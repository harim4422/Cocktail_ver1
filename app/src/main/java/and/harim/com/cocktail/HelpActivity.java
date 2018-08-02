package and.harim.com.cocktail;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {

    TextView hidden_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        hidden_btn=(TextView)findViewById(R.id.hidden_btn);

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
        Intent myIntent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/멀티칵테일-874231729439324/"));
        startActivity(myIntent);
    }//facebook페이지 연결

    public void click_mail(View view) {
        Intent email = new Intent(Intent.ACTION_SEND);
        email.setType("plain/text");
        // email setting 배열로 해놔서 복수 발송 가능
        String[] address = {"harim4422@naver.com"};
        email.putExtra(Intent.EXTRA_EMAIL, address);
        email.putExtra(Intent.EXTRA_SUBJECT,"칵테일 문의하기");
        email.putExtra(Intent.EXTRA_TEXT,"문의할 내용을 써주세요.\n");
        startActivity(email);
    }

    public void click_kakao(View view) {
        Intent myIntent = new Intent (Intent.ACTION_VIEW, Uri.parse("http://pf.kakao.com/_fGTgC"));
        startActivity(myIntent);
    }

    public void click_team(View view) {
        Intent team = new Intent(this, MadeBy.class);
        startActivity(team);
    }
}
