import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO
 *
 * @author Viktor Gamov on 7/25/16.
 *         Twitter: @gamussa
 * @since 0.0.1
 */
public class Talk implements Serializable {
    @Id
    //    @GeneratedValue
    private Long talkId;

    private Date when;

    private String title;

    public Talk() {
    }

    public Talk(String title, Date date) {
        this.title = title;
        this.when = date;
    }

    @Override
    public String toString() {
        return title;
    }

    public Date getWhen() {
        return when;
    }
}
