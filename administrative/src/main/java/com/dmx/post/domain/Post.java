package com.dmx.post.domain;

import com.dmx.shared.domain.PostId;
import com.dmx.shared.domain.SpaceId;
import com.dmx.user.domain.User;

public class Post {
    private final PostId id;
    private final PostTitle title;
    private final PostContent content;
    private final PostCreationDate creationDate;
    private final SpaceId spaceId;
    private final User user;

    public Post(PostId id, PostTitle title, PostContent content, PostCreationDate creationDate, SpaceId spaceId, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.spaceId = spaceId;
        this.user = user;
    }

    public static Post fromPrimitives(PostDTO data){
        return new Post(
                new PostId(data.id()),
                new PostTitle(data.title()),
                new PostContent(data.content()),
                new PostCreationDate(data.creationDate()),
                new SpaceId(data.spaceId()),
                User.fromPrimitives(data.user())
        );
    }

    public PostDTO toPrimitives(){
        return new PostDTO(
                this.id.value(),
                this.title.value(),
                this.content.value(),
                this.creationDate.value(),
                this.spaceId.value(),
                this.user.toPrimitives()
        );
    }

    public PostId getId() {
        return id;
    }

    public PostTitle getTitle() {
        return title;
    }

    public PostContent getContent() {
        return content;
    }

    public PostCreationDate getCreationDate() {
        return creationDate;
    }

    public SpaceId getSpaceId() {
        return spaceId;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title=" + title +
                ", content=" + content +
                ", creationDate=" + creationDate +
                ", spaceId=" + spaceId +
                ", user=" + user +
                '}';
    }
}