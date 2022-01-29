package Management.Gym.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GymManagement {
  private List<Center> centerList;
  private List<User> userList;
  private List<String> bookingIds;
}

/*
REGISTER CENTER HSR 6
REGISTER CENTER KORMANGLA 6
REGISTER USER AISHA AISHA@GMAIL.COM 7326 FGU73
REGISTER USER ANIKA ANIK2A@GMAIL.COM 7229 C76E3
REGISTER USER yasha sgf3@GMAIL.COM 73483 C76E3


*/
