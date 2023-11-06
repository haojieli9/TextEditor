package extra;
import java.io.File;
import java.util.Date;

public class FileInfo {
    private String fileName;
    private String filePath;
    private long fileSize;
    private Date lastModified;

    public FileInfo(String fileName, String filePath) {
        this.fileName = fileName;
        this.filePath = filePath;
        File file = new File(filePath);
        this.fileSize = file.length();
        this.lastModified = new Date(file.lastModified());
    }

    public String getFileName() {
        return fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public long getFileSize() {
        return fileSize;
    }

    public Date getLastModified() {
        return lastModified;
    }

    @Override
    public String toString() {
        return "File name: " + fileName + "\n" +
               "Path: " + filePath + "\n" +
               "Size: " + fileSize + " bytes" + "\n" +
               "Last modification: " + lastModified;
    }
}
