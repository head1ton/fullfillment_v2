package ai.fullfillment_v2.common;

import ai.fullfillment_v2.inbound.api.AddInboundProductApi;
import ai.fullfillment_v2.inbound.api.CreateInboundApi;
import ai.fullfillment_v2.inbound.api.UpdateInboundApi;
import ai.fullfillment_v2.inbound.api.UpdateInboundProductApi;

public class Scenario {

    public static CreateInboundApi createInbound() {
        return new CreateInboundApi();
    }

    public static UpdateInboundApi updateInbound() {
        return new UpdateInboundApi();
    }

    public static UpdateInboundProductApi updateInboundProduct() {
        return new UpdateInboundProductApi();
    }

    public AddInboundProductApi addInboundProduct() {
        return new AddInboundProductApi();
    }
}
