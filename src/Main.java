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
final class Main{
	
	public static void testReader(String file){
		System.out.println("[HST Reader] This is a testing feature... It will test the reader on a single file and will not save results.");
		Reader r = new Reader(new File(file)).read().sort();
		System.out.println("[HST Reader] The following is the sorted data:");
		System.out.println(r.toString());
		System.out.println("[HST Reader] These are the last entries in the list of each value:");
		System.out.println(r.getLastString());
	}
	
	public static void openInterface(){
		System.out.println("Use the GUI to choose your file locations.");
		GUI g = new GUI();
		g.launch(new String[0]);
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
	public static void main(String[] args){
		
		if (args.length == 1){
			testReader(args[0]);
		} else if (args.length == 0){
			openInterface();
		} else if (args.length>2){
			System.out.println("[HST Reader] Too many args... Ignoring the extra ones.");
			System.out.println("[HST Reader] Usage: hstparser [dir] [output.file]");
			System.out.println("[HST Reader] Dir is the directory you wish to look in and output.file is the filename to print to.");
		} else {
			readDirectory(args[0], args[1]);
		}
		
	}
}