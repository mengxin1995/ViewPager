package com.magicsoft.viewpagertransform.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.magicsoft.viewpagertransform.R;
import com.magicsoft.viewpagertransform.adapter.VpAdapter;
import com.magicsoft.viewpagertransform.transform.effect.DepthPageTransformer;
import com.magicsoft.viewpagertransform.transform.effect.MyTransformer1;
import com.magicsoft.viewpagertransform.transform.effect.ZoomOutPageTransformer;

import java.util.ArrayList;

/**
 * Created by 刘少帅 on 2017/11/8
 */

public class VpActivity extends AppCompatActivity {

    private ViewPager mVp;
    private int [] mImg=new int[]{R.mipmap.sea,R.mipmap.sunset,R.mipmap.sea,R.mipmap.lotus,R.mipmap.red};
    private ArrayList<ImageView> mImgList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp);
        mVp = (ViewPager) findViewById(R.id.vp_vp_vp);
        mImgList = new ArrayList<>();
        for (int i = 0; i < mImg.length; i++) {

            ImageView imageView = new ImageView(this);
            imageView.setImageResource(mImg[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mImgList.add(imageView);
        }
        VpAdapter adapter = new VpAdapter(mImgList);
        mVp.setAdapter(adapter);
        //默认无切换动画

    }


    public void oneListener(View view) {//
        mVp.setPageTransformer(true,new DepthPageTransformer());
    }


    public void twoListener(View view) {
        mVp.setPageTransformer(true,new ZoomOutPageTransformer());
    }

    public void threeListener(View view) {
        mVp.setPageTransformer(true,new MyTransformer1());
    }
}
