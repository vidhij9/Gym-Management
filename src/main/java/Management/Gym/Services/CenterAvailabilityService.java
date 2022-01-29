package Management.Gym.Services;

import Management.Gym.Models.Center;
import Management.Gym.Models.GymManagement;

import java.util.ArrayList;
import java.util.List;

// REGISTER CENTER NAME CAPACITY
// REGISTER CENTER KORMANGLA 6

public class CenterAvailabilityService {
  public boolean isCenterAvailable(String centerId, GymManagement gymManagement) {
    if (gymManagement.getCenterList() != null) {
      for (Center center : gymManagement.getCenterList()) {
        if (center.getCentreId().compareTo(centerId) == 0) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean isCenterAvailableName(String centerName, GymManagement gymManagement) {
    if (gymManagement.getCenterList() != null) {
      for (Center center : gymManagement.getCenterList()) {
        if (center.getName().compareTo(centerName) == 0) {
          return false;
        }
      }
    }
    return true;
  }

  public void addCenter(String centerName, Integer slotCapacity, GymManagement gymManagement) {
    Center newCenter = new Center(centerName, slotCapacity);
    if (gymManagement.getCenterList() != null) {
      newCenter.setCentreId(String.valueOf(gymManagement.getCenterList().size() + 1));
      newCenter.setWorkouts(new ArrayList<>());
      gymManagement.getCenterList().add(newCenter);
    } else {
      List<Center> centers = new ArrayList<>();
      newCenter.setCentreId("1");
      newCenter.setWorkouts(new ArrayList<>());
      centers.add(newCenter);
      gymManagement.setCenterList(centers);
    }
  }

  public void updateWorkout(String workoutType, GymManagement gymManagement) {
    if (gymManagement.getCenterList() != null) {
      for (Center center : gymManagement.getCenterList()) {
        if (center.getWorkouts() == null) {
          List<String> workouts = new ArrayList<>();
          workouts.add("Weights");
          workouts.add("Cardio");
          workouts.add(workoutType);
          center.setWorkouts(workouts);
        } else {
          center.getWorkouts().add(workoutType);
        }
      }
    }
  }
}
