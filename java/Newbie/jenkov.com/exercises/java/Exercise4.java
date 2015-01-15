package exercises.java;

public class Exercise4 {
	public static void main(String[] args) {
		DataObject[] dataObjects = new DataObject[3];

		DataObject dataObject = new DataObject();
		dataObject.count = 10;
		dataObjects[0] = dataObject;

		dataObject = new DataObject();
		dataObject.count = 20;
		dataObjects[1] = dataObject;

		dataObject = new DataObject();
                dataObject.count = 30;
		dataObjects[2] = dataObject;

		int sum = 0;

		for (int i=0;i<dataObjects.length;i++) {
			System.out.println("sum : " + sum);
			sum += dataObjects[i].count;
			System.out.println("sum += " + dataObjects[i].count + " --> " + sum);
			System.out.println("");
		}

		//System.out.println("");
		//System.out.println("Sum : " + sum);
	}
}
