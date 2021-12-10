package hospital.hospital.visit.entity;

import hospital.hospital.doctor.entity.Doctor;
import hospital.hospital.recipe.entity.Recipe;
import hospital.hospital.user.entity.User;
import hospital.hospital.visit.models.VisitREQ;
import hospital.hospital.visitType.entity.VisitType;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date date;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "visitType_id")
    private VisitType visitType;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "visit")
    private Set<Recipe> recipes;

    public static Visit of(VisitREQ visitREQ, VisitType visitType, Doctor doctor,User user){
        Visit visit = new Visit();
        visit.setUser(user);
        visit.setDoctor(doctor);
        visit.setDate(visitREQ.getDate());
        visit.setDescription(visitREQ.getDescription());
        visit.setVisitType(visitType);
        return visit;
    }

    public static Visit dto(Visit visit){
        if(visit.getVisitType() != null)visit.getVisitType().setVisits(null);
        if(visit.getDoctor() != null){
            visit.getDoctor().setVisits(null);
            visit.getDoctor().getSpecialisation().forEach(specialisation -> specialisation.setDoctor(null));
        }
        if(visit.getUser() != null) visit.getUser().setVisits(null);
        if(visit.getRecipes() != null) visit.getRecipes().forEach(recipe -> {
            recipe.setVisit(null);
            recipe.setDrugs(null);
            recipe.setUser(null);
            recipe.setDoctor(null);
        });
        return visit;
    }

}