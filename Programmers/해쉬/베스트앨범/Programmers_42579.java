package Programmers.해쉬.베스트앨범;

import java.util.*;

public class Programmers_42579 {
	public static void main(String args[]) {
		Solution solution = new Solution();

		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		System.out.println(Arrays.toString(solution.solution(genres, plays)));

		String[] genres2 = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays2 = {300, 300, 300, 300, 300};
		System.out.println(Arrays.toString(solution.solution(genres2, plays2)));

		String[] genres3 = {"classic", "pop"};
		int[] plays3 = {300, 500};
		System.out.println(Arrays.toString(solution.solution(genres3, plays3)));
	}
}

class Solution {
	public int[] solution(String[] genres, int[] plays) {
		List<Integer> playList = new LinkedList<>();

		Map<String, Integer> playCounts = new HashMap<>();
		Map<String, LinkedList<Song>> songs = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			playCounts.put(genres[i], playCounts.getOrDefault(genres[i], 0) + plays[i]);
			LinkedList<Song> songList = songs.getOrDefault(genres[i], new LinkedList<>());
			addSong(songList, new Song(i, plays[i]));
			songs.put(genres[i], songList);
		}

		while (!playCounts.isEmpty()) {
			String key = null;
			int maxCount = 0;
			for (Map.Entry<String, Integer> playCount : playCounts.entrySet()) {
				if (maxCount < playCount.getValue()) {
					maxCount = playCount.getValue();
					key = playCount.getKey();
				}
			}
			playCounts.remove(key);

			LinkedList<Song> songList = songs.get(key);
			for (int i = 0; i < 2; i++) {
				if (i < songList.size()) playList.add(songList.get(i).no);
			}
			songs.remove(key);
		}

		int[] answer = new int[playList.size()];
		for (int i = 0; i < playList.size(); i++) {
			answer[i] = playList.get(i);
		}

		return answer;
	}

	private void addSong(LinkedList<Song> songs, Song newSong) {
		int index = 0;
		while (index < songs.size()) {
			if (newSong.isPlayedMoreThan(songs.get(index))) break;
			index++;
		}
		songs.add(index, newSong);
	}

	class Song {
		int no;
		int playCount;

		public Song(int no, int playCount) {
			this.no = no;
			this.playCount = playCount;
		}

		public boolean isPlayedMoreThan(Song other) {
			if (this.playCount < other.playCount) return false;
			if (this.playCount == other.playCount && this.no > other.no) return false;
			return true;
		}
	}
}