package ru.appline.framework.managers;

import ru.appline.framework.pages.HomePage;
import ru.appline.framework.pages.CategoryPage;
import ru.appline.framework.pages.SubCategoryPage;

/**
 * @author Arkadiy_Alaverdyan
 *         Класс для управления страничками
 */
public class PageManager {

    /**
     * Менеджер страничек
     */
    private static PageManager pageManager;

    /**
     * Домашняя страничка
     */
    private HomePage homePage;

    /**
     * Страничка категорий
     */
    private CategoryPage categoryPage;

    /**
     * Страничка подкатегорий
     */
    private SubCategoryPage subCategoryPage;

    /**
     * Конструктор специально был объявлен как private (singleton паттерн)
     *
     * @see PageManager#getPageManager()
     */
    private PageManager() {
    }

    /**
     * Ленивая инициализация PageManager
     *
     * @return PageManager
     */
    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    /**
     * Ленивая инициализация {@link HomePage}
     *
     * @return HomePage
     */
    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    /**
     * Ленивая инициализация {@link CategoryPage}
     *
     * @return CategoryPage
     */
    public CategoryPage getCategoryPage() {
        if (categoryPage == null) {
            categoryPage = new CategoryPage();
        }
        return categoryPage;
    }

    /**
     * Ленивая инициализация {@link SubCategoryPage}
     *
     * @return SubCategoryPage
     */
    public SubCategoryPage getSubCategoryPage() {
        if (subCategoryPage == null) {
            subCategoryPage = new SubCategoryPage();
        }
        return subCategoryPage;
    }
}
