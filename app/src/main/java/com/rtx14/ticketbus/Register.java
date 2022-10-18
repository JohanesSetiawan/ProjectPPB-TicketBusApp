package com.rtx14.ticketbus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    Button keLogin, btnRegister;
    EditText ed_email2, ed_password2;
    private FirebaseAuth mAuth;
    final String TAG = "Register";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        keLogin = findViewById(R.id.btnLogin_2);
        btnRegister = findViewById(R.id.btnRegister);
        ed_email2 = findViewById(R.id.edEmailRegister);
        ed_password2 = findViewById(R.id.edPasswordRegister);

        mAuth = FirebaseAuth.getInstance();

        keLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed_email2.getText().toString().isEmpty() || ed_password2.getText().toString().isEmpty()){
                    Toast.makeText(Register.this, "Email dan Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }else {
                    signUp(ed_email2.getText().toString(), ed_password2.getText().toString());
                }
            }
        });
    }

    public void signUp(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(Register.this, "Yeay, berhasil mendaftar sebagai: "+user.getEmail()+".", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Register.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Register.this, "Yah gagal, coba lagi yuk.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Register.this, Register.class);
                            startActivity(intent);
                            finish();
                        }
                    }
        });
    }
}