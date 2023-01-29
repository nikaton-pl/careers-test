package pages.careers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class CareerPage extends BasePage {
    public CareerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "keywordLocation")
    WebElement findYourCareerInput;

    @FindBy(id = "location")
    WebElement locationInput;

    @FindBy(xpath = "//button[@title='Search']")
    WebElement searchButton;

    @FindBy(xpath = "//div[@class='row no-gutters']")
    WebElement resultsFirstRow;
    @FindBy(xpath = "//div[@class='row no-gutters']")
    List<WebElement> resultsRowsList;

    @FindBy(xpath = "//span[@class='badge badge-primary p-2 d-flex flex-row flex-nowrap align-items-center']")
    WebElement searchTextBadge;

    @FindBy(xpath = "//div[@class='text-muted font-italic mb-2 overflow-hidden']/span")
    WebElement jobFoundTextMessage;

    public CareerPage findYourCareerInputText(String inputText) {
        findYourCareerInput.sendKeys(inputText);
        return this;
    }

    public CareerPage locationInputTextSelectCountry(String inputText) {
//        waitForElement(jobFoundTextMessage);
        locationInput.sendKeys(inputText);
        WebElement countryElementOfList = driver
                .findElement(By.xpath("//ul[@id='location_list']/li[not(contains(text(),', " + inputText +
                        "')) and contains(text(),'" + inputText + "')]"));
        countryElementOfList.click();
        waitForElement(resultsFirstRow);
        return this;
    }

    public CareerPage searchButtonClick() {
        searchButton.click();
        waitForElement(searchTextBadge);
        return this;
    }

    public int getFoundJobsCountFromTextMessage() {
        String jobFoundMessageText = jobFoundTextMessage.getText();
        jobFoundMessageText = jobFoundMessageText.replaceAll("\\D+","");
        return Integer.parseInt(jobFoundMessageText);
    }

    public int getFoundJobsRowCount(){
        return resultsRowsList.size();
    }

}
