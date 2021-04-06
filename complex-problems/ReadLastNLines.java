import java.io.File;
import java.io.RandomAccessFile;

public class ReadLastNLines {
    public String readNLines(String filePath, int n) {
        StringBuilder sb = new StringBuilder();
        File fp = new File(String.valueOf(filePath));
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(fp, "r");
            long fileLen = fp.length() - 1;
            randomAccessFile.seek(fileLen);
            int readLines = 0;
            for (long currPtr = fileLen - 1; currPtr >= 0; currPtr--) {
                randomAccessFile.seek(currPtr);
                char c = (char)randomAccessFile.read();
                if (c == '\n') {
                    readLines++;
                    if (readLines == n) {
                        break;
                    }
                }
                sb.append(c);
            }
            sb.reverse();
            return sb.toString();
        } catch (Exception e) {
            System.err.println("Failed to access file: " + filePath);
            return null;
        }
    }

    public static void main(String[] args) {
        String result = new ReadLastNLines().readNLines("/Users/aamiray/Documents/Technical/Study/My_Codes/Java/DataStruture/resource/test.json", 22);
        System.out.println(result);
    }
}

