package joserocha.payday2sidejobwidget;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import joserocha.payday2sidejobwidget.Model.Achievements;
import joserocha.payday2sidejobwidget.Model.PayDaySideJobEntities;


public class MainActivity extends AppWidgetProvider {


    public static String jsonstr;
    public static List<Achievements> _achievementl = new ArrayList<Achievements>();

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        PayDaySideJobEntities pdent = new PayDaySideJobEntities(context.getApplicationContext());

        for(int i=0;i<appWidgetIds.length;i++){
            int appWidgetId = appWidgetIds[i];

            //Intent intent = new Intent(context, MainActivity.class);

            //PendingIntent pending = PendingIntent.getActivity(context, 0, intent, 0);

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.activity_main);

            //views.setOnClickPendingIntent(R.id.txtName, pending);


            String urlString = "http://media.overkillsoftware.com/stats/missions.json";
            BufferedReader reader = null;
            try {
                URL url = new URL(urlString);
                reader = new BufferedReader(new InputStreamReader(url.openStream()));
                StringBuffer buffer = new StringBuffer();
                int read;
                char[] chars = new char[1024];
                while ((read = reader.read(chars)) != -1)
                    buffer.append(chars, 0, read);

                jsonstr = buffer.toString();
            }
            catch (Exception ex){
                Log.d("Exception", "InputStream Exception");
            }
            finally {
                if (reader != null)
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }

            Gson _gsun = new Gson();

            try {
                JobInfo _jobinfo = _gsun.fromJson(jsonstr, JobInfo.class);
                if(_jobinfo != null){


                //split and clean the strings from quotes '
                String[] dailies = _jobinfo.daily.replace("'", "").split(",");
                _jobinfo.weekly = _jobinfo.weekly.replace("'","");

                Achievements _sachivement = pdent.getAchievementByCode(dailies[0]);

                    if(_sachivement != null){
                views.setTextViewText(R.id.txtName, (_sachivement.getName() != null && !_sachivement.getName().isEmpty() ? _sachivement.getName() : ""));
                views.setImageViewResource(R.id.imageView, context.getResources().getIdentifier( _sachivement.getIcon() != null && !_sachivement.getIcon().isEmpty() ? _sachivement.getIcon() : "frog1", "drawable", context.getPackageName()));
                _achievementl.add(_sachivement);
                    }


                _sachivement = pdent.getAchievementByCode(dailies[1]);
                    if(_sachivement != null) {

                        views.setTextViewText(R.id.txtName2, (_sachivement.getName() != null && !_sachivement.getName().isEmpty() ? _sachivement.getName() : "") );
                        views.setImageViewResource(R.id.imageView2, context.getResources().getIdentifier( _sachivement.getIcon() != null && !_sachivement.getIcon().isEmpty() ? _sachivement.getIcon() : "frog1", "drawable", context.getPackageName()));
                        _achievementl.add(_sachivement);
                    }

                _sachivement = pdent.getAchievementByCode(_jobinfo.weekly);
                    if(_sachivement != null) {
                        views.setTextViewText(R.id.txtName3, (_sachivement.getName() != null && !_sachivement.getName().isEmpty() ? _sachivement.getName() : ""));
                        views.setImageViewResource(R.id.imageView3, context.getResources().getIdentifier( _sachivement.getIcon() != null && !_sachivement.getIcon().isEmpty() ? _sachivement.getIcon() : "frog1", "drawable", context.getPackageName()));
                        _achievementl.add(_sachivement);
                    }

                }
                else{
                    Achievements _sacvhiement = new Achievements();
                    for(int j = 0; j<3;j++){
                    _sacvhiement.setInformation("");
                    _sacvhiement.setName("N/A");
                    _sacvhiement.setIcon("");
                    _sacvhiement.setCode("");
                    _sacvhiement.setID(j);

                    _achievementl.add(_sacvhiement);
                    }
                }

            }
            catch (Exception ex){
                Log.d("Exception", "Excepcion de json token");
            }

            PaydayInformation._achivement = _achievementl;

            Intent _vistainformativa = new Intent(context, PaydayInformation.class);
            PendingIntent pendinginforma = PendingIntent.getActivity(context, 0, _vistainformativa, 0);
            views.setOnClickPendingIntent(R.id.txtName, pendinginforma);
            views.setOnClickPendingIntent(R.id.txtName2, pendinginforma);
            views.setOnClickPendingIntent(R.id.txtName3, pendinginforma);
            views.setOnClickPendingIntent(R.id.imageView, pendinginforma);
            views.setOnClickPendingIntent(R.id.imageView2, pendinginforma);
            views.setOnClickPendingIntent(R.id.imageView3, pendinginforma);


            pdent.close();
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }



    @Override
    public void onDisabled(Context context) {

        Intent intent = new Intent(context, AlarmManagerBroadcastReceiver.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(sender);
        super.onDisabled(context);
    }


    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmManagerBroadcastReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, 0);
        //After after 3 seconds
        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+ 1000 * 3, 3600000, pi);
    }

    @Override
    public void onAppWidgetOptionsChanged(Context context,
                                          AppWidgetManager appWidgetManager, int appWidgetId,
                                          Bundle newOptions) {
        //Do some operation here, once you see that the widget has change its size or position.

    }

    public static class JobInfo
    {
        public String daily;

        public String weekly;

        public void setDaily(String daily) {
            this.daily = daily;
        }
        public void setWeekly(String weekly){
            this.weekly = weekly;
        }

    }

}

