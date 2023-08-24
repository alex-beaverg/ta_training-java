package pagefactory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.ExplicitCondition;

public class HardCoreTaskCalculatorPage {
    private WebDriver driver;
    private String numberOfInstances = "4";
    String calculatorPageWindowHandle;

    @FindBy(id = "input_92")
    private WebElement numberOfInstancesField;

    @FindBy(id = "select_117")
    private WebElement seriesField;
    @FindBy(xpath = "//md-option[@id=\"select_option_203\"]")
    private WebElement correctSeries;

    @FindBy(id ="select_119")
    private WebElement machineTypeField;
    @FindBy(xpath = "//md-option[@id=\"select_option_430\"]")
    private WebElement correctMachineType;

    @FindBy(xpath = "//md-checkbox[@ng-model = \"listingCtrl.computeServer.addGPUs\"]")
    private WebElement addGpuCheckbox;

    @FindBy(id ="select_468")
    private WebElement addGpuField;
    @FindBy(xpath = "//md-option[@id=\"select_option_473\"]")
    private WebElement correctGpu;

    @FindBy(xpath = "//*[@id=\"select_value_label_467\"]")
    private WebElement addNumberOfGpu;
    @FindBy(xpath = "//*[@id=\"select_option_479\"]")
    private WebElement correctNumberOfGpu;

    @FindBy(xpath = "//*[@id=\"select_value_label_424\"]")
    private WebElement addLocalSsd;
    @FindBy(xpath = "//*[@id=\"select_option_451\"]")
    private WebElement correctLocalSsd;

    @FindBy(xpath = "//*[@id=\"select_value_label_90\"]")
    private WebElement addDataCenter;
    @FindBy(xpath = "//*[@id=\"select_option_230\"]")
    private WebElement correctDatCenter;

    @FindBy(xpath = "//*[@id=\"select_132\"]")
    private WebElement addCommittedUsage;
    @FindBy(xpath = "//*[@id=\"select_option_130\"]")
    private WebElement correctCommittedUsage;

    @FindBy(xpath = "//button[@aria-label=\"Add to Estimate\"]")
    private WebElement addToEstimate;

    @FindBy(xpath = "//*[@id=\"Email Estimate\"]")
    private WebElement sendEstimateButton;

    @FindBy(xpath = "//*[@id=\"input_545\"]")
    private WebElement emailField;

    @FindBy(xpath = "//button[@aria-label = \"Send Email\"]")
    private WebElement sendButton;

    @FindBy(xpath = "//b[@class = \"ng-binding\" and contains (., \"Total\")]")
    private WebElement totalEstimate;

    public HardCoreTaskCalculatorPage(WebDriver driver) {
        this.driver = driver;
        calculatorPageWindowHandle = driver.getWindowHandle();
        PageFactory.initElements(driver, this);
    }

    public HardCoreTaskCalculatorPage addComputerToEstimate() {
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
        numberOfInstancesField.sendKeys(numberOfInstances);
        seriesField.click();
        new ExplicitCondition(driver, correctSeries);
        correctSeries.click();
        machineTypeField.click();
        new ExplicitCondition(driver, correctMachineType);
        correctMachineType.click();
        addGpuCheckbox.click();
        addGpuField.click();
        new ExplicitCondition(driver, correctGpu);
        correctGpu.click();
        addNumberOfGpu.click();
        new ExplicitCondition(driver, correctNumberOfGpu);
        correctNumberOfGpu.click();
        addLocalSsd.click();
        new ExplicitCondition(driver, correctLocalSsd);
        correctLocalSsd.click();
        addDataCenter.click();
        new ExplicitCondition(driver, correctDatCenter);
        correctDatCenter.click();
        addCommittedUsage.click();
        new ExplicitCondition(driver, correctCommittedUsage);
        correctCommittedUsage.click();
        addToEstimate.click();
        return new HardCoreTaskCalculatorPage(driver);
    }

    public String sendEstimateToEmail(String email) {
        driver.switchTo().window(calculatorPageWindowHandle);
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
        String total = totalEstimate.getText();
        sendEstimateButton.click();
        emailField.sendKeys(email);
        sendButton.click();
        return total.substring(22, 34);
    }

}
