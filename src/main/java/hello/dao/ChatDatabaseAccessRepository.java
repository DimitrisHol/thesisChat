package hello.dao;

import hello.model.Message;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("postgres")
public class ChatDatabaseAccessRepository implements MessageDao {

    private final JdbcTemplate jdbcTemplate;

    public ChatDatabaseAccessRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void newMessage(Message message) {

    }

    @Override
    public List<Message> selectAllMessages() {

//        final String sql = "SELECT * FROM"

        return null;
    }
}
