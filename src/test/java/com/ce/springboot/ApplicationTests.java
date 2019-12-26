package com.ce.springboot;

import com.ce.springboot.dao.*;
import com.ce.springboot.pojo.*;
import com.ce.springboot.service.MyUserService;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
    private AdminuserDao adminuserDao;
    @Autowired
    private ClientDao clientDao;
    @Autowired
    private ContactmanDao contactmanDao;

    private List<OrderResult> orderres = new ArrayList<>();


    @Test
    public void CC() {
        List<Contactman> contactman = contactmanDao.getContactman();
        for (Contactman contactman1 : contactman) {
            System.out.println("contactman1 = " + contactman1);
        }
    }


    @Test
    public void OO() {
        List<Good> goods = goodDao.selectAllGood();
        for (Good good : goods) {
            System.out.println("good = " + good);
        }
    }

    @Test
    public void OOO() {
        List<Client> clients = clientDao.selectClient();
        for (Client client : clients) {
            System.out.println("client = " + client);
        }
    }

    @Test
    public void iiiccc() {
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
    public void ooosss() {
        List<Order> orders = orderDao.selectOrder();
        for (Order order : orders) {
            System.out.println("order = " + order);
        }
    }

    @Test
    public void ooossoo() {
        Order2 order2 = new Order2("sd123124", 12343212,
                "sas", "sdas", "das", "sdasd",
                "dasd", "das", "adsas", "vsd",
                "sad", "dasd", new Date(), null

        );
        int i = orderDao2.insert(order2);
        System.out.println("i = " + i);
    }


    @Test
    public void lofinini() {
        Adminuser admin = adminuserDao.selectByUsername("admin");
        System.out.println("admin = " + admin);
    }

    @Test
    public void Useruuu() {
        Adminuser user = adminuserDao.selectByUsername("admin");
        System.out.println(user.getPerm());
        System.out.println(user.getPassword());
    }


    @Test
    public void mmmm() {

        Adminuser user = adminuserDao.selectByUsername("admin");

        if (StringUtils.isNotBlank(user.getPerm())) {
            String[] roles = user.getPerm().split(",");
            for (String role : roles) {
                if (StringUtils.isNotBlank(role)) {
//							authorities.add(new SimpleGrantedAuthority(role.trim()));
                    System.out.println("role = " + role.trim());

                }
            }
        }
    }


    @Test
    public void Passweoirhfn() {
        System.out.println(new BCryptPasswordEncoder().encode("123456").length());
    }

    @Autowired
    private MyUserService myUserService;

    @Test
    public void mmmsdnc() {
        UserDetails admin = myUserService.loadUserByUsername("admin");
        System.out.println("admin = " + admin);
    }

    @Test
	public void sdfsdf(){
		String pwd = new BCryptPasswordEncoder().encode("1");
		System.out.println("pwd = " + pwd);
	}

	@Test
    public void sdfoasd(){
        int sf12312 = orderGoodDao.deleteByKey("sf12312", 4);
        System.out.println("sf12312 = " + sf12312);
    }
    @Test
    public void sdfhjd(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("namezh","大");
        List<Client> clients = clientDao.searchClient(map);
        for (Client client1 : clients) {
            System.out.println("client1 = " + client1);
        }
    }

    @Test
    public void madkfn(){
        HashMap<String,String> map = new HashMap<>();
        map.put("company","大");
        List<Order> orders = orderDao.fuzzselect(map);
        for (Order order : orders) {
            System.out.println("order = " + order);
        }
    }
    @Test
    public void sdfhnoi(){
        int i = contactmanDao.numOfContactman(12345678);
        System.out.println("i = " + i);
    }

    @Test
    public void asdfnk(){
        int id = 665542;
        Contactman contactman = contactmanDao.selectById(id);
        int company = contactman.getCompany();
        int i = contactmanDao.numOfContactman(company);
        if( i> 1){
            System.out.println("sdsd");
        }else{
            System.out.println("nnnn");
        }
    }
    @Test
    public void sdfhnojsdkf(){
        int base_li = adminuserDao.userexist("base_li");
        System.out.println("base_li = " + base_li);
    }
    @Test
    public void sdfjoisdfn(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("goodname","梨");

        List<Good> fuzzsearch = goodDao.fuzzsearch(map);
        System.out.println("fuzzsearch = " + fuzzsearch);
    }
}


