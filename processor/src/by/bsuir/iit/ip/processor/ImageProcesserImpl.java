package by.bsuir.iit.ip.processor;

import java.awt.image.BufferedImage;

import by.bsuir.iit.ip.processor.anaglyph.AnaglyphProvider;
import by.bsuir.iit.ip.processor.anaglyph.AnaglyphType;
import by.bsuir.iit.ip.processor.filter.FilterProvider;
import by.bsuir.iit.ip.processor.filter.FilterType;
import by.bsuir.iit.ip.processor.filter.GreyFilter;
import by.bsuir.iit.ip.processor.filter.ImageFilter;
import by.bsuir.iit.ip.processor.filter.MatrixImageFilter;
import by.bsuir.iit.ip.processor.filter.ReverseFilter;

/**
 * @author Andrew Nepogoda Feb 26, 2015
 */
public class ImageProcesserImpl implements ImageProcessor {

    private AnaglyphProvider anaglyphProvider = new AnaglyphProvider();

    private FilterProvider filterProvider = new FilterProvider();

    @Override
    public BufferedImage buildAnagliph(BufferedImage leftImage, BufferedImage rightImage,
            AnaglyphType type) {

        BufferedImage sourceImg = anaglyphProvider.getAnaglyphBuilder(type).buildAnaglyph(
                leftImage, rightImage);
        return sourceImg;
    }

    @Override
    public BufferedImage filter(BufferedImage image, FilterType type) {

        ImageFilter filter = filterProvider.getFilter(type);
        return filter.process(image);
    }
}