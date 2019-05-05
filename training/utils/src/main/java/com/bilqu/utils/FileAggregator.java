package com.bilqu.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileAggregator {

	public static void main(String[] args) throws  IOException, InvalidFormatException {


		File file = new File("C:\\Temp\\aquery_input");

		if(!file.exists()) return; 

		Map<String, List<String>> data = new HashMap<>();
		Workbook workbook = new XSSFWorkbook(new File("c:/Temp/QUERY_LIST_PROCESS.xlsx"));
		Sheet sheet = workbook.getSheetAt(0);
		
		
		Predicate<String> select = line -> (line.startsWith("SELECT"));
		Predicate<String> update = line -> (line.startsWith("UPDATE"));
		Predicate<String> insert = line -> (line.startsWith("INSERT"));
		Predicate<String> delete = line -> (line.startsWith("DELETE"));
		
		for (Row row : sheet) {

			if(row.getRowNum() <=0) {
				continue;
			}
			for (Cell cell : row) {
				if(cell.getAddress().formatAsString().startsWith("K")) {
					if(file.isDirectory()) {
						//Arrays.stream(file.list()).anyMatch(f -> f.equalsIgnoreCase(index));
						Arrays.stream(file.list()).forEach(f -> {
							if(f.contains(cell.getRichStringCellValue().getString()))
							{
								List<String> selectList = new ArrayList<>();
								List<String> updateList = new ArrayList<>();
								List<String> insertList = new ArrayList<>();
								List<String> deleteList = new ArrayList<>();

								List<Predicate<String>> predicates = Arrays.asList(select,update,insert,delete);

								try(Stream<String> linesStream = Files.lines(Paths.get("c:/Temp/query_input/"+f))){
									
									//TODO :TRY this to avoid using multiple stream
									 List<List<String>> result = predicates.stream().map(pred -> linesStream.filter(pred).collect(Collectors.toList())).collect(Collectors.toList());
									
//									 predicates.stream().map(pred -> linesStream.filter(pred).collect(Collectors.toList())).forEach(System.out::println);;
									
									 System.out.println(result);
									 result.forEach(System.out::println); 
									 
																	
									

//									selectList = linesStream.filter(select).collect(Collectors.toList());
								}catch (java.nio.file.NoSuchFileException e) {
									//e.printStackTrace();
								}catch (Exception e) {
									e.printStackTrace();
								}

//								try(Stream<String> linesStream = Files.lines(Paths.get("c:/Temp/query_input/"+f))){
//
//									updateList = linesStream.filter(update).collect(Collectors.toList());
//								}catch (java.nio.file.NoSuchFileException e) {
//									//e.printStackTrace();
//								}catch (Exception e) {
//									e.printStackTrace();
//								}
//								
//								try(Stream<String> linesStream = Files.lines(Paths.get("c:/Temp/query_input/"+f))){
//
//									insertList = linesStream.filter(insert).collect(Collectors.toList());
//								}catch (java.nio.file.NoSuchFileException e) {
//									//e.printStackTrace();
//								}catch (Exception e) {
//									e.printStackTrace();
//								}
//								
//								try(Stream<String> linesStream = Files.lines(Paths.get("c:/Temp/query_input/"+f))){
//
//									deleteList = linesStream.filter(delete).collect(Collectors.toList());
//								}catch (java.nio.file.NoSuchFileException e) {
//									//e.printStackTrace();
//								}catch (Exception e) {
//									e.printStackTrace();
//								}
								System.out.format("%s : SELECT=%d, UPDATE=%d, INSERT=%d, DELETE=%d \n", f, selectList.size(),updateList.size(),insertList.size(),deleteList.size());
							}
						});
					}
				}
			}
		}
	}
}
