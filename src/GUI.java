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

		Group root = new Group();
		Scene scene = new Scene(root, 200, 150);
		scene.setFill(Color.BLACK);

		BorderPane bp = new BorderPane();
		root.getChildren().add(bp);

		//Top
		{
			Text title = new Text();
			title.setFont(new Font(20));
			title.setTextAlignment(TextAlignment.CENTER);
			title.setText("HST Reader");
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
			}
		}

		//Bottom
		Text t = new Text();
		t.setFont(new Font(10));
		t.setTextAlignment(TextAlignment.CENTER);
		t.setText("HST Reader (beta) - Tyler Scott");
		bp.setBottom(t);

		s.setScene(scene);
		s.show();
	}


}