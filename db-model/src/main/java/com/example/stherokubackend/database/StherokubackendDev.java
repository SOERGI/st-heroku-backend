/*
 * This file is generated by jOOQ.
*/
package com.example.stherokubackend.database;


import com.example.stherokubackend.database.tables.Profile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class StherokubackendDev extends SchemaImpl {

    private static final long serialVersionUID = -73327175;

    /**
     * The reference instance of <code>stherokubackend_dev</code>
     */
    public static final StherokubackendDev STHEROKUBACKEND_DEV = new StherokubackendDev();

    /**
     * The table <code>stherokubackend_dev.profile</code>.
     */
    public final Profile PROFILE = com.example.stherokubackend.database.tables.Profile.PROFILE;

    /**
     * No further instances allowed
     */
    private StherokubackendDev() {
        super("stherokubackend_dev", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Profile.PROFILE);
    }
}