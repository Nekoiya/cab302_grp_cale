package com.cab302.eduplanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DashboardUiTest {

    private static String read(String relativePath) {
        try {
            return Files.readString(Path.of(relativePath));
        } catch (IOException ex) {
            throw new IllegalStateException("Failed to read " + relativePath, ex);
        }
    }

    @Test
    @DisplayName("Dashboard FXML exposes a subtitle label under the greeting")
    void subtitleLabelIsDeclared() {
        String fxml = read("src/main/resources/com/cab302/eduplanner/dashboard.fxml");
        assertTrue(fxml.contains("fx:id=\"greetingSubtitle\""),
                "Expected dashboard.fxml to declare a greetingSubtitle label");
    }

    @Test
    @DisplayName("Greeting subtitle copy nudges the user to stay on track")
    void subtitleUsesFriendlyCopy() {
        String fxml = read("src/main/resources/com/cab302/eduplanner/dashboard.fxml");
        assertTrue(fxml.contains("Keep your study plan on track today."),
                "Greeting subtitle text should encourage study focus");
    }

    @Test
    @DisplayName("Greeting subtitle label is styled with a dedicated CSS class")
    void subtitleHasStyleClass() {
        String fxml = read("src/main/resources/com/cab302/eduplanner/dashboard.fxml");
        assertTrue(fxml.contains("styleClass=\"greeting-subtitle\""),
                "Greeting subtitle should use the greeting-subtitle style class");
    }

    @Test
    @DisplayName("Dashboard stylesheet defines the greeting subtitle style")
    void stylesheetDefinesGreetingSubtitleClass() {
        String css = read("src/main/resources/com/cab302/eduplanner/styles/dashboard.css");
        assertTrue(css.contains(".greeting-subtitle"),
                "dashboard.css should define the greeting-subtitle class");
    }
}
