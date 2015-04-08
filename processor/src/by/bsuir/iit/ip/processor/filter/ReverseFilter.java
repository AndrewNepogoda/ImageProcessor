/**
 * 
 */
package by.bsuir.iit.ip.processor.filter;

import java.awt.image.BufferedImage;

import by.bsuir.iit.ip.utils.ImageUtils;

/**
 * @author Andrew Nepogoda Apr 5, 2015
 */
public class ReverseFilter implements ImageFilter {

    @Override
    public BufferedImage process(BufferedImage image) {

        BufferedImage sourceImg = new BufferedImage(image.getWidth(), image.getHeight(),
                image.getType());
        byte[] oldBytes = ImageUtils.getBytes(image);
        byte[] newBytes = ImageUtils.getBytes(sourceImg);

        for (int i = 0; i < oldBytes.length; ++i) {
            newBytes[i] = (byte) (255 - (int) oldBytes[i]);
        }
        return sourceImg;
    }

}
