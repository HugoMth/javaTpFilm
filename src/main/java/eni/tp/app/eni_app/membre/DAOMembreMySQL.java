package eni.tp.app.eni_app.membre;


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
public class DAOMembreMySQL implements IDAOMembre {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * Le code qui permet de savoir comment convertir/mapper un resultat en SQL en Objet/Classe
     * Comment mapper un resultat SQL en Aliment
     */


    static final RowMapper<Membre> MEMBRE_ROW_MAPPER = new RowMapper<Membre>() {
        @Override
        public Membre mapRow(ResultSet rs, int rowNum) throws SQLException {
            Membre membre = new Membre();

            membre.setId(rs.getLong("id"));
            membre.setNom(rs.getString("nom"));
            membre.setPrenom(rs.getString("prenom"));
            membre.setEmail(rs.getString("email"));
            membre.setPassword(rs.getString("password"));
            membre.setAdmin(rs.getInt("admin"));
            return membre;
        }

        ;
    };

    public Membre getMembreByEmail(String email) {
        List<Membre> membre = jdbcTemplate.query("SELECT * FROM membre WHERE email = ?", MEMBRE_ROW_MAPPER, email);

        if (membre.isEmpty()) {
            return null;
        }
        return membre.get(0);
    }
}
