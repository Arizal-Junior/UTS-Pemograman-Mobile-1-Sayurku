package com.example.sayurku;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import androidx.core.content.ContextCompat;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Metode yang dipanggil saat aktivitas dibuat
        super.onCreate(savedInstanceState); // Memanggil onCreate dari superclass
        setContentView(R.layout.activity_splash); // Menetapkan layout tampilan untuk aktivitas ini

        // Ubah warna status bar menjadi hijau
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.green));
        }

        // Menunda selama 3 detik sebelum pindah ke LoginActivity
        new Handler().postDelayed(() -> {
            // Pindah ke LoginActivity setelah 3 detik
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent); // Menjalankan aktivitas baru
            finish(); // Menutup SplashActivity agar tidak kembali saat tombol back ditekan
        }, 3000); // 3000 ms = 3 detik
    }
}
