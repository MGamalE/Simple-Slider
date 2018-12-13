package com.project.slider.simlpeslider.view;

import android.app.ProgressDialog;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.project.slider.simlpeslider.R;
import com.project.slider.simlpeslider.model.PhotoResponse;
import com.project.slider.simlpeslider.network.PhotoClient;
import com.project.slider.simlpeslider.network.PhotoEndPoint;

import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final int PER_PAGE = 5;
    private static final int PAGE = 1;

    ViewPager viewPagerActivity;
    LinearLayout sliderDotspanel;
    ProgressDialog progressDialog;

    private ViewPagerAdapter adapter;
    private ImageView[] dots;
    private int dotsCount, itemsCounter;

    Timer timer;


    private int[] images = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPagerActivity = findViewById(R.id.view_pager);
        sliderDotspanel = findViewById(R.id.SliderDots);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        loadPhotos();

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerClass(), 2000, 3000);

    }

    private void loadPhotos() {
        final PhotoEndPoint photoEndPoint = PhotoClient.getClient().create(PhotoEndPoint.class);
        Call<PhotoResponse> call = photoEndPoint.getPhotos(PER_PAGE, PAGE);
        call.enqueue(new Callback<PhotoResponse>() {
            @Override
            public void onResponse(Call<PhotoResponse> call, Response<PhotoResponse> response) {
                viewPagerActivity.setVisibility(View.VISIBLE);
                PhotoResponse photoResponse = response.body();
                adapter = new ViewPagerAdapter(MainActivity.this, photoResponse.getPhotos());
                viewPagerActivity.setAdapter(adapter);
                loadDots();
                progressDialog.dismiss();

            }

            @Override
            public void onFailure(Call<PhotoResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                Log.e("onFailure", t.getMessage());
                progressDialog.dismiss();
            }
        });


    }

    public void loadDots() {

        dotsCount = adapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {

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

                for (int i = 0; i < dotsCount; i++) {
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
