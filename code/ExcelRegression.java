package ML;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelRegression {

    public static void main(String[] args) {
        String excelFilePath = "path_to_your_excel_file.xlsx";}}
//
//        try (FileInputStream fis = new FileInputStream(excelFilePath);
//             Workbook workbook = new XSSFWorkbook(fis)) {
//
//            Sheet sheet = workbook.getSheetAt(0); // 假设数据在第一个工作表上
//            int lastRowNum = sheet.getLastRowNum();
//            List<double[]> data = new ArrayList<>();
//
//            for (int rowNum = 1; rowNum <= lastRowNum; rowNum++) { // 跳过标题行
//                Row row = sheet.getRow(rowNum);
//                if (row != null) {
//                    // 假设最后一列是我们要预测的目标变量（历史产量）
//                    int targetIndex = row.getLastCellNum() - 1;
//                    double[] featureVector = new double[targetIndex - 1]; // 假设第一列是ID，不计入特征
//
//                    for (int cellNum = 1; cellNum < targetIndex; cellNum++) { // 跳过ID列
//                        Cell cell = row.getCell(cellNum);
//                        double value = cell.getNumericCellValue(); // 假设所有值都是数值型
//                        featureVector[cellNum - 1] = value;
//                    }
//
//                    double target = row.getCell(targetIndex).getNumericCellValue();
//                    double[] record = new double[featureVector.length + 1];
//                    System.arraycopy(featureVector, 0, record, 0, featureVector.length);
//                    record[featureVector.length] = target;
//                    data.add(record);
//                }
//            }
//
//            // 分离特征和标签
//            double[][] X = new double[data.size()][];
//            double[] y = new double[data.size()];
//            for (int i = 0; i < data.size(); i++) {
//                X[i] = new double[data.get(i).length - 1];
//                System.arraycopy(data.get(i), 0, X[i], 0, X[i].length);
//                y[i] = data.get(i)[data.get(i).length - 1];
//            }
//
//            // 使用Smile进行线性回归
//            LinearRegression regression = LinearRegression.fit(X, y);
//
//            // ... 这里可以添加代码来评估模型或进行预测 ...
//
//            System.out.println("Regression model trained.");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}