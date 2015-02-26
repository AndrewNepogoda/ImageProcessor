package by.bsuir.iit.ip.processer;

import java.awt.image.BufferedImage;

import by.bsuir.iit.ip.anaglyph.AnaglyphProvider;
import by.bsuir.iit.ip.constants.AnaglyphType;

/**
 * @author Andrew Nepogoda Feb 26, 2015
 */
public class ImageProcesserImpl implements ImageProcessor {

    private AnaglyphProvider anaglyphProvider = new AnaglyphProvider();

    @Override
    public BufferedImage buildAnagliph(BufferedImage leftImage,
            BufferedImage rightImage, AnaglyphType type) {

        BufferedImage sourceImg = anaglyphProvider.getAnaglyphBuilder(type)
                .buildAnaglyph(leftImage, rightImage);
        return sourceImg;
    }

}
