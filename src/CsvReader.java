import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CsvReader {

    public static void main(String[] args) throws IOException {
        ;
        printToTXT(readFromCSV("oscar_age_female"),"result");

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
            for(int i=0;i<4;i++) {
                builder.append(colName[i+1]).append(":").append(line[i]).append("\n");
            }
        }
        return builder.append("====================").toString();
    }

    private static String[] orderLine(String[] srcList, int elemMoving, int moveTo) {
        String[] auxList= srcList.clone();
        String auxStr = srcList[elemMoving];
        boolean reached = false;
        for (int i=1;i<srcList.length;i++){
            if(i==moveTo) auxList[i]=auxStr;
            else {
                if(!reached) {
                    auxList[i]=srcList[i-1];
                    if(i==elemMoving) reached=true;
                }else{
                    auxList[i]=srcList[i];
                }
            }
        }
        return auxList;
    }

}
