package com.magicsoft.viewpagertransform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.magicsoft.viewpagertransform.activity.GalleryActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    public void goTo(Class clz){
        startActivity(new Intent(this,clz));
    }

    public void gallery(View view) {
        goTo(GalleryActivity.class);
    }
}
