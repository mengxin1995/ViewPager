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
import com.magicsoft.viewpagertransform.transform.ZoomOutPageTransformer;

/**
 * Created by  on 2017/11/8
 * <p>
 * 普通画廊
 */

public class GalleryActivity2 extends AppCompatActivity {
    private LayoutInflater mLayoutInflater;
    private ViewPager mVp;
    private int[] mImg = new int[]{R.mipmap.sea, R.mipmap.sunset, R.mipmap.sea, R.mipmap.lotus, R.mipmap.red};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        mLayoutInflater = LayoutInflater.from(this);
        mVp = (ViewPager) findViewById(R.id.vp_gallery_vp);


        mVp.setAdapter(new MyAdapter());
        mVp.setOffscreenPageLimit(mImg.length);//设置预加载数量
        mVp.setPageMargin(10);//控制两幅图之间的间距
       mVp.setPageTransformer(true,new ZoomOutPageTransformer());
        //viewPager左右两边滑动无效的处理
        findViewById(R.id.ll_gallery_outer).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return mVp.dispatchTouchEvent(motionEvent);
            }
        });
    }

    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mImg.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = mLayoutInflater.inflate(R.layout.item_img, container, false);
            ImageView img = view.findViewById(R.id.img_item_img);
            //img.setImageResource(R.mipmap.sea);
            img.setImageResource(mImg[position]);
            img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
