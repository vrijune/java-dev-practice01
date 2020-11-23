package ictgradschool.industry.task01.pie;

public class GoodPieBakingCompetition {

    public static void main(String[] args) {
        GoodPieBakingCompetition goodPie = new GoodPieBakingCompetition();
        goodPie.start();
    }

    private void start() {
        System.out.print("Please enter the name of the first contestant: ");
        String contestant1 = getNameFromUser();

        System.out.print("Please enter the name of the second contestant: ");
        String contestant2 = getNameFromUser();

        System.out.print("Please enter the name of the third contestant: ");
        String contestant3 = getNameFromUser();

        System.out.print("Please enter an integer number greater than 0: ");
        int min = getIntFromUser(0);

        System.out.print("Please enter an integer number greater than " + min + ": ");
        int max = getIntFromUser(min);

        printMinAndMaxFromUser(min, max);

        int pieSize1 = getRandomPieSize(min, max);
        int pieSize2 = getRandomPieSize(min, max);
        int pieSize3 = getRandomPieSize(min, max);

        printContestantAndPieCircumference(contestant1, pieSize1);
        printContestantAndPieCircumference(contestant2, pieSize2);
        printContestantAndPieCircumference(contestant3, pieSize3);

        printPieSize(pieSize1, pieSize2, pieSize3);
        String winner = getWinner(contestant1, contestant2, contestant3);
        System.out.println("The winner is " + winner + "!!!");
    }

    // TODO A. Get a name from the user input
    private String getNameFromUser() {
        String name = Keyboard.readInput();
        return name;
    }

    // TODO B. Get an integer from the user. If the integer is less than or equal to the lower bound, ask the user to enter
    // the integer again
    private int getIntFromUser(int lowerBound) {
        int number = Integer.parseInt(Keyboard.readInput());

        while (number <= lowerBound) {
            System.out.println("Please enter an integer number greater than 0:");
            number = Integer.parseInt(Keyboard.readInput());
        }

        return number;
    }

    // TODO C. Print the minimum and maximum radius from the given values
    private void printMinAndMaxFromUser(int min, int max) {
        min = Math.min(min, max);
        max = Math.max(min, max);
        System.out.println("The minimum radius of a pie is :" + min + "The maximun radius of a pie is :" + max
        );

    }

    // TODO D. Generate a random number between the given ranges and calculate the circumference using the random number as
    // TODO the radius. Return the value as an integer.
    // TODO circumference = 2 * PI * radius
    private int getRandomPieSize(int min, int max) {
        int randomNumber = (int) (Math.random() * (max - min));
        double circumference = 2 * Math.PI * randomNumber;
        int value = (int) (circumference);

        return value;
    }

    // TODO E. Get the pie category based on the given value
    // If the size > 500, return "extra large"; If the size > 100, return "large";
    // If the size > 40, return "medium"; If the size > 10, return "small"; else return "extra small";
    private String getPieCategory(int size) {
        if (size > 500) {
            return "extra large";
        } else if (size > 100 && size <= 500) {
            return "large";
        } else if (size > 40 && size <= 100) {
            return "medium";
        } else if (size > 10 && size <= 40) {
            return "small";
        } else return "extra small";
    }

    // TODO F. Get the initial from the given contestant name
    private String getContestantInitial(String contestant) {


        char initial = contestant.charAt(0);

        return Character.toString(initial);

    }

    // TODO G. Print the following message on console (don't forget to use the methods created previously)
    // [initial] baked a [size]", which is [pie category]
    private void printContestantAndPieCircumference(String contestant, int size) {

        String initial = getContestantInitial(contestant);
        System.out.println(initial + "baked a " + contestant + "," + " which is" + size);

    }

    // TODO H. Print the given values in descending order. Do not use conditionals.
    private void printPieSize(int pieSize1, int pieSize2, int pieSize3) {
        int largestpie = Math.max(Math.max(pieSize1, pieSize2), pieSize3);
        int secondpie = Math.min(Math.max(pieSize1, pieSize2), pieSize3);
        int thirdpie = Math.min(Math.min(pieSize1, pieSize2), pieSize3);

        pieSize1 = largestpie;
        pieSize2 = secondpie;
        pieSize3 = thirdpie;


        System.out.println("The pie sizes are: " + pieSize1 + ", " + pieSize2 + ", " + pieSize3);
    }

    // TODO I. Generate a random number between 1 - 100 and return the remainder of the random number after dividing by 3
    private int getWinnerNumber() {
        double randomNumber = (Math.random() * (100) + 1);
        int reminder = (int) randomNumber % 3;

        return reminder;
    }

    // TODO J. Get the winner's name using the method created in I.
    // If the winner number is 0, the winner is contestant1;
    // If the winner number is 1, the winner is contestant2;
    // If the winner number is 2, the winner is contestant3;
    private String getWinner(String contestant1, String contestant2, String contestant3) {

        int reminder = getWinnerNumber();
        if (reminder == 0) {
            return "the winner is " + contestant1;
        } else if (reminder == 1) {
            return "the winner is " + contestant2;
        } else if (reminder == 2) {
            return "the winner is " + contestant3;
        }
        else {
            return "Error";
        }
    }
}

