package io.github.wotjd243.springevents.user.application;

import io.github.wotjd243.springevents.user.domain.SignedUpEvent;
import io.github.wotjd243.springevents.user.domain.User;
import io.github.wotjd243.springevents.user.domain.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    private static final long TEST_ID = 1L;
    private static final String TEST_NAME = "Jason";

    @Mock
    private UserRepository userRepository;

    @Mock
    private ApplicationEventPublisher publisher;

    @Captor
    private ArgumentCaptor<Object> publishEventCaptor;

    private UserService userService;

    @Before
    public void setUp() {
        this.userService = new UserService(userRepository, publisher);
    }

    @Test
    public void 회원가입() {
        // given
        // when
        userService.join(TEST_ID, TEST_NAME);

        // then
        verify(userRepository).save(any(User.class));
        verifyPublishedEvents(new SignedUpEvent(TEST_NAME));
    }

    @Test
    public void 회원보기() {
        // given
        given(userRepository.findAll())
                .willReturn(Arrays.asList(new User(TEST_ID, TEST_NAME)))
        ;

        // when
        final List<String> userNames = userService.lookup();

        // then
        assertThat(userNames).containsExactly(TEST_NAME);
    }

    private void verifyPublishedEvents(final Object... events) {
        verify(publisher, times(events.length)).publishEvent(publishEventCaptor.capture());
        assertThat(publishEventCaptor.getAllValues()).contains(events);
    }
}