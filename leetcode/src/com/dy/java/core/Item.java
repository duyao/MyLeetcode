package com.dy.java.core;


public class Item implements Comparable<Item>{
	
	private String description;
	private int partNum;
	
	public Item(String des, int num){
		this.description = des;
		this.partNum = num;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public int getPartNum(){
		return this.partNum;
	}
	
	@Override
	public String toString() {
		return "[" + description + "," + partNum + "]";
	}
	
//	@Override
//	public int hashCode() {
//		return Objects.hash(description, partNum);
//	}
	
	
//	@Override
//	public boolean equals(Object obj) {
//		if(this == obj) return true;
//		if(obj == null) return false;
//		if(this.getClass() != obj.getClass()) return false;
//		
//		Item i = (Item) obj;
//		return Objects.equals(this.description, i.description) && this.partNum == i.partNum;
//	}
	
	
	
	
	

	@Override
	public int compareTo(Item o) {
		return Integer.compare(partNum, o.partNum);
	}
	
	

}
