package uk.ac.ucl.coursework.control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import uk.ac.ucl.coursework.CinemaMain;
import uk.ac.ucl.coursework.xml.CreateEditFilmXML;

public class EmployeeHomeController implements Initializable {

	// DECLARES THE FXML TEXTFIELD VARIABLES
	@FXML
	private TextField filmTitle, filmDate, filmStart, filmEnd, filmGenre, filmDescription;

	public Scene scene5;

	/**
	 * Adds a film to the 'film.XML' file Uses the employee input to text-fields
	 * to set the film variables. Calls 'createFilm' method from 'CreateEditFilmXML' class
	 * 
	 * @param event
	 *            : event created from button click
	 */
	@FXML
	private void addFilm(ActionEvent event) {

		CreateEditFilmXML.setTitle(filmTitle.getText());
		CreateEditFilmXML.setDescription(filmDescription.getText());
		CreateEditFilmXML.setGenre(filmGenre.getText());
		CreateEditFilmXML.setStart(filmStart.getText());
		CreateEditFilmXML.setEnd(filmEnd.getText());
		CreateEditFilmXML.setDate(filmDate.getText());

		CreateEditFilmXML.createsFilm();
	}

	/**
	 * Takes the employee to the 'What's On' page. Sets a new scene (5) to
	 * 'thestage'
	 * 
	 * @param event
	 *            : event created by clicking menu-bar item
	 */
	@FXML
	private void goToWhatsOn(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/WhatsOnEmployee.fxml"));
			scene5 = new Scene(root, 690, 850);
			CinemaMain.thestage.setTitle("What's On");
			CinemaMain.thestage.setScene(scene5);
			CinemaMain.thestage.show();
		} catch (Exception e) {
			CinemaMain.LOGGER.warning("Couldn't load What's On");
			e.printStackTrace();
		}

	}
	
	@FXML 
	private void logsOut(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/LoginScreen.fxml"));
			scene5 = new Scene(root, 480, 300);
			CinemaMain.thestage.setTitle("Cinema Login");
			CinemaMain.thestage.setScene(scene5);
			CinemaMain.thestage.show();
		} catch (Exception e) {
			CinemaMain.LOGGER.warning("Problem logging out");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
