package selfstudy.transactions.api.service.impl;

import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import selfstudy.transactions.api.dto.request.ReceivableRequest;
import selfstudy.transactions.api.dto.response.PayableResponse;
import selfstudy.transactions.api.dto.response.ReceivableResponse;
import selfstudy.transactions.api.mapper.PayableMapper;
import selfstudy.transactions.api.mapper.ReceivableMapper;
import selfstudy.transactions.api.model.Payable;
import selfstudy.transactions.api.model.Receivable;
import selfstudy.transactions.api.repository.PayableRepository;
import selfstudy.transactions.api.repository.ReceivableRepository;
import selfstudy.transactions.api.service.ReceivableService;
import selfstudy.transactions.api.util.PageValidator;
import selfstudy.transactions.api.util.SortValidator;

import java.util.List;

@Service
public class ReceivableServiceImpl implements ReceivableService {

    public static final int DEFAULT_PAGE_SIZE = 10;
    private final ReceivableRepository receivableRepository;
    private final PayableRepository payableRepository;
    private final ReceivableMapper receivableMapper;
    private final PayableMapper payableMapper;
    private final EntityManager entityManager;
//    private final ReceivableSearchRepository receivableRepositoryImpl;

    public ReceivableServiceImpl(ReceivableRepository receivableRepository, PayableRepository payableRepository, ReceivableMapper receivableMapper, PayableMapper payableMapper, EntityManager entityManager) {
        this.receivableRepository = receivableRepository;
        this.payableRepository = payableRepository;
        this.receivableMapper = receivableMapper;
        this.payableMapper = payableMapper;
        this.entityManager = entityManager;
//        this.receivableRepositoryImpl = receivableRepositoryImpl;
    }

    @Override
    public Page<ReceivableResponse> getAllReceivablesWithPaginationAndSort(Integer page, Sort.Direction sort) {
        Integer pageNumber = PageValidator.pageNumber(page);
        Sort.Direction direction = SortValidator.sortDirection(sort);
        Sort.Order order = Sort.Order.by("id").with(direction);
        Page<Receivable> receivablePage =
                receivableRepository.findAll(PageRequest.of(pageNumber - 1, DEFAULT_PAGE_SIZE, Sort.by(order)));
        List<ReceivableResponse> receivableResponses
                = receivablePage.getContent().stream().map(receivableMapper::receivableResponse)
                .toList();
        return new PageImpl<>(receivableResponses, receivablePage.getPageable(), receivablePage.getTotalElements());
    }

    @Override
    public Page<PayableResponse> getAllPayablesWithPaginationAndSort(Integer page, Sort.Direction sort) {
        Integer pageNumber = PageValidator.pageNumber(page);
        Sort.Direction direction = SortValidator.sortDirection(sort);
        Page<Payable> payablePage =
                payableRepository.findAll(PageRequest.of(pageNumber - 1, DEFAULT_PAGE_SIZE, direction));
        List<PayableResponse> payableResponses
                = payablePage.getContent().stream().map(payableMapper::payableResponse)
                .toList();
        return new PageImpl<>(payableResponses, payablePage.getPageable(), payablePage.getTotalElements());
    }

    @Override
    public List<ReceivableResponse> searchReceivables(ReceivableRequest request) {
        List<Receivable> receivables = receivableRepository.findReceivableWithSearch(request, entityManager);
        return receivables.stream().map(receivableMapper::receivableResponse).toList();
    }
}
