package and.harim.com.cocktail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.io.Serializable;
import java.util.ArrayList;

public class CocktailActivity extends AppCompatActivity {

    ListView cocktail_lv;
    ArrayList<String> cocktail_list;
    CocktailAdapter cocktailAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktail);

        cocktail_lv = (ListView)findViewById(R.id.cocktail_lv);
        cocktailAdapter = new CocktailAdapter();
        settingCocktailListView();
        cocktail_lv.setAdapter(cocktailAdapter);

        final AdapterView.OnItemClickListener cocktaillistClickListener= new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CocktailItem ckitem = (CocktailItem)cocktailAdapter.getItem(i);
                Intent cockinfo = new Intent(CocktailActivity.this,CocktailInfoActivity.class);
                cockinfo.putExtra("cock", ckitem);
                startActivity(cockinfo);
            }
        };
        cocktail_lv.setOnItemClickListener(cocktaillistClickListener);


    }
    public class CocktailAdapter extends BaseAdapter {
        ArrayList<CocktailItem> items = new ArrayList<CocktailItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(CocktailItem item) {
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
            CocktailItemView view = new CocktailItemView(getApplicationContext());

            CocktailItem item = items.get(position);
            view.setName(item.getName());
            view.setImage(item.getResId());
            return view;
        }

    }


    private void settingCocktailListView(){
        //00
        CocktailItem list0 = new CocktailItem("AppleMartini",R.drawable.list0_1);
        list0.setWofy_id(R.drawable.list0_2);
        list0.setRecipe_id(R.drawable.list0_3);
        list0.setVideo("https://www.youtube.com/watch?v=z4yL2xrI0RY");
        //01
        CocktailItem list1 = new CocktailItem("B52",R.drawable.list1_1);
        list1.setWofy_id(R.drawable.list1_2);
        list1.setRecipe_id(R.drawable.list1_3);
        list1.setVideo("https://www.youtube.com/watch?v=UeDdWZLXf88");
        //02
        CocktailItem list2 = new CocktailItem("BlackRussian",R.drawable.list2_1);
        list2.setWofy_id(R.drawable.list2_2);
        list2.setRecipe_id(R.drawable.list2_3);
        list2.setVideo("https://www.youtube.com/watch?v=vr7qXrdnpPE");
        //03
        CocktailItem list3 = new CocktailItem("BlueHawaii",R.drawable.list3_1);
        list3.setWofy_id(R.drawable.list3_2);
        list3.setRecipe_id(R.drawable.list3_3);
        list3.setVideo("https://www.youtube.com/watch?v=n7qehacrf5A");
        //04
        CocktailItem list4 = new CocktailItem("Cosmopolitan",R.drawable.list4_1);
        list4.setWofy_id(R.drawable.list4_2);
        list4.setRecipe_id(R.drawable.list4_3);
        list4.setVideo("https://www.youtube.com/watch?v=Cf8ABwVh_5w");
        //05
        CocktailItem list5 = new CocktailItem("JuneBug",R.drawable.list5_1);
        list5.setWofy_id(R.drawable.list5_2);
        list5.setRecipe_id(R.drawable.list5_3);
        list5.setVideo("https://www.youtube.com/watch?v=upVTCwrsV8E");
        //06
        CocktailItem list6 = new CocktailItem("KahluaCoffee",R.drawable.list6_1);
        list6.setWofy_id(R.drawable.list6_2);
        list6.setRecipe_id(R.drawable.list6_3);
        list6.setVideo("https://www.youtube.com/watch?v=_Wg2Ed9UbZ8");
        //07
        CocktailItem list7 = new CocktailItem("LongIslandIcedTea",R.drawable.list7_1);
        list7.setWofy_id(R.drawable.list7_2);
        list7.setRecipe_id(R.drawable.list7_3);
        list7.setVideo("https://www.youtube.com/watch?v=fEXdP1M8yxU");
        //08
        CocktailItem list8 = new CocktailItem("Margarita",R.drawable.list8_1);
        list8.setWofy_id(R.drawable.list8_2);
        list8.setRecipe_id(R.drawable.list8_3);
        list8.setVideo("https://www.youtube.com/watch?v=MRcXtKSk7lo");
        //09
        CocktailItem list9 = new CocktailItem("Midorisour",R.drawable.list9_1);
        list9.setWofy_id(R.drawable.list9_2);
        list9.setRecipe_id(R.drawable.list9_3);
        list9.setVideo("https://www.youtube.com/watch?v=qW1dxZWxRi0");
        //10
        CocktailItem list10 = new CocktailItem("Mojito",R.drawable.list10_1);
        list10.setWofy_id(R.drawable.list10_2);
        list10.setRecipe_id(R.drawable.list10_3);
        list10.setVideo("https://www.youtube.com/watch?v=mIPMeIady3w");
        //11
        CocktailItem list11 = new CocktailItem("PeachCrush",R.drawable.list11_1);
        list11.setWofy_id(R.drawable.list11_2);
        list11.setRecipe_id(R.drawable.list11_3);
        list11.setVideo("https://www.youtube.com/watch?v=vJLhXLhQhs8");
        //12
        CocktailItem list12 = new CocktailItem("Pinacolada",R.drawable.list12_1);
        list12.setWofy_id(R.drawable.list12_2);
        list12.setRecipe_id(R.drawable.list12_3);
        list12.setVideo("https://www.youtube.com/watch?v=iv-uxM713q8");
        //13
        CocktailItem list13 = new CocktailItem("ScrewDriver",R.drawable.list13_1);
        list13.setWofy_id(R.drawable.list13_2);
        list13.setRecipe_id(R.drawable.list13_3);
        list13.setVideo("https://www.youtube.com/watch?v=P5V4JjsEyYE");
        //14
        CocktailItem list14 = new CocktailItem("Seabreeze",R.drawable.list14_1);
        list14.setWofy_id(R.drawable.list14_2);
        list14.setRecipe_id(R.drawable.list14_3);
        list14.setVideo("https://www.youtube.com/watch?v=R7N7DUY-Ksg");
        //15
        CocktailItem list15 = new CocktailItem("SexOnTheBeach",R.drawable.list15_1);
        list15.setWofy_id(R.drawable.list15_2);
        list15.setRecipe_id(R.drawable.list15_3);
        list15.setVideo("https://www.youtube.com/watch?v=KwkcKSwymro");
        //16
        CocktailItem list16 = new CocktailItem("TequilaSunrise",R.drawable.list16_1);
        list16.setWofy_id(R.drawable.list16_2);
        list16.setRecipe_id(R.drawable.list16_3);
        list16.setVideo("https://www.youtube.com/watch?v=9C2vUpCt8GQ");

        cocktailAdapter.addItem(list0);
        cocktailAdapter.addItem(list1);
        cocktailAdapter.addItem(list2);
        cocktailAdapter.addItem(list3);
        cocktailAdapter.addItem(list4);
        cocktailAdapter.addItem(list5);
        cocktailAdapter.addItem(list6);
        cocktailAdapter.addItem(list7);
        cocktailAdapter.addItem(list8);
        cocktailAdapter.addItem(list9);
        cocktailAdapter.addItem(list10);
        cocktailAdapter.addItem(list11);
        cocktailAdapter.addItem(list12);
        cocktailAdapter.addItem(list13);
        cocktailAdapter.addItem(list14);
        cocktailAdapter.addItem(list15);
        cocktailAdapter.addItem(list16);

        cocktail_lv.setAdapter(cocktailAdapter);
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
