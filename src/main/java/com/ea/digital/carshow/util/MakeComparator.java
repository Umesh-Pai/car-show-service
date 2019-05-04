package com.ea.digital.carshow.util;

import java.util.Comparator;
import com.ea.digital.carshow.domain.Car;

public class MakeComparator implements Comparator<Car>
{
	@Override
	public int compare(Car c1, Car c2) {
		return c1.getMake().compareTo(c2.getMake());
	}
}
