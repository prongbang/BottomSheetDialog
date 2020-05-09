package com.prongbang.bottomsheetdialog;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.Target;

/**
 * Created by prongbang on 3/19/2017.
 */

public class ImageUtil {

    private final static String TAG = ImageUtil.class.getSimpleName();

    public static int DEFAULT_IMAGE = R.mipmap.ic_launcher_round;

    public static void loadImageFromUrl(final Context context, final String url, final ImageView ivAvatar) {

        Glide.with(context).load(url).asBitmap().listener(new RequestListener<String, Bitmap>() {
            @Override
            public boolean onException(Exception e, String model, Target<Bitmap> target, boolean isFirstResource) {
                Log.e(TAG, "Load image from url ---> " + e.getMessage());
                return false;
            }

            @Override
            public boolean onResourceReady(Bitmap resource, String model, Target<Bitmap> target, boolean isFromMemoryCache, boolean isFirstResource) {
                // do show
                return false;
            }
        }).fitCenter().placeholder(DEFAULT_IMAGE).into(new BitmapImageViewTarget(ivAvatar) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                ivAvatar.setImageDrawable(circularBitmapDrawable);
            }
        });
    }

}
