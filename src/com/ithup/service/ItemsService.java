package com.ithup.service;

import java.util.List;

import com.ithup.pojo.Items;
import com.ithup.pojo.ItemsVo;

public interface ItemsService {
	/**
	 * ��ѯ������Ʒ��Ϣ
	 * @return
	 * @throws Exception
	 */
	public List<Items> findAllItems() throws Exception;

	public Items findItemsById(Integer id) throws Exception;

	public boolean updateItem(Items item) throws Exception;

	public List<Items> searchLikeItems(ItemsVo itemsVo) throws Exception;

}
