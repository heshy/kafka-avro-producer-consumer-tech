package io.hatchyard.avro.dto;

public class HelloMessageDTO {
	
	public String to;
	
	public String from;
	
	public String message;

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "To: "+to+" From: "+from+" message: "+message;
	}
	
	 
}
