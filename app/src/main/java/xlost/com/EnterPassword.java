package xlost.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterPassword extends AppCompatActivity {


    EditText enterPassword;
    Button enter_pass_button;

    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_password);

        SharedPreferences setting = getSharedPreferences("PREFS",0);
        password = setting.getString("password","");

 enterPassword =findViewById(R.id.enterPassword);
 enter_pass_button =findViewById(R.id.enter_pass_button);

enter_pass_button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
String enter = enterPassword.getText().toString();
Intent intent;


//text1 issue find out what part im overlooking.
if(enter.equals(password)){

    intent = new Intent(getApplicationContext(), MainActivity.class);
    startActivity(intent);
    finish();
} else {
    Toast.makeText(EnterPassword.this, "Incorrect Password",Toast.LENGTH_SHORT).show();

    }

    }
});







    }
}