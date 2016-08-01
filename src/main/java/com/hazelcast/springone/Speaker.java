import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * TODO
 *
 * @author Viktor Gamov on 7/25/16.
 *         Twitter: @gamussa
 * @since 0.0.1
 */
public class Speaker implements Serializable {
    @Id
    //@GeneratedValue
    private Long speakerId;

    private String name;

    //@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Talk> talks;

    public Speaker() {
    }

    public Speaker(String name) {
        this.name = name;
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

}
