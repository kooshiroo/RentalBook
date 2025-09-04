package file.operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReader {

    // csvファイルのすべての行をリストに入れて返却する
    public List<String> getAllLines(Path path) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            for (String line; (line = reader.readLine()) != null; ) {
                lines.add(line);
            }
        } catch (NoSuchFileException e) {
            System.out.println("ファイルが見つかりません");
        } catch (IOException e) {
            System.out.println("ファイルの読み込みに失敗しました");
        }
        return lines;
    }

    // ヘッダーを除いた全行を返却する
    public List<String> getLinesExceptHeader(Path path) {
        List<String> allLines = getAllLines((path));
        return allLines.subList(1, allLines.size() - 1);
    }

    // ヘッダーのみ返却。リストにして返却
    public List<String> getHeaderItems(Path path) {
        List<String> allLines = getAllLines(path);
        return Arrays.asList(allLines.getFirst().split(","));
    }
}
