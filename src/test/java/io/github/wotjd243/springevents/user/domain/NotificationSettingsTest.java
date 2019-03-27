package io.github.wotjd243.springevents.user.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NotificationSettingsTest {
    private static final boolean TEST_RECEIVING = true;

    @Test
    public void 수신_설정() {
        // given
        // when
        final NotificationSettings notificationSettings = new NotificationSettings(TEST_RECEIVING);

        // then
        assertThat(notificationSettings.isReceiving()).isTrue();
    }
}