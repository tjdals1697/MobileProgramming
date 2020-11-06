package com.example.myapptest1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Purchase extends AppCompatActivity {

    private TextView pur_name1;
    private TextView pur_name2;
    private TextView pur_price1;
    private TextView pur_price2;
    private TextView pur_price_result;
    private Button button_pur2home; // 홈으로
    private Button button_purchase; // 결제하기
//    private PostalAddress user_Address;
//    private Phone user_Phone_num;
    private EditText Address;
    private EditText Phone_num;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        Intent intent_pur2 = getIntent();
        String Case1 = getIntent().getStringExtra("Case");

        pur_price_result = (TextView)findViewById(R.id.txt_price_result);
        button_pur2home = (Button)findViewById(R.id.button3);
        button_purchase = (Button)findViewById(R.id.button4);
        Address = (EditText)findViewById(R.id.user_Address);
        Phone_num = (EditText)findViewById(R.id.user_Phone_num);

        switch(Case1) {
            case "both":
                pur_name1 = (TextView)findViewById(R.id.txt_name_Purchase1);
                pur_name2 = (TextView)findViewById(R.id.txt_name_Purchase2);
                pur_price1 = (TextView)findViewById(R.id.txt_price_Purchase1);
                pur_price2 = (TextView)findViewById(R.id.txt_price_Purchase2);
                String str_name_North = intent_pur2.getStringExtra("north_name");
                String str_price_North = intent_pur2.getStringExtra("north_price");
                String str_name_Cover = intent_pur2.getStringExtra("cover_name");
                String str_price_Cover = intent_pur2.getStringExtra("cover_price");
                int price_north = Integer.parseInt(str_price_North);
                int price_cover = Integer.parseInt(str_price_Cover);
                pur_name1.setText(str_name_North);
                pur_name2.setText(str_name_Cover);
                pur_price1.setText(str_price_North);
                pur_price2.setText(str_price_Cover);
                int result = price_north + price_cover;
                pur_price_result.setText(String.valueOf(result));
                break;
            case "north":
                pur_name1 = (TextView)findViewById(R.id.txt_name_Purchase1);
                pur_price1 = (TextView)findViewById(R.id.txt_price_Purchase1);
                String str_name_North1 = intent_pur2.getStringExtra("north_name");
                String str_price_North1 = intent_pur2.getStringExtra("north_price");
                pur_name1.setText(str_name_North1);
                pur_price1.setText(str_price_North1);
                pur_price_result.setText(String.valueOf(str_price_North1));
                break;
            case "cover":
                pur_name2 = (TextView)findViewById(R.id.txt_name_Purchase1);
                pur_price2 = (TextView)findViewById(R.id.txt_price_Purchase1);
                String str_name_Cover1 = intent_pur2.getStringExtra("cover_name");
                String str_price_Cover1 = intent_pur2.getStringExtra("cover_price");
                pur_name2.setText(str_name_Cover1);
                pur_price2.setText(str_price_Cover1);
                pur_price_result.setText(String.valueOf(str_price_Cover1));
                break;
        }


        button_pur2home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_pur2home = new Intent(Purchase.this, MainActivity.class);
                Toast.makeText(Purchase.this, "구매가 취소되었습니다.", Toast.LENGTH_SHORT).show();
                startActivity(intent_pur2home);
            }
        });

        button_purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_purchase = new Intent(Purchase.this, MainActivity.class);

                if (Address.getText().toString().length() < 5 && Phone_num.getText().toString().length() < 5) {
                    Toast.makeText(Purchase.this, "유효한 주소와 번호를 기재해주세요.", Toast.LENGTH_SHORT).show();
                }
                else if (Address.getText().toString().length() < 5) {
                    Toast.makeText(Purchase.this, "유효한 주소를 기재해주세요.", Toast.LENGTH_SHORT).show();
                }
                else if (Phone_num.getText().toString().length() < 5) {
                    Toast.makeText(Purchase.this, "유효한 핸드폰 번호를 기재해주세요.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Purchase.this, "결제되었습니다.", Toast.LENGTH_SHORT).show();
                    startActivity(intent_purchase);
                }
            }
        });
    }
}