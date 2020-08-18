package com.xinyu.test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelTest {
    public static void main(String[] args) {
        File file = new File("ab.xls");
        try {
            Workbook workbook = Workbook.getWorkbook(file);
            // 获得所有工作表
            Sheet[] sheets = workbook.getSheets();
            Map<String,List<Integer>> hasMap = new HashMap<>();
            // 遍历工作表
            if (sheets != null)
            {
                for (Sheet sheet : sheets)
                {
                    // 获得行数
                    int rows = sheet.getRows();
                    // 获得列数
                    int cols = sheet.getColumns();
                    // 读取数据
                    for (int row = 0; row < rows; row++)
                    {
                        for (int col = 0; col < cols; col++)
                        {
                            String contents = sheet.getCell(col, row)
                                    .getContents();
                            if (col == 1) {
                                List<Integer> strings = hasMap.getOrDefault(contents,null);
                                if (strings == null) {
                                    ArrayList<Integer> value = new ArrayList<>();
                                    value.add(row);
                                    hasMap.put(contents, value);
                                }else {
                                    strings.add(row);
                                }
                            }
                        }
                    }
                    break;
                }
            }
            workbook.close();
            for (Map.Entry<String, List<Integer>> stringListEntry : hasMap.entrySet()) {
                if (stringListEntry.getValue().size() > 1) {
                    System.out.println(stringListEntry.getKey() +"_"+ stringListEntry.getValue());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

    }

    public void testRead(){
        File file = new File("ab.xls");
        try {
            Workbook workbook = Workbook.getWorkbook(file);
            // 获得所有工作表
            Sheet[] sheets = workbook.getSheets();
            // 遍历工作表
            if (sheets != null)
            {
                for (Sheet sheet : sheets)
                {
                    // 获得行数
                    int rows = sheet.getRows();
                    // 获得列数
                    int cols = sheet.getColumns();
                    // 读取数据
                    for (int row = 0; row < rows; row++)
                    {
                        for (int col = 0; col < cols; col++)
                        {
                            System.out.printf("%10s", sheet.getCell(col, row)
                                    .getContents());
                        }
                        System.out.println();
                    }
                }
            }
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    public void test(){
        File xlsFile = new File("jxl.xls");
        // 创建一个工作簿
        WritableWorkbook workbook = null;
        try {
            workbook = Workbook.createWorkbook(xlsFile);
            // 创建一个工作表
            WritableSheet sheet = workbook.createSheet("sheet1", 0);
            for (int row = 0; row < 10; row++)
            {
                for (int col = 0; col < 10; col++)
                {
                    // 向工作表中添加数据
                    sheet.addCell(new Label(col, row, "data" + row + col));
                }
            }
            workbook.write();
            workbook.close();
        } catch (IOException | WriteException e) {
            e.printStackTrace();
        }

    }


}
