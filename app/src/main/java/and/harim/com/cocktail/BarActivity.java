package and.harim.com.cocktail;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class BarActivity extends AppCompatActivity {

    ListView bar_lv;

    Spinner bar_spinner_1;
    Spinner bar_spinner_2;
    ArrayAdapter<String> city_adp;
    ArrayAdapter<String> seoul_adp;
    ArrayAdapter<String> not_adp;
    String[] city = {"서울특별시","경기도","강원도","경상도","충청도","전라도","제주도"};
    String[] seoul ={"종로구"};
    String[] noting={"업데이트 준비중 입니다.."};
    BarAdapter barAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);

        //스피너1
        bar_spinner_1 =(Spinner)findViewById(R.id.bar_spinner_1) ;
        //시티 어뎁터 준비
        city_adp = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item,city);
        city_adp.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        //스피너1 연결
        bar_spinner_1.setAdapter(city_adp);
        //스피너2
        bar_spinner_2 =(Spinner)findViewById(R.id.bar_spinner_2) ;
        //서울 어뎁터 준비
        seoul_adp = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item,seoul);
        seoul_adp.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        //not 어뎁터 준비
        not_adp = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item,noting);
        not_adp.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        //리스트 뷰 준비
        bar_lv =(ListView)findViewById(R.id.bar_lv);
        barAdapter = new BarAdapter();


        //스피너1 선택시
        bar_spinner_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    bar_spinner_2.setAdapter(seoul_adp);
                    settingBarListView();
                    bar_lv.setAdapter(barAdapter);
                }
                else{
                    bar_spinner_2.setAdapter(not_adp);
                    bar_lv.setAdapter(barAdapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
    public class BarAdapter extends BaseAdapter {
        ArrayList<BarItem> items = new ArrayList<BarItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(BarItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            BarItemView view = new BarItemView(getApplicationContext());

            BarItem item = items.get(position);
            view.setName(item.getName());
            view.setAddress(item.getAddress());
            view.setScore(item.getScore());
            view.setImage(item.getResId());

            return view;
        }

    }


    private void settingBarListView(){
        barAdapter.addItem(new BarItem("독일주택","서울 종로구 대명1길 16-4(명륜4가 45-1)",3.0,R.drawable.dockiljuteak));
        barAdapter.addItem(new BarItem("퀸101","서울 종로구 대명길 17(명륜4가 12-3)",4.5,R.drawable.q101));
        bar_lv.setAdapter(barAdapter);
    }

    public void click_back(View view) {
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
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
