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
import com.magicsoft.viewpagertransform.indicator.ViewPagerIndicator;
import com.magicsoft.viewpagertransform.transform.ZoomOutPageTransformer;

/**
 * Created by  on 2017/11/8
 * <p>
 * 普通画廊
 */

public class GalleryActivity2 extends AppCompatActivity {
    private LayoutInflater mLayoutInflater;
    private ViewPager mVp;
    private int[] mImg = new int[]{R.mipmap.sea, R.mipmap.sunset, R.mipmap.lotus, R.mipmap.red};
    private ViewPagerIndicator mViewPagerIndicator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        mLayoutInflater = LayoutInflater.from(this);
        mVp = (ViewPager) findViewById(R.id.vp_gallery_vp);
        mViewPagerIndicator = (ViewPagerIndicator) findViewById(R.id.indicator_line);
        mViewPagerIndicator.setViewPager(mVp, mImg.length);


        MyAdapter myAdapter = new MyAdapter();
        mVp.setAdapter(myAdapter);
        mVp.setOffscreenPageLimit(3);//设置预加载数量
        mVp.setPageMargin(10);//控制两幅图之间的间距
        mVp.setPageTransformer(true,new ZoomOutPageTransformer());
        int firstPage = Integer.MAX_VALUE / 2 / mImg.length * mImg.length;
        mVp.setCurrentItem(firstPage, false);
        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                System.out.println("@@ position = " + position + " innerPosition = " + innerPosition(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
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
            int index = innerPosition(position);
            img.setImageResource(mImg[index]);
            img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }


    }
    private int innerPosition(int pos) {
        return pos % mImg.length;
    }
}
