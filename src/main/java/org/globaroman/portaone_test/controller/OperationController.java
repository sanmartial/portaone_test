package org.globaroman.portaone_test.controller;

import lombok.RequiredArgsConstructor;
import org.globaroman.portaone_test.dto.RequestOperationDto;
import org.globaroman.portaone_test.dto.ResponseOperationDto;
import org.globaroman.portaone_test.service.OperationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/operations")
public class OperationController {
    private final OperationService operationService;

    @GetMapping
    public ResponseOperationDto getResult() {
        return operationService.getResult();
    }

    @PostMapping
    public ResponseOperationDto getResultP(@RequestBody RequestOperationDto requestOperationDto) {
        return operationService.getResult(requestOperationDto.getPath());
    }
}


