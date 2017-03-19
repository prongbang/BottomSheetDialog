package com.prongbang.bottomsheetdialog.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.prongbang.bottomsheetdialog.R;
import com.prongbang.bottomsheetdialog.widget.MyBottomSheetDialog;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private TextView tvClickMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvClickMe = (TextView) findViewById(R.id.tvClickMe);
        tvClickMe.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvClickMe:

                MyBottomSheetDialog myBottomSheetDialog = MyBottomSheetDialog.getInstance(this);
                myBottomSheetDialog.setTvTitle("Bottom Sheet Dialog");
                myBottomSheetDialog.setTvSubTitle("Read more...");
                myBottomSheetDialog.setIvAvatar("https://avatars3.githubusercontent.com/u/6635954?v=3&u=d18aab686938ecda4b96f29e4e3b776008ced91f&s=400");
                myBottomSheetDialog.setCanceledOnTouchOutside(false);
                myBottomSheetDialog.show();

                break;
        }
    }
}
