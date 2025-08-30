import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;


//유니온파인드 이용
class Main {
	static class UnionFind{
		int[] parent, rank;
		UnionFind(int n){
			parent = new int[n+1];
			rank = new int[n+1];
			for(int i=1;i<=n;i++) parent[i] = i; //makeSet
		}
		
		int findSet(int x) {
			if(parent[x]!=x) parent[x] = findSet(parent[x]);
			return parent[x];
		}
		
		void union(int x, int y) {
			x = findSet(x); y = findSet(y);
			if(x==y) return; //대표자가 같으면 사이클이 있는것. 트리는 사이클 있으면 안됨
			if(rank[x]<rank[y]) parent[x]=y; //y랭크가 더 높으면 y가 대표자가 되도록 합쳐
			else {
				parent[y]=x;
				if(rank[x]==rank[y]) rank[x]++; //두 랭크가 같으면 x 랭크 하나 높여
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] arrList = new ArrayList[V+1];
		for(int i=1;i<=V;i++) {
			arrList[i] = new ArrayList<Integer>();
		}

		UnionFind uf = new UnionFind(V); //정점 개수 V만큼의 부모배열, 랭크배열 만들기
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arrList[a].add(b);
			arrList[b].add(a); //양방향
			uf.union(a,b); //a가 속한 집합과 b가 속한 집합을 합치자 (findSet은 이 함수 안에서 함)
		}
		
		//대표만 확인하자
		HashSet<Integer> set = new HashSet<>();
		for(int i=1;i<=V;i++) {
			set.add(uf.findSet(i));
		}
		
		System.out.println(set.size());
		
	}
}