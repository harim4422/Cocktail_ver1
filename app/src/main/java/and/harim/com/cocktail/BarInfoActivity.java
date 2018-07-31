package and.harim.com.cocktail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class BarInfoActivity extends AppCompatActivity {

    ImageView bar_image;
    TextView bar_name_tv;
    TextView bar_address_tv;
    ListView menu_lv;
    EditText epilogue_et;
    ArrayAdapter<String> menu_adp;
    ArrayList<String> menu_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_info);

        //데이터 연결 (이미지, 이름, 주소)
        bar_image =(ImageView)findViewById(R.id.bar_image);
        bar_name_tv =(TextView)findViewById(R.id.bar_name_tv);
        bar_address_tv=(TextView)findViewById(R.id.bar_address_tv);
        menu_lv = (ListView)findViewById(R.id.menu_lv);

        //BarActivity에서 리스트뷰 데이터 item 받아오기
        BarItem item = (BarItem)getIntent().getSerializableExtra("item");
        if(item!=null) {
            bar_image.setImageResource(item.getResId());
            bar_name_tv.setText(item.getName());
            bar_address_tv.setText(item.getAddress());
            menu_adp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, item.getMenu());
            menu_lv.setAdapter(menu_adp);
        }
    }
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
