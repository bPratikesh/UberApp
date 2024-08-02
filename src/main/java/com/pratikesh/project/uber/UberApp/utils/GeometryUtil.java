package com.pratikesh.project.uber.UberApp.utils;

import com.pratikesh.project.uber.UberApp.dto.PointDTO;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;

public class GeometryUtil {

    /*So basically here we are converting "PointDTO"(which contains longitude and latitude)
     to the "Point"
    Spatial Reference System Identifier(SRID) of earth is 4326*/
    public static Point createPoint(PointDTO pointDTO){

        GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
        Coordinate coordinate = new Coordinate(pointDTO.getCoordinates()[0],
                pointDTO.getCoordinates()[1]
        );
        return geometryFactory.createPoint(coordinate);
    }
}
