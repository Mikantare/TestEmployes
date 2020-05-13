package com.example.zzap.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zzap.pojo.BrandPart;
import com.example.zzap.R;

import java.util.List;

public class BrandPartAdapter extends RecyclerView.Adapter<BrandPartAdapter.BrandPartViewHolder> {

    public List<BrandPart> brandParts;

    public void setBrandParts(List<BrandPart> brandParts) {
        this.brandParts = brandParts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BrandPartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_brand,parent,false);
        return new BrandPartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrandPartViewHolder holder, int position) {
        BrandPart brandPart = brandParts.get(position);
        holder.textViewNameToBrand.setText(brandPart.getClassCat());
        holder.textViewBrand.setText(brandPart.getClassMan());
    }

    @Override
    public int getItemCount() {
        return brandParts.size();
    }



class BrandPartViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageViewLogoBrand;
    private TextView textViewNameToBrand;
    private TextView textViewBrand;

    public BrandPartViewHolder(@NonNull View itemView) {
        super(itemView);
        imageViewLogoBrand = itemView.findViewById(R.id.imageViewLogoBrand);
        textViewNameToBrand = itemView.findViewById(R.id.textViewNameToBrand);
        textViewBrand = itemView.findViewById(R.id.textViewBrand);
    }
}
}
