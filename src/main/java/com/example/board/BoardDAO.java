package com.example.board;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.board.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class BoardDAO {
    @Autowired
    private JdbcTemplate template;
    public BoardDAO(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }
    private final String BOARD_LIST = "select * from BOARD order by seq desc";

    public int insertBoard(BoardVO vo) {
        String sql = "insert into BOARD (title, writer, content, category) values("
                + "'" + vo.getTitle() + "',"
                + "'" + vo.getWriter() + "',"
                + "'" + vo.getContent() + "',"
                + "'" + vo.getCategory() + "')";
        return template.update(sql);

    }

    public int deleteBoard(int id)
    {
        String sql = "delete from BOARD where seq ="+id;
        return template.update(sql);
    }
    public int updateBoard(BoardVO vo)
    {
        String sql = "update BOARD "
                + "set title='" + vo.getTitle() + "',"
                +" category='"+vo.getCategory() +"',"
                +" writer='"+vo.getWriter() +"',"
                +" content='"+vo.getContent()+"'"
                +" where seq = "+vo.getSeq();
        return template.update(sql);
    }

    public BoardVO getBoard(int seq) {
        String sql = "select * from BOARD where seq = " + seq;
        return template.queryForObject(sql, new BoardRowMapper());
    }

    public List<BoardVO> getBoardList() {
        return template.query(BOARD_LIST, new BoardRowMapper());
     }
    class BoardRowMapper implements RowMapper<BoardVO>{
        @Override
        public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException{
            BoardVO vo = new BoardVO();
            vo.setSeq(rs.getInt("seq"));
            vo.setTitle(rs.getString("title"));
            vo.setWriter(rs.getString("writer"));
            vo.setContent(rs.getString("content"));
            vo.setRegdate(rs.getDate("regdate"));
            vo.setCategory(rs.getString("category"));
            vo.setModdate(rs.getDate("moddate"));
            System.out.println("Controller " + vo);
            return vo;
        }
    }
}