package io.github.wotjd243.springevents.user.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    private static final long TEST_ID = 1L;
    private static final String TEST_NAME = "Jason";
    private static final NotificationSettings TEST_NOTIFICATION_SETTINGS = new NotificationSettings(true);

    @Test
    public void 회원_생성() {
        // given
        // when
        final User user = new User(TEST_ID, TEST_NAME, TEST_NOTIFICATION_SETTINGS);

        // then
        assertThat(user.getId()).isEqualTo(TEST_ID);
        assertThat(user.getName()).isEqualTo(TEST_NAME);
        assertThat(user.getNotificationSettings()).isEqualTo(TEST_NOTIFICATION_SETTINGS);
    }
}