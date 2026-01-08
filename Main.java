package Task;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User[] userArray = new User[5];

        while (true) {

            System.out.println("Welcome to Task Manager");
            System.out.println("Enter Username");
            String userName = sc.nextLine();
            boolean isExistUser = false;
            int currentUsePosition = 0;

            for (int count = 0; count < userArray.length; count++) {

                if (userArray[count] == null) {
                    continue;
                }
                User user = userArray[count];
                String name = user.getUserName();

                if (name.equals(userName)) {
                    isExistUser = true;
                    currentUsePosition = count;
                    break;
                }
            }

            User currentUser;
            if (isExistUser == false) {
                currentUser = new User(userName);

                for (int count = 0; count < userArray.length; count++) {
                    if (userArray[count] == null) {
                        userArray[count] = currentUser;
                        break;
                    }

                }
            } else {
                currentUser = userArray[currentUsePosition];
            }

            Integer choice = 0;

            while (choice != 5) {
                System.out.print("welcome :");
                System.out.println(currentUser.getUserName());
                System.out.println("1 Add task");
                System.out.println("2 List all task");
                System.out.println("3 update");
                System.out.println("4 Delete");
                System.out.println("5 Exit");
                System.out.println("Please enter your choice below");
                choice = new Integer(sc.nextLine());

                if (choice == 1) {
                    System.out.println("Enter your Task Description");
                    String taskDes = sc.nextLine();
                    Task userTask = new Task(taskDes);

                    for (int count = 0; count < currentUser.getUserTask().length; count++) {
                        if (currentUser.getUserTask()[count] == null) {
                            currentUser.getUserTask()[count] = userTask;
                            break;
                        }

                    }
                    System.out.println("your task added successfully");
                }
                else if (choice == 2) {
                    boolean isThereTask = false;

                    for (int count = 0; count < currentUser.getUserTask().length; count++) {
                        if (currentUser.getUserTask()[count] != null) {
                            String taskDescription = currentUser.getUserTask()[count].getTaskDes();
                            System.out.print("you completed the task :");
                            System.out.println(taskDescription);
                            isThereTask = true;
                        }

                    }
                    if (isThereTask == false) {
                        System.out.println("There was no task");
                    }}
                    else if(choice == 3){

                        for (int count = 0; count < currentUser.getUserTask().length; count++) {
                            if (currentUser.getUserTask()[count] != null) {
                                int replacement = count + 1;
                                System.out.println(replacement);
                                System.out.println(currentUser.getUserTask()[count].getTaskDes());
                                System.out.println("Enter the task number which you want to update ");
                                Integer option = new Integer(sc.nextLine());
                                int i = option - 1;
                                System.out.println("Update the task");
                                String update=new String(sc.nextLine());
                                currentUser.getUserTask()[i].setTaskDes(update);
                                System.out.println("Task updated successfully");
                                
                            }
                        }
                        
                        System.out.println("There was no task");
                    }

                    else if(choice == 4){

                        for (int count = 0; count < currentUser.getUserTask().length; count++) {
                            if (currentUser.getUserTask()[count] != null) {
                                int replacement = count + 1;
                                System.out.println(replacement);
                                System.out.println(currentUser.getUserTask()[count].getTaskDes());
                                System.out.println("Enter the tash number which you want to delete ");
                                Integer option = new Integer(sc.nextLine());
                                int i = option - 1;
                                currentUser.getUserTask()[i] = null;
                                System.out.println("Task deleted successfully");
                                
                            }
                        }
                        System.out.println("There was no task");
                    }
                    else if (choice == 5) {
                        System.out.println("Thanks");
                    }
                }
            }
        }
    }


