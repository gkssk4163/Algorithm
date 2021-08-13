package SWEA.하계_대학생_SW_알고리즘_특강.실전문제.SWEA_12327_Disk_Scheduling;

public class UserSolution {

	private static int MAX = 100000;

	private static int TRACK_SIZE;    // 200 <= TRACK_SIZE <= 100000
	private static int HEAD;    // 0 <= HEAD <= TRACK_SIZE
	private static boolean LOOK_LEFT_DIRECTION;

	private static Track trackHead;	// track Head (입력받은 순서대로 접근)
	private static Track trackTail;	// Track Tail
	private static Track[] tracks;	// track 저장할 동적배열 ( 트랙번호가 index )

	class Track {
		int no;
		Track prev;
		Track next;

		Track(int no) {
			this.no = no;
			this.prev = null;
			this.next = null;
		}
	}

	// track 추가 (맨마지막에 추가)
	void addTrack(Track newTrack) {
		trackTail.next = newTrack;
		newTrack.prev = trackTail;
		trackTail = newTrack;
		tracks[newTrack.no] = newTrack;
	}

	public void init(int track_size, int head) {
		// track 사이즈 및 HEAD 초기화
		TRACK_SIZE = track_size;
		HEAD = head;

		// track 연결리스트 정보 초기화
		trackHead = new Track(-1);
		trackTail = trackHead;

		// track 저장할 동적배열 초기화
		tracks = new Track[MAX+1];

		// LOOK 진행방향 초기화
		LOOK_LEFT_DIRECTION = true;
	}

	public void request(int track) {	// 0 <= track <= TRACK_SIZE
		Track newTrack = new Track(track);
		addTrack(newTrack);
	}

	public int fcfs() {
		Track rmTrack = trackHead.next;
		removeTrack(rmTrack);
		return rmTrack.no;
	}

	public int sstf() {
		int track_no = -1;
		int range = HEAD > TRACK_SIZE - HEAD - 1 ? HEAD : TRACK_SIZE - HEAD - 1;

		for (int i = 0; i < range; i++) {
			int leftIndex = HEAD - i;
			int rightIndex = HEAD + i;
			if (leftIndex > -1 && tracks[leftIndex] != null) {
				track_no = tracks[leftIndex].no;
				break;
			} else if (rightIndex < TRACK_SIZE && tracks[rightIndex] != null) {
				track_no = tracks[rightIndex].no;
				break;
			}
		}
		removeTrackByNo(track_no);
		return track_no;
	}

	public int look() {
		int cur = HEAD;
		int track_no = -1;

		while (true) {
			if (LOOK_LEFT_DIRECTION) {	// 좌측방향
				if (tracks[cur] != null) {
					track_no = tracks[cur].no;
					break;
				}
				cur--;
				if (cur < 0) {
					cur = 0;
					LOOK_LEFT_DIRECTION = false;
				}
			} else {	// 우측방향
				if (tracks[cur] != null) {
					track_no = tracks[cur].no;
					break;
				}
				cur++;
				if (cur >= TRACK_SIZE) {
					cur = TRACK_SIZE-1;
					LOOK_LEFT_DIRECTION = true;
				}
			}
		}
		removeTrackByNo(track_no);
		return track_no;
	}

	public int clook() {
		int cur = HEAD;
		int track_no = -1;

		while (true) {
			if (tracks[cur] != null) {
				track_no = tracks[cur].no;
				break;
			}
			cur--;
			if (cur < 0) cur = TRACK_SIZE - 1;
		}

		removeTrackByNo(track_no);
		return track_no;
	}

	// track 삭제
	void removeTrack(Track rmTrack) {
		// track에서 제거할 트랙 삭제
		rmTrack.prev.next = rmTrack.next;
		if (rmTrack.next != null) rmTrack.next.prev = rmTrack.prev;

		// 제거된 트랙이 마지막 트랙이었으면 trackTail 업데이트
		if (rmTrack.next == null) trackTail = rmTrack.prev;

		// 트랙배열에서 제거
		tracks[rmTrack.no] = null;

		// 삭제된 트랙은 HEAD로 변경
		HEAD = rmTrack.no;
	}

	void removeTrackByNo(int track_no) {
		removeTrack(tracks[track_no]);
	}

}