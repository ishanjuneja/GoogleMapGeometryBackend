package com.mapapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mapapi.dto.PointInPoygonRequest;
import com.mapapi.model.Coordinate;
import com.mapapi.model.Shape;
import com.mapapi.service.ShapeService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class MapController {

	@Autowired
	ShapeService shapeService;
	
	@RequestMapping(value="/mapapi/saveCoordinates")
	public void saveCoordinates(@RequestBody Shape shape) {
		shapeService.saveShape(shape);
	}
	
	@RequestMapping(value="/mapapi/getAllShapes")
	public List<Shape> getAllShapes() {
		return shapeService.getAll();
	}
	
	@RequestMapping(value="/mapapi/checkPoint")
	public boolean checkPointInPolygon(@RequestBody PointInPoygonRequest pipRequest) {
		return shapeService.checkPIP(pipRequest);
	}
	
	@RequestMapping(value="/mapapi/checkPointInAllShapes")
	public boolean checkPointInAllPolygons(@RequestBody Coordinate testPoint) {
		return shapeService.checkPointInAllPolygons(testPoint);
	}
}
