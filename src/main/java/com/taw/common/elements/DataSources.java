package com.taw.common.elements;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

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
                    try {
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
                    } catch (Exception e) {
                        //e.printStackTrace();
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
                    try {
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

                    } catch (Exception e) {
                        //e.printStackTrace();
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

   /* public String[][] csv(final String file) {

        return null;
    }

    public String[][] json(final String file) {

        return null;
    }*/


}
