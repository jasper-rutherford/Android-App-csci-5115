package com.example.tamogatchi.goals.main;

/**
 * Created by karanjaswani on 1/12/18.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tamogatchi.R;

import java.util.List;

public class AddGoalsAdapter extends RecyclerView.Adapter<AddGoalsAdapter.ProductViewHolder> {

    String tempTxt;
    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<AddGoalsItem> productList;

    //getting the context and product list with constructor
    public AddGoalsAdapter(Context mCtx, List<AddGoalsItem> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.addgoals_item, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position
        AddGoalsItem product = productList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(product.getTitle());
        holder.textViewShortDesc.setText(product.getShortdesc());
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewRating;
        ProgressBar textViewProgress;
        ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            textViewProgress = itemView.findViewById(R.id.textViewProgress);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
