package SWEA.하계_대학생_SW_알고리즘_특강.그래프_탐색.SWEA_12317_기초_DFS_연습;

public class UserSolution {

	private static int MAX_ABILITY = 100;
	private static int MAX_CHILD = 5;
	private static int[][] relation;

	public void dfs_init(int N, int[][] path) {
		// path 를 관계로 변경 relation[부모능력][자손index] = 자손능력
		relation = new int[MAX_ABILITY][MAX_CHILD];
		for (int i = 0; i < N-1; i++) {
			int idx = 0;
			while (relation[path[i][0]][idx] != 0) {
				idx++;
			}
			relation[path[i][0]][idx] = path[i][1];
		}
	}

	private static int nextKing;
	public int dfs(int N) {
		nextKing = -1;
		dfs(N, N);
		return nextKing;
	}

	public void dfs(int king, int parent) {
		int idx = 0;
		while (idx < MAX_CHILD && relation[parent][idx] != 0) {
			int child = relation[parent][idx];
			// 왕보다 큰 처음 자손이 다음 왕이 되므로
			// 왕보다 크고 nextKing이 -1 인 경우 다음왕으로 지정해주고 종료한다.
			if (king < child && nextKing == -1) {
				nextKing = child;
				return;
			}
			// 다음왕 조건에 해당되지 않으면 dfs 탐색을 계속한다.
			dfs(king, child);
			idx++;
		}
	}
}