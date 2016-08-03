package com.hazelcast.springone;

import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Domain Object
 *
 * @KeySpace annotation points to Hazelcast IMap stored speaker objects
 *
 * @author Viktor Gamov on 7/25/16.
 *         Twitter: @gamussa
 * @since 0.0.1
 */
@KeySpace("speakers")
public class Speaker implements Serializable {
    @Id
    private final Long speakerId;

    private final String name;

    private Set<Talk> talks;

    public Speaker(Long speakerId, String name) {
        this.speakerId = speakerId;
        this.name = name;
    }

    public Speaker(String name) {
        this.name = name;
        speakerId = null;
    }

    public void addTalk(Talk talk) {
        if (talks == null)
            talks = new HashSet<Talk>();
        talks.add(talk);
    }

    public String getName() {
        return name;
    }

    public Set<Talk> getTalks() {
        return talks;
    }

    public Long getId() {
        return this.speakerId;
    }
}
