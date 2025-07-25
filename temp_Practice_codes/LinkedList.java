package temp_Practice_codes;

class Node {
    int data;
    Node next;

    Node(int data, Node nxt) {
        this.data = data;
        this.next = nxt;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {

    public static Node ConvertToLL(int arr[]) {
        if (arr == null || arr.length == 0)
            return null;
        Node head = new Node(arr[0]);
        Node movNode = head;
        for (int i = 1; i < arr.length; i++) {
            Node tempNode = new Node(arr[i]);
            movNode.next = tempNode; // because currently moveNode is the previous node
            movNode = tempNode; // now moveNode becomes currentNode
        }
        return head;
    }
    
    public static int lenghOfLL(Node head) {
        int cnt = 0;
        while (head != null) {
            cnt++;
            head = head.next;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int arr[] = {1,5,6,7,8,9,2,78};
        Node head = ConvertToLL(arr);
        // System.out.println(head.data);

        //traversal
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

        int lenghth = lenghOfLL(head);
        System.out.println(lenghth);
    }
}
