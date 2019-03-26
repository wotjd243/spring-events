package io.github.wotjd243.springevents.user.application;

import io.github.wotjd243.springevents.user.domain.User;
import io.github.wotjd243.springevents.user.domain.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    private static final long TEST_ID = 1L;
    private static final String TEST_NAME = "Jason";

    @Mock
    private UserRepository userRepository;

    @Mock
    private MessageSender emailSender;

    @Mock
    private MessageSender smsSender;

    private UserService userService;

    @Before
    public void setUp() {
        this.userService = new UserService(userRepository, emailSender, smsSender);
    }

    @Test
    public void 회원가입() {
        // given
        // when
        userService.join(TEST_ID, TEST_NAME);

        // then
        verify(userRepository).save(any(User.class));
        verify(emailSender).sendCongratulation(TEST_NAME);
        verify(smsSender).sendCongratulation(TEST_NAME);
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
}