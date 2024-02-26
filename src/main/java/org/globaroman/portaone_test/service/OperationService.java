package org.globaroman.portaone_test.service;

import org.globaroman.portaone_test.dto.ResponseOperationDto;

public interface OperationService {

    ResponseOperationDto getResult();
    ResponseOperationDto getResult(String path);
}
