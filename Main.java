public class Main {
    public static void main(String[] args)  {
        Room room = new Room(1, "Single", true, true, 225);
        Room room2 = new Room(2, "Double", true, true, 550);
        Room room3 = new Room(3, "Villa", false, true, 850);
        Room room4 = new Room(4, "Suite", true, true, 5000);
        Room room5 = new Room(5, "Luxury", false, true, 10_000);

        Room[] rooms = {room, room2, room3, room4, room5};
        for (int i = 0; i < rooms.length ; i++) {

            System.out.println("Room #" + rooms[i].roomNumber);
            System.out.println("Room Type: " + rooms[i].roomType);
            System.out.println("Is Occupied: " + rooms[i].isOccupied);
            System.out.println("Is Clean: " + rooms[i].isClean);
            System.out.println("Price: " + rooms[i].price);
            System.out.println("\n");

        }
    }
}