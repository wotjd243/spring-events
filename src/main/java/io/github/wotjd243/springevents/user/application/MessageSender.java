package io.github.wotjd243.springevents.user.application;

import io.github.wotjd243.springevents.user.domain.SignedUpEvent;

public interface MessageSender {
    void sendCongratulation(SignedUpEvent event);
}
