package and.harim.com.cocktail;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent load = new Intent(this,LoadingActivity.class);
        startActivity(load);
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
        Intent menu = new Intent(this,MenuActivity.class);
        startActivity(menu);
    }//하단 메뉴 버튼
}
