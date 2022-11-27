package com.example.becomputer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.becomputer.adapter.ProductAdapter;
import com.example.becomputer.model.Product;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {
    private RecyclerView rvProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        rvProduct = findViewById(R.id.rvProduct);
        initData();
    }

    private void initData() {
        Product product = new Product();
        {
            product.setId(1);
            product.setName("MAC Book 14 Inch");
            product.setPrice(1500.00);
            product.setCategory("Laptop");

            Product product1 = new Product();
            {
                product1.setId(2);
                product1.setName("Dell 15 inch");
                product1.setPrice(1800.00);
                product1.setCategory("Laptop");


                Product product2 = new Product();
                {
                    product2.setId(3);
                    product2.setName("Dell 15 inch");
                    product2.setPrice(1800.00);
                    product2.setCategory("Laptop");

                }
                Product product3 = new Product();
                {
                    product3.setId(4);
                    product3.setName("Dell 15 inch");
                    product3.setPrice(1800.00);
                    product3.setCategory("Laptop");

                    ArrayList<Product> productArrayList = new ArrayList<>();
                    productArrayList.add(product);
                    productArrayList.add(product1);
                    productArrayList.add(product2);
                    productArrayList.add(product3);



                    ProductAdapter adapter= new ProductAdapter(ProductActivity.this , productArrayList);
                    rvProduct.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL , false));
                    rvProduct.setAdapter(adapter);


                }

            }

        }


    }
}