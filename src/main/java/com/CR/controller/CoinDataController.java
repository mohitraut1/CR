package com.CR.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CR.model.CoinData;
import com.CR.service.CoinDataService;
import com.CR.service.ThirdPartyAPIService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CoinDataController {

	@Autowired
    private ThirdPartyAPIService thirdPartyAPIService;

    @GetMapping("/coin-data")
    public ResponseEntity<String> getCoinData(@RequestParam String userId) {
        String coinData = thirdPartyAPIService.getCoinData(userId);
        return ResponseEntity.ok(coinData);
    }
}