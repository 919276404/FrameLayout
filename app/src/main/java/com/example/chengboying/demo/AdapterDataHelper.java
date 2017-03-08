package com.example.chengboying.demo;

/**
 * Created by chengboying on 2017/3/7.
 */
import java.util.ArrayList;
import java.util.List;

public class AdapterDataHelper {
    public static AdapterDataHelper mInstance;
    public static AdapterDataHelper getInstance() {
        if (mInstance == null) {
            synchronized (AdapterDataHelper.class) {
                if (mInstance == null) {
                    mInstance = new AdapterDataHelper();
                }

            }
        }
        return mInstance;
    }
    private AdapterDataHelper() {}


    private List<String> dataList = new ArrayList<>();

    public void setData(List<Contributor> list) {
        dataList = transLate(list);
    }

    public List<String> getData() {
        return dataList;
    }



    private List<String> transLate(List<Contributor> list) {
        if (list == null || list.size()== 0) {
            return null;
        }
        List<String> dataList = new ArrayList<>();
        for(Contributor contributor : list) {
            if (contributor != null) {
                String name = contributor.getName();
                dataList.add(name);
            }
        }
        return dataList;
    }
}
