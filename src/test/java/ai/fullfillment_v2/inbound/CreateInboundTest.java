package ai.fullfillment_v2.inbound;

import static org.assertj.core.api.Assertions.assertThat;

import ai.fullfillment_v2.common.ApiTest;
import ai.fullfillment_v2.inbound.domain.InboundRepository;
import ai.fullfillment_v2.inbound.feature.CreateInbound;
import java.time.LocalDateTime;
import java.util.List;
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

        final CreateInbound.Request.Product product = new CreateInbound.Request.Product(
            1L,
            2_000L,
            15_000L,
            "블랙핑크 3집 앨범[]"
        );

        final CreateInbound.Request request = new CreateInbound.Request(
            "블랙핑크 앨범 입고",
            LocalDateTime.now().plusDays(1L),
            LocalDateTime.now(),
            "23년도 블랙핑크 신규 앨범 주문",
            List.of(product)
        );
        createInbound.request(request);

        assertThat(inboundRepository.findAll()).hasSize(1);
    }

}
