import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

class FilesSorter {
    private static void moveFile(String src, String dest ) {
        try {
            Files.move(Paths.get(src), Paths.get(dest));
        } catch (IOException e) {
            System.out.println("Exception while moving file: " + e.getMessage());
        }
    }

    static void sortFilesIntoAppropriatePackages(File file, Path pathToRootDirectory) throws IOException {
        if (file.isFile()) {
            String filename= file.getName();
            String fileNameArray[] = filename.split("\\.");
            File directoryForSpecificFiles = new File((String.valueOf(pathToRootDirectory)
                                                       + "\\" + fileNameArray[fileNameArray.length-1]).toUpperCase()
                                                       + "files");
            directoryForSpecificFiles.mkdir();
            moveFile(file.getAbsolutePath(),directoryForSpecificFiles.getAbsolutePath() + "\\" + filename);
            return;
        }
        if (file.getName().endsWith("files") && Character.isUpperCase(file.getName().charAt(0))
                                          && Character.isUpperCase(file.getName().charAt(file.getName().length()-6))) {
            return;
        }
        File[] files = file.listFiles();

            for (int i = 0; i < files.length; i++) {
                sortFilesIntoAppropriatePackages(files[i], pathToRootDirectory);
            }
            if (Objects.requireNonNull(file.listFiles()).length == 0) {
                file.delete();
            }


    }
}
