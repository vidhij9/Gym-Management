package Management.Gym.Commands;

import Management.Gym.Models.Command;
import Management.Gym.Models.GymManagement;
import Management.Gym.Services.CenterAvailabilityService;
import Management.Gym.Services.SlotAvailabilityService;
import Management.Gym.Services.UserAvailabilityService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CommandExecutorFactory {

  private final Map<String, CommandExecutor> commandExecutorMap = new HashMap<>();
  private final GymManagement gymManagement = new GymManagement(null, null, null);
  private final UserAvailabilityService userAvailabilityService = new UserAvailabilityService();
  private final CenterAvailabilityService centerAvailabilityService =
      new CenterAvailabilityService();
  private final SlotAvailabilityService slotAvailabilityService = new SlotAvailabilityService();

  public CommandExecutorFactory() {
    commandExecutorMap.put(
        RegisterCommandExecutor.COMMAND_NAME,
        new RegisterCommandExecutor(
            gymManagement, userAvailabilityService, centerAvailabilityService));
    commandExecutorMap.put(
        BookingCommandExecutor.COMMAND_NAME,
        new BookingCommandExecutor(
            gymManagement,
            userAvailabilityService,
            centerAvailabilityService,
            slotAvailabilityService));
    commandExecutorMap.put(
        ViewCommandExecutor.COMMAND_NAME, new ViewCommandExecutor(gymManagement));
    commandExecutorMap.put(
        ExitCommandExecutor.COMMAND_NAME, new ExitCommandExecutor(gymManagement));
  }

  public CommandExecutor getCommandExecutor(final Command command) {
    final CommandExecutor commandExecutor = commandExecutorMap.get(command.getCommandName());
    if (commandExecutor == null) {
      System.out.println("INVALID");
    }
    return commandExecutor;
  }
}
