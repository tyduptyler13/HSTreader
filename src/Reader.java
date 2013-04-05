import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



public class Reader{

	private ArrayList<Data> data = new ArrayList<Data>();
	private File file;
	private int part;
	private String map;

	public Reader(File file) throws NumberFormatException{
		this.file = file;

		String name = file.getName();
		part = Integer.parseInt(name.split(",")[0].substring(12));

		String map = file.getParent();
		String[] tmp = map.split("[\\\\|/|:|\\.]");
		this.map = tmp[tmp.length-1];
	}

	public Reader reset(File file) throws NumberFormatException{
		data.clear();

		this.file = file;

		String name = file.getName();
		part = Integer.parseInt(name.split(",")[0].substring(12));

		String map = file.getParent();
		String[] tmp = map.split("[\\\\|/|:|\\.]");
		this.map = tmp[tmp.length-1];


		return this;
	}

	public Reader read(){
		System.out.println("[HST Reader] Reading file: ("+file.getName()+")");
		FileReader fr;
		BufferedReader br;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			Scanner s = new Scanner(br);

			while(s.hasNextLine()){
				String line = s.nextLine();
				if (line.contains("Fire Truck")){
					try {
						data.add(new Data(map, part, line));
					} catch (Exception e) {
						System.out.println("An error occured reading a line from the file! Please check that it is formatted correctly.");
					}
				}
			}

			s.close();
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("The file specified was not found.");
		} catch (IOException e) {
			System.out.println("Sorry but the files seem to be giving the program some trouble. The files cannot be read.");
		}

		return this;
	}

	public Reader sort(){
		System.out.println("[HST Reader] Sorting data.");
		Collections.sort(data);
		return this;
	}

	/**
	 * Collects the sorted data and returns the last bit of info from each section.
	 * 
	 * <p>WARNING!! - <br>
	 * Only run this on a sorted Reader. If it is not sorted this data will not be correct.
	 * </p>
	 * @return List of the last of the list sorted by appliance then number.
	 */
	public ArrayList<Data> getLast(){
		ArrayList<Data> result = new ArrayList<Data>();
		for (int x = 1; x<=10; ++x){
			Data max = null;
			for (Data d : data){
				if (d.getAppliance()==x){
					max = d;
				} else if (d.getAppliance()>x){//No longer will find data if it is sorted.
					break;
				}
			}
			if (max != null) //Skip any null entries.
				result.add(max);
		}
		return result;

	}

	/**
	 * Same as other get last except it returns the results in a single string.
	 * @return
	 */
	public String getLastString(){
		String result = "";
		for (Data d : getLast()){
			result += d.toString() + "\n";
		}
		return result;
	}

	public String toString(){
		String result = "";
		for (Data d : data){
			result += d.toString() + "\n";
		}
		return result;
	}

}
