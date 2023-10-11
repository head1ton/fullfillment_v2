package ai.fullfillment_v2.inbound;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CreateInboundTest {

    private CreateInbound createInbound;

    @BeforeEach
    void setUp() {
        createInbound = new CreateInbound();
    }

    @Test
    @DisplayName("입고 생성")
    public void createInbound() {
        String title = "블랙핑크 앨범 입고";
        LocalDateTime estimatedArrivalAt = LocalDateTime.now().plusDays(1L);
        LocalDateTime orderRequestedAt = LocalDateTime.now();
        String description = "23년도 블랙핑크 신규 앨범 주문";
        final CreateInbound.Request request = new CreateInbound.Request(
            title,
            estimatedArrivalAt,
            orderRequestedAt,
            description
        );
        createInbound.request(request);
    }

    private class CreateInbound {

        public void request(final Request request) {
            throw new UnsupportedOperationException("Unsupported request");
        }

        public record Request(
            String title,
            LocalDateTime estimatedArrivalAt,
            LocalDateTime orderRequestedAt,
            String description) {

        }
    }
}
