package SWEA.하계_대학생_SW_알고리즘_특강.그래프_탐색.SWEA_12318_기초_BFS_연습;

public class UserSolution {

	static int[][] map;
	static int N;

	class xy {
		int x; int y;
		xy(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	class stack<E> {
		E data;
		stack next;

		stack() {
			this.data = null;
			this.next = null;
		}

		void push(E data) {
			stack<E> newOne = new stack<>();
			newOne.data = data;
			newOne.next = this.next;
			this.next = newOne;
		}

		boolean isNull() {
			return this.next == null;
		}

		E pop() {
			E data = (E) this.next.data;
			this.next = this.next.next;
			return data;
		}
	}

	public void bfs_init(int N, int[][] map) {
		this.N = N;
		this.map = new int[11][11];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				this.map[i+1][j+1] = map[i][j] * -1;
			}
		}
	}

	int[][] dr = {{0,-1},{1,0},{0,1},{-1,0}};	// 상,우,하,좌 x,y 이동거리
	public int bfs(int x1, int y1, int x2, int y2) {
		int[][] copyMap = copy(this.map);
		int distance = 1;	// 갈 수 있는 공간(0)과 구분하기 위해 초기거리 1로 설정. 출발지점이 1이 됨

		stack<xy> nextStack = new stack<>();
		stack<xy> stack = new stack<>();
		stack.push(new xy(x1, y1));

		while (!stack.isNull()) {
			xy cur = stack.pop();
			copyMap[cur.y][cur.x] = distance;
			if (cur.x == x2 && cur.y == y2) break;

			for (int i = 0; i < dr.length; i++) {
				int nextX = cur.x + dr[i][0];
				int nextY = cur.y + dr[i][1];
				if (isValid(nextX) && isValid(nextY) && copyMap[nextY][nextX] == 0) {
					nextStack.push(new xy(nextX, nextY));
				}
			}

			if (stack.isNull()) {
				stack = nextStack;
				nextStack = new stack<>();
				distance++;
			}
		}

		return copyMap[y2][x2] - 1;	// 초기거리를 +1 해주어으므로 -1 한 값을 리턴해줌
	}

	private static int[][] copy(int[][] map) {
		int[][] copy = new int[map.length][map.length];
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map.length; j++) {
				copy[i][j] = map[i][j];
			}
		}
		return copy;
	}

	private boolean isValid(int num) {
		return 1 <= num && num <= N;
	}
}