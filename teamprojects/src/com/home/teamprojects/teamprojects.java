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
		String[] lines = new String[100];//ArrayList<String>();//TODO magic number. code to be refactored
		String lineNew;
		int i =0; 
		while (input.hasNextLine()) {
			lineNew = input.nextLine();
			if (lineNew.isEmpty()) {
				break;
			}
			lines[i]= (lineNew);
			i++;
		}
		input.close();
		dataAnalyser dataAnalyserObject = new dataAnalyser();
		dataAnalyserObject.init(lines);
		dataAnalyserObject.printContractsCustomerCounts();
		dataAnalyserObject.printGeozonesCustomerCountsNamesAndBuildTimes();
		

	}

}
