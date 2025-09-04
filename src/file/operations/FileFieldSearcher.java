package file.operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileFieldSearcher {
    private final Path filePath;

    public FileFieldSearcher(Path path) {
        this.filePath = path;
    }

    // fieldNameというフィールドにitemNameという値があるかどうか
    public boolean ifHeaderContainsItem(String fieldName, String itemName) {
        try {
            List<String> headerList = getFieldItems(fieldName);
            return headerList.contains(itemName);
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // fieldNameというフィールドにitemNameという値があった場合、その１行の値たちをリストに入れて返却する。複数あっても最初の一つ目のみ返却
    public List<String> getLineItems(String fieldName, String itemName) throws IllegalAccessException {
        List<String> lineItems = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            List<String> headerList = Arrays.asList(reader.readLine().split(","));  // ヘッダーリスト
            if (!headerList.contains(fieldName)) {  // ヘッダーリストにfieldNameが存在しない場合
                throw new IllegalAccessException(fieldName + "というフィールドは存在しません");
            }
            int itemIndex = headerList.indexOf(fieldName);  // ヘッダーリストにおけるfieldNameのインデックス
            for (String line; (line = reader.readLine()) != null; ) {  // 一行ずつ読み込む
                if (itemName.equals(line.split(",")[itemIndex])) {  // もしitemNameがlineからなる文字列リストのitemIndexに当たるものと一致した場合
                    lineItems.addAll(Arrays.asList(line.split(",")));  // lineからなる文字列リストの全値をlineItemsに格納
                    return lineItems;
                }
            }
        } catch (NoSuchFileException e) {
            System.out.println("ファイルが見つかりません");
        } catch (IOException e) {
            System.out.println("ファイルの読み込みに失敗しました");
        }
        throw new IllegalArgumentException(itemName + "というは" + fieldName + "にはありません");
    }

    // ファイルの内、あるフィールドfieldNameに当たる一列分の値たちをリストにして返却
    public List<String> getFieldItems(String fieldName) throws IllegalAccessException{
        List<String> headerItems = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            List<String> headerList = Arrays.asList(reader.readLine().split(","));  // ヘッダーリスト
            if (!headerList.contains(fieldName)) {  // ヘッダーリストにfieldNameが存在しない場合
                throw new IllegalAccessException(fieldName + "というフィールドは存在しません");
            }
            int itemIndex = headerList.indexOf(fieldName);  // ヘッダーリストにおけるfieldNameのインデックス
            for (String line; (line = reader.readLine()) != null; ) {  // 一行ずつ読み込む
                headerItems.add(line.split(",")[itemIndex]);  // 一行をStringの配列に変換し、itemIndexに当たる文字列をheaderItemに格納
            }
        } catch (NoSuchFileException e) {
            System.out.println("ファイルが見つかりません");
        } catch (IOException e) {
            System.out.println("ファイルの読み込みに失敗しました");
        }
        return headerItems;
    }
}
