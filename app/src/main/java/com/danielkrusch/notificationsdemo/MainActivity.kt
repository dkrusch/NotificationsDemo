package com.danielkrusch.notificationsdemo

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.support.v4.app.NotificationCompat
import android.app.PendingIntent
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.media.RingtoneManager
import java.security.PrivateKey


class MainActivity : AppCompatActivity()
{

    var notification: NotificationCompat.Builder = NotificationCompat.Builder(this)
    private var uniqueID = 12423

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notification = NotificationCompat.Builder(this)
        notification.setAutoCancel(true)
    }

    fun onClick(v: View)
    {

        val alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        notification.setSmallIcon(uniqueID)
        notification.setSmallIcon(R.drawable.notification_template_icon_low_bg);
        notification.setTicker("This is a ticker")
        notification.setWhen(System.currentTimeMillis())
        notification.setSound(alarmSound)
        notification.setContentTitle("Test Notification")
        notification.setContentText("This is a test app for testing notifications.")


        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        notification.setContentIntent(pendingIntent)

        //Builds notification and issues it
        val nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        nm.notify(uniqueID, notification.build())
    }
}

