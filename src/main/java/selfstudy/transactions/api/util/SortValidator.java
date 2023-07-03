package selfstudy.transactions.api.util;

import org.springframework.data.domain.Sort;

public class SortValidator {

    public static Sort.Direction sortDirection(Sort.Direction sort) {
        return sort != null ? sort : Sort.Direction.ASC;
    }
}
