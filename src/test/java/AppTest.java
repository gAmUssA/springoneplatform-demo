import com.hazelcast.springone.AppConfig;
import com.hazelcast.springone.Speaker;
import com.hazelcast.springone.SpeakerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

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
public class AppTest {

    @Autowired
    SpeakerRepository speakerRepository;

    @Test
    public void testStart(){
        final Iterable<Speaker> all = speakerRepository.findAll();
        System.out.println(all);
    }
}
