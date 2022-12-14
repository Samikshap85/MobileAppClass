package com.example.becomputer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.becomputer.app.App;
import com.example.becomputer.database.AppDatabase;
import com.example.becomputer.database.dao.FoodDao;
import com.example.becomputer.database.model.FoodEntity;
import com.example.becomputer.databinding.ActivityDatabaseBinding;

public class DatabaseActivity extends AppCompatActivity {
    private ActivityDatabaseBinding binding;

    ////    private FoodDao foodDao;
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDatabaseBinding.inflate(getLayoutInflater());
        View view = binding.getRoot(); //find view by id garnu pardaina binding garyo vani
        setContentView(view);

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