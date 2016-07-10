package com.example.administrator.touch.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.administrator.touch.AppConstants;
import com.example.administrator.touch.R;
import com.example.administrator.touch.utils.SPUtil;

public class LaunchActivity extends Activity {
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (isFirstRun()) {
                Intent i=new Intent(LaunchActivity.this,IntroduceActivity.class);
                startActivity(i);
            }else {
                if (isHasToken()){
                    Intent i=new Intent(LaunchActivity.this,FrameAcitivity.class);
                }else{
                    Intent i=new Intent(LaunchActivity.this,MainActivity.class);
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Message message = mHandler.obtainMessage();
                mHandler.sendMessage(message);
            }
        }, 1500);

    }

    private boolean isFirstRun() {
        boolean isFirstRun = SPUtil.getInstance().getPrefBoolean(AppConstants.IS_FIRST_RUN, true);
        if (isFirstRun) {
            return true;
        } else {
            SPUtil.getInstance().putPrefBoolean(AppConstants.IS_FIRST_RUN, false);
            return false;
        }
    }
    private boolean isHasToken(){
        String isHasToken=SPUtil.getInstance().getPrefString(AppConstants.IS_HAS_TOKEN,null);
        if (isHasToken==null){
            return false;
        }else{
            return true;
        }
    }
}
