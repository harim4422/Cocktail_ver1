package and.harim.com.cocktail;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }
    public void click_back(View view) {
        Intent menu = new Intent(this, MenuActivity.class);
        startActivity(menu);
    }//하단 뒤로가기 버튼 (종료)

    public void click_home(View view) {
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }//하단 홈 버튼

    public void click_set(View view) {
        Intent set = new Intent(this,SettingsActivity.class);
        startActivity(set);
    }//세팅 연결

    public void click_facebook(View view) {
        Intent myIntent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/%ED%98%9C%ED%99%94-%EC%B9%B5%ED%85%8C%EC%9D%BC-600220950378118/?modal=admin_todo_tour"));
        startActivity(myIntent);
    }//facebook페이지 연결

    public void click_mail(View view) {
    }
}
