package org.opensrp.etl.entity;

import org.ektorp.support.CouchDbDocument;
import org.ektorp.support.TypeDiscriminator;

public class HouseHold extends CouchDbDocument {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @TypeDiscriminator
    private String id;

    public HouseHold() {
        // TODO Auto-generated constructor stub
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
