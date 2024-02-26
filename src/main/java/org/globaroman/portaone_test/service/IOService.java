package org.globaroman.portaone_test.service;

import java.io.FileNotFoundException;
import java.util.List;

public interface IOService {

    List<Long> uploadValues(String path) throws FileNotFoundException;
}
