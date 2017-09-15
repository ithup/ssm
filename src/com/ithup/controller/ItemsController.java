package com.ithup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ithup.pojo.Items;
import com.ithup.pojo.ItemsVo;
import com.ithup.service.ItemsService;

@Controller
public class ItemsController {
	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping("/itemsList")
	public ModelAndView itemsList() throws Exception{
		List<Items> allItems = itemsService.findAllItems();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemList", allItems);
		modelAndView.setViewName("itemList");
		return modelAndView;
	}
	
	@RequestMapping("/itemEdit")
	public String itemEdit(Integer id,Model model) throws Exception{
		Items items = itemsService.findItemsById(id);
		model.addAttribute("item", items);
		return "editItem";
	}
	
	@RequestMapping("/updateItem")
	public String updateItem(Items item) throws Exception{
		boolean isUpdate = itemsService.updateItem(item);
		if(isUpdate){
			return "success";
		}
		return "error";
	}
	@RequestMapping("/search")
	public String search(ItemsVo itemsVo) throws Exception{
		List<Items> likeItems = itemsService.searchLikeItems(itemsVo);
		return "success";
	}
}
