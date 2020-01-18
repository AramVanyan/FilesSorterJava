import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        File file1 = new File("C:\\Users\\Aram_Vanyan\\Desktop\\Sharing-Cryptography & Steganography");
        try {
            FilesSorter.sortFilesIntoAppropriatePackages(file1, Paths.get(file1.getAbsolutePath().toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
