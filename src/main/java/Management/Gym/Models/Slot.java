package Management.Gym.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Slot {
  private String slotId;
  private String slotTiming;
  private boolean isAvailable;
  private String workoutType;
}
