/**
 * 
 */
package by.bsuir.iit.ip.processor.filter;

/**
 * @author Andrew Nepogoda Apr 8, 2015
 */
public class FilterProvider {

    public ImageFilter getFilter(FilterType type) {

        switch (type) {
            case GREY:
                return new GreyFilter();
            case REVERSE:
                return new ReverseFilter();
            case SOBEL:
                return new MatrixImageFilter(new double[][] { { -1, -1, 1 }, { -2, 0, 2 },
                        { -1, 0, 1 } });
            default:
                throw new IllegalArgumentException("not support filter type");
        }

    }
}
