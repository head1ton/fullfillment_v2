package ai.fullfillment_v2.inbound.feature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UpdateInboundProductTest {

    private UpdateInboundProduct updateInboundProduct;

    @BeforeEach
    void setUp() {
        updateInboundProduct = new UpdateInboundProduct();
    }

    @Test
    @DisplayName("입고 상품 수정.")
    public void updateInboundProduct() {
        Long productNo = 1L;
        Long requestQuantity = 1_000L;
        Long unitPrice = 15_000L;
        String description = "블랙핑크 입고 수정";

        final UpdateInboundProduct.Request request = new UpdateInboundProduct.Request(
            productNo,
            requestQuantity,
            unitPrice,
            description
        );
        updateInboundProduct.request(request);
    }

    private class UpdateInboundProduct {

        public void request(final Request request) {
            throw new UnsupportedOperationException("Unsupported request");
        }

        public record Request(
            Long productNo,
            Long requestQuantity,
            Long unitPrice,
            String description) {

        }
    }
}
