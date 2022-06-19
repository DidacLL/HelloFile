import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CsvReader {

    public static void main(String[] args) throws IOException {
       // printToTXT(readFromCSV("oscar_age_female"),"result");
        testLineOrder();
    }



    private static void printToTXT(String text, String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName+".txt", false);
        writer.write(text.replace("\"",""));
        writer.close();

    }

    private static String readFromCSV(String fileName) throws FileNotFoundException {
        File file = new File(fileName+".csv");
        Scanner scanner = new Scanner(file);
        StringBuilder builder = new StringBuilder();
        String[] colName= scanner.nextLine().split(",");
        colName= orderLine(colName,3,1);



//3124
        while(scanner.hasNextLine()){
            String[] line = orderLine(scanner.nextLine().split(", "),3,1);
            for(int i=1;i<5;i++) {
                builder.append(colName[i]).append(":").append(line[i]).append("\n");
            }
        }
        return builder.append("====================").toString();
    }

    private static String[] orderLine(String[] srcList, int elemMoving, int moveTo) {
        if (Math.max(elemMoving,moveTo)< srcList.length) {
            String[] auxList = srcList.clone();
            String moveStr = srcList[elemMoving];
            boolean reached = false;
            boolean mustPush = elemMoving > moveTo;
            for (int i = 0; i < srcList.length; i++) {
                if (i == moveTo) auxList[i] = moveStr;
                else if (i < Math.min(moveTo, elemMoving)) {
                    auxList[i] = srcList[i];
                } else if (mustPush) {
                    if (!reached) {
                        auxList[i] = srcList[i - 1];
                        if (i == elemMoving) reached = true;
                    } else auxList[i] = srcList[i];
                } else if (i >= elemMoving) {
                    if (i < moveTo) auxList[i] = srcList[i + 1];
                    else auxList[i] = srcList[i];
                }
            }
            return auxList;
        }
        System.out.println("ERR");
        return srcList;
    }

    //-----------------------------------------------------------------TESTS
    private static void testLineOrder() {
        String[] list = new String[]{"0","1","2","3","4","5"};
        for (String str: list) System.out.print(str);
        System.out.println("\n=============");
        for (String str: orderLine(list,1,3)) System.out.print(str);
        System.out.println("\n=============");
        for (String str:orderLine(list,3,1)) System.out.print(str);
        System.out.println("\n=============");
        for (String str:orderLine(list,0,5)) System.out.print(str);
        System.out.println("\n=============");
        for (String str:orderLine(list,2,4)) System.out.print(str);
        System.out.println("\n=============");
        for (String str:orderLine(list,5,2)) System.out.print(str);
    }
/* OPTIONAL text  block
var txtBlck = """

""" .formatted()
 */
}
