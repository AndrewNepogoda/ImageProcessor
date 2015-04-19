/**
 * 
 */
package by.bsuir.iit.ip.processor.rotation;

import java.awt.image.BufferedImage;

/**
 * @author Andrew Nepogoda Apr 19, 2015
 */
public class RotationHandlerImpl implements RotationHandler {

    @Override
    public BufferedImage rotate(BufferedImage image, double angle) {

        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage sourceImage = new BufferedImage(image.getWidth(), image.getHeight(),
                image.getType());
        double angleRadians = Math.toRadians(angle);
        double sin = Math.sin(angleRadians);
        double cos = Math.cos(angleRadians);
        double x0 = 0.5 * width;
        double y0 = 0.5 * height;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                double a = i - x0;
                double b = j - y0;
                int x = (int) (a * cos - b * sin + x0);
                int y = (int) (a * sin + b * cos + y0);
                if (x >= 0 && x < width && y >= 0 && y < height) {
                    sourceImage.setRGB(i, j, image.getRGB(x, y));
                }
            }
        }
        return sourceImage;
    }

}
