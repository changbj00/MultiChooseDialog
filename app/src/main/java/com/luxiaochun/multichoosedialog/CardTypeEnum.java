package com.luxiaochun.multichoosedialog;

import com.luxiaochun.multiselectiondialog.base.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: jun
 * Date: 2017-12-21 10:55
 */
public enum CardTypeEnum {
    OFFICER_CARD("1", "", "军官证"),
    SOLDIER_CARD("2", "", "士兵证"),
    SOLDIER_CARD1("21", "2", "士兵证1"),
    SOLDIER_CARD2("22", "2", "士兵证2"),
    SHENFEN_CARD("3", "", "身份证"),
    OTHER_CARD("9", "", "其他");


    private final String id;
    private final String pId;
    private final String name;

    CardTypeEnum(String id, String pId, String name) {
        this.id = id;
        this.pId = pId;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getpId() {
        return pId;
    }

    public String getName() {
        return name;
    }

    /**
     * 返回类型列表
     *
     * @return
     */
    public static List<Node> getDatas() {
        List<Node> mlist = new ArrayList<>();
        for (CardTypeEnum type : CardTypeEnum.values()) {
            mlist.add(new Node(type.getId(), type.getpId(), type.getName()));
        }
        return mlist;
    }
}