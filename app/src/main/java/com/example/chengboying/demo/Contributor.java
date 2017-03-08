package com.example.chengboying.demo;


/**
 * Created by chengboying on 2017/3/3.
 */

public  class Contributor {
    public String name;
    public final int id;
    public Contributor(String name, int id) {
        this.name = name;
        this.id = id;
    }
    @Override
    public String toString() {
        return "Contributor{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
