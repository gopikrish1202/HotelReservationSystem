package com.util;
import java.util.*;
import java.util.Collection;


public class ApplicationUtil {

	public List<String> extractDetails(String[] input) {
		// TODO Auto-generated method stub
		List<String> riRecords=new ArrayList<String>();
		for(int i=0;i<input.length;i++) {
			riRecords.add(input[i]);
		}
		return riRecords;
	}
	
}
