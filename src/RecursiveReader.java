import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;




class RecursiveReader{
	
	private ArrayList<File> files = new ArrayList<File>();
	private ArrayList<Data> results = new ArrayList<Data>();
	private File top;
	private File out;
	
	public RecursiveReader(String directory, String out) throws FileNotFoundException{
		top = new File(directory);
		this.out = new File(out);
		if (!top.exists()){
			throw new FileNotFoundException();
		}
	}
	
	/**
	 * It is expected that top is the highest scope directory you wish to use.
	 * It will scan for all hst files in sub directories.
	 * @param top
	 */
	public RecursiveReader getFiles(){
		for (File f : top.listFiles()){
			if (f.isDirectory()){
				getFiles(f);
			} else if (f.getName().contains(".hst")){
				files.add(f);
			}
		}
		
		return this;
	}
	
	private RecursiveReader getFiles(File next){
		for (File f : next.listFiles()){
			if (f.isDirectory()){
				getFiles(f);
			} else if (f.getName().contains(".hst")){
				files.add(f);
			}
		}
		
		return this;
	}
	
	public RecursiveReader scanFiles(){
		Reader r = null;
		for (File f : files){
			if (r == null){
				r = new Reader(f);
			} else {
				try{
					r.reset(f);//Reuse reader.
				} catch (Exception e){
					System.out.println("[HST Reader] An error occured in the reader! The file ("+f.getPath()+") will be skipped.");
					continue;
				}
			}
			results.addAll(r.read().sort().getLast());
			System.out.println(r.getLastString());
		}
		
		return this;
	}
	
	public RecursiveReader save(){
		try {
			FileWriter fw = new FileWriter(out);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("");
			for (Data d : results){
				bw.append(d.toString() + "\r\n");
			}
			bw.flush();
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("The program could not write to the output file. Data was not saved.");
		}
		System.out.println("[HST Reader] All of the results have been printed to "+out.getAbsolutePath()+".");
		return this;
	}
	
}
