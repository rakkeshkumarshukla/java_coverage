package com.home.teamprojects;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class teamprojects {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		List<String> lines = new ArrayList<String>();
		String lineNew;
		int i =0; 
		while (input.hasNextLine()) {
			lineNew = input.nextLine();
			if (lineNew.isEmpty()) {
				break;
			}
			lines.add(lineNew);
			i++;
		}
		input.close();
		String[] lines_array = new String[lines.size()];
		lines_array = lines.toArray(lines_array);
		dataAnalyser dataAnalyserObject = new dataAnalyser();
		if(dataAnalyserObject.init(lines_array))
		{
			dataAnalyserObject.emitOutput();;
			
		}
		else
		{
			System.out.println("input format is incorrect.");
		}
		

	}

}
