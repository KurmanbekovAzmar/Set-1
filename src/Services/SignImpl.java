package Services;

import Model.Admin;
import Model.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SignImpl implements Sign {
   private Database database;

    public SignImpl(Database database) {
        this.database = database;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }


    public List<Admin> sign(List<Admin> admin) {
        database.getAdmins().addAll(admin);
        return admin;
    }

    @Override
    public String voity(String email, String pasword) {
        for (Admin s : database.getAdmins()) {
            if (s.getEmail().equals(email) && s.getPassword().equals(pasword)) {
                return "Succes";
            }}

            return "логин же пароль туура эмес кайра жазып корунуз";
        }
    }
