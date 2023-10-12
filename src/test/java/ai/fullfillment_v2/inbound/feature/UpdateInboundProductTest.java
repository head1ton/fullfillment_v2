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
        updateInboundProduct.request();
    }

    private class UpdateInboundProduct {

        public void request() {
            throw new UnsupportedOperationException("Unsupported request");
        }
    }
}
