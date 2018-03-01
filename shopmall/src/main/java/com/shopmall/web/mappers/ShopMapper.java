package com.shopmall.web.mappers;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shopmall.web.domains.Command;
import com.shopmall.web.domains.DetailImageDTO;
import com.shopmall.web.domains.Retval;
import com.shopmall.web.domains.ShopDTO;

@Repository
public interface ShopMapper {
	public int count(Command command);
	public List<ShopDTO> selectDesc();
	public List<ShopDTO> selectGenre();
	public List<ShopDTO> selectGenreDesc();
	public List<ShopDTO> selectAll();
	public List<ShopDTO> selectSearchAll(Command command);
	public List<ShopDTO> genre(Command command);
	public ShopDTO selectOneSeq(Command command);
	public ShopDTO readBuy(Command command);
	public int countImage(Command command);
	public List<DetailImageDTO> selectDetailImage(Command command);
	public int checkCount(Command command);
	public int updateCount(Command command);
}
