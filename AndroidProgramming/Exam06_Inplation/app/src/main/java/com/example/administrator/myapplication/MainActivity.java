package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayout itemContainer;
    private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemContainer = (LinearLayout) findViewById(R.id.itemContainer);
        layoutInflater = getLayoutInflater();
        fillItems();
    }

    public void fillItems(){
        List<Light> list = new ArrayList<>();
        list.add(new Light(R.drawable.light1,"인테리어 조명1","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light(R.drawable.light2,"인테리어 조명2","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light(R.drawable.light3,"인테리어 조명3","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light(R.drawable.light4,"인테리어 조명4","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light(R.drawable.light5,"인테리어 조명5","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));

        for(Light light : list){
            //Inplation
            LinearLayout itemLayout = (LinearLayout) layoutInflater.inflate(R.layout.light_item, null);

            //Data Setting
            ImageView lightImage = (ImageView) itemLayout.findViewById(R.id.lightImage);
            lightImage.setImageResource(light.getImage());

            TextView lightTitle = (TextView) itemLayout.findViewById(R.id.lightTitle);
            lightTitle.setText(light.getTitle());

            TextView lightContent = (TextView) itemLayout.findViewById(R.id.lightContent);
            lightTitle.setText(light.getContent());

            //itemContainer의 내부 객체로 추가
            itemContainer.addView(itemLayout);
        }

    }
}
