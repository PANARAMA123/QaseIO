package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectsPage {

    final String NEW_PROJECT_NAME_CSS = "#project-name";
    final String NEW_PROJECT_CODE_CSS = "#project-code";
    final String NEW_DESCRIPTION_AREA_CSS = "#description-area";
    final String CREATE_NEW_PROJECT_BTN_CSS = "#createButton";

    public void openPage() {
        open("/projects");
    }
    public void waitUntilOpen() {
        $(CREATE_NEW_PROJECT_BTN_CSS).shouldBe(Condition.visible);
    }

    public void createNewProject(String name, String code, String description) {
        $(CREATE_NEW_PROJECT_BTN_CSS).click();
        $(NEW_PROJECT_NAME_CSS).setValue(name);
        $(NEW_PROJECT_CODE_CSS).setValue(code);
        $(NEW_DESCRIPTION_AREA_CSS).setValue(description).submit();
    }
    public  void createNewProject(String name) {
            $(CREATE_NEW_PROJECT_BTN_CSS).click();
            $(NEW_PROJECT_NAME_CSS).setValue(name).submit();
    }
}
