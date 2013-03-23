import java.io.File;
import java.io.FileNotFoundException;


/**
 * Notes about the program:
 * 
 * <p>
 * Drawbacks: The number column value can not exceed 999 without unexpected results. No fix atm.
 * 
 * </p>
 * @author Tyler
 *
 */
public class Main{
	
	public static void testReader(String file){
		System.out.println("[HST Reader] This is a testing feature... It will test the reader on a single file and will not save results.");
		Reader r = new Reader(new File(file)).read().sort();
		System.out.println("[HST Reader] The following is the sorted data:");
		System.out.println(r.toString());
		System.out.println("[HST Reader] These are the last entries in the list of each value:");
		System.out.println(r.getLastString());
	}
	
	
	
	public static void readDirectory(String directory, String output){
		try {
			RecursiveReader rr = new RecursiveReader(directory, output);
			rr.getFiles().scanFiles().save();
		} catch (FileNotFoundException e) {
			System.out.println("Sorry but the directory does not seem to exist.");
		} catch (Exception e) {
			System.out.println("An error has occured. System will exit.");
			System.exit(1);
		}
	}

	/**
	 * Creates the reader and sorter.
	 * @param args
	 */
	
}