/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package in.blogspot.tradeinginthemarkets.inventorycontrol.data;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import in.blogspot.tradeinginthemarkets.inventorycontrol.data.PortfolioContract.PortfolioEntry;

public class PortfolioDbHelper extends SQLiteOpenHelper{
    public static final String LOG_TAG = PortfolioDbHelper.class.getSimpleName();
    public static final String DATABASE_NAME ="portfolio.db";
    public static final int DATABASE_VERSION = 1;
    public PortfolioDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_PORTFOLIO_TABLE =  "CREATE TABLE " + PortfolioEntry.TABLE_NAME + " ("
                + PortfolioEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PortfolioEntry.COLUMN_SCRIPT + " TEXT NOT NULL, "
                + PortfolioEntry.COLUMN_BUY_PRICE + " INTEGER DEFAULT 0, "
                + PortfolioEntry.COLUMN_BUY_QUANTITY + " INTEGER DEFAULT 0, "
                + PortfolioEntry.COLUMN_SELL_PRICE + " INTEGER DEFAULT 0, "
                + PortfolioEntry.COLUMN_SELL_QUANTITY + " INTEGER DEFAULT 0, "
                + PortfolioEntry.COLUMN_PROFIT_LOSS + " INTEGER  );";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_PORTFOLIO_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
