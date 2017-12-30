package org.csu.javainterview.common.deepcopyandshallowcopy;

import java.util.Date;

public class ShallowCopy {
	/**
	 * The house1 and house2 are two different object with identical contents.
	 * The clone method of Object class copies each field from the original object to the target object.
	 * If the field is of a primitive type, its value is copied. For example, the value of area (double type) is copied from house1 to house2.
	 * If the field is of an object, the reference of the field is copied. For example, the field whenBuilt is of the Date class, so its reference is copied into house2.
	 * This is Shallow Copy, which means that if the field is of an object type, the object’s reference is copied rather than its contents.
	 * @param args
	 */
	public static void main(String[] args) {
		HouseShallow house1 = new HouseShallow(1, 1750.50);
		try {
			HouseShallow house2 = (HouseShallow)house1.clone();
			System.out.println("house1==house2 is " + (house1==house2));
			System.out.println("house1.equals(house2) is " + (house1.equals(house2)));
			System.out.println("house1.area==house2.area is " + (house1.getArea()==house2.getArea()));
			System.out.println("house1.wehnBuilt==house2.wehnBuilt is " + (house1.getWhenBuilt()==house2.getWhenBuilt()));
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}

class HouseShallow implements Cloneable, Comparable<Object> {
	private int id;
	private double area;
	private Date whenBuilt;
	
	public HouseShallow(int id, double area) {
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
		return super.clone();
	}
	@Override
	public int compareTo(Object o) {
		if (area > ((HouseShallow)o).getArea()) {
			return 1;
		} else if (area < ((HouseShallow)o).getArea() ) {
			return -1;
		} else {
			return 0;
		}
	}
	
}