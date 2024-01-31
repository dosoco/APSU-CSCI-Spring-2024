
package csci2011.dotylab1;

/**
 * CSCI 2011 Lab 1
 * 
 * @author Jason Doty
 * 
 * The Movie Class can be used to create and manage movie objects.
 */
public class DotyLab1 {

    public static void main(String[] args) {
        // Unit test for initialize and display
        System.out.println("Testing initialize and display:");
        Movie movie = new Movie();
        movie.initialize("Blade Runner", "Ridley Scott", 1982);
        movie.display();

        // Unit test for setTitle and getTitle
        System.out.println("Testing setTitle and getTitle:");
        System.out.println("getTitle returns: " + movie.getTitle());
        movie.setTitle("Brazil");
        System.out.println("calling setTitle with argument: Brazil");
        System.out.println("getTitle returns: " + movie.getTitle());

        // Unit tests for equals method
        System.out.println("Testing equals on different titles, same director and year");
        Movie movie1 = new Movie();
        movie1.initialize("The Wasp Woman", "Roger Corman", 1959);
        movie1.display();

        Movie movie2 = new Movie();
        movie2.initialize("A Bucket of Blood", "Roger Corman", 1959);
        movie2.display();

        System.out.println("equals returns " + movie1.equals(movie2));

        System.out.println("Testing equals on different years, same title and director");
        Movie movie3 = new Movie();
        movie3.initialize("Halloween", "John Carpenter", 1978);
        movie3.display();

        Movie movie4 = new Movie();
        movie4.initialize("Halloween", "John Carpenter", 2007);
        movie4.display();

        System.out.println("equals returns " + movie3.equals(movie4));

        System.out.println("Testing equals and == on objects with the same data");
        Movie movie5 = new Movie();
        movie5.initialize("Suspiria", "Dario Argento", 1977);
        movie5.display();

        Movie movie6 = new Movie();
        movie6.initialize("Suspiria", "Dario Argento", 1977);
        movie6.display();

        System.out.println("equals returns " + movie5.equals(movie6));
        System.out.println("== returns " + (movie5 == movie6));

        System.out.println("Testing equals and == on references to the same object");
        Movie movie7 = movie5;
        movie7.display();
        movie5.display();

        System.out.println("equals returns " + movie5.equals(movie7));
        System.out.println("== returns " + (movie5 == movie7));
    }
}

