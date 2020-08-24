package com.sapient.mowit.input;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CommandFileReader {

    final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private static final String FILE_PATH = "tondeuse.txt";

    List<String> readInputFile (){
        List<String> list = new ArrayList<String>();
        try {
            Resource resource = new ClassPathResource(FILE_PATH);
            InputStream inputStream = resource.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()) {
                String line = reader.readLine();
                list.add(line);
            }
        }catch (FileNotFoundException e) {
            LOGGER.error("File not found", e);
        } catch (IOException e) {
            LOGGER.error("Failed to load file", e);
        }
        return list;
    }

}
