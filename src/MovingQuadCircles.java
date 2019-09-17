/*
 *	===============================================================================
 *	MovingQuadCircles.java : An extension of MovingCircle.
 *  A MovingQuadCircles draws four intersecting circles and colors the area enclosed by their intersections
 *  in this shape's fill color
 *
 *  Name: Feras Albaroudi
 *  UPI: falb418
 *	===============================================================================
 */

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class MovingQuadCircles extends MovingCircle {

    /**
     * Constructor to create a MovingQuadCircle
     */
    public MovingQuadCircles() {
        super();
    }

    /**
     * Constructor to create a MovingQuadCircle
     *
     * @param x          the x-coordinate of the new shape
     * @param y          the y-coordinate of the new shape
     * @param sideLength the height and width of the new shape
     * @param mw         the margin width of the animation panel
     * @param mh         the margin height of the animation panel
     * @param bc         the border colour of the new shape
     * @param fc         the fill colour of the new shape
     * @param pathType   the path of the new shape
     */
    public MovingQuadCircles(int x, int y, int sideLength, int mw, int mh, Color bc, Color fc, int pathType) {
        super(x, y, sideLength, mw, mh, bc, fc, pathType);

    }

    @Override
    public void draw(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        int qtrSideLen = width / 4;
        int halfSideLen = width / 2;

        Area northArea = new Area(new Ellipse2D.Double(x + qtrSideLen, y, halfSideLen, halfSideLen));
        Area eastArea = new Area(new Ellipse2D.Double(x + halfSideLen, y + qtrSideLen, halfSideLen, halfSideLen));
        Area southArea = new Area(new Ellipse2D.Double(x + qtrSideLen, y + halfSideLen, halfSideLen, halfSideLen));
        Area westArea = new Area(new Ellipse2D.Double(x, y + qtrSideLen, halfSideLen, halfSideLen));

        g2d.setColor(borderColor);
        g2d.draw(northArea);
        g2d.draw(eastArea);
        g2d.draw(southArea);
        g2d.draw(westArea);

        // Color the intersection between the circles in this shapes's fill color

        // Make a copy of northArea so we can get it's intersect with westCircle after it's area is updated
        Area northAreaCopy = (Area) northArea.clone();

        northArea.intersect(eastArea);
        eastArea.intersect(southArea);
        southArea.intersect(westArea);
        westArea.intersect(northAreaCopy);

        g2d.setColor(fillColor);
        g2d.fill(northArea);
        g2d.fill(eastArea);
        g2d.fill(southArea);
        g2d.fill(westArea);
    }
}
