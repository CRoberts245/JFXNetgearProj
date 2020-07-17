//Cameron Roberts
//Prof. Maini
//Spring 2020 Prog GUI

package netgearreplace;
import javafx.scene.image.Image;
import javafx.scene.control.ScrollBar;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.geometry.Orientation;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.application.Application;
import javafx.scene.shape.Sphere;
import javafx.collections.ObservableList;
import javafx.scene.text.Font;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.control.Control;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.Group;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import javafx.collections.FXCollections;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableView;
import java.util.ArrayList;

/**
 *
 * @author rober
 */
public class NetGearReplace extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        List<String> list = new ArrayList<String>();
        ObservableList<String> theList = FXCollections.observableList(list);
        theList.add("GARRISON    Security:WPA/WPA2  Channel:1  MAC Address:D0-XX-XX-XX-XX-XX  Strength: Good");
        theList.add("WINSTON     Security:WPA/WPA2  Channel:12 MAC Address:D1-XX-XX-XX-XX-XX  Strength: Weak");
        theList.add("MICHAELS    Security:WPA/WPA2  Channel:11 MAC Address:D2-XX-XX-XX-XX-XX  Strength: Medium");
        theList.add("DEVINS        Security:WPA/WPA2  Channel:55 MAC Address:D3-XX-XX-XX-XX-XX  Strength: N/A");
        theList.add("UNKOWN    Security:none             Channel:1  MAC Address:D4-XX-XX-XX-XX-XX   Strength: Weak");
        
        ListView TableNScroll = new ListView(theList);
      
       TableNScroll.setFixedCellSize(40);
        HBox hboxSelect   = new HBox();
        //draw a sphere
        Rectangle r = new Rectangle();
        r.setFill(Color.STEELBLUE);
        r.setWidth(678);
        r.setHeight(60);
        r.setArcWidth(20);
        r.setArcHeight(20);
        //text creation
        Text t = new Text("Netgear Wireless");
       

        //Set font of the text
        t.setFont(Font.font(null, FontWeight.BOLD, 24));
        //Set color of the text
        t.setFill(Color.BLACK);
        
        Text t1 = new Text("N300 Wireless Adapter        Version: 2.2.0.4");
       
        //Set font of the text
        t1.setFont(Font.font(null, FontWeight.NORMAL, 12));
        //Set color of the text
        t1.setFill(Color.BLACK);
        StackPane sp = new StackPane();
        sp.getChildren().addAll(r, t,t1);
        sp.setAlignment(t1, Pos.BOTTOM_LEFT);
        sp.setAlignment(t, Pos.TOP_LEFT);
        sp.setMargin(t1, new Insets(0,0,0,25));
        sp.setMargin(t, new Insets(10,10,10,10));
        root.getChildren().addAll(sp,TableNScroll,hboxSelect);
        String myString = "No Connection";
        Text textConnection = new Text(myString);

        Button btnCon = new Button();
        btnCon.setText("Connect");
        btnCon.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String listPickString = TableNScroll.getSelectionModel().getSelectedItem().toString();
                String delims = "[ ]+";
                String[] tokens = listPickString.split(delims);
                textConnection.setText("Current Connection:  "+tokens[0]+"   "+tokens[5]+" "+tokens[6]);
            }
        });
        
        Button btnDisconnect = new Button();
        btnDisconnect.setText("Disconnect");
        btnDisconnect.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                
                textConnection.setText(myString);
            }
        });

        
        
        HBox cButton = new HBox(btnCon,btnDisconnect,textConnection);
        cButton.setMargin(textConnection,new Insets(5,0,0,30));
        cButton.setMargin(btnDisconnect,new Insets(0,0,0,15));
        cButton.setMargin(btnCon,new Insets(0,0,0,15));
        root.getChildren().addAll(cButton);
     


        
        Scene scene = new Scene(root, 680, 420);

        
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
