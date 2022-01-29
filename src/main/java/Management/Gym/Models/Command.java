package Management.Gym.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@Setter
public class Command {

  private static final String SPACE = " ";
  private String commandName;
  private List<String> params;

  public Command(String inputLine) {
    inputLine = inputLine.toUpperCase();
    final List<String> gymManagement =
        Arrays.stream(inputLine.trim().split(SPACE))
            .map(String::trim)
            .filter(manage -> manage.length() > 0)
            .collect(Collectors.toList());

    if (gymManagement.size() == 0) {
      System.out.println("INVALID");
    }

    commandName = gymManagement.get(0);
    gymManagement.remove(0);
    params = gymManagement;
  }
}
