package spring.configuration;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import spring.dao.AccountDao;

public class PrototypeManager implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public AccountDao getAccountDao(){
        return applicationContext.getBean(AccountDao.class);
    }

}
