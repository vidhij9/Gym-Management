package Management.Gym.Commands;

import Management.Gym.Models.Command;
import Management.Gym.Models.GymManagement;

public abstract class CommandExecutor {

  GymManagement gymManagement;

  public CommandExecutor(GymManagement gymManagement) {
    this.gymManagement = gymManagement;
  }

  public abstract boolean validate(Command command);

  public abstract void execute(Command command);
}
