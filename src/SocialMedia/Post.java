package SocialMedia;

import java.time.LocalDateTime;
import java.util.UUID;

public class Post {
    private final String postId;
    private final String userId;
    private final String content;
    private final LocalDateTime timestamp;

    public Post(String userId, String content) {
        this.postId = UUID.randomUUID().toString();
        this.userId = userId;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public String getPostId() {
        return postId;
    }

    public String getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
