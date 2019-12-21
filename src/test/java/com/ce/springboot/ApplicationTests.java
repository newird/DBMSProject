package com.ce.springboot;

import com.ce.springboot.dao.*;
import com.ce.springboot.pojo.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ApplicationTests {

		@Autowired
		private OrderDao orderDao;
		@Autowired
		private OrderGoodDao orderGoodDao;
		@Autowired
		private GoodDao goodDao;
		@Autowired
		private ClientDao clientDao;
		@Autowired
		private ContactmanDao contactmanDao;

		private List<OrderResult> orderres = new ArrayList<>();

		@Test
		public void order() {
			List<Order> orders = orderDao.selectAll();

			for (Order order : orders) {
				OrderResult orderResult = new OrderResult();
				orderResult.setOrder(order);
				int clientId = order.getClient();
				Client client = clientDao.selectById(clientId);
				orderResult.setClient(client);
				List<Integer> goodsId = orderGoodDao.order2good(order.getOrderid());
				List<Good> goods = new ArrayList<>();
				for (Integer goodId : goodsId) {
					goods.add(goodDao.selectByPrimaryKey(goodId));
				}
				orderResult.setGood(goods);
				orderres.add(orderResult);
				System.out.println("goods = " + goods);
			}
		}


		@Test
		public void CC(){
			List<Contactman> contactman = contactmanDao.getContactman();
			for (Contactman contactman1 : contactman) {
				System.out.println("contactman1 = " + contactman1);
			}
		}

		@Test
		public void order(){
			List<Order> orders = orderDao.select();
			for (Order order : orders) {
				System.out.println("order = " + order);
			}
		}

		@Test
		public void Con(){
			List<Client> clients = clientDao.select();
			for (Client client : clients) {
				System.out.println("client = " + client);
			}
		}
		@Test
		public  void insert(){
				Client client= new Client("大连那啥公司", "daliannasha", "大拿", "124@163.com", "1234569632588763", "中国银行", 12345668, "辽宁", "大连");


				Contactman contactman = new Contactman("王三四","秘书","13245678765",2355467,"wer@162.com",123211);
//			contactman.setCompany(client.getCompanycode());
//				clientDao.insert(client);
				contactmanDao.insert(contactman);


			}
}


