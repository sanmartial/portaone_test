package org.globaroman.portaone_test.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.globaroman.portaone_test.dto.RequestOperationDto;
import org.globaroman.portaone_test.dto.ResponseOperationDto;
import org.globaroman.portaone_test.service.OperationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Operation", description = "Operations with value")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/operations")
public class OperationController {
    private final OperationService operationService;

    @GetMapping
    @Operation(summary = "You can get all the values that are in the provided file")
    public ResponseOperationDto getResult() {
        return operationService.getResult();
    }

    @PostMapping
    @Operation(summary = "You can get all the values by typing a link to your file")
    public ResponseOperationDto getResultP(@RequestBody RequestOperationDto requestOperationDto) {
        return operationService.getResult(requestOperationDto.getPath());
    }
}
