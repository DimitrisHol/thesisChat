package hello.dao;

import hello.model.Message;
import hello.model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@Repository("postgres")
public class ChatDatabaseAccessRepository implements chatDao {

    private final JdbcTemplate jdbcTemplate;

    public ChatDatabaseAccessRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // New message arrived, store it in the database.
    @Override
    public void newMessage(Message message) {

        int author_id = Integer.valueOf(userNameLookUp(message.getAuthorName()).getId());
        String content = message.getMessage();
        Timestamp timestamp = message.getTimeSent();




        final String sql  = "INSERT INTO messages(author_id , content, submitted_at) VALUES (? , ? , ?)";
        jdbcTemplate.update(sql , author_id, content, timestamp);
    }

    // When the a users joins the chat, return the 10 most recent messages back.
    @Override
    public List<Message> selectRecentMessages() {

        final String sql = "select username , content from users inner join messages on users.user_id = messages.author_id;";

        List<Message> messages = jdbcTemplate.query(sql, (resultSet,i) -> {

            String author = resultSet.getString("username");
            String content = resultSet.getString("content");

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//            String timeStamp  = dateFormat.format(resultSet.getTimestamp("submitted_at"));
            Timestamp timeStamp  = resultSet.getTimestamp("submitted_at");

            return new Message(author , content, timeStamp);
        });

        return messages;
    }


    // User logged in , add him to the database if he's not there already, and flag him as active.
    @Override
    public void userLoggedIn(User user) {

        String username = user.getUsername();

        // Test if user is already in the database
        User checkUser = userNameLookUp(username);

        if (checkUser == null){
            final String sql  = "INSERT INTO users(username) VALUES (?)";
            jdbcTemplate.update(sql , user.getUsername());
        }

        // Flag him as active.


    }

    public User userNameLookUp(String username){


        final String sql = "SELECT * FROM users where username = ?";

        try {
            User user =  jdbcTemplate.queryForObject(
                    sql,
                    new Object[]{username},
                    (resultSet, i) ->
                            new User(
                                    String.valueOf(resultSet.getInt("user_id")) ,
                                    resultSet.getString("username")
                            ));
            return user;
        }
        catch (EmptyResultDataAccessException e){
            return null;

        }

    }

    // User logged out, flag him as no longer active.
    @Override
    public void userLoggedOut(User user) {

    }
}




// WHAT WE NEED TO TEST:


// - Timestamps
// - serial
// -
// -
// -
// -
