package com.ada.flicks.models;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by ada on 9/26/16.
 */
@Database(name = FlicksDatabase.NAME, version = FlicksDatabase.VERSION)
public class FlicksDatabase {
    public static final String NAME = "flacksDB";
    public static final int VERSION = 1;
}
