package sg.edu.rp.c346.id19004781.quizgame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelperUser extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "tourist.db";
    private static final String TABLE_USER = "USER";
    private static final String COLUMN_USERID = "id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_USERPASSWORD = "password";

    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USERID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USERNAME + " TEXT," + COLUMN_USERPASSWORD + " TEXT" + ")";
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    public DBHelperUser(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_USER + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, PASSWORD TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
    }

    public boolean checkNameExists(String usernameContent) {
        String selectQuery = "SELECT * FROM " + TABLE_USER + " WHERE " + COLUMN_USERNAME + " = " +  "'" + usernameContent + "'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if ((cursor != null) && (cursor.getCount() > 0))
            return true;
        else
            return false;
    }

    public long addUser(String userInfo, String passwordInfo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, userInfo);
        values.put(COLUMN_USERPASSWORD, passwordInfo);
        long result = db.insert(TABLE_USER, null, values);
        db.close();
        Log.d("SQL Insert","ID:"+ result);
        return result;
    }

    public ArrayList<User> getAllNames() {
        ArrayList<User> users = new ArrayList<>();

        String selectQuery = "SELECT " + COLUMN_USERID + ", "
                + COLUMN_USERNAME + ", " + COLUMN_USERPASSWORD + " FROM " + TABLE_USER;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String getUser = cursor.getString(1);
                String getPass = cursor.getString(2);

                User userContent = new User(id, getUser, getPass);
                users.add(userContent);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return users;

    }

    public int deleteUser(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String condition = COLUMN_USERID + "= ?";
        String[] args = {String.valueOf(id)};
        /**/
        int result = db.delete(TABLE_USER, condition, args);
        db.close();
        return result;
    }

    public boolean retrieveUserInfo(String userInfo, String passwordInfo) {
        String selectQuery = "SELECT * FROM " + TABLE_USER + " WHERE " + COLUMN_USERNAME + " = " + "'" + userInfo + "'" + " AND " + COLUMN_USERPASSWORD + " = " + "'" + passwordInfo + "'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if ((cursor != null) && (cursor.getCount() > 0))
            return true;
        else
            return false;
    }

    public boolean retrieveName(String nameContent) {
        String selectQuery = "SELECT * FROM " + TABLE_USER + " WHERE " + COLUMN_USERNAME + " = " + "'" + nameContent + "'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if ((cursor != null) && (cursor.getCount() > 0))
            return true;
        else
            return false;
    }




}
