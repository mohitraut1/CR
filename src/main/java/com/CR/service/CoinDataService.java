package com.CR.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CR.model.CoinData;
import com.CR.repository.CoinDataRepository;

@Service
public class CoinDataService {
    @Autowired
    private CoinDataRepository coinDataRepository;

    public void saveCoinData(CoinData coinData) {
        coinDataRepository.save(coinData);
    }
}