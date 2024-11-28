package SocialMedia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SocialMediaApp app = new SocialMediaApp();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Create User");
            System.out.println("2. Create Post");
            System.out.println("3. Delete Post");
            System.out.println("4. Follow User");
            System.out.println("5. Unfollow User");
            System.out.println("6. Display Feed");
            System.out.println("7. Display Feed Paginated");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    app.createUser(userName);
                    System.out.println("User created: " + userName);
                    break;

                case 2:
                    System.out.print("Enter user name: ");
                    String postUserName = scanner.nextLine();
                    System.out.print("Enter post content: ");
                    String content = scanner.nextLine();
                    app.createPost(postUserName, content);
                    break;

                case 3:
                    System.out.print("Enter user name: ");
                    String deleteUserName = scanner.nextLine();
                    System.out.print("Enter post ID: ");
                    String deletePostId = scanner.nextLine();
                    app.deletePost(deleteUserName, deletePostId);
                    System.out.println("Attempted to delete post.");
                    break;

                case 4:
                    System.out.print("Enter your name: ");
                    String followerName = scanner.nextLine();
                    System.out.print("Enter name of the person you want to follow: ");
                    String followeeName = scanner.nextLine();
                    app.follow(followerName, followeeName);
                    System.out.println(followerName + " is now following " + followeeName);
                    break;

                case 5:
                    System.out.print("Enter your name: ");
                    String unfollowerName = scanner.nextLine();
                    System.out.print("Enter name of the person you want to unfollow: ");
                    String unfolloweeName = scanner.nextLine();
                    app.unfollow(unfollowerName, unfolloweeName);
                    System.out.println(unfollowerName + " has unfollowed " + unfolloweeName);
                    break;

                case 6:
                    System.out.print("Enter your name: ");
                    String feedUserName = scanner.nextLine();
                    app.displayFeed(feedUserName);
                    break;

                case 7:
                    System.out.print("Enter your name: ");
                    String paginatedUserName = scanner.nextLine();
                    System.out.print("Enter page number: ");
                    int page = scanner.nextInt();
                    System.out.print("Enter page size: ");
                    int pageSize = scanner.nextInt();
                    scanner.nextLine();
                    app.displayFeedPaginated(paginatedUserName, page, pageSize);
                    break;

                case 8:
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
            System.out.println();
        }

        scanner.close();
    }
}

