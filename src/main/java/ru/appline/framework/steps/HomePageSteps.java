package ru.appline.framework.steps;

import io.cucumber.java.ru.И;
import ru.appline.framework.managers.PageManager;

public class HomePageSteps {
    private final PageManager pageManager = PageManager.getPageManager();

    @И("^Открыть каталог$")
    public void openCatalog() {
        pageManager.getHomePage().openCatalog();
    }

    @И("^Выбираем \"(.+)\" в главном меню$")
    public void selectCategoryItem(String nameCategoryItem) {
        pageManager.getHomePage().selectCategoryItem(nameCategoryItem);
    }

}
