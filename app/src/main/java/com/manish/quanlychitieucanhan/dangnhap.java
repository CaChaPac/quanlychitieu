package com.manish.quanlychitieucanhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class dangnhap extends AppCompatActivity {
    EditText taikhoan, matkhau;
    Button dangnhap, dangky;
    CheckBox checkbox;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangnhap);
        taikhoan= findViewById(R.id.taikhoan);
        matkhau= findViewById(R.id.matkhau);
        dangky= findViewById(R.id.dangky);
        dangnhap= findViewById(R.id.dangnhap);
        checkbox= findViewById(R.id.checkbox);
        preferences= getSharedPreferences("Người dùng",0);


        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tk= taikhoan.getText().toString();
                String mk= matkhau.getText().toString();
                String tkdadk= preferences.getString("taikhoan","");
                String mkdadk= preferences.getString("matkhau","");
                if(tk.equals(tkdadk)&&mk.equals(mkdadk)){
                    if(checkbox.isChecked()){

                        Boolean boolisChecked = checkbox.isChecked();
                        SharedPreferences.Editor editor=preferences.edit();
                        editor.putString("tài khoản",taikhoan.getText().toString());
                        editor.putString("mật khẩu", matkhau.getText().toString());
                        editor.putBoolean("kiểm tra",boolisChecked);
                        editor.apply();
                        Toast.makeText(dangnhap.this,"Người dùng đã được lưu"
                                ,Toast.LENGTH_SHORT).show();
                    }else {
                        preferences.edit().clear().apply();
                    }
                    Intent intent= new Intent(dangnhap.this, MainActivity.class);
                    startActivity(intent);
                }

                else {
                    Toast.makeText(dangnhap.this, "Tài khoản hoặc mật khẩu không hợp lệ",
                            Toast.LENGTH_SHORT).show();
                }


            }
        });
        /*checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String tk= taikhoan.getText().toString();
                String mk= matkhau.getText().toString();
                String tkdadk= preferences.getString("taikhoan","");
                String mkdadk= preferences.getString("matkhau","");
                if(tk.equals(tkdadk)&&mk.equals(mkdadk)){
                    if (checkbox.isChecked()){
                        Intent intent= new Intent(dangnhap.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });*/


        dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.manish.quanlychitieucanhan.dangnhap.this,com.manish.quanlychitieucanhan.dangky.class);
                startActivity(intent);
            }
        });

    }
}
