package sg.edu.rp.c346.id19004781.quizgame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "travel.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_REVIEW = "Review";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_REVIEW = "reviewContent";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createNoteTableSql = "CREATE TABLE " + TABLE_REVIEW + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_REVIEW + "  TEXT ) ";
        db.execSQL(createNoteTableSql);
        Log.i("info", "created tables");

        // TODO: to prepare the database for testing,
        //  we could create some dummy data during the table creation process.
        //  Dummy records, to be inserted when the database is created
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REVIEW);
        onCreate(db);
    }

    public long insertReview(String review) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_REVIEW, review);


        // TODO: This line of code will return a number
        //  that represents the record id (the primary key, _id)
        //  of the table for the record that was inserted.
        //  If the insert fails, the id will be -1.
        //  As a result, we can use it to determine whether or not a record was successfully inserted.
        long result = db.insert(TABLE_REVIEW, null, values);

        db.close();
//		if (result == -1){
//			Log.d(“DBHelper”, “Insert failed”);
//		}
        Log.d("SQL Insert", "ID:" + result); //id returned, shouldn’t be -1
        return result;
    }

    public ArrayList<Review> getAllReview() {
        ArrayList<Review> reviews = new ArrayList<>();

        String selectQuery = "SELECT " + COLUMN_ID + ", "
                + COLUMN_REVIEW + " FROM " + TABLE_REVIEW;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String getReview = cursor.getString(1);

                Review review = new Review(id, getReview);
                reviews.add(review);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return reviews;

    }

    public int updateReview(Review data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_REVIEW, data.getReviewContent());
        String condition = COLUMN_ID + "= ?";
        String[] args = {String.valueOf(data.getId())};


/*TODO: This line of code will return a number representing the number
   of rows in the table that have been affected. We usually expect one
   or more records to be updated when we perform a record update.
   However, in this case, we anticipate only one record.
   As a result, if the affected record is 1,
   we can use it to determine whether or not a record was successfully updated.*/
        int result = db.update(TABLE_REVIEW, values, condition, args);

        db.close();
        return result;

    }

    public int deleteReview(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String condition = COLUMN_ID + "= ?";
        String[] args = {String.valueOf(id)};
        /**/
        int result = db.delete(TABLE_REVIEW, condition, args);
        db.close();
        return result;
    }

}
