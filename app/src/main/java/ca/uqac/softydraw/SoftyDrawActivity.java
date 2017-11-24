package ca.uqac.softydraw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;


public class SoftyDrawActivity extends AppCompatActivity {

    private PaintView paintView;
    private ScreenListener screenListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Use fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_softy_draw);

        paintView = (PaintView) findViewById(R.id.paintView);

        screenListener = new ScreenListener(paintView);
        paintView.setOnTouchListener(screenListener);

    }


}
