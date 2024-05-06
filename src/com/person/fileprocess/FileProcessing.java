package com.person.fileprocess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.person.bean.PersonBean;

public class FileProcessing {

	public void getRecords() throws IOException {
		List<String> incomingRecords;
		List<PersonBean> personDetails = new ArrayList<PersonBean>();
		
		// Get Source Records From file
		FileReader sourceFile = new FileReader(new File("D:\\preethi\\person.csv"));
		BufferedReader br = new BufferedReader(sourceFile);
		String line;
		line = br.readLine();
		
		// Read each record and assign it to bean
		while ((line = br.readLine()) != null) {
			incomingRecords = new ArrayList(Arrays.asList(line.split(",")));
			PersonBean personInstance = new PersonBean();
			personInstance.setPersonName(incomingRecords.get(0));
			personInstance.setAge(Integer.parseInt(incomingRecords.get(1)));
			personInstance.setDistrict(incomingRecords.get(2));
			personInstance.setState(incomingRecords.get(3));
			personInstance.setCountry(incomingRecords.get(4));
			personDetails.add(personInstance);

		}
		
		
		//Map<String(country), Map<String(state),Map<String(district), List<Person>>>>
		
		
		//Categorize each bean based District
		//Map<String(District), List<Person>>
		Map<Object, List<PersonBean>> districtWiseDetails =  personDetails
				.stream()
				.collect(Collectors.groupingBy(PersonBean::getDistrict));
		
		
		
		Map<Object,Map<Object, Map<Object, List<PersonBean>>>> countryWiseDetails = personDetails
				.stream()
				.collect(Collectors.groupingBy(
						PersonBean::getCountry,
							Collectors.groupingBy(
									PersonBean::getState,
										Collectors.groupingBy(
												PersonBean::getDistrict))));
				
		
		countryWiseDetails.forEach((key, value) -> System.out.println(key + ":" + value));

	}
	
	public static void main(String as[]) throws IOException {
		FileProcessing f = new FileProcessing();
		f.getRecords();
	}
}
