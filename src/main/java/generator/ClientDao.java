package generator;

import generator.Client;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClientDao {
    int insert(Client record);

    int insertSelective(Client record);
}