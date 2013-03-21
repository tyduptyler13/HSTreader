
public class Data implements Comparable<Data>{
	int participant;
	String map;
	int number;
	int generation;
	double score;
	String action;
	int appliance;
	String location;
	String locationType;
	String finalLocation;
	String finalLocationType;
	String extra;
	
	public Data(String map, int participant){
		this.participant = participant;
		this.map = map;
	}
	
	public Data(String map, int participant, String in) throws Exception{
		this.participant = participant;
		this.map = map;
		load(in);
	}
	
	public int getAppliance(){
		return appliance;
	}
	
	public void load(String in) throws Exception{
		String[] parts = in.split("\t");
		if (parts.length != 10){
			throw new Exception("Invalid string. Cell data mismatch.");
		} else {
			number = Integer.parseInt(parts[0]);
			generation = Integer.parseInt(parts[1]);
			score = Double.parseDouble(parts[2]);
			action = parts[3];
			appliance = Integer.parseInt(parts[4].split(" ")[0]);
			location = parts[5];
			locationType = parts[6];
			finalLocation = parts[7];
			finalLocationType = parts[8];
			extra = parts[9];
		}
	}
	
	public String toString(){
		String result = participant + "\t\t" + map + "\t" + number + "\t" + generation + "\t";
		result += score + "\t" + action + "\t" + appliance + " (Fire Truck)\t" + location + "\t" + locationType + "\t";
		result += finalLocation + "\t" + finalLocationType + "\t" + extra + "\t";
		return result;
	}

	/* This will use the appliance number times 1000 and no added together.
	 * The result is the difference between this and the other object.
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Data data) {
		int app = this.appliance - data.appliance;
		int no = this.number - data.number;
		app *= 1000;//Need to offset no completely. If number ever is larger than 1000. This will be an issue.
		return app+no;
	}
}
