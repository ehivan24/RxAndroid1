package com.ada.edwingsantos.rxandroid1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.*;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Observer;
import rx.Subscription;


public class MainActivity extends AppCompatActivity {

    Subscription mySubscription;
   // @BindView(R.id.btn_main)Button btnLambda;
   // @BindView(R.id.textView) TextView showUsers;

    TextView showUsers;

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
                //Log.d("mObserver","Completed");
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(String s) {
                //Log.d("mObserver ", s);
            }
        };


        mySubscription = mObservable.subscribe(mObserver);
        Button btnLambda = (Button) findViewById(R.id.btn_main);
        assert btnLambda != null;
        btnLambda.setOnClickListener((i)-> Toast.makeText(this, "Hello",  Toast.LENGTH_LONG).show());

        //runner.run(()-> Log.d("Single Line ","Java8"));


        showUsers = (TextView) findViewById(R.id.textView);

        doOperations();


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

    public void doOperations(){

        List<User> users = new  ArrayList<>();

        User user = new User(User.SEX.MALE, "Joe", "USA", 34, "joe@hotmail.com");
        users.add(user);
        user = new User(User.SEX.MALE, "Marcus", "Mexico", 41, "marcus12@yahoo.com");
        users.add(user);
        user = new User(User.SEX.FEMALE, "Loren", "France", 28, "loren_12@hotmail.com");
        users.add(user);
        user = new User(User.SEX.MALE, "Peter", "Belgium", 56, "pete34@gmail.com");
        users.add(user);
        user = new User(User.SEX.FEMALE, "Isabel", "USA", 23, "isabel@mail.com");
        users.add(user);
        user = new User(User.SEX.MALE, "Ali", "Germany", 78, "ali58@hotmail.com");
        users.add(user);
        user = new User(User.SEX.FEMALE, "Mary", "France", 45, "mary@yahoo.com");
        users.add(user);
        user = new User(User.SEX.FEMALE, "Patricia", "Germany", 31, "paty_34@gmail.com");
        users.add(user);

        List<User> newList = Stream.of(users)
                .filter(s -> s.getName().startsWith("M"))
                //.filter(s -> s.getGender() == User.SEX.MALE && s.getAge() < 35 )
                .collect(Collectors.toList());

                showUsers.setText(Arrays.toString(newList.toArray()).replaceAll("\\[|\\]", "").replaceAll(", ","\n"));

        Observable.just("Hello, world!")
                .subscribe(s -> System.out.println(s));
        //http://blog.danlew.net/2014/09/15/grokking-rxjava-part-1/


    }
}
