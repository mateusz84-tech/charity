package pl.coderslab.charity.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "donations")
@Getter @Setter @ToString @EqualsAndHashCode
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    @OneToMany
    @JoinColumn(name = "categoryId")
    private List<Category> category;
    @ManyToOne
    @JoinColumn(name = "institutionId")
    private Institution institution;
    private String  street;
    private String city;
    private String zipCode;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComments;

    public Donation() {
    }
}
