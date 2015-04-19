/**
 * 
 */
package by.bsuir.iit.ip.processor.rotation;

import java.awt.image.BufferedImage;


/**
 * @author Andrew Nepogoda
 * Apr 19, 2015
 */
public interface RotationHandler {
    BufferedImage rotate(BufferedImage image, double angle);
}
