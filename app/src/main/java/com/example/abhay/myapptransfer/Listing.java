package com.example.abhay.myapptransfer;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Listing extends AppCompatActivity {
 private  TextView textView,yolo;
    private EditText editText;
    private  Button button;
private static int number;
    /**
     * Created by Abhay on 6/28/2016.
     *
     * IN THIS APPLICATION I TRY TO LIST APK FILE FILES IN ANDROID MOBILE WHERE CAN SEARCH THE SNO. OF PARTICULAR APPLICATION HE/SHE WANT TO
     * SEND BY JUST PUTTING THE SNO. IN EDITBOX.
     */

    @Override
    protected synchronized void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.textView);
        yolo=(TextView)findViewById(R.id.yolo);
        button=(Button)findViewById(R.id.button);
        editText=(EditText)findViewById(R.id.edit);

       // String no=editText.getText().toString();


        final PackageManager pm = getPackageManager();
            //get a list of installed apps.
        final List<ApplicationInfo> packages =  pm.getInstalledApplications(PackageManager.GET_META_DATA);
       yolo.setText("HOW MANY APPS YOU HAVE: " + String.valueOf(packages.size()));

        /*ALL THE APK DESTINATION*/
        for(int i=0;i<packages.size();i++){
           textView.setText("SEE THE SNO. ON LOGCAT(ERROR) AND WRITE IT ON EDITTEXT for TRANSFERRING PARTICULAR APK FILE (OR SEARCH FROM LOGCAT)");
            Log.e("INSTALLED APP","SNO>" +i+"->"+"Installed package :" + packages.get(i).packageName+"-->" + "Apk file path:" +packages.get(i).sourceDir);
        }

        /*ALL THE APK DESTINATION*/
//        for (ApplicationInfo packageInfo : packages) {
//            Log.e("INSTALLED APP","Installed package :" + packageInfo.packageName+"Apk file path:" + packageInfo.sourceDir);
//
//           // Log.e("APK DISTINATION", "Apk file path:" + packageInfo.sourceDir);
//        }

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Log.e("VALUE OF INPUT", editText.getText().toString());
               Intent intent = new Intent(Listing.this, Fileshare.class);
               intent.putExtra("AnyKeyValue",packages.get(Integer.parseInt(editText.getText().toString())).sourceDir);  // pass your values and retrieve them in the other Activity using AnyKeyName
               startActivity(intent);
           }
       });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
