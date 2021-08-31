package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
// Bước 1: Tạo lớp con FoodViewHolder trong lớp FoodAdapter
// Bước 2:
public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    List<Food> listFood;
    OnItemListener onItemListener; // Khởi tạo interface

    //Contrustor
    public FoodAdapter(List<Food> listFood){
        this.listFood = listFood;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Khai báo đối tượng convert layout sang view
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_food_2, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.FoodViewHolder holder, int position) {
        holder.onBindView(listFood.get(position));
    }

    @Override
    public int getItemCount() {
        return listFood.size();
    }

    class FoodViewHolder extends RecyclerView.ViewHolder {

       ImageView img;
       TextView txtViewName, txtViewPrice;
       ImageButton imgButtonDelete;

       public FoodViewHolder(@NonNull View itemView) {
           super(itemView);

           img = itemView.findViewById(R.id.imageView2);
           txtViewName = itemView.findViewById(R.id.textViewName2);
           txtViewPrice = itemView.findViewById(R.id.textViewPrice2);
           imgButtonDelete = itemView.findViewById(R.id.imgButtonDelete);

           imgButtonDelete.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if(onItemListener != null){
                       onItemListener.OnItemClick(getAdapterPosition());
                   }
               }
           });
       }

       public void onBindView( Food food){
           img.setImageResource(food.getImg());
           txtViewName.setText(food.getName());
           NumberFormat numberFormat = new DecimalFormat("#,### VND");
           txtViewPrice.setText(numberFormat.format(food.getPrice()));
       }
   }

   public void setOnItemListener(OnItemListener onItemListener){
        this.onItemListener = onItemListener;
   }

}
