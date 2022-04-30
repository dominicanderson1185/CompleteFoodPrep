package xlost.com;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String Food_Table = "Food_Table";
    public static final String COLUMN_FOOD_NAME = "FOOD_NAME";
    public static final String COLUMN_FOOD_AMOUNT = "FOOD_AMOUNT";
    public static final String COLUMN_FOOD_DATE = "FOOD_DATE";
    public static final String ID = "ID";

    public DataBaseHelper(@Nullable Context context) {

        super(context,"foodstuff.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + Food_Table + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FOOD_NAME + " TEXT, " + COLUMN_FOOD_AMOUNT + " INT, " + COLUMN_FOOD_DATE + " INT)";

        db.execSQL(createTableStatement);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){


    }


    public boolean addOne (FoodModel foodModel){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_FOOD_NAME, foodModel.getName());
        cv.put(COLUMN_FOOD_AMOUNT, foodModel.getAmount());
        cv.put(COLUMN_FOOD_DATE, foodModel.getAge());

        long insert = db.insert(Food_Table, null, cv);
        return insert != -1;

    }


    public boolean deleteOne(FoodModel foodModel){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + Food_Table + " WHERE " + ID + " = " + foodModel.getId();

        Cursor cursor = db.rawQuery(queryString,null);

        if(cursor.moveToFirst()){
            return true;
        } else {
            return false;
        }

    }
    public List<FoodModel> getAll(){

        List<FoodModel> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM " + Food_Table + " GROUP BY " + COLUMN_FOOD_NAME+", " + COLUMN_FOOD_AMOUNT + ", " + COLUMN_FOOD_DATE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst())
        {

            do {
                int foodID = cursor.getInt(0);
                String foodname = cursor.getString(1);
                int foodamount = cursor.getInt(2);
                int fooddate = cursor.getInt(3);

                FoodModel newfoodModel = new FoodModel(foodID, foodname,foodamount,fooddate);
                returnList.add(newfoodModel);

            } while (cursor.moveToNext());

        } else {

        }
        cursor.close();
        db.close();
        return returnList;

    }

}
