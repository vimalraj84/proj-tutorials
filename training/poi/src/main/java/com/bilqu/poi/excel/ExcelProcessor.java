package com.bilqu.poi.excel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelProcessor {

	public static void main (String[] a) throws IOException, InvalidFormatException {

		readExcel(new File("c:/Temp/LIST_TABLE.xlsx")); 

	}

	private static void readExcel(File ipFile) throws IOException, InvalidFormatException {
		Map<String, List<String>> data = new HashMap<>();
		Workbook workbook = new XSSFWorkbook(ipFile);
		Sheet sheet = workbook.getSheetAt(0);
		for (Row row : sheet) {
			
			if(row.getRowNum() <=0) {
				continue;
			}
			String index = null;
			for (Cell cell : row) {
				
				if(cell.getAddress().formatAsString().startsWith("A")) {
					index = cell.getRichStringCellValue().getString() ;
					//System.out.print(index);
				}
				
				if(cell.getAddress().formatAsString().startsWith("E")) {
					data.put(index, formatCell(cell.getRichStringCellValue().getString()));
					//System.out.println(" : "+formatCell(cell.getRichStringCellValue().getString()));
				} 
			}
		}
		if (workbook != null){
			workbook.close();
		}
	}
	
	private static List<String> formatCell(String ip) {

		List<String> list = new ArrayList<>();
		ip = ip.toUpperCase();
		if(ip.contains("schema")) {
			ip = ip.replaceAll("Schema.", "").toUpperCase();
		}

		if(ip.contains("+") || ip.contains("\n")) {
			if(ip.contains("+")) {
				List<String> a= Arrays.stream(ip.trim().split("\\+")).map(i -> i.length() > 5 ?i.substring(0, 5).toUpperCase():i).sorted((p1, p2) -> p1.compareTo(p2)).collect(Collectors.toList());
				list.addAll(a);
			}

			if(ip.contains("\n")) {
				List<String> a= Arrays.stream(ip.trim().split("\n")).map(i -> i.length() > 5 ?i.substring(0, 5).toUpperCase():i).sorted((p1, p2) -> p1.compareTo(p2)).collect(Collectors.toList());
				list.addAll(a);
			}
			
			if(ip.contains(",")) {
				List<String> a= Arrays.stream(ip.trim().split(",")).map(i -> i.length() > 5 ?i.substring(0, 5).toUpperCase():i).sorted((p1, p2) -> p1.compareTo(p2)).collect(Collectors.toList());
				list.addAll(a);
			}
		}else {
			list.add(ip.length() > 5 ?ip.substring(0, 5):ip);
		}
		return list;
	}
}
