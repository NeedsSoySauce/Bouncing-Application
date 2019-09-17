/*
 *	===============================================================================
 *	MovingImage.java : An extension of MovingRectangle.
 *  MovingImage allows an image from the user's system to be drawn. The given border and fill color are still
 *  used to draw a border around the image's bounding box and fill in any transparent areas, however these can be set to
 *  be transparent if they aren't desired.
 *
 *  Name: Feras Albaroudi
 *  UPI: falb418
 *	===============================================================================
 */

import java.awt.*;

public class MovingImage extends MovingRectangle {

    private Image image;

    /**
     * Constructor to create a MovingImage
     *
     * @param image the image to be drawn
     */
    public MovingImage(Image image) {
        super();
        this.image = image;
    }

    /**
     * Constructor to create a MovingImage
     *
     * @param sideLength value to use as the width and height of this image
     * @param image      the image to be drawn
     */
    public MovingImage(int sideLength, Image image) {
        super(sideLength);
        this.image = image;
    }

    /**
     * Constructor to create a MovingImage
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
     * @param image    the image to be drawn
     */
    public MovingImage(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, int pathType,
                       Image image) {
        super(x, y, w, h, mw, mh, bc, fc, pathType);
        this.image = image;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, x, y, width, height, null);
    }
}
