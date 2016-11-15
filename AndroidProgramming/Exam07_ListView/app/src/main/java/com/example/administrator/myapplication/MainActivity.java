package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /*private LinearLayout itemContainer;
    private LayoutInflater layoutInflater;*/

    private ListView lightList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*itemContainer = (LinearLayout) findViewById(R.id.itemContainer);
        layoutInflater = getLayoutInflater();*/

        lightList = (ListView) findViewById(R.id.lightList);
        fillItems();
    }

    public void fillItems(){
        List<Light> list = new ArrayList<>();
        list.add(new Light(R.drawable.light1,"인테리어 조명01","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light(R.drawable.light2,"인테리어 조명02","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light(R.drawable.light3,"인테리어 조명03","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light(R.drawable.light4,"인테리어 조명04","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light(R.drawable.light5,"인테리어 조명05","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light(R.drawable.light1,"인테리어 조명06","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light(R.drawable.light2,"인테리어 조명07","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light(R.drawable.light3,"인테리어 조명08","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light(R.drawable.light4,"인테리어 조명09","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light(R.drawable.light5,"인테리어 조명10","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));

        LightAdapter lightAdapter = new LightAdapter(this);
        lightAdapter.setList(list);

        lightList.setAdapter(lightAdapter);

        /*for(Light light : list){
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
        }*/

    }
}
