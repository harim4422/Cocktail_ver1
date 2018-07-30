package and.harim.com.cocktail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class BarInfoActivity extends AppCompatActivity {

    ImageView bar_image;
    TextView bar_name_tv;
    TextView bar_address_tv;
    ListView menu_lv;
    ArrayList<String> menu_list;
    ArrayAdapter<String> menu_adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_info);


    }
    private void settingList(){}
    public void click_back(View view) {
        Intent bar = new Intent(this, BarActivity.class);
        startActivity(bar);
    }//하단 뒤로가기 버튼 (종료)

    public void click_home(View view) {
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }//하단 홈 버튼

    public void click_set(View view) {
        Intent set = new Intent(this,SettingsActivity.class);
        startActivity(set);
    }//세팅 연결
}
