# DemoGallery

### 動態產生元件

> 程式動態產生ImageView，並綁定至LinearLayout

	LinearLayout view=(LinearLayout)findViewById(R.id.view);
    for(int i=0;i<5;i++){
        ImageView imageView=new ImageView(context);
        imageView.setImageResource(image[i]);
        imageView.setTag(i);
        imageView.setPadding(5,0,5,0);
        imageView.setOnClickListener(new ImageOnClick());
        view.addView(imageView);
    }

> 實作點下ImageView時的事件

	private class ImageOnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            imageSwitcher.setImageResource(image[(int)v.getTag()]);
        }
    }

### ImageSwitcher

> 設定ImageSwitcher移入移出動畫

	ImageSwitcher imageSwitcher = (ImageSwitcher)findViewById(R.id.image_switcher);
    imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left)); //移入動畫
    imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(context, android.R.anim.slide_out_right)); //移出動畫
    imageSwitcher.setFactory(new ResetImage());

> ImageSwitcher產生圖

	private class ResetImage implements ViewSwitcher.ViewFactory {
        @Override
        public View makeView() {
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return imageView;
        }
    }

