/*
 * SENG2200 Programming Languages & Paradigms
 * Assignment 1 (100 marks, 10%) - Due March 19, 23:59
 * 
 * Student Name: NI ZENG
 * Student Number: C3238805
 */
import java.io.*;
import java.util.Scanner;

class PA1{
	public static void main( String[] args) throws IOException {
		
        MyPolygons list1 = new MyPolygons();
        MyPolygons list2 = new MyPolygons();
        String fileName = args[0]; 
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
		 
		String inputStream = "";

		try {
			while (scan.hasNext()) { 
				inputStream = scan.next();

				if (inputStream.equals("P")) {  

					 int polNo = scan.nextInt(); 
					 Polygon p = new Polygon(polNo);
					 Point[] pol = new Point[polNo];
					int i = 1, j = 0;

					while (i <= polNo) {
						 double x = scan.nextDouble();
						 double y = scan.nextDouble();
						pol[j] = new Point(x, y);
						p.addPoint(x, y);
                       
						i++;
					}
                    p.areaCal(polNo);
					list1.add(p);
                    list2.addInOrder(p);
				}
			}
		} catch ( Exception e) {
			System.out.println("File Not Found");
		}

        
        System.out.println("Unsorted list");
        list1.printNodes();

        System.out.println("\nSorted list");
        list2.printNodes();
		
	}
}