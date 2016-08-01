import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import java.util.Date;

import static com.hazelcast.core.Hazelcast.newHazelcastInstance;
import static java.time.LocalDate.now;
import static java.time.LocalTime.of;
import static java.time.ZoneId.systemDefault;
import static java.util.Date.from;

/**
 * TODO
 *
 * @author Viktor Gamov on 7/25/16.
 *         Twitter: @gamussa
 * @since 0.0.1
 */
public class Starter {
    public static void main(String[] args) {
        System.setProperty("hazelcast.logging.type","slf4j");
        final HazelcastInstance hazelcastInstance = newHazelcastInstance();
        final IMap<Long, Speaker> speakers = hazelcastInstance.getMap("speakers");
        populateSpeakers(speakers);
    }

    private static void populateSpeakers(IMap<Long, Speaker> speakers) {
        Speaker jeka = new Speaker("Evgeny Borisov");
        jeka.addTalk(new Talk("Spring The Ripper", time("12:30")));
        jeka.addTalk(new Talk("Spring Data", time("17:30")));


        Speaker nikolay = new Speaker("Nikolay Alimenkov");
        nikolay.addTalk(new Talk("CD JEE7", time("18:00")));

        Speaker baruch = new Speaker("Baruch Sadogursky");
        baruch.addTalk(new Talk("AST Groovy", time("12:00")));
        baruch.addTalk(new Talk("Making Spring Groovy", time("09:00")));
    }

    private static Date time(String time) {
        String[] split = time.split(":");
        int hours = Integer.parseInt(split[0]);
        int minutes = Integer.parseInt(split[1]);
        return from(of(hours, minutes).atDate(now()).atZone(systemDefault()).toInstant());
    }
}
