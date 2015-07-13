package joserocha.payday2sidejobwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.StrictMode;
import android.util.Log;
import android.widget.RemoteViews;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import joserocha.payday2sidejobwidget.Model.Achievements;
import joserocha.payday2sidejobwidget.Model.PayDaySideJobEntities;

/**
 * Created by Photodynamics5 on 4/16/2015.
 */
public class AlarmManagerBroadcastReceiver extends BroadcastReceiver {

    public static List<Achievements> _achievementl = new ArrayList<Achievements>();

    @Override
    public void onReceive(Context context, Intent intent) {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "YOUR TAG");
        //Acquire the lock
        wl.acquire();



            //You can do the processing here update the widget/remote views.
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
                    R.layout.activity_main);

            PayDaySideJobEntities pdent = new PayDaySideJobEntities(context.getApplicationContext());

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

                MainActivity.jsonstr = buffer.toString();
            } catch (Exception ex) {
                Log.d("Exception", "InputStream Exc");
            } finally {
                if (reader != null)
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }

            Gson _gsun = new Gson();

            try {
                MainActivity.JobInfo _jobinfo = _gsun.fromJson(MainActivity.jsonstr, MainActivity.JobInfo.class);

                if (_jobinfo != null) {

                    String[] dailies = _jobinfo.daily.replace("'", "").split(",");
                    _jobinfo.weekly = _jobinfo.weekly.replace("'", "");

                    Achievements _sachivement = pdent.getAchievementByCode(dailies[0]);
                    if (_sachivement != null) {

                        remoteViews.setTextViewText(R.id.txtName, (_sachivement.getName() != null && !_sachivement.getName().isEmpty() ? _sachivement.getName() : ""));
                        remoteViews.setImageViewResource(R.id.imageView, context.getResources().getIdentifier(_sachivement.getIcon() != null && !_sachivement.getIcon().isEmpty() ? _sachivement.getIcon() : "frog1", "drawable", context.getPackageName()));
                        _achievementl.add(_sachivement);
                    }

                    if (_sachivement != null) {
                        _sachivement = pdent.getAchievementByCode(dailies[1]);
                        remoteViews.setTextViewText(R.id.txtName2, (_sachivement.getName() != null && !_sachivement.getName().isEmpty() ? _sachivement.getName() : ""));
                        remoteViews.setImageViewResource(R.id.imageView2, context.getResources().getIdentifier(_sachivement.getIcon() != null && !_sachivement.getIcon().isEmpty() ? _sachivement.getIcon() : "frog1", "drawable", context.getPackageName()));
                        _achievementl.add(_sachivement);
                    }

                    if (_sachivement != null) {

                        _sachivement = pdent.getAchievementByCode(_jobinfo.weekly);
                        remoteViews.setTextViewText(R.id.txtName3, (_sachivement.getName() != null && !_sachivement.getName().isEmpty() ? _sachivement.getName() : ""));
                        remoteViews.setImageViewResource(R.id.imageView3, context.getResources().getIdentifier(_sachivement.getIcon() != null && !_sachivement.getIcon().isEmpty() ? _sachivement.getIcon() : "frog1", "drawable", context.getPackageName()));
                        _achievementl.add(_sachivement);
                    }

                } else {
                    Achievements _sacvhiement = new Achievements();
                    for (int j = 0; j < 3; j++) {
                        _sacvhiement.setInformation("");
                        _sacvhiement.setName("N/A");
                        _sacvhiement.setIcon("frog1");
                        _sacvhiement.setCode("");
                        _sacvhiement.setID(j);

                        _achievementl.add(_sacvhiement);
                    }
                }

            } catch (Exception ex) {
                Log.d("Exception", "Excepcion de json token");
            }

            PaydayInformation._achivement = _achievementl;

            Intent _vistainformativa = new Intent(context, PaydayInformation.class);
            PendingIntent pendinginforma = PendingIntent.getActivity(context, 0, _vistainformativa, 0);
            remoteViews.setOnClickPendingIntent(R.id.txtName, pendinginforma);
            remoteViews.setOnClickPendingIntent(R.id.txtName2, pendinginforma);
            remoteViews.setOnClickPendingIntent(R.id.txtName3, pendinginforma);
            remoteViews.setOnClickPendingIntent(R.id.imageView, pendinginforma);
            remoteViews.setOnClickPendingIntent(R.id.imageView2, pendinginforma);
            remoteViews.setOnClickPendingIntent(R.id.imageView3, pendinginforma);

            pdent.close();


        ComponentName thiswidget = new ComponentName(context, MainActivity.class);
        AppWidgetManager manager = AppWidgetManager.getInstance(context);


        manager.updateAppWidget(thiswidget, remoteViews);
        //Release the lock
        wl.release();
    }
}
