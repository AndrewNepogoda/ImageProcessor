package by.bsuir.iit.ip.processor;

import java.awt.image.BufferedImage;

import by.bsuir.iit.ip.constants.AnaglyphType;
import by.bsuir.iit.ip.processor.anaglyph.AnaglyphProvider;
import by.bsuir.iit.ip.processor.filter.ImageFilter;
import by.bsuir.iit.ip.processor.filter.MatrixImageFilter;

/**
 * @author Andrew Nepogoda Feb 26, 2015
 */
public class ImageProcesserImpl implements ImageProcessor {

    private AnaglyphProvider anaglyphProvider = new AnaglyphProvider();

    @Override
    public BufferedImage buildAnagliph(BufferedImage leftImage, BufferedImage rightImage,
            AnaglyphType type) {

        BufferedImage sourceImg = anaglyphProvider.getAnaglyphBuilder(type).buildAnaglyph(
                leftImage, rightImage);
        return sourceImg;
    }

    @Override
    public BufferedImage filter(BufferedImage image) {

        ImageFilter filter = new MatrixImageFilter(new double[][] { { -1, -1, 1 }, { -2, 0, 2 },
                { -1, 0, 1 } });

        return filter.process(image);
    }

}
