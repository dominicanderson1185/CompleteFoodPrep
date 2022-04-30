package xlost.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class Buffer extends AppCompatActivity {


    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buffer);


        SharedPreferences setting = getSharedPreferences("PREFS", 0);
        password = setting.getString("password", "");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                if(password.equals("")){
                    intent = new Intent(getApplicationContext(), CreatePassword.class);
                } else {
                    intent = new Intent(getApplicationContext(), EnterPassword.class);

                }
                startActivity(intent);
                finish();


            }
        }, 2000);




    }
}