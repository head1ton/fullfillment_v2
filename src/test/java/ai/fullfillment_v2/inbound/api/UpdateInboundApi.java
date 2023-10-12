package ai.fullfillment_v2.inbound.api;

import ai.fullfillment_v2.common.Scenario;
import ai.fullfillment_v2.inbound.feature.UpdateInbound;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;

public class UpdateInboundApi {

    private final Long inboundNo = 1L;
    private String title = "블랙핑크 앨범 수정";
    private LocalDateTime estimatedArrivalAt = LocalDateTime.now().plusDays(1L);
    private LocalDateTime orderRequestedAt = LocalDateTime.now();
    private String description = "23년도 블랙핑크 신규 앨범 주문";

    public UpdateInboundApi title(final String title) {
        this.title = title;
        return this;
    }

    public UpdateInboundApi estimateArrivalAt(final LocalDateTime estimatedArrivalAt) {
        this.estimatedArrivalAt = estimatedArrivalAt;
        return this;
    }

    public UpdateInboundApi orderRequestedAt(final LocalDateTime orderRequestedAt) {
        this.orderRequestedAt = orderRequestedAt;
        return this;
    }

    public UpdateInboundApi description(final String description) {
        this.description = description;
        return this;
    }

    public Scenario request() {
        final UpdateInbound.Request request = new UpdateInbound.Request(
            inboundNo,
            title,
            estimatedArrivalAt,
            orderRequestedAt,
            description
        );

        RestAssured
            .given().log().all()
            .contentType(ContentType.JSON)
            .body(request)
            .when()
            .patch("/inbounds")
            .then().log().all()
            .statusCode(HttpStatus.OK.value());

        return new Scenario();
    }
}
