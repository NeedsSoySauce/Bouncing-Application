/*
 *	===============================================================================
 *	MovingSquare.java : An extension of MovingRectangle.
 *	A MovingSquare's height and width are constrained so that they're always equal.
 *
 *  Name: Feras Albaroudi
 *  UPI: falb418
 *	===============================================================================
 */

import java.awt.*;

public class MovingSquare extends MovingRectangle {

    protected static final int DEFAULT_SIDE_LENGTH = 50;

    /**
     * Constructor to create a MovingSquare
     */
    public MovingSquare() {
        super(DEFAULT_SIDE_LENGTH);
    }

    /**
     * Constructor to create a MovingSquare
     *
     * @param sideLength value to use as the width and height of the square to be drawn
     */
    public MovingSquare(int sideLength) {
        super(sideLength);
    }

    /**
     * Constructor to create a MovingSquare
     *
     * @param x          the x-coordinate of the new shape
     * @param y          the y-coordinate of the new shape
     * @param sideLength value to use as the width and height of the square to be drawn
     * @param mw         the margin width of the animation panel
     * @param mh         the margin height of the animation panel
     * @param bc         the border colour of the new shape
     * @param fc         the fill colour of the new shape
     * @param pathType   the path of the new shape
     */
    public MovingSquare(int x, int y, int sideLength, int mw, int mh, Color bc, Color fc, int pathType) {
        super(x, y, sideLength, sideLength, mw, mh, bc, fc, pathType);
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
