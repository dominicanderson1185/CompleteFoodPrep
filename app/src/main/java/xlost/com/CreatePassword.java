package xlost.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreatePassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_password);

        EditText TextPassword,TextPassword2;
        Button pass_sub_button;

        TextPassword =findViewById(R.id.TextPassword);
        TextPassword2 =findViewById(R.id.TextPassword2);
        pass_sub_button =findViewById(R.id.pass_sub_button);


        pass_sub_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = TextPassword.getText().toString();
                String text2 = TextPassword2.getText().toString();
                Intent intent;

            if (text1.equals("") || text2.equals("")){
                Toast.makeText(CreatePassword.this, "No password entered", Toast.LENGTH_SHORT).show();

            }   else{
                if(text1.equals(text2)){
                    SharedPreferences settings = getSharedPreferences("PREFS",0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putString("password",text1);
                    editor.apply();

                    Toast.makeText(CreatePassword.this, text1.toString(), Toast.LENGTH_SHORT).show();

                    intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();

                } else {
                    Toast.makeText(CreatePassword.this, "Passwords doesn't match",Toast.LENGTH_SHORT).show(); }

            }

            }
        });






    }
}