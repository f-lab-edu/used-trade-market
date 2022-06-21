package com.market.dao;

import com.market.dto.ItemDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemDAO {
    public void registerItem(ItemDTO itemDTO);

    public List<ItemDTO> showItemList();

    public ItemDTO getItemSelectOne(Long itemNo);
}
