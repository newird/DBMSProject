package generator;

import java.io.Serializable;
import lombok.Data;

/**
 * client
 * @author 
 */
@Data
public class Client implements Serializable {
    private String namezh;

    private String nameen;

    private String namesp;

    private String email;

    private String blankid;

    private String blank;

    private Integer companycode;

    private String province;

    private String city;

    private static final long serialVersionUID = 1L;
}