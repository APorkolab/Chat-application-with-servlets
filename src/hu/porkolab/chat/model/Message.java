package hu.porkolab.chat.model;

public class Message {
    private Human name;
    private String messageString;
   
    
    public Message(Human name, String messageString) {
		super();
		this.name = name;
		this.setMessageString(messageString);
	}
    
	public Human getName() {
		return name;
	}

	public void setName(Human name) {
		this.name = name;
	}

	public String getMessageString() {
		return messageString;
	}

	public void setMessageString(String messageString) {
		this.messageString = messageString;
	}

	public String toString() {
	    return this.getName().getName() + ": " + this.getMessageString() + System.lineSeparator();
	}
}
