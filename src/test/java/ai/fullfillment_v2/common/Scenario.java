package ai.fullfillment_v2.common;

import ai.fullfillment_v2.inbound.api.AddInboundProductApi;
import ai.fullfillment_v2.inbound.api.CreateInboundApi;

public class Scenario {

    public static CreateInboundApi createInbound() {
        return new CreateInboundApi();
    }

    public AddInboundProductApi addInboundProduct() {
        return new AddInboundProductApi();
    }
}
