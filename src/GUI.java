import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class GUI extends Application{

	@Override
	public void start(Stage s) throws Exception {
		s.setTitle("HSTreader");

		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 200, 150);
		//scene.setFill(Color.BLACK);

		//Top
		{
			Text title = new Text();
			title.setFont(new Font(20));
			title.setTextAlignment(TextAlignment.CENTER);
			title.setText("HST Reader");
			root.getChildren().add(title);
		}

		//Center
		{
			VBox content = new VBox();
			//Loader
			{
				VBox loader = new VBox();
				content.setSpacing(10);
				Text title = new Text();
				title.setFont(new Font(14));
				title.setText("Load file:");
				loader.getChildren().add(title);
				Button open = new Button("Open Directory");
				//TODO
				
				content.getChildren().add(loader);
			}
			root.getChildren().add(content);
		}

		//Bottom
		{
			Text t = new Text();
			t.setFont(new Font(10));
			t.setTextAlignment(TextAlignment.CENTER);
			t.setText("HST Reader (beta) - Tyler Scott");
			root.setBottom(t);
		}

		s.setScene(scene);
		s.show();
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