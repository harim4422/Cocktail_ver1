package and.harim.com.cocktail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class BarItemView extends LinearLayout {
    TextView bar_title;
    TextView bar_ad;
    TextView bar_score;
    ImageView bar_image;

    public BarItemView(Context context) {
        super(context);
        init(context);
    }

    public BarItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.bar_item, this, true);

        bar_title = (TextView) findViewById(R.id.bar_title);
        bar_ad = (TextView) findViewById(R.id.bar_ad);
        bar_score = (TextView) findViewById(R.id.bar_score);
        bar_image = (ImageView) findViewById(R.id.bar_image);
    }

    public void setName(String name) {
        bar_title.setText(name);
    }

    public void setAddress(String mobile) {
        bar_ad.setText(mobile);
    }

    public void setScore(double score) {
        bar_score.setText(String.valueOf(score));
    }

    public void setImage(int resId) {
        bar_image.setImageResource(resId);
    }
}
