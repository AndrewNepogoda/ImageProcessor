package by.bsuir.iit.ip.entry;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import by.bsuir.iit.ip.constants.AnaglyphType;
import by.bsuir.iit.ip.processor.ImageProcesserImpl;
import by.bsuir.iit.ip.processor.ImageProcessor;

/**
 * @author Andrew Nepogoda Feb 26, 2015
 */
public class EntryPoint {

    public static void main(String[] args) throws IOException {

        long start = System.currentTimeMillis();
        System.out.println(start);
        ImageProcessor processor = new ImageProcesserImpl();
        BufferedImage leftImg = null;
        BufferedImage rightImg = null;
        try {
            leftImg = ImageIO.read(new File("./img/left.jpg"));
            rightImg = ImageIO.read(new File("./img/right.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedImage sourceImg = processor.buildAnagliph(leftImg, rightImg,
                AnaglyphType.OPTIMIZED);
        File outputfile = new File("saved.png");
        ImageIO.write(sourceImg, "png", outputfile);
        System.out.println("view saved image");
        long end = System.currentTimeMillis();
        System.out.println(end);
        System.out.println("Creation time miles:" + (end - start));
    }

}
