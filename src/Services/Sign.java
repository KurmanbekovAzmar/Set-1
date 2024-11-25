package Services;

import Model.Admin;

import java.util.List;

public interface Sign {
    List<Admin> sign(List<Admin> admin);
    String voity(String email,String pasword);


}
