package com.example.myapptest1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button shopbasket;
    private Button purchase;
    private CheckBox CheckBoxNorth;
    private CheckBox CheckBoxCover;
//    private ImageButton NorthImage;
//    private ImageButton CoverImage;
    private TextView txt_name_North;
    private TextView txt_name_Cover;
    private TextView txt_price_North;
    private TextView txt_price_Cover;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shopbasket = (Button)findViewById(R.id.button); // 장바구니 버튼
        purchase = (Button)findViewById(R.id.button2); // 구매하기 버튼
        CheckBoxNorth = (CheckBox)findViewById(R.id.checkBox);
        CheckBoxCover = (CheckBox)findViewById(R.id.checkBox2);
        txt_name_North = (TextView)findViewById(R.id.textView4);
        txt_name_Cover = (TextView)findViewById(R.id.textView5);
        txt_price_North = (TextView)findViewById(R.id.textView3);
        txt_price_Cover = (TextView)findViewById(R.id.textView2);

        final Intent intent_shop = new Intent(MainActivity.this, ShoppingBasket.class);
        final Intent intent_pur = new Intent(MainActivity.this, Purchase.class);

        shopbasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent_shop.putExtra("north_name", txt_name_North.getText());
                intent_shop.putExtra("north_price", txt_price_North.getText());
                intent_shop.putExtra("cover_name", txt_name_Cover.getText());
                intent_shop.putExtra("cover_price", txt_price_Cover.getText());

                if(CheckBoxNorth.isChecked() && CheckBoxCover.isChecked()) {
                    intent_shop.putExtra("Case", "both");
                    startActivity(intent_shop); }
                else if(CheckBoxNorth.isChecked()){
                    intent_shop.putExtra("Case", "north");
                    startActivity(intent_shop);
                }
                else if(CheckBoxCover.isChecked()){
                    intent_shop.putExtra("Case", "cover");
                    startActivity(intent_shop);
                }
                else{
                    Toast.makeText(MainActivity.this, "상품이 선택되지 않았습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent_pur.putExtra("north_name", txt_name_North.getText());
                intent_pur.putExtra("north_price", txt_price_North.getText());
                intent_pur.putExtra("cover_name", txt_name_Cover.getText());
                intent_pur.putExtra("cover_price", txt_price_Cover.getText());

                if(CheckBoxNorth.isChecked()&&CheckBoxCover.isChecked()) {
                    intent_pur.putExtra("Case", "both");
                    startActivity(intent_pur); }
                else if(CheckBoxNorth.isChecked()){
                    intent_pur.putExtra("Case", "north");
                    startActivity(intent_pur);
                }
                else if(CheckBoxCover.isChecked()){
                    intent_pur.putExtra("Case", "cover");
                    startActivity(intent_pur);
                }
                else{
                    Toast.makeText(MainActivity.this, "상품이 선택되지 않았습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}