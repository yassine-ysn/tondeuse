package com.sapient.mowit.input;

import com.sapient.mowit.constructor.MowerConstructor;
import com.sapient.mowit.model.Mower;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MainComponent implements CommandLineRunner {

    final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private int xmax, ymax;

    public void setXmax(int xmax) {
        this.xmax = xmax;
    }

    public void setYmax(int ymax) {
        this.ymax = ymax;
    }

    @Override
    public void run(String... args) throws Exception {
        List<String> lines = new CommandFileReader().readInputFile()
                                    .stream()
                                    .map( line -> line.replaceAll("\\s", ""))
                                    .collect(Collectors.toList());
        LOGGER.info("File content : {}",lines.toString());
        setCamp(lines.get(0).toCharArray());
        LOGGER.info("Camp created, X={}, Y={}",xmax, ymax);
        for (int i = 1; i < lines.size(); i+=2) {
            //construct a mower from the line i
            Mower m = new MowerConstructor().contructMower(lines.get(i).toCharArray());
            LOGGER.info("Mower created : {}",m);
            //execute the command from the line i+1 : a ne pas depasser xmax et ymax
            m.mow(lines.get(i+1).toCharArray(), xmax, ymax);
            //print x, y and direction
            LOGGER.info("Mower has finished at position X={}, Y={}, Direction={}", m.getX(), m.getY(), m.getDirection().getSymbol());
        }
    }

    private void setCamp(char[] camp) throws Exception{
        if(camp.length != 2) throw new Exception("Failed to construct the camp");
        xmax = Character.getNumericValue(camp[0]);
        ymax = Character.getNumericValue(camp[1]);
    }
}
