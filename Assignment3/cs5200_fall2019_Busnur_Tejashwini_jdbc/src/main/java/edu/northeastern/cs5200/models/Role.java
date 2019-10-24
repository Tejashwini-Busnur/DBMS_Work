package edu.northeastern.cs5200.models;

public enum Role {

	owner(1), editor(2), admin(3), reviewer(4), writer(5);

	private int roleId;

	Role(int roleId) {
		this.roleId = roleId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public static Role roleIdToRole(int roleId) {
		switch (roleId) {
		case 1:
			return Role.owner;
		case 2:
			return Role.editor;
		case 3:
			return Role.admin;
		case 4:
			return Role.reviewer;
		case 5:
			return Role.writer;
		default:
			return null;
		}
	}

}