package com.manish.quanlychitieucanhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class dangky extends AppCompatActivity {
    EditText taikhoan, matkhau, xacnhanmatkhau;
    Button dangky, thoat;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangky);
        taikhoan= findViewById(R.id.taikhoan);
        matkhau= findViewById(R.id.matkhau);
        dangky= findViewById(R.id.dangky);
        thoat= findViewById(R.id.thoat);
        xacnhanmatkhau= findViewById(R.id.xacnhanmatkhau);

        preferences= getSharedPreferences("Người dùng",0);

        dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tk= taikhoan.getText().toString();
                String mk= matkhau.getText().toString();
                String xnmk= xacnhanmatkhau.getText().toString();
                if (tk.length()!= 0 && mk.length()!=0&&xnmk.length()!=0){
                SharedPreferences.Editor editor= preferences.edit();
                editor.putString("taikhoan",tk);
                editor.putString("matkhau",mk);
                editor.putString("xacnhanmatkhau",xnmk);
                editor.apply();
                if(mk.compareTo(xnmk)==0){
                Toast.makeText(com.manish.quanlychitieucanhan.dangky.this, "Đăng ký thành công",
                        Toast.LENGTH_SHORT).show();
                 }
                else {
                    Toast.makeText(com.manish.quanlychitieucanhan.dangky.this,"Mật khẩu không trùng vui lòng nhập lại",
                            Toast.LENGTH_SHORT).show();
                }
                }
                else Toast.makeText(com.manish.quanlychitieucanhan.dangky.this,"Lỗi rồi! :((",
                        Toast.LENGTH_SHORT).show();
            }

        });
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
