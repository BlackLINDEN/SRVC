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
    ArrayList<Valami> yyy;

    public CanvasView(Context context, AttributeSet set) {
        super(context,set);
        xxx = new ArrayList<>();

        yyy = new ArrayList<>();
        p = new Paint();
        p.setColor(Color.GREEN);
        p.setStrokeWidth(5f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        T(canvas,yyy);
        invalidate();
    }

    public void indit(View v){

    }

    public void XXX(ArrayList<Valami> yyy){
        this.yyy.clear();
        this.yyy.addAll(yyy);
    }

    void T(Canvas c, ArrayList<Valami> al) {
        if (!al.isEmpty()) {
            for (Valami a : al) {
                switch (a.név) {
                    case "F":
                        c.drawCircle(c.getWidth()/2, c.getHeight()/2, a.sug, p);
                        break;
                    case "X":
                        c.drawLine(0, 0, 0, 100, p);
                        break;
                }
            }
        }else
            c.drawText("Yipie ki yeah",c.getWidth()/2,c.getHeight()/2,p);
    }

}
