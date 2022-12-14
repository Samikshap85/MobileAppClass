package com.example.becomputer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.becomputer.app.App;
import com.example.becomputer.database.dao.FoodDao;
import com.example.becomputer.database.model.FoodEntity;
import com.example.becomputer.databinding.ActivityAddRecordBinding;

public class AddRecordActivity extends AppCompatActivity {
    private FoodDao dao;
    private ActivityAddRecordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddRecordBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
         setContentView(view);
         setAppBar();

         binding.btAdd.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                     FoodEntity food = new FoodEntity();
                     food.setFood_id(Integer.parseInt(binding.etFoodId.getText().toString()));
                     food.setName(binding.etName.getText().toString());
                     food.setPrice(binding.etPrice.getText().toString());
                     food.setPrice(binding.etPrice.getText().toString());

                     App.foodDao.insertItem(food);
                     Toast.makeText(AddRecordActivity.this , "Record Added" , Toast.LENGTH_SHORT).show();
                     finish();
                 

             }


         });

    }

    private void setAppBar() {
        if(getSupportActionBar() != null){
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle((R.string.txtAddRecord));
        }
    }
}