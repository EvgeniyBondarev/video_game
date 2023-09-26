public class Battle {
    public static void main(String[] args) {
        Player p = new Player(10, 20, 350, 10, 200);
        Monster m = new Monster(25, 20, 350, 10, 100);
        while (true){
            if (p.hitHim(m) != 1)
                break;
            if (m.hitHim(p) !=1)
                break;
            System.out.println();
        }
    }
}
