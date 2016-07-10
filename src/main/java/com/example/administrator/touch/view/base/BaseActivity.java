package com.example.administrator.touch.view.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.touch.R;
import com.example.administrator.touch.TouchApplication;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;


/**
 * Created by Administrator on 10/07/2016.
 */
public abstract class BaseActivity extends Activity implements SurfaceStandard{
    private Context mcontext;
    public LinearLayout linear_layout;
    public TextView text_left;
    public TextView text_center;
    public TextView text_right;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayout());
        TouchApplication.getInstance().addActivity(this);
        ButterKnife.bind(this);
        mcontext=this;
        initView();
        initData();
        initControl();
        initAdapter();
    }
    public abstract int getLayout();
    public abstract String setTitleName();
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault() != null) {
            EventBus.getDefault().unregister(this);
        }
        ButterKnife.unbind(this);
    }

    @Override
    public void initView() {
        linear_layout = (LinearLayout) findViewById(R.id.linear_left);
        text_left = (TextView) findViewById(R.id.text_left);
        text_center = (TextView) findViewById(R.id.text_center);
        text_right = (TextView) findViewById(R.id.text_right);
    }

    @Override
    public void initData() {
        EventBus.getDefault().register(this);
    }

    @Override
    public void initControl() {
        text_center.setText(setTitleName());
    }

    @Override
    public void initAdapter() {

    }

    @Override
    public void refreshData() {

    }
}
