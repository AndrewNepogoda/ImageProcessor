package by.bsuir.iit.ip.processor.anaglyph;


/**
 * @author Andrew Nepogoda Feb 26, 2015
 */
public class AnaglyphProvider {

    public AnaglyphBuilder getAnaglyphBuilder(AnaglyphType type) {

        return new AnaglyphBuilderImpl(type);

    }
}
