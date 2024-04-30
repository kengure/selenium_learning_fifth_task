package ru.appline.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Keys;

import java.util.List;

/**
 * Страница подкатегории товаров
 */
public class SubCategoryPage extends BasePage {

    @FindBy(xpath = "//h1[contains(@class, 'PageTitle_title')]")
    private WebElement categoryPageTitle;

    @FindBy(xpath = "//span[text()='Фильтры']")
    private WebElement filters;

    @FindBy(xpath = "//p[contains(@class, 'CardCategory_title')]")
    private List<WebElement> listSubCategory;

    @FindBy(xpath = "//div[contains(@class, 'ListingFilters_filterList')]//input[@name = 'min']")
    private WebElement minPrice;

    @FindBy(xpath = "//label[contains(@class, 'Checkbox_text')]")
    private List<WebElement> listManufacturer;

    @FindBy(xpath = "//div[contains(@class, 'Card_wrap')]")
    private List<WebElement> listItemOnPage;

    @FindBy(xpath = "//div[contains(@class, 'Card_wrap')]//a/div[@title]")
    private List<WebElement> listItemTitleOnPage;

    @FindBy(xpath = "//input[@id='searchInput']")
    private WebElement searchInput;

    @FindBy(xpath = "//span[contains(@class, 'PageTitle_count') and text()='1 товар']")
    private WebElement oneItemInTitle;

    /**
     * Функция проверки видимости title страницы
     *
     * @return SubCategoryPage - т.е. остаемся на этой странице
     */
    public SubCategoryPage checkOpenSubCategoryPage(String nameSubCategory) {
        waitUtilElementToBeVisible(filters);
        waitUtilElementToBeVisible(categoryPageTitle);
        if (!categoryPageTitle.getText().equals(nameSubCategory)) {
            Assert.fail("Категория '" + nameSubCategory + "' не была открыта");
        }
        return this;
    }

    /**
     * Функция заполнения полей при фильтрации товаров
     *
     * @param nameField - название поля
     * @param value     - вводимое значение
     * @return SubCategoryPage - т.е. остаемся на этой странице
     */
    public SubCategoryPage fillFilterField(String nameField, String value) {
        switch (nameField) {
            case "Цена от":
                fillInputField(minPrice, value);
                break;
            case "Производитель":
                driverManager.getDriver().findElement(By.xpath("//input[@value='" + value + "']/../label/*")).click();
                Assert.assertTrue("Поле было заполнено некорректно", driverManager.getDriver()
                        .findElement(By.xpath("//input[@value='" + value + "']")).isSelected());
                break;
            default:
                Assert.fail("Поле с наименованием '" + nameField + "' отсутствует на странице ");

        }
        return this;
    }

    /**
     * Функция проверки загрузки страницы
     *
     * @return SubCategoryPage - т.е. остаемся на этой странице
     */
    public SubCategoryPage checkLoadingSubCategoryPage() {
        driverManager.getDriver().findElement(By.xpath("//meta[@name='next-head-count' and @content='31']"));
        driverManager.getDriver().findElement(By.xpath("//meta[@name='next-head-count' and @content='32']"));
        driverManager.getDriver().findElement(By.xpath("//meta[@property='og:image']"));
        return this;
    }


    /**
     * Функция проверки, что отображаемое количество товаров на странице соответсвует заданному
     *
     * @param itemNumber - количество товаров
     * @return SubCategoryPage - т.е. остаемся на этой странице
     */
    public SubCategoryPage checkItemNumberOnPage(int itemNumber) {
        if (listItemOnPage.size() > itemNumber) {
            Assert.fail("Товаров на странице отображено больше чем'" + itemNumber + "'");
        }
        return this;
    }

    /**
     * Функция поиска первого товара
     *
     * @return SubCategoryPage - т.е. остаемся на этой странице
     */
    public SubCategoryPage searchFirstItem() {
        WebElement firstElementBefore = listItemTitleOnPage.get(0);
        String searchTextBefore = firstElementBefore.getText().trim();

        waitUtilElementToBeClickable(searchInput).click();
        searchInput.clear();
        searchInput.sendKeys(searchTextBefore);
        searchInput.sendKeys(Keys.ENTER);

        waitUtilElementToBeVisible(oneItemInTitle);
        checkItemNumberOnPage(1);

        WebElement firstElementAfter = listItemTitleOnPage.get(0);
        String searchTextAfter = firstElementAfter.getText().trim();

        if (!searchTextBefore.equals(searchTextAfter)) {
            Assert.fail("Поиск товара выполнен неверно");
        }
        return this;
    }

}
