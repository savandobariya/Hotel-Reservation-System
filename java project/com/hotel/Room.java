//Rooms Package
package com.hotel;

abstract class Room {
   protected int roomNo;
   protected double price;

   public Room(int var1, double var2) {
      this.roomNo = var1;
      this.price = var2;
   }

   public String toString() {
      int var10000 = this.roomNo;
      return "Room No: " + var10000 + ", Type: " + this.getClass().getSimpleName() + ", Price: " + this.price;
   }
}
