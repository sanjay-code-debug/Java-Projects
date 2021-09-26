package csvfileread;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import au.com.bytecode.opencsv.CSVReader;

/**
 * Date-06/07/2019
 * 
 * @author SANJAY
 *
 */
public class ReadFile {
	CSVReader reader = null;

	public void readFile(ArrayList<SystemLog> arr) throws IOException {
		reader = new CSVReader(new FileReader("F:\\sanjay.csv"));
		String[] nextLine;
		SystemLog ob = null;
		while ((nextLine = reader.readNext()) != null) {
			if (nextLine != null) {
				ob = new SystemLog();
				ob.setLevel(nextLine[0]);
				ob.setDateAndTime(nextLine[1]);
				ob.setSource(nextLine[2]);
				ob.setId(nextLine[3]);
				ob.setTaskCategory(nextLine[4]);
			}
			arr.add(ob);
		}
	}

	public void displayIdDetails(ArrayList<SystemLog> arr, String id) {

		for (SystemLog temp : arr) {
			if (temp.getId().equalsIgnoreCase(id)) {
				System.out.println(temp.getLevel());
				System.out.println(temp.getDateAndTime());
				System.out.println(temp.getSource());
				System.out.println(temp.getTaskCategory());
			}
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter The Id");
		String id = input.nextLine();
		ArrayList<SystemLog> arr = new ArrayList<>();
		ReadFile out = new ReadFile();
		try {
			out.readFile(arr);
			out.displayIdDetails(arr, id);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			input.close();
		}
	}
}
