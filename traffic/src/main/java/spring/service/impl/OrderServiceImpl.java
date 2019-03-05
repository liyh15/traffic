package spring.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.MapperOrder;
import entity.Order;
import spring.mapper.OrderMapper;
import spring.service.IOrderService;
/**
 * 订单服务层实现类
 * @author 李元浩
 *
 */
@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderMapper orderMapper;
    /**
     * 通过订单编号获得订单
     */
	public Order getOrderByOrderId(Integer id) {
		MapperOrder mapperOrder = orderMapper.getOrderByOrderId(id);
		Order order = changeMapperOrderToOrder(mapperOrder);		
		return order;
	}
	
	/**
	 * 将MapperOrder类转化为Order类
	 * @return
	 */
	private Order changeMapperOrderToOrder(MapperOrder mapperOrder){
		Order order = new Order();
		order.setId(mapperOrder.getId());
		order.setUserId(mapperOrder.getUserId());
		order.setStatus(mapperOrder.getStatus());
		order.setTrafficDateArrangeId(mapperOrder.getTrafficDateArrangeId());
		order.setTotlePrice(mapperOrder.getTotlePrice().split(","));
		order.setPassengerId(changeStringToInteger(mapperOrder.getPassengerId().split("&")));
		order.setType(mapperOrder.getType());
		order.setExplain(mapperOrder.getOexplain().split("&"));
		order.setReservation(mapperOrder.getReservation());;
		order.setReturnPrice(mapperOrder.getReturnPrice());
		order.setdAddress(mapperOrder.getDistributionAddress());
		order.setContactPhone(mapperOrder.getContactPhone());
		order.setCreateTime(mapperOrder.getCreateTime());
		return order;
	}
	
	/**
	 * 将String类型数组转化为Integer类型数组
	 * @return
	 */
	private Integer[] changeStringToInteger(String [] str){
		Integer [] integers = new Integer[str.length];
	    for(int i = 0;i < str.length;i++){
	    	integers[i] = Integer.parseInt(str[i]);
	    }
		return integers;
	}
}




