package com.model;

import com.model.*;
import java.io.*;
import java.util.*;
import java.lang.IllegalStateException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringTokenizer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ApplyProcess{
    private Scanner input;
	private String fileName;
	
	public ApplyProcess(String fileName) {
		
		this.fileName = fileName;
		System.setProperty("file.encoding", "UTF-8");
		open(); 
		//ReadApplier();
	}
	public ApplyProcess(){
		
	}
	public void open() {
		
		try {
			input = new Scanner(new File(fileName), "utf-8");
		}
		catch (FileNotFoundException fileNotFoundException) {
			System.err.println("Error opening file.");
			System.exit(1);
		}
	}
	/*public ArrayList<Applicant> ReadApplier()
	{
		ArrayList<Applicant> list = new ArrayList<Applicant>();
		StringTokenizer tokens = new StringTokenizer(input.nextLine());
		try
		// read records from file using Scanner object
		{
			while (input.hasNextLine())
			{
				Applicant a = new Applicant();
				String token = tokens.nextToken();
				
				if (tokens.hasMoreTokens())
				{
					a.setName(token);
				}
				if (tokens.hasMoreTokens())
				{
					a.setNumber(token);
				}
				if (tokens.hasMoreTokens())
				{
					a.setGrade(token);
				}
				if (tokens.hasMoreTokens())
				{
					a.setSex(token);
				}
				
				list.add(a);	
			// System.out.println( quiz );
			} // end while
		} // end try
		catch (IllegalStateException stateException)
		{
			System.err.println("Error reading from file.");
			System.exit(1);
		} // end catch
		
		
		return list;
	} // end method readRecords*/
	
	public Applicant jsonStr2Account(String jsonStr) {
		
		Gson gson = new Gson();
		Applicant apply = gson.fromJson(jsonStr, Applicant.class);
		
		return apply;
	}
	
	public void WriteApplier(Applicant applicant)throws IOException{
		FileWriter fw = new FileWriter(new File(fileName), true);
		fw.write(applier2JsonStr(applicant));
		fw.close();
	}
	
	public String applier2JsonStr(Applicant applicant) {
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(applicant);
		
		return jsonStr;
	}
	
	public ArrayList<Event> getYourEvents(EventProcess ep,String id){
		ArrayList<Event> activity = new ArrayList<Event>();
		ArrayList<Event> allEvents = ep.getEventList();
		
		for(Event event:allEvents){
			for(Applicant a: event.getApplicantList()){
				if((id.equals(a.getNumber()))==true){
					activity.add(event);
				}		
			}
		}
		return activity;
	}
}