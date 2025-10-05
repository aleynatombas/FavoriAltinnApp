package com.aleynatombas.favorialtinnapp.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.aleynatombas.favorialtinnapp.R;
import com.aleynatombas.favorialtinnapp.models.GoldPrice;
import com.aleynatombas.favorialtinnapp.utils.Prefs;

import java.util.List;

public class GoldAdapter extends RecyclerView.Adapter<GoldAdapter.ViewHolder> {

    private List<GoldPrice> list;
    private Prefs prefs;
    private Context context;

    public GoldAdapter(Context context, List<GoldPrice> list, Prefs prefs) {
        this.context = context;
        this.list = list;
        this.prefs = prefs;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        ImageView imgHeart;

        public ViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            imgHeart = itemView.findViewById(R.id.imgHeart);
        }
    }

    @Override
    public GoldAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.gold_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final GoldPrice item = list.get(position);

        if (item != null && holder != null) {
            // Altın türü ve fiyat bilgilerini göster
            String displayText = (item.getName() != null ? item.getName() : "Bilinmeyen") + "\n";
            displayText += "Alış: " + item.getBuyPrice() + " ₺ | Satış: " + item.getSellPrice() + " ₺";
            holder.txtName.setText(displayText);

            // Favori durumunu kontrol et (Prefs içinde ID ile)
            boolean isFav = prefs != null && prefs.isFavorite(item.getId());
            holder.imgHeart.setImageResource(isFav ? R.drawable.ic_heart_filled : R.drawable.ic_heart_empty);

            // Favori tıklama işlemi
            holder.imgHeart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (prefs != null && item != null) {
                        if (prefs.isFavorite(item.getId())) {
                            prefs.removeFavorite(item.getId());
                        } else {
                            prefs.saveFavorite(item.getId());
                        }
                        notifyItemChanged(position);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }
}
