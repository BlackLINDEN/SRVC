package blacklinden.com.servicetest;


import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CanvasView canvas;
    public Vevő vevő;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        canvas = findViewById(R.id.canv);
        setupServiceReceiver();
        nyissSzervizt();

    }

    private void nyissSzervizt(){
        Intent i = new Intent(this,L_Service.class);
        i.putExtra("axioma","X");
        i.putExtra("vevő",vevő);

        startService(i);
    }



    public void setupServiceReceiver() {
        vevő = new Vevő(new Handler());
        // This is where we specify what happens when data is received from the service
        vevő.setReceiver(new Vevő.Receiver() {
            @Override
            public void onReceiveResult(int resultCode, Bundle resultData) {
                if (resultCode == RESULT_OK) {
                    ArrayList<String> resultValue = resultData.getStringArrayList("res");
                    canvas.XXX(resultValue);
                    //Toast.makeText(MainActivity.this, resultValue, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
