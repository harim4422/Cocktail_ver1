package and.harim.com.cocktail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class CocktailActivity extends AppCompatActivity {

    Spinner cocktail_spinner;
    ArrayAdapter<String> spin;
    String[] nothing={"업데이트 준비중 입니다.."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktail);

        cocktail_spinner =(Spinner)findViewById(R.id.cocktail_spinner);
        spin = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item,nothing);
        spin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cocktail_spinner.setAdapter(spin);//스피너 연결

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
