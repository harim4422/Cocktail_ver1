package and.harim.com.cocktail;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class SearchActivity extends AppCompatActivity {

    private ArrayList<BarItem> list;          // 데이터를 넣은 리스트변수
    private ListView listView;          // 검색을 보여줄 리스트변수
    private EditText editSearch;        // 검색어를 입력할 Input 창
    private SearchAdapter adapter;      // 리스트뷰에 연결할 아답터
    private ArrayList<BarItem> arraylist;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        editSearch = (EditText) findViewById(R.id.editSearch);
        listView = (ListView) findViewById(R.id.listView);

        // 리스트를 생성한다.
        list = new ArrayList<BarItem>();


        // 검색에 사용할 데이터을 미리 저장한다.
        settingList();

        // 리스트의 모든 데이터를 arraylist에 복사한다.// list 복사본을 만든다.
        arraylist = new ArrayList<BarItem>();
        arraylist.addAll(list);

        // 리스트에 연동될 아답터를 생성한다.
        adapter = new SearchAdapter(list, this);

        // 리스트뷰에 아답터를 연결한다.
        listView.setAdapter(adapter);

        // input창에 검색어를 입력시 "addTextChangedListener" 이벤트 리스너를 정의한다.
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // input창에 문자를 입력할때마다 호출된다.
                // search 메소드를 호출한다.
                String text = editSearch.getText().toString();
                search(text);
            }
        });
        final AdapterView.OnItemClickListener searchClickListener= new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                BarItem item = (BarItem)adapter.getItem(i);
                Toast.makeText(getApplicationContext(),item.toString(),Toast.LENGTH_SHORT).show();
                Intent barinfo = new Intent(SearchActivity.this,BarInfoActivity.class);
                barinfo.putExtra("item",item);
                startActivity(barinfo);
            }
        };
        listView.setOnItemClickListener(searchClickListener);





    }

    // 검색을 수행하는 메소드
    public void search(String charText) {

        // 문자 입력시마다 리스트를 지우고 새로 뿌려준다.
        list.clear();

        // 문자 입력이 없을때는 모든 데이터를 보여준다.
        if (charText.length() == 0) {
            list.addAll(arraylist);
        }
        // 문자 입력을 할때..
        else
        {
            // 리스트의 모든 데이터를 검색한다.
            for(int i = 0;i < arraylist.size(); i++)
            {
                // arraylist의 모든 데이터에 입력받은 단어(charText)가 포함되어 있으면 true를 반환한다.
                if (arraylist.get(i).getName().toLowerCase().contains(charText))
                {
                    // 검색된 데이터를 리스트에 추가한다.
                    list.add(arraylist.get(i));
                }
            }
        }
        // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
        adapter.notifyDataSetChanged();
    }

    // 검색에 사용될 데이터를 리스트에 추가한다.
    private void settingList(){
        //01
        BarItem list1 = new BarItem("독일주택","서울 종로구 대명1길 16-4(명륜4가 45-1)",5.0,R.drawable.bar01);
        String[] list1_menu ={"올드 라스푸틴 - 10000원","스컬핀 - 13000원","슈나이더 마인 호펜바이세 탭 - 12000원","독일플레이트 - 8000원"};
        list1.setMenu(list1_menu);
        //02
        BarItem list2 = new BarItem("인생의 단맛","서울 종로구 성균관로5가길 1",5.0,R.drawable.bar02);
        String[] list2_menu ={"버드 – 3500원","기네스 – 8000원","데낄라 – 3000원"};
        list2.setMenu(list2_menu);
        //03
        BarItem list3 = new BarItem("우리의 밤","서울 종로구 창경궁로29길 3",5.0,R.drawable.bar03);
        String[] list3_menu ={"비와 당신 – 6000원","남자를 몰라 – 7000원","TV를 껐네 – 7000원","핸드릭스 진 토닉 – 10,000원"};
        list3.setMenu(list3_menu);
        //04
        BarItem list4 = new BarItem("햇살돛단배","서울 종로구 창경궁로34길 5",5.0,R.drawable.bar04);
        String[] list4_menu ={"타파스 – 12,000원","감바스 알 아히요 – 15,000원","하몽하몽 – 18000원","스페인 와인 스파클링 와인 샴페인 스페인 맥주 – 변동"};
        list4.setMenu(list4_menu);
        //05
        BarItem list5 = new BarItem("도리안그레이","서울 종로구 대학로11길 27 ",5.0,R.drawable.bar5);
        String[] list5_menu ={"써머스비 – 7,000원","에델바이스 – 7,000원","필스너우르켈 – 7,000원","치킨가라아게 – 12,000원"};
        list5.setMenu(list5_menu);
        //06
        BarItem list6 = new BarItem("반저","서울 종로구 대학로8길 56 ",5.0,R.drawable.bar6);
        String[] list6_menu ={"과일소주 - 10,000원","단호박해물찜 – 28,000원","오삼불고기 – 20,000원","모둠해물철판볶음 – 20,000원"};
        list6.setMenu(list6_menu);
        //07
        BarItem list7 = new BarItem("비틀즈","서울 종로구 동숭동 1-96 ",5.0,R.drawable.bar7);
        String[] list7_menu ={"캐언즈 쿨러 – 8,000원","카사블랑카 – 8,000원","피나 콜라다 – 8,000원","부케 – 9,000원"};
        list7.setMenu(list7_menu);
        //08
        BarItem list8 = new BarItem("믹스 앤 몰트","서울 종로구 창경궁로 29길 3 ",5.0,R.drawable.bar8);
        String[] list8_menu ={"싱글몰트위스키  - 190,000원","칵테일 - 12,000원","Food – 20,000원"};
        list8.setMenu(list8_menu);
        //09
        BarItem list9 = new BarItem("퀸101","서울 종로구 대명길 17 ",5.0,R.drawable.bar9);
        String[] list9_menu ={"스미노프 플레이버 750ml 세트 – 39,000원","앱솔루트 플레이버 750ml 세트 – 49,000원","칵테일 – 6,000원","호세쿠에르보 750ml 세트 – 49,000원"};
        list9.setMenu(list9_menu);
        //10
        BarItem list10 = new BarItem("수도원","서울 종로구 동숭3길 16 ",5.0,R.drawable.bar10);
        String[] list10_menu ={"라 쇼페 – 14,000원"};
        list10.setMenu(list10_menu);
        //11
        BarItem list11 = new BarItem("The Glenco","서울 종로구 낙산3길 23 ",5.0,R.drawable.bar11);
        String[] list11_menu ={"시그니쳐 칵테일 – 25,000원","클래식 칵테일 – 15,000원"};
        list11.setMenu(list11_menu);
        //12
        BarItem list12 = new BarItem("HUMER","서울 종로구 대학로11길 39 ",5.0,R.drawable.bar12);
        String[] list12_menu ={"칵테일 무제한 – 20,000원","보드카set – 89,000원","이태리피자미더볼 – 15,000원","시그니쳐 칵테일 – 15,000원"};
        list12.setMenu(list12_menu);
        //13
        BarItem list13 = new BarItem("스페이스플라토","서울 종로구 대명1길 20 ",5.0,R.drawable.bar13);
        String[] list13_menu ={"피자1+파스타1+하우스와인2 – 33,000원","브루원 생맥주 – 7,500원","시저샐러드피자 – 14,000원","하우스와인 – 9,000원"};
        list13.setMenu(list13_menu);
        //14
        BarItem list14 = new BarItem("나무요일","서울 종로구 창경궁로26길 39 ",5.0,R.drawable.bar14);
        String[] list14_menu ={"샐러드 12,000원","치즈,포테이토 12,000원","나무 파스타 10,000원","잭콕, 와인 – 9,000원"};
        list14.setMenu(list14_menu);
        //15
        BarItem list15 = new BarItem("챠코","서울 종로구 성균관로 15-3 ",5.0,R.drawable.bar15);
        String[] list15_menu ={"칵테일, 맥주 – 6,000원"};
        list15.setMenu(list15_menu);
        //16
        BarItem list16 = new BarItem("Comfort zone","서울 종로구 창경궁로 235-1 ",5.0,R.drawable.bar16);
        String[] list16_menu ={"Draft beer – 3,000원","스카치 – 6,000원","버번 – 6,000원"};
        list16.setMenu(list16_menu);
        //17
        BarItem list17 = new BarItem("에잇스트리트","서울 종로구 대학로8가길 26 ",5.0,R.drawable.bar17);
        String[] list17_menu ={"Fish&Chips – 16,500원","Handmade nacho – 5,000원","Kimchi fries – 12,000원"};
        list17.setMenu(list17_menu);
        //18
        BarItem list18 = new BarItem("마녀주방 대학로점","서울 종로구 대명길 18 ",5.0,R.drawable.bar18);
        String[] list18_menu ={"넓적다리 스테이크 – 6,000원","리코타 유령 독초 샐러드 – 6,000원","봉골레 파스타 – 12,500원","간장크림 파스타 – 12,000원"};
        list18.setMenu(list18_menu);
        //19
        BarItem list19 = new BarItem("a perfect day 찡쪽바","서울 종로구 성균관로 7-1 ",5.0,R.drawable.bar19);
        String[] list19_menu ={"짜이 – 5,000원","칵테일 – 7,000원"};
        list19.setMenu(list19_menu);
        //20
        BarItem list20 = new BarItem("머그앤글래스","서울 종로구 성균관로 7-1 ",5.0,R.drawable.bar20);
        String[] list20_menu ={"생맥주 – 3,000원","수제맥주 – 7,000원","하우스와인 – 3,900원","솔트커피 – 4,000원"};
        list20.setMenu(list20_menu);

        //연결
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        list.add(list5);
        list.add(list6);
        list.add(list7);
        list.add(list8);
        list.add(list9);
        list.add(list10);
        list.add(list11);
        list.add(list12);
        list.add(list13);
        list.add(list14);
        list.add(list15);
        list.add(list16);
        list.add(list17);
        list.add(list18);
        list.add(list19);
        list.add(list20);

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