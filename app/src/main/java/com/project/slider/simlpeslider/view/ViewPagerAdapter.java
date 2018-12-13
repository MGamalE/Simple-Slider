package com.project.slider.simlpeslider.view;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.github.chrisbanes.photoview.PhotoView;
import com.project.slider.simlpeslider.R;
import com.project.slider.simlpeslider.model.Photos;

import java.util.ArrayList;

public class ViewPagerAdapter extends PagerAdapter {
    Dialog dialog;

    private ArrayList<Photos> photos;
    private Context context;
    private LayoutInflater layoutInflater;
    private int[] images = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5
    };

    public ViewPagerAdapter(Context context) {
        this.context = context;

    }

    public ViewPagerAdapter(Context context, ArrayList<Photos> photos) {
        this.context = context;
        this.photos = photos;

    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.custom_view_pager, null);
        ImageView imageView = view.findViewById(R.id.imageView);
        Glide.with(context)
                .asBitmap()
                .load(photos.get(position).getPhotoSrc().getPhotoUrl())
                .apply(new RequestOptions().override(1080, 600).placeholder(R.color.colorAccent)
                        .error(R.drawable.ic_launcher_background))
                .into(imageView);

        ViewPager vp = (ViewPager) container;

        vp.addView(view, 0);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(photos.get(position).getPhotoSrc().getPhotoUrl(), photos.get(position).getPhotographer());
            }
        });

        return view;
    }

    private void showDialog(String imageUrl, String photographer) {
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.custom_dialog);

        ImageButton close = (ImageButton) dialog.findViewById(R.id.btnClose);
        PhotoView photoView = dialog.findViewById(R.id.imageDialog);
        TextView photographerName = dialog.findViewById(R.id.photograpgher);


        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        Glide.with(context)
                .load(imageUrl)
                .apply(new RequestOptions().placeholder(R.color.colorAccent)
                        .error(R.drawable.ic_launcher_background))
                .into(photoView);

        photographerName.setText(photographer);

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.show();
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }

    @Override
    public int getCount() {
        if (photos.size() != 0)
            return photos.size();
        else
            return images.length;
    }

}
