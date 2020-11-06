package com.example.myapptest1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ShoppingBasket extends AppCompatActivity {

    private Button home;
    private Button purchase;
    private ImageView img_North;
    private ImageView img_Cover;
    private CheckBox check_North;
    private CheckBox check_Cover;
    private TextView txt_name_North;
    private TextView txt_name_Cover;
    private TextView txt_price_North;
    private TextView txt_price_Cover;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_basket);

        final Intent intent_shop2 = getIntent();
        String Case = getIntent().getStringExtra("Case");

        home = (Button)findViewById(R.id.button3);
        purchase = (Button)findViewById(R.id.button4);
        img_North = (ImageView)findViewById(R.id.img_North);
        img_Cover = (ImageView)findViewById(R.id.img_Cover);
        check_North = (CheckBox)findViewById(R.id.checkbox3);
        check_Cover = (CheckBox)findViewById(R.id.checkbox4);
        check_North.setVisibility(View.INVISIBLE);
        check_Cover.setVisibility(View.INVISIBLE);
        img_North.setVisibility(View.INVISIBLE);
        img_Cover.setVisibility(View.INVISIBLE);

        switch(Case) {
            case "both":
                img_North.setImageResource(R.drawable.northface);
                img_Cover.setImageResource(R.drawable.covernat);
                img_North.setVisibility(View.VISIBLE);
                img_Cover.setVisibility(View.VISIBLE);
                check_North.setVisibility(View.VISIBLE);
                check_Cover.setVisibility(View.VISIBLE);
                txt_name_North = (TextView)findViewById(R.id.txt_name_North);
                txt_name_Cover = (TextView)findViewById(R.id.txt_name_Cover);
                txt_price_North = (TextView)findViewById(R.id.txt_price_North);
                txt_price_Cover = (TextView)findViewById(R.id.txt_price_Cover);
                String str_name_North = intent_shop2.getStringExtra("north_name");
                String str_price_North = intent_shop2.getStringExtra("north_price");
                String str_name_Cover = intent_shop2.getStringExtra("cover_name");
                String str_price_Cover = intent_shop2.getStringExtra("cover_price");
                txt_name_North.setText(str_name_North);
                txt_name_Cover.setText(str_name_Cover);
                txt_price_North.setText(str_price_North);
                txt_price_Cover.setText(str_price_Cover);
                break;

            case "north":
                img_North.setImageResource(R.drawable.northface);
                img_North.setVisibility(View.VISIBLE);
                check_North.setVisibility(View.VISIBLE);
                txt_name_North = (TextView)findViewById(R.id.txt_name_North);
                txt_price_North = (TextView)findViewById(R.id.txt_price_North);
                String str_name_North1 = intent_shop2.getStringExtra("north_name");
                String str_price_North1 = intent_shop2.getStringExtra("north_price");
                txt_name_North.setText(str_name_North1);
                txt_price_North.setText(str_price_North1);
                break;

            case "cover":
                img_North.setImageResource(R.drawable.covernat);
                img_North.setVisibility(View.VISIBLE);
                check_North.setVisibility(View.VISIBLE);
                txt_name_North = (TextView)findViewById(R.id.txt_name_Cover);
                txt_price_North = (TextView)findViewById(R.id.txt_price_Cover);
                String str_name_Cover1 = intent_shop2.getStringExtra("cover_name");
                String str_price_Cover1 = intent_shop2.getStringExtra("cover_price");
                txt_name_North.setText(str_name_Cover1);
                txt_price_North.setText(str_price_Cover1);
                break;
        }

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_shop2home = new Intent(ShoppingBasket.this, MainActivity.class);
                startActivity(intent_shop2home);
            }
        });

        purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_shop2pur = new Intent(ShoppingBasket.this, Purchase.class);

                intent_shop2pur.putExtra("north_name", intent_shop2.getStringExtra("north_name"));
                intent_shop2pur.putExtra("north_price", intent_shop2.getStringExtra("north_price"));
                intent_shop2pur.putExtra("cover_name", intent_shop2.getStringExtra("cover_name"));
                intent_shop2pur.putExtra("cover_price", intent_shop2.getStringExtra("cover_price"));

                String Case0 = intent_shop2.getStringExtra("Case");
                switch(Case0) {
                    case "both":
                        if (check_North.isChecked() && check_Cover.isChecked()) {
                            intent_shop2pur.putExtra("Case", "both");
                            startActivity(intent_shop2pur);
                        }
                        else if (check_North.isChecked()) {
                            intent_shop2pur.putExtra("Case", "north");
                            startActivity(intent_shop2pur);
                        }
                        else if (check_Cover.isChecked()) {
                            intent_shop2pur.putExtra("Case", "cover");
                            startActivity(intent_shop2pur);
                        }
                        else {
                            Toast.makeText(ShoppingBasket.this, "상품이 선택되지 않았습니다.", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "north":
                        if (check_North.isChecked()) {
                            intent_shop2pur.putExtra("Case", "north");
                            startActivity(intent_shop2pur);
                        }
                        else {
                            Toast.makeText(ShoppingBasket.this, "상품이 선택되지 않았습니다.", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "cover":
                        if (check_North.isChecked()) {
                            intent_shop2pur.putExtra("Case", "cover");
                            startActivity(intent_shop2pur);
                        }
                        else {
                            Toast.makeText(ShoppingBasket.this, "상품이 선택되지 않았습니다.", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
            }
        });
    }
}