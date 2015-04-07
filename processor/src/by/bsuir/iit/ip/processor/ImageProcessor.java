package by.bsuir.iit.ip.processor;

import java.awt.image.BufferedImage;

import by.bsuir.iit.ip.constants.AnaglyphType;

/**
 * @author Andrew Nepogoda Feb 26, 2015
 */
public interface ImageProcessor {

    public BufferedImage buildAnagliph(BufferedImage leftImage,
            BufferedImage rightImage, AnaglyphType type);
}
