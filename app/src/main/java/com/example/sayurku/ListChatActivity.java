package com.example.sayurku;

import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class ListChatActivity extends AppCompatActivity {

    ListView chatListView; // Deklarasi ListView untuk menampilkan daftar chat
    String[] titles = {"Ijlal", "Agis", "Lita", "Lyra", "Sohee", // Data dummy: nama pengirim chat
            "Anton", "Sunoo", "Ray", "lie", "Hyu"};
    String[] subtitles = {"Aplikasinya bagus!", "Sangat membantu!", "kantung kertas buat sayurannya bagus.", "Sayurannya selalu restock!.", "Pakai aplikasi ini untuk pesan sayuran jadi mudah.",
            "mas kurirnya baik-baik gais!", "Tote-Bag buat sayurnya lucu bangett.", "Ngebantu banget!!", "Sayurannya segar!", "aku suka aplikasi ini."}; // Data dummy: isi pesan
    int[] images = {R.drawable.tomat, R.drawable.tomat, R.drawable.tomat, // Gambar profil (semua menggunakan gambar yang sama: tomat)
            R.drawable.tomat, R.drawable.tomat, R.drawable.tomat,
            R.drawable.tomat, R.drawable.tomat, R.drawable.tomat, R.drawable.tomat};

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Dipanggil saat activity dibuat
        super.onCreate(savedInstanceState); // Memanggil onCreate dari superclass
        setContentView(R.layout.activity_list_chat); // Mengatur layout activity

        if (Build.VERSION.SDK_INT >= 21) { // Ubah warna status bar jadi hijau
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.green));
        }

        chatListView = findViewById(R.id.chatListView); // Menghubungkan ListView dengan layout

        // Membuat instance dari custom adapter dan mengaturnya ke ListView
        CustomAdapter adapter = new CustomAdapter(this, titles, subtitles, images); // Adapter kustom untuk mengatur item daftar
        chatListView.setAdapter(adapter); // Mengatur adapter ke ListView
    }
}
