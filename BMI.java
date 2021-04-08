package BMI_Calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BMI {

    private static double convertFeetandInchesToCentimeter(String feet, String inches) {
        double heightInFeet = 0;
        double heightInInches = 0;
        try {
            if (feet != null && feet.trim().length() != 0) {
                heightInFeet = Double.parseDouble(feet);
            }
            if (inches != null && inches.trim().length() != 0) {
                heightInInches = Double.parseDouble(inches);
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Enter Correct Values");
        }
        return (heightInFeet * 30.48) + (heightInInches * 2.54);
    }

    private static void calculateBMI(double height, double weight) {
        //  cm , kg
        System.out.println("Height : " + height + " Weight : " + weight);
        double bmi = (100 * 100 * weight) / (height * height);

        System.out.printf("Your BMI is: %2.2f%n", (bmi));
        printBMICategory(bmi);

    }

    private static void printBMICategory(double bmi) {

        if (bmi < 18.5) {
            System.out.println("You are considered Underweight and possibly Malnourished");
            guideChart(1);
        } else if (bmi < 25) {
            System.out.println("You are within a healthy weight range for young and middle-aged adults");
            guideChart(2);
        } else if (bmi < 30) {
            System.out.println("You are considered Overweight");
            guideChart(3);
        } else {
            System.out.println("You are considered Obese");
            guideChart(4);
        }

    }

    private static void guideChart(int option) {
        System.out.println("\nGuidelines you should Follow : ");
        switch (option) {
            case 1: {
                System.out.println("As you are Considered Underweight. \n1.) It is important that you consumes sufficient" +
                        " amounts of protein, carbohydrates and fats to provide energy for activity, growth and development." +
                        "\n2.) Continue to promote physical activity as part of a normal routine." +
                        "\n3.) Avoid caffeine; promote healthiest drinks such as milk water juice.");
                break;
            }
            case 2: {
                System.out.println("You are already fit and just continue exercise and Eat Healthy.");
                break;
            }
            case 3: {
                System.out.println("Exercise is the formost step for you to make your body fit. You just need some diet" +
                        " control.");
                break;
            }
            case 4: {
                System.out.println("You need Doctor Guidance as soon as possible. You need to reduce your diet and also " +
                        " need to take care of your daily routine. For this you should Exercise daily and should also need" +
                        " some meditation and yoga classes for sure. ");
                break;
            }
            default: {
                System.out.println("Some Error Occured !!!");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;
        double oheight, weight;
        String height, again;

        System.out.println("For Calculation of your BMI, choose from the following options : ");
        do {
            System.out.println("1.) Enter Weight in LBS & Height in Feet and Inches");
            System.out.println("2.) Enter Weight in LBS & Height in CM");
            System.out.println("3.) Enter Weight in KG & Height in Feet and Inches");
            System.out.println("4.) Enter Weight in KG and Height in CM");
            System.out.println("5.) Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    while (true) {
                        System.out.println("Enter your Weight in LBS: ");
                        try {
                            weight = sc.nextDouble();
                            sc.nextLine();
                            if (weight <= 0) {
                                throw new ArithmeticException();
                            }
                            weight = weight * .45359237;
                            break;
                        } catch (InputMismatchException ime) {
                            System.err.println("Error: " + ime.getMessage());
                        } catch (ArithmeticException ae) {
                            System.out.println("Weight can't be less than or equal to zero!");
                        }
                    }

                    while (true) {
                        System.out.println("Enter your Height in Feet and Inches(F'I) : ");

                        try {

                            height = sc.nextLine();

                            String[] res = height.split("'");

                            oheight = convertFeetandInchesToCentimeter(res[0], res[1]);
                            if (oheight <= 0) {
                                throw new ArithmeticException();
                            }
                            break;
                        } catch (InputMismatchException ime) {
                            System.err.println("Error: " + ime.getMessage());

                        } catch (ArithmeticException ae) {
                            System.out.println("Height can't be less than or equal to zero!");

                        } catch (ArrayIndexOutOfBoundsException aibe) {
                            System.out.println("Height should be Input in required Format!");

                        }
                    }
                    calculateBMI(oheight, weight);
                    break;
                }

                case 2: {
                    while (true) {
                        System.out.println("Enter your Weight in LBS: ");
                        try {
                            weight = sc.nextDouble();
                            if (weight <= 0) {
                                throw new ArithmeticException();
                            }
                            weight = weight * .45359237;
                            break;
                        } catch (InputMismatchException ime) {
                            System.err.println("Error: " + ime.getMessage());

                        } catch (ArithmeticException ae) {
                            System.out.println("Weight can't be less than or equal to zero!");

                        }
                    }

                    while (true) {
                        System.out.println("Enter your Height in Centimeter(CM) : ");
                        try {
                            oheight = sc.nextDouble();
                            sc.nextLine();
                            if (oheight <= 0) {
                                throw new ArithmeticException();
                            }
                            break;
                        } catch (InputMismatchException ime) {
                            System.err.println("Error: " + ime.getMessage());

                        } catch (ArithmeticException ae) {
                            System.out.println("Height can't be less than or equal to zero!");

                        }
                    }
                    calculateBMI(oheight, weight);
                    break;
                }

                case 3: {
                    while (true) {
                        System.out.println("Enter your Weight in KG: ");
                        try {
                            weight = sc.nextDouble();
                            sc.nextLine();
                            if (weight <= 0) {
                                throw new ArithmeticException();
                            }
                            break;
                        } catch (InputMismatchException ime) {
                            System.err.println("Error: " + ime.getMessage());

                        } catch (ArithmeticException ae) {
                            System.out.println("Weight can't be less than or equal to zero!");

                        }
                    }

                    while (true) {
                        System.out.println("Enter your Height in Feet and Inches(F'I) : ");
                        try {

                            height = sc.nextLine();

                            String[] res = height.split("'");

                            oheight = convertFeetandInchesToCentimeter(res[0], res[1]);
                            if (oheight <= 0) {
                                throw new ArithmeticException();
                            }
                            break;
                        } catch (InputMismatchException ime) {
                            System.err.println("Error: " + ime.getMessage());

                        } catch (ArithmeticException ae) {
                            System.out.println("Height can't be less than or equal to zero!");

                        } catch (ArrayIndexOutOfBoundsException aibe) {
                            System.out.println("Height should be Input in required Format!");

                        }
                    }
                    calculateBMI(oheight, weight);
                    break;
                }

                case 4: {
                    while (true) {
                        System.out.println("Enter your Weight in KG: ");
                        try {
                            weight = sc.nextDouble();
                            if (weight <= 0) {
                                throw new ArithmeticException();
                            }
                            break;
                        } catch (InputMismatchException ime) {
                            System.err.println("Error: " + ime.getMessage());

                        } catch (ArithmeticException ae) {
                            System.out.println("Weight can't be less than or equal to zero!");

                        }
                    }

                    while (true) {
                        System.out.println("Enter your Height in Centimeter(CM) : ");
                        try {
                            oheight = sc.nextDouble();
                            sc.nextLine();
                            if (oheight <= 0) {
                                throw new ArithmeticException();
                            }
                            break;
                        } catch (InputMismatchException ime) {
                            System.err.println("Error: " + ime.getMessage());
                        } catch (ArithmeticException ae) {
                            System.out.println("Height can't be less than or equal to zero!");
                        }
                    }
                    calculateBMI(oheight, weight);
                    break;
                }

                case 5:
                    System.exit(0);

                default: {
                    System.out.println("Enter Correct Options");
                    sc.nextLine();
                }
            }
            System.out.println("\nDo you want to calculate more?(Y/N)");
            again = sc.nextLine();
        }
        while (again.equalsIgnoreCase("y"));
    }
}
