package com.yume.demogallery;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

public class MainActivity extends Activity {
    private Context context=this;
    private ImageSwitcher imageSwitcher;
    private int[] image = {
            android.R.drawable.ic_btn_speak_now,android.R.drawable.ic_dialog_alert,
            android.R.drawable.ic_dialog_dialer,android.R.drawable.ic_dialog_email,
            android.R.drawable.ic_dialog_map,android.R.drawable.ic_dialog_info,
            android.R.drawable.ic_media_ff,android.R.drawable.ic_media_next,
            android.R.drawable.ic_media_pause,android.R.drawable.ic_media_play,
            android.R.drawable.ic_media_previous,android.R.drawable.ic_media_rew,
            android.R.drawable.ic_notification_clear_all,android.R.drawable.ic_notification_overlay,
            android.R.drawable.ic_popup_disk_full,android.R.drawable.ic_popup_reminder,android.R.drawable.ic_popup_sync
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //建立scrollview裡的每個imageview
        LinearLayout view=(LinearLayout)findViewById(R.id.view);
        for(int i=0;i<image.length;i++){
            ImageView imageView=new ImageView(context);
            imageView.setImageResource(image[i]);
            imageView.setTag(i);
            imageView.setPadding(5,0,5,0);
            imageView.setOnClickListener(new ImageOnClick());
            view.addView(imageView);
        }
        view.setGravity(Gravity.CENTER);

        imageSwitcher = (ImageSwitcher)findViewById(R.id.image_switcher);
        imageSwitcher.setFactory(new ResetImage());
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(context, android.R.anim.slide_out_right));
    }
    //scrollview裡的每個image點下去會更換imageswitcher的圖
    private class ImageOnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            imageSwitcher.setImageResource(image[(int)v.getTag()]);
        }
    }
    //imageswitcher重置圖片
    private class ResetImage implements ViewSwitcher.ViewFactory {
        @Override
        public View makeView() {
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return imageView;
        }
    }
}