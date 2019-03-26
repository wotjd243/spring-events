package io.github.wotjd243.springevents.user.domain;

import java.util.Objects;

public class SignedUpEvent {
    private final String name;

    public SignedUpEvent(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final SignedUpEvent that = (SignedUpEvent) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
