package Algorithms;

import java.util.Arrays;

import weka.classifiers.functions.LinearRegression;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Regression {
	DataSource data;
	Instances instances;
	LinearRegression reg;

	public void build() {

		try {
			data = new DataSource("regressionarff.arff");

			instances = data.getDataSet();

			instances.setClassIndex(instances.numAttributes() - 1);

			reg = new LinearRegression();

			try {
				reg = (LinearRegression) weka.core.SerializationHelper.read("reg.model");
			} catch (Exception e) {
				reg.buildClassifier(instances);
				weka.core.SerializationHelper.write("reg.model", reg);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		// System.out.println(Arrays.toString(reg.coefficients()));
	}

	// test
	public String test(Instances instances2) {
		DataSource data2;
		String time = "0";
		try {
			// data2 = new DataSource("E:\\test.arff");
			//
			// Instances instances2 = data2.getDataSet();
			//
			// instances2.setClassIndex(instances2.numAttributes() - 1);

			int i;
			int count = 0;
			try {

				for (i = 0; i <= instances2.numInstances() - 1; i++) {
					// for (i = 0; i <= 2; i++) {

					double predelay = reg.classifyInstance(instances2.instance(i));
					double truedelau = (double) instances2.instance(i).value(instances2.numAttributes() - 1);
					time = (int) predelay + "";
					// System.out.println("delayed time:" + truedelau +
					// "predicted delay:" + predelay);
					if (predelay - truedelau >= -15 && predelay - truedelau <= 15)
						count++;
				}
				// System.out.println(((double) count * 100) / (double) i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return time;
	}

}
