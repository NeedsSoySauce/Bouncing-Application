/*
 *	===============================================================================
 *	MovingEllipse.java : An extension of MovingShape.
 *  A MovingEllipse can have a different length for it's major and minor axis, accurately calculate it's
 *  area, and accurately determine whether a point lays within it's border.
 *
 *  Name: Feras Albaroudi
 *  UPI: falb418
 *	===============================================================================
 */

import java.awt.*;

/**
 * Name: Feras Albaroudi
 * <p>
 * UPI: falb418
 * <p>
 * An implementation of MovingShape, this class allows an ellipse to be created that can be drawn, calculate it's area,
 * and determine if a point lays inside it.
 *
 * @see MovingShape
 */

public class MovingEllipse extends MovingShape {

    /**
     * Constructor to create a MovingEllipse
     */
    public MovingEllipse() {
    }

    /**
     * Constructor to create a MovingEllipse
     *
     * @param axisLength value to use as the length of the major and minor axis of the ellipse to be drawn
     */
    public MovingEllipse(int axisLength) {
        super(axisLength);
    }

    /**
     * Constructor to create a MovingEllipse
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
    public MovingEllipse(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, int pathType) {
        super(x, y, w, h, mw, mh, bc, fc, pathType);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(fillColor);
        g2d.fillOval(x, y, width, height);

        g2d.setColor(borderColor);
        g2d.drawOval(x, y, width, height);
    }

    @Override
    public double getArea() {
        return Math.PI * height / 2.0 * width / 2.0;
    }

    @Override
    public boolean contains(Point p) {

        double xRadius = width / 2.0;
        double yRadius = height / 2.0;

        double xCenter = x + xRadius;
        double yCenter = y + yRadius;

        // Equation of an ellipse
        return Math.pow(p.x - xCenter, 2) / Math.pow(xRadius, 2) + Math.pow(p.y - yCenter, 2) / Math.pow(yRadius, 2) <= 1;
    }
}
