package com.example.sayurku;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

public class RegisterActivity extends Activity {

    EditText nameInput, emailInput, passwordInput; // Deklarasi input nama, email, dan password
    Button registerButton; // Deklarasi tombol register

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Method yang dipanggil saat activity dibuat
        super.onCreate(savedInstanceState); // Memanggil onCreate dari superclass
        setContentView(R.layout.activity_register); // Mengatur tampilan activity menggunakan layout activity_register.xml

        // Ubah warna status bar menjadi hijau
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.green));
        }

        // Inisialisasi elemen UI dari layout
        nameInput = findViewById(R.id.nameInput); // Ambil input nama
        emailInput = findViewById(R.id.emailInput); // Ambil input email
        passwordInput = findViewById(R.id.passwordInput); // Ambil input password
        registerButton = findViewById(R.id.registerButton); // Ambil tombol register

        // Menangani klik tombol register
        registerButton.setOnClickListener(v -> {
            String name = nameInput.getText().toString(); // Ambil teks dari input nama
            String email = emailInput.getText().toString(); // Ambil teks dari input email
            String password = passwordInput.getText().toString(); // Ambil teks dari input password

            Log.d("RegisterActivity", "Nama: " + name + ", Email: " + email); // Tampilkan data di log untuk keperluan debugging

            Toast.makeText(RegisterActivity.this, "Daftar Berhasil", Toast.LENGTH_SHORT).show(); // Tampilkan pesan bahwa pendaftaran berhasil
            Toast.makeText(RegisterActivity.this, "Silahkan login", Toast.LENGTH_SHORT).show(); // Tampilkan pesan lanjut ke login

            // Selesai register, kembali ke login
            finish();
        });
    }
}
