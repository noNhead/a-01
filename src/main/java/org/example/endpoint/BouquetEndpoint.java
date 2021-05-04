package org.example.endpoint;

import org.example.data.gen.GetBouquetRequest;
import org.example.data.gen.GetBouquetResponse;
import org.example.repo.BouquetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BouquetEndpoint {
    private static final String NAMESPACE_URI = "http://www.example.org/data/gen";

    private final BouquetRepo bouquetRepo;

    @Autowired
    public BouquetEndpoint(BouquetRepo bouquetRepo) {
        this.bouquetRepo = bouquetRepo;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBouquetRequest")
    @ResponsePayload
    public GetBouquetResponse getBouquetResponse(@RequestPayload GetBouquetRequest request) {
        GetBouquetResponse response = new GetBouquetResponse();
        response.setBouquet(bouquetRepo.select(request.getName()));
        return response;
    }
}
