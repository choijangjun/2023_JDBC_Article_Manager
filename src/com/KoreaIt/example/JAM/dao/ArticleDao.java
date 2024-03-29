package com.KoreaIt.example.JAM.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.KoreaIt.example.JAM.util.DBUtil;
import com.KoreaIt.example.JAM.util.SecSql;

public class ArticleDao {

	private Connection conn;
	
	public ArticleDao(Connection conn) {
		this.conn = conn;
	}

	public int doWrite(String title, String body, int loginedMemberId) {
		
		SecSql sql = new SecSql();

		sql.append("INSERT INTO article");
		sql.append("SET regDate = NOW()");
		sql.append(", updateDate = NOW()");
		sql.append(", memberId = ?", loginedMemberId);
		sql.append(", title = ?", title);
		sql.append(", `body` = ?", body);
		 
		return DBUtil.insert(conn, sql);
	}
	
	public List<Map<String, Object>> getArticles(String searchKeyword){
		SecSql sql = new SecSql();

		sql.append("SELECT article.*, member.*");	
		sql.append("FROM article");
		sql.append("inner join `member`");
		sql.append("ON article.memberId = member.id");
		if (searchKeyword.length() > 0) {
			sql.append("WHERE title LIKE CONCAT('%', ?, '%')", searchKeyword);
			
		}
		sql.append("ORDER BY article.id DESC");

		
		return DBUtil.selectRows(conn, sql);
	}

	public Map<String, Object> getArticle(int id) {
		SecSql sql = new SecSql();

		sql.append("SELECT article.*, member.name");
		sql.append("FROM article");
		sql.append("INNER JOIN `member`");
		sql.append("ON article.memberId = member.id");
		sql.append("WHERE article.id = ?;", id);
		
		
		
		
		return DBUtil.selectRow(conn, sql);
	}
	
	public int addviewCount(int id) {
		SecSql sql = new SecSql();

		sql.append("UPDATE article");
		sql.append("SET viewCount = viewCount + 1");
		sql.append("WHERE article.id = ?;", id);
		
		
		
		
		return DBUtil.update(conn, sql);
	}

	public int getArticleCount(int id) {
		SecSql sql = new SecSql();

		sql.append("SELECT COUNT(*)");
		sql.append("FROM article");
		sql.append("WHERE id = ?", id);
		
		return DBUtil.selectRowIntValue(conn, sql);
	}

	public void doModify(String title, String body, int id) {
		SecSql sql = new SecSql();

		sql.append("UPDATE article");
		sql.append("SET updateDate = NOW()");
		sql.append(", title = ?", title);
		sql.append(", `body` = ?", body);
		sql.append("WHERE id = ?", id);
		
		DBUtil.update(conn, sql);
	}

	public void doDelete(int id) {
		SecSql sql = new SecSql();

		sql.append("DELETE FROM article");
		sql.append("WHERE id = ?", id);
		
		DBUtil.delete(conn, sql);
	}

}