package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class DangKyActivity extends AppCompatActivity {
private FirebaseAuth auth;
private EditText dangkyEmail, dangkyMK;
private Button  dangkyButton;
private TextView dangnhapRedirectText; 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        EdgeToEdge.enable( this );
        setContentView( R.layout.activity_dang_ky );
        auth = FirebaseAuth.getInstance();
        dangkyButton = findViewById( R.id.dangky_button );
        dangkyEmail = findViewById( R.id.dangky_email );
        dangkyMK = findViewById( R.id.dangky_password );
        dangnhapRedirectText = findViewById( R.id.dangnhapRedirectText );

        dangkyButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = dangkyEmail.getText().toString().trim();
                String pass = dangkyMK.getText().toString().trim();

                if (user.isEmpty()){
                    dangkyEmail.setError( "Email không được để trống!" );
                }
                if (pass.isEmpty()){
                    dangkyMK.setError( "Mật khẩu không được để trống!" );
                }else {
                    auth.createUserWithEmailAndPassword( user,pass ).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText( DangKyActivity.this, "Đăng ký thành công!", Toast.LENGTH_SHORT ).show();
                                startActivity( new Intent(DangKyActivity.this, LoginActivity.class) );
                            }else{
                                Toast.makeText( DangKyActivity.this,""+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    } );
                }
            }
        } );
        dangnhapRedirectText.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DangKyActivity.this, LoginActivity.class ) );
            }
        } );
    }
}