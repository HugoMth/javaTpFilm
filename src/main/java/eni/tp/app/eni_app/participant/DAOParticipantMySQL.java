package eni.tp.app.eni_app.participant;

import eni.tp.app.eni_app.participant.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Profile("mysql")
@Component
public class DAOParticipantMySQL implements IDAOParticipant {

    @Autowired
    JdbcTemplate jdbcTemplate;

    static final RowMapper<Participant> PARTICIPANT_ROW_MAPPER = new RowMapper<Participant>() {
        @Override
        public Participant mapRow(ResultSet rs, int rowNum) throws SQLException {
            Participant participant = new Participant();

            participant.setId(rs.getLong("id"));
            participant.setNom(rs.getString("nom"));
            participant.setPrenom(rs.getString("prenom"));
            return participant;
        }

        ;
    };

    public List<Participant> getParticipants() {
        return jdbcTemplate.query("SELECT * FROM participant", PARTICIPANT_ROW_MAPPER);
    }

    ;

    public Participant getParticipantById(Long id) {
        List<Participant> participants = jdbcTemplate.query("SELECT * FROM participant WHERE id = ?", PARTICIPANT_ROW_MAPPER, id);

        if (participants.isEmpty()) {
            return null;
        }
        return participants.get(0);
    }

    ;
}
