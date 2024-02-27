package org.globaroman.portaone_test.service.impl;

import lombok.RequiredArgsConstructor;
import org.globaroman.portaone_test.dto.ResponseOperationDto;
import org.globaroman.portaone_test.service.InputService;
import org.globaroman.portaone_test.service.OperationService;
import org.springframework.stereotype.Service;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService {

    private final InputService inputService;

    @Override
    public ResponseOperationDto getResult() {
        String PATH_FILE = "10m.txt";
        return getResponseOperationDto(PATH_FILE);
    }

    @Override
    public ResponseOperationDto getResult(String path) {
        return getResponseOperationDto(path);
    }

    private ResponseOperationDto getResponseOperationDto(String path) {
        ResponseOperationDto responseDto = new ResponseOperationDto();
        try {
            List<Long> list = inputService.uploadValues(path);
            if (list.isEmpty()) {
                return responseDto;
            }
            responseDto = getResponseDtoWithValues(list);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return responseDto;
    }

    private ResponseOperationDto getResponseDtoWithValues(List<Long> list) {
        ResponseOperationDto responseDto = new ResponseOperationDto();
        responseDto.setMaxValue(maxValue(list));
        responseDto.setMinValue(minValue(list));
        responseDto.setAverageValue(averageValue(list));
        responseDto.setLargeSeqIncrease(largeSequenceValueIncreases(list));
        responseDto.setLargeSeqDecrease(largeSequenceValueDecrease(list));
        responseDto.setMediana(medianaValue(list));
        return responseDto;
    }

    private Long maxValue(List<Long> list) {
        Long max = 0L;
        for (Long value : list) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    private Long minValue(List<Long> list) {
        Long min = list.get(0);
        for (Long value : list) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    private Double medianaValue(List<Long> list) {
        Collections.sort(list);
        int size = list.size();

        if (size % 2 != 0) {
            return Double.valueOf(list.get(size / 2));
        } else {
            Long mid1 = list.get(size / 2 - 1);
            Long mid2 = list.get(size / 2);
            return (double) ((mid1 + mid2) / 2);
        }
    }

    private Double averageValue(List<Long> list) {
        double sum = 0L;
        double count = 0L;

        for (Long value : list) {
            sum += value;
            count++;
        }
        return sum / count;
    }

    private Long largeSequenceValueIncreases(List<Long> list) {
        long prev = list.get(0);
        long max = 1L;
        long count = 1L;
        for (Long value : list) {
            long current = value;
            if (current > prev) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 1L;
            }
            prev = current;
        }
        return max;
    }

    private Long largeSequenceValueDecrease(List<Long> list) {
        long prev = list.get(0);
        long max = 1L;
        long count = 1L;
        for (Long value : list) {
            long current = value;
            if (current < prev) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 1L;
            }
            prev = current;
        }
        return max;
    }
}
