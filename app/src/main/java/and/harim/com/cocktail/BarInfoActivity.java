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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
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
    EditText ep_name;
    EditText ep_et;
    ArrayList<EpItem> bar_ep;
    ArrayAdapter<EpItem> ep_adp;
    ArrayAdapter<String> menu_adp;
    String add;
    ArrayList<BarItem> bar_ary;
    BarItem item;
    EpItem ei;

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
        final String bar_name;
        ep_et =(EditText)findViewById(R.id.ep_et);



        //BarActivity에서 리스트뷰 데이터 item 받아오기
        item = (BarItem)getIntent().getSerializableExtra("item");
        if(item!=null) {
            bar_image.setImageResource(item.getResId());
            bar_name_tv.setText(item.getName());
            bar_address_tv.setText(item.getAddress());
            menu_adp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, item.getMenu());
            menu_lv.setAdapter(menu_adp);
            add = item.getAddress();
            bar_name = item.getName();
            bar_ep=item.getEp_AL();



            //후기 관련 어댑터

            ep_adp =new ArrayAdapter<EpItem>(this,android.R.layout.simple_list_item_1,bar_ep);
            ep_lv.setAdapter(ep_adp);


            //지도 추가
            bar_address_tv.setOnTouchListener(new View.OnTouchListener(){   //터치 이벤트 리스너 등록(누를때와 뗐을때를 구분)


                public boolean onTouch(View v, MotionEvent event) {
                    // TODO Auto-generated method stub
                    ;

                    if(event.getAction()==MotionEvent.ACTION_DOWN){
                        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                        intent.putExtra("add", add);
                        intent.putExtra("barname", bar_name);

                        startActivityForResult(intent, 1001);

                    }
                    return true;
                }
            });
        }
    }


    //지도 메소드
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 1001){
            if(resultCode == Activity.RESULT_OK){
                LatLng bus = new LatLng(40, 120);
                GoogleMap mMap=null;
                mMap.moveCamera(CameraUpdateFactory.newLatLng(bus));
                mMap.animateCamera(CameraUpdateFactory.zoomBy(10));

            }
            if(resultCode == Activity.RESULT_CANCELED){

            }
        }
    }



    //후기 등록 메소드
    public void click_resist(View view) {
        String name = ep_name.getText().toString();
        String ep = ep_et.getText().toString();
        ei= new EpItem();
        ei.setEp_name(name);
        ei.setEp(ep);
        if( name.trim().length()==0 ||  ep.trim().length()==0){
            Toast.makeText(this,"이름과 내용을 확인해 주세요",Toast.LENGTH_SHORT).show();
            return;
        }
        bar_ep.add(ei);
        ep_adp.notifyDataSetChanged();//화면 갱신
        ep_name.setText("");
        ep_et.setText("");

        //로딩
        SharedPreferences pref = getPreferences(MODE_PRIVATE);
        String s = pref.getString("bar_ary",null);
        Type objType = new TypeToken<ArrayList<BarItem>>() {
        }.getType();
        Gson gson = new GsonBuilder().create();
        bar_ary = gson.fromJson(s, objType);
        System.out.println("*********"+bar_ary);


    }


    public void click_back(View view) {
        Intent bar = new Intent(this, BarInfoActivity.class);
        bar.putExtra("item",item);
        setResult(RESULT_OK, bar);
        finish();
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
