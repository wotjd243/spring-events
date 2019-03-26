package io.github.wotjd243.springevents.user.infra;

import io.github.wotjd243.springevents.user.application.MessageSender;
import io.github.wotjd243.springevents.user.domain.SignedUpEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmsSenderTest {
    private static final String TEST_NAME = "Jason";

    @Autowired
    private MessageSender smsSender;

    @Test
    public void 문자_발송() {
        // given
        // when
        // then
        smsSender.sendCongratulation(new SignedUpEvent(TEST_NAME));
    }
}