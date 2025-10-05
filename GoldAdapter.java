package com.aleynatombas.favorialtinnapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GoldAdapter extends RecyclerView.Adapter<GoldAdapter.ViewHolder> {
    private List<AltinItem> list;
    private Prefs prefs;
    private Context context;

    public GoldAdapter(Context context, List<AltinItem> list, Prefs prefs) {
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
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final AltinItem item = list.get(position);
        
        if (item != null) {
            // Altın türünü ve fiyatları göster
            String displayText = item.getTur() + "\n";
            if (item.getAlis() != null && item.getSatis() != null) {
                displayText += "Alış: " + item.getAlis() + " ₺ | Satış: " + item.getSatis() + " ₺";
            }
            holder.txtName.setText(displayText);

            // Favori durumunu kontrol et
            int id = position; // Pozisyonu ID olarak kullan
            boolean isFav = prefs != null && prefs.isFavorite(id);
            holder.imgHeart.setImageResource(isFav ? R.drawable.ic_heart_filled : R.drawable.ic_heart_empty);

            // Favori tıklama işlemi
            holder.imgHeart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (prefs != null) {
                        if (prefs.isFavorite(id)) {
                            prefs.removeFavorite(id);
                        } else {
                            prefs.saveFavorite(id);
                        }
                        notifyItemChanged(holder.getAdapterPosition());
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
