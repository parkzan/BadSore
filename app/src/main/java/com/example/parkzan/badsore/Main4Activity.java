package com.example.parkzan.badsore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

public class Main4Activity extends AppCompatActivity {
    public static final int REQUEST_QR_SCAN = 4;
    public String code="";
    String name[]={"user"};
    String resId[] = {"0757020777"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Customer customer = new Customer();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Button btn_scan = (Button)findViewById(R.id.btn_scan);
        final EditText input_code =(EditText)findViewById(R.id.input_code);
        final TextView textView = (TextView)findViewById(R.id.textView_35);

        Button btn_inputCode = (Button)findViewById(R.id.btn_inputCode);
        btn_inputCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                code = input_code.getText().toString();

                    if(code.equals("0757020777")) {
                        Intent intent = new Intent(Main4Activity.this, Main3Activity.class);
                        intent.putExtra("name",name[0]);
                        intent.putExtra("resId",resId[0]);
                        startActivity(intent);
                        finish();
                    }



            }
        });
        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =
                        new Intent("com.google.zxing.client.android.SCAN");
                startActivityForResult(Intent.createChooser(intent
                        , "Scan with"), REQUEST_QR_SCAN);

            }

        });


    }
    public void onActivityResult(int requestCode, int resultCode
            , Intent intent) {
        if (requestCode == REQUEST_QR_SCAN && resultCode == RESULT_OK) {
            String contents = intent.getStringExtra("SCAN_RESULT");

            if(contents.equals("0757020777")) {
                Intent intent2 = new Intent(Main4Activity.this, Main3Activity.class);
                intent2.putExtra("name_qrcode", name[0]);
                intent2.putExtra("resId_qrcode", resId[0]);
                startActivity(intent2);
                finish();
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id ==  android.R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
