package com.CR.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ThirdPartyAPIService {

    private static final String API_BASE_URL = "https://proapi.coinmarketcap.com/v1/cryptocurrency/quotes/latest?symbol=BTC,ETHLTC";

    @Autowired
    private RestTemplate restTemplate;

    public String getCoinData(String userId) {
        String url = API_BASE_URL + "/coin-data?userId=" + userId;
        return restTemplate.getForObject(url, String.class);
    }
}