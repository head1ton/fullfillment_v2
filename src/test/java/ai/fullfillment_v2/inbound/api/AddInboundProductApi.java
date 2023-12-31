package ai.fullfillment_v2.inbound.api;

import ai.fullfillment_v2.common.Scenario;
import ai.fullfillment_v2.inbound.feature.AddInboundProduct;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.springframework.http.HttpStatus;

public class AddInboundProductApi {

    private Long inboundNo = 1L;
    private Long productNo = 1L;
    private Long requestQuantity = 1_000L;
    private Long unitPrice = 15_000L;
    private String description = "블랙핑크 3집 앨범[] - 미입고분 추가 입고";

    public AddInboundProductApi inboundNo(final Long inboundNo) {
        this.inboundNo = inboundNo;
        return this;
    }

    public AddInboundProductApi productNo(final Long productNo) {
        this.productNo = productNo;
        return this;
    }

    public AddInboundProductApi requestQuantity(final Long requestQuantity) {
        this.requestQuantity = requestQuantity;
        return this;
    }

    public AddInboundProductApi unitPrice(final Long unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public AddInboundProductApi description(final String description) {
        this.description = description;
        return this;
    }

    public Scenario request() {

        final AddInboundProduct.Request request = new AddInboundProduct.Request(
            productNo,
            requestQuantity,
            unitPrice,
            description
        );

        RestAssured
            .given().log().all()
            .contentType(ContentType.JSON)
            .body(request)
            .when()
            .post("/inbounds/{inboundNo}/products", inboundNo)
            .then().log().all()
            .statusCode(HttpStatus.CREATED.value());

        return new Scenario();
    }
}
