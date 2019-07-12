package com.mapapi.serviceimpl;

import java.awt.Polygon;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapapi.dto.PointInPoygonRequest;
import com.mapapi.model.Coordinate;
import com.mapapi.model.Shape;
import com.mapapi.repository.ShapeRepository;
import com.mapapi.service.ShapeService;

@Service
public class ShapeServiceImpl implements ShapeService {

	@Autowired
	ShapeRepository shapeRepository;

	@Override
	public boolean saveShape(Shape shape) {
		shapeRepository.save(shape);
		return false;
	}

	@Override
	public List<Shape> getAll() {
		return shapeRepository.findAll();
	}

	@Override
	public boolean checkPIP(PointInPoygonRequest pipRequest) {
		Shape shape = shapeRepository.findById(pipRequest.getShapeId()).get();
		Coordinate test = new Coordinate(pipRequest.getLat(), pipRequest.getLng());

		return contains(test, shape.getCoordinates());
	}

	public boolean contains(Coordinate test, List<Coordinate> points) {
		int i;
		int j;
		boolean result = false;
		for (i = 0, j = points.size() - 1; i < points.size(); j = i++) {
			if ((points.get(i).getLng() > test.getLng()) != (points.get(j).getLng() > test.getLng())
					&& (test.getLat() < (points.get(j).getLat() - points.get(i).getLat())
							* (test.getLng() - points.get(i).getLng())
							/ (points.get(j).getLng() - points.get(i).getLng()) + points.get(i).getLat())) {
				result = !result;
			}
		}
		return result;
	}

	@Override
	public boolean checkPointInAllPolygons(Coordinate testPoint) {
		List<Shape> shapes = shapeRepository.findAll();
		for (Shape shape : shapes) {
			if(contains(testPoint,shape.getCoordinates())) return true;
		}
		return false;
	}
}
