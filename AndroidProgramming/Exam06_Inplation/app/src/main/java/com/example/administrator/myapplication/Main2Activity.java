package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private LinearLayout itemContainer;
    private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        itemContainer = (LinearLayout) findViewById(R.id.itemContainer);
        layoutInflater = getLayoutInflater();
        fillItems();
    }
    public void fillItems(){
        int[] arrImage = {
                R.drawable.food01,
                R.drawable.food02,
                R.drawable.food03,
                R.drawable.food04,
                R.drawable.food05
        };


        String[] arrTitle = {
                "음식1",
                "음식2",
                "음식3",
                "음식4",
                "음식5"

        };

        String[] arrPrice = {
                "55,000 Won",
                "45,000 Won",
                "35,000 Won",
                "25,000 Won",
                "15,000 Won"

        };

        String[] arrContent = {
                "Information about popular Korean food dishes and local restaurant listings in the Tri-state area.",
                "Information about popular Korean food dishes and local restaurant listings in the Tri-state area.",
                "Information about popular Korean food dishes and local restaurant listings in the Tri-state area.",
                "Information about popular Korean food dishes and local restaurant listings in the Tri-state area.",
                "Information about popular Korean food dishes and local restaurant listings in the Tri-state area.",
                "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."
        };

        for(int i=0;i<5;i++){
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
        }
    }
}
