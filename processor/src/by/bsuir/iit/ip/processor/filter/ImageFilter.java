/**
 * 
 */
package by.bsuir.iit.ip.processor.filter;

import java.awt.image.BufferedImage;


/**
 * @author Andrew Nepogoda
 * Mar 14, 2015
 */
public interface ImageFilter {
    BufferedImage process(BufferedImage image);
}
