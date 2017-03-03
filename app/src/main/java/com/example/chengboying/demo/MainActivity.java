package com.example.chengboying.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.chengboying.demo.adapter.NormalRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    private  boolean isSingleline=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setShow();
        mRecyclerView=(RecyclerView) findViewById(R.id.recycler_view);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));//这里用线性显示 类似于listview
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));//这里用线性宫格显示 类似于grid view
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));//这里用线性宫格显示 类似于瀑布流
        mRecyclerView.setAdapter(new NormalRecyclerViewAdapter(this));
        findViewById(R.id.change_bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSingleline=!isSingleline;
                ((NormalRecyclerViewAdapter)mRecyclerView.getAdapter()).changecount(isSingleline);
            }
        });
    }

//    private Callback<retrofitResult> callback = new Callback<retrofitResult>() {
//        @Override
//        public void onResponse(Call<retrofitResult> call, Response<retrofitResult> response) {
//            if (response.isSuccessful()){
////                Log.i(TAG, "success!!!");
////                Log.e(tag,"success!!!");
////                Log.i(TAG, "---" + response.body().toString());
//            } else {
////                Log.e(TAG, "+++" + response.message());
//            }
//        }
//
//        @Override
//        public void onFailure(Call<retrofitResult> call, Throwable t) {
////            Log.e(TAG, "***" + t.getMessage());
//        }
//    };

//    private void createSingle(){
//        Call<retrofitResult> repos = service.listRepos(
//                commitParam.getMessage());
//        repos.enqueue(callback);
//    }

//    public void setShow() {
////            Uri uri = Uri.parse("http://images8.m.china.com.cn/mchina/img72/ueditor/20170208/84881486516229194_160_160.jpg");
////            draweeView.setImageURI(uri);
//        Call<retrofitResult> repos = service.listRepos("octocat");
//        repos.enqueue(callback);
//    }

}
