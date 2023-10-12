package ai.fullfillment_v2.inbound.feature;

import static org.assertj.core.api.Assertions.assertThat;

import ai.fullfillment_v2.common.ApiTest;
import ai.fullfillment_v2.common.Scenario;
import ai.fullfillment_v2.inbound.domain.Inbound;
import ai.fullfillment_v2.inbound.domain.InboundRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateInboundTest extends ApiTest {

    @Autowired
    private InboundRepository inboundRepository;

    @BeforeEach
    void updateInboundSetUp() {
        Scenario.createInbound().request();
    }

    @Test
    @DisplayName("입고 수정")
    public void updateInbound() {

        Inbound before = inboundRepository.getBy(1L);
        assertThat(before.getTitle()).isEqualTo("블랙핑크 앨범 입고");

        Scenario
            .updateInbound().request();

        Inbound after = inboundRepository.getBy(1L);
        assertThat(after.getTitle()).isEqualTo("블랙핑크 앨범 수정");
    }
}
