import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadEXEL {

    public static String readExelFile(String pathFile,int numbSheet, int rowInd,int cellInd){
        String dataFromCell = null;
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(pathFile));
            XSSFSheet sheet = workbook.getSheetAt(numbSheet);
            XSSFRow row = sheet.getRow(rowInd);
            dataFromCell = row.getCell(cellInd).getStringCellValue();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataFromCell;
    }

    public static void main(String[] args) {
        Util util = new Util();
        System.out.println(readExelFile(util.pathEXELFile,0,0,1));
    }

}
