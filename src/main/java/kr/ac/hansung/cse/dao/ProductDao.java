package kr.ac.hansung.cse.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.cse.model.Product;

@Repository
public class ProductDao {
	// dao가 jdbc템플릿사용할때 dataSource를 주입을 받아야해
	private JdbcTemplate jdbcTemplate;

	// @Autowired라는게 xml에서 같은 타입이 있으면 묶어주는거임.
	// dao-context.xml에 <bean id="dataSource" 요로케 되어있는게 있음
	// 이게 주입되는거임.
	@Autowired
	public void setDataSource(DataSource dataSource) {
		// 실질적으로 jdbcTemplate가 생성되는곳, 생성된 템플릿은 컨테이너가 관리하지는 않음
		// dao-context.xml에 <bean id="dataSource" 이 부분이 datasource에 들어가면서 생성
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Product> getProducts() {
		// db에서 쿼리를 진행할 sql문을 만들었다.

		String sqlStatement = "select * from product";
		// 레코드 형태로 들어오는데 그거를 object 형식으로 바꿔줘야함.
		// 그걸 RowMapper의 mapRow함수가 해
		return jdbcTemplate.query(sqlStatement, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

				Product product = new Product();

				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setCategory(rs.getString("category"));
				product.setPrice(rs.getInt("price"));
				product.setManufacturer(rs.getString("manufacturer"));
				product.setUnitInStock(rs.getInt("unitInStock"));
				product.setDescription(rs.getString("description"));

				return product;
			}

		});
	}

	// 상품 추가!
	public boolean addProduct(Product product) {

		String name = product.getName();
		String category = product.getCategory();
		int price = product.getPrice();
		String manufacturer = product.getManufacturer();
		int unitInStock = product.getUnitInStock();
		String description = product.getDescription();

		String sqlStatement = "insert into product (name, category, price, manufacturer, unitInstock, description) values(?,?,?,?,?,?)";

		// 업데이트하면 리턴값이 몇개가 넘어왔는지 떠 int값.
		// 우리는 지금 하나의 레코드만 업데이트할거니까 성공적으로 업데이트가 되면 1이 출력되겠지?
		// 그러면 1이면 true 아니면 false가 나올거야!
		return (jdbcTemplate.update(sqlStatement,
				new Object[] { name, category, price, manufacturer, unitInStock, description }) == 1);

	}

	public boolean deleteProduct(int id) {

		String sqlStatement = "delete from product where id =?";
		// 아래 리턴값이 성공이면 true(1)임. 그걸 1이랑 비교하면 같으니까 true
		// 실패하면 false(0)이고 그걸 1이랑 비교하면 다르니까 false
		return (jdbcTemplate.update(sqlStatement, new Object[] { id }) == 1);
	}

	public Product getProductById(int id) {
		// db에서 쿼리를 진행할 sql문을 만들었다.
		//특정한 id를 가진 레코드 나와라
		String sqlStatement = "select * from product where id =?";
		// 레코드 형태로 들어오는데 그거를 object 형식으로 바꿔줘야함.
		// 그걸 RowMapper의 mapRow함수가 해
		// 하나의 레코드를 가져오는경우 query보다 queryForObject 더 낫다.
		// 저기 ?들어갈 파라미터 값을 리턴함
		return jdbcTemplate.queryForObject(sqlStatement, new Object[] { id },new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

				Product product = new Product();

				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setCategory(rs.getString("category"));
				product.setPrice(rs.getInt("price"));
				product.setManufacturer(rs.getString("manufacturer"));
				product.setUnitInStock(rs.getInt("unitInStock"));
				product.setDescription(rs.getString("description"));

				return product;
			}

		});
	}

	public boolean updateProduct(Product product) {
		//인자로 들어온 product를 통해 id값을 먼저 알아낸다.
		int id=product.getId();
		
		String name = product.getName();
		String category = product.getCategory();
		int price = product.getPrice();
		String manufacturer = product.getManufacturer();
		int unitInStock = product.getUnitInStock();
		String description = product.getDescription();
		//해당 id를 가진 레코드를 업데이트한다는거임
		String sqlStatement = "update product "
							+ "set name=?, category=?, price=?, manufacturer=?, unitInstock=?, description=?"
							+ " where id=?";

		// 우리는 지금 하나의 레코드만 업데이트할거니까 성공적으로 업데이트가 되면 1이 출력되겠지?
		// 그러면 1이면 true 아니면 false가 나올거야!
		return (jdbcTemplate.update(sqlStatement,
				new Object[] { name, category, price, manufacturer, unitInStock, description, id }) == 1);


	}

}
