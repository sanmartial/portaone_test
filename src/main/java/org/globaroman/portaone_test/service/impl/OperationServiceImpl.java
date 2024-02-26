package org.globaroman.portaone_test.service.impl;

import lombok.RequiredArgsConstructor;
import org.globaroman.portaone_test.dto.ResponseOperationDto;
import org.globaroman.portaone_test.service.IOService;
import org.globaroman.portaone_test.service.OperationService;
import org.springframework.stereotype.Service;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService {

    private final IOService ioService;
    private final String PATH_FILE = "/app/file.txt";

    @Override
    public ResponseOperationDto getResult() {

        ResponseOperationDto responseDto = new ResponseOperationDto();
        try {
            List<Long> list = ioService.uploadValues(PATH_FILE);
            if (list.isEmpty()) {
                return responseDto;
            }
            responseDto.setMaxValue(maxValue(list));
            responseDto.setMinValue(minValue(list));
            responseDto.setAverageValue(averageValue(list));
            responseDto.setLargeSeqIncrease(largeSequenceValueIncreases(list));
            responseDto.setLargeSeqDecrease(largeSequenceValueDecrease(list));
            responseDto.setMediana(medianaValue(list));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        return responseDto;
    }


    public ResponseOperationDto getResult(String path) {

        ResponseOperationDto responseDto = new ResponseOperationDto();
        try {
            List<Long> list = ioService.uploadValues(path);
            if (list.isEmpty()) {
                return responseDto;
            }
            responseDto.setMaxValue(maxValue(list));
            responseDto.setMinValue(minValue(list));
            responseDto.setAverageValue(averageValue(list));
            responseDto.setLargeSeqIncrease(largeSequenceValueIncreases(list));
            responseDto.setLargeSeqDecrease(largeSequenceValueDecrease(list));
            responseDto.setMediana(medianaValue(list));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


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


    public Long minValue(List<Long> list) {
        Long min = list.get(0);
        for (Long value : list) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }


    public Double medianaValue(List<Long> list) {
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


    public Double averageValue(List<Long> list) {
        double sum = 0L;
        double count = 0L;

        for (Long value : list) {
            sum += value;
            count++;
        }
        return sum / count;
    }


    public Long largeSequenceValueIncreases(List<Long> list) {

        Long prev = list.get(0);
        Long max = 1L;
        Long count = 1L;
        for (Long value : list) {
            Long current = value;
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


    public Long largeSequenceValueDecrease(List<Long> list) {
        Long prev = list.get(0);
        Long max = 1L;
        Long count = 1L;
        for (Long value : list) {
            Long current = value;
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
