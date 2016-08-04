package com.hazelcast.springone;

import static com.hazelcast.core.Hazelcast.newHazelcastInstance;

/**
 * Created by vikgamov on 8/4/16.
 */
public class Member {
    public static void main(String[] args) {
        System.setProperty("hazelcast.logging.type", "slf4j");
        newHazelcastInstance();
    }
}
