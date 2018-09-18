package Controllers;

import application.Main;

import java.awt.List;
import java.awt.TextArea;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import Comun.Metodos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.control.ProgressBar;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;



import javafx.stage.Stage;


public class MainController implements Initializable{
	Stage stage1 = null;
	@FXML private ProgressBar pbar_Progress = new ProgressBar(0);
	@FXML private TextField txtID,txtPass;
	@FXML private TextField Txt_IP,Txt_Port,Txt_User,Txt_Password,Txt_DB;
	@FXML private CheckBox Clk_Utf;
	private Boolean estadoTest = false;
	

	Main command = new Main();

	public void Login(ActionEvent event)  {
		
		if(txtID.getText().equals("user") && txtPass.getText().equals("pass")) {
			
			try {
			Parent root = FXMLLoader.load(getClass().getResource("/Views/Main.fxml"));
			command.closeLogin((Stage)txtID.getScene().getWindow());
			Stage stage = new Stage();
			stage.setResizable(false);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			}catch (Exception Ex) {
				System.out.println(Ex);
			}
			}
		}
		
	public void SQLSetup(ActionEvent event) throws Exception {
		String[] data = new String[6];
		int i =0;
		data[0] =  Txt_IP.getText();
		data[1] = Txt_Port.getText();
		data[2] = Txt_User.getText();
		data[3] = Txt_Password.getText();
		data[4] = Txt_DB.getText();
		data[5] = "?&characterEncoding=UTF-8";
		String url;

		
		
		System.out.println("Iniciando Test");
		Connection con;
		if (Txt_DB.getText().equals("")) {
			url = "jdbc:mysql://"+data[0]+":"+data[1]+data[5];
		}else {
			url = "jdbc:mysql://"+data[0]+":"+data[1]+"/"+data[4]+data[5];
		}

		try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,data[2],data[3]);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("show databases");
	
		//ElegirDB(rs, i );	
		
		

		
		con.close();	
		this.estadoTest = true;
		this.pbar_Progress.setProgress(1);
		
		}catch (Exception ex) {
			System.out.println("Test ended in exception");
			this.estadoTest = false;
			this.pbar_Progress.setProgress(0);
		}	


	}
	
	public void ElegirDB(ResultSet rs,int r) throws SQLException {
		int i = 0;
		String [] choices = new String[r];
		ChoiceDialog<String> dialog = new ChoiceDialog<>("Data bases", choices);
		while(rs.next()) {
			choices[i]=rs.getString("Database");
			System.out.println(choices[i]);
			i++;
		}
		
		
		dialog.setTitle("DB requerida");
		dialog.setHeaderText("Porfavor selecciona una DB en la cual trabajaras");
		dialog.setContentText("Elige tu DB:");

		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
		    System.out.println("Your choice: " + result.get());
		}

		// The Java 8 way to get the response value (with lambda expression).
		result.ifPresent(letter -> System.out.println("Your choice: " + letter));
	}
	
	public void SqlGuardar() throws IOException {
		Metodos Guardado = new Metodos();
		String IP = Txt_IP.getText();
		String port = Txt_Port.getText();
		String user = Txt_User.getText();
		String pass = Txt_Password.getText();
		String db = Txt_DB.getText();
		String url = "jdbc:mysql://"+IP+":"+port+"/"+db+"?&characterEncoding=UTF-8";
		if (this.estadoTest) {
		Guardado.GuardarSqlConData(url,user,pass);
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Hubo un error con respecto a la SQL");
			alert.setContentText("Porfavor asegurate que la conneccion haya sido exitosa para continuar  "
					+ "Si no tienes los datos ahora podras ingresarlos mas tarde");
			alert.showAndWait();
		}
	}

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
