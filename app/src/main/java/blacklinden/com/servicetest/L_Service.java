package blacklinden.com.servicetest;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.logging.Handler;
import java.util.logging.LogRecord;


public class L_Service extends IntentService {

    ArrayList<String> arrayList;
    Bundle bundle;
    ResultReceiver rec;
    int ism;
    public L_Service() {
        super("szervíz");
        arrayList = new ArrayList<>();
        bundle  = new Bundle();
        ism=0;
    }




    @Override
    protected void onHandleIntent(@Nullable Intent intent) {



        if(arrayList.isEmpty()){
            // Extract the receiver passed into the service
            rec = intent.getParcelableExtra("vevő");
            // Extract additional values from the bundle
            String val = intent.getStringExtra("axioma");
            arrayList.add(val);
        }

        oo.run();




    }

    public android.os.Handler handler = new android.os.Handler(Looper.myLooper());
    public Runnable oo = new Runnable() {
        @Override
        public void run() {
            if (ism < 10) {
                bundle.putStringArrayList("res", L(arrayList));
                
                rec.send(Activity.RESULT_OK, bundle);

                ism++;

                handler.postDelayed(oo, 1000);
            } else {
                handler.removeCallbacks(oo);
                Toast.makeText(L_Service.this, "VÉGE", Toast.LENGTH_SHORT).show();
                stopSelf();
            }
        }
        };


    private ArrayList<String> L(ArrayList<String> aa){
        ArrayList<String>a = new ArrayList<>();
        for(String s:aa){
            if(Objects.equals(s,"F")){
                a.add("F");
                a.add("F");
            }else if(Objects.equals(s,"X")){
                a.add("X");
                a.add("F");

            }
        }
        arrayList.clear();
        arrayList.addAll(a);
        return a;
    }


}
