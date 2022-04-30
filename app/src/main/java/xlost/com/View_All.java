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

public class View_All extends AppCompatActivity {

    Button submit, ViewAll, addGoods, addView, reminder_btn2;
    EditText ItemName, ItemAmount,ExpirationDate;
    ListView FoodList, All_View;
    ArrayAdapter foodArrayAdapter;
    DataBaseHelper dataBaseHelper;
    FoodModel foodModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);


        FoodList = findViewById(R.id.foodList);
        dataBaseHelper = new DataBaseHelper(View_All.this);
        Button add_view = findViewById(R.id.addView);
        Button List_View = findViewById(R.id.List_View);
        Button reminder_btn2 = findViewById(R.id.reminder_btn2);
        ShowFoodList(dataBaseHelper);

        DataBaseHelper dataBaseHelper = new DataBaseHelper(View_All.this);

        /*------------------------------------------*/

        List_View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent theIntent = new Intent(getApplicationContext(), View_All.class);
                    startActivity(theIntent);
                } catch (Exception e){
                    Toast.makeText(View_All.this, "You may be on this page already.", Toast.LENGTH_SHORT).show();
            }

            }
        });
        /*------------------------------------------*/

        add_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent theIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(theIntent);
                } catch (Exception e){
                }

            }
        });

        /*------------------------------------------*/

        reminder_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent theIntent = new Intent(getApplicationContext(), Reminder.class);
                startActivity(theIntent);
            }


        });

FoodList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

FoodModel clickFood = (FoodModel) adapterView.getItemAtPosition(i);
dataBaseHelper.deleteOne(clickFood);
ShowFoodList(dataBaseHelper);
        Toast.makeText(View_All.this, "Deleted", Toast.LENGTH_SHORT).show();

    }
});





    }
    private void ShowFoodList(DataBaseHelper dataBaseHelper2) {
        // ArrayAdapter foodArrayAdapter = new ArrayAdapter<FoodModel>(MainActivity.this, android.R.layout.simple_list_item_1, dataBaseHelper2.getAll());

        ArrayAdapter foodArrayAdapter = new ArrayAdapter<FoodModel>(View_All.this, android.R.layout.select_dialog_item, dataBaseHelper2.getAll());
        FoodList.setAdapter(foodArrayAdapter);
    }

}