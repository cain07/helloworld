package com.rxjava.cain.cainrxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    private TextView tvHello;
    private Button btnTest1;

    private Observable<String> observable;

    private Subscriber<String> subscriber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHello = (TextView) findViewById(R.id.tv_hello);
        btnTest1 = (Button) findViewById(R.id.btn_test1);

        createSubscriberByAction();

        btnTest1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test1:
                Log.e(TAG, "onClick");
                //createObservable();
                createObservableByMap();
                break;
        }
    }

    private void createSubscriber() {
        subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.e(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(String s) {
                Log.e(TAG, "onNext----"+s);
                tvHello.setText(s);
            }
        };


    }

    private Action1<String> onNextAction;

    private void createSubscriberByAction() {
        onNextAction = new Action1<String>() {


            @Override
            public void call(String s) {
                tvHello.setText(s);
            }
        };
    }

    private void createObservableByMap() {
        Observable.just(getHello()).map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return s+ "by cain";
            }
        });
    }

    private void bindSubscriber() {
        observable.subscribe(onNextAction);
        //observable.subscribe(subscriber);
    }

    private void createObservable() {
       /* observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext(getHello());
                subscriber.onCompleted();
            }
        });*/

        /**
         * 顺次执行
         */
        observable = Observable.just(getHello(),"111","2222");

        bindSubscriber();
    }

    private String getHello() {
        return "Hello RxAndroid";
    }

}
