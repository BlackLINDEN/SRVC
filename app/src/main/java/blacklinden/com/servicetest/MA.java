package blacklinden.com.servicetest;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MA extends AppCompatActivity {

    Intent activity,service;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m);

        activity = new Intent(MA.this,MainActivity.class);
        service = new Intent(MA.this, L_Service.class);

        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);

        if (!L_Service.IS_SERVICE_RUNNING) b1.setEnabled(true);
        else b2.setEnabled(true);

    }

    public void newGame(View v){
        service.setAction(Constants.ACTION.STARTFOREGROUND_ACTION);
        L_Service.IS_SERVICE_RUNNING = true;
        startService(service);
        startActivity(activity);
    }

    public void cont(View v){
        service.setAction(Constants.ACTION.NEXT_ACTION);
        L_Service.IS_SERVICE_RUNNING = false;
        startActivity(activity);
    }


}
