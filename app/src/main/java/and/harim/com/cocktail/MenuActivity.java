package and.harim.com.cocktail;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void click_facebook(View view) {
        Intent myIntent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/%ED%98%9C%ED%99%94-%EC%B9%B5%ED%85%8C%EC%9D%BC-600220950378118/?modal=admin_todo_tour"));
        startActivity(myIntent);
    }//facebook 버튼 링크 연결

    public void click_bar(View view) {
        Intent bar = new Intent(this,BarActivity.class);
        startActivity(bar);
    }

    public void click_cocktail(View view) {
        Intent cocktail = new Intent(this,CocktailActivity.class);
        startActivity(cocktail);
    }

    public void click_recipe(View view) {
    }

    public void click_set(View view) {
    }

    public void click_help(View view) {
    }
}
