package com.eduwechat.backend.backend.service.user;

import com.eduwechat.backend.backend.repository.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by H on 2019/5/22.
 */
@Service
public class UserService {
    @Resource
    private UserRepository repository;

    public JSONObject GetSessionOpenID(String code) throws IOException, JSONException {
        OutputStreamWriter out = null;
        StringBuffer buffer = new StringBuffer();

        String APPID = "wx34f69a4b4a8c4829";
        String SECRET = "db74c007e991c0d29a0719a440710bb7\n";
        String USER_AGENT = "Mozilla/5.0";


        String url = "https://api.weixin.qq.com/sns/jscode2session";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setDoOutput(true);
        con.setDoInput(true);
        con.setUseCaches(false);

        con.setRequestMethod("GET");
        con.setRequestProperty("content-type", "application/x-www-form-urlencoded");

        out = new OutputStreamWriter(con.getOutputStream(),"UTF-8");
        out.write("appid="+APPID+"&secret="+SECRET+"&js_code="+code+"&grant_type=authorization_code"); //参数形式跟在地址栏的一样
        out.flush();
        out.close();

        InputStream inputStream = con.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
        }
        bufferedReader.close();
        inputStreamReader.close();

        inputStream.close();
        con.disconnect();
        JSONObject json = new JSONObject(buffer.toString());
        return json;
    }

    public void UpdateSkey(String OpenID, String Skey){
        if(repository.findUserByOpenID(OpenID).isEmpty()){
            insertOpenIDAndSkey(OpenID, Skey);
        }
        else{
            setSkeyByOpenID(OpenID, Skey);
        }
    }

    public void setSkeyByOpenID(String openID, String Skey){
        repository.updateSkeyByOpenID(openID, Skey);
    }
    public void insertOpenIDAndSkey(String OpenID, String Skey){repository.insertOpenIDAndSkey(OpenID,Skey);}
    public String EncodeSessionKey(String SessionKey){
        return DigestUtils.sha1Hex(SessionKey);
    }

}
