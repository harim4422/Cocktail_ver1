package and.harim.com.cocktail;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView today_bar_image;
    ImageView today_cocktail_image;
    TextView today_bar_tv;
    TextView today_cocktail_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            Intent load = new Intent(this, LoadingActivity.class);
            load.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(load);


        today_bar_image = (ImageView)findViewById(R.id.today_bar_image);
        today_cocktail_image = (ImageView)findViewById(R.id.today_cocktail_image);
        today_bar_tv =(TextView)findViewById(R.id.today_bar_tv);
        today_cocktail_tv =(TextView)findViewById(R.id.today_cocktail_tv);

        today_bar_image.setImageResource(R.drawable.bar01);
        today_bar_tv.setText("독일주택");
        today_bar_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //투데이 식당 객체 생성
                BarItem list1 = new BarItem("독일주택","서울 종로구 대명1길 16-4(명륜4가 45-1)",5.0,R.drawable.bar01);
                String[] list1_menu ={"올드 라스푸틴 - 10000원","스컬핀 - 13000원","슈나이더 마인 호펜바이세 탭 - 12000원","독일플레이트 - 8000원"};
                list1.setMenu(list1_menu);
                Intent intent = new Intent(MainActivity.this,BarInfoActivity.class);
                intent.putExtra("item",list1);
                startActivity(intent);

            }
        });
        today_cocktail_tv.setText("BlackRussian");
        today_cocktail_image.setImageResource(R.drawable.list2_1);
        today_cocktail_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //투데이 칵테일 객체 생성
                CocktailItem list2 = new CocktailItem("BlackRussian",R.drawable.list2_1);
                list2.setWofy_id(R.drawable.list2_2);
                list2.setRecipe_id(R.drawable.list2_3);
                list2.setVideo("https://www.youtube.com/watch?v=vr7qXrdnpPE");
                Intent intent = new Intent(MainActivity.this,CocktailInfoActivity.class);
                intent.putExtra("cock",list2);
                startActivity(intent);
            }
        });




    } //메인 실행시 메소드

    public void clcik_menu(View view) {
        Intent menu = new Intent(this,MenuActivity.class);
        startActivity(menu);
    }//상단 메뉴 클릭시

    public void click_map(View view) {
        Intent map = new Intent(this,MapsActivity.class);
        startActivity(map);
    }//상단 지도 클릭시

    public void click_search(View view) {
        Intent search = new Intent(this,SearchActivity.class);
        startActivity(search);
    }//상단 검색 클릭시

    public void click_bar(View view) {
        Intent bar = new Intent(this,BarActivity.class);
        startActivity(bar);
    } //맛집 메뉴 클릭시

    public void click_cocktail(View view) {
        Intent cocktail = new Intent(this,CocktailActivity.class);
        startActivity(cocktail);
    }//칵테일 메뉴 클릭시

    public void click_rank(View view) {
        Intent rank = new Intent(this,RankActivity.class);
        startActivity(rank);
    } //순위 메뉴 클릭시

    public void click_recipe(View view) {
        Intent myIntent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://cafe.naver.com/multicocktail"));
        startActivity(myIntent);
    }//레시피 메뉴 클릭시

    public void click_back(View view) {
        showMessage();

    }//하단 뒤로가기 버튼 (종료)

    private void showMessage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Cocktail 종료");
        builder.setMessage("정말로 종료하시겠습니까?????");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.setNeutralButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }//뒤로가기 버튼 리스너(종료)

    public void click_home(View view) {
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }//하단 홈 버튼

    public void click_set(View view) {
        Intent menu = new Intent(this,SettingsActivity.class);
        startActivity(menu);
    }//하단 메뉴 버튼
}
