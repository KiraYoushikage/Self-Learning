package component;

import lombok.Data;

@Data
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        System.out.println("dasdas");
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
