/**
 * 
 */
package by.bsuir.iit.ip.utils;

/**
 * @author Andrew Nepogoda Apr 5, 2015
 */
public class ImageUtils {

    public static int truncate(int value) {

        if (value > 255) {
            return 255;
        } else if (value < 0) {
            return 0;
        } else {
            return value;
        }
    }
}
