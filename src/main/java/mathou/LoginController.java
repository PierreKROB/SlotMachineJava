package mathou;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LoginController {

    private Map<String, String> users = new HashMap<>();
    private static final String USERS_FILE = "users.json";
    private static final Gson GSON = new Gson();

    public LoginController() {
        loadUsers();
    }

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLoginButton() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (isValidCredentials(username, password)) {
            try {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SlotMachineUI.fxml")));
                SlotMachineApp.primaryStage.setScene(new Scene(root));
                SlotMachineApp.primaryStage.setTitle("SlotMachine Pokémon");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isValidCredentials(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    public void addUser(String username, String password) {
        users.put(username, password);
        saveUsers();
    }

    private void loadUsers() {
        try (FileReader reader = new FileReader(USERS_FILE)) {
            Type type = new TypeToken<HashMap<String, String>>(){}.getType();
            users = GSON.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveUsers() {
        try (FileWriter writer = new FileWriter(USERS_FILE)) {
            GSON.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}