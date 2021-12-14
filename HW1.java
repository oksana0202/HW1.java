/**
 * JAVA 2 Homework1
 *
 * @author Oksana Ilyakova
 * @version 14.12.2021
 */

class Team {
    public static void main(String[] args) {
        Course course = new Course(new Cross(100), new Wall(3),
                new Cross(500), new Water(4));
        Team team = new Team("Team 1", new Human("Joe"), new Cat("Tom"),
                new Mouse("Jerry"), new Dog("Molly"));
        course.doIt(team);

        System.out.println("\n===== RESULTS =====\n");
        team.showResults();
        System.out.println();
    }
}
class Course {
    Let[] let = new Let[3];
    Random random = new Random();

    public static void main(String[] args) {
        Track track = new Track(random.nextInt(100));
        Wall wall = new Wall(random.nextFloat() * 10);
        Water water = new Water(random.nextInt(100));
        let[0] = (Let) track;
        let[1] = (Let) wall;
        let[2] = (Let) water;
    }

    public void printInformationAboutTheObstacle() {
        System.out.println("Length track: " + ((Track) let[0]).getLength());
        System.out.println("Height wall: " + ((Wall) let[1]).getHeight());
        System.out.println("Length water: " + ((Water) let[2]).getLength());
        System.out.println();
    }

    public void passObstacles(Team team){
        for(Animal animal : team.teamAnimal){
            for(Let l : let){
                if(!l.doIt(animal)){
                    animal.setPassing(l.doIt(animal));
                    break;
                }
                animal.setPassing(true);
            }
        }
    }
}
