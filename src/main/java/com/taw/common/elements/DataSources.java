package com.taw.common.elements;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author gjore.zaharchev
 */
public class DataSources {

    public String[][] excel(final String sourceFile, final String selectedSheet) {
        String[][] resultsIntoList = null;
        try {

            File inputFile = new File(sourceFile);
            FileInputStream inputStream = new FileInputStream(inputFile);

            XSSFWorkbook wb = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = wb.getSheet(selectedSheet);

            int rowCount = sheet.getLastRowNum();
            int collCount = sheet.getRow(0).getLastCellNum();

            resultsIntoList = new String[rowCount][collCount];

            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < collCount; j++) {
                        switch (sheet.getRow(i + 1).getCell(j).getCellTypeEnum()) {
                        /*case BLANK:
                            resultsIntoList[i][j] = "";
                            break;*/
                            case STRING:
                                resultsIntoList[i][j] = String.valueOf(
                                        sheet.getRow(i + 1).getCell(j).getRichStringCellValue());
                                break;
                            case NUMERIC:
                                resultsIntoList[i][j] = String
                                        .valueOf(sheet.getRow(i + 1).getCell(j).getNumericCellValue());
                                break;
                       /* case _NONE:
                            resultsIntoList[i][j] = "";
                            break;*/
                            case BOOLEAN:
                                resultsIntoList[i][j] = String
                                        .valueOf(sheet.getRow(i + 1).getCell(j).getBooleanCellValue());
                                break;
                            case ERROR:
                                resultsIntoList[i][j] = String.valueOf(sheet.getRow(i + 1).getCell(j).getErrorCellValue());
                                break;
                            case FORMULA:
                                resultsIntoList[i][j] =
                                        String.valueOf(sheet.getRow(i + 1).getCell(j).getCellFormula());
                                break;
                            default:
                                resultsIntoList[i][j] = "";
                                break;
                        }
                }
            }

            wb.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultsIntoList;
    }

    public String[][] excel(final String sourceFile, final String selectedSheet, int fromRow, final int toRow) {
        String[][] resultsIntoList = null;
        try {

            File inputFile = new File(sourceFile);
            FileInputStream inputStream = new FileInputStream(inputFile);

            XSSFWorkbook wb = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = wb.getSheet(selectedSheet);

            int collCount = sheet.getRow(fromRow).getLastCellNum();
            int rowsTotal = toRow - fromRow + 1;

            resultsIntoList = new String[rowsTotal][collCount];

            for (int i = 0; i < rowsTotal; i++) {
                for (int j = 0; j < collCount; j++) {
                        switch (sheet.getRow(fromRow).getCell(j).getCellTypeEnum()) {
                        /*case BLANK:
                            resultsIntoList[i][j] = "";
                            break;*/
                            case STRING:
                                resultsIntoList[i][j] = String.valueOf(
                                        sheet.getRow(fromRow).getCell(j).getRichStringCellValue());
                                break;
                            case NUMERIC:
                                resultsIntoList[i][j] = String
                                        .valueOf(sheet.getRow(fromRow).getCell(j).getNumericCellValue());
                                break;
                        /*case _NONE:
                            resultsIntoList[i][j] = "";
                            break;*/
                            case BOOLEAN:
                                resultsIntoList[i][j] = String
                                        .valueOf(sheet.getRow(fromRow).getCell(j).getBooleanCellValue());
                                break;
                            case ERROR:
                                resultsIntoList[i][j] = String.valueOf(sheet.getRow(fromRow).getCell(j).getErrorCellValue());
                                break;
                            case FORMULA:
                                resultsIntoList[i][j] =
                                        String.valueOf(sheet.getRow(fromRow).getCell(j).getCellFormula());
                                break;
                            default:
                                resultsIntoList[i][j] = "";
                                break;
                        }
                }
                fromRow++;
            }

            wb.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultsIntoList;
    }

    public Iterator<Object[]> csv(final String fileName, final String delimiter) {
        BufferedReader input = null;
        File file = new File(fileName);
        ArrayList<Object[]> data = null;

        try {
            input = new BufferedReader(new FileReader(file));

            String line = null;
            data = new ArrayList<Object[]>();
            while ((line = input.readLine()) != null) {
                String in = line.trim();
                String[] temp = in.split(delimiter);
                List<Object> arrray = new ArrayList<Object>();
                for (String s : temp) {
                    arrray.add(s);
                }
                data.add(arrray.toArray());
            }

            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.iterator();
    }


}
