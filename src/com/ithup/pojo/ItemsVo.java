package com.ithup.pojo;

public class ItemsVo {
	private Items items;
	//用做批量删除
	private Integer[] ids;
	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	
}
