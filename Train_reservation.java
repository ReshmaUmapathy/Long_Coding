import java.util.*;
import java.io.*;

class Train_reservation 
{
String name, from , to;
int train_no , seats , time;
static void menu()
{
	System.out.println("1.Book ticket");
	System.out.println("2.Cancel ticket");
	System.out.println("3.Reservation chart");
	System.out.println("4.Display unbooked tickets");
	System.out.println("5.Exit");
	System.out.println("Please enter your choice");
}

public static void main(String args[])
{
	Scanner sc = new Scanner(System.in);
Train_reservation train = new Train_reservation();
int[] p = new int[300];
int[] c1= new int[300];
String[] name = new String[275];
int pcount = 0;
String phno[]=new String[275];
int age[]=new int[275];
int pnum=1;
int max1=75;
int max2=125;
int max3=175;
int i,ticket_avail=0;
int choice;
System.out.println("***********************************TRAIN RESERVATION FOR CHENNAI EXPRESS*****************************************************");
do{
menu();	
choice = sc.nextInt();
switch(choice)
{
	case 1 : 
	{
		System.out.println("Please enter the class of ticket");
		System.out.println("1. AC\t 2. First\t 3. Sleeper\t");
		int c=sc.nextInt();
		System.out.println("Please enter no. of tickets");
		int t=sc.nextInt();
		if(c==1 && t<max1)
		{
			ticket_avail = 1;
		}
		if(c==2 && t<max2)
		{
			ticket_avail = 1;
		}
		if(c==3 && t<max3)
		{
			ticket_avail = 1;
		}
		if(ticket_avail == 1)
		{
			for(i=0;i<t;i++)
			{
				p[pcount]=pnum;
				System.out.println("Please enter your name");
				name[pcount]=sc.next();
				System.out.println("Please enter your age");
				age[pcount]=sc.nextInt();
				c1[pcount]=c;
				System.out.println("Please enter your phno");
				phno[pcount]=sc.next();
				pcount++;
				pnum++;
				System.out.println("Ticket successfully booked");
			}//for
		if(c==1)
		{
		max1-=t;
		System.out.println("Please pay Rs."+t*1500);
		}
		if(c==2)
		{
		max2-=t;
		System.out.println("Please pay Rs."+t*1200);
		}
		if(c==3)
		{
		max3-=t;
		System.out.println("Please pay Rs."+t*1000);
		}
		}
		break;
		}
		case 2 : 
		{
			System.out.println("Please enter the class of ticket");
			System.out.println("1. AC\t 2. First\t 3. Sleeper\t");
			int c=sc.nextInt();
			System.out.println("Enter your seat_no : ");
			int s = sc.nextInt();
			int flag =0;
			for(i=0;i<pcount;i++)
			{
				if(p[i]==s)
				{
					flag = 1;
					if(c==1)
					{
						max1++;
						System.out.println("please collect your refund amount : Rs.1500 ");
					}
					if(c==2)
					{
						max2++;
						System.out.println("please collect your refund amount : Rs.1200 ");
					}
					if(c==3)
					{
						max3++;
						System.out.println("please collect your refund amount : Rs.1000 ");
					}
				}
			}
			if(flag == 0)
			{
				System.out.println("Sorry, You havent booked the ticket ...!!! ");
			}
			else
			{
				pcount--;
				System.out.println("Successfully cancelled your ticket ...!!!");
				flag = 0;
			}
			break;
		}
		case 3:{
			
			System.out.println("Passenger list in AC class");
	System.out.println("pno \t name \t\t age \t phno");
	for(i=0;i<pcount;i++)
	{
	if(c1[i]==1)
	{
	System.out.println(p[i]+"\t"+name[i]+"\t\t"+age[i]+"\t"+phno[i]);
	}
	}
	System.out.println("Passenger list in First class");
	System.out.println("pno \t name \t\t age \t phno");
	for(i=0;i<pcount;i++)
	{
	if(c1[i]==2)
	{
	System.out.println(p[i]+"\t"+name[i]+"\t\t"+age[i]+"\t"+phno[i]);
	}
	}
	System.out.println("Passenger list in Sleeper class");
	System.out.println("pno \t name \t\t age \t phno");
	for(i=0;i<pcount;i++)
	{
	if(c1[i]==3)
	{
	System.out.println(p[i]+"\t"+name[i]+"\t\t"+age[i]+"\t"+phno[i]);
	}
	}
	break;		
		}
		case 4: {
		System.out.println("No. of booked tickets status");
		System.out.println("AC class"+max1);
		System.out.println("First class"+max2);
		System.out.println("Sleeper class"+max3);
		break;
		}
		
		
		default : break;
}
}while(choice!=5);
}
}
