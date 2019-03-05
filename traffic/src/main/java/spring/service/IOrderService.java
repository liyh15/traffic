package spring.service;

import entity.Order;

/**
 * 订单服务层接口
 * @author 李元浩
 *
 */
public interface IOrderService {
    
	public Order getOrderByOrderId(Integer id);
}
