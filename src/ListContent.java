import java.io.File;
import java.io.FilenameFilter;

public class ListContent {

    public static void main(String[] args) {
        //question1();
        rechercher(new File("."), "+");

    }

    public static void question1(){
        File repertoire = new File(".");
        String filenames[] = repertoire.list();

        for(String filename:filenames){
            System.out.println(filename);
        }
    }

    public static void rechercher(File f, String prefix){
        File files[] = f.listFiles();
        if(files == null){
            return;
        }
        for(File file:files){
            System.out.println(prefix + file.getName());
            if (file.isDirectory()) {
                rechercher(file, "-");
            }
        }
    }

    public static class MyFileNameFilter implements FilenameFilter {
        @Override
        public boolean accept(File dir, String fileName) {
            if (fileName.endsWith(".java")) {
                return true;
            }
            return false;
        }
    }

}