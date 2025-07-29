import java.io.File;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

public class Main {



    public static void main(String[] args) throws InterruptedIOException {
        String srcFolder = "src/assets/src";
        String dstFolder = "src/assets/dst";
        File srcDir = new File(srcFolder);
        long start = System.currentTimeMillis();
        File[] files = srcDir.listFiles();
        List<File[]> filesList = new ArrayList<>();

        for(int i = 0; i < files.length; i++){
            new Thread(new ImageResizer(files[i], dstFolder, srcFolder, 300)).start();
        }
    }
}
