package com.example.chengboying.demo.adapter;

import android.content.Context;
import android.net.Uri;
import android.os.StrictMode;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chengboying.demo.AdapterDataHelper;
import com.example.chengboying.demo.Contributor;
import com.example.chengboying.demo.GitHub;
import com.example.chengboying.demo.R;
import com.facebook.drawee.view.SimpleDraweeView;

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
    private List<String> mDatas;
    private Context mContext;
    private int count=9;

    public NormalRecyclerViewAdapter(Context context, List<String> datas) {
        mLayoutInflater = LayoutInflater.from(context);
        this. mContext=context;
        this. mDatas=datas;

    }

    @Override
    public NormalTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return new NormalTextViewHolder(mLayoutInflater.inflate(R.layout.item_text, parent, false));
        View view = mLayoutInflater.inflate(R.layout. item_text,parent, false);
        NormalTextViewHolder holder= new NormalTextViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(NormalTextViewHolder holder, int position) {
//        holder.setShow();
        holder.setName();
//        holder.textView.setText( mDatas.get(position));
        holder.textView.setText(AdapterDataHelper.getInstance().getData().get(position));
    }

    @Override
    public int getItemCount() {
//        return  AdapterDataHelper.getInstance().getData().size();
        return mDatas.size();
//        return  count;
    }

    public void changecount(boolean single){
        count=single?3:9;
        notifyDataSetChanged();


    }

    class NormalTextViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView draweeView;
        TextView textView;
        NormalTextViewHolder(View view) {
            super(view);

//             draweeView = (SimpleDraweeView) view.findViewById(R.id.my_image_view);
             textView = (TextView) view.findViewById(R.id.name);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("NormalTextViewHolder", "onClick--> position = " + getPosition());
                }
            });
        }
        public void setShow() {
            Uri uri = Uri.parse("http://images8.m.china.com.cn/mchina/img72/ueditor/20170208/84881486516229194_160_160.jpg");
            draweeView.setImageURI(uri);
        }

        public void setName() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            GitHub service = retrofit.create(GitHub.class);
            Call<List<Contributor>> call = service.listRepos("octocat");

            if (android.os.Build.VERSION.SDK_INT > 9) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            try{
                Response<List<Contributor>> response = call.execute(); // 同步

                AdapterDataHelper.getInstance().setData(response.body());


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
                    AdapterDataHelper.getInstance().setData(response.body());
                    Log.e("HHH","response:" + response.body().toString());
                }

                @Override
                public void onFailure(Throwable t) {

                }
            });
        }

    }
}
