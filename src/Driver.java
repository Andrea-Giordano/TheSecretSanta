import java.util.List;

public class Driver {

    public static void main(String[] args) {

        final Credentials credentials = new Credentials(args[0], args[1]);

        List<Participant> participants = ParticipantsConfig.initParticipants();
        ConditionsGroup conditions = new ConditionsGroup();

        for (int i=0; i<participants.size(); ++i) {
            if (i==0 || i<participants.size()-1) {
                NotificationSender.sendNotification(participants.get(i), participants.get(i+1), conditions.pickOne(), credentials);
            } else {
                NotificationSender.sendNotification(participants.get(i), participants.get(0), conditions.pickOne(), credentials);
            }
        }
    }
}
