package com.example.recyclerview;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Food {
    private String name;
    private int img;
    private long price;

    public Food(String name, int img, long price) {
        this.name = name;
        this.img = img;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", img=" + img +
                ", price=" + price +
                '}';
    }
    //Data giả
    // Lưu ý: List chỉ là interface không thể thực hiện thêm xóa sửa.
    public static List<Food> getMock(){
        //new ra đối tượng ArrayList để thực hiện thêm xóa sửa
        return new ArrayList<>(Arrays.asList(
                new Food("Trà sữa", R.drawable.hinh_tra_sua, 50000),
                new Food("Món cơm sườn", R.drawable.hinh_com_suon,50000),
                new Food("Món bún đậu", R.drawable.hinh_bun_dau, 50000),
                new Food("Món cơm sườn", R.drawable.hinh_com_suon,50000)
        ));
    }
}
