package com.mapapi.service;

import java.util.List;

import com.mapapi.dto.PointInPoygonRequest;
import com.mapapi.model.Coordinate;
import com.mapapi.model.Shape;

public interface ShapeService {

	boolean saveShape(Shape shape);
	
	List<Shape> getAll();

	boolean checkPIP(PointInPoygonRequest pipRequest);

	boolean checkPointInAllPolygons(Coordinate testPoint);
}
