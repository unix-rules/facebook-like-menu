package eu.basicenglish;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import eu.basicenglish.model.Category;
import eu.basicenglish.model.WordRecord;

//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//
//import android.content.Context;
//import android.database.SQLException;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.util.Log;

public class Database  extends SQLiteOpenHelper  {
	private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "words";
    
    private final String WORDS_TABLE = "words";
    //private final String CATEGORIES_TABLE = "categories";
    
	private final static Database sharedInstance = new Database(null);
	
	static Database sharedInstance() {
		return sharedInstance;
	}
	
	private Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        
        WordRecord wordRecord = new WordRecord();
        wordRecord.setFrom("example");
        //addWordRecord(wordRecord);
    }
	
	ArrayList<Category> categories() {
		
		for (int i=0;i<9;i++) {
			Log.e("ok", "ok"+i);
		}
		
		return new ArrayList<Category> ();
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		Log.e("ok", "create ======================");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	
	public void addWordRecord(WordRecord wordRecord) {
	    SQLiteDatabase db = this.getWritableDatabase();
	 
	    ContentValues values = new ContentValues();
	    values.put("from", wordRecord.getFrom());
	 
	    db.insert(WORDS_TABLE, null, values);
	    db.close();
	}
	/*
	public Contact getContact(int id) {
	    SQLiteDatabase db = this.getReadableDatabase();
	 
	    Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
	            KEY_NAME, KEY_PH_NO }, KEY_ID + "=?",
	            new String[] { String.valueOf(id) }, null, null, null, null);
	    if (cursor != null)
	        cursor.moveToFirst();
	 
	    Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
	            cursor.getString(1), cursor.getString(2));
	    // return contact
	    return contact;
	}
	
	public List<Contact> getAllContacts() {
    List<Contact> contactList = new ArrayList<Contact>();
    // Select All Query
    String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;
 
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.rawQuery(selectQuery, null);
 
    // looping through all rows and adding to list
    if (cursor.moveToFirst()) {
        do {
            Contact contact = new Contact();
            contact.setID(Integer.parseInt(cursor.getString(0)));
            contact.setName(cursor.getString(1));
            contact.setPhoneNumber(cursor.getString(2));
            // Adding contact to list
            contactList.add(contact);
        } while (cursor.moveToNext());
    }
 
    // return contact list
    return contactList;
}

public int updateContact(Contact contact) {
    SQLiteDatabase db = this.getWritableDatabase();
 
    ContentValues values = new ContentValues();
    values.put(KEY_NAME, contact.getName());
    values.put(KEY_PH_NO, contact.getPhoneNumber());
 
    // updating row
    return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
            new String[] { String.valueOf(contact.getID()) });
}

deleteContact()
    // Deleting single contact
public void deleteContact(Contact contact) {
    SQLiteDatabase db = this.getWritableDatabase();
    db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
            new String[] { String.valueOf(contact.getID()) });
    db.close();
}







private static String TAG = "DataBaseHelper"; // Tag just for the LogCat window
//destination path (location) of our database on device
private static String DB_PATH = ""; 
private static String DB_NAME ="YourDbName";// Database name
private SQLiteDatabase mDataBase; 
private final Context mContext;

public DataBaseHelper(Context context) 
{
    super(context, DB_NAME, null, 1);// 1? its Database Version
    DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
    this.mContext = context;
}   

public void createDataBase() throws IOException
{
    //If database not exists copy it from the assets

    boolean mDataBaseExist = checkDataBase();
    if(!mDataBaseExist)
    {
        this.getReadableDatabase();
        this.close();
        try 
        {
            //Copy the database from assests
            copyDataBase();
            Log.e(TAG, "createDatabase database created");
        } 
        catch (IOException mIOException) 
        {
            throw new Error("ErrorCopyingDataBase");
        }
    }
}
    //Check that the database exists here: /data/data/your package/databases/Da Name
    private boolean checkDataBase()
    {
        File dbFile = new File(DB_PATH + DB_NAME);
        //Log.v("dbFile", dbFile + "   "+ dbFile.exists());
        return dbFile.exists();
    }

    //Copy the database from assets
    private void copyDataBase() throws IOException
    {
        InputStream mInput = mContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream mOutput = new FileOutputStream(outFileName);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer))>0)
        {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    //Open the database, so we can query it
    public boolean openDataBase() throws SQLException
    {
        String mPath = DB_PATH + DB_NAME;
        //Log.v("mPath", mPath);
        mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        //mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        return mDataBase != null;
    }

    @Override
    public synchronized void close() 
    {
        if(mDataBase != null)
            mDataBase.close();
        super.close();
    }
	*/
}
