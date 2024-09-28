package structural;
import java.io.File;
public class FacadeDemo {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.updateFilePathinDB("test.jpg");
    }
}

class FileHandler{
    S3Handler s3Handler;
    DBHandler dbHandler;
    public boolean updateFilePathinDB(String filePath){
        File file = s3Handler.getFile(filePath);
        return dbHandler.updateFilePath(file);
    }
}
class S3Handler{
    public File getFile(String filePath){
        return new File(filePath);
    }
}
class DBHandler{
    public boolean updateFilePath(File file){
        return true;
    }
}