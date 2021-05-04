package org.example.repo;

import org.example.data.gen.Bouquet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BouquetRepo {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BouquetRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Map<String, Bouquet> bouquetMap = new HashMap<>();

    public Bouquet select(String name){
        /* Превышен лимит запросов(((
        String query = "SELECT * FROM internet_shop.bouquet WHERE name = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{name}, (resultSet, i) -> new Bouquet(
                resultSet.getInt("id"),
                resultSet.getString("bouquet_name"),
                resultSet.getString("description")));
        */

        return bouquetMap.get(name);
    }

    @PostConstruct
    public void initData(){
        /* Превышен лимит запросов(((
        jdbcTemplate.execute("INSERT INTO internet_shop.bouquet (bouquet_name, description) VALUES ('name1', 'description1')");
        jdbcTemplate.execute("INSERT INTO internet_shop.bouquet (bouquet_name, description) VALUES ('name2', 'description2')");
        jdbcTemplate.execute("INSERT INTO internet_shop.bouquet (bouquet_name, description) VALUES ('name3', 'description3')");
        */
        Bouquet bouquet1 = new Bouquet();
        bouquet1.setName("name1");
        bouquet1.setDescription("description1");
        bouquetMap.put(bouquet1.getName(), bouquet1);

        Bouquet bouquet2 = new Bouquet();
        bouquet2.setName("name2");
        bouquet2.setDescription("description2");
        bouquetMap.put(bouquet2.getName(), bouquet2);

        Bouquet bouquet3 = new Bouquet();
        bouquet3.setName("name3");
        bouquet3.setDescription("description3");
        bouquetMap.put(bouquet3.getName(), bouquet3);
    }
}
