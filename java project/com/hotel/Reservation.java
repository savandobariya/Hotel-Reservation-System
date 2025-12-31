// Reservation Package
package com.hotel;

import java.io.*;

public class Reservation implements Serializable{
   private String guestName;
   private int roomNo;
   private int nights;

   public Reservation(String var1, int var2, int var3) {
      this.guestName = var1;
      this.roomNo = var2;
      this.nights = var3;
   }

   public String getGuestName() {
      return guestName;
   }

   public String toString() {
      return "Guest: " + guestName + ", Room: " + roomNo + ", Nights: " + nights;
   }
}
