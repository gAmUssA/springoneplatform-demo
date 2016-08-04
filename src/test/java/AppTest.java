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
 * Simple Repositories Test
 *
 * @author Viktor Gamov on 7/25/16.
 *         Twitter: @gamussa
 * @since 0.0.1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@DirtiesContext
public class AppTest {

    private static final Logger LOG = LoggerFactory.getLogger(AppTest.class);

    @Autowired
    //TrueSpeakerRepository speakerRepository;
    NaiveSpeakerRepository speakerRepository;

    @Test
    public void testCount() {
        LOG.info("********* COUNT ***********");
        LOG.info("count = " + speakerRepository.count());
        Iterable<Speaker> allSpeakers = speakerRepository.findAll();
        for (Speaker speaker : allSpeakers) {
            LOG.info(speaker.getName());
        }
    }

    @Test
    public void testByName() {
        LOG.info("********* FIND Josh Longs as a Speaker ***********");
        Speaker speaker = speakerRepository.findByName("Josh Long").get(0);
        Set<Talk> talks = speaker.getTalks();
        for (Talk talk : talks) {
            LOG.info("talk = " + talk);
        }

    }

    @Test
    public void testLike() {
        /*LOG.info("********* ALL SPEAKERS WITH oo ***********");
        List<Speaker> speakers = speakerRepository.findПожалуйстаByNameLike("%oo%");
        for (Speaker speaker1 : speakers) {
            LOG.info(speaker1.getName());
            if (speaker1.getName().contains("Dan")){
                LOG.info("#unfollowdanveloper");
            }
        }*/
    }

}
