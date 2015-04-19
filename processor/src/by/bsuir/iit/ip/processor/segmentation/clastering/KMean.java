/**
 * 
 */
package by.bsuir.iit.ip.processor.segmentation.clastering;

import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Random;

import by.bsuir.iit.ip.processor.segmentation.Segmenter;

/**
 * @author Andrew Nepogoda Apr 10, 2015
 */
public class KMean implements Segmenter {

    private ImageCluster[] clusters;

    class ImageCluster {

        int r;

        int g;

        int b;

        int red;

        int green;

        int blue;

        int clusterID;

        int pixelCount;

        int getID() {

            return this.clusterID;
        }

        ImageCluster(int id, int rgb) {

            this.clusterID = id;
            this.r = rgb >> 16 & 0x000000FF;
            this.g = rgb >> 8 & 0x000000FF;
            this.b = rgb & 0x000000FF;
            this.red = this.r;
            this.green = this.g;
            this.blue = this.b;
        }

        int getRGB() {

            return 0xff000000 | this.red << 16 | this.green << 8 | this.blue;
        }

        void addPixel(int rgb) {

            this.r += rgb >> 16 & 0x000000FF;
            this.g += rgb >> 8 & 0x000000FF;
            this.b += rgb & 0x000000FF;
            this.pixelCount++;
            recalculateRGB();
        }

        void removePixel(int rgb) {

            this.r -= rgb >> 16 & 0x000000FF;
            this.g -= rgb >> 8 & 0x000000FF;
            this.b -= rgb & 0x000000FF;
            this.pixelCount--;
            if (this.pixelCount != 0) {
                recalculateRGB();
            } else {
                this.red = this.r;
                this.green = this.g;
                this.blue = this.b;
            }
        }

        private void recalculateRGB() {

            this.red = this.r / this.pixelCount;
            this.green = this.g / this.pixelCount;
            this.blue = this.b / this.pixelCount;
        }

        int calculateDistance(int rgb) {

            int r = rgb >> 16 & 0x000000FF;
            int g = rgb >> 8 & 0x000000FF;
            int b = rgb & 0x000000FF;
            int rx = Math.abs(this.red - r);
            int gx = Math.abs(this.green - g);
            int bx = Math.abs(this.blue - b);
            int d = (rx + gx + bx) / 3;
            return d;
        }

    }

    private ImageCluster[] createClusters(int count) {

        ImageCluster[] clusters = new ImageCluster[count];
        Random r = new Random();
        for (int i = 0; i < count; ++i) {
            // random value
            clusters[i] = new ImageCluster(i, i * count + 1);
        }
        return clusters;
    }

    public ImageCluster findMinimalCluster(int rgb) {

        ImageCluster cluster = null;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < clusters.length; i++) {
            int distance = clusters[i].calculateDistance(rgb);
            if (distance < min) {
                min = distance;
                cluster = clusters[i];
            }
        }
        return cluster;
    }

    @Override
    public BufferedImage calculate(BufferedImage image, int segmentsCount) {

        int w = image.getWidth();
        int h = image.getHeight();
        clusters = createClusters(segmentsCount);
        int[] lut = new int[w * h];
        Arrays.fill(lut, -1);
        boolean pixelChangedCluster = true;
        while (pixelChangedCluster) {
            pixelChangedCluster = false;
            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    int pixel = image.getRGB(x, y);
                    ImageCluster cluster = findMinimalCluster(pixel);
                    if (lut[w * y + x] != cluster.getID()) {
                        if (lut[w * y + x] != -1) {
                            clusters[lut[w * y + x]].removePixel(pixel);
                        }
                        cluster.addPixel(pixel);
                        pixelChangedCluster = true;
                        lut[w * y + x] = cluster.getID();
                    }
                }
            }

        }
        BufferedImage result = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int clusterId = lut[w * y + x];
                result.setRGB(x, y, clusters[clusterId].getRGB());
            }
        }
        return result;
    }

}
