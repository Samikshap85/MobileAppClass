package com.example.becomputer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.becomputer.adapter.FoodEntityAdapter;
import com.example.becomputer.app.App;
import com.example.becomputer.database.AppDatabase;
import com.example.becomputer.database.dao.FoodDao;
import com.example.becomputer.database.model.FoodEntity;
import com.example.becomputer.databinding.ActivityDatabaseBinding;

import java.util.ArrayList;

public class DatabaseActivity extends AppCompatActivity {

    private ActivityDatabaseBinding binding;
    private ArrayList<FoodEntity>foodEntityArrayList= new ArrayList<>();  // new arraylist ley empty array list assign gardinxa
    ////    private FoodDao foodDao;
    private FoodEntityAdapter adapter;
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDatabaseBinding.inflate(getLayoutInflater());
        View view = binding.getRoot(); //find view by id garnu pardaina binding garyo vani
        setContentView(view);
        setAppBar();

        binding.btnAddRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DatabaseActivity.this, "Button Clicked", Toast.LENGTH_LONG).show(); //call back fxn ho so this vanni kam gardaina
            }


        });
        binding.btnRemoveRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DatabaseActivity.this , AddRecordActivity.class);
               // Toast.makeText(DatabaseActivity.this, "Button Clicked", Toast.LENGTH_LONG).show(); //call back fxn ho so this vanni kam gardaina
                startActivity(intent);
            }
        });

        binding.rvRecords.setLayoutManager(new LinearLayoutManager( //seting recycler view layout or desgin
                this,
                LinearLayoutManager.VERTICAL,
                false
        ));
        foodEntityArrayList.addAll(App.foodDao.getAllItems());
        adapter = new FoodEntityAdapter(DatabaseActivity.this , foodEntityArrayList);
        binding.rvRecords.setAdapter(adapter);

        binding.rvRecords.setAdapter(adapter);
        binding.btnRemoveRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.foodDao.deleteAll();
            }
        });

    }

    private void setAppBar() {
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setTitle(R.string.txtAllFood);
        }
    }
}










//
//        db= App.db;
//        foodDao = db.foodDao();
//
//        FoodEntity food1= new FoodEntity();{
//            food1.setName("Burger");
//            food1.setFood_id(23);
//            food1.setPrice("250");
//            food1.setStatus("available");
//
//           // foodDao.insertItem(food1); //database ma entry gareko
//            foodDao.deleteItem(food1);
//            Log.d("TEST_FOOD" , "DB Record Size" + foodDao.getAllItems().size());
//        }
//    }
//}