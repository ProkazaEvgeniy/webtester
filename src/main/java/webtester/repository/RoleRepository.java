package webtester.repository;

import webtester.annotation.Delete;
import webtester.annotation.Insert;
import webtester.model.Role;

public interface RoleRepository {

	@Delete(sql="delete from role where id=?")
	int deleteRole(long id);
	
	@Insert(sql="insert into role values(nextval('role_seq'),?)")
	Role save(Role role);
		
}
