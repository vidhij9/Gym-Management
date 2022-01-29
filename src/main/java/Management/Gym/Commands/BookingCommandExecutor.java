package Management.Gym.Commands;

import Management.Gym.Models.Command;
import Management.Gym.Models.GymManagement;
import Management.Gym.Services.CenterAvailabilityService;
import Management.Gym.Services.SlotAvailabilityService;
import Management.Gym.Services.UserAvailabilityService;

import java.util.List;

//  BOOK USER_ID CENTER_ID WORKOUT_TYPE SLOT_ID DATE

public class BookingCommandExecutor extends CommandExecutor {
  public static final String COMMAND_NAME = "BOOK";
  private static UserAvailabilityService userAvailabilityService;
  private static CenterAvailabilityService centerAvailabilityService;
  private static SlotAvailabilityService slotAvailabilityService;

  public BookingCommandExecutor(
      GymManagement gymManagement,
      UserAvailabilityService userAvailabilityService,
      CenterAvailabilityService centerAvailabilityService,
      SlotAvailabilityService slotAvailabilityService) {
    super(gymManagement);
    BookingCommandExecutor.userAvailabilityService = userAvailabilityService;
    BookingCommandExecutor.centerAvailabilityService = centerAvailabilityService;
    BookingCommandExecutor.slotAvailabilityService = slotAvailabilityService;
  }

  @Override
  public boolean validate(Command command) {
    List<String> params = command.getParams();
    if (params.size() != 5) {
      System.out.println("INVALID");
      return false;
    }
    if (!userAvailabilityService.isUserAvailableUserId(params.get(0), gymManagement)) {
      System.out.println("User not available.");
      return false;
    }
    if (!centerAvailabilityService.isCenterAvailable(params.get(1), gymManagement)) {
      System.out.println("Center not available.");
      return false;
    }
    if (!slotAvailabilityService.isSlotAvailable(params, gymManagement)) {
      System.out.println("Slot not available.");
      return false;
    }
    return true;
  }

  @Override
  public void execute(Command command) {
    List<String> params = command.getParams();
    //    Map<String, Object> bookingDetails = slotAvailabilityService.bookSlot(params,
    // gymManagement);
    //    System.out.println("Booking Id: " + bookingDetails.get("bookingId"));
    //    System.out.println("Slot Id: " + bookingDetails.get("SlotId"));
    //    System.out.println("Slot Timings: " + bookingDetails.get("Slot_timings"));
    //    System.out.println("Workout Type: " + bookingDetails.get("workoutType"));
    //    System.out.println("Center Id: " + bookingDetails.get("centerId"));
    //    System.out.println("Centre Name: " + bookingDetails.get("centreName"));
  }
}
