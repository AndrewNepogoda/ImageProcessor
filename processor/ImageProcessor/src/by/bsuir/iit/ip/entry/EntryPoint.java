package by.bsuir.iit.ip.entry;

import java.awt.Color;
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
//        Color c = new Color(793887);
//        System.out.print(c);
        
       
        ImageProcessor processor = new ImageProcesserImpl();
//        BufferedImage leftImg = null;
//        BufferedImage rightImg = null;
//        try {
//            leftImg = ImageIO.read(new File("./img/left.jpg"));
//            rightImg = ImageIO.read(new File("./img/right.jpg"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        BufferedImage sourceImg = processor.buildAnagliph(leftImg, rightImg,
//                AnaglyphType.COLOR);
        BufferedImage image = null;
        try{
            image = ImageIO.read(new File("./img/filter.jpg"));
        }catch(IOException e){
            e.printStackTrace();
        }
        long start = System.currentTimeMillis();
        System.out.println(start);
        BufferedImage sourceImg = processor.filter(image);
        System.out.println("filter image");
        long end = System.currentTimeMillis();
        System.out.println(end);
        System.out.println("Creation time miles:" + (end - start));
        File outputfile = new File("saved.jpg");
        ImageIO.write(sourceImg, "jpg", outputfile);
        System.out.println("view saved image");
    
        
        
    }

}
