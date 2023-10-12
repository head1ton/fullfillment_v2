package ai.fullfillment_v2.inbound.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.util.Assert;

@Entity
@Table(name = "inbound_product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InboundProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inbound_product_no")
    @Comment("입고 상품 번호")
    private Long inboundProductNo;
    @Column(name = "product_no", nullable = false)
    @Comment("상품 번호")
    private Long productNo;
    @Column(name = "request_quantity", nullable = false)
    @Comment("상품 입고 요청 수량")
    private Long requestQuantity;
    @Column(name = "unit_price", nullable = false)
    @Comment("상품 입고 요청 단가")
    private Long unitPrice;
    @Getter
    @Column(name = "description")
    @Comment("상품 입고 설명")
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inbound_no", nullable = false)
    @Comment("입고 번호")
    private Inbound inbound;
    @Column(name = "is_added", nullable = false)
    @Comment("추가 여부")
    private boolean isAdded;

    public InboundProduct(
        final Long productNo,
        final Long requestQuantity,
        final Long unitPrice,
        final String description) {
        validateConstructor(productNo, requestQuantity, unitPrice);

        this.productNo = productNo;
        this.requestQuantity = requestQuantity;
        this.unitPrice = unitPrice;
        this.description = description;
    }

    private static void validateConstructor(
        final Long productNo,
        final Long requestQuantity,
        final Long unitPrice) {
        Assert.notNull(productNo, "상품 번호는 필수입니다.");
        Assert.notNull(requestQuantity, "상품 입고 요청 수량은 필수입니다.");
        if (requestQuantity < 1) {
            throw new IllegalArgumentException("상품 입고 요청 수량은 1개 이상이어야 합니다.");
        }
        Assert.notNull(unitPrice, "상품 입고 요청 단가는 필수입니다.");
        if (unitPrice < 0) {
            throw new IllegalArgumentException("상품 입고 요청 단가는 0원 이상이어야 합니다.");
        }
    }

    public void assignInbound(final Inbound inbound) {
        Assert.notNull(inbound, "입고는 필수입니다.");
        this.inbound = inbound;
    }

    public void added() {
        isAdded = true;
    }

    void update(
        final Long productNo,
        final Long requestQuantity,
        final Long unitPrice,
        final String description) {
        validateUpdate(productNo, requestQuantity, unitPrice);
        this.productNo = productNo;
        this.requestQuantity = requestQuantity;
        this.unitPrice = unitPrice;
        this.description = description;
    }

    private void validateUpdate(
        final Long productNo,
        final Long requestQuantity,
        final Long unitPrice) {
        Assert.notNull(productNo, "상품 번호는 필수입니다.");
        Assert.notNull(requestQuantity, "상품 입고 요청 수량은 필수입니다.");
        if (1 > requestQuantity) {
            throw new IllegalArgumentException("상품 입고 요청 수량은 1개 이상이어야 합니다.");
        }
        Assert.notNull(unitPrice, "상품 입고 요청 단가는 필수입니다.");
        if (0 > unitPrice) {
            throw new IllegalArgumentException("상품 입고 요청 단가는 0원 이상이어야 합니다.");
        }
    }

    boolean equalsId(final Long inboundProductNo) {
        return this.inboundProductNo.equals(inboundProductNo);
    }
}
