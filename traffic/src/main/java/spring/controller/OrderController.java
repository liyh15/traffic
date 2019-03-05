package spring.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Order;
import entity.Passenger;
import entity.TrainArrange;
import entity.TrainDateArrange;
import spring.service.IOrderService;
import spring.service.IPassengerService;
import spring.service.ITrainService;
import staticdate.OrderStaticDate;
/**
 * ������spring���������
 * @author ��Ԫ��
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	
	 @Autowired
	 private IOrderService orderService;
	 @Autowired
	 private ITrainService trainService;
	 @Autowired
	 private IPassengerService passengetService;
	 
	 @RequestMapping(value = "/orderDetailView.do")	 
	 /**
	  * ���ݶ�����Ų�ѯ��������
	  * @param id �������
	  * @param session
	  * @return
	  */
     public String orderDetailView(@RequestParam("id") int id,HttpSession session){	
		 session.removeAttribute("orderList");
		 Order order = orderService.getOrderByOrderId(id);	
		 // ��ȡ������ڰ��ű��
		 Integer tdai = order.getTrafficDateArrangeId();
		 String trafficType = order.getType();
		 if(OrderStaticDate.TRAIN_TYPE.equals(trafficType)){
			 // �����������Ϊ������
			 TrainDateArrange trainDateArrange = trainService.getTrainDateArrangeById(tdai);
			 TrainArrange trainArrange = trainService.getTrainArrangeById(trainDateArrange.getTrainArrangeId());
			 trainArrange.setDate(trainDateArrange.getDay());
			 trainArrange.setEndDate(trainDateArrange.getEndDay());
			 session.setAttribute("TrainArrange", trainArrange);
		 }
		 Integer [] passengerId = order.getPassengerId();
		 // ��ó˿���Ϣ
		 List<Passenger> passengers = passengetService.getPassengersById(passengerId);	
    	 session.setAttribute("passengers", passengers);
    	 session.setAttribute("order", order);   	 
		 return "train_order";
     }
}
