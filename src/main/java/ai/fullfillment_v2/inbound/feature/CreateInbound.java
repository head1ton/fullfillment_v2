package ai.fullfillment_v2.inbound.feature;

import ai.fullfillment_v2.inbound.domain.Inbound;
import ai.fullfillment_v2.inbound.domain.InboundProduct;
import ai.fullfillment_v2.inbound.domain.InboundRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateInbound {

    private final InboundRepository inboundRepository;

    @Transactional
    @PostMapping("/inbounds")
    @ResponseStatus(HttpStatus.CREATED)
    public void request(@RequestBody @Valid final Request request) {
        final List<InboundProduct> products = request.toProducts();
        final Inbound inbound = request.toDomain();
        inbound.assignProducts(products);

        inboundRepository.save(inbound);
    }

    public record Request(
        @NotBlank(message = "입고 제목은 필수입니다.")
        String title,
        @NotNull(message = "입고 예정일은 필수입니다.")
        LocalDateTime estimatedArrivalAt,
        @NotNull(message = "주문 요청일은 필수입니다.")
        LocalDateTime orderRequestedAt,
        String description,
        @NotEmpty(message = "입고 상품은 필수입니다.")
        List<Request.Product> inboundProducts) {

        public Inbound toDomain() {
            return new Inbound(
                title,
                estimatedArrivalAt,
                orderRequestedAt,
                description
            );
        }

        public List<InboundProduct> toProducts() {
            return inboundProducts.stream()
                                  .map(Request.Product::toDomain)
                                  .toList();
        }

        public record Product(
            @NotNull(message = "상품 번호는 필수입니다.")
            Long productNo,
            @NotNull(message = "상품 입고 요청 수량은 필수입니다.")
            @Min(value = 1, message = "상품 입고 요청 수량은 1개 이상이어야 합니다.")
            Long requestQuantity,
            @NotNull(message = "상품 입고 요청 단가는 필수입니다.")
            @Min(value = 0, message = "상품 입고 요청 단가는 0원 이상이어야 합니다.")
            Long unitPrice,
            String description) {

            public InboundProduct toDomain() {
                return new InboundProduct(
                    productNo,
                    requestQuantity,
                    unitPrice,
                    description
                );
            }
        }
    }
}
