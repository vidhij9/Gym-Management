package Management.Gym.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User {
  private String userId;
  private String name;
  private String email;
  private String phoneNumber;
  private String password;
  private List<Slot> slots;

  public User(String userId, String name, String email, String phoneNumber, String password) {
    this.userId = userId;
    this.name = name;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.password = password;
  }

}
