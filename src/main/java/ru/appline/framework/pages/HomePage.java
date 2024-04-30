package ru.appline.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Домашняя страница
 */
public class HomePage extends BasePage {

    @FindBy(xpath = "//button[span[text()='Каталог']]")
    private WebElement openCatalogBtn;

    @FindBy(xpath = "//div[contains(@class, 'Catalog_content')]")
    private WebElement openedCatalog;

    @FindBy(xpath = "//div[contains(@class, 'Catalog_mainCategoryName')]")
    private List<WebElement> listMainCategory;

    /**
     * Кликнуть на кнопку 'Каталог' и проверить его открытие
     *
     * @return HomePage - т.е. остаемся на этой странице
     */
    public HomePage openCatalog() {
        waitUtilElementToBeClickable(openCatalogBtn).click();
        waitUtilElementToBeVisible(openedCatalog);
        return this;
    }

    /**
     * Функция клика на любой пункт каталога
     *
     * @param nameCategoryItem - наименование меню
     * @return CategoryPage - т.е. переходим на страницу CategoryPage
     */
    public CategoryPage selectCategoryItem(String nameCategoryItem) {
        for (WebElement menuItem : listMainCategory) {
            if (menuItem.getText().trim().equalsIgnoreCase(nameCategoryItem)) {
                waitUtilElementToBeClickable(menuItem).click();
                return pageManager.getCategoryPage().checkOpenCategoryPage(nameCategoryItem);
            }
        }
        Assert.fail("Меню '" + nameCategoryItem + "' не было найдено на стартовой странице!");
        return pageManager.getCategoryPage();
    }
}
