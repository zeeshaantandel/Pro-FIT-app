package com.example.fitnessapps2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ImageAdapterArticles extends PagerAdapter {

    private Context contextArticles;
    private int[] ArticlesImageIds=new int[]{R.drawable.articles_quote,R.drawable.articles_1,R.drawable.articles_2,R.drawable.articles_3,R.drawable.articles_4,R.drawable.articles_5,R.drawable.articles_6,R.drawable.articles_7,R.drawable.articles_8,R.drawable.articles_9,R.drawable.articles_10};

    ImageAdapterArticles(Context context){
        contextArticles=context;
    }

    @Override
    public int getCount() {
        return ArticlesImageIds.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageViewArticles=new ImageView(contextArticles);
        imageViewArticles.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageViewArticles.setImageResource(ArticlesImageIds[position]);
        container.addView(imageViewArticles,0);

        if (position==0){
            imageViewArticles.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        else {
            imageViewArticles.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        return imageViewArticles;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView)object);
    }
}
