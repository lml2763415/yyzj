package com.lml.yyzj.ui.home.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lml.yyzj.R;
import com.lml.yyzj.bean.db.User;
import com.lml.yyzj.view.RotateLoading;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.observers.SafeSubscriber;

/**
 * Created by liml on 17/3/8.
 */

public class Applet extends Activity implements View.OnClickListener{
    String TAG = null;
    @Bind(R.id.image)
    ImageView image;
    @Bind(R.id.id)
    EditText id;
    @Bind(R.id.name)
    EditText name;
    @Bind(R.id.insert)
    Button insert;
    @Bind(R.id.query)
    Button query;
    @Bind(R.id.panel)
    TextView panel;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.applet);
        ButterKnife.bind(this);
        TAG = "lml" + getLocalClassName() + "-----";
        Log.d(TAG, "onCreate");
        initRealm();
        insert.setOnClickListener(this);
        query.setOnClickListener(this);
    }


    private void initRealm() {
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("yyzj.realm") //文件名
                .schemaVersion(0) //版本号
                .build();
        realm = Realm.getInstance(config);
    }

    public void tv(View v) {

//        Tools.startActivity(this,Applet.class);
        RotateLoading loading = new RotateLoading(this);
        loading.show();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.insert:
                String id = this.id.getText().toString();
                String name = this.name.getText().toString();
                final User user = new User();
                user.setId(Integer.parseInt(id));
                user.setName(name);
                realm.executeTransactionAsync(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.copyToRealmOrUpdate(user);

                    }
                });

                break;
            case R.id.query:
                realm.executeTransactionAsync(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        final RealmResults<User> results = realm.where(User.class).findAll();
                        if (results.isLoaded()){
//                            Log.d(TAG,results.toString());
                            ObserUi(results.toString());
                        }
                    }
                });
                break;
        }
    }
    void ObserUi(final String string){
        Observable.just(string).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        panel.setText(string);
                    }
                });
    }



}

