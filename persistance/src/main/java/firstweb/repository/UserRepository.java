package firstweb.repository;

import org.springframework.stereotype.Repository;
import firstweb.domain.User;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link User}{@link Repository}
 */
@Repository
public class UserRepository {


    private final ConcurrentMap<Integer, User> repository = new ConcurrentHashMap<>();

    private final static AtomicInteger idGenerator = new AtomicInteger();


    /**
     * 保存用户，如果成功，返回<code>true</code>,否则返回<code>false</code>
     *
     * @param user
     * @return
     */
    public boolean save(User user) {
        int id = idGenerator.incrementAndGet();
        user.setId(id);
        return repository.put(id, user) == null;
    }


    public Collection<User> findAll() {
        Collection<User> users = repository.values();
        return users;
    }
}
