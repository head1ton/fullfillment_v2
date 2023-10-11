package ai.fullfillment_v2.inbound.feature;

import static org.assertj.core.api.Assertions.assertThat;

import ai.fullfillment_v2.common.ApiTest;
import ai.fullfillment_v2.common.Scenario;
import ai.fullfillment_v2.inbound.domain.InboundRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateInboundTest extends ApiTest {

    @Autowired
    private CreateInbound createInbound;
    @Autowired
    private InboundRepository inboundRepository;

    @Test
    @DisplayName("입고 생성")
    public void createInbound() {

        Scenario.createInbound().request();

        assertThat(inboundRepository.findAll()).hasSize(1);
    }

}
