package com.shopmall.web.controllers;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.shopmall.web.constants.Values;
import com.shopmall.web.domains.Command;
import com.shopmall.web.domains.Retval;
import com.shopmall.web.domains.ShopDTO;
import com.shopmall.web.services.ShopServiceImpl;
import com.shopmall.web.util.Pagination;

@Controller
@Lazy
@SessionAttributes({"price", "user", "context", "css", "img", "js","temp"})
@RequestMapping("/shop")
public class ShopController {
	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	@Autowired ShopDTO shop;
	@Autowired ShopServiceImpl service;
	@Autowired Command command;
	@Autowired Retval retval;
	
	@RequestMapping("/buy")
	public String goBuy(){
		logger.info("shopController : {}", "goBuy");
		return "public:shop/buy.tiles";
	}
	
	@RequestMapping("buyFin")
	public String goBuyFin() {
		logger.info("shopController : {}", "goBuyFin");
		return "public:shop/buy_fin.tiles";
	}
	
	@RequestMapping("/selectDesc")
	public @ResponseBody HashMap<String, Object> selectDesc(){
		logger.info("ShopController GO TO {}", "selectDesc");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", service.selectDesc());
		return map;
	}
	
	@RequestMapping("/selectGenre")
	public @ResponseBody HashMap<String, Object> selectGenre(){
		logger.info("shopController GO TO {}",  "selectGenre");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", service.selectGenere());
		return map;
	}

	@RequestMapping("selectGenreDesc/{keyword}")
	public @ResponseBody HashMap<String, Object> selectGenreDesc(@RequestParam String keyword){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", service.selectGenreDesc());
		return map;
	}
	
	@RequestMapping("/selectOneSeq/{keyword}")
	public String selectOneSeq(@PathVariable String keyword, Model model){
		logger.info("shopController GO TO {}", "selectOneSeq");
		command.setKeyword(keyword);
		shop = service.selectOneSeq(command);
		
		model.addAttribute("seq", shop.getSeq());
		model.addAttribute("title", shop.getTitle());
		model.addAttribute("price", shop.getPrice());
		model.addAttribute("count", shop.getCount());
		model.addAttribute("detail", shop.getDetail());
		model.addAttribute("genre", shop.getGenre());
		model.addAttribute("genre_eng", shop.getGenre_eng());
		model.addAttribute("image", shop.getImage());
		return "public:shop/detail.tiles";
	}
	
	@RequestMapping("/readBuy")
	public @ResponseBody ShopDTO readBuy(@RequestParam int seq){
		logger.info("shopController : {}", "readBuy");
		command.setSeq(seq);
		shop = service.readBuy(command);
		return shop; 
	}
	
	@RequestMapping("/selectAll")
	public @ResponseBody HashMap<String, Object> selectAll(){
		logger.info("shopController GO TO {}", "selectAll");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", service.selectAll());
		return map;
	}
	
	@RequestMapping("/selectSearchAll/{keyField}/{keyword}")
	public @ResponseBody HashMap<String, Object> selectSearchAll(@PathVariable String keyField, @PathVariable String keyword){
		logger.info("shopController GO TO {}", "selectSerachAll");
		logger.info("shopController keyField {}", keyField);
		logger.info("shopController keyword {}", keyword);
		command.setKeyField(keyField);
		command.setKeyword(keyword);
		
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("list", service.selectSearchAll(command));
		return map;
	}
	
	@RequestMapping("/countImage/{seq}")
	@ResponseBody	//404 에러로 인한 어노테이션
	public Retval countImage(@PathVariable int seq){
		logger.info("shopController GO TO {}", "countImage");
		command.setSeq(seq);
		retval.setCount(service.countImage(command));
		return retval;
	}
	
	@RequestMapping("/selectDetailImage/{seqSellList}")
	@ResponseBody	//404 에러로 인한 어노테이션
	public HashMap<String, Object> selectDetailImage(@PathVariable int seqSellList){
		logger.info("shopController GO TO {}", "selectDetailImage");
		HashMap<String, Object> map = new HashMap<String, Object>(); 
		command.setSeq(seqSellList);
		map.put("list", service.selectDetailImage(command));
		return map;
	}
	
	@RequestMapping("/goGenre/{keyword}/{pgNum}")
	public String goGenre(@PathVariable String keyword, @PathVariable String pgNum, Model model){
		logger.info("shopController GO TO {}", "goGenre");
		command.setKeyField("genre_eng");
		command.setKeyword(keyword);
		model.addAttribute("genre", service.selectSearchAll(command).get(0).getGenre());
		return "public:shop/shop.tiles";
	}
	
	@RequestMapping("/genre/{keyword}/{pgNum}")
	@ResponseBody
	public HashMap<String, Object> genre(@PathVariable String keyword, @PathVariable String pgNum){
		logger.info("shopController GO TO {}", "genre");
		command.setKeyword(keyword);
		int totCount = service.count(command);
		int pageSize = Pagination.shopPageSize(totCount);
		int[] pageStartEnd = Pagination.shopGetStartEnd(totCount, pageSize, Integer.parseInt(pgNum));
		command.setStart(pageStartEnd[0]);
		command.setEnd(pageStartEnd[1]);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", service.genre(command));
		map.put("pageSize", Values.SHOP_PG_SIZE);
		map.put("groupSize", Values.SHOP_GROUP_SIZE);
		map.put("totCount", totCount);
		map.put("totPage", pageStartEnd[2]);
		map.put("pgNum", Integer.parseInt(pgNum));
		map.put("startPage", pageStartEnd[3]);
		map.put("endPage", pageStartEnd[4]);
		logger.info("pgNum {}", pgNum);
		return map;
	}
	
	@RequestMapping("/checkCount")
	public @ResponseBody Retval checkCount(@RequestParam int seq) {
		logger.info("shopController GO TO {}", "checkCount");
		command.setSeq(seq);
		retval.setCount(service.checkCount(command));
		return retval;
	}
	
	@RequestMapping("/resultPrice")
	public @ResponseBody Retval resultPrice(HttpSession session, @RequestParam int price) {
		try{
	      InetAddress local = InetAddress.getLocalHost();
	      logger.info(local.getHostAddress() + " total price : {}", price);
	    }catch(Exception e){
	      System.out.println(e.getMessage());
	    }

		retval.setCount(price);
		session.setAttribute("price", retval);
		return (Retval)session.getAttribute("price");
	}
	
	@RequestMapping("/getResultPrice")
	public @ResponseBody Retval getResultPrice(HttpSession session) {
		logger.info("shopController : {}", "getResultPrice");
		return (Retval)session.getAttribute("price");
	}
	
	@RequestMapping("goBuyFinList")
	public String buyFinList() {
		logger.info("shopController : {}", "goBuyFinList");
		return "public:shop/buy_fin.tiles";
	}
	
	@RequestMapping(value="/setBuyList", method=RequestMethod.POST)
	public @ResponseBody Retval setBuyList(@RequestBody String[] buy_arr, Model model) {
		logger.info("shopController : {}", "setBuyList");
		String[] temp = new String[buy_arr.length - 1];
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		for(int i=0; i<=buy_arr.length-2; i++) {
			temp = buy_arr[i].split(",");
			map.put("seq" + temp[i], buy_arr[i]);
		}
		
		map.put("total_price", buy_arr[buy_arr.length - 1]);
		model.addAttribute("buyList", map);
		model.addAttribute("test", 1);
		
		retval.setMsg("set complete");
		return retval;
	}
	
	@RequestMapping("/getBuyList")
	public @ResponseBody HashMap<String, Object> getBuyList(Model model) {
		logger.info("shopController : {}", "getBuyList");
		
		return null;
	}
}
