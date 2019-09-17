/*
 *	===============================================================================
 *	MovingCircle.java : An extension of MovingEllipse.
 *	A MovingCircle's height and width are constrained so that they're always equal.
 *
 *  Name: Feras Albaroudi
 *  UPI: falb418
 *	===============================================================================
 */

import java.awt.*;

public class MovingCircle extends MovingEllipse {

    public static final int DEFAULT_DIAMETER = 50;

    /**
     * Constructor to create a MovingCircle
     */
    public MovingCircle() {
        super(DEFAULT_DIAMETER);
    }

    /**
     * Constructor to create a MovingCircle
     *
     * @param diameter the diameter of the circle to be drawn
     */
    public MovingCircle(int diameter) {
        super(diameter);
    }

    /**
     * Constructor to create a MovingCircle
     *
     * @param x        the x-coordinate of the new shape
     * @param y        the y-coordinate of the new shape
     * @param diameter the diameter of the circle to be drawn
     * @param mw       the margin width of the animation panel
     * @param mh       the margin height of the animation panel
     * @param bc       the border colour of the new shape
     * @param fc       the fill colour of the new shape
     * @param pathType the path of the new shape
     */
    public MovingCircle(int x, int y, int diameter, int mw, int mh, Color bc, Color fc, int pathType) {
        super(x, y, diameter, diameter, mw, mh, bc, fc, pathType);
    }

    /**
     * Sets the width and height of this shape to w.
     *
     * @param w the width
     */
    @Override
    public void setWidth(int w) {
        width = w;
        height = w;
    }

    /**
     * Sets the width and height of this shape to h.
     *
     * @param h the height
     */
    @Override
    public void setHeight(int h) {
        width = h;
        height = h;
    }

}
