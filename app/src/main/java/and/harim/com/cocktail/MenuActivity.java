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
    }

    public void click_help(View view) {
        // 메일 연동

        Uri uri = Uri.parse("mailto:" + "gkwls0812@naver.com");

        // 인수로 송신지를 설정하고 이 값은 setData로 설정해도 된다

        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);

        // 설정할 메일 본문의 제목이 Text인 경우에는 text/plain을, HTML인 경우에는 text/html을 설정한다

        intent.setType("text/혜화 칵테일 문의합니다");

        // 제목을 설정한다

        intent.putExtra(Intent.EXTRA_SUBJECT, "");

        // 본문을 설정한다

    }
}
