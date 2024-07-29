package kr.or.ddit.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.BuyprodVO;

@Repository
public class BuyprodDao {
	@Autowired
	SqlSessionTemplate sst;

	public List<BuyprodVO> list(Map<String, Object> map) {
		return this.sst.selectList("buyprod.list", map);
	}

	public int getTotal(Map<String, Object> map) {
		return this.sst.selectOne("buyprod.getTotal", map);
	}
}
