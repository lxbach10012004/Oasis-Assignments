import java.io.*;

public class Utils {

    /**
     * Reads the content of a file and returns it as a string.
     *
     * @param path The path of the file to be read.
     * @return The content of the file as a string.
     */
    public static String readContentFromFile(String path) {
        StringBuilder s = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                s.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s.toString();
    }

    /**
     * Writes the specified content to a file.
     *
     * @param path The path of the file to write to.
     * @param s    The content to be written to the file.
     */
    public static void writeContentToFile(String path, String s) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Appends the specified content to the end of a file.
     *
     * @param path The path of the file to append to.
     * @param s    The content to be appended to the file.
     */
    public static void appendContentToFile(String path, String s) {
        try {
            String old = readContentFromFile(path);
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(old + "\n" + s);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Finds a file by name in the specified folder.
     *
     * @param folderPath The path of the folder to search in.
     * @param fileName   The name of the file to find.
     * @return The File object if found, or null if not found.
     */
    public static File findFileByName(String folderPath, String fileName) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        for (File file : files) {
            if (file.getName().equals(fileName)) {
                return file;
            }
        }
        return null;
    }
}
