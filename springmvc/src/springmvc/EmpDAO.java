package springmvc;


import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  
import springmvc.Emp;  

public class EmpDAO {  
JdbcTemplate template;  
static int number;
int minimum=1;
int maximum=5000;
public EmpDAO() {
	number=minimum + (int)(Math.random() * maximum); 
}

public void setTemplate(JdbcTemplate template) {  
  this.template = template;  
}  
public int save(Emp p){  
	number++;
  String sql="insert into emp99 values("+number+",";
  sql=sql+"'"+p.getName()+"',"+p.getSalary()+",'"+p.getDesignation()+"')";
 // sql=sql+'"+p.getName()+"',"+p.getSalary()+",'"+p.getDesignation()+"'";
  return template.update(sql);  
}  
public int update(Emp p){  
  String sql="update Emp99 set name='"+p.getName()+"',salary="+p.getSalary()+",desig='"+p.getDesignation()+"' where id="+p.getId()+"";  
  return template.update(sql);  
}  
public int delete(int id){  
  String sql="delete from Emp99 where id="+id+"";  
  return template.update(sql);  
}  
public Emp getEmpById(int id){  
  String sql="select * from Emp99 where id=?";  
  return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Emp>(Emp.class));  
}  
public List<Emp> getEmployees(){  
  return template.query("select * from Emp99",new RowMapper<Emp>(){  
      public Emp mapRow(ResultSet rs, int row) throws SQLException {  
          Emp e=new Emp();  
          e.setId(rs.getInt(1));  
          e.setName(rs.getString(2));  
          e.setSalary(rs.getFloat(3));  
          e.setDesignation(rs.getString(4));  
          return e;  
      }  
  });  
}  
}