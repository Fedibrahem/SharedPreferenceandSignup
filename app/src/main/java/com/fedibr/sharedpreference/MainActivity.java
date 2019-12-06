package com.fedibr.sharedpreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences mPref;
    private SharedPreferences.Editor mPrefEditor;
    private static  final String TAG11 = "SharedPref";
    private EditText UN11,UP11;
    private Button btnLog11;
    private CheckBox CHECK11;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        db = new DatabaseHelper(this);
        UN11 = (EditText) findViewById(R.id.Username11);
        UP11 = (EditText) findViewById(R.id.Password11);
        btnLog11 = (Button) findViewById(R.id.Signin11);
            btnLog11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String s11 = UN11.getText().toString();
                    String s21=  UP11.getText().toString();
                    Boolean chkmeailpass = db.emailpassword(s11,s21);
                    if(chkmeailpass==true)
                        Toast.makeText(getApplicationContext(),"Succes",Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getApplicationContext(),"fail",Toast.LENGTH_SHORT).show();
                }
            });
            }
        }

