package com.market.service.impl;

import com.market.dao.ItemDAO;
import com.market.dao.MemberDAO;
import com.market.dto.ItemDTO;
import com.market.dto.MemberDTO;
import com.market.repository.ItemRepository;
import com.market.service.ItemService;
import com.market.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemDAO itemDAO;

    @Autowired
    private MemberService memberService;

    @Override
    public void registerItem(String registerId, ItemDTO itemDTO) {
        MemberDTO memberDTO = memberService.userFindById(registerId);
        itemDTO.setMemberNo(memberDTO.getMemberNo());
        itemDAO.registerItem(itemDTO);
    }

    @Override
    public List<ItemDTO> showItemList() {
        return itemDAO.showItemList();
    }

    @Override
    public ItemDTO getItemSelectOne(Long itemNo) {
        return itemDAO.getItemSelectOne(itemNo);
    }

    @Override
    public void updateItemInfo(Long itemNo, ItemDTO itemDTO) {
        itemRepository.updateItemInfo(itemNo, itemDTO);
    }
}
