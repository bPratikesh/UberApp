package com.pratikesh.project.uber.UberApp.configs;

import com.pratikesh.project.uber.UberApp.dto.PointDTO;
import com.pratikesh.project.uber.UberApp.utils.GeometryUtil;
import org.locationtech.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper(){

        //converting PontDTO to point
        ModelMapper mapper = new ModelMapper();
        mapper.typeMap(PointDTO.class, Point.class).setConverter(context ->{
            PointDTO pointDTO = context.getSource();
            return GeometryUtil.createPoint(pointDTO);
        });

        //converting point to PontDTO
        mapper.typeMap(Point.class, PointDTO.class).setConverter(context ->{
            Point point = context.getSource();
            double coordinates[] = {
                    point.getX(),
                    point.getY()
            };
            return new PointDTO(coordinates);
        });

        return mapper;
    }
}
