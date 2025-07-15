package com.spring.app;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GoldRateInfo {

    
    @Value("#{${gold.rate}}")
    private Map<Integer, Double> rateInfo;

    public Map<Integer, Double> getRateInfo() {
        return rateInfo;
    }
    
    @Value("#{${gold.rate}}")
    public void setRateInfo(Map<Integer, Double> rateInfo) {
        this.rateInfo = rateInfo;
    }

    public double calculateGoldRate(int goldCarat, double grams) {
  
            return rateInfo.get(goldCarat) * grams;
        
    }
}
