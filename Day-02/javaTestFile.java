import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;



public class javaTestFile {

    public static String path = "C:\\Users\\trevo\\Documents\\aocReports.txt";



    public static void main(String[] args) {
// ------------------------------------------------------------------------------------------------------------------------------------
// ---------------------------- READ FILE AND CREATE LISTS FROM FILE CONTENTS --------------------------------------------------------

        int count = 0; // USED TO KEEP TRACK OF NUMBER OF "SAFE" REPORTS
        List<String> reportList = new ArrayList<>(); // LIST TO BE USED TO STORE FILE DATA

        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
                String line;
                while((line = reader.readLine()) != null) {
                    reportList.add(line);  // ADDS EACH LINE FROM FILE TO reportList LIST AS A STRING
                }  
            }
        catch(Exception e) {
            System.out.println(e);
            }

            List<List<Integer>> integerList = new ArrayList<>();
            for(String line : reportList) { // ITERATING THROUGH reportList TO CREATE MANY LISTS WITHIN ONE BIG LIST
                ArrayList<Integer> integers = new ArrayList<>(); // NEW SMALL LIST GENERATED WITH EACH LINE OF reportList << 
                try {
                    for(String number : line.split("\\s+")) { // SPLITS LINE FROM reportList BY SPACES
                        integers.add(Integer.parseInt(number)); // ADDS EACH PARSED INT TO intgers LIST
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                integerList.add(integers); // ADDS EACH SMALLER LIST CREATED FROM THE INNER FOR LOOP TO THE LARGER LIST COLLECTION
            }
       
       
       
       
       
            // -------------------------- NOW PARSE THE LISTS BASED ON AoC DAY 2 REQUIREMENTS ----------------------------------------------
        // -----------------------------------------------------------------------------------------------------------------------------
        
        
        
        
        for(List<Integer> reports : integerList){
            if(isAscending(reports) || isDescending(reports)){
                System.out.println(reports + ": SAFE"); // PRINTS SUB LIST WITH SAFE IF ALL SAFE CONDITIONS MET
                count += 1;
            }
            else {
                System.out.println(reports + ": UNSAFE"); // PRINTS SUB LIST WITH UNSAFE IF NOT ALL SAFE CONDITIONS MET
            }
        }
        System.out.println("# SAFE: " + count); // PRINTS TOTAL NUMBER OF "SAFE" LISTS

    }

    private static boolean isDescending(List<Integer> list) {
        boolean isValid = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (!(list.get(i) > list.get(i + 1) && (list.get(i) - list.get(i + 1) >= 1 && list.get(i) - list.get(i + 1) <= 3))) {
                isValid = false;
                break;
            }
        }
        if (isValid) {
            return true;
        }
        for (int i = 0; i < list.size(); i++) {
            List<Integer> tempList = new ArrayList<>(list);
            tempList.remove(i);
    
            boolean tempIsValid = true;
            for (int j = 0; j < tempList.size() - 1; j++) {
                if (!(tempList.get(j) > tempList.get(j + 1) && (tempList.get(j) - tempList.get(j + 1) >= 1 && tempList.get(j) - tempList.get(j + 1) <= 3))) {
                    tempIsValid = false;
                    break;
                }
            }
            if (tempIsValid) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean isAscending(List<Integer> list) {
        boolean isValid = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (!(list.get(i) < list.get(i + 1) && (list.get(i + 1) - list.get(i) >= 1 && list.get(i + 1) - list.get(i) <= 3))) {
                isValid = false; 
                break;
            }
        }
        if (isValid) {
            return true; 
        }
        for (int i = 0; i < list.size(); i++) {
            List<Integer> tempList = new ArrayList<>(list);
            tempList.remove(i);
    
            boolean tempIsValid = true;
            for (int j = 0; j < tempList.size() - 1; j++) {
                if (!(tempList.get(j) < tempList.get(j + 1) && (tempList.get(j + 1) - tempList.get(j) >= 1 && tempList.get(j + 1) - tempList.get(j) <= 3))) {
                    tempIsValid = false;
                    break;
                }
            }
            if (tempIsValid) {
                return true; 
            }
        }
        return false;
    }
    

}
