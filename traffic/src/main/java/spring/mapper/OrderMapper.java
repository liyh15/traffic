package spring.mapper;


import org.apache.ibatis.annotations.Param;

import entity.MapperOrder;
import entity.Order;
/**
 * ������mabatis��mapper��
 * @author ��Ԫ��
 */
public interface OrderMapper {
	
	/**
	 * ͨ��������Ų�ѯָ������
	 * @param id
	 * @return
	 */
    public MapperOrder getOrderByOrderId(@Param("id") Integer id);
}
