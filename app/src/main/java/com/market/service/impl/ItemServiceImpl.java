package com.market.service.impl;

import com.market.dto.ItemDTO;
import com.market.repository.ItemRepository;
import com.market.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void registerItem(ItemDTO itemDTO, Long memberNo) {
        itemRepository.registerItem(itemDTO, memberNo);
    }

    @Override
    public List<ItemDTO> showItemList(ItemDTO itemDTO) {
        return itemRepository.showItemList(itemDTO);
    }

    @Override
    public ItemDTO getItemSelectOne(Long itemNo) {
        return itemRepository.getItemSelectOne(itemNo);
    }

    @Override
    public void updateItemInfo(Long itemNo, ItemDTO itemDTO) {
        itemRepository.updateItemInfo(itemNo, itemDTO);
    }
}
