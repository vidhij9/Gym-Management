package Management.Gym.Commands;

import Management.Gym.Models.Command;
import Management.Gym.Models.GymManagement;

public class ExitCommandExecutor extends CommandExecutor {
  public static final String COMMAND_NAME = "EXIT";

  public ExitCommandExecutor(GymManagement gymManagement) {
    super(gymManagement);
  }

  @Override
  public boolean validate(Command command) {
    return command.getParams().isEmpty();
  }

  @Override
  public void execute(Command command) {
    System.out.println("Thanks for using our services.");
  }
}
