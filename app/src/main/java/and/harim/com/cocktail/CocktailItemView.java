package and.harim.com.cocktail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class CocktailItemView extends LinearLayout {
    TextView cocktail_title;
    ImageView cocktail_image;

    public CocktailItemView(Context context) {
        super(context);
        init(context);
    }

    public CocktailItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.bar_item, this, true);

        cocktail_title = (TextView) findViewById(R.id.bar_title);
        cocktail_image = (ImageView) findViewById(R.id.bar_image);
    }

    public void setName(String name) {
        cocktail_title.setText(name);
    }

    public void setImage(int resId) {
        cocktail_image.setImageResource(resId);
    }}
