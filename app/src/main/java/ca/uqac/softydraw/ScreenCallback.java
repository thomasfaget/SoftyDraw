package ca.uqac.softydraw;

/** Created by thomas on 23/11/2017.
 */

public interface ScreenCallback {

    /** The user change the color
     */
    void changeColor(int color);

    /** The user move the main pointer on the screen
     * He moves from the position (x1,y1) to (x2,y2)
     */
    void performMove(int x1, int y1, int x2, int Y2);
}
