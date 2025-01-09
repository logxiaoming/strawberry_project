package ML;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelDataReader {

    // 假设我们关注的列索引（从0开始）
    private static final int c3 = 3;
    private static final int c4 = 4;
    private static final int c5 = 5;
    private static final int c6 = 6;
    private static final int c7 = 7;
    private static final int c8 = 8;
    private static final int c9 = 9;
    private static final int c10 = 10;
    private static final int c11 = 11;
    private static final int c12 = 12;
    private static final int c13 = 13;
    private static final int c14 = 14;
    private static final int c15 = 15;
    private static final int c16 = 16;
    private static final int c17 = 17;
    private static final int c21 = 21;


    public static void main(String[] args) {

        String excelFilePath = "C:\\Users\\xiaoming\\Desktop\\农业大数据实训2024-06\\" +
                "草莓农业大棚实时数据异常监控\\data\\housedata.xlsx"; // Excel文件路径
        List<double[]> features = readExcelFile(excelFilePath);

        System.out.println("读取到" + features.size() + "条数据");


        // 输出特征数据，仅作为示例
        for (double[] feature : features) {
            System.out.println(java.util.Arrays.toString(feature));
        }

    }



//    读取excel数据的函数
    public static List<double[]> readExcelFile(String filePath) {
        List<double[]> features = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new HSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // 假设数据在第一个工作表上

            // 跳过标题行
            int startRow = 1; // 如果第一行是标题，则从第二行开始读取

            for (int rowNum = startRow; rowNum <= sheet.getLastRowNum(); rowNum++) {
                Row row = sheet.getRow(rowNum);
                if (row != null) {
                    double[] feature = new double[16];

                    // 读取特征值
                    Cell f3 = row.getCell(c3);
                    Cell f4 = row.getCell(c4);
                    Cell f5 = row.getCell(c5);
                    Cell f6 = row.getCell(c6);
                    Cell f7 = row.getCell(c7);
                    Cell f8 = row.getCell(c8);
                    Cell f9 = row.getCell(c9);
                    Cell f10 = row.getCell(c10);
                    Cell f11 = row.getCell(c11);
                    Cell f12 = row.getCell(c12);
                    Cell f13 = row.getCell(c13);
                    Cell f14 = row.getCell(c14);
                    Cell f15 = row.getCell(c15);
                    Cell f16 = row.getCell(c16);
                    Cell f17 = row.getCell(c17);
                    Cell f21 = row.getCell(c21);


                    // 处理空值或类型转换
                    feature[0] = getDoubleValue(f3);
                    feature[1] = getDoubleValue(f4);
                    feature[2] = getDoubleValue(f5);
                    feature[3] = getDoubleValue(f6);
                    feature[4] = getDoubleValue(f7);
                    feature[5] = getDoubleValue(f8);
                    feature[6] = getDoubleValue(f9);
                    feature[7] = getDoubleValue(f10);
                    feature[8] = getDoubleValue(f11);
                    feature[9] = getDoubleValue(f12);
                    feature[10] = getDoubleValue(f13);
                    feature[11] = getDoubleValue(f14);
                    feature[12] = getDoubleValue(f15);
                    feature[13] = getDoubleValue(f16);
                    feature[14] = getDoubleValue(f17);
                    feature[15] = getDoubleValue(f21);

                    features.add(feature);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return features;
    }

    // 辅助方法，用于从Cell中获取double值
    private static double getDoubleValue(Cell cell) {
        if (cell == null) {
            return Double.NaN; // 或者你可以选择返回0或其他默认值
        }
        switch (cell.getCellType()) {
            case NUMERIC:
                return cell.getNumericCellValue();
            case STRING:
                try {
                    return Double.parseDouble(cell.getStringCellValue());
                } catch (NumberFormatException e) {
                    return Double.NaN; // 如果无法转换，则返回NaN
                }
            default:
                return Double.NaN; // 对于其他类型，也返回NaN
        }
    }
}