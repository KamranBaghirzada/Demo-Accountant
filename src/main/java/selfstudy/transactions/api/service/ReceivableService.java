package selfstudy.transactions.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import selfstudy.transactions.api.dto.request.ReceivableRequest;
import selfstudy.transactions.api.dto.response.PayableResponse;
import selfstudy.transactions.api.dto.response.ReceivableResponse;

import java.util.List;
@Service
public interface ReceivableService {

    Page<ReceivableResponse> getAllReceivablesWithPaginationAndSort(Integer page, Sort.Direction sort);

    Page<PayableResponse> getAllPayablesWithPaginationAndSort(Integer page, Sort.Direction sort);

    List<ReceivableResponse> searchReceivables(ReceivableRequest request);
}
