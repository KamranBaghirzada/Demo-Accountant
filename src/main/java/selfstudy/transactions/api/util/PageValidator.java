package selfstudy.transactions.api.util;

public class PageValidator {

    public static Integer pageNumber(Integer page) {
        return page == null || page <= 0 ? 1 : page;
    }
}
