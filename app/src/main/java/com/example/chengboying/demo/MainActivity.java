package com.example.chengboying.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.chengboying.demo.adapter.NormalRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    private List<String> mDatas;
    NormalRecyclerViewAdapter recycleAdapter;
    private  boolean isSingleline=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=(RecyclerView) findViewById(R.id.recycler_view);
        initData();
        recycleAdapter= new NormalRecyclerViewAdapter(MainActivity.this , mDatas );
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(layoutManager);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));//这里用线性显示 类似于listview
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));//这里用线性宫格显示 类似于grid view
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));//这里用线性宫格显示 类似于瀑布流
        mRecyclerView.setAdapter(new NormalRecyclerViewAdapter(MainActivity.this,mDatas));
        findViewById(R.id.change_bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSingleline=!isSingleline;
                ((NormalRecyclerViewAdapter)mRecyclerView.getAdapter()).changecount(isSingleline);
            }
        });
    }


    public void initData(){
        mDatas = new ArrayList<String>();

            mDatas.add( "item"+AdapterDataHelper.mInstance);



    }
}
