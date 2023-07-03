package selfstudy.transactions.api.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import selfstudy.transactions.api.dto.request.ReceivableRequest;
import selfstudy.transactions.api.dto.response.PayableResponse;
import selfstudy.transactions.api.dto.response.ReceivableResponse;
import selfstudy.transactions.api.service.ReceivableService;

import java.util.List;


@RestController
@RequestMapping("api/accounts")
public class AccountsController {

    private final ReceivableService receivableService;

    public AccountsController(ReceivableService receivableService) {
        this.receivableService = receivableService;
    }

    @GetMapping("/receivables")
    public ResponseEntity<Page<ReceivableResponse>> getAllReceivables(@RequestParam(required = false) Integer page,
                                                                      Sort.Direction sort) {
        return ResponseEntity.ok(receivableService.getAllReceivablesWithPaginationAndSort(page, sort));
    }

    @GetMapping("/payables")
    public ResponseEntity<Page<PayableResponse>> getAllPayables(@RequestParam(required = false) Integer page,
                                                                Sort.Direction sort) {
        return ResponseEntity.ok(receivableService.getAllPayablesWithPaginationAndSort(page, sort));
    }

    @GetMapping("/receivables-search")
    public ResponseEntity<List<ReceivableResponse>> searchReceivables( ReceivableRequest request) {
        return ResponseEntity.ok(receivableService.searchReceivables(request));
    }
}
