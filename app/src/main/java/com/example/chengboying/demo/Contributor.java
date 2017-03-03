package com.example.chengboying.demo;


/**
 * Created by chengboying on 2017/3/3.
 */

public  class Contributor {
    public final String name;
    public final int id;
    public Contributor(String login, int contributions) {
        this.name = login;
        this.id = contributions;
    }
    @Override
    public String toString() {
        return "Contributor{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
