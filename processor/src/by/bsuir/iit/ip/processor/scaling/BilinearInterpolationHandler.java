/**
 * 
 */
package by.bsuir.iit.ip.processor.scaling;

import java.awt.image.BufferedImage;

/**
 * @author Andrew Nepogoda Apr 19, 2015
 */
public class BilinearInterpolationHandler implements ScalingHandler {

    @Override
    public BufferedImage resizeImage(BufferedImage oldImage, int newWidth, int newHeight) {

        int oldHeight = oldImage.getHeight();
        int oldWidth = oldImage.getWidth();
        BufferedImage sourceImage = new BufferedImage(newWidth, newHeight, oldImage.getType());
        int a, b, c, d, x, y;
        float x_ratio = ((float) (oldWidth - 1)) / newWidth;
        float y_ratio = ((float) (oldHeight - 1)) / newHeight;
        float x_diff, y_diff, blue, red, green;
        for (int i = 0; i < newHeight; i++) {
            for (int j = 0; j < newWidth; j++) {
                x = (int) (x_ratio * j);
                y = (int) (y_ratio * i);
                x_diff = (x_ratio * j) - x;
                y_diff = (y_ratio * i) - y;
                a = oldImage.getRGB(x, y);
                b = oldImage.getRGB(x + 1, y);
                c = oldImage.getRGB(x, y + 1);
                d = oldImage.getRGB(x + 1, y + 1);
                // Yb = Ab(1-w)(1-h) + Bb(w)(1-h) + Cb(h)(1-w) + Db(wh)
                blue = (a & 0xff) * (1 - x_diff) * (1 - y_diff) + (b & 0xff) * (x_diff)
                        * (1 - y_diff) + (c & 0xff) * (y_diff) * (1 - x_diff) + (d & 0xff)
                        * (x_diff * y_diff);
                // Yg = Ag(1-w)(1-h) + Bg(w)(1-h) + Cg(h)(1-w) + Dg(wh)
                green = ((a >> 8) & 0xff) * (1 - x_diff) * (1 - y_diff) + ((b >> 8) & 0xff)
                        * (x_diff) * (1 - y_diff) + ((c >> 8) & 0xff) * (y_diff) * (1 - x_diff)
                        + ((d >> 8) & 0xff) * (x_diff * y_diff);
                // Yr = Ar(1-w)(1-h) + Br(w)(1-h) + Cr(h)(1-w) + Dr(wh)
                red = ((a >> 16) & 0xff) * (1 - x_diff) * (1 - y_diff) + ((b >> 16) & 0xff)
                        * (x_diff) * (1 - y_diff) + ((c >> 16) & 0xff) * (y_diff) * (1 - x_diff)
                        + ((d >> 16) & 0xff) * (x_diff * y_diff);

                int rgb = 0xff000000 | ((((int) red) << 16) & 0xff0000)
                        | ((((int) green) << 8) & 0xff00) | ((int) blue);
                sourceImage.setRGB(j, i, rgb);
            }
        }
        return sourceImage;
    }

}
