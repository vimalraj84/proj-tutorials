package com.bilqu.java8.filestream;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileStream {

	public static void main(String[] args) {
		Stream<String> lines = null;
		try {
			lines = Files.lines(Paths.get(ClassLoader.getSystemResource("employee.txt").toURI()));
			Map<String,String> empList = lines.map(ip -> ip.split(","))
					.filter(ip -> ip.length >= 3)
					.collect(Collectors.toMap(ip -> ip[0], ip -> ip[1]+ip[2]));
			System.out.println(empList);
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}finally {
			if(lines != null) lines.close();
		}

	}

}
