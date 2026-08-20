/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linkedlists;

import java.io.*;
import java.util.*;

class Node {
    int value;
    Node next;
    
    Node(int value){
        this.value = value;
    }
}

class MyLinkedList {
    Node head;
    
    void addFirst(int value) {
        Node newNode = new Node(value);
        
        newNode.next = head;
        head = newNode;
    }
    
    void addLast(int value) {
        Node newNode = new Node(value);
        
        if(head == null) {
            head = newNode;
            return;
        }
        
        Node current = head;
        
        while(current.next != null){
            current = current.next;
        }
        
        current.next = newNode;
    }
    
    void printList(){
        Node current = head;
        
        
        while(current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.print("null");
    }
    
    void addAt(int index, int value){
        if(index==0) addFirst(value);
        
        Node current = head;
        
        for(int i=0;i<index-1;i++){
            current = current.next;
        }
        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
    }
    
    void removeFirst(){
        if(head == null){
            return;
        }
        
        head = head.next;
    }
    
    void removeLast(){
        
        if(head == null){
            return ;
        }
        
        if(head.next == null){
            head = null;
            return;
        }
        
        Node current = head;
        while(current.next.next != null){
            current = current.next;
        }
        
        current.next = null;
    }
    
    int size(){
        int count = 0;
        Node current = head;
        
        while(current != null){
            count++;
            current = current.next;
        }
        
        return count;
    }
    
   void removeAt(int index){
       if(index < 0 || index >= size()) {
           return;
       }
       
       if(index == 0) {
           removeFirst();
           return;
       }
       
       Node current = head;
       
       for(int i=0;i<index-1;i++){
           current = current.next;
       }
       
       current.next = current.next.next;
   } 
   
   int get(int index) {
       
       if(index < 0 || index > size()){
           return -1;
       }
       
       Node current = head;
       
       for(int i=0;i<index;i++){
           current = current.next;
       }
       
       return current.value;
   }
   
   void reverse(){
       Node current = head;
       Node previous = null;
       
       while( current != null ){
           Node next = current.next;
           
           current.next = previous;
           
           previous = current;
           
           current = next;
       }
       
       head = previous;
   }
}

public class LinkedLists {


    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        
        list.addFirst(20);
        list.addFirst(10);
        list.addLast(40);
        
        list.printList();
        System.out.println();
        list.addAt(2,30);
        list.printList();
        System.out.println();
        
//        list.removeFirst();
//        list.printList();
//        System.out.println();
//        
//        list.removeLast();
//        list.printList();
//        System.out.println();
//        
//
//        list.removeAt(1);
//        list.printList();
//        System.out.println();
//        
//        System.out.print(list.get(0));
//        System.out.println();
        
        list.reverse();
        list.printList();
        System.out.println();
        
        

    }
    
}
