package com.eduwechat.backend.backend.service.v2.article;

import com.eduwechat.backend.backend.entity.v2.article.StudentArticle;
import com.eduwechat.backend.backend.entity.v2.article.inner.ArticleReply;
import com.eduwechat.backend.backend.exceptions.base.AuthException;
import com.eduwechat.backend.backend.exceptions.base.ThirdPartException;
import com.eduwechat.backend.backend.repository.v2.article.StudentArticleDao;
import com.eduwechat.backend.backend.service.v2.base.AuthService;
import com.eduwechat.backend.backend.utils.CommonUtil;
import com.eduwechat.backend.backend.utils.cos.COSUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentArticleService extends AuthService {

    @Resource
    private StudentArticleDao dao;

    /**
     * 上传作文图片
     * @param openid id
     * @param uid 创建者uid
     * @param fileInputStream 文件输入流
     * @param fileName 文件名
     * @throws AuthException 鉴权异常
     * @throws IOException IO异常
     */
    public void upload(String openid, Long uid, InputStream fileInputStream, String fileName) throws AuthException, ThirdPartException {
        if (!this.doAuth(openid, uid)) {
            throw new AuthException("用户未注册或openid、uid不正确。");
        }

        String fileType = CommonUtil.fromNameGetType(fileName);
        String key = CommonUtil.getUniqueId().substring(16) + "-" + CommonUtil.getNowTime() + "." + fileType;

        String _id = CommonUtil.getUniqueId();
        List<ArticleReply> replys = new ArrayList<>();
        String createtime = CommonUtil.getNowTime();

        // upload
        try {
            COSUtil.uploadWithInputStream(fileInputStream, key);
        } catch (IOException e) {
            throw new ThirdPartException("COS exception:" + e.getMessage());
        }

        dao.save(new StudentArticle(_id, uid, key, replys, createtime));
    }


}
