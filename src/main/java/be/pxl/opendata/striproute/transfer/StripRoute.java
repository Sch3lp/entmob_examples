package be.pxl.opendata.striproute.transfer;

import java.time.LocalDateTime;

public class StripRoute {

    private String datasetid;
    private String recordid;
    private StripRouteFields fields;
    private StripRouteGeometry geometry;
    private LocalDateTime record_timestamp;

    public StripRoute(String datasetid, String recordid, StripRouteFields fields, StripRouteGeometry geometry, LocalDateTime record_timestamp) {
        this.datasetid = datasetid;
        this.recordid = recordid;
        this.fields = fields;
        this.geometry = geometry;
        this.record_timestamp = record_timestamp;
    }

    public String getDatasetid() {
        return datasetid;
    }

    public String getRecordid() {
        return recordid;
    }

    public StripRouteFields getFields() {
        return fields;
    }

    public StripRouteGeometry getGeometry() {
        return geometry;
    }

    public LocalDateTime getRecord_timestamp() {
        return record_timestamp;
    }
}
