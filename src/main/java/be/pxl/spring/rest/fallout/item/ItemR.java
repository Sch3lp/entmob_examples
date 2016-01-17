package be.pxl.spring.rest.fallout.item;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemR {

    private String id;
    private String name;
    private String holder;

    @JsonCreator
    public ItemR(@JsonProperty("id")String id, @JsonProperty("name") String name, @JsonProperty("holder") String holder) {
        this.id = id;
        this.name = name;
        this.holder = holder;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String location) {
        this.holder = location;
    }
}
