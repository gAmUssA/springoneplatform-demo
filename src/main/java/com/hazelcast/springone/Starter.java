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

    public static void populateSpeakers(IMap<Long, Speaker> speakers) {
        Speaker joshLong = new Speaker(1L, "Josh Long");
        joshLong.addTalk(new Talk("Keynote", time("9:30")));
        joshLong.addTalk(new Talk("Cloud Native Java", time("14:00")));
        speakers.set(joshLong.getId(), joshLong);

        Speaker danveloper = new Speaker(2L, "Dan Woods");
        danveloper.addTalk(new Talk("High Performance Microservices with Ratpack and Spring Boot", time("11:00")));
        speakers.set(danveloper.getId(), danveloper);

        Speaker oliverG = new Speaker(3L, "Oliver Gierke");
        oliverG.addTalk(new Talk("DDD & REST - Domain Driven APIs for the Web", time("17:00")));
        oliverG.addTalk(new Talk("Advanced Spring Data REST", time("11:10")));
        speakers.set(oliverG.getId(), oliverG);
    }

    private static Date time(String time) {
        String[] split = time.split(":");
        int hours = Integer.parseInt(split[0]);
        int minutes = Integer.parseInt(split[1]);
        return from(of(hours, minutes).atDate(now()).atZone(systemDefault()).toInstant());
    }
}
