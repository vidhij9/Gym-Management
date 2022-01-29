package Management.Gym.Commands;

import Management.Gym.Models.Command;
import Management.Gym.Models.GymManagement;

public class ViewCommandExecutor extends CommandExecutor {
  public static final String COMMAND_NAME = "VIEW";

  public ViewCommandExecutor(GymManagement gymManagement) {
    super(gymManagement);
  }

  @Override
  public boolean validate(Command command) {
    return true;
  }

  @Override
  public void execute(Command command) {}
}
