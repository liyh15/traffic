package spring.service;

import entity.Order;

/**
 * ���������ӿ�
 * @author ��Ԫ��
 *
 */
public interface IOrderService {
    
	public Order getOrderByOrderId(Integer id);
}
