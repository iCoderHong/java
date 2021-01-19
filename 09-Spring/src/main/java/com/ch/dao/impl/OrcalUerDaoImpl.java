package com.ch.dao.impl;

import com.ch.dao.IUserDao;
import com.ch.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Component("OrcalUerDao") 等价 <bean id="OrcalUerDao" class="com.ch.dao.impl.OrcalUerDaoImpl"></bean>
 * @Component("OrcalUerDao")
 * @Component  默认id名 类名首字母小写
 */
@Repository("OrcalUerDaoImpl")
public class OrcalUerDaoImpl implements IUserDao {
    @Override
    public void insertUser(User user) {
        System.out.println("OrcalUerDaoImpl insertUser");
    }
}
