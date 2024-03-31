package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText dangnhapEmail, dangnhapMK;
    private Button dangnhapButton;
    private TextView dangkyRedirectText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        EdgeToEdge.enable( this );
        setContentView( R.layout.activity_login );
        auth = FirebaseAuth.getInstance();
        dangnhapEmail = findViewById( R.id.login_email );
        dangnhapMK = findViewById( R.id.login_password );
        dangnhapButton = findViewById( R.id.login_button );
        dangkyRedirectText = findViewById( R.id.dangkyRedirectText );

        dangnhapButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = dangnhapEmail.getText(  ).toString();
                String pass = dangnhapMK.getText().toString();

                if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher( email).matches(  ) ){
                    if(!pass.isEmpty()){
                        auth.signInWithEmailAndPassword( email,pass ).addOnSuccessListener( new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult result) {
                                Toast.makeText( LoginActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT ).show();
                                startActivity( new Intent(LoginActivity.this, MainActivity.class) );
                                finish();
                            }
                        } ).addOnFailureListener( new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText( LoginActivity.this, "Đăng nhâp thất bại!", Toast.LENGTH_SHORT ).show();
                            }
                        } );
                    }else {
                        dangnhapMK.setError( "Mật khẩu không được để trống!" );
                    }
                }else if(email.isEmpty()){
                    dangnhapEmail.setError( "Tài khoản không được để trống!" );
                }else {
                    dangnhapEmail.setError( "Vui lòng nhập email hợp lệ!" );
                }
            }
        } );
        dangkyRedirectText.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(LoginActivity.this, DangKyActivity.class) );
            }
        } );
    }
}