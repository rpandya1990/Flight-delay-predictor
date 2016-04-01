package Algorithms;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class J48Classifier {

	J48 j48tree = new J48();
	DataSource data;
	Instances instances;
	String classes[] = { "notdelayed", "delayed" };

	public void build() {

		try {
			// data = new DataSource("j48train.arff");
			data = new DataSource("treetrain.csv");

			instances = data.getDataSet();
			instances.setClassIndex(instances.numAttributes() - 1);

			try {
				j48tree = (J48) weka.core.SerializationHelper.read("j48.model");
			} catch (Exception e) {
				j48tree.buildClassifier(instances);
				weka.core.SerializationHelper.write("j48.model", j48tree);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("tree size:" + j48tree.measureTreeSize());
		System.out.println("leaf size:" + j48tree.measureNumLeaves());
		// System.out.println(j48tree.graph());

	}

	public String test(Instances instances2) {
		String status = "delayed";
		try {
			int count = 0;
			int i;
			try {

				for (i = 0; i <= instances2.numInstances() - 1; i++) {
					// for (i = 0; i <= 2; i++) {
					int trueval = (int) instances.instance(i).classValue();

					int predval = (int) j48tree.classifyInstance(instances2.instance(i));
					status = classes[predval];
					// System.out.println("class:" + classes[trueval] +
					// "classified as:" + classes[predval]);

					if (trueval == predval) {
						// System.out.println(predval);
						count++;
					}

				}
				// System.out.println("% correct: " + (((float) count * 100.00)
				// / (float) i));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return status;
	}

}
