package com.example.becomputer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.becomputer.R;
import com.example.becomputer.api.Api;
import com.example.becomputer.model.Food;
import com.example.becomputer.model.Product;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private Context context;
    private ArrayList<Food> productArrayList;

    public ProductAdapter(Context context , ArrayList<Food> productArrayList){
        this.context = context;
        this.productArrayList=productArrayList;
    }



    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.row_product,parent ,false);
        return  new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Food item = productArrayList.get(position);
        holder.tvName.setText(item.getName());
        holder.tvPrice.setText(String.valueOf(item.getPrice()));
        Glide.with(context)
                .load(Api.BASE_URL+item.getUrl())
                .placeholder(R.drawable.emoty)
                .into(holder.ivProduct);

    }

    @Override
    public int getItemCount() {

        return productArrayList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivProduct;
        private TextView tvName , tvPrice;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProduct = itemView.findViewById(R.id.ivProduct);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);

        }
    }
}
