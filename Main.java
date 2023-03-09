import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Main {
    static StringBuilder logsBuilder = new StringBuilder();
    public static void main(String[] args) {
        writeLogs("Начинаем распаковывать игру");
        String[] array = {"C:/Apps/Games/", "/src/", "/res/", "/savegames/", "/temp/", "/src/main/", "/src/test/", "/res/drawables/", "/res/vectors/", "/res/icons/"};
        File installDir = new File(array[0]);
        createPath(installDir);
        for (int i = 1; i < array.length; i++) {
            installDir = new File(array[0] + array[i]);
            createPath(installDir);
        }
        File newFile1 = new File(array[0] + array[5], "Main.java");
        try {
            if (newFile1.createNewFile()) {
                writeLogs("Файл успешно создан " + newFile1.getAbsolutePath());
            } else writeLogs("Ошибка создания " + newFile1.getAbsolutePath());
        } catch (IOException e) {
            writeLogs(e.getMessage());
        }
        File newFile2 = new File(array[0] + array[5], "Utils.java");
        try {
            if (newFile2.createNewFile()) {
                writeLogs("Файл успешно создан " + newFile2.getAbsolutePath());
            } else writeLogs("Ошибка создания " + newFile2.getAbsolutePath());
        } catch (IOException e) {
            writeLogs(e.getMessage());
        }
        File newFile3 = new File(array[0] + array[4], "temp.txt");
        try {
            if (newFile3.createNewFile()) {
                writeLogs("Файл успешно создан " + newFile3.getAbsolutePath());
                FileWriter writer = new FileWriter(newFile3);
                writer.write(logsBuilder.toString());
                writer.flush();
                writer.close();
            } else writeLogs("Ошибка создания " + newFile3.getAbsolutePath());
        } catch (IOException e) {
            writeLogs(e.getMessage());
        }
        System.out.println(logsBuilder.toString());

    }

    public static void writeLogs(String args) {
        Date currDate = new Date();
        logsBuilder.append(currDate.toString() + ": " + args + "\n");
    }

    public static void createPath(File args) {
        File someDirs = new File(args.toURI());
        if (someDirs.mkdir())
            writeLogs("папка " + someDirs.toPath() + " создана");
        else {
            writeLogs("ошибка создания " + someDirs.toPath());
        }
    }
}