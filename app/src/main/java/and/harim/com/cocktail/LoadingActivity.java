package and.harim.com.cocktail;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class LoadingActivity extends Activity {
    private ImageView imgAndroid;
    private ImageView imgAndroid2;
    private Animation anim;
    private Animation anim2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        startLoading();
    }
    private void startLoading() {

        imgAndroid = (ImageView)findViewById(R.id.img_android);
        anim = AnimationUtils.loadAnimation(this, R.anim.loading);
        imgAndroid.setAnimation(anim);
        imgAndroid2 = (ImageView)findViewById(R.id.img_android2);
        anim2 = AnimationUtils.loadAnimation(this, R.anim.loading2);
        imgAndroid2.setAnimation(anim2);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 1300);


    }
}
