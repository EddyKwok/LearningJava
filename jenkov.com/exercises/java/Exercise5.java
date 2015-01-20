package exercises.java;

public class Exercise5 {
	public static void main(String[] args) {
		DataObject[] dataObjects = new DataObject[5];

		DataObject dataObject = new DataObject();
		dataObject.count = 10;
                dataObject.code = "friday";
		dataObjects[0] = dataObject;

		dataObject = new DataObject();
		dataObject.count = 20;
		dataObject.code = "saturday";
		dataObjects[1] = dataObject;

		dataObject = new DataObject();
                dataObject.count = 30;
		dataObject.code = "saturday";
                dataObjects[2] = dataObject;

		dataObject = new DataObject();
		dataObject.count = 40;
		dataObject.code = "saturday";
		dataObjects[3] = dataObject;

		dataObject = new DataObject();
		dataObject.count = 50;
		dataObject.code = "friday";
		dataObjects[4] = dataObject;

		int sum = 0;

		for (int i=0;i<dataObjects.length;i++) {
			System.out.println("sum : " + sum);

			//Below 3 if statements are all similar.
			//if (dataObjects[i].code=="friday") {
			//if ("friday".equals(dataObjects[i].code)) {
			if (dataObjects[i].code.equals("friday")) {
				sum += dataObjects[i].count;
			        System.out.println("sum += " + dataObjects[i].count + " --> " + sum);
			}
			System.out.println("");
		}

		//System.out.println("");
		//System.out.println("Sum : " + sum);
	}
}
