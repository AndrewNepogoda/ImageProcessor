package by.bsuir.iit.ip.anaglyph;

import java.awt.image.BufferedImage;

/**
 * @author Andrew Nepogoda Feb 26, 2015
 */
public interface AnaglyphBuilder {

    public BufferedImage buildAnaglyph(BufferedImage leftImage,
            BufferedImage rightImage);

    int[][] getLeftMatrix();

    int[][] getRigthMatrix();
}
