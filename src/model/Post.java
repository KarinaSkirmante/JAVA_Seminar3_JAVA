package model;

import java.time.LocalDateTime;

public class Post {
	//mainīgie, getters, setters, abi konstruktori, toString + citas funkcijas
	private String msg;
	private LocalDateTime datetime;
	private long countOfLikes = 0;
	
	public String getMsg() {
		return msg;
	}
	public LocalDateTime getDatetime() {
		return datetime;
	}
	public long getCountOfLikes() {
		return countOfLikes;
	}
	
	public void setMsg(String inputMsg) {
		if(inputMsg != null && inputMsg.matches("[A-Za-b .0-9!@#$%^&*()?]{3,100}")) {
			msg = inputMsg;
		}
		else
		{
			msg = "No msg";
		}
	}
	
	public void setDatetime() {
		datetime = LocalDateTime.now();
	}
	
	public void increaseCountOfLikes() {
		countOfLikes++;
	}
	public Post() {
		setMsg("Test message");
		setDatetime();
	}
	
	public Post(String inputMsg) {
		setMsg(inputMsg);
		setDatetime();
	}
	
	//TODO apskatities datetime formātus 
	public String toString() {
		return msg + " (" + datetime + ")" + countOfLikes;
	}
	
	
}
