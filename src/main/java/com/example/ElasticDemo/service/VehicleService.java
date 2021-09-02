package com.example.ElasticDemo.service;

import com.example.ElasticDemo.entities.Vehicle;
import com.example.ElasticDemo.helper.Indices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.rest.RestStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The class define service in relation to Vehicle Entity
 */
public class VehicleService {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final Logger LOG = LoggerFactory.getLogger(VehicleService.class);

    private final RestHighLevelClient client;

    @Autowired
    public VehicleService(RestHighLevelClient client) {
        this.client = client;
    }

    public Boolean index(final Vehicle vehicle) {
        try{
            final String vehicleAsString = MAPPER.writeValueAsString(vehicle);

            final IndexRequest request = new IndexRequest(Indices.VEHICLE_INDEX);
            request.id(vehicle.getId());
            request.source(vehicleAsString, XContentType.JSON);

            final IndexResponse response = client.index(request, RequestOptions.DEFAULT);
            return response != null && response.status().equals(RestStatus.OK);
        } catch (final Exception E) {
            LOG.error(E.getMessage(), E);
            return false;
        }
    }

    public Vehicle getById(final String vehicleId) {
        try {
            final GetResponse documentFields = client.get(
              new GetRequest(Indices.VEHICLE_INDEX, vehicleId),
                    RequestOptions.DEFAULT);

            if (documentFields == null || documentFields.isSourceEmpty()) {
               return null;
            }

            return MAPPER.readValue(documentFields.getSourceAsString(),Vehicle.class);
        } catch (final Exception E) {
            LOG.error(E.getMessage(), E);
            return null;
        }
    }
}
