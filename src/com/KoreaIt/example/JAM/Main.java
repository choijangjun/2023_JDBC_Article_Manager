package com.KoreaIt.example.JAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		
		List<Article> articles = new ArrayList<>();
		
		int lastArticleId = 0;
		
		System.out.println("==프로그램 시작==");
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.printf("명령어) ");
			String cmd = sc.nextLine().trim();
			
			if(cmd.equals("article write")) {
				System.out.println("==게시물 작성==");
				
				int id = lastArticleId +1;
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();
				
				Article article = new Article(id, title, body);
				
				articles.add(article);
				
				lastArticleId++;
				
				System.out.printf("%d번 글이 생성되었습니다\n",id);
				
			}else if(cmd.equals("article list")) {
				System.out.println("==게시물 목록==");
				
				if (articles.size() == 0) {
					System.out.println("게시물이 없습니다.");
					continue;
				}
				
				System.out.println("번호	|	제목");
				for (Article article : articles) {
					System.out.printf("%d	|	%s\n", article.id, article.title);
					
				}
			}else if(cmd.equals("exit")) {
				break;
			}else {
				System.out.println("존재하지 않는 명령어 입니다");
			
			}
			
			
		}
		System.out.println("==프로그램 종료==");
	}
}
