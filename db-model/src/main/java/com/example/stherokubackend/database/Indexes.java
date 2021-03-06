/*
 * This file is generated by jOOQ.
*/
package com.example.stherokubackend.database;


import com.example.stherokubackend.database.tables.Profile;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>stherokubackend_dev</code> 
 * schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index PROFILE_PKEY = Indexes0.PROFILE_PKEY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index PROFILE_PKEY = Internal.createIndex("profile_pkey", Profile.PROFILE, new OrderField[] { Profile.PROFILE.ID }, true);
    }
}
