package xlost.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class Reminder extends AppCompatActivity {


    EditText description_id, location_id, title_id;
    Button reminder_btn, addView3,List_View3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
// build buttons min
//description_id   reminder_btn    location_id     title_id

       title_id = findViewById(R.id.title_id);
       description_id = findViewById(R.id.description_id);
       location_id = findViewById(R.id.location_id);
       reminder_btn = findViewById(R.id.reminder_btn);
       addView3 = findViewById(R.id.addView3);
       List_View3 = findViewById(R.id.List_View3);

reminder_btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

if(!title_id.getText().toString().isEmpty() && !location_id.getText().toString().isEmpty() && !description_id.getText().toString().isEmpty() ){
Intent intent = new Intent(Intent.ACTION_INSERT);
intent.setData(CalendarContract.Events.CONTENT_URI);
intent.putExtra(CalendarContract.Events.TITLE,title_id.getText().toString());
intent.putExtra(CalendarContract.Events.EVENT_LOCATION,location_id.getText().toString());
intent.putExtra(CalendarContract.Events.DESCRIPTION,description_id.getText().toString());
intent.putExtra(CalendarContract.Events.ALL_DAY,"true");

    if(intent.resolveActivity(getPackageManager()) != null){
        startActivity(intent);
    }
    else {
        Toast.makeText(Reminder.this, "There seems to be an error.",Toast.LENGTH_SHORT).show();

    }

}
else{
    Toast.makeText(Reminder.this, "All lines must be filled.",Toast.LENGTH_SHORT).show();

}

    }
});

        List_View3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent theIntent = new Intent(getApplicationContext(), View_All.class);
                startActivity(theIntent);
            }
        });

        addView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent theIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(theIntent);
                } catch (Exception e){
                }

            }
        });






    }
}