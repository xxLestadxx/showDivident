package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockService {
    @Value("${alpha.vantage.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public StockService (RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public String getDailyStockData(String symbol){
        String url = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY" +
                "&symbol=" + symbol +
                "&apikey=" + apiKey;

        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }

}
