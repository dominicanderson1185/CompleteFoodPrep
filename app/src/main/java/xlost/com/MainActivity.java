package xlost.com;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submit, ViewAll, addGoods, addView, List_View,scan_button,Reminder_btn,scanner_add;
    EditText ItemName, ItemAmount,ExpirationDate;
    ListView FoodList;
    ArrayAdapter foodArrayAdapter;
    DataBaseHelper dataBaseHelper;
    FoodModel foodModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button add_view = findViewById(R.id.addView);
        Button List_View = findViewById(R.id.List_View);
        Button Reminder_btn = findViewById(R.id.Reminder_btn);
        Button scan_button = findViewById(R.id.scan_button);
        submit = findViewById(R.id.submit);
        ItemName = findViewById(R.id.ItemName);
        ItemAmount = findViewById(R.id.ItemAmount);
        ExpirationDate = findViewById(R.id.ExpirationDate);
        FoodList = findViewById(R.id.foodList);
        dataBaseHelper = new DataBaseHelper(MainActivity.this);

    //    ShowFoodList(dataBaseHelper);

        DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    foodModel = new FoodModel(-1,ItemName.getText().toString(),Integer.parseInt(ItemAmount.getText().toString()), Integer.parseInt(ExpirationDate.getText().toString()));
                    Toast.makeText(MainActivity.this, "Item added", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "A Error has been made please check your inputs", Toast.LENGTH_SHORT).show();
               //     foodModel = new FoodModel(-1, "error",0,0);
                }


                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);

                dataBaseHelper.addOne(foodModel);
           //     ShowFoodList(dataBaseHelper);

            }
        });

        scan_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent theIntent = new Intent(getApplicationContext(), Scanner.class);
                startActivity(theIntent);
            }
        });


        List_View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent theIntent = new Intent(getApplicationContext(), View_All.class);
                startActivity(theIntent);
            }
        });

        add_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
                    ShowFoodList(dataBaseHelper);
                } catch (Exception e){
                }

            }
        });
/*
scan_button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity(new Intent(getApplicationContext(),Scanner.class));
    }
});
*/

Reminder_btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent theIntent = new Intent(getApplicationContext(), Reminder.class);
        startActivity(theIntent);
    }


});








    }

    private void ShowFoodList(DataBaseHelper dataBaseHelper2) {
       // ArrayAdapter foodArrayAdapter = new ArrayAdapter<FoodModel>(MainActivity.this, android.R.layout.simple_list_item_1, dataBaseHelper2.getAll());

        ArrayAdapter foodArrayAdapter = new ArrayAdapter<FoodModel>(MainActivity.this, android.R.layout.select_dialog_item, dataBaseHelper2.getAll());
        FoodList.setAdapter(foodArrayAdapter);
    }
}