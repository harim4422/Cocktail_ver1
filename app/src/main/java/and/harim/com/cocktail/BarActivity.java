package and.harim.com.cocktail;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
    ArrayList<String> bar_list;
    ArrayAdapter<String> bar_adp;

    Spinner bar_spinner_1;
    Spinner bar_spinner_2;
    ArrayAdapter<String> city_adp;
    ArrayAdapter<String> seoul_adp;
    ArrayAdapter<String> not_adp;
    String[] city = {"서울특별시","경기도","강원도","경상도","충청도","전라도","제주도"};
    String[] seoul ={"종로구"};
    String[] noting={"업데이트 준비중 입니다.."};

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

        //스피너1 선택시
        bar_spinner_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    bar_spinner_2.setAdapter(seoul_adp);
                }
                else{bar_spinner_2.setAdapter(not_adp);}
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        bar_lv =(ListView)findViewById(R.id.bar_lv);
        bar_list= new ArrayList<>();
        bar_adp = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,bar_list);
        bar_lv.setAdapter(bar_adp);

       /* BarAsyncTask bat = new BarAsyncTask();
        bat.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);*/

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

    /*private class BarAsyncTask extends AsyncTask<Void,String,Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            String url ="https://cafe.naver.com/cocktailapp?iframe_url=/ArticleList.nhn%3Fsearch.clubid=29487548%26search.menuid=4%26search.boardtype=L";

            try {
                Document doc = Jsoup.connect(url).get();
                Elements datas = doc.select("span");
                for(Element el:datas){
                    String title = el.select("a").get(0).text();
                    publishProgress(title);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            //어댑터에 데이터 추가시 데이터 원본 수정, UI갱신
            bar_adp.add(values[0]);
        }
    }*/
}
