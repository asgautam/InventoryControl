
/*
 *
 *  * Copyright (C) 2016 The Android Open Source Project
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package in.blogspot.tradeinginthemarkets.inventorycontrol.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by anura on 5/27/2017.
 */

public class PortfolioContract {
    public static final String CONTENT_AUTHORITY = "com.example.android.pets";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_PORTFOLIO = "portfolio";
    public PortfolioContract() {
    }
    public static final class PortfolioEntry implements BaseColumns{
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PORTFOLIO);
        public final static String TABLE_NAME = "portfolio";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_SCRIPT ="script";
        public final static String COLUMN_BUY_PRICE ="buy_price";
        public final static String COLUMN_SELL_PRICE ="sell_price";
        public final static String COLUMN_BUY_QUANTITY ="buy_quantity";
        public final static String COLUMN_SELL_QUANTITY ="sell_quantity";
        public final static String COLUMN_PROFIT_LOSS ="profit_loss";

        public static final String CONTENT_LIST_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PORTFOLIO;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PORTFOLIO;
    }
}
