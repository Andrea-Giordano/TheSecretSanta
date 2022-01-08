import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class ParticipantsConfig {

    public static List<Participant> initParticipants() {
        List<Participant> participants = new ArrayList<>();

        try {
            participants = Files.lines(Paths.get("resources" + File.separator + "participants"))
                    .map(p -> p.split(";"))
                    .map(p -> new Participant(p[0], p[1]))
                    .collect(Collectors.toList());

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Collections.shuffle(participants);

        return participants;
    }
}
