package github.yangllli.springboot_demos.springDataCache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * 缓存
 * 需要CacheManager和@EnableCache
 *
 * 配置@CacheConfig
 * 增删 @CachePut @CacheEvict
 * 增查 @Cacheable  cacheNames/Value(指库名）  key   condition等

 */
@Component
@CacheConfig(cacheNames = "personCache")
public class CacheDemo {
    @Autowired
    private PersonDao personDao;

    @Cacheable
//    key为name  值为person
    public Person getPerson(String name) {
        return personDao.findByName(name);
    }

    @CachePut(key = "#result.id")
//    增加person，key为id
    public Person addPerson(Person person) {
        return personDao.save(person);
    }

    @CacheEvict
//    删除id为id的person
    public void deletePerson(int id) {
        personDao.deleteById(id);
    }
}
