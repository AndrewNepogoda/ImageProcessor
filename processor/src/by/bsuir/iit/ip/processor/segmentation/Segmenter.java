/**
 * 
 */
package by.bsuir.iit.ip.processor.segmentation;

import java.awt.image.BufferedImage;


/**
 * @author Andrew Nepogoda
 * Apr 10, 2015
 */
public interface Segmenter {
    BufferedImage calculate(BufferedImage image, int segmentsCount);
}
