package Java_Algo;

// Study this solution

public class ReverseListBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        // Empty list
        if (head == null) {
            return null;
        }

        // Move the two pointers until they reach the proper starting point
        // in the list.
        ListNode currentNode = head,
            prev = null;

        while (left > 1) {
            prev = currentNode;
            currentNode = currentNode.next;
            left--;
            right--;
        }

        // The two pointers that will fix the final connections.
        ListNode connection = prev,
            tail = currentNode;

        // Iteratively reverse the nodes until n becomes 0.
        ListNode nextNode = null;
        while (right > 0) {
            nextNode = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = nextNode;
            right--;
        }

        // Adjust the final connections as explained in the algorithm
        if (connection != null) {
            connection.next = prev;
        } else {
            head = prev;
        }

        tail.next = currentNode;
        return head;
    }

    public static void main(String[] args) {
        ReverseListBetween reverseList = new ReverseListBetween();

        ListNode list = new ListNode(7,
            new ListNode(8,
                new ListNode(9,
                    new ListNode(10,
                        new ListNode(11)
                    )
                )
            )
        );

        ListNode result = reverseList.reverseBetween(list, 2, 4);
        System.out.println("result: " + result);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public String toString() {
        return "ListNode { " + "val: " + this.val + ", " + "next: " + this.next + " }";
    }
}

