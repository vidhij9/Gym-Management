package Management.Gym.Services;

import Management.Gym.Models.GymManagement;
import Management.Gym.Models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// REGISTER USER NAME EMAIL PHONE PASSWORD
// REGISTER USER AISHA AISHA@GMAIL.COM 7326 FGU73
// REGISTER USER ANIKA ANIK2A@GMAIL.COM 7229 C76E3

public class UserAvailabilityService {
  public boolean isUserAvailableDetails(
      String email, String phoneNumber, GymManagement gymManagement) {
    if (gymManagement.getUserList() != null) {
      for (User user : gymManagement.getUserList()) {
        if (user.getEmail().compareTo(email) == 0
            && user.getPhoneNumber().compareTo(phoneNumber) == 0) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean isUserAvailableUserId(String userId, GymManagement gymManagement) {
    if (gymManagement.getUserList() == null) {
      return false;
    }
    for (User user : gymManagement.getUserList()) {
      if (user.getUserId().compareTo(userId) == 0) {
        return true;
      }
    }
    return false;
  }

  public String registerUser(List<String> params, GymManagement gymManagement) {
    String userId =
        params.get(1).concat(UUID.randomUUID().toString().toUpperCase().substring(2, 8));
    User newUser = new User(userId, params.get(1), params.get(2), params.get(3), params.get(4));
    if (gymManagement.getUserList() != null) {
      gymManagement.getUserList().add(newUser);
    } else {
      List<User> users = new ArrayList<>();
      users.add(newUser);
      gymManagement.setUserList(users);
    }
    return userId;
  }
}
