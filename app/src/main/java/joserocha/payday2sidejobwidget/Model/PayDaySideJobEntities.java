package joserocha.payday2sidejobwidget.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Photodynamics5 on 7/9/2015.
 */
public class PayDaySideJobEntities extends SQLiteOpenHelper {

    public static int DATABASE_VERSION = 1;

    public static String DATABASE_NAME = "PAYDAYWIDGETDB";

    public static String TABLE_ACHIEVEMENTS = "Achievements";

    public static String TABLE_ACHIEVEMENTS_ID = "ID";

    public static String TABLE_ACHIEVEMENTS_NAME = "Name";

    public static String TABLE_ACHIEVEMENTS_CODE = "Code";

    public static String TABLE_ACHIEVEMENTS_ICON = "Icon";

    public static String TABLE_ACHIEVEMENTS_INFORMATION = "Information";

    //CREATE TABLES

    public static String CREATE_ACHIEVEMENTS = "CREATE TABLE "+TABLE_ACHIEVEMENTS+" ( "+ TABLE_ACHIEVEMENTS_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " + TABLE_ACHIEVEMENTS_ICON +" TEXT, " + TABLE_ACHIEVEMENTS_NAME +" TEXT, " + TABLE_ACHIEVEMENTS_CODE +" TEXT, "+TABLE_ACHIEVEMENTS_INFORMATION+" TEXT ) ";


    public PayDaySideJobEntities(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ACHIEVEMENTS);

        db.execSQL("INSERT INTO "+TABLE_ACHIEVEMENTS+ " VALUES (1, 'diamondsareforever','Diamonds Are Forever','diamonds_are_forever', 'In the Jewelry store job, steal and secure 4 bags without the escape car leaving the first time.') ");
        db.execSQL("INSERT INTO "+TABLE_ACHIEVEMENTS+" VALUES (2, 'pinkpanther', 'Painting Yourself Into a Corner', 'pink_panther', 'On day 1 of the Framing Frame job, steal all sold paintings without being seen.') ");
        db.execSQL("INSERT INTO "+TABLE_ACHIEVEMENTS+" VALUES (3, 'frog1', 'Tabula Rasa', 'frog_1', 'In the Hoxton Breakout job, complete the heist on OVERKILL difficulty or above with each crew member using no skills, wearing suits, wielding Golden AK.762 rifles and Chicago Typewriter submachine guns. Unlocks a new skill slot.') ");
        db.execSQL("INSERT INTO "+TABLE_ACHIEVEMENTS+ " VALUES (4, 'caribbeanpirate', 'Caribbean Pirate', 'caribbean_pirate', 'On day 2 of the Rat job, bring additional meth bags to the trade, but steal your payment instead.') ");
        db.execSQL("INSERT INTO "+TABLE_ACHIEVEMENTS+ " VALUES (5, 'doctorfantastic', 'Doctor Fantastic', 'doctor_fantastic', 'On day 2 of the Big Oil job, complete the heist with the first engine being correct.') ");

        db.execSQL("INSERT INTO "+TABLE_ACHIEVEMENTS+ " VALUES (6, 'shortfuse','Short Fuse','short_fuse', 'On day 3 of the Rat job, get away with 7 bags without defusing any bombs.') ");
        db.execSQL("INSERT INTO "+TABLE_ACHIEVEMENTS+" VALUES (7, 'iwasnteventhere', 'I Wasn''t Even There!', 'i_wasnt_even_there', 'On day 3 of the Framing Frame job, send the gold by zip-line without ever tripping the alarm.') ");
        db.execSQL("INSERT INTO "+TABLE_ACHIEVEMENTS+" VALUES (8, 'iknewwhatiwasdoingwaswrong', 'I Knew What I Did Was Wrong', 'i_knew_what_i_was_doing_was_wrong', 'On day 1 of the Big Oil job, enter the basement, open the ATM machines and take the loot.') ");
        db.execSQL("INSERT INTO "+TABLE_ACHIEVEMENTS+ " VALUES (9, 'yeahhesagolddigger', 'Yeah He''s a Gold Digger', 'yeah_hes_a_gold_digger', 'In the Four Stores job, find a gold bar in a safe.') ");
        db.execSQL("INSERT INTO "+TABLE_ACHIEVEMENTS+ " VALUES (10, 'lordofwar', 'Lord of War', 'lord_of_war', 'On day 1 of the Firestarter job, steal all the weapons from the hangar.') ");

        db.execSQL("INSERT INTO "+TABLE_ACHIEVEMENTS+ " VALUES (11, 'thewire','Guessing Game','the_wire', 'On day 2 of the Firestarter job, complete the heist in stealth without hacking the computer.') ");
        db.execSQL("INSERT INTO "+TABLE_ACHIEVEMENTS+" VALUES (12, 'thefirstline', 'The First Line', 'the_first_line', 'On day 3 of the Firestarter job, find the rare hockey poster of the OVERKILL hockey team.') ");
        db.execSQL("INSERT INTO "+TABLE_ACHIEVEMENTS+" VALUES (13, 'halloween1', 'I Am the One Who Knocks', 'halloween_1', 'On day 1 of the Rats job, cook 3 bags worth of meth without letting any law enforcer enter the house.') ");
        db.execSQL("INSERT INTO "+TABLE_ACHIEVEMENTS+ " VALUES (14, 'halloween2', 'Full Measure', 'halloween_2', 'On day 1 of the Rats job, cook and secure 7 bags worth of meth without blowing up the lab on the OVERKILL difficulty or above.') ");
        db.execSQL("INSERT INTO "+TABLE_ACHIEVEMENTS+ " VALUES (15, 'halloween3', 'Afraid of the Dark', 'halloween_3', 'On day 3 of the Framing Frame job, while doing plan B, don''t let law enforcers pull the power.') ");


        db.execSQL("INSERT INTO "+TABLE_ACHIEVEMENTS+ " VALUES (16, 'bob8','Hot Lava 2.0','bob_8', 'On day 1 of the Election Day job, use the computer in stealth without ever touching the ground.') ");
        db.execSQL("INSERT INTO "+TABLE_ACHIEVEMENTS+" VALUES (17, 'kosugi3', 'I Will Take With Impunity', 'kosugi_3', 'In the Shadow Raid job, secure a piece of every available type of loot, including money, gold, cocaine, artifact, painting, weapons and server.') ");
        db.execSQL("INSERT INTO "+TABLE_ACHIEVEMENTS+" VALUES (18, 'kosugi4', 'I Will Walk Faceless Among Men', 'kosugi_4', 'In the Shadow Raid job, secure all 4 pieces of the samurai armor. Unlocks the “Somen Mempo” mask.') ");
        db.execSQL("INSERT INTO "+TABLE_ACHIEVEMENTS+ " VALUES (19, 'kosugi5', 'I Am Ninja', 'kosugi_5', 'In the Shadow Raid job, secure 16 bags of random loot and all 4 pieces of the samurai armor.') ");
        db.execSQL("INSERT INTO "+TABLE_ACHIEVEMENTS+ " VALUES (20, 'slakt1', 'Speedlock Holmes', 'slakt_1', 'On day 1 of the Election Day job, tag the right truck and leave within a minute of the start of the heist.') ");

        db.execSQL("INSERT INTO "+TABLE_ACHIEVEMENTS+ " VALUES (21, 'slakt2','Nothing Out of the Ordinary','slakt_2', 'Answer 4 pagers by yourself within 90 seconds from first to last pager.') ");
        db.execSQL("INSERT INTO "+TABLE_ACHIEVEMENTS+" VALUES (22, 'slakt3', 'Situation Normal', 'slakt_3', 'In the Hoxton Breakout job, complete day 2 without using a single keycard on the OVERKILL difficulty or above.') ");
        db.execSQL("INSERT INTO "+TABLE_ACHIEVEMENTS+" VALUES (23, 'slakt4', 'Keep the Party Going', 'slakt_4', 'In the Nightclub job, zip-tie the DJ and bring him to the escape zone by the escape van.') ");
        db.execSQL("INSERT INTO "+TABLE_ACHIEVEMENTS+ " VALUES (24, 'bigdeal', 'Big Deal', 'big_deal', 'On day 2 of the Framing Frame job, trade 9 paintings') ");
        db.execSQL("INSERT INTO "+TABLE_ACHIEVEMENTS+ " VALUES (25, 'slakt5', 'It''s Getting Hot in Here', 'slakt_5', 'In the Firestarter job, complete day 3 with you and your crew staying inside the vault while all of the money burns out on the Death Wish difficulty.') ");

        db.execSQL("INSERT INTO "+TABLE_ACHIEVEMENTS+ " VALUES (26, 'gage21','Doctor Miserable','gage2_1', 'On day 2 of the Big Oil job, complete the heist with the last engine being correct on the OVERKILL difficulty or above.') ");
        db.execSQL("INSERT INTO "+TABLE_ACHIEVEMENTS+" VALUES (27, 'deer7', 'Impossible, It Can''t Be. Is It?', 'deer_7', 'In the White Xmas job, secure the rare Almir''s Toast.') ");

        db.execSQL("INSERT INTO "+TABLE_ACHIEVEMENTS+" VALUES (28, 'any300kills', 'Mass Murderer', 'any_300_kills', 'Kill 300 enemies with the weapons of your choice.') ");
        db.execSQL("INSERT INTO "+TABLE_ACHIEVEMENTS+" VALUES (29, 'pistol100kills', 'Target Practice: Pistol', 'pistol_100_kills', 'Kill 100 enemies using only Pistols.') ");

        db.execSQL("INSERT INTO "+TABLE_ACHIEVEMENTS+" VALUES (30, 'shotgun100kills', 'Target Practice: Shotgun', 'shotgun_100_kills', 'Kill 100 enemies using only shotguns.') ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_ACHIEVEMENTS );

        onCreate(db);

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_ACHIEVEMENTS );

        onCreate(db);
    }

    public Achievements getAchievementByCode(String Code){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_ACHIEVEMENTS+" WHERE "+TABLE_ACHIEVEMENTS_CODE+" = '"+Code+"'", null);
        Achievements achivement = new Achievements();
        if(c != null){
            while(c.moveToNext()){


                achivement.setID(c.getInt(c.getColumnIndex(TABLE_ACHIEVEMENTS_ID)));
                achivement.setCode(c.getString(c.getColumnIndex(TABLE_ACHIEVEMENTS_CODE)));
                achivement.setIcon(c.getString(c.getColumnIndex(TABLE_ACHIEVEMENTS_ICON)));
                achivement.setName(c.getString(c.getColumnIndex(TABLE_ACHIEVEMENTS_NAME)));
                achivement.setInformation(c.getString(c.getColumnIndex(TABLE_ACHIEVEMENTS_INFORMATION)));


            }
        }
        return achivement;
    }
}
