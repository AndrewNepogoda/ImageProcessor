package by.bsuir.iit.ip.processor.anaglyph;

import java.awt.image.BufferedImage;

/**
 * @author Andrew Nepogoda Feb 26, 2015
 */
public interface AnaglyphBuilder {

    BufferedImage buildAnaglyph(BufferedImage leftImage,
            BufferedImage rightImage);

}
