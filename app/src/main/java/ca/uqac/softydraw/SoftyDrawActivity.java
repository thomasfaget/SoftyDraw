package ca.uqac.softydraw;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import ca.uqac.softydraw.colorPicker.ColorPickerDialog;


public class SoftyDrawActivity extends AppCompatActivity {

    // Views
    private PaintingView paintingView;

    private ImageButton currentButtonUsedToDraw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Use fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_softy_draw);

        // View
        paintingView = findViewById(R.id.paintView);
        List<ImageButton> colorButtons= new ArrayList<>();
        colorButtons.add((ImageButton) findViewById(R.id.colorButton1));
        colorButtons.add((ImageButton) findViewById(R.id.colorButton2));
        colorButtons.add((ImageButton) findViewById(R.id.colorButton3));
        colorButtons.add((ImageButton) findViewById(R.id.colorButton4));
        colorButtons.add((ImageButton) findViewById(R.id.colorButton5));
        colorButtons.add((ImageButton) findViewById(R.id.colorButton6));

        View.OnLongClickListener changeColorListener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ImageButton button = (ImageButton) view;
                changeColorButton(button);
                return true;
            }
        };

        // Set up color button listener
        for (ImageButton button: colorButtons) {
            button.setOnLongClickListener(changeColorListener);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ImageButton button = (ImageButton) view;
                    changeCurrentColor(button);
                }
            });
        }

        // Setup paintingView
        paintingView.initialDrawing();
        changeCurrentColor(colorButtons.get(0)); // Set first color
    }

    /** Display the color picker in order to change the color of a button
     *
     * @param button the button which to change the color
     */
    private void changeColorButton(final ImageButton button) {
        int initialColor = Color.WHITE;
        ColorPickerDialog colorPickerDialog = new ColorPickerDialog(this, initialColor, new ColorPickerDialog.OnColorSelectedListener() {
            @Override
            public void onColorSelected(int color) {
                // Change the color of the button
                button.setTag(String.format("#%06X", 0xFFFFFF & color));
                button.setBackgroundColor(color);
                // Chane current color
                changeCurrentColor(button);
            }
        });
        colorPickerDialog.show();
    }

    /** Change the current color in the interface and in the DrawingView
     */
    private void changeCurrentColor(ImageButton button) {

        // Change color used to draw
        int color = Color.parseColor((String) button.getTag());
        paintingView.setCurrentColor(color);
        // Change current button used to draw in the interface
        button.setImageDrawable(getResources().getDrawable(R.drawable.button_select_color_pressed));
        if (currentButtonUsedToDraw != null && currentButtonUsedToDraw != button) {
            currentButtonUsedToDraw.setImageDrawable(getResources().getDrawable(R.drawable.button_select_color));
        }
        currentButtonUsedToDraw = button;

    }


}
