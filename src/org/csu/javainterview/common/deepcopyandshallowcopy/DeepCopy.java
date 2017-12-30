package org.csu.javainterview.common.deepcopyandshallowcopy;

import java.util.Date;

public class DeepCopy {
	/**
	 * This is Deep Copy.
	 * @param args
	 */
	public static void main(String[] args) {
		HouseDeep house1 = new HouseDeep(1, 1750.50);
		try {
			HouseDeep house2 = (HouseDeep)house1.clone();
			System.out.println("house1==house2 is " + (house1==house2));
			System.out.println("house1.equals(house2) is " + (house1.equals(house2)));
			System.out.println("house1.area==house2.area is " + (house1.getArea()==house2.getArea()));
			System.out.println("house1.wehnBuilt==house2.wehnBuilt is " + (house1.getWhenBuilt()==house2.getWhenBuilt()));
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}

class HouseDeep implements Cloneable, Comparable<Object> {
	private int id;
	private double area;
	private Date whenBuilt;
	
	public HouseDeep(int id, double area) {
		super();
		this.id = id;
		this.area = area;
		this.whenBuilt = new Date();
	}
	public int getId() {
		return id;
	}
	public double getArea() {
		return area;
	}
	public Date getWhenBuilt() {
		return whenBuilt;
	}
	
	/**
	 * Override the protected clone method defined in the Object class, and strengthen its accessibility
	 */
	public Object clone() throws CloneNotSupportedException {
		try {
			HouseDeep houseDeep = (HouseDeep) super.clone();
			houseDeep.whenBuilt = (Date) whenBuilt.clone();
			return houseDeep;
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public int compareTo(Object o) {
		if (area > ((HouseDeep)o).getArea()) {
			return 1;
		} else if (area < ((HouseDeep)o).getArea() ) {
			return -1;
		} else {
			return 0;
		}
	}
	
}