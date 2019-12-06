package com.fedibr.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class SharedPref extends AppCompatActivity {

    private SharedPreferences mPref;
    private SharedPreferences.Editor mPrefEditor;
    private static  final String TAG = "SharedPref";
    private EditText UN,UP;
    private Button btnLog;
    private CheckBox CHECK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UN = (EditText) findViewById(R.id.Username11);
        UP = (EditText) findViewById(R.id.Password11);
        btnLog = (Button) findViewById(R.id.Signin11);
        CHECK = (CheckBox) findViewById(R.id.Rem11);


        mPref = PreferenceManager.getDefaultSharedPreferences(this);
        mPrefEditor = mPref.edit();

        mPrefEditor.putString("Key", "Fedi");
        mPrefEditor.commit();
        String name = mPref.getString("Key", "default");
        Log.d(TAG,"OnCreate : name" + name);

        checkSharedPreference();
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CHECK.isChecked()){
                mPrefEditor.putString(getString(R.string.CheckBox), "True");
                mPrefEditor.commit();
                    String Name = UN.getText().toString();
                    mPrefEditor.putString(getString(R.string.Name), Name);
                    mPrefEditor.commit();

                String password = UP.getText().toString();
                mPrefEditor.putString(getString(R.string.Password), password);
                mPrefEditor.commit();
                }else{
                    mPrefEditor.putString(getString(R.string.CheckBox), "False");
                    mPrefEditor.commit();

                    mPrefEditor.putString(getString(R.string.Name), "");
                    mPrefEditor.commit();


                    mPrefEditor.putString(getString(R.string.Password), "");
                    mPrefEditor.commit();
                }
            }
        });

    }

private void checkSharedPreference(){
    String CheckBox = mPref.getString((getString(R.string.CheckBox)), "False");
    String Name = mPref.getString((getString(R.string.Name)), "");
    String Pass = mPref.getString((getString(R.string.Password)), "");
    UN.setText(Name);
    UP.setText(Pass);

    if(CheckBox.equals(true)){
        CHECK.setChecked(true);
    }else{
        CHECK.setChecked(false);
    }
}
}
