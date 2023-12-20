package com.model;

public class Room {
    /**
	 * @return the room_number
	 */
	public String getRoom_number() {
		return room_number;
	}
	/**
	 * @param room_number the room_number to set
	 */
	public void setRoom_number(String room_number) {
		this.room_number = room_number;
	}
	/**
	 * @return the floor_number
	 */
	public String getFloor_number() {
		return floor_number;
	}
	/**
	 * @param floor_number the floor_number to set
	 */
	public void setFloor_number(String floor_number) {
		this.floor_number = floor_number;
	}
	/**
	 * @return the is_occupied
	 */
	public String getIs_occupied() {
		return is_occupied;
	}
	/**
	 * @param is_occupied the is_occupied to set
	 */
	public void setIs_occupied(String is_occupied) {
		this.is_occupied = is_occupied;
	}
	/**
	 * @return the max_occupancy
	 */
	public int getMax_occupancy() {
		return max_occupancy;
	}
	/**
	 * @param max_occupancy the max_occupancy to set
	 */
	public void setMax_occupancy(int max_occupancy) {
		this.max_occupancy = max_occupancy;
	}
	/**
	 * @return the has_ac
	 */
	public String getHas_ac() {
		return has_ac;
	}
	/**
	 * @param has_ac the has_ac to set
	 */
	public void setHas_ac(String has_ac) {
		this.has_ac = has_ac;
	}
	/**
	 * @return the has_swimming_pool_access
	 */
	public String getHas_swimming_pool_access() {
		return has_swimming_pool_access;
	}
	/**
	 * @param has_swimming_pool_access the has_swimming_pool_access to set
	 */
	public void setHas_swimming_pool_access(String has_swimming_pool_access) {
		this.has_swimming_pool_access = has_swimming_pool_access;
	}
	/**
	 * @return the has_gym_access
	 */
	public String getHas_gym_access() {
		return has_gym_access;
	}
	/**
	 * @param has_gym_access the has_gym_access to set
	 */
	public void setHas_gym_access(String has_gym_access) {
		this.has_gym_access = has_gym_access;
	}
	private String room_number;
    public Room(String room_number, String floor_number, String is_occupied, int max_occupancy, String has_ac,
			String has_swimming_pool_access, String has_gym_access) {
		super();
		this.room_number = room_number;
		this.floor_number = floor_number;
		this.is_occupied = is_occupied;
		this.max_occupancy = max_occupancy;
		this.has_ac = has_ac;
		this.has_swimming_pool_access = has_swimming_pool_access;
		this.has_gym_access = has_gym_access;
	}
	private String floor_number;
    private String is_occupied;
    private int max_occupancy;
    private String has_ac;
    private String has_swimming_pool_access;
    private String has_gym_access;
}
