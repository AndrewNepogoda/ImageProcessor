/**
 * 
 */
package by.bsuir.iit.ip.processor.anaglyph;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * @author Andrew Nepogoda Feb 26, 2015
 */
public class AnaglyphBuilderImpl implements AnaglyphBuilder {

    private AnaglyphType dataType;

    public AnaglyphBuilderImpl(AnaglyphType type) {

        this.dataType = type;
    }

    @Override
    public BufferedImage buildAnaglyph(BufferedImage leftImage,
            BufferedImage rightImage) {

        double[][] leftMatrix = dataType.getLeftMatrix();
        double[][] rightMatrix = dataType.getRightMatrix();
        BufferedImage sourceImg = new BufferedImage(leftImage.getWidth(),
                leftImage.getHeight(), leftImage.getType());
        for (int x = 0; x < leftImage.getWidth(); ++x) {
            for (int y = 0; y < leftImage.getHeight(); ++y) {
                Color leftColor = new Color(leftImage.getRGB(x, y));
                Color rightColor = new Color(rightImage.getRGB(x, y));
                int[] lrgb = { leftColor.getRed(), leftColor.getGreen(),
                        leftColor.getBlue() };
                int[] rrgb = { rightColor.getRed(), rightColor.getGreen(),
                        rightColor.getBlue() };
                int[] srgb = { 0, 0, 0 };
                int size = leftMatrix.length;
                for (int i = 0; i < size; ++i) {
                    for (int j = 0; j < size; ++j) {
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
