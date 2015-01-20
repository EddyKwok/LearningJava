package exercises.java;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Exercise6 {
    public static void main(String[] args) {
        DataObject[] dataObjects = new DataObject[5];

        DataObject dataObject = new DataObject();
        dataObject.count = 5;
        dataObject.code  = "friday";
        dataObjects[0] = dataObject;

        dataObject = new DataObject();
        dataObject.count = 7;
        dataObject.code  = "friday";
        dataObjects[1] = dataObject;

        dataObject = new DataObject();
        dataObject.count = 9;
        dataObject.code  = "saturday";
        dataObjects[2] = dataObject;

        dataObject = new DataObject();
        dataObject.count = 11;
        dataObject.code  = "saturday";
        dataObjects[3] = dataObject;

        dataObject = new DataObject();
        dataObject.count = 13;
        dataObject.code  = "saturday";
        dataObjects[4] = dataObject;


        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for(int i=0; i < dataObjects.length; i++){
            //read sum for code
            Integer sumForCode = map.get(dataObjects[i].code);  

            //if no sum is in the map for that code yet start with sum of 0
            if(sumForCode == null){
                sumForCode = new Integer(0);                    
            }
    
            //add count to sum
            sumForCode = sumForCode.intValue() + dataObjects[i].count;
    
            //store new sum in map
            map.put(dataObjects[i].code, sumForCode);                     
        }

        //iterate all keys (codes) in map
        for(String code : map.keySet()){                                  
            //print out the sum for that key (code).
            System.out.println(code + " " + map.get(code));               
        }
    }
}
