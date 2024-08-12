package by.mts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MtsHomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MtsHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Укажите нужное время ожидания
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class, 'cookie')]")
    private WebElement cookieBanner;

    @FindBy(xpath = "//*[contains(@id, 'cookie-agree')]")
    private WebElement acceptCookiesButton;

    @FindBy(xpath = "//*[contains(@class, 'select__header')]")
    private WebElement serviceDropdown;

    @FindBy(xpath = "//*[contains(@class, 'select__now')]")
    private WebElement currentService;

    @FindBy(xpath = "//*[contains(@class, 'select__item')]")
    private List<WebElement> serviceOptions;

    @FindBy(xpath = "//*[contains(@id, 'connection-phone')]")
    private WebElement connectionPhone;

    @FindBy(xpath = "//*[contains(@id, 'connection-sum')]")
    private WebElement connectionSum;

    @FindBy(xpath = "//*[contains(@id, 'connection-email')]")
    private WebElement connectionEmail;

    @FindBy(xpath = "//*[contains(@id, 'internet-phone')]")
    private WebElement internetPhone;

    @FindBy(xpath = "//*[contains(@id, 'internet-sum')]")
    private WebElement internetSum;

    @FindBy(xpath = "//*[contains(@id, 'internet-email')]")
    private WebElement internetEmail;

    @FindBy(xpath = "//*[contains(@id, 'score-instalment')]")
    private WebElement scoreInstalment;

    @FindBy(xpath = "//*[contains(@id, 'instalment-sum')]")
    private WebElement instalmentSum;

    @FindBy(xpath = "//*[contains(@id, 'instalment-email')]")
    private WebElement instalmentEmail;

    @FindBy(xpath = "//*[contains(@id, 'score-arrears')]")
    private WebElement scoreArrears;

    @FindBy(xpath = "//*[contains(@id, 'arrears-sum')]")
    private WebElement arrearsSum;

    @FindBy(xpath = "//*[contains(@id, 'arrears-email')]")
    private WebElement arrearsEmail;

    @FindBy(xpath = "//button[text()='Продолжить']")
    private WebElement continueButton;

    @FindBy(xpath = "//iframe[contains(@class, 'bepaid-iframe')]")
    private WebElement bePaidIframe;

    @FindBy(xpath = "//div[contains(@class, 'pay-description__cost')]//span[1]")
    private WebElement bePaidAmount;

    @FindBy(xpath = "//div[contains(@class, 'pay-description__text')]//span")
    private WebElement bePaidDescription;

    @FindBy(xpath = "//button[contains(@class, 'colored')]")
    private WebElement bePaidButton;

    @FindBy(xpath = "//label[contains(@class, 'ng-tns-c46-1 ng-star-inserted')]")
    private WebElement bePaidCardInput;

    @FindBy(xpath = "//label[contains(@class, 'ng-tns-c46-4 ng-star-inserted')]")
    private WebElement bePaidValidityCard;

    @FindBy(xpath = "//label[contains(@class, 'ng-tns-c46-5 ng-star-inserted')]")
    private WebElement bePaidCvcCard;

    @FindBy(xpath = "//label[contains(@class, 'ng-tns-c46-3 ng-star-inserted')]")
    private WebElement bePaidCardholderName;

    @FindBy(xpath = "//img[contains(@src, 'assets/images/payment-icons/card-types/visa-system.svg')]")
    private WebElement bePaidVisaIcon;

    @FindBy(xpath = "//img[contains(@src, 'assets/images/payment-icons/card-types/mastercard-system.svg')]")
    private WebElement bePaidMastercardIcon;

    @FindBy(xpath = "//img[contains(@src, 'assets/images/payment-icons/card-types/belkart-system.svg')]")
    private WebElement bePaidBelkartIcon;

    @FindBy(xpath = "//img[contains(@src, 'assets/images/payment-icons/card-types/maestro-system.svg')]")
    private WebElement bePaidMaestroIcon;

    @FindBy(xpath = "//img[contains(@src, 'assets/images/payment-icons/card-types/mir-system-ru.svg')]")
    private WebElement bePaidMirIcon;

    public void acceptCookiesIfPresent() {
        if (cookieBanner.isDisplayed()) {
            acceptCookiesButton.click();
        }
    }

    public void selectService(String serviceName) {
        serviceDropdown.click();
        for (WebElement option : serviceOptions) {
            if (option.getText().equals(serviceName)) {
                option.click();
                break;
            }
        }
    }

    public String getCurrentService() {
        return currentService.getText();
    }

    public String getConnectionPhonePlaceholder() {
        return connectionPhone.getAttribute("placeholder");
    }

    public String getConnectionSumPlaceholder() {
        return connectionSum.getAttribute("placeholder");
    }

    public String getConnectionEmailPlaceholder() {
        return connectionEmail.getAttribute("placeholder");
    }

    public String getInternetPhonePlaceholder() {
        return internetPhone.getAttribute("placeholder");
    }

    public String getInternetSumPlaceholder() {
        return internetSum.getAttribute("placeholder");
    }

    public String getInternetEmailPlaceholder() {
        return internetEmail.getAttribute("placeholder");
    }

    public String getScoreInstalmentPlaceholder() {
        return scoreInstalment.getAttribute("placeholder");
    }

    public String getInstalmentSumPlaceholder() {
        return instalmentSum.getAttribute("placeholder");
    }

    public String getInstalmentEmailPlaceholder() {
        return instalmentEmail.getAttribute("placeholder");
    }

    public String getScoreArrearsPlaceholder() {
        return scoreArrears.getAttribute("placeholder");
    }

    public String getArrearsSumPlaceholder() {
        return arrearsSum.getAttribute("placeholder");
    }

    public String getArrearsEmailPlaceholder() {
        return arrearsEmail.getAttribute("placeholder");
    }

    public void enterDataForConnection(String phoneNumber, String amount) {
        connectionPhone.clear();
        connectionPhone.sendKeys(phoneNumber);
        connectionSum.clear();
        connectionSum.sendKeys(amount);
        continueButton.click();
    }

    public boolean isBePaidIframeDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(bePaidIframe));
        boolean result = bePaidIframe.isDisplayed();
        driver.switchTo().frame(bePaidIframe);
        return result;
    }

    public String getBePaidAmount() {
        wait.until(ExpectedConditions.visibilityOf(bePaidAmount));
        return bePaidAmount.getText();
    }

    public String getBePaidDescription() {
        return bePaidDescription.getText();
    }

    public String getBePaidButtonText() {
        return bePaidButton.getText();
    }

    public String getBePaidCardInputText() {
        return bePaidCardInput.getText();
    }

    public String getBePaidValidityCardText() {
        return bePaidValidityCard.getText();
    }

    public String getBePaidCvcCardText() {
        return bePaidCvcCard.getText();
    }

    public String getBePaidCardholderNameText() {
        return bePaidCardholderName.getText();
    }

    public boolean isBePaidVisaIconDisplayed() {
        return bePaidVisaIcon.isDisplayed();
    }

    public boolean isBePaidMastercardIconDisplayed() {
        return bePaidMastercardIcon.isDisplayed();
    }

    public boolean isBePaidBelkartIconDisplayed() {
        return bePaidBelkartIcon.isDisplayed();
    }

    public boolean isBePaidMaestroIconDisplayed() {
        return bePaidMaestroIcon.isDisplayed();
    }

    public boolean isBePaidMirIconDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(bePaidMirIcon));
        return bePaidMirIcon.isDisplayed();
    }
}

