package com.xiao.geeker.springbatchboot.vo;

public class UserInfo {

	private String name;
	private String nickName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserInfo [name=");
		builder.append(name);
		builder.append(", nickName=");
		builder.append(nickName);
		builder.append("]");
		return builder.toString();
	}
	
}
