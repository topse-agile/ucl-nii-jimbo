package com.fr_soft.demos.rfsample;

import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DB {
  public Map<String, Integer> inputFile(String filename) {
	  Map<String, Integer> map = new HashMap();
	  try{
		  File file = new File(filename);
		  FileReader filereader = new FileReader(file);
		  BufferedReader br = new BufferedReader(filereader);
	  
		  String str = br.readLine();
	  
		  while(str != null){
		  
			  map.put(str.split(",",0)[0], Integer.parseInt(str.split(",",0)[1]));
			  str = br.readLine();
		  }
	  }catch(FileNotFoundException e){
		  System.out.println(e);
	  }catch(IOException e){
		  System.out.println(e);
	  }
//	  System.out.println(map.get("Apple"));
	  return map;
  }
}
