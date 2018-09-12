package view;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import model.Course;
import model.MasterCourseBag;
import model.Textbook;
import model.TextbookBag;

public class UpdateCourse {

	private BorderPane updatePane;
	private Button save;
	private Button reset;

	public UpdateCourse(MasterCourseBag courseBag, TextbookBag bookBag, Course course) {

		updatePane = new BorderPane();

		InsertCourse insertCoursePane = new InsertCourse(courseBag, bookBag);
		save = insertCoursePane.getSaveButton();

		reset = insertCoursePane.getResetButton();
		reset.setOnAction(insertCoursePane.getResetButton().getOnAction());

		save.setOnAction(e -> {
			String courseTitle = insertCoursePane.getCourseTitleField().getText();
			String courseNumber = insertCoursePane.getCourseNumberField().getText();
			String credit = insertCoursePane.getCreditsField().getText();
			String textbookNumber = insertCoursePane.getCourseNumberField().getText();
			if (!courseTitle.isEmpty()) {
				course.setCourseTitle(courseTitle);
			}
			if (!courseNumber.isEmpty()) {
				course.setCourseNumber(courseNumber);
			}
			if (!credit.isEmpty()) {
				course.setNumberCreds(Integer.parseInt(credit));
			}
			if (!textbookNumber.isEmpty()) {
				Textbook book = bookBag.findTextbook(textbookNumber);
				course.setBook(book);
			}
			insertCoursePane.getCourseNumberField().clear();
			insertCoursePane.getCreditsField().clear();
			insertCoursePane.getCourseNumberField().clear();
			insertCoursePane.getCourseTitleField().clear();
		});

		updatePane.setCenter(insertCoursePane.getInsertPane());
	}

	public BorderPane getUpdatePane() {
		return updatePane;
	}

	public void setUpdatePane(BorderPane updatePane) {
		this.updatePane = updatePane;
	}

	public Button getSave() {
		return save;
	}

	public void setSave(Button save) {
		this.save = save;
	}

	public Button getReset() {
		return reset;
	}

	public void setReset(Button reset) {
		this.reset = reset;
	}
	
}
