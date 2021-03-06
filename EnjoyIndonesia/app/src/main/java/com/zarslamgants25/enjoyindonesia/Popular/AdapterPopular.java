package com.zarslamgants25.enjoyindonesia.Popular;

import android.content.Context;
import android.media.Image;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zarslamgants25.enjoyindonesia.Databases.ParsingGson5;
import com.zarslamgants25.enjoyindonesia.R;

import java.util.List;

/**
 * Created by WIN10 on 23/03/2017.
 */

public class AdapterPopular extends RecyclerView.Adapter<AdapterPopular.ViewHolder> {

    private List<ParsingGson5.DataPopular> listPopulars;
    private Context context;

    public AdapterPopular(FragmentActivity listPopulars, List<ParsingGson5.DataPopular> context) {
      this.listPopulars = context;
        this.context = listPopulars;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_popular, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvNamaWisata.setText(listPopulars.get(position).judul_wisata2);
        holder.tvJenisWisata.setText(listPopulars.get(position).nama_kategori_wisata);
        holder.tvLokasi.setText(listPopulars.get(position).nama_kota_kabupaten);
        Glide.with(context)
                .load(listPopulars.get(position).url_gambar2)
                .crossFade()
                .placeholder(R.drawable.ic_photo_size_select_actual_black_24dp)
                .into(holder.imageViewPopular);


    }

    @Override
    public int getItemCount() {
        return listPopulars.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvNamaWisata;
        public TextView tvLokasi;
        public TextView tvJenisWisata;
        public ImageView imageViewPopular;

        public ViewHolder(View itemView) {
            super(itemView);

            tvNamaWisata = (TextView)itemView.findViewById(R.id.tvNamaWisata);
            tvLokasi = (TextView)itemView.findViewById(R.id.lokasi);
            tvJenisWisata = (TextView)itemView.findViewById(R.id.jenis_wisata);
            imageViewPopular = (ImageView)itemView.findViewById(R.id.image_wisata);
        }
    }
}
