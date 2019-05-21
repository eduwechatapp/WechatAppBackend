package com.eduwechat.backend.backend.utils;

import com.eduwechat.backend.backend.exceptions.exercise.SubjectDoesNotSupportedException;
import com.eduwechat.backend.backend.service.base.inner.exercise.ExerciseTitleResultItem;

public class CommonUtil {

    /**
     * 中文学科名返回表名
     * @param subject 学科中文名
     * @return 表名
     * @throws SubjectDoesNotSupportedException 学科未找到异常
     */
    public static String fromSubjectGetExerciseTableName(String subject) throws SubjectDoesNotSupportedException {
        switch (subject) {
            case "语文":
                return "chinese_lib";
            case "数学":
                return "math_lib";
            case "英语":
                return "english_lib";
            case "物理":
                return "physics_lib";
            case "化学":
                return "chemistry_lib";
            case "生物":
                return "biology_lib";
            case "地理":
                return "geography_lib";
            case "历史":
                return "history_lib";
            case "政治":
                return "politics_lib";
            default:
                throw new SubjectDoesNotSupportedException(subject);
        }
    }

    /**
     * 从简写学科返回真正学科
     * @param simple 简写学科
     * @return 真正学科
     */
    public static String fromSimpleStrGetChinese(String simple) {

        switch (simple) {

            case "sx":
                return "数学";
            case "yw":
                return "语文";
            case "yy":
                return "英语";
            case "wl":
                return "物理";
            case "hx":
                return "化学";
            case "sw":
                return "生物";
            case "dl":
                return "地理";
            case "ls":
                return "历史";
            case "zz":
                return "政治";
            default:
                return "";
        }

    }

    /**
     * 首页html
     */
    public static final String indexFileContent = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "\t<title>Welcome</title>\n" +
            "\t<link href=\"https://staff.bootcss.com/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
            "\n" +
            "\t<style type=\"text/css\">\n" +
            "\t\t.jumbotron {\n" +
            "    \t\ttext-align: center;\n" +
            "\t\t}\n" +
            "\t</style>\n" +
            "</head>\n" +
            "<body>\n" +
            "\t<div class=\"container\">\n" +
            "\t\t<div class=\"jumbotron\">\n" +
            "\t\t\t<div class=\"container\">\n" +
            "\t\t\t\t<h1>New World of High School Education</h1>\n" +
            "\t\t\t\t<p>This is our WechatApp gateway entry.</p>\n" +
            "\t\t\t\t<p><a class=\"btn btn-success btn-lg\" href=\"//vaskka.com/mp/swagger-ui.html\" role=\"button\">swagger&nbsp;doc</a></p>\n" +
            "\t\t\t</div>\n" +
            "\n" +
            "\t\t</div>\n" +
            "\t</div>\n" +
            "\t<script src=\"https://staff.bootcss.com/npm/jquery@1.12.4/dist/jquery.min.js\"></script>\n" +
            "\t<script src=\"https://staff.bootcss.com/npm/handlebars@3.0.3/dist/handlebars.min.js\"></script>\n" +
            "\n" +
            "</body>\n" +
            "</html>";
}
