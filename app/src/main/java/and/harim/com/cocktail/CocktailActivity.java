package and.harim.com.cocktail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class CocktailActivity extends AppCompatActivity {

    Spinner cocktail_spinner;
    ArrayAdapter<String> spin;
    String[] nothing={"업데이트 준비중 입니다.."};

    ListView cocktail_lv;
    ArrayList<String> cocktail_list;
    CocktailAdapter cocktailAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktail);

        //스피너 연결
        cocktail_spinner =(Spinner)findViewById(R.id.cocktail_spinner);
        spin = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item,nothing);
        spin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cocktail_spinner.setAdapter(spin);

        cocktail_lv = (ListView)findViewById(R.id.cocktail_lv);
        cocktailAdapter = new CocktailAdapter();
        settingCocktailListView();
        cocktail_lv.setAdapter(cocktailAdapter);


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
        cocktailAdapter.addItem(new CocktailItem("AppleMartini",R.drawable.applemartini));
        cocktailAdapter.addItem(new CocktailItem("BlackRussian",R.drawable.blackrussian));
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
