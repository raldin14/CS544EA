package accounts.repository;

import accounts.domain.Account;
import accounts.repositories.AccountRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestRepository {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void whenFindByAccountHolder() {

        Account frank = new Account("12345",100,"Frank Brown");
        entityManager.persist(frank);
        entityManager.flush();

        Account found = accountRepository.findByAccountHolder(frank.getAccountHolder());

        assertThat(found.getAccountHolder())
                .isEqualTo(frank.getAccountHolder());
    }

}
