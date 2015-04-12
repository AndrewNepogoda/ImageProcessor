package by.bsuir.iit.ip.entry;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import by.bsuir.iit.ip.processor.ImageProcesserImpl;
import by.bsuir.iit.ip.processor.ImageProcessor;
import by.bsuir.iit.ip.processor.anaglyph.AnaglyphType;
import by.bsuir.iit.ip.processor.filter.FilterType;

/**
 * @author Andrew Nepogoda Feb 26, 2015
 */
public class EntryPoint {

    public static void main(String[] args) throws IOException {

        // Color c = new Color(793887);
        // System.out.print(c);

        ImageProcessor processor = new ImageProcesserImpl();
        // BufferedImage leftImg = null;
        // BufferedImage rightImg = null;
        // try {
        // leftImg = ImageIO.read(new File("./img/left.jpg"));
        // rightImg = ImageIO.read(new File("./img/right.jpg"));
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        // BufferedImage sourceImg = processor.buildAnagliph(leftImg, rightImg,
        // AnaglyphType.COLOR);
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("./img/filter.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        long start = System.currentTimeMillis();
        System.out.println(start);
        BufferedImage segmentImage = processor.segmentImage(image, 15);
        long end = System.currentTimeMillis();
        File outputfile1 = new File("saved1.jpg");
        ImageIO.write(segmentImage, "jpg", outputfile1);
        System.out.println(end);
        System.out.println("Creation time miles:" + (end - start));
        // long start = System.currentTimeMillis();
        // System.out.println(start);
        // BufferedImage sourceImg1 = processor.filter(image,FilterType.GREY);
        // BufferedImage sourceImg2 =
        // processor.filter(image,FilterType.REVERSE);
        // BufferedImage sourceImg3 = processor.filter(image,FilterType.SOBEL);
        // System.out.println("filter image");
        // long end = System.currentTimeMillis();
        // System.out.println(end);
        // System.out.println("Creation time miles:" + (end - start));
        // File outputfile1 = new File("saved1.jpg");
        // ImageIO.write(sourceImg1, "jpg", outputfile1);
        // File outputfile2 = new File("saved2.jpg");
        // ImageIO.write(sourceImg2, "jpg", outputfile2);
        // File outputfile3 = new File("saved3.jpg");
        // ImageIO.write(sourceImg3, "jpg", outputfile3);
        // System.out.println("view saved image");

    }

}