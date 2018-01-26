package com.shopmall.web.services;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.shopmall.web.controllers.ShopController;
import com.shopmall.web.domains.Command;
import com.shopmall.web.domains.DetailImageDTO;
import com.shopmall.web.domains.Retval;
import com.shopmall.web.domains.ShopDTO;
import com.shopmall.web.mappers.ShopMapper;

@Service
@Lazy
public class ShopServiceImpl implements ShopService {
	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	@Autowired SqlSession sqlSession;
	@Autowired ShopDTO shop;
	@Autowired ShopMapper ShopMapper;
	@Autowired Retval retval;
	
	@Override
	public List<ShopDTO> selectDesc() {
		ShopMapper mapper  = sqlSession.getMapper(ShopMapper.class);
		return mapper.selectDesc();
	}

	@Override
	public List<ShopDTO> selectGenere() {
		ShopMapper mapper = sqlSession.getMapper(ShopMapper.class);
		return mapper.selectGenre();
	}

	@Override
	public ShopDTO selectOneSeq(Command command) {
		ShopMapper mapper = sqlSession.getMapper(ShopMapper.class);
		return mapper.selectOneSeq(command);
	}

	@Override
	public int countImage(Command command) {
		ShopMapper mapper = sqlSession.getMapper(ShopMapper.class);
		return mapper.countImage(command);
	}

	@Override
	public List<DetailImageDTO> selectDetailImage(Command command) {
		ShopMapper mapper = sqlSession.getMapper(ShopMapper.class);
		return mapper.selectDetailImage(command);
	}

	@Override
	public List<ShopDTO> selectGenreDesc() {
		ShopMapper mapper = sqlSession.getMapper(ShopMapper.class);
		return mapper.selectGenreDesc();
	}

	@Override
	public List<ShopDTO> selectAll() {
		ShopMapper mapper = sqlSession.getMapper(ShopMapper.class);
		return mapper.selectAll();
	}

	@Override
	public List<ShopDTO> selectSearchAll(Command command) {
		ShopMapper mapper = sqlSession.getMapper(ShopMapper.class);
		return mapper.selectSearchAll(command);
	}

	@Override
	public List<ShopDTO> genre(Command command) {
		ShopMapper mapper = sqlSession.getMapper(ShopMapper.class);
		return mapper.genre(command);
	}

	@Override
	public int count(Command command) {
		ShopMapper mapper = sqlSession.getMapper(ShopMapper.class);
		return mapper.count(command);
	}

	@Override
	public ShopDTO readBuy(Command command) {
		ShopMapper mapper = sqlSession.getMapper(ShopMapper.class);
		return mapper.readBuy(command);
	}

	@Override
	public int checkCount(Command command) {
		ShopMapper mapper = sqlSession.getMapper(ShopMapper.class);
		return mapper.checkCount(command);
	}
		
}
