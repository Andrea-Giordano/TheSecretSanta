package com.andreagiordano.thesecretsanta.config;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class ConditionsConfig {

    public static List<String> initConditions() {
        List<String> conditions = new ArrayList<>();

        try {
            conditions = Files.lines(Paths.get("resources" + File.separator + "conditions"))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Collections.shuffle(conditions);

        return conditions;
    }
}
