package com.andreagiordano.thesecretsanta.model;

import com.andreagiordano.thesecretsanta.config.ConditionsConfig;

import java.util.List;
import java.util.Random;

public class ConditionsGroup {
    List<String> conditions;

    public ConditionsGroup() {
        this.conditions = ConditionsConfig.initConditions();
    }

    public String pickOne() {
        Random rnd = new Random();
        if (conditions.size() == 0) {
            conditions = ConditionsConfig.initConditions();
        }
        return conditions.remove(rnd.nextInt(conditions.size()));
    }
}
