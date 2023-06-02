package com.archproduct.model;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.archproduct.R;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {
    public final String TAG = "ProductsAdapter";
    Context context;
    List<ProductPojo> products;
    private OnFavouriteClickListener listener;
    int mode;

    public ProductsAdapter(Context context, List<ProductPojo> products, OnFavouriteClickListener _listener , int mode) {
        this.context = context;
        this.products = products;
        this.listener = _listener;
        this.mode = mode;
    }

    public void setList(List<ProductPojo> products){
        this.products = products;
        this.notifyDataSetChanged();
    }

    public interface OnFavouriteClickListener {
        void onClick(ProductPojo product);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView brand;
        private TextView description;
        private TextView price;
        private RatingBar rating;
        private ImageView thumbnail;
        private View layout;
        private ConstraintLayout constraintLayout;
        private Button favouriteBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView;
            title = itemView.findViewById(R.id.titleTv);
            brand = itemView.findViewById(R.id.brandTv);
            description = itemView.findViewById(R.id.descriptionTv);
            price = itemView.findViewById(R.id.priceTv);
            rating = itemView.findViewById(R.id.ratingBar);
            thumbnail = itemView.findViewById(R.id.imageView);
            constraintLayout = itemView.findViewById(R.id.constraintlayout);
            favouriteBtn = itemView.findViewById(R.id.favouriteBtn);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.custom_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        Log.i(TAG, "====== onCreateViewHolder ======");
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mode == 1 ){
            holder.favouriteBtn.setText("Delete From Favourite");
        }
        holder.title.setText(products.get(position).getTitle());
        holder.description.setText(products.get(position).getDescription());
        holder.brand.setText(products.get(position).getBrand());
        holder.rating.setRating((float) products.get(position).getRating());
        holder.price.setText(products.get(position).getPrice()+"");
        Glide.with(context)
                .load(products.get(position).getThumbnail())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.thumbnail);
        holder.favouriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(products.get(holder.getAdapterPosition()));
            }
        });
        Log.i(TAG, "====== onBindViewHolder ======");
    }

    @Override
    public int getItemCount() {
        return products.size();
    }


}
