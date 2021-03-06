package com.example.foot_panel;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foot_panel.databinding.ActivityKeyboardBinding;
import com.sd.lib.foot_panel.ext.FKeyboardListener;

/**
 * 软键盘监听
 */
public class KeyboardActivity extends AppCompatActivity
{
    private static final String TAG = KeyboardActivity.class.getSimpleName();
    private ActivityKeyboardBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mBinding = ActivityKeyboardBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        /**
         * 由于{@link FKeyboardListener}内部采用弱引用保存回调对象，所以这边回调对象要强引用
         */
        FKeyboardListener.of(this).addCallback(mCallback);

        Log.i(TAG, "getCachedKeyboardVisibleHeight:" + FKeyboardListener.getCachedKeyboardVisibleHeight());
    }

    private final FKeyboardListener.Callback mCallback = new FKeyboardListener.Callback()
    {
        @Override
        public void onKeyboardHeightChanged(int height, FKeyboardListener listener)
        {
            Log.i(TAG, "onKeyboardHeightChanged height:" + height + " visibleHeight:" + listener.getKeyboardVisibleHeight());
        }
    };
}