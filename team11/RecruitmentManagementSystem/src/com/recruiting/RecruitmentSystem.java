package com.recruiting;
import java.util.*;
import java.io.*;
public class RecruitmentSystem {
	static Scanner me=new Scanner(System.in);
	static List<Candidate> candidates=new ArrayList<>();
	static final String File_Name="candidates.txt";
	public static void main(String[] args) {
		loadFromFile();
		
		while (true) {
            System.out.println("\n===== Recruitment Management System =====");
            System.out.println("1. Register Candidate");
            System.out.println("2. View All Candidates");
            System.out.println("3. Schedule Technical Interview");
            System.out.println("4. Schedule HR Interview");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = me.nextInt();
            me.nextLine();
            switch(choice) {
            case 1:
            	registerCandidate();
            	break;
            case 2:
            	viewCandidate();
            	break;
            case 3:
            	scheduleTechnical();
            	break;
            case 4:
            	scheduleHR();
            	break;
            case 5:
            	exitProgram();
            	break;
            	default:
            		System.out.println("Invalid Input");
            }
		}
	}
	public static void registerCandidate() {
		System.out.print("Enter Candidate Name: ");
        String name = me.nextLine();
        System.out.print("Enter Candidate Email: ");
        String email = me.nextLine();
        
        Candidate c=new Candidate(name,email);
        candidates.add(c);
        System.out.println("Candidate Registered Successfully!");
        saveToFile();
	}
	public static void viewCandidate() {
		if(candidates.isEmpty()) {
			System.out.println("No data available");
			return;
		}
		System.out.println("Candidates List");
		for(int i=0;i<candidates.size();i++) {
			System.out.println((i+1)+"."+candidates.get(i));
		}
	}
	public static void scheduleTechnical() {
		viewCandidate();
		if(candidates.isEmpty())
			return;
		System.out.println("Candidaate no:");
		int index=me.nextInt()-1;
		me.nextLine();
		System.out.println("Interview date");
		String date=me.nextLine();
		TechnicalInterview t=new TechnicalInterview(candidates.get(index),date);
		t.evaluate();
		System.out.println("Technical interview done");
		saveToFile();
	}
	public static void scheduleHR() {
		viewCandidate();
		if(candidates.isEmpty())
			return;
		System.out.println("Candidate no");
		int index=me.nextInt()-1;
		me.nextLine();
		System.out.println("Hr Interview Date:");
		String date=me.nextLine();
		HrInterview h=new HrInterview(candidates.get(index),date);
		h.evaluate();
		System.out.println("HR completed");
		saveToFile();
	}
	public static void exitProgram() {
		saveToFile();
		System.out.println("Exit the program");
		System.exit(0);
	}
	private static void saveToFile() {
        try (FileWriter fw = new FileWriter(File_Name)) {
            for (Candidate c : candidates) {
                fw.write(c.getName() + "," + c.getEmail() + "," + c.getStatus() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving file!");
        }
    }
	private static void loadFromFile() {
        File file = new File(File_Name);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                Candidate c = new Candidate(arr[0], arr[1]);
                c.Update(arr[2]);
                candidates.add(c);
            }
        } catch (IOException e) {
            System.out.println("Error loading file!");
        }
    }
}
