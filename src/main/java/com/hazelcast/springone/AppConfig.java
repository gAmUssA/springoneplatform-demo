package com.hazelcast.springone;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.hazelcast.HazelcastKeyValueAdapter;
import org.springframework.data.hazelcast.repository.config.EnableHazelcastRepositories;
import org.springframework.data.keyvalue.core.KeyValueOperations;
import org.springframework.data.keyvalue.core.KeyValueTemplate;

import static com.hazelcast.client.HazelcastClient.newHazelcastClient;

/**
 * Spring Application Config
 *
 * @author Viktor Gamov on 7/25/16.
 *         Twitter: @gamussa
 * @since 0.0.1
 */
@Configuration
@EnableHazelcastRepositories
@ComponentScan
public class AppConfig {

    @Bean
    HazelcastInstance hazelcastInstance() {
        System.setProperty("hazelcast.logging.type", "slf4j");
        return newHazelcastClient();
    }

    @Bean
    public KeyValueOperations keyValueTemplate() {
        return new KeyValueTemplate(new HazelcastKeyValueAdapter(hazelcastInstance()));
    }

    @Bean
    public HazelcastKeyValueAdapter hazelcastKeyValueAdapter(HazelcastInstance hazelcastInstance) {
        return new HazelcastKeyValueAdapter(hazelcastInstance);
    }

}
