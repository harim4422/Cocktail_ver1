package and.harim.com.cocktail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class BarInfoActivity extends AppCompatActivity {

    ImageView bar_image;
    TextView bar_name_tv;
    TextView bar_address_tv;
    ListView menu_lv;
    ListView ep_lv;
    ListView ep_name_lv;
    EditText ep_name;
    EditText ep_et;
    ArrayList<BarItem> bar_ep;
    ArrayList<String> ep_name_list;
    ArrayList<String> ep_list;
    ArrayAdapter<String> ep_name_adp;
    ArrayAdapter<String> ep_adp;
    ArrayAdapter<String> menu_adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_info);

        //데이터 연결 (이미지, 이름, 주소)
        bar_image =(ImageView)findViewById(R.id.bar_image);
        bar_name_tv =(TextView)findViewById(R.id.bar_name_tv);
        bar_address_tv=(TextView)findViewById(R.id.bar_address_tv);
        menu_lv = (ListView)findViewById(R.id.menu_lv);
        ep_lv =(ListView)findViewById(R.id.ep_lv);
        ep_name=(EditText)findViewById(R.id.ep_name);
        ep_et =(EditText)findViewById(R.id.ep_et);

        //BarActivity에서 리스트뷰 데이터 item 받아오기
        BarItem item = (BarItem)getIntent().getSerializableExtra("item");
        if(item!=null) {
            bar_image.setImageResource(item.getResId());
            bar_name_tv.setText(item.getName());
            bar_address_tv.setText(item.getAddress());
            menu_adp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, item.getMenu());
            menu_lv.setAdapter(menu_adp);

            //지도 추가
            bar_address_tv.setOnTouchListener(new View.OnTouchListener(){   //터치 이벤트 리스너 등록(누를때와 뗐을때를 구분)


                public boolean onTouch(View v, MotionEvent event) {
                    // TODO Auto-generated method stub
                    if(event.getAction()==MotionEvent.ACTION_DOWN){
                        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                        startActivity(intent);
                    }
                    return true;
                }
            });
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

    public void click_resist(View view) {
        String name =ep_name.getText().toString();
        String ep = ep_et.getText().toString();
        if( name.trim().length()==0 ||  ep.trim().length()==0){
            Toast.makeText(this,"이름과 후기내용을 확인해 주세요",Toast.LENGTH_SHORT).show();
            return;
        }
        SharedPreferences pref = getPreferences(MODE_PRIVATE);
        Gson gson = new GsonBuilder().create();

    }
    private class epAdapter<T> extends ArrayAdapter<BarItem> {
        private final Activity activity;
        private final int ep_row;
        private final ArrayList<BarItem> bar_ep;

        public epAdapter(
                Activity activity,
                int ep_row,
                ArrayList<BarItem> bar_ep) {
            super(activity,ep_row,bar_ep);
            this.activity = activity;
            this.ep_row = ep_row;
            this.bar_ep = bar_ep;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // convertView 화면에 한개 행으로 그려지는 뷰
            // 처음에는 보여줄게 없어서 null
            if(convertView==null){//초반에
                LayoutInflater inflater =
                        (LayoutInflater) activity.getSystemService(
                                Context.LAYOUT_INFLATER_SERVICE);
                //XML화면을 자바객체로 변환
                convertView = inflater.inflate(ep_row,null);
            }
            BarItem info = bar_ep.get(position);
            TextView name_tv = (TextView)convertView.findViewById(R.id.ep_name_tv);
            TextView company_tv = (TextView)convertView.findViewById(R.id.ep_tv);
            //name_tv.setText();
           // company_tv.setText(info.company_name);

            return convertView;
        }//end getView(...)...
    }//end SingerAdapter

}
