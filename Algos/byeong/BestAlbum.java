import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
 
// 고유 번호(idx)와 재생 횟수(plays)를 가진 Song 클래스 생성
public class Song implements Comparable<Song> {
    public int idx;
    public int plays;
    public Song(int idx, int plays) {
        this.idx = idx;
        this.plays = plays;
    }
 
    //재생 횟수(plays) 큰 것이 더 크도록, 재생 횟수가 같다면 idx를 비교하여 더 낮은 것이 크도록 설정
    @Override
    public int compareTo(Song o) {
        if (this.plays == o.plays) {
            if (this.idx > o.idx) {
                return 1;
            } else {
                return -1;
            }
        } else if (this.plays < o.plays) {
            return 1;
        } else {
            return -1;
        }
    }
}
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        //장르의 순위 결정을 위한 Hash 생성
        HashMap<String, Integer> rankHash = new HashMap<String, Integer>();
        for (int i = 0; i < plays.length; i++) {
            rankHash.put(genres[i], rankHash.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        //장르 순위 판별을 위한 우선순위 큐 생성 (java에서 int형 우선순위 큐는 작은 것 부터 나오므로 lamda식을 이용해 역순으로 변환)
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x, y) -> y - x);
        for (Integer value : rankHash.values()) {
            pq.add(value);
        }
        
        //모든 장르는 재생된 횟수가 다르므로 rankHash의 Key, Value를 바꾼 HashMap 생성
        HashMap<Integer, String> rankHashReverse = new HashMap<Integer, String>();
        for (String key : rankHash.keySet()) {
            rankHashReverse.put(rankHash.get(key), key);
        }
 
        //장르의 재생 횟수를 이용하여 가장 높은 장르부터 rankArr에 순서대로 저장(장르의 순위 선정 완료)
        int uniqueGenreLength = pq.size();
        String[] rankArr = new String[uniqueGenreLength];
        for (int i = 0; i < uniqueGenreLength; i++) {
            rankArr[i] = rankHashReverse.get(pq.poll());
        }
        
        
        //장르의 순위는 정해졌으니 각 노래의 1,2위를 뽑기 위한 HashMap 생성
        HashMap<String, PriorityQueue<Song>> songsRank = new HashMap<String, PriorityQueue<Song>>();
        for (int i = 0; i < plays.length; i++) {
            if (songsRank.containsKey(genres[i])) {
                songsRank.get(genres[i]).add(new Song(i, plays[i]));
            } else {
                songsRank.put(genres[i], new PriorityQueue<Song>());
                songsRank.get(genres[i]).add(new Song(i, plays[i]));
            }
        }
        
        //정답리스트를 만들고 rankArr에 저장한 장르 순서대로 우선순위 큐에서 우선 순위가 높은 Song 하나씩 뽑아서 idx 저장
        ArrayList<Integer> answerArrList = new ArrayList<Integer>();
        for (int i = 0; i < rankArr.length; i++) {
            answerArrList.add(songsRank.get(rankArr[i]).poll().idx);
            //해당 장르에 한 곡이 전부라면 if 문 통과
            if (songsRank.get(rankArr[i]).peek() != null) {
                answerArrList.add(songsRank.get(rankArr[i]).poll().idx);
            }
        }
        
        //정답 리스트를 Array 형태로 변환 .toArray()는 Object[] 형태로 나오므로 int[] 형태로 바꾸어줌
        int[] answerArr = new int[answerArrList.size()];
        Object[] answerArrObj = answerArrList.toArray();
        for (int i = 0; i < answerArrObj.length; i++) {
            answerArr[i] = (int) answerArrObj[i];
        }
        
        return answerArr;
    }
}
