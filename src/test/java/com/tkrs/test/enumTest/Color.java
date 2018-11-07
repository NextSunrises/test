package com.tkrs.test.enumTest;

/**
 * @ClassName Color
 * @Description TODO
 * @Author wangchenge
 * @Date 2018/10/22  15:10
 * @Version 1.0
 **/
public enum Color {
    GREEN,BLUE,YELLOW,BLACK,WHITE, RED("红色", 1),;
    // 构造方法
    private Color(String name, int index) {
        this.name = name;
        this.index = index;
    }
    private Color() {}

    // 成员变量
    private String name;
    private int index;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

