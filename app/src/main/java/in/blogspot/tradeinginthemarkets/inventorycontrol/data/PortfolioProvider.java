/*
 *
 *  Copyright (C) 2016 The Android Open Source Project
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package in.blogspot.tradeinginthemarkets.inventorycontrol.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by anura on 5/27/2017.
 */

public class PortfolioProvider extends ContentProvider {

    private static final int PORTFOLIO = 100;
    private static final int PORTFOLIO_ID = 101;
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        sUriMatcher.addURI(PortfolioContract.CONTENT_AUTHORITY,PortfolioContract.PATH_PORTFOLIO,PORTFOLIO);
        sUriMatcher.addURI(PortfolioContract.CONTENT_AUTHORITY,PortfolioContract.PATH_PORTFOLIO+"/#",PORTFOLIO_ID);
    }
    public static final String LOG_TAG = PortfolioProvider.class.getSimpleName();

    private PortfolioDbHelper mDbHelper;
    @Override
    public boolean onCreate() {
        mDbHelper = new PortfolioDbHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase database =mDbHelper.getReadableDatabase();
        Cursor cursor;
        int match = sUriMatcher.match(uri);
        switch (match)
        {
            case PORTFOLIO:
                cursor = database.query(PortfolioContract.PortfolioEntry.TABLE_NAME,projection,selection,selectionArgs,null,null,sortOrder);
                break;
            case PORTFOLIO_ID:
                selection = PortfolioContract.PortfolioEntry._ID + "=?";
                selectionArgs = new String[] {String.valueOf(ContentUris.parseId(uri))};
                cursor = database.query(PortfolioContract.PortfolioEntry.TABLE_NAME,projection,selection,selectionArgs,null,null,sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Cannot query unknown URI "+uri);
        }
        cursor.setNotificationUri(getContext().getContentResolver(),uri);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
