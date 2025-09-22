import java.util.Scanner;

public class HotelBookingSystem {
// Let's assume 5 floors and 5 rooms per floor
static final int FLOORS = 5;
static final int ROOMS_PER_FLOOR = 5;

// 2D array to represent hotel rooms
static boolean[][] rooms = new boolean[FLOORS][ROOMS_PER_FLOOR];

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
int choice;

do {
System.out.println("\n=== Hotel Room Booking System ===");




System.out.println("1. View Rooms");
System.out.println("2. Book a Room");
System.out.println("3. Exit");
System.out.print("Enter your choice: ");

choice = scanner.nextInt();

switch (choice) {
case 1:
viewRooms();
break;
case 2:
bookRoom(scanner);
break;
case 3:
System.out.println("Exiting system. Thank you!");
break;
default:
System.out.println("Invalid choice. Please select 1-3.");
}
} while (choice != 3);

scanner.close();
}

// Display room availability
public static void viewRooms() {
System.out.println("\nRoom Availability (F: Floor, R: Room):");

for (int i = 0; i < FLOORS; i++) {
System.out.print("Floor " + (i + 1) + ": ");
for (int j = 0; j < ROOMS_PER_FLOOR; j++) {
String status = rooms[i][j] ? "[X]" : "[ ]"; // X = booked, blank = available
System.out.print("R" + (j + 1) + status + " ");
}
System.out.println();
}
}

// Book a room
public static void bookRoom(Scanner scanner) {
System.out.print("Enter floor number (1 to " + FLOORS + "): ");
int floor = scanner.nextInt();
System.out.print("Enter room number (1 to " + ROOMS_PER_FLOOR + "): ");
int room = scanner.nextInt();

if (floor < 1 || floor > FLOORS || room < 1 || room > ROOMS_PER_FLOOR) {
System.out.println("Invalid floor or room number.");
return;
}

if (rooms[floor - 1][room - 1]) {
System.out.println("Sorry, that room is already booked.");
} else {
rooms[floor - 1][room - 1] = true;
System.out.println("Room booked successfully!");
}

}
}