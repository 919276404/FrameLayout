package com.example.chengboying.demo.adapter;

import android.content.Context;
import android.os.StrictMode;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chengboying.demo.Contributor;
import com.example.chengboying.demo.GitHub;
import com.example.chengboying.demo.R;
import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by chengboying on 2017/2/9.
 */

public class NormalRecyclerViewAdapter extends RecyclerView.Adapter<NormalRecyclerViewAdapter.NormalTextViewHolder>{
    private final LayoutInflater mLayoutInflater;
//    private String[] mTitles;
    private int count=9;

    public NormalRecyclerViewAdapter(Context context) {
//        mTitles = context.getResources().getStringArray(R.array.my_image_view);
        mLayoutInflater = LayoutInflater.from(context);

    }

    @Override
    public NormalTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NormalTextViewHolder(mLayoutInflater.inflate(R.layout.item_text, parent, false));
    }

    @Override
    public void onBindViewHolder(NormalTextViewHolder holder, int position) {
        holder.setShow();
    }

    @Override
    public int getItemCount() {
        return  count;
    }

    public void changecount(boolean single){
        count=single?3:9;
        notifyDataSetChanged();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();

        GitHub gitHubService = retrofit.create(GitHub.class);
        Call<List<Contributor>> call = gitHubService.contributors("square", "retrofit");
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        try{
            Response<List<Contributor>> response = call.execute(); // 同步
            Log.d("hhh", "response:" + response.body().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // clone
        Call<List<Contributor>> call1 = call.clone();
// 5. 请求网络，异步

        call1.enqueue(new Callback<List<Contributor>>() {
            @Override
            public void onResponse(Response<List<Contributor>> response, Retrofit retrofit) {
                Log.e("HHH","response:" + response.body().toString());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    class NormalTextViewHolder extends RecyclerView.ViewHolder {
//        TextView mTextView;
//        SimpleDraweeView draweeView;
        NormalTextViewHolder(View view) {
            super(view);

//             draweeView = (SimpleDraweeView) view.findViewById(R.id.my_image_view);
//            mTextView=(TextView) view.findViewById(R.id.text_view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("NormalTextViewHolder", "onClick--> position = " + getPosition());
                }
            });
        }
        public void setShow() {
//            Uri uri = Uri.parse("http://images8.m.china.com.cn/mchina/img72/ueditor/20170208/84881486516229194_160_160.jpg");
//            draweeView.setImageURI(uri);
//            Call<List<Repo>> repos = service.listRepos("octocat");
        }

    }
}
