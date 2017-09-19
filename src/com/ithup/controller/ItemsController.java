package com.ithup.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ithup.pojo.Items;
import com.ithup.pojo.ItemsVo;
import com.ithup.service.ItemsService;

@Controller
public class ItemsController {
	@Autowired
	private ItemsService itemsService;

	@RequestMapping("/itemsList")
	public ModelAndView itemsList() throws Exception {
		List<Items> allItems = itemsService.findAllItems();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemList", allItems);
		modelAndView.setViewName("itemList");
		return modelAndView;
	}

	@RequestMapping("/itemEdit")
	public String itemEdit(Integer id, Model model) throws Exception {
		Items items = itemsService.findItemsById(id);
		model.addAttribute("item", items);
		return "editItem";
	}

	@RequestMapping("/updateItem")
	public String updateItem(Items item, MultipartFile pictureFile) throws Exception {
		//1. 获取图片完整名称
		String pictureFilename = pictureFile.getOriginalFilename();
		//2. 使用随机生成的字符串+源图片扩展名组成新的图片名称,防止图片重名
		String newFilename = UUID.randomUUID().toString() + pictureFilename.substring(pictureFilename.lastIndexOf("."));
		// 上传图片
		File uploadPic = new File("D:/javaee/imageServer/" + newFilename);
		if (!uploadPic.exists()) {
			uploadPic.mkdirs();
		}
		//3. 将图片保存到硬盘
		pictureFile.transferTo(uploadPic);
		//4.将图片名称保存到数据库
		item.setPic(newFilename);
		boolean isUpdate = itemsService.updateItem(item);
		if (isUpdate) {
			return "success";
		}
		return "error";
	}

	@RequestMapping("/search")
	public String search(ItemsVo itemsVo) throws Exception {
		List<Items> likeItems = itemsService.searchLikeItems(itemsVo);
		return "success";
	}

	@RequestMapping("/deleteAll")
	public String deleteAll(ItemsVo itemsVo) throws Exception {
		Integer[] ids = itemsVo.getIds();
		for (Integer id : ids) {
			System.out.println(id);
		}
		return "success";
	}
}
