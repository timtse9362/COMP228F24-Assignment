package com.example.kinchuentse_comp228lab4;

import javafx.fxml.FXML;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

public class Lab4Controller implements Initializable{

    //Declare the objects
    @FXML private TextField nameTextField;
    @FXML private TextField addressTextField;
    @FXML private TextField provinceTextField;
    @FXML private TextField cityTextField;
    @FXML private TextField postalCodeTextField;
    @FXML private TextField phoneTextField;
    @FXML private TextField emailTextField;
    @FXML private RadioButton csRadio;
    @FXML private RadioButton businessRadio;
    @FXML private ComboBox<String> courseComboBox;
    @FXML private ListView<String> courseListView;
    @FXML private CheckBox studentCouncilCheckBox;
    @FXML private CheckBox volunteerCheckBox;
    @FXML private TextArea displayArea;
    @FXML private Button displayButton;

    //Declare the Computer Science and Business Courses array list
    private final ObservableList<String> selectedCourses = FXCollections.observableArrayList();
    private final ObservableList<String> csCourses = FXCollections.observableArrayList("Java", "Python", "C#");
    private final ObservableList<String> businessCourses = FXCollections.observableArrayList("Accounting", "Economics", "Marketing", "Management", "Finance");


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize ToggleGroup for radio buttons
        ToggleGroup programGroup = new ToggleGroup();
        csRadio.setToggleGroup(programGroup);
        businessRadio.setToggleGroup(programGroup);

        // All the CS courses into the dropdown list
        courseComboBox.setItems(csCourses);
        courseListView.setItems(selectedCourses);
    }

    @FXML
    private void addComboBoxCourse(){ // To set the dropdown menu courses when CS or business radio button is selected
        if (csRadio.isSelected()){
            courseComboBox.setItems(csCourses);
        }
        else{
            courseComboBox.setItems(businessCourses);
        }
    }

    @FXML
    private void addCourse() { // Add the selected course from dropdown menu to the listview and will check if duplicated
        String selectedCourse = courseComboBox.getSelectionModel().getSelectedItem();
        if (selectedCourse != null && !selectedCourses.contains(selectedCourse)) {
            selectedCourses.add(selectedCourse);
        }
    }

    @FXML
    private void displayInfo() { // To display the student information when the Display button is clicked
        try{
            if (nameTextField.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty");
            }
            if (addressTextField.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Address cannot be empty");
            }
            if (provinceTextField.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Province cannot be empty");
            }
            if (cityTextField.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("City cannot be empty");
            }
            if (postalCodeTextField.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Postal Code cannot be empty");
            }
            if (phoneTextField.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Phone Number cannot be empty");
            }
            if (emailTextField.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Email cannot be empty");
            }
            if (courseListView.getItems().isEmpty()) {
                throw new IllegalArgumentException("Please select at least one course from the dropdown menu");
            }

            String info = nameTextField.getText() + ", " + addressTextField.getText() + ", " + cityTextField.getText() + ", " + provinceTextField.getText() + ", " + postalCodeTextField.getText() + ", " + phoneTextField.getText() + ", " + emailTextField.getText() + '\n';

            info = info + "Courses:\n";

            for (int i = 0; i < selectedCourses.size(); i++) {
                info += selectedCourses.get(i) + "\n";
            }

            if(volunteerCheckBox.isSelected() && studentCouncilCheckBox.isSelected()){
                info = info + "Involvement in Volunteer Work and Student Council\n";
            }
            else if (volunteerCheckBox.isSelected() && !studentCouncilCheckBox.isSelected()){
                info = info + "Involvement in Volunteer Work\n";
            }
            else if (studentCouncilCheckBox.isSelected() && !volunteerCheckBox.isSelected()){
                info = info + "Involvement in Student Council\n";
            }
            displayArea.setText(info);
        }
        catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}