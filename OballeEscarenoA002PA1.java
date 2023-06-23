/* 
 * @(#)OballeEscarenoA002PA1.java
 * @Author Aldo Oballe-Escareno
 * @verison 1.00 6/24/22 1:25 PM
 * 
 * PROGRAM PURPOSE: Create a program that accepts a customer's orders for hammocks. 
 * The customer gets a discount based on the order total (size). A sales receipt 
 * will be generated. 
 */
import java.util.Scanner; // Class that will capture input 
import java.util.Calendar; // Class that will get the date and time

public class OballeEscarenoA002PA1
{
  /*
   * Customers will be asked for a hammock choice based on small, medium, or large; 
   * the quantity or hammock size; and the color. An itemTotal is calculated for a 
   * selection, followed by a subtotal. Based on the subtotal a discount is derived, 
   * then the subtotal is re-calculated with the discount. The sales tax is based on 
   * the discounted subtotal. A total for the sale is finalized and the sales receipt 
   * is printed. 
   */
  public static void main(String[] args)
  {
    int hammock = 0,
      quantity = 0,
      color = 0,
      iterations = 1;
    
    double itemTotal = 0.0,
      subtotal = 0.0,
      discount = 0.0,
      discSubtotal = 0.0,
      tax = 0.0,
      total = 0.0,
      price = 0.0;
    
    java.util.Scanner input = new Scanner(System.in);
    Calendar dateTime = Calendar.getInstance();
    
    char cont = 'y';
    
    String hammockDesc = "", colorSelected = "";
    
    String salesReceipt = String.format("%n%nSALES RECEIPT"
                                          + "%n%nLAZY HAZY DAYS, INC."
                                          + "%nHuebner Oaks Mall"
                                          + "%nSan Antonio, TX"
                                          + "%n%nDate:  %tD"
                                          + "%nTime:  %tr%n", dateTime, dateTime);
    
    while(cont == 'y')
    {
      System.out.printf("%nLAZY HAZY DAYS, INC."  // PROMPT 1
                          + "%n%nOur beautiful cotton hammocks sport a "
                          + "traditional look and are very comfortable. "
                          + "%n%n1.  Small - 48 in. x 11 ft. - Good for 1 person "
                          + "\t\t\t\t$100.00"
                          + "%n2.  Large - 55 in. x 13 ft. - Good for 2 "
                          + "people\t\t\t\t$140.00"
                          + "%n3.  Deluxe - 60 in. x 13 ft. - Good for 2 or "
                          + "more people\t\t\t$175.00"
                          + "%n%nEnter your choice:    "); //END OF PROMPT 1 
      hammock = input.nextInt(); //TO CAPTURE WHAT'S COMING IN TO THE KEYBOARD AS AN INTEGER
      
      if(hammock == 1)
      {
        hammockDesc = "Small - 48 in. x 11 ft.";
        price = 100.00;
      }
      else
      {
        if(hammock == 2)
        {
          hammockDesc = "Large - 55 in. x 13 ft.";
          price = 140.00;
        }
        else
        {
          if(hammock == 3)
          {
            hammockDesc = "Deluxe - 60 in. x 13 ft.";
            price = 175.00;
          }
          else
          {
            System.out.printf("%nInvalid hammock choice!%n");
            hammockDesc = "Invalid hammock";
            price = 0.0;
          }//END if hammock is 3 else invalid hammock choice  
        }//END if hammock is 2 else hammock is 3
      }//END if hammock is 1 else hammock is 2
      
      
      //INSERT PROMPTS 2 AND 3
      {
        System.out.printf("%n%nEnter the quantity:   ");// PROMPT 2 PROMPTS FOR THE NUMBER OF HAMMOCKS TO ORDER
        quantity = input.nextInt(); // Capturing what's coming in to the keyboard as an Integer 
      }
      {
        //PROMPT 3 
        System.out.printf("%n%n1. Crimson Red"    
                            + "%n2. Emerald Green"
                            + "%n3. Indigo Blue"
                            + "%n4. Natural"
                            + "%n5. Purple Haze"
                            + "%nEnter your choice of colors: "); 
        color = input.nextInt(); // Capture the color choice
        //TEST FOR COLORS USING IF-ELSES
        if(color == 1)
        {
          colorSelected = "Crimson Red";
        }
        else
        {
          if(color == 2)
          {
            colorSelected = "Emerald green";
          }
          else
          {
            if(color == 3)
            {
              colorSelected = "Indigo Blue";
            }
            else
            {
              if(color == 4)
              {
                colorSelected = "Natural";
              }
              else
              {
                if(color == 5)
                {
                  colorSelected = "Purple Haze";
                }
                else
                {
                  colorSelected = "Invalid color!";
                }
              }// END IF HAMMOCK COLOR IS 5 ELSE COLOT IS INVALID
            }//END IF HAMMOCK COLOR IS 4 ELSE COLOR IS 5   
           }//END IF HAMMOCK COLOR IS 3 ELSE COLOR IS 4
         }//END IF HAMMOCK COLOR 2 ELSE COLOR IS 3
       }// END IF HAMMOCK COLOR 1 ELSE COLOR IS 2 

     {itemTotal = quantity * price; // Calculation 1 
      
      subtotal += itemTotal; // Calculaton 2
      
      //CODE IF-ELSES TESTING DISCOUNT RANGES 
      if(subtotal >= 100000.00)
      {
        discount = subtotal * .035; // CALCULATION 3
      }
      else
      {
        if(subtotal >= 50000.00)
        {
          discount = subtotal * .03; // CALCULATION 4
        }
        else
        {
          if(subtotal >= 10000.00)
          {
            discount = subtotal * .025; // CALCULATION 5
          }
          else
          {
            if(subtotal >= 5000.00)
            {
              discount = subtotal * 0.2; // CALCULATION 6
            }
            else
              discount = 0.0; // ELSE NO DISCOUNT
           }//END IF SUBTOTAL IS GREATER THEN OR EQAUL TO 5000.00 THEN CALC 6
         }//END IF SUBTOTAL IS GREATER THAN OR EQUAL TO 10000.00 THEN CALC 5
        }//END IF SUBTOTAL IS GREATER OR EQUAL TO 50000.00 THEN CALC 4
       }//END IF SUBTOTAL IS GREATER THAN OR EQUAL TO 100000.00 THEN CALC 3
      
      
      salesReceipt += String.format("%n%-24s %c %-13s %5s %,7d %4s %s%,14.2f",
                                     hammockDesc, '-', colorSelected, " ", 
                                     quantity, " ", iterations > 1 ? " " : "$",
                                     itemTotal);
      //INCREMENT iterations VARIABLE
      iterations += 1;
      
      //PROMPT 4 TO ASK FOR ADDITIONAL HAMMOCKS
      {
        System.out.printf("%n%nDo you want to add another hammock? Enter 'Y' or 'N': ");
        cont = input.next().charAt(0);
        
      }
      
    }// END while cont is 'y'                               
    
    //INSERT CALCULATIONS FOR discSubtotal, tax, and total
    discSubtotal += subtotal - discount;
    tax = discSubtotal * .0825;
    total = discSubtotal + tax;
    
      
    // SALES RECEIPT
    System.out.printf("%s"
                    + "%n%n%52s %-6s $%,14.2f"
                    + "%n%52s %-7s %,14.2f"
                    + "%n%52s %-7s %,14.2f"
                    + "%n%n%52s %-6s $%,14.2f",
                      salesReceipt, "SUBTOTAL:", " ",
                      subtotal, "DISCOUNT:", " ",
                      discount, "TAX @ 8.250%:",
                      " ", tax, "TOTAL:", " ", total);
    System.exit(0);
    
    
  }//END main()
}//END APPLICATION CLASS OballeEscarenoAL002PA1

// SAMPLE OUTPUT
/*
 * 
 * Low quatity - hammock sales
 * 
LAZY HAZY DAYS, INC. 
 
Our beautiful cotton hammocks sport a traditional look and are very comfortable.  
 
1.  Small - 48 in. x 11 ft. - Good for 1 person                         $100.00 
2.  Large - 55 in. x 13 ft. - Good for 2 people                         $140.00 
3.  Deluxe - 60 in. x 13 ft. - Good for 2 or more people                $175.00 
 
Enter your choice:    1
 
 
Enter the quantity:   2
 
 
1. Crimson Red 
2. Emerald Green 
3. Indigo Blue 
4. Natural 
5. Purple Haze 
Enter your choice of colors: 4
 
 
Do you want to add another hammock? Enter 'Y' or 'N': y
 
LAZY HAZY DAYS, INC. 
 
Our beautiful cotton hammocks sport a traditional look and are very comfortable.  
 
1.  Small - 48 in. x 11 ft. - Good for 1 person                         $100.00 
2.  Large - 55 in. x 13 ft. - Good for 2 people                         $140.00 
3.  Deluxe - 60 in. x 13 ft. - Good for 2 or more people                $175.00 
 
Enter your choice:    2
 
 
Enter the quantity:   100
 
 
1. Crimson Red 
2. Emerald Green 
3. Indigo Blue 
4. Natural 
5. Purple Haze 
Enter your choice of colors: 2
 
 
Do you want to add another hammock? Enter 'Y' or 'N': y
 
LAZY HAZY DAYS, INC. 
 
Our beautiful cotton hammocks sport a traditional look and are very comfortable.  
 
1.  Small - 48 in. x 11 ft. - Good for 1 person                         $100.00 
2.  Large - 55 in. x 13 ft. - Good for 2 people                         $140.00 
3.  Deluxe - 60 in. x 13 ft. - Good for 2 or more people                $175.00 
 
Enter your choice:    3
 
 
Enter the quantity:   50
 
 
1. Crimson Red 
2. Emerald Green 
3. Indigo Blue 
4. Natural 
5. Purple Haze 
Enter your choice of colors: 5
 
 
Do you want to add another hammock? Enter 'Y' or 'N': n
 
 
SALES RECEIPT 
 
LAZY HAZY DAYS, INC. 
Huebner Oaks Mall 
San Antonio, TX 
 
Date:  07/03/22 
Time:  10:10:33 AM 
 
Small - 48 in. x 11 ft.  - Natural                   2      $        200.00 
Large - 55 in. x 13 ft.  - Emerald green           100            14,000.00 
Deluxe - 60 in. x 13 ft. - Purple Haze              50             8,750.00 
 
                                           SUBTOTAL:        $     22,950.00 
                                           DISCOUNT:                 573.75 
                                       TAX @ 8.250%:               1,846.04 
 
                                              TOTAL:        $     24,222.29
                                              
                                              
 * HAMMOCK SALES - LARGE QUANTITY
 * 
 * 
LAZY HAZY DAYS, INC. 
 
Our beautiful cotton hammocks sport a traditional look and are very comfortable.  
 
1.  Small - 48 in. x 11 ft. - Good for 1 person                         $100.00 
2.  Large - 55 in. x 13 ft. - Good for 2 people                         $140.00 
3.  Deluxe - 60 in. x 13 ft. - Good for 2 or more people                $175.00 
 
Enter your choice:    1
 
 
Enter the quantity:   100000
 
 
1. Crimson Red 
2. Emerald Green 
3. Indigo Blue 
4. Natural 
5. Purple Haze 
Enter your choice of colors: 4
 
 
Do you want to add another hammock? Enter 'Y' or 'N': y
 
LAZY HAZY DAYS, INC. 
 
Our beautiful cotton hammocks sport a traditional look and are very comfortable.  
 
1.  Small - 48 in. x 11 ft. - Good for 1 person                         $100.00 
2.  Large - 55 in. x 13 ft. - Good for 2 people                         $140.00 
3.  Deluxe - 60 in. x 13 ft. - Good for 2 or more people                $175.00 
 
Enter your choice:    2
 
 
Enter the quantity:   10000
 
 
1. Crimson Red 
2. Emerald Green 
3. Indigo Blue 
4. Natural 
5. Purple Haze 
Enter your choice of colors: 1
 
 
Do you want to add another hammock? Enter 'Y' or 'N': y
 
LAZY HAZY DAYS, INC. 
 
Our beautiful cotton hammocks sport a traditional look and are very comfortable.  
 
1.  Small - 48 in. x 11 ft. - Good for 1 person                         $100.00 
2.  Large - 55 in. x 13 ft. - Good for 2 people                         $140.00 
3.  Deluxe - 60 in. x 13 ft. - Good for 2 or more people                $175.00 
 
Enter your choice:    3
 
 
Enter the quantity:   1000
 
 
1. Crimson Red 
2. Emerald Green 
3. Indigo Blue 
4. Natural 
5. Purple Haze 
Enter your choice of colors: 5
 
 
Do you want to add another hammock? Enter 'Y' or 'N': n
 
 
SALES RECEIPT 
 
LAZY HAZY DAYS, INC. 
Huebner Oaks Mall 
San Antonio, TX 
 
Date:  07/03/22 
Time:  10:18:26 AM 
 
Small - 48 in. x 11 ft.  - Natural             100,000      $ 10,000,000.00 
Large - 55 in. x 13 ft.  - Crimson Red          10,000         1,400,000.00 
Deluxe - 60 in. x 13 ft. - Purple Haze           1,000           175,000.00 
 
                                           SUBTOTAL:        $ 11,575,000.00 
                                           DISCOUNT:             405,125.00 
                                       TAX @ 8.250%:             921,514.69 
 
                                              TOTAL:        $ 12,091,389.69
                                              
                                              
 
 * 
 * ERROR MESSAGES 
LAZY HAZY DAYS, INC. 
 
Our beautiful cotton hammocks sport a traditional look and are very comfortable.  
 
1.  Small - 48 in. x 11 ft. - Good for 1 person     $100.00 
2.  Large - 55 in. x 13 ft. - Good for 2 people    $140.00 
3.  Deluxe - 60 in. x 13 ft. - Good for 2 or more people   $175.00 
 
Enter your choice:    4
 
Invalid hammock choice! 
 
 
Enter the quantity:   0
 
 
1. Crimson Red 
2. Emerald Green 
3. Indigo Blue 
4. Natural 
5. Purple Haze 
Enter your choice of colors: 7
 
 
Do you want to add another hammock? Enter 'Y' or 'N': N
 
 
SALES RECEIPT 
 
LAZY HAZY DAYS, INC. 
Huebner Oaks Mall 
San Antonio, TX 
 
Date:  07/03/22 
Time:  10:22:05 AM 
 
Invalid hammock          - Invalid color!             0      $          0.00 
 
                                           SUBTOTAL:        $          0.00 
                                           DISCOUNT:                   0.00 
                                       TAX @ 8.250%:                   0.00 
 
                                              TOTAL:        $          0.00
 */



















