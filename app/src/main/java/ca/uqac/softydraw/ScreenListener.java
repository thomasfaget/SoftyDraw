package ca.uqac.softydraw;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/** The screen listener
 * Acquire screen interaction and send then to the PaintView with the callback
 */

public class ScreenListener implements View.OnTouchListener {



    // The main pointer used to draw
    private int mainPointer;

    // Main pointer position :
    private int xPos;
    private int yPos;

    // Current color
    private int color = 1;

    // The callback to notify
    private ScreenCallback callback;

    public ScreenListener(ScreenCallback callback) {
        this.callback = callback;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        int action = event.getAction();
        int actionMasked = event.getActionMasked();

        Log.d("TEST", "----------------------");
        Log.d("TEST", "action = " + action);
        Log.d("TEST", "actionMasked = " + actionMasked);


        // The user adds a pointer on the screen
        if (actionMasked == MotionEvent.ACTION_DOWN) {
        }
        // The user moves a pointer
        else if (action == MotionEvent.ACTION_MOVE) {
        }
        // The user remove a pointer
        else if (action == MotionEvent.ACTION_UP) {
        }
        /**

        // Move the ROI when moving on the screen with 1 finger
        if (event.getPointerCount() == 1) {

            // The user move his finger -> perform a move of the ROI
            if (action == MotionEvent.ACTION_MOVE) {

                float newXPos = event.getX(0);
                float newYPos = event.getY(0);
                if (newXPos != xPos && newYPos != yPos) {
                    regionOfInterest.applyMove((newXPos - xPos) * moveInertiaCoefficientForROI, (newYPos - yPos) * moveInertiaCoefficientForROI);
                    roiView.invalidate();
                }
                xPos = newXPos;
                yPos = newYPos;
            }

            // The user put a finger on the screen -> set the position
            else if (actionMasked == MotionEvent.ACTION_DOWN) {
                xPos = event.getX(0);
                yPos = event.getY(0);
                xPosInitial = xPos;
                yPosInitial = yPos;
            }

            // The user remove his finger from the screen
            //  -> Auto focus if the finger not moved from the beginning
            else if (actionMasked == MotionEvent.ACTION_UP && xPosInitial == event.getX(0) && yPosInitial == event.getY(0)) {
                // Auto focus on the ROI if the user don't move his finger :
            }
        }
        // Perform a move if 2 moving fingers are detected on the screen :
        else if (event.getPointerCount() == 2) {

            // The user move his 2 fingers -> perform a zoom
            if (action == MotionEvent.ACTION_MOVE) {

                float newDistance = getSquareDistance(event);
                if (newDistance < distance) {
                    regionOfInterest.applyZoomMore((distance - newDistance) * zoomInertiaCoefficientForROI);
                    roiView.invalidate();
                } else if (newDistance > distance) {
                    regionOfInterest.applyZoomLess((newDistance - distance) * zoomInertiaCoefficientForROI);
                    roiView.invalidate();
                }
                distance = newDistance;
            }

            // The user add an other finger : update the position of the pointer
            else if (actionMasked == MotionEvent.ACTION_POINTER_DOWN) {
                // Need to update the position of the pointer
                if (action == actionMasked) {
                    xPos = event.getX(0);
                    yPos = event.getY(0);
                }
                distance = getSquareDistance(event);
            }

            // The user remove an finger : update the position of the pointer
            else if (actionMasked == MotionEvent.ACTION_POINTER_UP) {
                // Need to update the position of the pointer
                if (action == actionMasked) {
                    xPos = event.getX(1);
                    yPos = event.getY(1);
                } else {
                    xPos = event.getX(0);
                    yPos = event.getY(0);
                }
            }
        }*/
        return true;
    }

    private float getSquareDistance(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float) Math.sqrt(x * x + y * y);
    }
}
