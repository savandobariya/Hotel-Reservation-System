//Required all Packages
package com.hotel;

import java.io.*;
import java.util.*;


public class HotelReservationSystem {
   static Scanner sc;
   static ArrayList<Reservation> reservations;
   // private static final String FILE_NAME = "reservations.txt";

   public HotelReservationSystem() {
   }

   public static void main(String[] var0) {
      loadReservations();

      while(true) {
         while(true) {
            System.out.println("\n=== Hotel Reservation System ===");
            System.out.println("1. Search Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View Reservations");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int var1 = sc.nextInt();
            sc.nextLine();
            switch (var1) {
               case 1:
                  searchRooms();
                  break;
               case 2:
                  bookRoom();
                  break;
               case 3:
                  cancelReservation();
                  break;
               case 4:
                  viewReservations();
                  break;
               case 5:
                  saveReservations();
                  System.exit(0);
                  break;
               default:
                  System.out.println("Invalid choice, please try again.");
            }
         }
      }
   }

   private static void searchRooms() {
      System.out.println("Available Rooms:");
      Room[] var0 = new Room[]{new StandardRoom(101, 1500.0), new DeluxeRoom(201, 3000.0), new SuiteRoom(301, 5000.0)};
      Room[] var1 = var0;
      int var2 = var0.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Room var4 = var1[var3];
         System.out.println(var4);
      }

   }

   private static void bookRoom() {
      try {
         System.out.print("Enter Name: ");
         String var0 = sc.nextLine();
         System.out.print("Enter Room Number: ");
         int var1 = sc.nextInt();
         System.out.print("Enter Nights: ");
         int var2 = sc.nextInt();
         Reservation var3 = new Reservation(var0, var1, var2);
         reservations.add(var3);
         System.out.println("Reservation successful!");
      } catch (InputMismatchException var4) {
         System.out.println("Invalid input! Please enter numbers correctly.");
         sc.nextLine();
      }

   }

   private static void cancelReservation() {
      System.out.print("Enter Name to Cancel: ");
      String var0 = sc.nextLine();
      reservations.removeIf((var1) -> {
         return var1.getGuestName().equalsIgnoreCase(var0);
      });
      System.out.println("Reservation cancelled (if found).");
   }

   private static void viewReservations() {
      if (reservations.isEmpty()) {
         System.out.println("No reservations found.");
      }

      Iterator<Reservation> var0 = reservations.iterator();

      while(var0.hasNext()) {
         Reservation var1 = (Reservation)var0.next();
         System.out.println(var1);
      }

   }

   private static void loadReservations() {
      try {
         ObjectInputStream var0 = new ObjectInputStream(new FileInputStream("reservations.txt"));

         try {
            reservations = (ArrayList<Reservation>)var0.readObject();
         } catch (Throwable var4) {
            try {
               var0.close();
            } catch (Throwable var3) {
               var4.addSuppressed(var3);
            }

            throw var4;
         }

         var0.close();
      } catch (Exception var5) {
      }

   }

   private static void saveReservations() {
      try {
         ObjectOutputStream var0 = new ObjectOutputStream(new FileOutputStream("reservations.txt"));

         try {
            var0.writeObject(reservations);
         } catch (Throwable var4) {
            try {
               var0.close();
            } catch (Throwable var3) {
               var4.addSuppressed(var3);
            }

            throw var4;
         }

         var0.close();
      } catch (IOException var5) {
         System.out.println("Error saving reservations.");
      }

   }

   static {
      sc = new Scanner(System.in);
      reservations = new ArrayList<Reservation>();
   }
}

