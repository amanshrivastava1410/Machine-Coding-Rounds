package SocialMedia;

import java.util.*;

public class User {
    private final String userId;
    private final List<Post> posts;
    private final Set<String> followers;
    private final Set<String> following;

    public User(String userId) {
        this.userId = userId;
        this.posts = new ArrayList<>();
        this.followers = new HashSet<>();
        this.following = new HashSet<>();
    }

    public String getUserId() {
        return userId;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public Set<String> getFollowers() {
        return followers;
    }

    public Set<String> getFollowing() {
        return following;
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public void deletePost(String postId) {
        posts.removeIf(post -> post.getPostId().equals(postId));
    }

    public void addFollower(String followerId) {
        followers.add(followerId);
    }

    public void removeFollower(String followerId) {
        followers.remove(followerId);
    }

    public void follow(String userId) {
        following.add(userId);
    }

    public void unfollow(String userId) {
        following.remove(userId);
    }
}
