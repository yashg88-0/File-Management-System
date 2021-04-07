import java.io.*;
import java.lang.*;
import java.util.*;

import javax.xml.stream.events.Characters;
public class Task {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> al = new ArrayList<Integer>();
		int a = 0;
		String[] list = null;
		System.out.println("Welcome to File Handling Task");
		System.out.println("What operation do you want to perform?");
		System.out.println("Please select your operation");
		System.out.println("1. Create");
		System.out.println("2. Read");
		System.out.println("3. Update");
		System.out.println("4. Delete");
		String n = sc.next();
		sc.nextLine();
		String filePath = "C:\\Yash\\";
		String d = "";
		try {
			File file = new File(filePath);
			list =file.list();
			for(int i=0;i<list.length;i++) {
				String s = list[i];
				s = s.replace("yash_", "");
				s = s.replace(".txt", "");
				al.add(Integer.parseInt(s));
			}
			 a = al.get(al.size()-1);
		}catch(Exception e) {
			e.printStackTrace();
		}
		File file = new File("C:\\Yash\\yash"+"_"+(++a)+".txt");
		switch(n) {
		
		
		
			//create
			case "1":
				try {
						
					 if(file.createNewFile()){
						    String s = sc.nextLine();
						    FileWriter f = new FileWriter(file);
						    f.write(s);
						    f.close();
						    System.out.println("Successfully Created");
						 }else
						   System.out.println("Already exists");
				}
				catch(IOException e) {
					e.printStackTrace();
				}
				break;
				
				
				//read
			case "2":
				System.out.println("Here are the List of files");
				System.out.println("Choose the file to read");
				for(String item:list) {
					System.out.println(item);
				}
				
				System.out.println("Please input the file number which is written after the filename");
				System.out.println("-----------------------------------------------------------------");
				String l = sc.next();
				File file1 = new File(filePath+"\\yash_"+l+".txt");
				System.out.println("yash"+"_"+l+".txt");
				 try {
				      Scanner myReader = new Scanner(file1);
				      while (myReader.hasNextLine()) {
				        String data = myReader.nextLine();
				        System.out.println(data);
				      }
				      myReader.close();
				    } catch (FileNotFoundException e) {
				      System.out.println("An error occurred.");
				      e.printStackTrace();
				    }
				 break;
				 
				 
				 //update
			case "3": 
				System.out.println("Choose the file to update");
				for(String item:list) {
					System.out.println(item);
				}
				int u = sc.nextInt();
				sc.nextLine();
				
				File file3 = new File(filePath+"\\yash_"+u+".txt");
				try {
				
				Scanner myReader = new Scanner(file3);
				String s = "";
			      while (myReader.hasNextLine()) {
				        String data = myReader.nextLine();
				        s = s + data;
				      }   
//				String filecontent = sb.toString();
				System.out.println("Content of the file:"+ s);
				System.out.println("--------------------");
				System.out.println("Enter the content: ");
				String upd = sc.nextLine();
				FileWriter fw = new FileWriter(file3);
				upd = upd+s;
				fw.append(upd);
				fw.flush();
				System.out.println("Successfully Updated");
				}
				catch(Exception e) {
					
				}
				break;
				
				
				
				//delete
			case "4": 
				System.out.println("Choose the file number to delete");
				for(String item:list) {
					System.out.println(item);
				}
				String n1 = sc.next();
				try {
					File file2 = new File(filePath+"\\yash_"+n1+".txt");
					if(file2.exists()) {
						file2.delete();
						System.out.println("File deleted successfully");
					}
					else
						System.out.println("File doesn't exist");
				}
				catch(Exception e) {
					System.out.println("Please provide number only");
				}
	}
}
}
