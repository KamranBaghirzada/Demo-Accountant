package selfstudy.transactions.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import selfstudy.transactions.api.dto.response.ReceivableResponse;
import selfstudy.transactions.api.model.Receivable;

@Mapper(componentModel = "spring")
public interface ReceivableMapper {

    @Mapping(target = "balance", source = "balance")
    ReceivableResponse receivableResponse(Receivable receivable);
}
