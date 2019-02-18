import java.io.File;
import java.io.FilenameFilter;

public class FilenameFilterExternal extends ListContent implements FilenameFilter{
    @Override
    public boolean accept(File dir, String fileName) {
        if (fileName.endsWith(".java")) {
            return true;
        }
        return false;
    }

    
}
