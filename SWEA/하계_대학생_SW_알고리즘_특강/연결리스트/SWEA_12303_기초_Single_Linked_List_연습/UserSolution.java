package SWEA.하계_대학생_SW_알고리즘_특강.연결리스트.SWEA_12303_기초_Single_Linked_List_연습;

class Node {
	public int data;
	public Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class UserSolution {

	private final static int MAX_NODE = 10000;

	private Node[] node = new Node[MAX_NODE];
	private int nodeCnt = 0;
	private Node head;

	public Node getNode(int data) {
		node[nodeCnt] = new Node(data);
		return node[nodeCnt++];
	}

	public void init() {
		head = getNode(-1);
		nodeCnt = 0;
	}

	public void addNode2Head(int data) {
		Node newHead = getNode(data);
		newHead.next = head.next;
		head.next = newHead;
	}

	public void addNode2Tail(int data) {
		Node newTail = getNode(data);
		Node cur = head;
		while (cur.next != null) {
			cur = cur.next;
		}
		cur.next = newTail;
	}

	public void addNode2Num(int data, int num) {
		Node prev = head;
		for (int i = 1; i < num; i++) {
			prev = prev.next;
		}
		Node node = getNode(data);
		node.next = prev.next;
		prev.next = node;
	}

	public void removeNode(int data) {
		Node prev = head;
		while (prev.next != null) {
			Node cur = prev.next;
			if (cur.data == data) {
				prev.next = cur.next;
				break;
			}
			prev = prev.next;
		}
	}

	public int getList(int[] output) {
		Node cur = head.next;
		int idx = 0;
		while (cur != null) {
			output[idx] = cur.data;
			cur = cur.next;
			idx++;
		}
		return idx;
	}
}