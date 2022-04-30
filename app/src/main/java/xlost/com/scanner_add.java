package xlost.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class scanner_add extends AppCompatActivity {


    Button submit2_s, ViewAll, addGoods, addView, list_View_s,scan_button,Reminder_btn;
    EditText ItemName_s, ItemAmount_s,ExpirationDate_s,result;
    ListView FoodList;
    ArrayAdapter foodArrayAdapter;
    DataBaseHelper dataBaseHelper;
    FoodModel foodModel;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner_add);

        ItemAmount_s = findViewById(R.id.ItemAmount);
        ExpirationDate_s = findViewById(R.id.ExpirationDate);
        FoodList = findViewById(R.id.foodList);
        submit2_s = findViewById(R.id.submit2_s);
        dataBaseHelper = new DataBaseHelper(scanner_add.this);
        ItemName_s =findViewById(R.id.ItemName_s);








        submit2_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
       //         SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
       //         String s1 = sh.getString("newname", "");

      //          ItemName_s.setText(s1);

       //         String str = intent.getStringExtra("message");
       //         ItemName_s.setText(str);
                try {
                    foodModel = new FoodModel(-1,ItemName_s.getText().toString(),Integer.parseInt(ItemAmount_s.getText().toString()), Integer.parseInt(ExpirationDate_s.getText().toString()));
                    Toast.makeText(scanner_add.this, "Item added", Toast.LENGTH_SHORT).show();

                }
                catch (Exception e){
                    Toast.makeText(scanner_add.this, "A Error has been made please check your inputs", Toast.LENGTH_SHORT).show();
                    //     foodModel = new FoodModel(-1, "error",0,0);
                }


                DataBaseHelper dataBaseHelper = new DataBaseHelper(scanner_add.this);
                dataBaseHelper.addOne(foodModel);
                    ShowFoodList(dataBaseHelper);

            }
        });














    }
















    private void ShowFoodList(DataBaseHelper dataBaseHelper2) {
        // ArrayAdapter foodArrayAdapter = new ArrayAdapter<FoodModel>(MainActivity.this, android.R.layout.simple_list_item_1, dataBaseHelper2.getAll());

        ArrayAdapter foodArrayAdapter = new ArrayAdapter<FoodModel>(scanner_add.this, android.R.layout.select_dialog_item, dataBaseHelper2.getAll());
        FoodList.setAdapter(foodArrayAdapter);
    }











}