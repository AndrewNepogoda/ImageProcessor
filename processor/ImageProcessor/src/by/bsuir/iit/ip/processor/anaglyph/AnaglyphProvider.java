package by.bsuir.iit.ip.processor.anaglyph;

import by.bsuir.iit.ip.constants.AnaglyphType;

/**
 * @author Andrew Nepogoda Feb 26, 2015
 */
public class AnaglyphProvider {

    public AnaglyphBuilder getAnaglyphBuilder(AnaglyphType type) {

        switch (type) {
            case COLOR:
                return new AnaglyphBuilderImpl(type);
            default:
                throw new IllegalArgumentException("Illegal anaglyph type");

        }
    }
}
