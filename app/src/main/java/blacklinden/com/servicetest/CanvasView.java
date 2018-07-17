package blacklinden.com.servicetest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class CanvasView extends View {

    Paint p;
    ArrayList<String> xxx;

    public CanvasView(Context context, AttributeSet set) {
        super(context,set);
        xxx = new ArrayList<>();
        p = new Paint();
        p.setColor(Color.GREEN);
        p.setStrokeWidth(5f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        T(canvas,xxx);
        invalidate();
    }

    public void indit(View v){

    }

    public void XXX(ArrayList<String> xxx){
        this.xxx.clear();
        this.xxx.addAll(xxx);
    }

    void T(Canvas c, ArrayList<String> al) {
        if (!al.isEmpty()) {
            for (String a : al) {
                switch (a) {
                    case "F":
                        c.drawCircle(ThreadLocalRandom.current().nextInt(0, c.getWidth() + 1), ThreadLocalRandom.current().nextInt(0, 100 + 1), 10, p);
                        break;
                    case "X":
                        c.drawLine(ThreadLocalRandom.current().nextInt(0, c.getWidth() + 1), ThreadLocalRandom.current().nextInt(0, 90 + 1), ThreadLocalRandom.current().nextInt(0, 100 + 1), 100, p);
                        break;
                }
            }
        }else
            c.drawText("Yipie ki yeah",c.getWidth()/2,c.getHeight()/2,p);
    }

}
