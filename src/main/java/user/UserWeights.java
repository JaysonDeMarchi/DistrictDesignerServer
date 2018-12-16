package user;

import enums.Metric;
import java.io.Serializable;
import java.util.HashMap;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author hqzhu
 */
@Entity
@Table(name = "USER_WEIGHTS")
public class UserWeights implements Serializable {
  
  private String username;
  private Float compactness;
  private Float populationEquality;
  private Float partisanGerrymandering;
  
  public UserWeights(){}
  
  @Id
  @GeneratedValue
  @Column(name = "USERNAME")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Column(name = "COMPACTNESS")
  public Float getCompactness() {
    return this.compactness;
  }

  public void setCompactness(Float compactness) {
    this.compactness = compactness;
  }

  @Column(name = "POPULATION_EQUALITY")
  public Float getPopulationEquality() {
    return this.populationEquality;
  }

  public void setPopulationEquality(Float populationEquality) {
    this.populationEquality = populationEquality;
  }

  @Column(name = "PARTISAN_FAIRNESS")
  public Float getPartisanGerrymandering() {
    return this.partisanGerrymandering;
  }

  public void setPartisanGerrymandering(Float partisanGerrymandering) {
    this.partisanGerrymandering = partisanGerrymandering;
  }
  
  @Transient
  public HashMap<Metric,Float> getUserWeightsList(){
    HashMap<Metric,Float> userWeights = new HashMap<>();
    userWeights.put(Metric.COMPACTNESS,this.compactness);
    userWeights.put(Metric.POPULATION_EQUALITY, this.populationEquality);
    userWeights.put(Metric.PARTISAN_GERRYMANDERING, this.partisanGerrymandering);
    return userWeights;
  }
  
   public void setUserWeights(HashMap<Metric,Float> userWeightsList){
     this.compactness = userWeightsList.get(Metric.COMPACTNESS);
     this.populationEquality = userWeightsList.get(Metric.POPULATION_EQUALITY);
     this.partisanGerrymandering = userWeightsList.get(Metric.PARTISAN_GERRYMANDERING);
  }
}