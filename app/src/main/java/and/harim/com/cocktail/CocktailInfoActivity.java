package and.harim.com.cocktail;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CocktailInfoActivity extends AppCompatActivity {

    ImageView cocktail_image;
    TextView cocktail_name_tv;
    ImageView wofy_image;
    ImageView recipe_image;
    String youtube="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktail_info);
        //연결
        cocktail_image=(ImageView)findViewById(R.id.cocktail_image);
        cocktail_name_tv=(TextView)findViewById(R.id.cocktail_name_tv);
        wofy_image =(ImageView)findViewById(R.id.wofy_image);
        recipe_image=(ImageView)findViewById(R.id.recipe_image);

        CocktailItem ckitem =(CocktailItem)getIntent().getSerializableExtra("cock");
        cocktail_image.setImageResource(ckitem.getResId());
        cocktail_name_tv.setText(ckitem.getName());
        wofy_image.setImageResource(ckitem.getWofy_id());
        recipe_image.setImageResource(ckitem.getRecipe_id());
        setYoutube(ckitem.getVideo());


    }
    public void setYoutube(String url){
        this.youtube=url;
    }
    public void click_back(View view) {
        Intent cocktail = new Intent(this, CocktailActivity.class);
        startActivity(cocktail);
    }//하단 뒤로가기 버튼 (종료)

    public void click_home(View view) {
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }//하단 홈 버튼

    public void click_set(View view) {
        Intent set = new Intent(this,SettingsActivity.class);
        startActivity(set);
    }//세팅 연결

    public void click_youtube(View view) {
        Intent myIntent = new Intent (Intent.ACTION_VIEW, Uri.parse(youtube));
        startActivity(myIntent);
    }//유튜브 영상 연결
}
