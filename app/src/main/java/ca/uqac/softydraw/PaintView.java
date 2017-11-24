package ca.uqac.softydraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/** A View used to paint on the screen
 */

public class PaintView extends View implements ScreenCallback {

    private Paint paint;


    public PaintView(Context context) {
        super(context);
    }

    public PaintView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PaintView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PaintView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /**
         int h = getHeight();
         int w = getWidth();

         // Set the ROI in the context of the view

         float leftROI = roi.getHorizontalLowerBound(w);
         float rightROI = roi.getHorizontalUpperBound(w);
         float topROI = roi.getVerticalLowerBound(h);
         float bottomROI = roi.getVerticalUpperBound(h);

         // Add a transparent mask around the roi
         paint.setStyle(Paint.Style.FILL);
         paint.setColor(getResources().getColor(R.color.grayTransparent));
         canvas.drawRect(0, 0, leftROI, h, paint);
         canvas.drawRect(rightROI, 0, w, h, paint);
         canvas.drawRect(leftROI, 0, rightROI, topROI, paint);
         canvas.drawRect(leftROI, bottomROI, rightROI, h, paint);

         // Draw border
         paint.setStyle(Paint.Style.STROKE);
         paint.setColor(Color.DKGRAY);
         if (leftROI == rightROI && topROI == bottomROI) {
         paint.setStrokeWidth(10);
         canvas.drawPoint(leftROI, topROI, paint);
         }
         else {
         paint.setStrokeWidth(3);
         canvas.drawRect(leftROI, topROI, rightROI, bottomROI, paint);
         }

         */
    }

    @Override
    public void changeColor(int color) {

    }


    @Override
    public void performMove(int x1, int y1, int x2, int Y2) {

    }
}
