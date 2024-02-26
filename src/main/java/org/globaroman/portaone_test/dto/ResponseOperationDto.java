package org.globaroman.portaone_test.dto;

import lombok.Data;

@Data
public class ResponseOperationDto {
    private Long maxValue;
    private Long minValue;
    private Double mediana;
    private Double averageValue;
    private Long largeSeqIncrease;
    private Long largeSeqDecrease;
}
