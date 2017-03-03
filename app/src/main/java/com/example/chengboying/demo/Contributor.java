package com.example.chengboying.demo;


/**
 * Created by chengboying on 2017/3/3.
 */

public  class Contributor {
    public final String login;
    public final int contributions;
    public Contributor(String login, int contributions) {
        this.login = login;
        this.contributions = contributions;
    }
    @Override
    public String toString() {
        return "Contributor{" +
                "login='" + login + '\'' +
                ", contributions=" + contributions +
                '}';
    }
}
