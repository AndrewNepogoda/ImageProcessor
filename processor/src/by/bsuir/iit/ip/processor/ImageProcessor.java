package by.bsuir.iit.ip.processor;

import java.awt.image.BufferedImage;

import by.bsuir.iit.ip.processor.anaglyph.AnaglyphType;
import by.bsuir.iit.ip.processor.filter.FilterType;

/**
 * @author Andrew Nepogoda Feb 26, 2015
 */
public interface ImageProcessor {

    public BufferedImage buildAnagliph(BufferedImage leftImage, BufferedImage rightImage,
            AnaglyphType type);

    public BufferedImage filter(BufferedImage image, FilterType type);

    public BufferedImage segmentImage(BufferedImage image, int segmentsCount);
}
