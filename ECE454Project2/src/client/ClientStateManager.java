package client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import data.Message;

public class ClientStateManager {
	public static HashMap<String, Message> otherPeersAndMessageQueue;
	
	public ClientStateManager(){
		otherPeersAndMessageQueue = new HashMap<String, Message>();
	}
	
	public static void AddNewMessageToQueue(String peerName, Message message){
		otherPeersAndMessageQueue.put(peerName, message);
	}
	
	public static boolean NewMessageToSendForPeer(String peerName){
		boolean newMessage = false;
		Iterator it = otherPeersAndMessageQueue.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pairs = (Map.Entry)it.next();
	        String retrievedPeerName = (String) pairs.getKey();
	        if (peerName.equals(retrievedPeerName)){
	        	newMessage = true;
	        }
	    }
	    return newMessage;
	}
	
	public static Message RetrieveMessageForPeer(String peerName){
		Message newMessage = null;
		Iterator it = otherPeersAndMessageQueue.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pairs = (Map.Entry)it.next();
	        String retrievedPeerName = (String) pairs.getKey();
	        if (peerName.equals(retrievedPeerName)){
	        	newMessage = (Message) pairs.getValue();
	        }
	        it.remove();
	    }
	    return newMessage;
	}
}
