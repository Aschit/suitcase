package com.example.suitcase.Adapter;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suitcase.ItemModel;
import com.example.suitcase.R;

import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {
    private final RecyclerViewItemClickListener recyclerViewItemClickListener;
    private ArrayList<ItemModel> itemModels;

    public ItemsAdapter(RecyclerViewItemClickListener recyclerViewItemClickListener) {
        this.recyclerViewItemClickListener = recyclerViewItemClickListener;
        this.itemModels = itemModels;

    }



    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.ItemViewHolder holder, int position) {
        ItemModel itemModel = itemModels.get(position);
        holder.textViewName.setText(itemModel.getName());
        if (itemModel.isPurchased()) {
            holder.textViewName.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.baseline_check_24, 0);
        }
        holder.textViewPrice.setText(String.valueOf(itemModel.getPrice()));
        holder.textViewDescription.setText(itemModel.getDescription());
        Uri imageUri = itemModel.getImage();
        if (imageUri != null) {
            holder.imageView.setImageURI(imageUri);
        }


    }

    @Override
    public int getItemCount() {

        return itemModels.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewName, textViewPrice, textViewDescription;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_image);
            textViewName = itemView.findViewById(R.id.item_name);
            textViewPrice = itemView.findViewById(R.id.item_price);
            textViewDescription = itemView.findViewById(R.id.item_description);

            itemView.setOnClickListener(this::itemViewOnClick);


        }

        private void itemViewOnClick(View view) {
            recyclerViewItemClickListener.onItemClick(view, getAdapterPosition());

        }
    }
}

