package com.cacheproject.inMemoryCache.codehomework;

import java.util.HashMap;


class Node{ 
	String key;
	Object value;
	Node prev;
	Node next;
	
	Node(String key, Object value){
		this.key = key;
		this.value= value;
	}

}
// So this implementation is based on least recently for that we are using hashmap to save the node with the key.
// Also we have temporary holder to hold current head and current tail.
// In side of constructor we are getting the size or the max capacity.
public class InMemoryCache implements Service{
	Node head;
	Node tail;
	HashMap<String, Object> hashMap;
	int capacity;
	
	public InMemoryCache(int capacity){
		this.capacity = capacity;
		hashMap = new HashMap<String, Object>();
	}

	public Object get(String key) {
		if(key==null) {
			return "";
		}
		return hashMap.get(key);
	}

	public void put(String key, Object value) {
		
		if(hashMap.containsKey(key)) { // if the map contains the key already
			 Node tempNode = (Node) hashMap.get(key);
	         tempNode.value = value;
	         removeNode(tempNode); 
	         moveToHead(tempNode);
		}else {
			if(hashMap.size()>=capacity){ //if the hashMap size is more than capacity need to remove the end node
                
				hashMap.remove(head.key); 
                removeNode(head);
            }
			 //creating a new node
            Node node = new Node(key, value);
            System.out.println(node);
            moveToHead(node);
            hashMap.put(key, node);
		}
	
	}
	
	private void moveToHead(Node tempNode) {
		if(tail!=null){
            tail.next = tempNode;
        }
 
		tempNode.prev = tail;
		tempNode.next = null;
        tail = tempNode;
 
        if(head == null){
            head = tail;   
        }
		
	}

	private void removeNode(Node tempNode) { // this method removes the node prev and next 
		if(tempNode.prev!=null){
			tempNode.prev.next = tempNode.next;
        }else{
            head = tempNode.next;
        }
 
        if(tempNode.next!=null){
        	tempNode.next.prev = tempNode.prev;
        }else{
            tail = tempNode.prev;
        }
		
	}
	@Override
	public String toString() {
		return "InMemoryCache [hashMap=" + hashMap + ", capacity=" + capacity + "]";
	}
	
	

}
