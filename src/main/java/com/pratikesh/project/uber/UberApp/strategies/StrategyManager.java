package com.pratikesh.project.uber.UberApp.strategies;

/*Responsibility of StrategyManager is whenever in application we need any of strategy it will return the
strategy.*/

import com.pratikesh.project.uber.UberApp.strategies.implementations.DriverMatchingHighestRatedDriverStrategy;
import com.pratikesh.project.uber.UberApp.strategies.implementations.NearestDriverMatchingStrategy;
import com.pratikesh.project.uber.UberApp.strategies.implementations.RideFareDefaultCalculationStrategy;
import com.pratikesh.project.uber.UberApp.strategies.implementations.RideFareSurgePricingFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class StrategyManager {

    private final DriverMatchingHighestRatedDriverStrategy highestRatedDriverStrategy;
    private final NearestDriverMatchingStrategy nearestDriverMatchingStrategy;
    private final RideFareSurgePricingFareCalculationStrategy surgePricingFareCalculationStrategy;
    private final RideFareDefaultCalculationStrategy fareDefaultCalculationStrategy;

    public DriverMatchingStrategy driverMatchingStrategy(double riderRating){
        if(riderRating >= 4.8){
            return highestRatedDriverStrategy;
        }
        else {
            return nearestDriverMatchingStrategy;
        }
    }

    public RideFareCalculationStrategy rideFareCalculationStrategy(){

        LocalTime surgeStartTime = LocalTime.of(18,0);
        LocalTime surgeEndTime = LocalTime.of(21,0);
        LocalTime currentTime = LocalTime.now();

        boolean isSurgeTime = currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime);
        if(isSurgeTime){
            return surgePricingFareCalculationStrategy;
        }
        else{
            return fareDefaultCalculationStrategy;
        }
    }
}
