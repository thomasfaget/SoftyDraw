package ca.uqac.softydraw;


import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ca.uqac.softydraw.colorPicker.ColorPickerDialog;


public class SoftyDrawActivity extends AppCompatActivity {

    // Views
    private PaintingView paintingView;
    private Toolbar toolbar;

    // Size
    private float smallBrush, mediumBrush, largeBrush;

    private Drawable iconErase;

    private ImageButton currentButtonUsedToDraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Use fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_softy_draw);


        //sizes from dimensions
        smallBrush = getResources().getInteger(R.integer.small_size);
        mediumBrush = getResources().getInteger(R.integer.medium_size);
        largeBrush = getResources().getInteger(R.integer.large_size);

        iconErase = getResources().getDrawable(android.R.drawable.ic_menu_close_clear_cancel);

        // View
        paintingView = findViewById(R.id.paintView);
        toolbar = findViewById(R.id.toolbar);

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

        // add listener for color buttons
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

        // Action bar
        setSupportActionBar(toolbar);

        // Setup paintingView
        paintingView.initialDrawing();
        changeCurrentColor(colorButtons.get(0)); // Set first color
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.erase :
                paintingView.switchErase();
                if (paintingView.getErase()) {
                    iconErase.setColorFilter(getResources().getColor(R.color.green_app_dark), PorterDuff.Mode.SCREEN);
                }
                else {
                    iconErase.setColorFilter(getResources().getColor(R.color.green_app), PorterDuff.Mode.SCREEN);
                }
                item.setIcon(iconErase);
                break;
            case R.id.changeBrush:
                changeBrush();
                break;
            case R.id.newDrawing :
                newDraw();
                break;
            case R.id.saveDrawing :
                saveDraw();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return true;
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

    /** Made a new draw
     */
    private void newDraw() {
        //new button
        AlertDialog.Builder newDialog = new AlertDialog.Builder(this);
        newDialog.setTitle("Nouveau dessin");
        newDialog.setMessage("Etes-vous sur ? (Le dessin en cours sera supprimé !)");
        newDialog.setPositiveButton("Nouveau", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                paintingView.startNew();
                dialog.dismiss();
            }
        });
        newDialog.setNegativeButton("Annuler", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                dialog.cancel();
            }
        });
        newDialog.show();
    }


    /** Save the current Drawing
     */
    private void saveDraw() {
        //save drawing
        AlertDialog.Builder saveDialog = new AlertDialog.Builder(this);
        saveDialog.setTitle("Sauvegarde");
        saveDialog.setMessage("Voulez-vous sauvegarder l'image?");
        saveDialog.setPositiveButton("Sauvegarder", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                //save drawing
                paintingView.setDrawingCacheEnabled(true);
                //attempt to save
                String imgSaved = MediaStore.Images.Media.insertImage(
                        getContentResolver(), paintingView.getDrawingCache(),
                        UUID.randomUUID().toString()+".png", "drawing");
                //feedback
                if(imgSaved!=null){
                    Toast savedToast = Toast.makeText(getApplicationContext(),
                            "Sauvegarde réussi !", Toast.LENGTH_SHORT);
                    savedToast.show();
                }
                else{
                    Toast unsavedToast = Toast.makeText(getApplicationContext(),
                            "Erreur :( L'image n'a pas été suavegardé !", Toast.LENGTH_SHORT);
                    unsavedToast.show();
                }
                paintingView.destroyDrawingCache();
            }
        });
        saveDialog.setNegativeButton("Annuler", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                dialog.cancel();
            }
        });
        saveDialog.show();
    }


    private void changeBrush() {
        CharSequence[] items = {" Fin (10)"," Médium (20)"," Epais (30)"};

        int checkedItem = -1;
        if (paintingView.getLastBrushSize() == 10) {
            checkedItem = 0;
        }
        else if (paintingView.getLastBrushSize() == 20) {
            checkedItem = 1;
        }
        else if (paintingView.getLastBrushSize() == 30) {
            checkedItem = 2;
        }

        new AlertDialog.Builder(this)
                .setTitle("Taille pinceau")
                .setSingleChoiceItems(items, checkedItem, null)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.dismiss();
                        int selectedPosition = ((AlertDialog)dialog).getListView().getCheckedItemPosition();
                        if (selectedPosition == 0) {
                            paintingView.setLastBrushSize(smallBrush);
                            paintingView.setBrushSize(smallBrush);
                        }
                        else if (selectedPosition == 1) {
                            paintingView.setLastBrushSize(mediumBrush);
                            paintingView.setBrushSize(mediumBrush);
                        }
                        else if (selectedPosition == 2) {
                            paintingView.setLastBrushSize(largeBrush);
                            paintingView.setBrushSize(largeBrush);
                        }
                    }
                }).show();
    }




}
