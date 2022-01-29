package Management.Gym.Services;

import Management.Gym.Models.Center;
import Management.Gym.Models.GymManagement;
import Management.Gym.Models.Page;
import Management.Gym.Models.Register;
import Management.Gym.Models.Slot;
import Management.Gym.Models.User;

import java.util.ArrayList;
import java.util.List;

//  BOOK USER_ID CENTER_ID WORKOUT_TYPE SLOT_ID DATE

public class SlotAvailabilityService {

  private CenterAvailabilityService centerAvailabilityService;

  public boolean isSlotAvailable(List<String> params, GymManagement gymManagement) {
    String userId = params.get(0);
    String centerId = params.get(1);
    String workoutType = params.get(2);
    String slotId = params.get(3);
    String date = params.get(4);
    Register register = new Register();

    // check if this user already has the given slot or not
    for (User user : gymManagement.getUserList()) {
      if (user.getUserId().compareTo(userId) == 0) {
        for (Slot slot : user.getSlots()) {
          if (slot.getWorkoutType().compareTo(workoutType) == 0
              && slot.getSlotId().compareTo(slotId) == 0) {
            System.out.println("Slot is already booked by the given user.");
            return false;
          }
        }
      } else return false;
    }

    for (Center center : gymManagement.getCenterList()) {
      if (center.getCentreId().compareTo(centerId) == 0) {
        register = center.getRegister();
      } else {
        return false;
      }
    }
    for (Page page : register.getPageList()) {
      if (page.getDate().compareTo(date) == 0) {
        for (Slot slot : page.getSlotList()) {
          if (slot.getSlotId().compareTo(slotId) == 0) {
            System.out.println("Slot is already booked.");
            return false;
          }
        }
        System.out.println("Some slots are available for the day.");
        return true;
      } else {
        System.out.println("All slots are available for the day.");
        return true;
      }
    }
    return true;
  }

  private List<Center> addCenterToUser(
      String centerId, String userId, GymManagement gymManagement) {
    return new ArrayList<>();
  }

  private boolean isWorkoutAvailable(String workoutType, GymManagement gymManagement) {
    for (Center center : gymManagement.getCenterList()) {
      if (center.getWorkouts().contains(workoutType)) {
        return false;
      }
    }
    return true;
  }

  //  public Map<String, Object> bookSlot(List<String> params, GymManagement gymManagement) {
  //    Integer centerId = Integer.valueOf(params.get(1));
  //    Integer slotId = Integer.valueOf(params.get(2));
  //    String date = params.get(3);
  //    String bookingId = null;
  //    Slot newSlot = new Slot(slotId, params.get(4), null);
  //    for (Center center : gymManagement.getCenterList()) {
  //      if (center.getCentreId().compareTo(centerId) == 0) {
  //        if (center.getDateSlots().containsKey(date)) {
  //          center.getDateSlots().get(date).add(newSlot);
  //        } else {
  //          List<Slot> slotList = new ArrayList<>();
  //          slotList.add(newSlot);
  //          center.getDateSlots().put(date, slotList);
  //        }
  //        bookingId = params.get(0).concat(UUID.randomUUID().toString().substring(8, 10));
  //        if (center.getBookings() == null) {
  //          List<String> bookings = new ArrayList<>();
  //          bookings.add(bookingId);
  //          center.setBookings(bookings);
  //        } else {
  //          center.getBookings().add(bookingId);
  //        }
  //        break;
  //      }
  //    }
  //    String slotTimings = getSlotsTimings(slotId);
  //    String finalBookingId = bookingId;
  //    return (Map<String, Object>)
  //        new HashMap() {
  //          {
  //            put("bookingId", finalBookingId);
  //            put("SlotId", slotId);
  //            put("Slot_timings", slotTimings);
  //            put("workoutType", params.get(4));
  //            put("centerId", centerId);
  //            put("centreName", gymManagement.getCenterList().get(centerId).getName());
  //          }
  //        };
  //  }

  private String getSlotsTimings(Integer slotId) {
    if (slotId == 1) {
      return "6am-7am";
    }
    if (slotId == 2) {
      return "7am-8am";
    }
    if (slotId == 3) {
      return "8am-9am";
    }
    if (slotId == 4) {
      return "6pm-7pm";
    }
    if (slotId == 5) {
      return "7pm-8pm";
    }
    if (slotId == 6) {
      return "8pm-9pm";
    } else return "no slot available";
  }
}
