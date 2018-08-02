package and.harim.com.cocktail;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EpAdapter<T> extends ArrayAdapter<EpItem> {
    private final Activity activity;
    private final int ep_view;
    private final ArrayList<EpItem> ep_ary;

    public EpAdapter(
            Activity activity,
            int ep_view,
            ArrayList<EpItem> ep_ary) {
        super(activity,ep_view,ep_ary);
        this.activity = activity;
        this.ep_view = ep_view;
        this.ep_ary = ep_ary;
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
            convertView = inflater.inflate(ep_view,null);
        }
        EpItem info = ep_ary.get(position);
        TextView ep_name_tv = (TextView)convertView.findViewById(R.id.ep_name_tv);
        TextView ep_tv = (TextView)convertView.findViewById(R.id.ep_tv);
        ep_name_tv.setText(info.getEp_name());
        ep_tv.setText(info.getEp());

        return convertView;
    }//end getView(...)...
}//end SingerAdapter

