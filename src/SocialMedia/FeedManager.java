package SocialMedia;

import java.util.*;

public class FeedManager {
    private final Map<String, List<Post>> userPosts;

    public FeedManager() {
        this.userPosts = new HashMap<>();
    }

    public void createPost(String userId, Post post) {
        userPosts.putIfAbsent(userId, new ArrayList<>());
        userPosts.get(userId).add(post);
    }

    public boolean deletePost(String userId, String postId) {
        if (!userPosts.containsKey(userId)) {
            return false;
        }
        return userPosts.get(userId).removeIf(post -> post.getPostId().equals(postId));
    }

    public List<Post> getFeed(String userId, Set<String> following) {
        List<Post> feed = new ArrayList<>();
        if (userPosts.containsKey(userId)) {
            feed.addAll(userPosts.get(userId));
        }
        for (String followee : following) {
            if (userPosts.containsKey(followee)) {
                feed.addAll(userPosts.get(followee));
            }
        }
        feed.sort((p1, p2) -> p2.getTimestamp().compareTo(p1.getTimestamp()));
        return feed;
    }

    public List<Post> getFeedPaginated(String userId, Set<String> following, int page, int pageSize) {
        List<Post> feed = getFeed(userId, following);
        int start = page * pageSize;
        int end = Math.min(start + pageSize, feed.size());
        if (start >= feed.size()) {
            return Collections.emptyList();
        }
        return feed.subList(start, end);
    }
}
