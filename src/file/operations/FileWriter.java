package file.operations;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FileWriter {
    private Path filePath;

    public FileWriter(Path path) {
        this.filePath = path;
    }

    // 引数のリストの各要素を各ヘッダーの要素として、一行分ファイルに書き込む
    public boolean append(List<String> fieldList) {
        try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            for (String field : fieldList) {
                writer.append(field);
                writer.append(",");
            }
            writer.newLine();
        } catch (NoSuchFileException e) {
            System.out.println("ファイルが見つかりません");
            return false;
        } catch (IOException e) {
            System.out.println("書き込みに失敗しました");
            return false;
        }
        return true;
    }

    // ヘッダー名と値のセットを受けて１レコードを書き込む
    public boolean appendMap(Map<String, String> map) {
        FileReader fileReader = new FileReader();
        Set<String> keySet = map.keySet();
        List<String> headerItems = fileReader.getHeaderItems(filePath);

        try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            for (String item : headerItems) {  // ヘッダーの項目それぞれに対して
                if (keySet.contains(item)) {  // もしmapのキーにヘッダーの項目が含まれていたら
                    writer.append(map.get(item));  // そのキーに当たるmapの値を書き込む。
                    writer.append(",");
                } else {
                    writer.append(" ");  // mapのキーにヘッダーの項目が含まれないとき、そのヘッダーの値は空白となる
                    writer.append(",");
                }
            }
            writer.newLine();
        } catch (NoSuchFileException e) {
            System.out.println("ファイルが見つかりません");
            return false;
        } catch (IOException e) {
            System.out.println("書き込みに失敗しました");
            return false;
        }
        return true;
    }
}
