package ai.fullfillment_v2.inbound.feature;

import static org.assertj.core.api.Assertions.assertThat;

import ai.fullfillment_v2.common.ApiTest;
import ai.fullfillment_v2.common.Scenario;
import ai.fullfillment_v2.inbound.domain.Inbound;
import ai.fullfillment_v2.inbound.domain.InboundRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AddInboundProductTest extends ApiTest {

    @Autowired
    private InboundRepository inboundRepository;

    @Test
    @DisplayName("입고 상품을 추가.")
    @Transactional
    public void addInboundProduct() {
        Scenario.createInbound().request()
                .addInboundProduct().request();

        final Inbound inbound = inboundRepository.findById(1L).get();
        assertThat(inbound.getInboundProducts()).hasSize(2);
    }

}
