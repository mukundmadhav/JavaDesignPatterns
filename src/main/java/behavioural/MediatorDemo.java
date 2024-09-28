package behavioural;

import java.util.*;

public class MediatorDemo {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();
        User user1 = new UserImpl(chatRoom, "User1");
        User user2 = new UserImpl(chatRoom, "User2");
        User user3 = new UserImpl(chatRoom, "User3");
        chatRoom.addUsers(user1);
        chatRoom.addUsers(user2);
        chatRoom.addUsers(user3);

        user1.send("Hello User2");
        user2.send("Hello User1");
    }
}
// Declare the mediator interface and describe the desired communication protocol between mediators and various components
// Uses: Airline traffic, chat room, broadcasting
interface Mediator {
	void showMessage(User user, String message);
}
class ChatRoom implements Mediator {

	private List<User> users = new ArrayList<>();
	public void addUsers(User user) {
		users.add(user);
	}

	@Override
	public void showMessage(User user, String message) {
		for(User curr: users)
			if(user != curr)
				curr.receive(message);
	}
}

// Colleague
abstract class User{
	protected ChatRoom chatRoom;
    protected String name;

    public User(ChatRoom room, String name) {
    	this.chatRoom = room;
    	this.name = name;
    }

    public abstract void send(String message);
    public abstract void receive(String message);

}

class UserImpl extends User {
	public UserImpl(ChatRoom chatRoom, String name) {
        super(chatRoom, name);
    }

    @Override
    public void send(String message) {
        System.out.println(this.name + " sends: " + message);
        chatRoom.showMessage(this, message);
    }

    @Override
    public void receive(String message) {
        System.out.println(this.name + " receives: " + message);
    }
}