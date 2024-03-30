package com.CR.DBConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.CR.model.CoinData;
import com.CR.repository.CoinDataRepository;

@Repository
public class CoinDataRepositoryImpl implements CoinDataRepository{
	@Autowired
    private JdbcTemplate jdbcTemplate;


	@Override
	public void save(CoinData coinData) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO coin_data (coin_name, coin_value) VALUES (?, ?)";
        jdbcTemplate.update(sql, coinData.getCoinName(), coinData.getCoinValue());
	}
}
