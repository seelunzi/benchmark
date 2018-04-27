package cn.kiiwii.framework.mybatis.mapper;

import cn.kiiwii.framework.mybatis.model.Account;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @author tang
 */
public interface TestXmlMapper {

    int addMoney(int userId, float money);

    int minusMoney(int userId, float money);

    @CacheEvict(value = {"indexCache"}, allEntries = true, beforeInvocation = true)
    int insertAccount(Account account);

    @Cacheable(value = "indexCache", key = "'xmlgetAccountById'+#id")
    Account getAccountById(int id);

    @Cacheable(value = "indexCache", key = "'xmlfindAccountsById'+#id")
    List<Account> findAccountsById(int id);
}
