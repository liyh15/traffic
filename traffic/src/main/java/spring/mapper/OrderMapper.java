package spring.mapper;


import org.apache.ibatis.annotations.Param;

import entity.MapperOrder;
import entity.Order;
/**
 * 订单的mabatis的mapper层
 * @author 李元浩
 */
public interface OrderMapper {
	
	/**
	 * 通过订单编号查询指定订单
	 * @param id
	 * @return
	 */
    public MapperOrder getOrderByOrderId(@Param("id") Integer id);
}
