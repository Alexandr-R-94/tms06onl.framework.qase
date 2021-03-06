package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import core.ReadProperties;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestRepositoryPage extends BasePage {

    @FindBy(xpath = "//p[@class='header']")
    private WebElement title;
    @FindBy(xpath = "//a[@title = 'Import']")
    private WebElement importButton;
    @FindBy(xpath = "//button[@class = 'btn btn-secondary mt-3 me-2']")
    private WebElement exportButton;
    @FindBy(xpath = "//a[text() = 'Trash bin']")
    private WebElement trashBinButton;
    @FindBy(id = "create-suite-button")
    private WebElement suiteButton;
    @FindBy(id = "create-case-button")
    private WebElement caseButton;
    @FindBy(xpath = "//span[text() = 'Settings']")
    private WebElement settings;
    @FindBy(xpath = "//span[@class='alert-message']")
    public WebElement uploadDoneMessage;
    @FindBy(xpath = "//a[@aria-label='Projects']/span")
    private WebElement projectsBtn;

    private final static String endpoint = "project/123";

    public TestRepositoryPage(BrowsersService browsersService, boolean openPageByURL) {
        super(browsersService, openPageByURL);
    }

    @Override
    protected void openPage() {
        browsersService.getDriver().get(ReadProperties.getInstance().getURL() + endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return title.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }


    public SettingsPage settingsClick() {
        settings.click();
        logger.info("Нажатие на кнопку настройки");
        return new SettingsPage(browsersService, false);
    }
    public String titleText(){
        return title.getText();
    }
    public ImportTestCasesPage importBtn() {
        importButton.click();
        logger.info("Нажатие на кнопку Import");
        return new ImportTestCasesPage(browsersService, false);
    }
    public void projectsBtn() {projectsBtn.click();}
}
