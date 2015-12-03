package com.example.leo.photogallery;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;

/**
 * Created by leo on 15-12-2.
 */
public class PhotoGalleryFragment extends Fragment {
    private static final String TAG = "PhotoGalleryFragment";
    GridView mGridView;
    ArrayList<GalleryItem> mItems;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        new FetchItemsTask().execute();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_photo_gallery,container,false);
        mGridView = (GridView)v.findViewById(R.id.gridView);
        setupAdapter();
        return v;
    }

    void setupAdapter(){
        if(getActivity() == null || mGridView == null){
            return;
        }
        if (mItems !=null){
            mGridView.setAdapter(new ArrayAdapter<GalleryItem>(getActivity(), android.R.layout.simple_gallery_item,mItems));
        }else{
            mGridView.setAdapter(null);
        }
    }


    /**
     * 后台获取flickr数据
     */
    private class FetchItemsTask extends AsyncTask<Void,Void,ArrayList<GalleryItem>>{
        @Override
        protected ArrayList<GalleryItem> doInBackground(Void... params) {
            return new FlickrFetchr().fetchItems();
        }

        @Override
        protected void onPostExecute(ArrayList<GalleryItem> galleryItems) {
            //在此方法更新 ui 更安全,避免在后台线程中更新UI
            mItems = galleryItems;
            setupAdapter();
        }
    }
}
