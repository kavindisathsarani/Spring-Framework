package lk.ijse.s13_spring_boot.repo;

import lk.ijse.s13_spring_boot.entity.Customer;
import lk.ijse.s13_spring_boot.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {
}
