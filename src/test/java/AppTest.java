import com.hazelcast.springone.AppConfig;
import com.hazelcast.springone.NaiveSpeakerRepository;
import com.hazelcast.springone.Speaker;
import com.hazelcast.springone.Talk;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * TODO
 *
 * @author Viktor Gamov on 7/25/16.
 *         Twitter: @gamussa
 * @since 0.0.1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@DirtiesContext
public class AppTest{

    private static final Logger LOG = LoggerFactory.getLogger(AppTest.class);

    @Autowired
    //SpeakerRepository speakerRepository;
    NaiveSpeakerRepository speakerRepository;

    @Test
    public void testHazelcast() {

        LOG.info("********* COUNT ***********");
        LOG.info("count = " + speakerRepository.count());
        Iterable<Speaker> allSpeakers = speakerRepository.getAllSpeakers();
        for (Speaker speaker : allSpeakers) {
            LOG.info(speaker.getName());
        }
        LOG.info("********* FIND Josh Longs as a Speaker ***********");
        Speaker speaker = speakerRepository.findByName("Josh Long").get(0);
        Set<Talk> talks = speaker.getTalks();
        for (Talk talk : talks) {
            LOG.info("talk = " + talk);
        }

        /*LOG.info("********* ALL SPEAKERS WITH oo ***********");
        List<Speaker> speakers = speakerRepository.findByNameLike("%oo%");
        for (Speaker speaker1 : speakers) {
            LOG.info(speaker1.getName());
        }*/
    }

}
