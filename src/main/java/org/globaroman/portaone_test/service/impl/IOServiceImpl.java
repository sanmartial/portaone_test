package org.globaroman.portaone_test.service.impl;

import org.globaroman.portaone_test.service.IOService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class IOServiceImpl implements IOService {
    @Override
    public List<Long> uploadValues(String path) throws FileNotFoundException {
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
