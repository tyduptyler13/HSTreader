import java.io.File;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class GUI extends Application{

	File in;
	TextArea console;
	RecursiveReader rr;
	private final String desc = "Description: This program will find all files within the load directory. "+
								"It will then sort all entries in each file by column 5 and then by column 1. "+
								"After this it will pick out the last entry of each value in column 5 and save them.";

	@Override
	public void start(Stage s) throws Exception {
		s.setTitle("HSTreader");

		BorderPane root = new BorderPane();
		root.setPrefSize(500, 400);
		final Scene scene = new Scene(root);
		//scene.setFill(Color.BLACK);

		//Top
		{
			Text title = new Text();
			title.setFont(new Font(20));
			title.setTextAlignment(TextAlignment.CENTER);
			title.setText("HST Reader");
			root.setAlignment(title, Pos.TOP_CENTER);
			root.setTop(title);
		}	
		//Center
		{
			VBox content = new VBox();
			final Button parse = new Button("Parse");
			final Button save = new Button("Save");
			//Description
			{
				Text d = new Text();
				d.setFont(new Font(14));
				d.setText(desc);
				d.setWrappingWidth(500);
				content.getChildren().add(d);
			}
			Separator s1 = new Separator();
			content.getChildren().add(s1);
			//Loader
			{
				Button open = new Button("Open Directory");
				open.setOnAction(new EventHandler<ActionEvent>(){
					public void handle(ActionEvent e){
						DirectoryChooser dc = new DirectoryChooser();
						dc.setInitialDirectory(new File(System.getProperty("user.home")));
						in = dc.showDialog(scene.getWindow());
						log("In directory set to "+ in.getPath());
						parse.setDisable(false);
					}
				});
				content.getChildren().add(open);
			}
			Separator s2 = new Separator();
			content.getChildren().add(s2);
			//Pseudo Console
			{
				console = new TextArea();
				console.setEditable(false);
				content.getChildren().add(console);
			}
			Separator s3 = new Separator();
			content.getChildren().add(s3);
			//Add Parse button
			{
				parse.setDisable(true);
				parse.setOnAction(new EventHandler<ActionEvent>(){

					public void handle(ActionEvent arg0) {
						try {
							rr = new RecursiveReader(in);
							log("Scanning for hst files.");
							rr.getFiles();
							log("Found "+rr.getFileCount()+" files. Parsing... This can take some time.");
							rr.scanFiles();
							save.setDisable(false);
							log("Files parsed.");
						} catch (FileNotFoundException e) {
							console.appendText("[error] The directory does not exist... try again.\r\n");
						}
						
					}
					
				});
				content.getChildren().add(parse);
			}
			//Add save button
			{
				save.setDisable(true);
				save.setOnAction(new EventHandler<ActionEvent>(){
					public void handle(ActionEvent e) {
						FileChooser fc = new FileChooser();
						fc.setInitialDirectory(new File(System.getProperty("user.home")));
						fc.setTitle("Choose a save file");
						rr.setOut(fc.showSaveDialog(scene.getWindow()));
						try {
							rr.save();
							log("Contents have been saved.");
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							console.appendText("[error] An error has occured. Full trace printed to console.\r\n");
							e1.printStackTrace();

						}
					}
				});
				content.getChildren().add(save);
			}
			root.setCenter(content);
		}

		//Bottom
		{
			Text t = new Text();
			t.setFont(new Font(10));
			t.setTextAlignment(TextAlignment.CENTER);
			t.setText("HST Reader (beta) - Tyler Scott");
			root.setAlignment(t, Pos.BOTTOM_RIGHT);
			root.setBottom(t);
		}

		s.setScene(scene);
		s.show();
	}

	public void log(String s){
		console.appendText("[HSTreader] "+s+"\r\n");
	}
	
	public static void openInterface(){
		System.out.println("Use the GUI to choose your file locations.");
		launch(new String[0]);
	}

	public static void main(String[] args){

		if (args.length == 1){
			Main.testReader(args[0]);
		} else if (args.length == 0){
			openInterface();
		} else if (args.length>2){
			System.out.println("[HST Reader] Too many args... Ignoring the extra ones.");
			System.out.println("[HST Reader] Usage: hstparser [dir] [output.file]");
			System.out.println("[HST Reader] Dir is the directory you wish to look in and output.file is the filename to print to.");
		} else {
			Main.readDirectory(args[0], args[1]);
		}

	}

}