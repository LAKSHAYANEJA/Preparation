/*      
// Definition for a Node.      
class Node {      
    int val;      
    Node next;      
    Node random;      
      
    public Node(int val) {      
        this.val = val;      
        this.next = null;      
        this.random = null;      
    }      
}      
*/      
      
class Solution {       
    public Node copyRandomList(Node head) {       
        HashMap<Node, Node> map = new HashMap<>();      
        Node next = head;      
        Node random =  null;      
        Node original = head;   
      
        while (next != null ) {      
       original = next;   
       Node copy = new Node(original.val);   
        map.put(original, copy);      
       next = next.next;     
}      
next = head;   
while (next != null) {     
original = next;     
Node copy = map.get(original);     
copy.next = map.get(original.next);    
copy.random = map.get(original.random);     
next = next.next;       
}        
return map.get(head);        
    }         
}
