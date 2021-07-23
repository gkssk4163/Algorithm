package SWEA.하계_대학생_SW_알고리즘_특강.연결리스트.SWEA_12304_기초_Double_Linked_List_연습;

class Node {
	public int data;
	public Node prev;
	public Node next;

	public Node(int data) {
		this.data = data;
		this.prev = null;
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
		Node first = getNode(data);	// head 에 추가될 노드
		Node next = head.next;	// head 다음 노드
		// head 와 새로 추가된 노드끼리 연결
		head.next = first;
		first.prev = head;
		// 새로 추가된 노드와 next와 연결
		if (next != null) {
			first.next = next;
			next.prev = first;
		}
	}

	public void addNode2Tail(int data) {
		Node cur = head;
		while (cur.next != null) {
			cur = cur.next;
		}
		// 마지막노드와 새로 추가된 노드연결
		Node node = getNode(data);
		cur.next = node;
		node.prev = cur;
	}

	public void addNode2Num(int data, int num) {
		Node prev = head;
		for (int i = 1; i < num; i++) {
			prev = prev.next;
		}
		Node next = prev.next;
		Node node = getNode(data);
		prev.next = node;
		node.prev = prev;
		if (next != null) {
			node.next = next;
			next.prev = node;
		}
	}

	public int findNode(int data) {
		Node cur = head.next;
		int idx = 1;
		while (cur != null) {
			if (cur.data == data) {
				break;
			}
			cur = cur.next;
			idx++;
		}
		return idx;
	}

	public void removeNode(int data) {
		Node cur = head.next;
		while (cur != null) {
			if (cur.data == data) {
				cur.prev.next = cur.next;
				if (cur.next != null) {
					cur.next.prev = cur.prev;
				}
				break;
			}
			cur = cur.next;
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

	public int getReversedList(int[] output) {
		Node cur = head.next;
		while (cur.next != null) {
			cur = cur.next;
		}

		int idx = 0;
		while (cur != head) {
			output[idx] = cur.data;
			cur = cur.prev;
			idx++;
		}
		return idx;
	}
}