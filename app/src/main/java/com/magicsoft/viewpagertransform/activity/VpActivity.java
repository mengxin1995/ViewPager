package com.magicsoft.viewpagertransform.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.magicsoft.viewpagertransform.R;
import com.magicsoft.viewpagertransform.adapter.VpAdapter;
import com.magicsoft.viewpagertransform.transform.cust.ABaseTransformer;
import com.magicsoft.viewpagertransform.transform.cust.AccordionTransformer;
import com.magicsoft.viewpagertransform.transform.cust.BackgroundToForegroundTransformer;
import com.magicsoft.viewpagertransform.transform.cust.CubeInTransformer;
import com.magicsoft.viewpagertransform.transform.cust.CubeOutTransformer;
import com.magicsoft.viewpagertransform.transform.cust.DrawerTransformer;
import com.magicsoft.viewpagertransform.transform.cust.FlipHorizontalTransformer;
import com.magicsoft.viewpagertransform.transform.cust.FlipVerticalTransformer;
import com.magicsoft.viewpagertransform.transform.cust.ForegroundToBackgroundTransformer;
import com.magicsoft.viewpagertransform.transform.cust.RotateDownTransformer;
import com.magicsoft.viewpagertransform.transform.cust.RotateUpTransformer;
import com.magicsoft.viewpagertransform.transform.cust.ScaleInOutTransformer;
import com.magicsoft.viewpagertransform.transform.cust.StackTransformer;
import com.magicsoft.viewpagertransform.transform.cust.TabletTransformer;
import com.magicsoft.viewpagertransform.transform.cust.ZoomInTransformer;
import com.magicsoft.viewpagertransform.transform.cust.ZoomOutSlideTransformer;
import com.magicsoft.viewpagertransform.transform.cust.ZoomOutTransformer;
import com.magicsoft.viewpagertransform.transform.effect.DepthPageTransformer;
import com.magicsoft.viewpagertransform.transform.effect.MyTransformer1;
import com.magicsoft.viewpagertransform.transform.effect.MyTransformer2;
import com.magicsoft.viewpagertransform.transform.effect.MyTransformer3;
import com.magicsoft.viewpagertransform.transform.effect.MyTransformer4;
import com.magicsoft.viewpagertransform.transform.effect.StereoPagerTransformer;
import com.magicsoft.viewpagertransform.transform.effect.ZoomInTransform;
import com.magicsoft.viewpagertransform.transform.effect.ZoomOutPageTransformer;

import java.util.ArrayList;

/**
 * Created by 刘少帅 on 2017/11/8
 */

public class VpActivity extends AppCompatActivity {

    public static final String TAG = "MMM";
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

    /**
     * 获取屏幕的宽度
     *
     * @param context
     * @return
     */
    public  int getScreenWidth(Context context) {
        WindowManager service = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        service.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public void oneListener(View view) {//平移,缩放,渐变
        mVp.setPageTransformer(true,new DepthPageTransformer());
    }


    public void twoListener(View view) {//平移,缩放,渐变2
        mVp.setPageTransformer(true,new ZoomOutPageTransformer());
    }

    public void threeListener(View view) {//两边同时缩放,同时渐变
        mVp.setPageTransformer(true,new MyTransformer1());
    }

    public void fourListener(View view) {//同官方一类似
        mVp.setPageTransformer(true,new MyTransformer2());
    }

    public void fiveListener(View view) {//平移,渐变

        mVp.setPageTransformer(true,new MyTransformer3(getScreenWidth(this)));
    }

    public void sixListener(View view) {//360度翻转
        mVp.setPageTransformer(true,new MyTransformer4());
    }

    public void seventListener(View view) {//3d****
        mVp.setPageTransformer(true,new StereoPagerTransformer(getScreenWidth(this)));
    }

    public void eight(View view) {//**
        mVp.setPageTransformer(true,new ZoomInTransform());
    }

    public void customOne(View view) {//自定义效果
        mVp.setPageTransformer(true, new ABaseTransformer() {
            @Override
            protected void onTransform(View page, float position) {
                Log.e(TAG, "onTransform: "+page+"|||"+position);
            }
        });
    }

    public void customTwo(View view) {//翻页效果*****
        mVp.setPageTransformer(true,new AccordionTransformer());
    }

    public void customThree(View view) {//x
        mVp.setPageTransformer(true,new BackgroundToForegroundTransformer());
    }

    public void customFour(View view) {//xxxx
        mVp.setPageTransformer(true,new CubeInTransformer());
    }

    public void custom5(View view) {//3d
        mVp.setPageTransformer(true,new CubeOutTransformer());
    }

    public void custom6(View view) {//等同于官方一
        mVp.setPageTransformer(true,new com.magicsoft.viewpagertransform.transform.cust.DepthPageTransformer());
    }

    public void custom7(View view) {//同时平移
        mVp.setPageTransformer(true,new DrawerTransformer());
    }


    public void custom8(View view) {//360翻转,水平方向
        mVp.setPageTransformer(true,new FlipHorizontalTransformer());
    }

    public void custom9(View view) {//360翻转,垂直方向
        mVp.setPageTransformer(true,new FlipVerticalTransformer());
    }

    public void custom10(View view) {//当前缩小退出
        mVp.setPageTransformer(true,new ForegroundToBackgroundTransformer());
    }

    public void custom11(View view) {//扇形,平移加旋转
        mVp.setPageTransformer(true,new RotateDownTransformer());
    }

    public void custom12(View view) {//扇形,平移加旋转
        mVp.setPageTransformer(true,new RotateUpTransformer());
    }

    public void custom13(View view) {//同时缩放,一个放大,一个缩小
        mVp.setPageTransformer(true,new ScaleInOutTransformer());
    }

    public void custom14(View view) {//平移
        mVp.setPageTransformer(true,new StackTransformer());
    }

    public void custom15(View view) {//平移,旋转xxx
        mVp.setPageTransformer(true,new TabletTransformer());
    }

    public void custom16(View view) {//平移,渐变
        mVp.setPageTransformer(true,new ZoomOutSlideTransformer());
    }

    public void custom17(View view) {//缩放
        mVp.setPageTransformer(true,new ZoomOutTransformer());
    }

    public void custom18(View view) {//缩放2
        mVp.setPageTransformer(true,new ZoomInTransformer());
    }
}
