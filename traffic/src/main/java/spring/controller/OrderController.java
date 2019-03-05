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
 * 订单的spring处理控制器
 * @author 李元浩
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
	  * 根据订单编号查询订单详情
	  * @param id 订单编号
	  * @param session
	  * @return
	  */
     public String orderDetailView(@RequestParam("id") int id,HttpSession session){	
		 session.removeAttribute("orderList");
		 Order order = orderService.getOrderByOrderId(id);	
		 // 获取班次日期安排编号
		 Integer tdai = order.getTrafficDateArrangeId();
		 String trafficType = order.getType();
		 if(OrderStaticDate.TRAIN_TYPE.equals(trafficType)){
			 // 如果订单类型为火车类型
			 TrainDateArrange trainDateArrange = trainService.getTrainDateArrangeById(tdai);
			 TrainArrange trainArrange = trainService.getTrainArrangeById(trainDateArrange.getTrainArrangeId());
			 trainArrange.setDate(trainDateArrange.getDay());
			 trainArrange.setEndDate(trainDateArrange.getEndDay());
			 session.setAttribute("TrainArrange", trainArrange);
		 }
		 Integer [] passengerId = order.getPassengerId();
		 // 获得乘客信息
		 List<Passenger> passengers = passengetService.getPassengersById(passengerId);	
    	 session.setAttribute("passengers", passengers);
    	 session.setAttribute("order", order);   	 
		 return "train_order";
     }
}
