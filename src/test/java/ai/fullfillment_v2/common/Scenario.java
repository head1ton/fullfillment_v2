package ai.fullfillment_v2.common;

import ai.fullfillment_v2.inbound.api.AddInboundProductApi;
import ai.fullfillment_v2.inbound.api.CreateInboundApi;
import ai.fullfillment_v2.inbound.api.UpdateInboundApi;

public class Scenario {

    public static CreateInboundApi createInbound() {
        return new CreateInboundApi();
    }

    public static UpdateInboundApi updateInbound() {
        return new UpdateInboundApi();
    }

    public AddInboundProductApi addInboundProduct() {
        return new AddInboundProductApi();
    }
}
