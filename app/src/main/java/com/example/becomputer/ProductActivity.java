package com.example.becomputer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.becomputer.adapter.ProductAdapter;
import com.example.becomputer.api.ApiClient;
import com.example.becomputer.api.ApiInterface;
import com.example.becomputer.model.Product;
import com.example.becomputer.response.FoodResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductActivity extends AppCompatActivity {
    private RecyclerView rvProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        rvProduct = findViewById(R.id.rvProduct);
        initData(); //initialize data
    }

    private void initData() {
//        Product product = new Product();
//        {
//            product.setId(1);
//            product.setName("MAC Book 14 Inch");
//            product.setPrice(1500.00);
//            product.setCategory("Laptop");
//
//            Product product1 = new Product();
//            {
//                product1.setId(2);
//                product1.setName("Dell 15 inch");
//                product1.setPrice(1800.00);
//                product1.setCategory("Laptop");
//
//
//                Product product2 = new Product();
//                {
//                    product2.setId(3);
//                    product2.setName("Dell 15 inch");
//                    product2.setPrice(1800.00);
//                    product2.setCategory("Laptop");
//
//                }
//                Product product3 = new Product();
//                {
//                    product3.setId(4);
//                    product3.setName("Dell 15 inch");
//                    product3.setPrice(1800.00);
//                    product3.setCategory("Laptop");
//
//                    ArrayList<Product> productArrayList = new ArrayList<>();
//                    productArrayList.add(product);
//                    productArrayList.add(product1);
//                    productArrayList.add(product2);
//                    productArrayList.add(product3);
//


        ApiInterface apiInterfacee = ApiClient.getClient().create(ApiInterface.class);
        Call<FoodResponse> call = apiInterfacee.getFood();
        call.enqueue(new Callback<FoodResponse>() {
            @Override
            public void onResponse(Call<FoodResponse> call, Response<FoodResponse> response) {
                FoodResponse rs = response.body();
                if(rs.isSuccess()){
                    ProductAdapter adapter= new ProductAdapter(ProductActivity.this , rs.getData());
                    rvProduct.setLayoutManager(new LinearLayoutManager(ProductActivity.this,LinearLayoutManager.VERTICAL , false));
                    rvProduct.setAdapter(adapter);
                }
                else{
                    Toast.makeText(ProductActivity.this, rs.getMessage() , Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<FoodResponse> call, Throwable t) {

                Toast.makeText(ProductActivity.this, t.getMessage() , Toast.LENGTH_LONG).show();

            }
        }); //running in queue //using retrofit the api will run in background by itself





                }

            }

