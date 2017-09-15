package com.ithup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ithup.dao.ItemsMapper;
import com.ithup.pojo.Items;
import com.ithup.pojo.ItemsExample;
import com.ithup.pojo.ItemsVo;

@Service
public class ItemsServiceImpl implements ItemsService {
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<Items> findAllItems() throws Exception {
		ItemsExample example = new ItemsExample();
		return itemsMapper.selectByExampleWithBLOBs(example );
	}

	@Override
	public Items findItemsById(Integer id) throws Exception {
		return itemsMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean updateItem(Items item) throws Exception {
		int i = itemsMapper.updateByPrimaryKey(item);
		if(i>0){
			return true;
		}
		return false;
	}

	@Override
	public List<Items> searchLikeItems(ItemsVo itemsVo) throws Exception {
		List<Items> items = itemsMapper.selectByItemsVo(itemsVo);
		return null;
	}

}
