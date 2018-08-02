package blacklinden.com.servicetest;


import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private CanvasView canvas;
    private Button b2,b;

    private L_Service lService;
    private boolean bounded_e =false;
    Intent service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = findViewById(R.id.button);
        canvas = findViewById(R.id.canv);
        service = new Intent(MainActivity.this, L_Service.class);

        bindService(service,kapcsolat,Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        unbindService(kapcsolat);
    }





    private ServiceConnection kapcsolat = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            bounded_e = false;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            L_Service.Binderem myBinder = (L_Service.Binderem) service;
            lService = myBinder.getService();
            bounded_e = true;
            canvas.XXX(lService.valamis);
        }
    };


}
