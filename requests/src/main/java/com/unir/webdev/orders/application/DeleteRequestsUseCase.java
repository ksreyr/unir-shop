package com.unir.webdev.orders.application;

import com.unir.webdev.orders.domain.repository.RequestRepository;
import com.unir.webdev.orders.domain.response.Result;
import com.unir.webdev.orders.infrastructur.events.ChangeAvailabilityEvent;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DeleteRequestsUseCase {
    RequestRepository requestRepository;
    ChangeAvailabilityEvent changeAvailabilityEvent;
    public Result<String, String> deleteRequest(UUID requestID){
        if(requestRepository.unknownRequest(requestID) || requestRepository.isEmptyRequest(requestID)){
            return Result.error("Not Validdata");
        }
        var booksID = requestRepository.getBookIDsOfRequest(requestID);
        requestRepository.deleteOrder(requestID);
        changeAvailabilityEvent.sendEventChangeAvailability(booksID);
        return Result.success("Deleted Request");
    }
}
