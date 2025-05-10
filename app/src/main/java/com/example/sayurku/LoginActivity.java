package com.example.sayurku;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

public class LoginActivity extends Activity {

    EditText usernameInput, passwordInput; // Deklarasi field untuk input username dan password
    Button loginButton; // Deklarasi tombol login
    TextView registerLink; // Deklarasi teks link ke halaman registrasi

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Method yang dipanggil saat activity dibuat
        super.onCreate(savedInstanceState); // Memanggil onCreate dari superclass
        setContentView(R.layout.activity_login); // Menetapkan layout tampilan untuk aktivitas ini

        // Ubah warna status bar menjadi hijau
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.green));
        }

        // Inisialisasi komponen dari layout
        usernameInput = findViewById(R.id.usernameInput); // Ambil input username dari layout
        passwordInput = findViewById(R.id.passwordInput); // Ambil input password dari layout
        loginButton = findViewById(R.id.loginButton); // Ambil tombol login dari layout
        registerLink = findViewById(R.id.registerLink); // Ambil teks link registrasi dari layout

        // Menangani klik tombol login
        loginButton.setOnClickListener(v -> {
            String username = usernameInput.getText().toString(); // Ambil teks dari input username
            String password = passwordInput.getText().toString(); // Ambil teks dari input password

            // Cek apakah username dan password sesuai
            if (username.equals("Arizal Junior") && password.equals("1234")) {
                Toast.makeText(LoginActivity.this, "Login berhasil", Toast.LENGTH_SHORT).show(); // Tampilkan pesan berhasil
                startActivity(new Intent(LoginActivity.this, ListChatActivity.class)); // Pindah ke ListChatActivity
            } else {
                Toast.makeText(LoginActivity.this, "Login gagal", Toast.LENGTH_SHORT).show(); // Tampilkan pesan gagal
            }
        });

        // Menangani klik teks registrasi
        registerLink.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class); // Intent untuk pindah ke RegisterActivity
            startActivity(intent); // Jalankan aktivitas registrasi
        });
    }
}
