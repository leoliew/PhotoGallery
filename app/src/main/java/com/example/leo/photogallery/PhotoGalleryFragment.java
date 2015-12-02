package com.example.leo.photogallery;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.io.IOException;

/**
 * Created by leo on 15-12-2.
 */
public class PhotoGalleryFragment extends Fragment {
    private static final String TAG = "PhotoGalleryFragment";
    GridView mGridView;

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
        return v;
    }


    private class FetchItemsTask extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void... params) {
//            try{
//                String result = new FlickrFetchr().getUrl("http://www.baidu.com");
//                Log.i(TAG,"Fetched contents of URL: "+ result);
//            }catch (IOException e){
//                Log.e(TAG,"Failed to fetch URL ",e);
//            }
            new FlickrFetchr().fetchItems();
            return null;
        }
    }
}
