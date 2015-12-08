package be.pxl.opendata.striproute.transfer;

public class StripRoutePhoto {
    private String format;
    private String thumbnail;
    private int height;
    private int width;
    private String filename;
    private String id;

    public StripRoutePhoto(String format, String thumbnail, int height, int width, String filename, String id) {
        this.format = format;
        this.thumbnail = thumbnail;
        this.height = height;
        this.width = width;
        this.filename = filename;
        this.id = id;
    }
}
