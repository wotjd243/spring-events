package io.github.wotjd243.springevents.user.domain;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class NotificationSettings {
    private boolean receiving;

    private NotificationSettings() {
    }

    public NotificationSettings(final boolean receiving) {
        this.receiving = receiving;
    }

    public boolean isReceiving() {
        return receiving;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final NotificationSettings that = (NotificationSettings) o;
        return receiving == that.receiving;
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiving);
    }
}
