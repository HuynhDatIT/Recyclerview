package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<Food> mListfood;
    FoodAdapter mFoodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);
        mListfood = Food.getMock();
        mFoodAdapter = new FoodAdapter(mListfood);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mFoodAdapter);

        mFoodAdapter.setOnItemListener(new OnItemListener() {
            @Override
            public void OnItemClick(int position) {
                Toast.makeText(MainActivity.this,
                        "Xoa mon "+ mListfood.get(position).getName(), Toast.LENGTH_SHORT).show();
                //Xóa đối tượng trong listfood
                mListfood.remove(position);
                //Cập nhật hiển thị thay đổi trong Adapter
                mFoodAdapter.notifyDataSetChanged();
            }
        });
    }
}