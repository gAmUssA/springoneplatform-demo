package com.hazelcast.springone;

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
        System.setProperty("hazelcast.logging.type", "slf4j");
        final HazelcastInstance hazelcastInstance = newHazelcastInstance();
        final IMap<Long, Speaker> speakers = hazelcastInstance.getMap("speakers");
        populateSpeakers(speakers);
    }

    private static void populateSpeakers(IMap<Long, Speaker> speakers) {
        Speaker jeka = new Speaker(1L, "Evgeny Borisov");
        jeka.addTalk(new Talk("Spring The Ripper", time("12:30")));
        jeka.addTalk(new Talk("Spring Data", time("17:30")));
        speakers.set(jeka.getId(), jeka);


        Speaker nikolay = new Speaker(2L, "Nikolay Alimenkov");
        nikolay.addTalk(new Talk("CD JEE7", time("18:00")));
        speakers.set(nikolay.getId(), nikolay);

        Speaker baruch = new Speaker(3L, "Baruch Sadogursky");
        baruch.addTalk(new Talk("AST Groovy", time("12:00")));
        baruch.addTalk(new Talk("Making Spring Groovy", time("09:00")));
        speakers.set(baruch.getId(), baruch);
    }

    private static Date time(String time) {
        String[] split = time.split(":");
        int hours = Integer.parseInt(split[0]);
        int minutes = Integer.parseInt(split[1]);
        return from(of(hours, minutes).atDate(now()).atZone(systemDefault()).toInstant());
    }
}
