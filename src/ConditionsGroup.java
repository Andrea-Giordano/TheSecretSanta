import java.util.List;
import java.util.Random;

public class ConditionsGroup {
    List<String> originalConditions;
    List<String> conditions;

    public ConditionsGroup() {
        this.originalConditions = ConditionsConfig.initConditions();
        this.conditions = ConditionsConfig.initConditions();
    }

    public String pickOne() {
        Random rnd = new Random();
        if (conditions.size() == 1) {
            return originalConditions.get(rnd.nextInt(originalConditions.size()));
        }
        return conditions.remove(rnd.nextInt(conditions.size()));
    }
}
