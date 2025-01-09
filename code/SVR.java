//package ML;
//
//import weka.classifiers.functions.SMOreg;
//import weka.classifiers.Evaluation;
//import weka.core.Instances;
//import weka.core.converters.ConverterUtils.DataSource;
//import java.io.FileWriter;
//import com.opencsv.CSVWriter;
//
//import static weka.core.Utils.round;
//
//public class SVR {
//    public static void main(String[] args) {
//        try {
//            // 加载训练集和测试集
//            DataSource trainSource = new DataSource("D:\\Yuce\\src\\main\\java\\Export_train.arff");
//            DataSource testSource = new DataSource("D:\\Yuce\\src\\main\\java\\Export_pre.arff");
//
//            Instances trainData = trainSource.getDataSet();
//            trainData.setClassIndex(trainData.numAttributes() - 1);
//
//            Instances testData = testSource.getDataSet();
//            testData.setClassIndex(testData.numAttributes() - 1);
//
//            // 构建支持向量机回归模型
//            SMOreg svr = new SMOreg();
//            svr.buildClassifier(trainData);
//
//            // 创建评价对象
//            Evaluation eval = new Evaluation(trainData);
//
//            // 对测试集进行预测
//            /*for (int i = 0; i < testData.numInstances(); i++) {
//                double predicted = svr.classifyInstance(testData.instance(i));
//                testData.instance(i).setClassValue(predicted);
//            }*/
//
//            // 评估预测结果
//            eval.evaluateModel(svr, testData);
//            System.out.println(eval.toSummaryString("\nResults\n======\n", false));
//
//            // 将预测结果导出到CSV文件
//            CSVWriter writer = new CSVWriter(new FileWriter("SVR_production_1.csv"));
//            String[] header = {"Actual", "Predicted"};
//            writer.writeNext(header);
//
//            for (int i = 0; i < testData.numInstances(); i++) {
//                double actual = testData.instance(i).classValue();
//                double predicted = eval.predictions().get(i).predicted();
//                double i_predicted = round(predicted * 100.0)/100.0;
//                //int i_actual = round(actual);
//                String[] nextLine = {Double.toString(actual), Double.toString(i_predicted)};
//                //String[] nextLine = {Double.toString(actual), Double.toString(predicted)};
//                writer.writeNext(nextLine);
//            }
//            // 关闭CSVWriter
//            writer.close();
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
