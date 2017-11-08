package com.magicsoft.viewpagertransform.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.magicsoft.viewpagertransform.R;
import com.magicsoft.viewpagertransform.transform.GallyPageTransformer;

import java.util.ArrayList;

/**
 * Created by 刘少帅 on 2017/11/8
 */

public class GalleryActivity extends AppCompatActivity {

    private ViewPager mVp;
    private int [] mImg=new int[]{R.mipmap.sea,R.mipmap.sunset,R.mipmap.sea,R.mipmap.lotus,R.mipmap.red};
    private ArrayList<Integer> mImgList;
    private LayoutInflater mLayoutInflater;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        mLayoutInflater = LayoutInflater.from(this);
        mVp = (ViewPager) findViewById(R.id.vp_gallery_vp);
        mImgList = new ArrayList<>();
        for (int i = 0; i < mImg.length; i++) {
            mImgList.add(mImg[i]);
        }

        mVp.setAdapter(new MyAdapter());
        mVp.setOffscreenPageLimit(mImgList.size());//设置预加载数量
        mVp.setPageMargin(-50);//控制两幅图之间的间距
        mVp.setPageTransformer(true,new GallyPageTransformer());//3D画廊模式
        //viewPager左右两边滑动无效的处理
        findViewById(R.id.ll_gallery_outer).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return mVp.dispatchTouchEvent(motionEvent);
            }
        });
    }

    class MyAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return mImgList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = mLayoutInflater.inflate(R.layout.item_img, container, false);
            ImageView img = view.findViewById(R.id.img_item_img);
            //img.setImageResource(R.mipmap.sea);
            img.setImageResource(mImgList.get(position));
            img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
           container.removeView((View)object);
        }
    }


}
