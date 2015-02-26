/**
 * 
 */
package by.bsuir.iit.ip.anaglyph;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * @author Andrew Nepogoda Feb 26, 2015
 */
public abstract class AnaglyphBuilderImpl implements AnaglyphBuilder {

    @Override
    public BufferedImage buildAnaglyph(BufferedImage leftImage,
            BufferedImage rightImage) {

        int[][] leftMatrix = getLeftMatrix();
        int[][] rightMatrix = getRigthMatrix();
        BufferedImage sourceImg = new BufferedImage(leftImage.getWidth(),
                leftImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < leftImage.getWidth(); ++x) {
            for (int y = 0; y < leftImage.getHeight(); ++y) {
                Color color1 = new Color(leftImage.getRGB(x, y));
                Color color2 = new Color(rightImage.getRGB(x, y));
                int[] lrgb = { color1.getRed(), color1.getGreen(),
                        color1.getBlue() };
                int[] rrgb = { color2.getRed(), color2.getGreen(),
                        color2.getBlue() };
                int[] srgb = { 0, 0, 0 };

                for (int i = 0; i < 3; ++i) {
                    for (int j = 0; j < 3; ++j) {
                        srgb[i] += (leftMatrix[i][j] * lrgb[j] + rightMatrix[i][j]
                                * rrgb[j]);
                    }
                }
                Color sourceColor = new Color(srgb[0], srgb[1], srgb[2]);
                sourceImg.setRGB(x, y, sourceColor.getRGB());
            }
        }
        return sourceImg;
    }

}
