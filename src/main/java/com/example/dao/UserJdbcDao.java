package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.query.UtilisateurSqlParameter;

@Repository
public class UserJdbcDao implements UserDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer countUserByNom(String nom) {
        String sql = "SELECT COUNT(*) FROM utilisateur WHERE nom = :nom";
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(new UtilisateurSqlParameter(nom));
        return this.namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Integer.class);
    }
}
