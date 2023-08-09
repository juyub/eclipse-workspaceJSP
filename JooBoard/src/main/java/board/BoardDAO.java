package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class BoardDAO {
	
	@Autowired
	private DataSource dataSource;
	
	public static final int ITEMS_PER_PAGE = 10;

	public int getTotalPage() {
	    String sql = "SELECT COUNT(*) FROM sj_board";
	    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	    int totalCount = jdbcTemplate.queryForObject(sql, Integer.class);
	    int totalPage = (int) Math.ceil((double)totalCount / ITEMS_PER_PAGE);
	    return totalPage;
	}
	
	public List<BoardVO> getBoardList(int pageNumber) {
	    String sql = 
	    		" SELECT * " +
	    		  " FROM ( SELECT LEVEL, seq, parentSeq, title, content, regDate, writer, hit, ROWNUM AS rnum " +
	    		           " FROM sj_board " +
	    		          " START WITH parentSeq = 0 " +
	    		        " CONNECT BY PRIOR seq = parentSeq " +
	    		          " ORDER SIBLINGS BY seq DESC " +
	    		       " ) " +
	    		 " WHERE rnum BETWEEN (? - 1) * ? + 1 AND ? * ? ";
//	    		" SELECT * " +
//	    		  " FROM ( SELECT ROWNUM AS RNUM, BOARD.* " +
//	    		           " FROM ( SELECT * " +
//	    		                    " FROM sj_board" +
//	    		                   " ORDER BY SEQ DESC" +
//	    		                " ) BOARD " +
//	    		       " ) " +
//	    		 " WHERE RNUM BETWEEN (? - 1) * ? + 1 AND ? * ? ";
	    JdbcTemplate template = new JdbcTemplate(dataSource);
	    List<BoardVO> boardList = template.query(sql, new BeanPropertyRowMapper<>(BoardVO.class), pageNumber, ITEMS_PER_PAGE, pageNumber, ITEMS_PER_PAGE);
	    return boardList;
	}

	public List<BoardVO> getBoardList(){
		String sql = " select * from sj_board order by seq desc ";
		
		// spring JDBC
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(dataSource);
		List<BoardVO> boardList = template.query(sql, new BeanPropertyRowMapper(BoardVO.class));
		
		return boardList;
	}
	
	public BoardVO getBorad(String seq) {
		String sql = " select * from sj_board WHERE seq = ? ";
		
		// spring JDBC
		JdbcTemplate template = new JdbcTemplate(dataSource);
		BoardVO board = template.queryForObject(sql, new BeanPropertyRowMapper<>(BoardVO.class), seq);
		
		return board;
	}
	
	public void addBoard(BoardVO vo) {
		String sql = 
				" insert into sj_board(seq, title, writer, content) " +
		        " values((select nvl(max(seq), 0) + 1 from sj_board), ?, ?, ?) ";
		
	    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	    jdbcTemplate.update(sql, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	public void addReply(BoardVO vo) {
		String sql = 
				" insert into sj_board(seq, parentSeq, title, writer, content) " +
						" values((select nvl(max(seq), 0) + 1 from sj_board), ?, ?, ?, ?) ";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	public void updateBoard(BoardVO vo) {
		String sql = 
				" UPDATE sj_board SET title = ?, content = ? WHERE seq = ? ";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, vo.getTitle(), vo.getContent(), vo.getSeq());
	}

	public void deleteBoard(String seq) {
		String sql = " delete from sj_board WHERE seq = ? ";
		
	    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	    jdbcTemplate.update(sql, seq);
	}
	
	// 게시글 삭제시 댓글 삭제
	public void deleteComment(String seq) {
		String sql =
				" delete sj_comment where seq=? ";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	    jdbcTemplate.update(sql, seq);
	}

}