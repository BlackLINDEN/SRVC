package blacklinden.com.servicetest;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;


import java.util.ArrayList;

import java.util.Objects;



public class L_Service extends Service {


    ArrayList<Valami> valamis = new ArrayList<>();
    public android.os.Handler handler = new android.os.Handler(Looper.myLooper());

    int ism=0;
    private IBinder binderem = new Binderem();
    public static boolean IS_SERVICE_RUNNING = false;


    @Override
    public void onCreate() {
        valamis.add(new Valami("F"));
        handler.post(oo);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(L_Service.this, "ON", Toast.LENGTH_SHORT).show();

            switch ((intent.getAction())) {
                case Constants.ACTION.STARTFOREGROUND_ACTION:
                    Log.i("log ", "Received Start Foreground Intent ");
                    showNotification();
                    Toast.makeText(this, "Service Started!", Toast.LENGTH_SHORT).show();

                    break;
                case Constants.ACTION.PREV_ACTION:
                    Log.i("log ", "Clicked Previous");

                    Toast.makeText(this, "Clicked Previous!", Toast.LENGTH_SHORT)
                            .show();
                    break;
                case Constants.ACTION.PLAY_ACTION:
                    Log.i("log ", "Clicked Play");

                    Toast.makeText(this, "Clicked Play!", Toast.LENGTH_SHORT).show();
                    break;
                case Constants.ACTION.NEXT_ACTION:
                    Log.i("log ", "Clicked Next");

                    Toast.makeText(this, "Clicked Next!", Toast.LENGTH_SHORT).show();
                    break;
                case Constants.ACTION.STOPFOREGROUND_ACTION:
                    Log.i("log ", "Received Stop Foreground Intent");
                    stopForeground(true);
                    //stopSelf();
                    break;
            }

        return START_STICKY;
    }

    private void showNotification() {
        Intent notificationIntent = new Intent(this, MainActivity.class);
        notificationIntent.setAction(Constants.ACTION.MAIN_ACTION);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);

        Intent previousIntent = new Intent(this, L_Service.class);
        previousIntent.setAction(Constants.ACTION.PREV_ACTION);
        PendingIntent ppreviousIntent = PendingIntent.getService(this, 0,
                previousIntent, 0);

        Intent playIntent = new Intent(this, L_Service.class);
        playIntent.setAction(Constants.ACTION.PLAY_ACTION);
        PendingIntent pplayIntent = PendingIntent.getService(this, 0,
                playIntent, 0);

        Intent nextIntent = new Intent(this, L_Service.class);
        nextIntent.setAction(Constants.ACTION.NEXT_ACTION);
        PendingIntent pnextIntent = PendingIntent.getService(this, 0,
                nextIntent, 0);

        Bitmap icon = BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_launcher_foreground);

        Notification notification = new Notification.Builder(this)
                .setContentTitle("FOrgroundTeszt")
                .setTicker("teszt")
                .setContentText("sor001")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentIntent(pendingIntent)
                .setOngoing(true)
                .addAction(android.R.drawable.ic_media_previous, "Previous",
                        ppreviousIntent)
                .addAction(android.R.drawable.ic_media_play, "Play",
                        pplayIntent)
                .addAction(android.R.drawable.ic_media_next, "Next",
                        pnextIntent).build();
        startForeground(Constants.NOTIFICATION_ID.FOREGROUND_SERVICE,
                notification);

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {


        return binderem;
    }

    @Override
    public void onRebind(Intent intent) {
        Log.v("binderService", "in onRebind");





    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.v("binderService", "in onRebind");

        return true;
    }

    @Override
    public void onDestroy() {

        Log.v("binderService", "in onDestroy");

    }

    public class Binderem extends Binder {
        L_Service getService() {
            return L_Service.this;
        }
    }


    public Runnable oo = new Runnable() {
        @Override
        public void run() {
            if (ism < 10) {
                ism++;
                LL(valamis);
                handler.postDelayed(oo, 6000);
            } else if(ism>=10) {
                handler.removeCallbacks(oo);
                Toast.makeText(L_Service.this, "VÉGE", Toast.LENGTH_SHORT).show();
                stopSelf();
            }
        }
        };




    private void LL(ArrayList<Valami> aa){

        ArrayList<Valami>a = new ArrayList<>();
        for(Valami s:aa){
            System.out.println("AAAAAAAAAA  "+s.név);
            s.doit();
            if(Objects.equals(s.név,"F")){
                a.add(s);
                a.add(new Valami("F"));
            }else if(Objects.equals(s.név,"X")){
                a.add(s);
                a.add(new Valami("F"));

            }
        }
        valamis.clear();
        valamis.addAll(a);

    }


}
