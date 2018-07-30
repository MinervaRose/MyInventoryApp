/*
PROJECT LICENSE
This project was submitted by Sabrina Palis as part of the Android Basics Nanodegree by Google At Udacity.
As part of Udacity Honor code, your submissions must be your own work, hence
submitting this project as yours will cause you to break the Udacity Honor Code
and the suspension of your account.
Me, the author of the project, allow you to check the code as a reference, but if
you submit it, it is your own responsibility if you get expelled.
Copyright (c) 2018 Sabrina Palis.
Besides the above notice, the following license applies and this license notice
must be included in all works derived from this project.
MIT License
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

package com.example.android.myinventoryappv9.data;

import android.net.Uri;

import android.content.ContentResolver;
import android.provider.BaseColumns;

/**
 * API Contract.
 */
public final class ProductContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private ProductContract() {}

    /**
     * The "Content authority" is a name for the entire content provider, similar to the
     * relationship between a domain name and its website.  A convenient string to use for the
     * content authority is the package name for the app, which is guaranteed to be unique on the
     * device.
     */
    public static final String CONTENT_AUTHORITY = "com.example.android.myinventoryappv9";

    /**
     * Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
     * the content provider.
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    /**
     * Possible path (appended to base content URI for possible URI's)
     * For instance, content://com.example.android.cakes/cakes/ is a valid path for
     * looking at product data. content://com.example.android.products/staff/ will fail,
     * as the ContentProvider hasn't been given any information on what to do with "staff".
     */
    public static final String PATH_PRODUCTS = "products";

    /**
     * Inner class that defines constant values for the database table.
     * Each entry in the table represents a single product.
     */
    public static final class ProductEntry implements BaseColumns {

        /** The content URI to access the product data in the provider */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PRODUCTS);

        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of products.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCTS;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single product.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCTS;

        /** Name of database table for products */
        public final static String TABLE_NAME = "products";

        /**
         * Unique ID number for the cake (only for use in the database table).
         *
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the product.
         *
         * Type: TEXT
         */
        public final static String COLUMN_PRODUCT_NAME ="name";

        /**
         * Category of the product.
         * The only possible values are {@link #CATEGORY_UNKNOWN}, {@link #CATEGORY_BOOK},
         *  {@link #CATEGORY_STATIONARY} , or (@link #CATEGORY_CARD) .
         * Type: INTEGER
         */
        public final static String COLUMN_PRODUCT_CATEGORY = "category";

        /**
         * price of the product.
         *
         * Type: INTEGER
         */
        public final static String COLUMN_PRODUCT_PRICE = "price";

        /**
         * Quantity of  product.
         *
         * Type: INTEGER
         */
        public final static String COLUMN_PRODUCT_QUANTITY = "quantity";

        /**
         * Name of the product supplier.
         *
         * Type: TEXT
         */
        public final static String COLUMN_PRODUCT_SUPPLIER ="supplier";

        /**
         * Phone number of the product supplier.
         *
         * Type: INTEGER
         */
        public final static String COLUMN_PRODUCT_PHONE ="phone";

        /**
         * Possible values for the category.
         */
        public static final int CATEGORY_UNKNOWN = 0;
        public static final int CATEGORY_BOOK = 1;
        public static final int CATEGORY_STATIONARY = 2;
        public static final int CATEGORY_CARD = 3;

        /**
         * Returns whether or not the given category is {@link #CATEGORY_UNKNOWN}, {@link #CATEGORY_BOOK},
         *  {@link #CATEGORY_STATIONARY} or (@link #CATEGORY_CARD).
         */
        public static boolean isValidCategory(int category) {
            if (category == CATEGORY_UNKNOWN || category == CATEGORY_BOOK || category == CATEGORY_STATIONARY || category == CATEGORY_CARD) {
                return true;
            }
            return false;
        }
    }
}