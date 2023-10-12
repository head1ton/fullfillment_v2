package ai.fullfillment_v2.inbound.feature;

import static org.assertj.core.api.Assertions.assertThat;

import ai.fullfillment_v2.common.ApiTest;
import ai.fullfillment_v2.common.Scenario;
import ai.fullfillment_v2.inbound.domain.Inbound;
import ai.fullfillment_v2.inbound.domain.InboundProduct;
import ai.fullfillment_v2.inbound.domain.InboundRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateInboundProductTest extends ApiTest {

    @Autowired
    private InboundRepository inboundRepository;

    @BeforeEach
    void UpdateInboundProductSetUp() {
        Scenario.createInbound().request();
    }

    @Test
    @DisplayName("입고 상품 수정.")
    @Transactional
    public void updateInboundProduct() {
        Scenario
            .updateInboundProduct().request();

        Inbound after = inboundRepository.findById(1L).get();
        InboundProduct afterProduct = after.getInboundProducts().get(0);

        assertThat(afterProduct.getDescription()).isEqualTo("블랙핑크 입고 수정");
    }

}
