package org.globaroman.portaone_test.service.impl;

import org.globaroman.portaone_test.service.InputService;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class InputServiceImpl implements InputService {
    @Override
    public List<Long> uploadValues(String path) {
        List<Long> list = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(path))) {

            String line = null;
            while ((line = read.readLine()) != null) {
                list.add(Long.parseLong(line));
            }

        } catch (IOException e) {
            throw new RuntimeException("Can not read file by path:" + path, e);
        }
        return list;
    }
}
