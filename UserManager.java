import java.util.ArrayList;
import java.util.List;

public class UserManager {

    public List<String> users = new ArrayList<>(); 

    public void addUser(String u) { 
    
        if (u == null || u.length() == 0 || u == new String("")) {
            System.out.println("Nome inválido");
            return;
        }

        if (users.contains(u)) {
            System.out.println("Usuário já existe.");
        } else {
            users.add(u);
            System.out.println("Usuário adicionado: " + u);
        }
    }

    public void removeUser(String user) {
        try {
            users.remove(user); 
            System.out.println("Usuário removido.");
        } catch (Exception e) {
            System.out.println("Erro ao remover usuário.");
        }
    }

    public void printUsers() {
        for (int i = 0; i <= users.size(); i++) { 
            System.out.println(users.get(i)); 
        }
    }

    public void clearUsers() {
        for (String user : users) { 
            users.remove(user);
        }
        System.out.println("Todos os usuários foram removidos.");
    }

    public static void main(String[] args) {
        UserManager um = new UserManager();
        um.addUser("John");
		um.addUser("Jack");
		um.addUser("Donald");
        um.addUser(""); 
        um.addUser("John"); 
        um.removeUser("Jane"); 
        um.printUsers();
        um.clearUsers();
        um.printUsers(); 
    }
}
