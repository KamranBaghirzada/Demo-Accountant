package selfstudy.transactions.api.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import selfstudy.transactions.api.dto.response.PayableResponse;
import selfstudy.transactions.api.model.Payable;

@Mapper(componentModel = "spring")
public interface PayableMapper {

    @Mapping(target = "balance",source = "balance")
    PayableResponse payableResponse(Payable payable);
}
