import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;

public class ImageResizer implements Runnable{

    private final File file;
    private String dstFolder;
    private String srcFolder;
    private int newWidth;
    static final int CORES = Runtime.getRuntime().availableProcessors();
    private static final Semaphore SEMAPHORE = new Semaphore(CORES, true);

    public ImageResizer(File file, String dstFolder, String srcFolder, int newWidth) {
        this.file = file;
        this.dstFolder = dstFolder;
        this.srcFolder = srcFolder;
        this.newWidth = newWidth;
    }

    @Override
    public void run() {

        long start = System.currentTimeMillis();
        try {
            SEMAPHORE.acquire();
            System.out.print("Thread " + this.getClass().getSimpleName() + " started");

                System.out.println(" File is: " + file.getName());
                BufferedImage image = ImageIO.read(file);
                if (image == null) {
                    Thread.currentThread().interrupt();
                };

                Scalr.resize(image, newWidth);

                File newFile = new File(dstFolder + "/scalr/" + file.getName());
                ImageIO.write(Scalr.resize(image, 300, Scalr.OP_ANTIALIAS), "jpg", newFile);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        SEMAPHORE.release();
        System.out.println("Thread " + this.getClass().getSimpleName() + " stoped. Duration: " + (System.currentTimeMillis() - start) + " ms");
    }
}
