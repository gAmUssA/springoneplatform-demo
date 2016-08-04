package com.hazelcast.springone;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.query.Predicates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class NaiveSpeakerRepository {

    private HazelcastInstance hazelcastInstance;
    private IMap<Long, Speaker> speakers;

    @Autowired
    public void setHazelcastInstance(HazelcastInstance instance) {
        this.hazelcastInstance = instance;
        this.speakers = instance.getMap("speakers");

    }

    public Speaker findOne(Long key) {
        return speakers.get(key);
    }

    public List<Speaker> findByName(String name) {
        final Collection<Speaker> values = speakers.values(Predicates.equal("name", name));
        return new ArrayList(values);
    }

    public List<Speaker> getAllSpeakers() {
        return new ArrayList(speakers.values());
    }


    public long count() {
        return speakers.size();
    }

    public void deleteAll() {
        speakers.clear();
    }
}
