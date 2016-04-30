package com.ada.edwingsantos.rxandroid1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;
import java.util.*;

import butterknife.ButterKnife;
import rx.Observable;
import rx.Observer;
import rx.Subscription;


public class MainActivity extends AppCompatActivity {

    Subscription mySubscription;
   // @BindView(R.id.btn_main)Button btnLambda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        /**
         * initiate the Class for lambdas
         */

        RunnerNew runner = new RunnerNew();

        Observable<String> mObservable = Observable.just("hello");

        Observer<String> mObserver = new Observer<String>() {


            @Override
            public void onCompleted() {
                Log.d("mObserver","Completed");
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(String s) {
                Log.d("mObserver ", s);
            }
        };


        mySubscription = mObservable.subscribe(mObserver);
        Button btnLambda = (Button) findViewById(R.id.btn_main);
        assert btnLambda != null;
        btnLambda.setOnClickListener((i)-> Toast.makeText(this, "Hello",  Toast.LENGTH_LONG).show());

        runner.run(()-> Log.d("Single Line ","Java8"));





    }

    @Override
    protected void onPause() {
        super.onPause();
        mySubscription.unsubscribe();
        Log.d("mObserver ", "unsubscribe");

        // https://www.youtube.com/watch?v=vfjgQabgjOg  9:34

        //http://code.tutsplus.com/tutorials/getting-started-with-reactivex-on-android--cms-24387
        //http://www.andreamaglie.com/rxjava-android-where-to-start/

        //https://www.youtube.com/watch?v=Gsfmfeb2XW8

        //https://www.parleys.com/search/android/PRESENTATIONS
    }

}
