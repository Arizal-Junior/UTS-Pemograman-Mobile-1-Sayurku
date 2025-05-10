package com.example.sayurku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
public class CustomAdapter extends BaseAdapter {

    Context context; // Context dari activity pemanggil
    String[] titles; // Array judul (nama pengirim)
    String[] subtitles; // Array subjudul (pesan/chat)
    int[] images; // Array gambar
    LayoutInflater inflater; // Untuk mengubah XML layout menjadi objek View

    // Konstruktor untuk menginisialisasi data dan context
    public CustomAdapter(Context context, String[] titles, String[] subtitles, int[] images) {
        this.context = context;
        this.titles = titles;
        this.subtitles = subtitles;
        this.images = images;
        inflater = LayoutInflater.from(context); // Membuat inflater dari context
    }

    // Mengembalikan jumlah item yang akan ditampilkan di ListView
    @Override
    public int getCount() {
        return titles.length;
    }

    // Mengembalikan item di posisi tertentu
    @Override
    public Object getItem(int position) {
        return titles[position];
    }

    // Mengembalikan ID unik item (di sini hanya posisi)
    @Override
    public long getItemId(int position) {
        return position;
    }

    // ViewHolder adalah pola efisiensi untuk menghindari pemanggilan findViewById berulang
    static class ViewHolder {
        ImageView avatarImage; // Gambar avatar
        TextView titleText; // Teks judul (nama)
        TextView subText; // Teks subjudul (pesan)
    }

    // Fungsi untuk menghasilkan tampilan item pada posisi tertentu
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        // Jika convertView masih null, buat tampilan baru dari layout XML
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_chat, parent, false); // Inflate layout item_chat.xml
            holder = new ViewHolder();
            holder.avatarImage = convertView.findViewById(R.id.avatarImage); // Hubungkan ImageView
            holder.titleText = convertView.findViewById(R.id.titleText); // Hubungkan TextView judul
            holder.subText = convertView.findViewById(R.id.subText); // Hubungkan TextView subjudul
            convertView.setTag(holder); // Simpan ViewHolder dalam tag untuk efisiensi
        } else {
            holder = (ViewHolder) convertView.getTag(); // Gunakan ViewHolder lama jika sudah ada
        }

        // Set data ke elemen tampilan
        holder.avatarImage.setImageResource(images[position]); // Tampilkan gambar
        holder.titleText.setText(titles[position]); // Tampilkan judul
        holder.subText.setText(subtitles[position]); // Tampilkan subjudul

        return convertView; // Kembalikan tampilan item
    }
}
