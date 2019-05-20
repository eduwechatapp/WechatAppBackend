package com.eduwechat.backend.backend.service.common;

import com.eduwechat.backend.backend.entity.base.BaseCommonEntity;
import com.eduwechat.backend.backend.exceptions.common.TypeNotMatchException;
import com.eduwechat.backend.backend.repository.common.HighSchoolGeographyRepository;
import com.eduwechat.backend.backend.service.base.CommonService;
import com.eduwechat.backend.backend.service.base.inner.common.Content;
import com.eduwechat.backend.backend.service.base.inner.common.TitleListMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HighSchoolGeographyService extends CommonService {

    @Autowired
    private HighSchoolGeographyRepository repository;

    /**
     * 获取知识点章节映射
     * @param which Integer
     * @return String
     */
    private static String fromWhichGetKnowledgeErji(Integer which) {

        switch (which) {
            case 0:
                return "第1讲《地球》";
            case 1:
                return "第2讲《地图》";
            case 2:
                return "第3讲《地球上的大气》";
            case 3:
                return "第4讲《地球上的水》";
            case 4:
                return "第5讲《地表形态的塑造》";
            case 5:
                return "第6讲《自然环境的整体性和差异性》";
            case 6:
                return "第7讲《关于季节的知识专题》";
            case 7:
                return "第8讲《自然资源与自然灾害》";
            case 8:
                return "第9讲《农业》";
            case 9:
                return "第10讲《工业》";
            case 10:
                return "第11讲《交通》";
            case 11:
                return "第12讲《人口》";
            case 12:
                return "第13讲《城市》";
            case 13:
                return "第14讲《人类与地理环境的协调发展》";
            case 14:
                return "第15讲《区域治理与可持续发展》";
            case 15:
                return "第16讲《地理信息技术的应用》";
        }
        return null;
    }

    /**
     * 获取专题映射
     * @param which Integer
     * @return String
     */
    private static String fromWhichGetTopicErji(Integer which) {

        switch (which) {
            case 0:
                return "地理计算专题";
            case 1:
                return "地质地形专题";
            case 2:
                return "能源专题";
            case 3:
                return "气候与自然带专题";
            case 4:
                return "干旱专题";
            case 5:
                return "洪涝专题";
            case 6:
                return "河流专题";
            case 7:
                return "海洋专题";
            case 8:
                return "农业专题";
            case 9:
                return "工业专题";
            case 10:
                return "旅游专题";
            case 11:
                return "人口专题";
            case 12:
                return "城市专题";
            case 13:
                return "交通专题";
            case 14:
                return "生态环境问题专题";
            case 15:
                return "重要地理界线专题";
            case 16:
                return "特征问题答题方法";
            case 17:
                return "等高线地形图专题";
            case 18:
                return "海洋资源专题";
            case 19:
                return "盐度和洋流专题";
            case 20:
                return "河流及交通专题";
            case 21:
                return "人口数量、分布专题";
            case 22:
                return "人口迁移专题";
            case 23:
                return "兰州问题";
            case 24:
                return "文化专题";
            case 25:
                return "黄山与庐山旅游问题";
            case 26:
                return "政治经济地理格局专题";
            case 27:
                return "港口的建设：上海、纽约、天津等";
            case 28:
                return "三峡工程专题";
            case 29:
                return "商业贸易与金融专题";
            case 30:
                return "第7讲《关于季节的知识专题》";
        }
        return null;
    }

    /**
     * 获取答题模板映射
     * @param which Integer
     * @return String
     */
    private static String fromWhichGetTemplateErji(Integer which) {

        switch (which) {
            case 0:
                return "自然地理部分大题答题模板";
            case 1:
                return "社会人文地理部分大题答题模板";
            case 2:
                return "区位选择类问题大题答题模板";
            case 3:
                return "原因分析类问题大题答题模板";
            case 4:
                return "意义影响类问题大题答题模板";
            case 5:
                return "价值作用类问题大题答题模板";
            case 6:
                return "方法措施类问题大题答题模板";
        }
        return null;
    }

    /**
     * 获取归纳总结映射
     * @param which Integer
     * @return String
     */
    private static String fromWhichGetSummaryErji(Integer which) {

        switch (which) {
            case 0:
                return "世界区域地理";
            case 1:
                return "中国自然地理";
            case 2:
                return "中国人文地理";
            case 3:
                return "中国农业地理的综合分析";
            case 4:
                return "中国区域地理与区域差异";
            case 5:
                return "中国国土整治与开发";
        }
        return null;
    }

    /**
     * 分页获取知识点
     * @param which 指定教材
     * @param size 每页数据组数
     * @param page 页数偏移量从0开始
     * @return List
     */
    @Override
    public List<Content> getKnowledge(Integer which, Integer size, Integer page) {
        Page<BaseCommonEntity> pages = repository.findByErji(fromWhichGetKnowledgeErji(which), PageRequest.of(page, size));
        return this.fromPageGetList(pages);
    }

    /**
     * 分页获取归纳总结
     * @param which 指定内容
     * @param size 每页数据组数
     * @param page 页数偏移量从0开始
     * @return List
     */
    public List<Content> getSummary(Integer which, Integer size, Integer page) {
        Page<BaseCommonEntity> pages = repository.findByErji(fromWhichGetSummaryErji(which), PageRequest.of(page, size));
        return this.fromPageGetList(pages);
    }

    /**
     * 分页获取专题
     * @param which 指定专题
     * @param size 每页数据组数
     * @param page 页数偏移量从0开始
     * @return List
     */
    public List<Content> getTopic(Integer which, Integer size, Integer page) {
        Page<BaseCommonEntity> pages = repository.findByErji(fromWhichGetTopicErji(which), PageRequest.of(page, size));
        return this.fromPageGetList(pages);
    }

    /**
     * 分页获取答题模板
     * @param which 指定内容
     * @param size 每页数据组数
     * @param page 页数偏移量从0开始
     * @return List
     */
    public List<Content> getTemplate(Integer which, Integer size, Integer page) {
        Page<BaseCommonEntity> pages = repository.findByErji(fromWhichGetTemplateErji(which), PageRequest.of(page, size));
        return this.fromPageGetList(pages);
    }

    /**
     * 通用获取二级标题列表接口
     * @param yijiString String 数据库中一级标题字段名称
     * @param yijiType String 一级类型 knowledge topic summary template
     * @param subjectType String 学科类型 zz hx yy yw sx ls dl sw wl
     * @throws TypeNotMatchException 一级类型或学科类型未匹配
     * @return List&lt;TitleListMapping&gt; 映射后标题列表
     */
    @Override
    public List<TitleListMapping> getTitleList(String yijiString, String yijiType, String subjectType) throws TypeNotMatchException {
        return this.innerGetTitleList(repository.findByTitleList(yijiString), yijiType, subjectType);
    }


}
