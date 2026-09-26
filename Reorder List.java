class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { 
        val = x; 
    }
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        ListNode curr = this;
        while (curr != null) {
            sb.append(curr.val).append(",");
            curr = curr.next;
        }
        return sb.toString();
    }
    public static ListNode deserialize(String data) {
        if (data == null || data.isEmpty() || data.equals("[]")) return null;
        data = data.replaceAll("[\\[\\] ]", "");
        String[] values = data.split(",");
        ListNode head = new ListNode(Integer.parseInt(values[0]));
        ListNode curr = head;
        for (int i = 1; i < values.length; i++) {
            if (!values[i].isEmpty()) {  
                curr.next = new ListNode(Integer.parseInt(values[i]));
                curr = curr.next;
            }
        }
        return head;
    }
}
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode firstHalf = head;
        ListNode secondHalf = slow.next;
        slow.next = null; 
        secondHalf = reverseList(secondHalf);
        mergeLists(firstHalf, secondHalf);
    }
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev; 
    }
    private void mergeLists(ListNode first, ListNode second) {
        ListNode head = first;
        ListNode temp;
        while (second != null) {
            temp = first.next;
            first.next = second;
            first = temp;
            if (first == null) break;
            temp = second.next;
            second.next = first;
            second = temp;
        }
    }
}
