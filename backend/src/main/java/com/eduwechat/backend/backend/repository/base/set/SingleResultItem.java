package com.eduwechat.backend.backend.repository.base.set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class SingleResultItem {

    private String _id;

    /**
     * 得到简单字符串列表
     * @param originalList 原始mongodb返回实体
     * @return 简单的字符串列表
     */
    public static List<String> getSimpleStringList(List<SingleResultItem> originalList) {
        List<String> res = new ArrayList<>(originalList.size());

        for (SingleResultItem item : originalList) {
            res.add(item.get_id());

        }

        return res;
    }
}
