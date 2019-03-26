package io.github.wotjd243.springevents.user.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    private static final long TEST_ID = 1L;
    private static final String TEST_NAME = "Jason";

    @Test
    public void 회원_생성() {
        // given
        // when
        final User user = new User(TEST_ID, TEST_NAME);

        // then
        assertThat(user.getId()).isEqualTo(TEST_ID);
        assertThat(user.getName()).isEqualTo(TEST_NAME);
    }
}