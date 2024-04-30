package ru.appline.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Страница выбора категорий товаров
 */
public class CategoryPage extends BasePage {

    @FindBy(xpath = "//h1[contains(@class, 'PageTitle_title')]")
    private WebElement categoryPageTitle;

    @FindBy(xpath = "//p[contains(@class, 'CardCategory_title')]")
    private List<WebElement> listSubCategory;

    /**
     * Функция проверки открытия страницы категории
     *
     * @return CategoryPage - т.е. остаемся на этой странице
     */
    public CategoryPage checkOpenCategoryPage(String nameCategory) {
        waitUtilElementToBeVisible(categoryPageTitle);
        if (!categoryPageTitle.getText().equals(nameCategory)) {
            Assert.fail("Категория '" + nameCategory + "' не была открыта");
        }
        return this;
    }

    /**
     * Функция клика на любой подпункт каталога
     *
     * @param nameSubCategoryItem - наименование подменю
     * @return SubCategoryPage - т.е. переходим на страницу SubCategoryPage
     */
    public SubCategoryPage selectSubCategoryItem(String nameSubCategoryItem) {
        for (WebElement menuItem : listSubCategory) {
            if (menuItem.getText().trim().contains(nameSubCategoryItem)) {
                waitUtilElementToBeClickable(menuItem).click();
                return pageManager.getSubCategoryPage().checkOpenSubCategoryPage(nameSubCategoryItem);
            }
        }
        Assert.fail("Меню '" + nameSubCategoryItem + "' не было найдено на стартовой странице!");
        return pageManager.getSubCategoryPage();
    }
}
