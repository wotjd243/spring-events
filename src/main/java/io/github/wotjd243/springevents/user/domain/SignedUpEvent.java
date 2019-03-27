package io.github.wotjd243.springevents.user.domain;

import java.util.Objects;

public class SignedUpEvent {
    private final String name;
    private final NotificationSettings notificationSettings;

    public SignedUpEvent(final String name, final NotificationSettings notificationSettings) {
        this.name = name;
        this.notificationSettings = notificationSettings;
    }

    public String getName() {
        return name;
    }

    public NotificationSettings getNotificationSettings() {
        return notificationSettings;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final SignedUpEvent that = (SignedUpEvent) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(notificationSettings, that.notificationSettings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, notificationSettings);
    }
}
