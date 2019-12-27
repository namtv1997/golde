package com.app.goldenhealth.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.network.BuildConfig;
import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

import java.util.ArrayList;

/**
 * Created by Blue on 1/9/2018.
 */

public class SlideImage extends FragmentActivity {
    static final int NUM_ITEMS = 6;
    private static String TAG = "SLIDE";
    ArrayList<String> arrImg;
    ImageFragmentPagerAdapter imageFragmentPagerAdapter;
    ViewPager viewPager;
    private String[] IMAGE_NAME;

    public static Intent getCallingIntent(Context context) {
        Intent intent = new Intent(context, SlideImage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pager);

        arrImg = getIntent().getStringArrayListExtra(Key.ARRIMG);
        Log.d(TAG, "onCreate: " + arrImg);



        imageFragmentPagerAdapter = new ImageFragmentPagerAdapter(getSupportFragmentManager(),arrImg);
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(imageFragmentPagerAdapter);
        int pos = getIntent().getIntExtra(Key.POSITION, 0);
        viewPager.setCurrentItem(pos);

    }

    public static class ImageFragmentPagerAdapter extends FragmentPagerAdapter {
        ArrayList<String> arrImg;
        public ImageFragmentPagerAdapter(FragmentManager fm, ArrayList<String> arrImg) {
            super(fm);
            this.arrImg=arrImg;

        }

        @Override
        public int getCount() {
            return arrImg.size();
        }

        @Override
        public Fragment getItem(int position) {
            SwipeFragment fragment = new SwipeFragment();

            return SwipeFragment.newInstance(position,arrImg);
        }
    }

    public static class SwipeFragment extends Fragment {
        ArrayList<String> arrImg;
        String[]IMAGE_NAME;
        static SwipeFragment newInstance(int position, ArrayList<String> arrImg) {
            SwipeFragment swipeFragment = new SwipeFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("position", position);
            bundle.putStringArrayList(Key.ARRIMG,arrImg);
            swipeFragment.setArguments(bundle);
            return swipeFragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View swipeView = inflater.inflate(R.layout.swipe_fragment, container, false);
            PhotoView imageView = swipeView.findViewById(R.id.imageView);
            Bundle bundle = getArguments();
            arrImg=bundle.getStringArrayList(Key.ARRIMG);
            int position = bundle.getInt("position");
            IMAGE_NAME = new String[arrImg.size()];
            for (int i = 0; i < arrImg.size(); i++) {
                IMAGE_NAME[i] = arrImg.get(i);
            }
            String imageFileName = IMAGE_NAME[position];

            Glide.with(this)
                    .load(imageFileName)
                    .into(imageView);
            return swipeView;
        }
    }
}
