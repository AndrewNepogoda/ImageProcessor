package by.bsuir.iit.ip.processor;

import java.awt.image.BufferedImage;

import by.bsuir.iit.ip.processor.anaglyph.AnaglyphProvider;
import by.bsuir.iit.ip.processor.anaglyph.AnaglyphType;
import by.bsuir.iit.ip.processor.filter.FilterProvider;
import by.bsuir.iit.ip.processor.filter.FilterType;
import by.bsuir.iit.ip.processor.filter.ImageFilter;
import by.bsuir.iit.ip.processor.segmentation.Segmenter;
import by.bsuir.iit.ip.processor.segmentation.clastering.KMean;

/**
 * @author Andrew Nepogoda Feb 26, 2015
 */
public class ImageProcesserImpl implements ImageProcessor {

    private AnaglyphProvider anaglyphProvider = new AnaglyphProvider();

    private FilterProvider filterProvider = new FilterProvider();

    private Segmenter segmenter = new KMean();

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

    @Override
    public BufferedImage segmentImage(BufferedImage image, int segmentsCount) {

        return segmenter.calculate(image, segmentsCount);
    }
}