package BFSAlgorithm;

import java.io.*;
import java.util.*;

public class Graph {

	private int V;
	private LinkedList<Integer> adj[]; //인접리스트를 호출한다.
	
	Graph(int v){
		V=v;
		adj=new LinkedList[v]; // 인접 리스트 초기화
		for(int i=0; i<v; i++)
		{
			adj[i]=new LinkedList();
		}
	}
	
	void addEdge(int v, int w) { adj[v].add(w); }
	
	void BFS(int s) {
		
		boolean already[] = new boolean[V];
		
		LinkedList<Integer> q=new LinkedList<Integer>();
		
		already[s]=true;
		q.add(s);
		
		while(q.size()!=0)
		{
			s=q.poll();
			System.out.println(s+" ");
			
			Iterator<Integer> i=adj[s].listIterator();
			while(i.hasNext()){
				int n=i.next();
				if(!already[n]){
					already[n] =true;
					q.add(n);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Queue res=new Queue(4);
		
		res.addEdge(0, 1);
		res.addEdge(0, 2);
		res.addEdge(1, 1);
		res.addEdge(1, 2);
		res.addEdge(2, 1);
		res.addEdge(2, 2);
		
		
		res.BFS(2);
	}
}
