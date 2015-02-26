package by.bsuir.iit.ip.anaglyph;

import by.bsuir.iit.ip.constants.AnaglyphType;

/**
 * @author Andrew Nepogoda Feb 26, 2015
 */
public class AnaglyphProvider {

    private class ColorAnaglyphBuilder extends AnaglyphBuilderImpl {

        @Override
        public int[][] getLeftMatrix() {

            return new int[][] { { 1, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
        }

        @Override
        public int[][] getRigthMatrix() {

            return new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
        }

    }

    public AnaglyphBuilder getAnaglyphBuilder(AnaglyphType type) {

        switch (type) {
            case COLOR:
                return new ColorAnaglyphBuilder();
            default:
                throw new IllegalArgumentException("Illegal anaglyph type");

        }
    }
}
