package com.project.slider.simlpeslider;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPagerActivity;
    LinearLayout sliderDotspanel;
    private ViewPagerAdapter adapter;
    private int dotscount, itemsCounter;
    private ImageView[] dots;
    private int[] images = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5
    };
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPagerActivity = findViewById(R.id.view_pager);
        sliderDotspanel = findViewById(R.id.SliderDots);

        adapter = new ViewPagerAdapter(this);
        viewPagerActivity.setAdapter(adapter);


        loadDots();
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerClass(), 2000, 3000);

    }

    public void loadDots() {

        dotscount = adapter.getCount();
        dots = new ImageView[dotscount];

        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(getApplicationContext());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        viewPagerActivity.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public class TimerClass extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    for (itemsCounter = 0; itemsCounter < images.length; itemsCounter++) {
                        if (viewPagerActivity.getCurrentItem() == itemsCounter) {
                            if (itemsCounter == images.length - 1) {
                                viewPagerActivity.setCurrentItem(0);
                                itemsCounter = 0;
                                break;
                            } else {
                                viewPagerActivity.setCurrentItem(++itemsCounter);
                                break;
                            }

                        }
                    }
                }
            });
        }
    }


}
