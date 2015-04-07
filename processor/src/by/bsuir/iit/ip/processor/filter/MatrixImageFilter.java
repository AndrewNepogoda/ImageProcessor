/**
 * 
 */
package by.bsuir.iit.ip.processor.filter;

import java.awt.Color;
import java.awt.image.BufferedImage;

import by.bsuir.iit.ip.utils.ImageUtils;

/**
 * @author Andrew Nepogoda Mar 14, 2015
 */
public class MatrixImageFilter implements ImageFilter {

    private double[][] filterMatrix;

    /**
     * 
     */
    public MatrixImageFilter(double[][] filterMatrix) {

        this.filterMatrix = filterMatrix;
    }

    @Override
    public BufferedImage process(BufferedImage image) {

        BufferedImage sourceImg = new BufferedImage(image.getWidth(), image.getHeight(),
                BufferedImage.TYPE_INT_RGB);
        int size = filterMatrix.length;
        int offset = size / 2;
        for (int x = offset; x < image.getWidth() - offset; ++x) {
            for (int y = offset; y < image.getHeight() - offset; ++y) {
                int sourceR = 0;
                int sourceG = 0;
                int sourceB = 0;
                for (int i = 0; i < size; ++i) {
                    for (int j = 0; j < size; ++j) {
                        Color color = new Color(image.getRGB(x - offset + i, y - offset + j));
                        sourceR += color.getRed() * filterMatrix[i][j];
                        sourceG += color.getGreen() * filterMatrix[i][j];
                        sourceB += color.getBlue() * filterMatrix[i][j];
                    }
                }
                Color sourceColor = new Color(ImageUtils.truncate(sourceR),
                        ImageUtils.truncate(sourceG), ImageUtils.truncate(sourceB));
                sourceImg.setRGB(x, y, sourceColor.getRGB());
            }
        }
        return sourceImg;
    }

}
