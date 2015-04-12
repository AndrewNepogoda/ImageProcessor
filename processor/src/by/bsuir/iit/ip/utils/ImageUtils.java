/**
 * 
 */
package by.bsuir.iit.ip.utils;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;

/**
 * @author Andrew Nepogoda Apr 5, 2015
 */
public class ImageUtils {

    public static final int MAX_INT_RGB = 16777215;

    public static int truncate(int value) {

        if (value > 255) {
            return 255;
        } else if (value < 0) {
            return 0;
        } else {
            return value;
        }
    }

    public static byte[] getBytes(BufferedImage image) {

        WritableRaster raster = image.getRaster();
        DataBufferByte buffer = (DataBufferByte) raster.getDataBuffer();
        return buffer.getData();
    }
}
