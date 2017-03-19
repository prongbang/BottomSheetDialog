package com.prongbang.bottomsheetdialog.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.prongbang.bottomsheetdialog.R;
import com.prongbang.bottomsheetdialog.utils.ImageUtil;

/**
 * Created by prongbang on 3/19/2017.
 */

public class MyBottomSheetDialog extends BottomSheetDialog implements View.OnClickListener {

    private ImageView ivAvatar;
    private ImageView ivClose;
    private TextView tvTitle;
    private TextView tvSubTitle;
    private Context context;

    @SuppressLint("StaticFieldLeak")
    private static MyBottomSheetDialog instance;

    public static MyBottomSheetDialog getInstance(@NonNull Context context) {
        return instance == null ? new MyBottomSheetDialog(context) : instance;
    }

    public MyBottomSheetDialog(@NonNull Context context) {
        super(context);
        this.context = context;
        create();
    }

    public void create() {
        View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_layout, null);
        setContentView(bottomSheetView);
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from((View) bottomSheetView.getParent());
        BottomSheetBehavior.BottomSheetCallback bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                // do something
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                // do something
            }
        };

        ivAvatar = (ImageView) bottomSheetView.findViewById(R.id.ivAvatar);
        ivClose = (ImageView) bottomSheetView.findViewById(R.id.ivClose);
        tvTitle = (TextView) bottomSheetView.findViewById(R.id.tvTitle);
        tvSubTitle = (TextView) bottomSheetView.findViewById(R.id.tvSubTitle);

        ivAvatar.setOnClickListener(this);
        ivClose.setOnClickListener(this);
        tvTitle.setOnClickListener(this);

    }

    public void setIvAvatar(String url) {
        ImageUtil.loadImageFromUrl(context, url, ivAvatar);
    }

    public void setTvTitle(String tvTitle) {
        this.tvTitle.setText(tvTitle);
    }

    public void setTvSubTitle(String tvSubTitle) {
        this.tvSubTitle.setText(tvSubTitle);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvTitle:
//                hide();
                break;
            case R.id.ivClose:
                hide();
                break;
            case R.id.ivAvatar:
//                hide();
                break;
        }
    }
}
