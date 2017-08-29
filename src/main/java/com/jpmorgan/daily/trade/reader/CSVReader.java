package com.jpmorgan.daily.trade.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;




public class CSVReader {

	private static final String SEPERATOR = ","; 
	//File csvFile = new File("");
	
	private final String path;
	
	public CSVReader(String path){
		this.path = path;
	}
	
		
	
	public List<String> readFile() {
		//List<List<String>> ret = null;
		try(Stream<String> stream = Files.lines(Paths.get(path))){
			return stream
					//.map( line -> Arrays.asList(line.split(SEPERATOR)))
					.collect(Collectors.toList());
					
		}catch (IOException e) {
			throw new UncheckedIOException(e);
		}
		
		
		//Stream<String> lines = reader.lines().map(mapper);
		
		
		
	}
}
