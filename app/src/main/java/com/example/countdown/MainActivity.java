package com.example.countdown;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/*
* 改倒计时适合用于获取验证码，请求等待，一段时间后可再次请求，每一次请求过程中无法请求，必须等本次请求结束....
* */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_djs)
    Button btnDjs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_djs)
    public void onViewClicked() {
        //new倒计时对象,总共的时间,每隔多少秒更新一次时间
        final MyCountDownTimer myCountDownTimer = new MyCountDownTimer(10000,1000);
        myCountDownTimer.start();
    }

    //复写倒计时
     class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        //计时过程
        @Override
        public void onTick(long l) {
            //防止计时过程中重复点击
            btnDjs.setClickable(false);
            btnDjs.setText(l / 1000 + "s");

        }

        //计时完毕的方法
        @Override
        public void onFinish() {
            //重新给Button设置文字
            btnDjs.setText("重新获取验证码");
            //设置可点击
            btnDjs.setClickable(true);
        }
    }


}
