/*
 *	===============================================================================
 *	MovingPixelArt.java : An extension of MovingRectangle.
 *  A MovingPixelArt can be defined using an array of numeric strings.
 *
 *  NOTE: This class deviates from the specifications a little in that it allows the pixel art to be resized such
 *  that it's rectangular, and it also allows the pixel art's definition to be rectangular. A simpler version that
 *  conforms to the specifications has been submitted to Coderunner2.
 *
 *  Name: Feras Albaroudi
 *  UPI: falb418
 *	===============================================================================
 */

import java.awt.*;
import java.awt.image.BufferedImage;

public class MovingPixelArt extends MovingRectangle {

    protected static final Color[] colours = {Color.black, Color.white, Color.red, Color.orange, Color.yellow,
            Color.green, Color.cyan, Color.blue, Color.gray, Color.DARK_GRAY};

    private BufferedImage pixelArt;

    /**
     * Constructor to create a MovingPixelArt
     *
     * @param values an array of values which describe the pixel art to be drawn, where the length of the array is equal
     *               to the length of each substring, and each substring is a sequence of numbers from 0 to 9
     *               (inclusive) representing the index of a colour in <a href="#colours">colours</a>.
     */
    public MovingPixelArt(String[] values) {
        super();
        pixelArt = createPixelArtImage(values);
    }

    /**
     * Constructor to create a MovingPixelArt
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
     * @param values   an array of values which describe the pixel art to be drawn, where the length of the array is
     *                 equal to the length of each substring, and each substring is a sequence of numbers from 0 to 9
     *                 (inclusive) representing the index of a colour in <a href="#colours">colours</a>
     */
    public MovingPixelArt(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, int pathType,
                          String[] values) {
        super(x, y, w, h, mw, mh, bc, fc, pathType);
        pixelArt = createPixelArtImage(values);
    }

    /**
     * Returns a new pixel art BufferedImage created from the given array of values. This can throw an
     * IllegalArgumentException if the given array is not valid, see {@link #checkValues} for details.
     *
     * @param values an array of values which describe the pixel art to be drawn, where the length of the array is equal
     *               to the length of each substring, and each substring is a sequence of numbers from 0 to 9
     *               (inclusive) representing the index of a colour in <a href="#colours">colours</a>
     * @return a new BufferedImage
     * @see BufferedImage
     */
    public static BufferedImage createPixelArtImage(String[] values) {

        checkValues(values);

        int width = values[0].length();
        int height = values.length;

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = bufferedImage.createGraphics();

        // Loop through each row
        for (int i = 0; i < values.length; i++) {

            String row = values[i];

            // Loop through each column on this row
            for (int j = 0; j < row.length(); j++) {

                // Draw each pixel one by one
                g2d.setColor(colours[Character.getNumericValue(row.charAt(j))]);
                g2d.fillRect(j, i, 1, 1);

            }

        }

        g2d.dispose();

        return bufferedImage;
    }

    /**
     * Throws an IllegalArgumentException if the given values are not valid.
     *
     * @param values the values to check
     * @throws IllegalArgumentException Values must contain at least one element
     * @throws IllegalArgumentException All strings in values must be the same length as the array
     * @throws IllegalArgumentException All strings in values must be numeric
     */
    private static void checkValues(String[] values) {

        if (values.length == 0) {
            throw new IllegalArgumentException("Values must contain at least one element");
        }

        int rowWidth = values[0].length();

        for (String value : values) {
            if (value.length() != rowWidth) {
                throw new IllegalArgumentException("All strings in values must be the same length");
            }

            // Check each character to make sure it's a number from 0 to 9 (inclusive)
            try {
                Integer.parseInt(value);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("All strings in values must be numeric");
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(pixelArt, x, y, width, height, null);
    }

}
