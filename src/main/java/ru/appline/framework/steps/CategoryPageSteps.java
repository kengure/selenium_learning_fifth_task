package ru.appline.framework.steps;

import io.cucumber.java.ru.И;
import ru.appline.framework.managers.PageManager;

public class CategoryPageSteps {
    private final PageManager pageManager = PageManager.getPageManager();

    @И("^Проверка открытия страницы категории \"(.+)\"$")
    public void checkOpenCategoryPage(String nameCategory) {
        pageManager.getCategoryPage().checkOpenCategoryPage(nameCategory);
    }

    @И("^Выбираем подкатегорию \"(.+)\" в главном меню$")
    public void selectSubCategoryItem(String nameSubCategoryItem) {
        pageManager.getCategoryPage().selectSubCategoryItem(nameSubCategoryItem);
    }
}
