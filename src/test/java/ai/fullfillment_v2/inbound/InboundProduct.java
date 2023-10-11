package ai.fullfillment_v2.inbound;

import org.springframework.util.Assert;

public class InboundProduct {

    private final Long productNo;
    private final Long requestQuantity;
    private final Long unitPrice;
    private final String description;
    private Inbound inbound;
    private boolean isAdded;

    public InboundProduct(
        final Long productNo,
        final Long requestQuantity,
        final Long unitPrice,
        final String description) {
        Assert.notNull(productNo, "상품 번호는 필수입니다.");
        Assert.notNull(requestQuantity, "상품 입고 요청 수량은 필수입니다.");
        if (requestQuantity < 1) {
            throw new IllegalArgumentException("상품 입고 요청 수량은 1개 이상이어야 합니다.");
        }
        Assert.notNull(unitPrice, "상품 입고 요청 단가는 필수입니다.");
        if (unitPrice < 0) {
            throw new IllegalArgumentException("상품 입고 요청 단가는 0원 이상이어야 합니다.");
        }

        this.productNo = productNo;
        this.requestQuantity = requestQuantity;
        this.unitPrice = unitPrice;
        this.description = description;
    }

    public void assignInbound(final Inbound inbound) {
        Assert.notNull(inbound, "입고는 필수입니다.");
        this.inbound = inbound;
    }
}
