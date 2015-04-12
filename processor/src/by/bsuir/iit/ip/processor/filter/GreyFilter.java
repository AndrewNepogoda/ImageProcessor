/**
 * 
 */
package by.bsuir.iit.ip.processor.filter;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * @author Andrew Nepogoda Apr 8, 2015
 */
public class GreyFilter implements ImageFilter {

    @Override
    public BufferedImage process(BufferedImage image) {

        BufferedImage sourceImg = new BufferedImage(image.getWidth(), image.getHeight(),
                image.getType());
        int average = 0;
        for (int x = 0; x < image.getWidth(); ++x) {
            for (int y = 0; y < image.getHeight(); ++y) {
                Color color = new Color(image.getRGB(x, y));
                average = (int) (color.getBlue() * 0.299 + color.getRed() * 0.587 + color
                        .getGreen() * 0.144);
                Color sourceColor = new Color(average, average, average);
                sourceImg.setRGB(x, y, sourceColor.getRGB());
            }
        }
        return sourceImg;
    }

}
