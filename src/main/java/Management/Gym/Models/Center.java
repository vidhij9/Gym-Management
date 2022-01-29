package Management.Gym.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Center {
  private String centreId;
  private String name;
  private List<String> workouts;
  private Integer slotCapacity;
  private Register register;

  public Center(String name, Integer slotCapacity) {
    this.name = name;
    this.slotCapacity = slotCapacity;
  }

  public void setCentreId(String centreId) {
    this.centreId = centreId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setWorkouts(List<String> workouts) {
    if(workouts.isEmpty()){
      workouts.add("Weights");
      workouts.add("Cardio");
    }
    this.workouts = workouts;
  }

  public void setSlotCapacity(Integer slotCapacity) {
    if (slotCapacity == null) {
      this.slotCapacity = 6;
    }
    this.slotCapacity = slotCapacity;
  }

  public void setRegister(Register register) {
    this.register = register;
  }
}
