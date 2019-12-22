package com.ce.springboot;

import com.ce.springboot.dao.*;
import com.ce.springboot.pojo.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class ApplicationTests {

		@Autowired
		private OrderDao orderDao;
		@Autowired
		private OrderDao2 orderDao2;
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
		public void CC(){
			List<Contactman> contactman = contactmanDao.getContactman();
			for (Contactman contactman1 : contactman) {
				System.out.println("contactman1 = " + contactman1);
			}
		}



		@Test
	public void OO(){
			List<Good> goods = goodDao.selectAllGood();
			for (Good good : goods) {
				System.out.println("good = " + good);
			}
		}
		@Test
		public void OOO(){
			List<Client> clients = clientDao.selectClient();
			for (Client client : clients) {
				System.out.println("client = " + client);
			}
		}

		@Test
	public void iiiccc(){
//			Client client = new Client("上海的公司","shgs","上攻",
//					"e@e.com","1234564876452341","汇丰银行",
//					12343212,"上海","上海");
//
//			int i = clientDao.insertClient(client);
//			System.out.println("i = " + i);
			Client client = clientDao.selectById(12345678);
			System.out.println("client = " + client);

		}

		@Test
	public void ooosss(){
			List<Order> orders = orderDao.selectOrder();
			for (Order order : orders) {
				System.out.println("order = " + order);
			}
		}
		@Test
	public void ooossoo(){
			Order2 order2 = new Order2("sd123124", 12343212,
					"sas","sdas","das","sdasd",
					"dasd","das","adsas","vsd",
					"sad","dasd",new Date(),null

			);
			int i = orderDao2.insert(order2);
			System.out.println("i = " + i);
		}
		

}


