package com.market.dao.impl;

import com.market.dao.ItemDAO;
import com.market.dto.ItemDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDAOImpl implements ItemDAO {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public void registerItem(ItemDTO itemDTO) {
        sqlSession.insert("registerItem",itemDTO);
    }

    @Override
    public List<ItemDTO> showItemList() {
        return sqlSession.selectList("showItemList");
    }

    @Override
    public ItemDTO getItemSelectOne(Long itemNo) {
        return sqlSession.selectOne("getItemSelectOne", itemNo);
    }
}
