package Management.Gym.Commands;

import Management.Gym.Models.Command;
import Management.Gym.Models.GymManagement;
import Management.Gym.Services.CenterAvailabilityService;
import Management.Gym.Services.UserAvailabilityService;

import java.util.List;

public class RegisterCommandExecutor extends CommandExecutor {
  public static final String COMMAND_NAME = "REGISTER";
  private static UserAvailabilityService userAvailabilityService;
  private static CenterAvailabilityService centerAvailabilityService;

  public RegisterCommandExecutor(
      GymManagement gymManagement,
      UserAvailabilityService userAvailabilityService,
      CenterAvailabilityService centerAvailabilityService) {
    super(gymManagement);
    RegisterCommandExecutor.userAvailabilityService = userAvailabilityService;
    RegisterCommandExecutor.centerAvailabilityService = centerAvailabilityService;
  }

  // REGISTER CENTER KORMANGLA 6
  // REGISTER CENTER BELLANDUR 8

  // REGISTER USER NAME EMAIL PHONE PASSWORD
  // REGISTER USER AISHA AISHA@GMAIL.COM 7326 FGU73
  // REGISTER USER ANIKA ANIK2A@GMAIL.COM 7229 C76E3

  @Override
  public boolean validate(Command command) {
    List<String> params = command.getParams();
    if (params.get(0).compareTo("USER") == 0) {
      // checking with email and phone number
      if (!userAvailabilityService.isUserAvailableDetails(
          params.get(2), params.get(3), gymManagement)) {
        System.out.println("User already exists");
        return false;
      }
    }
    if (params.get(0).compareTo("CENTER") == 0) {
      // checking with center name
      if (!centerAvailabilityService.isCenterAvailableName(params.get(1), gymManagement)) {
        System.out.println("Center already exists");
        return false;
      }
    }
    return true;
  }

  @Override
  public void execute(Command command) {
    List<String> params = command.getParams();
    if (params.get(0).compareTo("USER") == 0) {
      String userId = userAvailabilityService.registerUser(params, gymManagement);
      System.out.println("UserId: " + userId);
    }
    if (params.get(0).compareTo("CENTER") == 0) {
      centerAvailabilityService.addCenter(
          params.get(1), Integer.valueOf(params.get(2)), gymManagement);
      System.out.println("CenterId: " + gymManagement.getCenterList().size());
    }
  }
}
