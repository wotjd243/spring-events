package io.github.wotjd243.springevents.user.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private Long id;
    private String name;

    @Embedded
    private NotificationSettings notificationSettings;

    private User() {
    }

    public User(final Long id, final String name, final NotificationSettings notificationSettings) {
        this.id = id;
        this.name = name;
        this.notificationSettings = notificationSettings;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public NotificationSettings getNotificationSettings() {
        return notificationSettings;
    }
}
