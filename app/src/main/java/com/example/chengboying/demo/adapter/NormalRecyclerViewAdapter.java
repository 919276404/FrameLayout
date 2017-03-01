package com.example.chengboying.demo.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chengboying.demo.R;
import com.facebook.drawee.view.SimpleDraweeView;

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
    }

    class NormalTextViewHolder extends RecyclerView.ViewHolder {
//        TextView mTextView;
        SimpleDraweeView draweeView;
        NormalTextViewHolder(View view) {
            super(view);
             draweeView = (SimpleDraweeView) view.findViewById(R.id.my_image_view);
//            mTextView=(TextView) view.findViewById(R.id.text_view);
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

    }
}
