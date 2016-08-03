package com.hazelcast.springone;

import org.springframework.data.keyvalue.repository.KeyValueRepository;

import java.util.List;

/**
 * Speaker's Repository
 *
 * @author Viktor Gamov on 7/25/16.
 *         Twitter: @gamussa
 * @since 0.0.1
 */
public interface SpeakerRepository extends KeyValueRepository<Speaker, Long> {

    public List<Speaker> findByName(String s);

    public List<Speaker> findByNameLike(String s);
}
