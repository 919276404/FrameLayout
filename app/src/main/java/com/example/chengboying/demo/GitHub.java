package com.example.chengboying.demo;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

public interface GitHub {
    @GET("users/{user}/repos")
    Call<List<Contributor>> listRepos(@Path("user") String user);
}

