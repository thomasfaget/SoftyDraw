package ca.uqac.softydraw;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import ca.uqac.softydraw.colorPicker.ColorPickerDialog;


public class SoftyDrawActivity extends AppCompatActivity {

    // Views
    private PaintView paintView;
    private ScreenListener screenListener;
    private Button testButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Use fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_softy_draw);

        // View
        paintView = findViewById(R.id.paintView);
        testButton = findViewById(R.id.testButton);

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showColorPicker();
            }
        });
        screenListener = new ScreenListener(paintView);
        paintView.setOnTouchListener(screenListener);

    }

    /** Display the color picker in order to change a color
     */
    private void showColorPicker() {
        int initialColor = Color.WHITE;
        ColorPickerDialog colorPickerDialog = new ColorPickerDialog(this, initialColor, new ColorPickerDialog.OnColorSelectedListener() {
            @Override
            public void onColorSelected(int color) {
                testButton.setBackgroundColor(color);
            }
        });
        colorPickerDialog.show();
    }


}
