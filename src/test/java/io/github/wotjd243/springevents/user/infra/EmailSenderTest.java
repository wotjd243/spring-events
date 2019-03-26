package io.github.wotjd243.springevents.user.infra;

import io.github.wotjd243.springevents.user.application.MessageSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailSenderTest {
    private static final String TEST_NAME = "Jason";

    @Autowired
    private MessageSender emailSender;

    @Test
    public void 이메일_발송() {
        // given
        // when
        // then
        emailSender.sendCongratulation(TEST_NAME);
    }
}