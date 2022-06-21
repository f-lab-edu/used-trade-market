package com.market.service;

import com.market.dto.ItemDTO;

import java.util.List;

public interface ItemService {

    public void registerItem(String registerId, ItemDTO itemDTO);

    public List<ItemDTO> showItemList();

    public ItemDTO getItemSelectOne(Long itemNo);

    public void updateItemInfo(Long ItemNo, ItemDTO itemDTO);

}
