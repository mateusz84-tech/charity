package pl.coderslab.charity.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.domain.model.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query(value = "SELECT SUM(d.quantity) FROM Donation d")
    Long sumQuantity();

//    @Query(value = "SELECT COUNT(d) FROM Donation d")
//    Long sumItem();
}
