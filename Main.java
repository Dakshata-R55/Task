package Task;
/*
To do is there will be a user -they do tasks.
Here I have created 6 choices for users,
1 is Add task,
2 is List the tasks,
3 is to update the task,
4 is to delete the task,
5 is to update the status of the task,
6 is to exit.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        User[] userArray = new User[10];

        while (true) {

            System.out.println("Welcome to Task Manager");
            System.out.println("Enter Username");
            String userName = sc.nextLine();

            boolean isExistUser = false;
            User currentUser=null;
            for (int count = 0; count < userArray.length; count++)
            {

                if (userArray[count] != null)
                {
                    if ((userArray[count].getUserName()).equals(userName))
                    {
                        isExistUser = true;
                        currentUser = userArray[count];
                    }
                }
                if (isExistUser == false){
                    currentUser = new User(userName);
                    userArray[count] = currentUser;
                }

            }

            Integer choice = 0;

            while (choice != 6) {
                System.out.print("welcome :");
                System.out.println(currentUser.getUserName());
                System.out.println("1 Add task");
                System.out.println("2 List all task");
                System.out.println("3 update");
                System.out.println("4 Delete");
                System.out.println("5 Status");
                System.out.println("6 Exit");

                System.out.println("Please enter your choice below");
                choice = new Integer(sc.nextLine());

                if (choice == 1) {//To add the tasks

                    System.out.println("Enter your Task Description");
                    String taskDes = sc.nextLine();
                    Task userTask = new Task(taskDes);

                    for (int count = 0; count < currentUser.getUserTask().length; count++)
                    {
                        if (currentUser.getUserTask()[count] == null)
                        {
                            currentUser.getUserTask()[count] = userTask;
                            break;
                        }
                    }
                    System.out.println("your task added successfully");

                }
                else if (choice == 2)//List of tha tasks
                {
                    boolean isThereTask = false;

                    for (int count = 0; count < currentUser.getUserTask().length; count++)
                    {
                        if (currentUser.getUserTask()[count] != null) {
                            String taskDescription = currentUser.getUserTask()[count].getTaskDes();
                            System.out.print("your task : ");
                            System.out.println(taskDescription);
                            System.out.print("Status of the task : ");
                            if(currentUser.getUserTask()[count].getStatus()!=null){
                                System.out.println(currentUser.getUserTask()[count].getStatus());}
                            else if(currentUser.getUserTask()[count].getStatus()==null){System.out.println("There was no status");}
                            isThereTask = true;
                        }

                    }
                    if (isThereTask == false)
                    {
                        System.out.println("There was no task");
                    }
                } else if (choice == 3) {//update
                    boolean isupdate = false;
                    int replacement = 0;
                    for (int count = 0; count < currentUser.getUserTask().length; count++) {
                        if (currentUser.getUserTask()[count] != null) {
                            replacement = count + 1;
                            System.out.print(replacement );
                            System.out.print(" ");
                            System.out.print( currentUser.getUserTask()[count].getTaskDes());
                            System.out.print(" ");
                            System.out.println(currentUser.getUserTask()[count].getStatus());
                            isupdate = true;
                        }
                    }
                    if (isupdate == false) {
                        System.out.println("There was no task");
                        break;
                    }
                    while (true) {
                        System.out.println("Enter the task number which you want to update ");
                        Integer option = new Integer(sc.nextLine());
                        if (option <= replacement) {
                            int i = option - 1;
                            System.out.println("Update the task");
                            String update = new String(sc.nextLine());
                            currentUser.getUserTask()[i].setTaskDes(update);
                            System.out.println("Task updated successfully");
                            break;
                        } else {
                            System.out.println("Enter the correct task option to delete ");
                        }
                    }
                } else if (choice == 4)
                {//delete
                    boolean isdelete = false;
                    int replacement = 0;
                    for (int count = 0; count < currentUser.getUserTask().length; count++)
                    {
                        if (currentUser.getUserTask()[count] != null)
                        {
                            replacement = count + 1;
                            System.out.print(replacement);
                            System.out.println(currentUser.getUserTask()[count].getTaskDes());
                            isdelete = true;
                        }
                    }
                    if (isdelete == false)
                    {
                        System.out.println("There was no task");
                        break;
                    }
                    while (true)
                    {
                        System.out.println("Enter the task number which you want to delete ");//
                        Integer option = new Integer(sc.nextLine());
                        if (option <= replacement)
                        {
                            int i = option - 1;
                            currentUser.getUserTask()[i] = null;
                            System.out.println("Task deleted successfully");
                            break;
                        }
                        else
                        {
                            System.out.println("Enter the correct task option to delete");
                        }
                    }
                    for (int i = 0; i < currentUser.getUserTask().length; i++) //rearrangement
                    {
                        if (currentUser.getUserTask()[i] != null)
                        {
                            continue;
                        }
                        for (int j = i + 1; j < currentUser.getUserTask().length; j++)
                        {
                            if (currentUser.getUserTask()[j] != null)
                            {
                                currentUser.getUserTask()[i] = currentUser.getUserTask()[j];
                                currentUser.getUserTask()[j] = null;
                                break;
                            }
                        }
                    }
                }
                else if (choice == 6) //exit
                {
                    System.out.println("Thanks");
                }

                else if (choice == 5) //Status update
                {
                    int replacement = 0;
                    for (int count = 0; count < currentUser.getUserTask().length; count++)
                    {
                        if (currentUser.getUserTask()[count] != null)
                        {
                            replacement = count + 1;
                            System.out.print(replacement);
                            System.out.println(currentUser.getUserTask()[count].getTaskDes());
                        }
                    }
                    System.out.println("Which task you want to update");
                    Integer status = new Integer(sc.nextLine());
                    System.out.println("Update the task status");
                    System.out.println("1 Start");
                    System.out.println("2 In progress");
                    System.out.println("3 progress done");
                    String task = sc.nextLine();
                    int opt=status-1;
                    currentUser.getUserTask()[opt].setStatus(task);
                    System.out.println(currentUser.getUserTask()[opt].getTaskDes());
                    System.out.println(currentUser.getUserTask()[opt].getStatus());
                    System.out.println("Your task status updated successfully");
                }
            }
        }
    }
}
