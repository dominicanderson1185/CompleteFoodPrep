package xlost.com;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class Scanner extends AppCompatActivity implements View.OnClickListener{


Button scan_btn;
TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

scan_btn = findViewById(R.id.scan_btn);
scan_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
scanCode();
    }

    private void scanCode(){

        //IntentIntegrator integrator
       IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setCaptureActivity(CaptureAct.class);
        integrator.setOrientationLocked(false);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.setPrompt("Scanning Code");
        integrator.initiateScan();
    }

protected void onActivityResult(int requestCode, int resultCode, Intent data){


        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode,data);
        if (result != null){
            if(result.getContents() != null){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(result.getContents());
                builder.setTitle("Scanning Results");
                builder.setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        scanCode();
                    }
                }).setNegativeButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                   finish();
                    }
                });
AlertDialog dialog = builder.create();

dialog.show();


                // Storing data into SharedPreferences
   //             SharedPreferences sharedPreferences = getSharedPreferences("MySharedPrefscan",MODE_PRIVATE);

// Creating an Editor object to edit(write to the file)
 //               SharedPreferences.Editor myEdit = sharedPreferences.edit();

// Storing the key and its value as the data fetched from edittext
  //              myEdit.putString("newname", result.toString());

// Once the changes have been made,
// we need to commit to apply those changes made,
// otherwise, it will throw an error
     //           Intent intent = new Intent(getApplicationContext(), scanner_add.class);
       //         startActivity(intent);
            }
            else {
                Toast.makeText(this,"Couldn't find any results", Toast.LENGTH_SHORT).show();
            }}
        else{
            super.onActivityResult(requestCode, resultCode, data);
        }




            }

        }
