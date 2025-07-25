package temp_Practice_codes.LL_AIG_QS;

class Node {
    int data;
    Node next;

    Node() {
    }

    Node(int data) {
        this.data = data;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class LinkedListPractice {

    // ============= PRACTICE QUESTIONS (IMPLEMENT THESE METHODS) =============

    /**
     * Question 1: Search for a dataue in the linked list
     * 
     * @param head   - head of the linked list
     * @param target - dataue to search for
     * @return true if target exists in the list, false otherwise
     * 
     *  
     */
    public static boolean searchInLL(Node head, int target) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == target) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    /**
     * Question 2: Insert a node at the beginning of the linked list
     * 
     * @param head - current head of the linked list
     * @param data - dataue to insert
     * @return new head of the linked list
     * 
     *         
     */
    public static Node insertAtStart(Node head, int data) {
        Node temp = new Node(data, head);
        return temp;
    }

    /**
     * Question 3: Insert a node at the end of the linked list
     * 
     * @param head - head of the linked list
     * @param data - dataue to insert
     * @return head of the linked list (may be the same or new if list was empty)
     * 
     *        
     */
    public static Node insertAtEnd(Node head, int data) {
        Node temp = new Node(data);
        Node curr = head;
        if (head == null) {
            return temp;
        }
        while (curr != null) {
            if (curr.next == null) {
                curr.next = temp;
                temp.next = null;
            }
            curr = curr.next;
        }
        return head;
    }

    /**
     * Question 4: Insert a node at a specific position (0-indexed)
     * 
     * @param head - head of the linked list
     * @param pos  - position to insert at (0-indexed)
     * @param data - dataue to insert
     * @return head of the linked list
     * 
     *         TODO: Implement this method
     *         Note: If pos is 0, insert at start. If pos >= length, insert at end.
     */
    public static Node insertAtPosition(Node head, int pos, int data) {
        Node newNode = new Node(data);
        Node temp = head;
        Node prv = head;
        if (head == null) {
            return newNode;
        }
        if (pos == 0) {
            newNode.next = head;
            return newNode;
        }
        int i = 1;
        while (temp != null) {
            temp = temp.next;
            if (pos == i) {
                prv.next = newNode;
                newNode.next = temp;
                return head;
            }
            if (temp != null) {
                prv = temp;
            } 
            i++;
        }
        prv.next = newNode;
        return head;
    }

    /**
     * Question 5: Delete first occurrence of a dataue from the linked list
     * 
     * @param head - head of the linked list
     * @param data - dataue to delete
     * @return head of the linked list after deletion
     * 
     *         
     */
    public static Node deletedataue(Node head, int data) {
        if (head == null) return null;
        // If head needs to be deleted
        if (head.data == data) {
            return head.next;
        }
        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            if (curr.data == data) {
                prev.next = curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }

    /**
     * Question 6: Delete node at a specific position (0-indexed)
     * 
     * @param head - head of the linked list
     * @param pos  - position to delete (0-indexed)
     * @return head of the linked list after deletion
     * 
     *         
     *         Note: If pos is out of bounds, return the list unchanged
     */
    public static Node deleteAtPosition(Node head, int pos) {
        // Write your code here
        Node prv = head;
        Node curr = head.next;
        int i = 1;
        if (pos == 0) {
            head = head.next;
            return head;
        }
        while (curr!=null) {
            if (i == pos) {
                prv.next = curr.next;
                break;
            }
            i++;
            prv = curr;
            curr = curr.next;
        }
        return head;
    }

    /**
     * Question 7: Delete the first node (head) of the linked list
     * 
     * @param head - head of the linked list
     * @return new head of the linked list after deletion
     * 
     *         
     *         Note: If list is empty, return null
     */
    public static Node deleteFirst(Node head) {
        if (head==null) {
            return null;
        }
        head = head.next;
        return head;
    }

    /**
     * Question 8: Delete the last node of the linked list
     * 
     * @param head - head of the linked list
     * @return head of the linked list after deletion
     * 
     *         
     *         Note: If list has only one node, return null
     */
    public static Node deleteLast(Node head) {
        Node temp = head;
        if (temp==null || temp.next == null) {
            return null;
        }
        while (temp !=null) {
            if (temp.next.next == null) {
                temp.next = null;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    // ============= HELPER METHODS (DO NOT MODIFY) =============

    public static Node createList(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        Node head = new Node(arr[0]);
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static boolean compareLists(Node l1, Node l2) {
        while (l1 != null && l2 != null) {
            if (l1.data != l2.data)
                return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }

    public static int getLength(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    // ============= TEST CASES AND MAIN METHOD =============

    public static void main(String[] args) {
        System.out.println("Running Linked List Practice Tests...\n");

        int totalTests = 80;
        int passedTests = 0;

        // Test Search functionality (10 tests)
        passedTests += runSearchTests();

        // Test Insert at Start functionality (10 tests)
        passedTests += runInsertAtStartTests();

        // Test Insert at End functionality (10 tests)
        passedTests += runInsertAtEndTests();

        // Test Insert at Position functionality (10 tests)
        passedTests += runInsertAtPositionTests();

        // Test Delete dataue functionality (10 tests)
        passedTests += runDeletedataueTests();

        // Test Delete at Position functionality (10 tests)
        passedTests += runDeleteAtPositionTests();

        // Test Delete First functionality (10 tests)
        passedTests += runDeleteFirstTests();

        // Test Delete Last functionality (10 tests)
        passedTests += runDeleteLastTests();

        System.out.println("=".repeat(50));
        System.out.println("FINAL RESULT:");
        System.out.println(passedTests + "/" + totalTests + " Test cases passed");

        if (passedTests == totalTests) {
            System.out.println("Status: ACCEPTED ✓");
        } else {
            System.out.println("Status: NOT ACCEPTED ✗");
            System.out.println("Keep practicing! You're getting there.");
        }
        System.out.println("=".repeat(50));
    }

    private static int runSearchTests() {
        System.out.println("Testing Search in Linked List...");
        int passed = 0;

        // Test cases for search
        int[][] testArrays = {
                { 1, 2, 3, 4, 5 }, { 10, 20, 30 }, { 1 }, {},
                { 5, 3, 8, 1, 9 }, { 100 }, { 1, 1, 1, 1 }, { -1, -2, -3 },
                { 0, 5, 10, 15 }, { 7, 14, 21, 28, 35 }
        };

        int[] searchdataues = { 3, 20, 1, 5, 9, 100, 1, -2, 10, 42 };
        boolean[] expectedResults = { true, true, true, false, true, true, true, true, true, false };

        for (int i = 0; i < testArrays.length; i++) {
            Node head = createList(testArrays[i]);
            boolean result = searchInLL(head, searchdataues[i]);
            if (result == expectedResults[i]) {
                passed++;
            }
        }

        System.out.println("Search tests: " + passed + "/10 passed\n");
        return passed;
    }

    private static int runInsertAtStartTests() {
        System.out.println("Testing Insert at Start...");
        int passed = 0;

        int[][] testArrays = {
                { 2, 3, 4 }, {}, { 5 }, { 1, 2 }, { 10, 20, 30, 40 },
                { 100 }, { 7, 8, 9 }, { 50 }, { 1, 3, 5, 7 }, { 0 }
        };

        int[] insertdataues = { 1, 5, 0, 0, 5, 99, 6, 25, 0, -1 };

        int[][] expectedArrays = {
                { 1, 2, 3, 4 }, { 5 }, { 0, 5 }, { 0, 1, 2 }, { 5, 10, 20, 30, 40 },
                { 99, 100 }, { 6, 7, 8, 9 }, { 25, 50 }, { 0, 1, 3, 5, 7 }, { -1, 0 }
        };

        for (int i = 0; i < testArrays.length; i++) {
            Node head = createList(testArrays[i]);
            Node result = insertAtStart(head, insertdataues[i]);
            Node expected = createList(expectedArrays[i]);
            if (compareLists(result, expected)) {
                passed++;
            }
        }

        System.out.println("Insert at Start tests: " + passed + "/10 passed\n");
        return passed;
    }

    private static int runInsertAtEndTests() {
        System.out.println("Testing Insert at End...");
        int passed = 0;

        int[][] testArrays = {
                { 1, 2, 3 }, {}, { 5 }, { 1, 2 }, { 10, 20, 30 },
                { 100 }, { 7, 8 }, { 50, 60 }, { 1, 3, 5 }, { 0, 1 }
        };

        int[] insertdataues = { 4, 5, 0, 3, 40, 200, 9, 70, 7, 2 };

        int[][] expectedArrays = {
                { 1, 2, 3, 4 }, { 5 }, { 5, 0 }, { 1, 2, 3 }, { 10, 20, 30, 40 },
                { 100, 200 }, { 7, 8, 9 }, { 50, 60, 70 }, { 1, 3, 5, 7 }, { 0, 1, 2 }
        };

        for (int i = 0; i < testArrays.length; i++) {
            Node head = createList(testArrays[i]);
            Node result = insertAtEnd(head, insertdataues[i]);
            Node expected = createList(expectedArrays[i]);
            if (compareLists(result, expected)) {
                passed++;
            }
        }

        System.out.println("Insert at End tests: " + passed + "/10 passed\n");
        return passed;
    }

    private static int runInsertAtPositionTests() {
        System.out.println("Testing Insert at Position...");
        int passed = 0;

        int[][] testArrays = {
                { 1, 3, 4 }, { 1, 2, 3 }, { 5 }, {}, { 10, 30, 40 },
                { 1, 2, 3, 4 }, { 7, 8, 9 }, { 100 }, { 1, 5, 9 }, { 0, 2, 4 }
        };

        int[] positions = { 1, 0, 1, 0, 1, 4, 1, 0, 2, 5 };
        int[] insertdataues = { 2, 0, 6, 1, 20, 5, 99, -1, 7, 6 };

        int[][] expectedArrays = {
                { 1, 2, 3, 4 }, { 0, 1, 2, 3 }, { 5, 6 }, { 1 }, { 10, 20, 30, 40 },
                { 1, 2, 3, 4, 5 }, { 7, 99, 8, 9 }, { -1, 100 }, { 1, 5, 7, 9 }, { 0, 2, 4, 6 }
        };

        for (int i = 0; i < testArrays.length; i++) {
            Node head = createList(testArrays[i]);
            Node result = insertAtPosition(head, positions[i], insertdataues[i]);
            Node expected = createList(expectedArrays[i]);
            if (compareLists(result, expected)) {
                passed++;
            }
        }

        System.out.println("Insert at Position tests: " + passed + "/10 passed\n");
        return passed;
    }

    private static int runDeletedataueTests() {
        System.out.println("Testing Delete dataue...");
        int passed = 0;

        int[][] testArrays = {
                { 1, 2, 3, 4 }, { 1, 2, 3 }, { 5 }, { 1, 1, 2, 3 }, { 10, 20, 30 },
                { 100, 200 }, { 7, 8, 9, 7 }, { 50 }, { 1, 3, 5, 7 }, {}
        };

        int[] deletedataues = { 2, 1, 5, 1, 20, 300, 7, 50, 3, 5 };

        int[][] expectedArrays = {
                { 1, 3, 4 }, { 2, 3 }, {}, { 1, 2, 3 }, { 10, 30 },
                { 100, 200 }, { 8, 9, 7 }, {}, { 1, 5, 7 }, {}
        };

        for (int i = 0; i < testArrays.length; i++) {
            Node head = createList(testArrays[i]);
            Node result = deletedataue(head, deletedataues[i]);
            Node expected = createList(expectedArrays[i]);
            if (compareLists(result, expected)) {
                passed++;
            }
        }

        System.out.println("Delete dataue tests: " + passed + "/10 passed\n");
        return passed;
    }

    private static int runDeleteAtPositionTests() {
        System.out.println("Testing Delete at Position...");
        int passed = 0;

        int[][] testArrays = {
                { 1, 2, 3, 4 }, { 1, 2, 3 }, { 5 }, { 1, 2, 3, 4, 5 }, { 10, 20 },
                { 100, 200, 300 }, { 7, 8, 9 }, { 50, 60, 70, 80 }, { 1 }, { 0, 1, 2, 3 }
        };

        int[] positions = { 1, 0, 0, 4, 1, 2, 10, 2, 0, 2 };

        int[][] expectedArrays = {
                { 1, 3, 4 }, { 2, 3 }, {}, { 1, 2, 3, 4 }, { 10 },
                { 100, 200 }, { 7, 8, 9 }, { 50, 60, 80 }, {}, { 0, 1, 3 }
        };

        for (int i = 0; i < testArrays.length; i++) {
            Node head = createList(testArrays[i]);
            Node result = deleteAtPosition(head, positions[i]);
            Node expected = createList(expectedArrays[i]);
            if (compareLists(result, expected)) {
                passed++;
            }
        }

        System.out.println("Delete at Position tests: " + passed + "/10 passed\n");
        return passed;
    }

    private static int runDeleteFirstTests() {
        System.out.println("Testing Delete First...");
        int passed = 0;

        int[][] testArrays = {
                { 1, 2, 3 }, { 5 }, { 1, 2 }, { 10, 20, 30, 40 }, { 100 },
                { 7, 8, 9, 10 }, { 50, 60 }, { 1, 3, 5, 7, 9 }, { 0 }, {}
        };

        int[][] expectedArrays = {
                { 2, 3 }, {}, { 2 }, { 20, 30, 40 }, {},
                { 8, 9, 10 }, { 60 }, { 3, 5, 7, 9 }, {}, {}
        };

        for (int i = 0; i < testArrays.length; i++) {
            Node head = createList(testArrays[i]);
            Node result = deleteFirst(head);
            Node expected = createList(expectedArrays[i]);
            if (compareLists(result, expected)) {
                passed++;
            }
        }

        System.out.println("Delete First tests: " + passed + "/10 passed\n");
        return passed;
    }

    private static int runDeleteLastTests() {
        System.out.println("Testing Delete Last...");
        int passed = 0;

        int[][] testArrays = {
                { 1, 2, 3 }, { 5 }, { 1, 2 }, { 10, 20, 30 }, { 100 },
                { 7, 8, 9 }, { 50, 60, 70 }, { 1, 3, 5 }, { 0 }, {}
        };

        int[][] expectedArrays = {
                { 1, 2 }, {}, { 1 }, { 10, 20 }, {},
                { 7, 8 }, { 50, 60 }, { 1, 3 }, {}, {}
        };

        for (int i = 0; i < testArrays.length; i++) {
            Node head = createList(testArrays[i]);
            Node result = deleteLast(head);
            Node expected = createList(expectedArrays[i]);
            if (compareLists(result, expected)) {
                passed++;
            }
        }

        System.out.println("Delete Last tests: " + passed + "/10 passed\n");
        return passed;
    }
}
