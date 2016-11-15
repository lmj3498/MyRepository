package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private ImageView imageLarge;
    private ListView foodList;
    private List<Food> list;

    //private LinearLayout itemContainer;
    //private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //itemContainer = (LinearLayout) findViewById(R.id.itemContainer);
        //layoutInflater = getLayoutInflater();

        fillItems();
    }
    public void fillItems(){

        list = new ArrayList<>();
        list.add(new Food(R.drawable.food01, R.drawable.food01_large,"음식1","55,000 Won","Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food(R.drawable.food02, R.drawable.food02_large,"음식2","45,000 Won" ,"Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food(R.drawable.food03, R.drawable.food03_large,"음식3","35,000 Won", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food(R.drawable.food04, R.drawable.food04_large,"음식4","25,000 Won", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food(R.drawable.food05, R.drawable.food05_large,"음식5","15,000 Won", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food(R.drawable.food01, R.drawable.food01_large,"음식1","55,000 Won", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food(R.drawable.food02, R.drawable.food02_large,"음식2","45,000 Won", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food(R.drawable.food03, R.drawable.food03_large,"음식3","35,000 Won", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food(R.drawable.food04, R.drawable.food04_large,"음식4","25,000 Won", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food(R.drawable.food05, R.drawable.food05_large,"음식5","15,000 Won", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));

        FoodAdapter foodAdapter = new FoodAdapter(this);
        foodAdapter.setList(list);

        foodList.setAdapter(foodAdapter);

        /*for(int i=0;i<5;i++){
            //Inplation
            LinearLayout itemLayout = (LinearLayout) layoutInflater.inflate(R.layout.food_item, null);

            //Data Setting
            ImageView foodImage = (ImageView) itemLayout.findViewById(R.id.foodImage);
            foodImage.setImageResource(arrImage[i]);

            TextView foodTitle = (TextView) itemLayout.findViewById(R.id.foodTitle);
            foodTitle.setText(arrTitle[i]);

            TextView foodPrice = (TextView) itemLayout.findViewById(R.id.foodPrice);
            foodPrice.setText(arrPrice[i]);

            TextView foodContent = (TextView) itemLayout.findViewById(R.id.foodContent);
            foodContent.setText(arrContent[i]);

            //itemContainer의 내부 객체로 추가
            itemContainer.addView(itemLayout);
        }*/
    }
}
