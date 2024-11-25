package Model;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Admin> admin;
private List<Group> groups;

    public Database(List<Admin> admin, List<Group> groups) {
        this.admin = admin;
        this.groups = groups;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }


    public List<Admin> getAdmins() {
        return admin;
    }

    public void setAdmins(List<Admin> admins) {
        this.admin = admins;
    }
}