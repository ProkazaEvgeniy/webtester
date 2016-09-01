package webtester.repository;

import java.util.List;

import webtester.annotation.Delete;
import webtester.annotation.Insert;
import webtester.annotation.ReturnType;
import webtester.annotation.Select;
import webtester.model.Role;

public interface RoleRepository {

	@Delete(sql="delete from role where id=?")
	int deleteRole(long id);
	
	@Insert(sql="insert into role values(nextval('role_seq'),?)")
	Role save(Role role);
		
	@Select(sql = "select * from role")
	@ReturnType(entityClass = Role.class)
	List<Role> findAll();
}
