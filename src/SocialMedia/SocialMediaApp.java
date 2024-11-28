package SocialMedia;

import java.util.*;

public class SocialMediaApp {
    private final Map<String, User> users;
    private final FeedManager feedManager;

    public SocialMediaApp() {
        this.users = new HashMap<>();
        this.feedManager = new FeedManager();
    }

    public void createUser(String userId) {
        if (users.containsKey(userId.toLowerCase())) {
            System.out.println("Username already exists.");
            return;
        }
        users.put(userId.toLowerCase(), new User(userId));
        System.out.println("User created: " + userId);
    }

    public void createPost(String userId, String content) {
        User user = users.get(userId.toLowerCase());
        if (user == null) {
            System.out.println("User does not exist.");
            return;
        }
        Post post = new Post(userId, content);
        feedManager.createPost(userId.toLowerCase(), post);
        user.addPost(post);
        System.out.println("Post created by " + userId + ": " + post.getContent());
    }

    public void deletePost(String userId, String postId) {
        User user = users.get(userId.toLowerCase());
        if (user == null) {
            System.out.println("User does not exist.");
            return;
        }
        boolean removedFromFeedManager = feedManager.deletePost(userId.toLowerCase(), postId);
        user.deletePost(postId);
        if (removedFromFeedManager) {
            System.out.println("Post deleted successfully.");
        } else {
            System.out.println("Post not found.");
        }
    }

    public void follow(String followerId, String followeeId) {
        if (!users.containsKey(followerId.toLowerCase()) || !users.containsKey(followeeId.toLowerCase())) {
            System.out.println("One or both users do not exist.");
            return;
        }
        users.get(followerId.toLowerCase()).follow(followeeId.toLowerCase());
        users.get(followeeId.toLowerCase()).addFollower(followerId.toLowerCase());
        System.out.println(followerId + " is now following " + followeeId);
    }

    public void unfollow(String followerId, String followeeId) {
        User follower = users.get(followerId.toLowerCase());
        User followee = users.get(followeeId.toLowerCase());
        if (follower == null || followee == null) {
            System.out.println("One or both users do not exist.");
            return;
        }
        follower.unfollow(followeeId.toLowerCase());
        followee.removeFollower(followerId.toLowerCase());
        System.out.println(followerId + " has unfollowed " + followeeId);
    }

    public void displayFeed(String userId) {
        User user = users.get(userId.toLowerCase());
        if (user == null) {
            System.out.println("User does not exist.");
            return;
        }
        List<Post> feed = feedManager.getFeed(userId.toLowerCase(), user.getFollowing());
        System.out.println("Feed for " + userId + ":");
        for (Post post : feed) {
            System.out.println("[" + post.getTimestamp() + "] " + post.getUserId() + ": " + post.getContent());
        }
    }

    public void displayFeedPaginated(String userId, int page, int pageSize) {
        User user = users.get(userId.toLowerCase());
        if (user == null) {
            System.out.println("User does not exist.");
            return;
        }
        List<Post> feed = feedManager.getFeedPaginated(userId.toLowerCase(), user.getFollowing(), page, pageSize);
        System.out.println("Feed (Page " + page + ") for " + userId + ":");
        for (Post post : feed) {
            System.out.println("[" + post.getTimestamp() + "] " + post.getUserId() + ": " + post.getContent());
        }
    }
}
