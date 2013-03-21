import java.io.File;
import java.io.FileNotFoundException;

import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;


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
final class Interface{
	
	public void testReader(String file){
		System.out.println("[HST Reader] This is a testing feature... It will test the reader on a single file and will not save results.");
		Reader r = new Reader(new File(file)).read().sort();
		System.out.println("[HST Reader] The following is the sorted data:");
		System.out.println(r.toString());
		System.out.println("[HST Reader] These are the last entries in the list of each value:");
		System.out.println(r.getLastString());
	}
	
	public void openInterface(){
		
		System.out.println("Use the GUI to choose your file locations.");
		DirectoryChooser dc = new DirectoryChooser();
		dc.setInitialDirectory(new File(System.getProperty("user.home")));
		dc.setTitle("Choose search directory");
		File top = dc.showDialog(arg0)
	}
	
	public void readDirectory(String directory, String output){
		try {
			RecursiveReader rr = new RecursiveReader(directory, output);
			rr.getFiles().scanFiles().save();
		} catch (FileNotFoundException e) {
			System.out.println("Sorry but the directory does not seem to exist.");
		}
	}

	/**
	 * Creates the reader and sorter.
	 * @param args
	 */
	public static void main(String[] args){
		
		Interface i = new Interface();
		
		if (args.length == 1){
			i.testReader(args[0]);
		} else if (args.length == 0){
			i.openInterface();
		} else if (args.length>2){
			System.out.println("[HST Reader] Too many args... Ignoring the extra ones.");
			System.out.println("[HST Reader] Usage: hstparser [dir] [output.file]");
			System.out.println("[HST Reader] Dir is the directory you wish to look in and output.file is the filename to print to.");
		} else {
			i.readDirectory(args[0], args[1]);
		}
		
	}
}