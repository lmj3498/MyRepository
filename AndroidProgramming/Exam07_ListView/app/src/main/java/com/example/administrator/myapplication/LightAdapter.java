package com.example.administrator.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class LightAdapter extends BaseAdapter{

    private List<Light> list;
    public void setList(List<Light> list) {
        this.list = list;
    }

    private Context context;
    private LayoutInflater layoutInflater;

    public LightAdapter(Context context){
        this.context = context;//context는 추상클래스로서 Activity는 이를 구현하고 있는 구현클래스, 그러므로 범용적으로 어댑터를 쓰기 위해 context를 주입함
        layoutInflater = LayoutInflater.from(context);
    }

    //데이터의 갯수가 뭐냐
    @Override
    public int getCount() {
        return list.size();
    }

    //해당 position의 위치의 객체가 뭐냐
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    //position 위치의 식별번호가 뭐냐
    @Override
    public long getItemId(int position) {
        return position;//리스트 상의 인덱스를 뜻함, 다른 객체와 식별할 수 있는 값, 만약 board객체의 bno같은 식별가능한 필드가 있으면 그걸 리턴하면 됨
    }

    //재사용할게 없는 데이터 필요한 상태라서 새롭게 객체를 추가할 것인지,객체를 재사용하기 위해 데이터만 세팅할 것인지
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {//position : list 순번 , convertView : 재사용되는 ListView의 아이템, parent : ListView
        //null이면 재사용할게 없으니 새로 만듬, null이 아니면 재사용하므로 바꿔치기
        if(convertView == null){
            //inplation
            convertView = layoutInflater.inflate(R.layout.light_item, null);
        }
        //data setting
        Light light = list.get(position);
        ImageView lightImage = (ImageView) convertView.findViewById(R.id.lightImage);
        lightImage.setImageResource(light.getImage());

        TextView lightTitle = (TextView) convertView.findViewById(R.id.lightTitle);
        lightTitle.setText(light.getTitle());

        TextView lightContent = (TextView) convertView.findViewById(R.id.lightContent);
        lightContent.setText(light.getContent());

        return convertView;
    }
}
