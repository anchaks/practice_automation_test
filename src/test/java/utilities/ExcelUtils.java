

package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils 
{
    /*
    public static void writeAccountDataToRegistraExcel(String fileNamePrefix, List<String> accountNumbers, List<String> accountBalances, List<String> availableBalances) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        
        String directoryPath="//Users/arnab/Desktop/Programming_Projects/VSCodeProjects/parabanking_project/src/test_output/generatedexcelsheets/";
        new File(directoryPath).mkdirs(); // Create folders if they don't exist
        
        String fileName =directoryPath+fileNamePrefix + "_" + timestamp + ".xlsx";

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Account Details");

        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Account Number");
        headerRow.createCell(1).setCellValue("Account Balance");
        headerRow.createCell(2).setCellValue("Available Balance");

        // Populate data rows
        for (int i = 0; i < accountNumbers.size(); i++) {
            Row row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(accountNumbers.get(i));
            row.createCell(1).setCellValue(accountBalances.get(i));
            row.createCell(2).setCellValue(availableBalances.get(i));
        }

        // Write to file
        try (FileOutputStream outputStream = new FileOutputStream(new File(fileName))) {
            workbook.write(outputStream);
            System.out.println("Data written to Excel file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeAccountDataToExcel(String fileNamePrefix, List<String> accountNumbers, List<String> accountBalances, List<String> availableBalances) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        
        String directoryPath="//Users/arnab/Desktop/Programming_Projects/VSCodeProjects/parabanking_project/src/test_output/generatedexcelsheets/";
        new File(directoryPath).mkdirs(); // Create folders if they don't exist
        
        String fileName =directoryPath+fileNamePrefix + "_" + timestamp + ".xlsx";

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Account Details");

        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Account Number");
        headerRow.createCell(1).setCellValue("Account Balance");
        headerRow.createCell(2).setCellValue("Available Balance");

        // Populate data rows
        for (int i = 0; i < accountNumbers.size(); i++) {
            Row row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(accountNumbers.get(i));
            row.createCell(1).setCellValue(accountBalances.get(i));
            row.createCell(2).setCellValue(availableBalances.get(i));
        }

        // Write to file
        try (FileOutputStream outputStream = new FileOutputStream(new File(fileName))) {
            workbook.write(outputStream);
            System.out.println("Data written to Excel file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
        */

        /*
    public static String readFirstAccountNumber(String filePath) {
    try (FileInputStream fis = new FileInputStream(new File(filePath));
         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
        XSSFSheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(1); // Assuming first data row is at index 1
        return row.getCell(0).getStringCellValue();
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
        */
    
    private static final String BASE_DIR="//Users/arnab/Desktop/Programming_Projects/VSCodeProjects/parabanking_project/src/test_output/generatedexcelsheets/";

    public static void writeAccountDataToExcel(String fileNamePrefix, List<String> accountNumbers, List<String> accountBalances, List<String> availableBalances) {
        //String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = BASE_DIR + fileNamePrefix + "_" + ".xlsx";

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Account Details");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Account Number");
        headerRow.createCell(1).setCellValue("Account Balance");
        headerRow.createCell(2).setCellValue("Available Balance");

        for (int i = 0; i < accountNumbers.size(); i++) {
            Row row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(accountNumbers.get(i));
            row.createCell(1).setCellValue(accountBalances.get(i));
            row.createCell(2).setCellValue(availableBalances.get(i));
        }

        try (FileOutputStream outputStream = new FileOutputStream(new File(fileName))) {
            workbook.write(outputStream);
            System.out.println("Data written to Excel file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> readAccountNumbersFromExcel(String filePath) {
        List<String> accountNumbers = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = sheet.iterator();

            if (iterator.hasNext()) {
                iterator.next(); // Skip header
            }

            while (iterator.hasNext()) {
                Row row = iterator.next();
                Cell cell = row.getCell(0); // Account Number is in the first column
                if (cell != null) {
                    accountNumbers.add(cell.toString().trim());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return accountNumbers;
    }













}



