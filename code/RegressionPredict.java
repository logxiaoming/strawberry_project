//package ML;
//
//import smile.data.DataFrame;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class RegressionPredict {
//
//    public static void main(String[] args) {
//
//        String excelFilePath = "C:\\Users\\xiaoming\\Desktop\\农业大数据实训2024-06\\" +
//                "草莓农业大棚实时数据异常监控\\data\\housedata.xlsx"; // Excel文件路径
//
//        List<double[]> features = ExcelDataReader.readExcelFile(excelFilePath);
//
//        // 分离特征和真实值
//        List<double[]> X = new ArrayList<>();
//        double[] y = new double[features.size()];
//        for (int i = 0; i < features.size(); i++) {
//            double[] feature = features.get(i);
//            X.add(new double[feature.length - 1]);
//            System.arraycopy(feature, 0, X.get(i), 0, feature.length - 1);
//            y[i] = feature[feature.length - 1];
//        }
//
//        // 转换为Smile的矩阵格式
////        smile.data.DataFrame data = smile.data.DataFrame.of(X.toArray(new double[X.size()][]), y);
//        // 创建 DataFrame
//        DataFrame data = DataFrame.of("x1","x2", "Y") // 假设有两个特征和一个目标变量
//                .parse(smile.io.Read.doubles(new smile.data.tuple.ArrayTupleIterator(X, y)));
//
//        // 划分训练集和测试集（这里简单使用70%训练，30%测试）
//        int n = data.nrow();
//        int trainSize = (int) (n * 0.7);
//        smile.data.DataFrame train = data.subset(0, trainSize);
//        smile.data.DataFrame test = data.subset(trainSize, n);
//
//        // 接下来进行模型训练和评估
//        // 使用线性回归
//        smile.regression.LinearRegression regression = smile.regression.LinearRegression.fit(train.x, train.y);
//
//        // 预测测试集
//        double[] predictions = regression.predict(test.x);
//
//        // 计算并打印MSE（均方误差）
//        double mse = smile.stat.RegressionMetrics.mse(test.y, predictions);
//        System.out.println("MSE: " + mse);
//        // 也可以计算其他指标，如RMSE、MAE等
//        double rmse = Math.sqrt(mse);
//        System.out.println("RMSE: " + rmse);
//
//
//    }
//}