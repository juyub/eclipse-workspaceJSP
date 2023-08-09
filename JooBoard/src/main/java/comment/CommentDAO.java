package comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import board.BoardVO;

@Component
public class CommentDAO {
	
	@Autowired
	private DataSource dataSource;

	public List<CommentVO> getCommentListByBoardNO(String seq) {
	    String sql =
	        " SELECT * " +
	        " FROM sj_comment " +
	        " WHERE seq = ? ";

	    JdbcTemplate template = new JdbcTemplate(dataSource);
	    List<CommentVO> commentList = template.query(sql, new BeanPropertyRowMapper<>(CommentVO.class), seq);
		
	    return commentList;
	}
	
	// 댓글 등록
	public void addComment(CommentVO vo) {
		String sql =
				" INSERT INTO sj_comment (commentNO, seq, writer, content) " +
						" VALUES ((select nvl(max(commentNO), 0) + 1 from sj_comment),?, ?, ?) ";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	    jdbcTemplate.update(sql, vo.getSeq(), vo.getWriter(), vo.getContent());
	}
	
	// 댓글 수정
	public void updateComment(CommentVO vo) {
		String sql =
				" update sj_comment " +
						" set content=? where commentNO=? ";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, vo.getContent(), vo.getCommentNO());
	}
	
	// 댓글 삭제
	public void deleteComment(CommentVO vo) {
		String sql =
				" delete sj_comment where commentNO=? ";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	    jdbcTemplate.update(sql, vo.getCommentNO());
	}
	
}

