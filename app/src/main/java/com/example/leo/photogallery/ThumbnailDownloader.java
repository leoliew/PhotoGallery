package com.example.leo.photogallery;

import android.os.HandlerThread;

/**
 * Created by Leo on 15/12/8.
 */
public class ThumbnailDownloader <Token> extends HandlerThread {
    private static final String TAG = "ThumbnailDownloader";

    public ThumbnailDownloader(){
        super(TAG);
    }

    

}
