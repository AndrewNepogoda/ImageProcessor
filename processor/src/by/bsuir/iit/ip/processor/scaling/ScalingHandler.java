/**
 * 
 */
package by.bsuir.iit.ip.processor.scaling;

import java.awt.image.BufferedImage;

/**
 * @author Andrew Nepogoda Apr 19, 2015
 */
public interface ScalingHandler {

    BufferedImage resizeImage(BufferedImage oldImage, int newHeight, int newWidth);
}
