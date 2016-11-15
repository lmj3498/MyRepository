package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /*private LinearLayout itemContainer;
    private LayoutInflater layoutInflater;*/

    private ImageView imageLarge;
    private ListView lightList;
    private Button button2;
    private List<Light> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*itemContainer = (LinearLayout) findViewById(R.id.itemContainer);
        layoutInflater = getLayoutInflater();*/

        imageLarge = (ImageView) findViewById(R.id.imageLarge);
        lightList = (ListView) findViewById(R.id.lightList);
        lightList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Light light = list.get(position);
                imageLarge.setImageResource(light.getImageLarge());
            }
        });

        fillItems();

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    public void fillItems(){
        list = new ArrayList<>();
        list.add(new Light(R.drawable.light1, R.drawable.light1_large,"인테리어 조명01","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light(R.drawable.light2, R.drawable.light2_large, "인테리어 조명02","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light(R.drawable.light3, R.drawable.light3_large, "인테리어 조명03","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light(R.drawable.light4, R.drawable.light4_large, "인테리어 조명04","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light(R.drawable.light5, R.drawable.light5_large, "인테리어 조명05","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light(R.drawable.light1, R.drawable.light1_large, " 인테리어 조명06","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light(R.drawable.light2, R.drawable.light2_large, "인테리어 조명07","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light(R.drawable.light3, R.drawable.light3_large, "인테리어 조명08","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light(R.drawable.light4, R.drawable.light4_large, "인테리어 조명09","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light(R.drawable.light5, R.drawable.light5_large, "인테리어 조명10","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));

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

    public void onClickButton1(View view){
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }

}
