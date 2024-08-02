package com.pratikesh.project.uber.UberApp.services.implementations;

import com.pratikesh.project.uber.UberApp.services.DistanceService;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

@Service
public class DistanceServiceImpl implements DistanceService {
    @Override
    public double calculateDistance(Point src, Point dest) {
        //call the third party api called osrm to fetch distance
        return 0;
    }
}
