package ru.appline.framework.steps;

import io.cucumber.java.ru.И;
import ru.appline.framework.managers.PageManager;

public class SubCategoryPageSteps {
    private final PageManager pageManager = PageManager.getPageManager();

    @И("^Проверка открытия страницы подкатегории \"(.+)\"$")
    public void checkOpenSubCategoryPage(String nameSubCategory) {
        pageManager.getSubCategoryPage().checkOpenSubCategoryPage(nameSubCategory);
    }

    @И("^Заполнить поле \"(.+)\" значением \"(.+)\" при фильтрации$")
    public void fillFilterField(String nameField, String value) {
        pageManager.getSubCategoryPage().fillFilterField(nameField, value);
    }

    @И("^Проверка загрузки страницы$")
    public void checkLoadingSubCategoryPage() {
        pageManager.getSubCategoryPage().checkLoadingSubCategoryPage();
    }

    @И("^Проверка, что отображаемое количество товаров на странице не более \"(.+)\"$")
    public void checkItemNumberOnPage(Integer itemNumber) {
        pageManager.getSubCategoryPage().checkItemNumberOnPage(itemNumber);
    }

    @И("^Поиск первого товара из списка$")
    public void searchFirstItem() {
        pageManager.getSubCategoryPage().searchFirstItem();
    }
}
