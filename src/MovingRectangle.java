/*
 *	===============================================================================
 *	MovingRectangle.java : An extension of MovingShape.
 *
 *  Name: Feras Albaroudi
 *  UPI: falb418
 *	===============================================================================
 */

import java.awt.*;

public class MovingRectangle extends MovingShape {

    /**
     * Constructor to create a MovingRectangle
     */
    public MovingRectangle() {
    }

    /**
     * Constructor to create a MovingRectangle
     *
     * @param sideLength value to use as the width and height of this image
     */
    public MovingRectangle(int sideLength) {
        super(sideLength);
    }

    /**
     * Constructor to create a MovingRectangle
     *
     * @param x        the x-coordinate of the new shape
     * @param y        the y-coordinate of the new shape
     * @param w        the width of the new shape
     * @param h        the height of the new shape
     * @param mw       the margin width of the animation panel
     * @param mh       the margin height of the animation panel
     * @param bc       the border colour of the new shape
     * @param fc       the fill colour of the new shape
     * @param pathType the path of the new shape
     */
    public MovingRectangle(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, int pathType) {
        super(x, y, w, h, mw, mh, bc, fc, pathType);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(fillColor);
        g2d.fillRect(x, y, width, height);

        g2d.setColor(borderColor);
        g2d.drawRect(x, y, width, height);
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public boolean contains(Point p) {
        return x <= p.x && x + width >= p.x && y <= p.y && y + height >= p.y;
    }

}
