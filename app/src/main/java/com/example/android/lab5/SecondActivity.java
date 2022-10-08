package com.example.android.lab5;

import android.content.*;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class SecondActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button store_information = findViewById(R.id.store_information);
        Button show_information = findViewById(R.id.show_information);
        textView = findViewById(R.id.txtPrefs);
        View.OnClickListener listener = view -> {
            switch (view.getId()){
                case R.id.store_information:
                    Intent intent = new Intent(SecondActivity.this,PrefsActivity.class);
                    startActivity(intent);
                    break;
                case R.id.show_information:
                    displaySharedPreferences();
                    break;
                default:
                    break;
            }
        };
        store_information.setOnClickListener(listener);
        show_information.setOnClickListener(listener);
    }

    private void displaySharedPreferences() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(SecondActivity.this);
        String username = prefs.getString("username", "Default NickName");
        String passw = prefs.getString("password", "Default Password");
        boolean checkBox = prefs.getBoolean("checkBox", false);
        String listPrefs = prefs.getString("list_pref", "Default list prefs");
        StringBuilder builder = new StringBuilder();
        builder.append("Логін: " + username + "\n");
        builder.append("Пароль: " + passw + "\n");
        builder.append("Залишити мене в системі: " + String.valueOf(checkBox) + "\n");
        builder.append("Список налаштувань: " + listPrefs);textView.setText(builder.toString());

    }
}