package com.market.service;

import com.market.dto.ItemDTO;

import java.util.List;

public interface ItemService {

    public void registerItem(ItemDTO itemDTO, Long memberNo);

    public List<ItemDTO> showItemList(ItemDTO itemDTO);

    public ItemDTO getItemSelectOne(Long itemNo);

    public void updateItemInfo(Long ItemNo, ItemDTO itemDTO);
}
