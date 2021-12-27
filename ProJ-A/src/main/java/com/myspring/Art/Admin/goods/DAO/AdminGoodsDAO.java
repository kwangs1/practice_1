package com.myspring.Art.Admin.goods.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

public interface AdminGoodsDAO {

	int insertNewGoods(Map newGoodsMap) throws DataAccessException;

	void insertGoodsImageFile(List fileList) throws DataAccessException;

}
