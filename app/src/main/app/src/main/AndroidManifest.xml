<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.clipboardcopy">

    <application
        android:label="Copy Image"
        android:theme="@android:style/Theme.Translucent.NoTitleBar">
        
        <activity
            android:name=".MainActivity"
            android:exported="true"
            android:excludeFromRecents="true"
            android:noHistory="true">
            <intent-filter>
                <action android:name="android.intent.action.SEND" />
                <category android:name="android.intent.category.DEFAULT" />
                <data android:mimeType="image/*" />
            </intent-filter>
        </activity>
    </application>
</manifest>
