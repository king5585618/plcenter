package com.kakarot.plcenter.enumList;

/**
 * @author jinzj
 * @since v4.0.1
 */
public enum A {

    up(1,"上");

    A(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    private Integer id ;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
