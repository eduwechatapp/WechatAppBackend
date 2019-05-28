package com.eduwechat.backend.backend.service.saveInfo;

import com.eduwechat.backend.backend.repository.UserClickInfoRepository;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by H on 2019/5/27.
 */
@Service
public class UserClickInfoService {
    @Resource
    public UserClickInfoRepository repository;

    private String getStringByType(int type){
        switch (type){
            case 1: return "需要留意";
            case 2: return "重点关注";
            default:return "默认";
        }
    }

    public void insertInfo(String OpenId, int type, String content){
        System.out.println("exe here");
        repository.insertInfo(OpenId,type,content);}

    public List<Object> getInfoByOpenId(String OpenId) throws JSONException {
        Integer TypeTemp;
        String ContentTemp;
        List<Integer> InfoTypeList=repository.getInfoTypeByOpenId(OpenId);
        List<String> InfoContentList = repository.getInfoContentByOpenId(OpenId);
        List<Object> result= new ArrayList<>();
        Iterator itType = InfoTypeList.iterator();
        Iterator itContent = InfoContentList.iterator();
        while(itType.hasNext()){
            Map<String ,String> elem = new HashMap<>();
            elem.put("type",getStringByType((Integer) itType.next()));
            elem.put("content",(String)itContent.next());
            result.add(elem);
        }
        return result;
    }
}
