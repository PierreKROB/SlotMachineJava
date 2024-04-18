package mathou;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AddUserController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleAddUserButton() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        LoginController controller = new LoginController();
        controller.addUser(username, password);
    }
}