package p000;

import android.location.Location;
import android.os.Bundle;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class uc1 {
    @DoNotInline
    /* renamed from: a */
    public static void m7698a(Location location) {
        if (!location.hasBearingAccuracy()) {
            return;
        }
        String provider = location.getProvider();
        long time = location.getTime();
        long elapsedRealtimeNanos = location.getElapsedRealtimeNanos();
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        boolean hasAltitude = location.hasAltitude();
        double altitude = location.getAltitude();
        boolean hasSpeed = location.hasSpeed();
        float speed = location.getSpeed();
        boolean hasBearing = location.hasBearing();
        float bearing = location.getBearing();
        boolean hasAccuracy = location.hasAccuracy();
        float accuracy = location.getAccuracy();
        boolean hasVerticalAccuracy = location.hasVerticalAccuracy();
        float verticalAccuracyMeters = location.getVerticalAccuracyMeters();
        boolean hasSpeedAccuracy = location.hasSpeedAccuracy();
        float speedAccuracyMetersPerSecond = location.getSpeedAccuracyMetersPerSecond();
        Bundle extras = location.getExtras();
        location.reset();
        location.setProvider(provider);
        location.setTime(time);
        location.setElapsedRealtimeNanos(elapsedRealtimeNanos);
        location.setLatitude(latitude);
        location.setLongitude(longitude);
        if (hasAltitude) {
            location.setAltitude(altitude);
        }
        if (hasSpeed) {
            location.setSpeed(speed);
        }
        if (hasBearing) {
            location.setBearing(bearing);
        }
        if (hasAccuracy) {
            location.setAccuracy(accuracy);
        }
        if (hasVerticalAccuracy) {
            location.setVerticalAccuracyMeters(verticalAccuracyMeters);
        }
        if (hasSpeedAccuracy) {
            location.setBearingAccuracyDegrees(speedAccuracyMetersPerSecond);
        }
        if (extras != null) {
            location.setExtras(extras);
        }
    }

    @DoNotInline
    /* renamed from: b */
    public static void m7699b(Location location) {
        if (!location.hasSpeedAccuracy()) {
            return;
        }
        String provider = location.getProvider();
        long time = location.getTime();
        long elapsedRealtimeNanos = location.getElapsedRealtimeNanos();
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        boolean hasAltitude = location.hasAltitude();
        double altitude = location.getAltitude();
        boolean hasSpeed = location.hasSpeed();
        float speed = location.getSpeed();
        boolean hasBearing = location.hasBearing();
        float bearing = location.getBearing();
        boolean hasAccuracy = location.hasAccuracy();
        float accuracy = location.getAccuracy();
        boolean hasVerticalAccuracy = location.hasVerticalAccuracy();
        float verticalAccuracyMeters = location.getVerticalAccuracyMeters();
        boolean hasBearingAccuracy = location.hasBearingAccuracy();
        float bearingAccuracyDegrees = location.getBearingAccuracyDegrees();
        Bundle extras = location.getExtras();
        location.reset();
        location.setProvider(provider);
        location.setTime(time);
        location.setElapsedRealtimeNanos(elapsedRealtimeNanos);
        location.setLatitude(latitude);
        location.setLongitude(longitude);
        if (hasAltitude) {
            location.setAltitude(altitude);
        }
        if (hasSpeed) {
            location.setSpeed(speed);
        }
        if (hasBearing) {
            location.setBearing(bearing);
        }
        if (hasAccuracy) {
            location.setAccuracy(accuracy);
        }
        if (hasVerticalAccuracy) {
            location.setVerticalAccuracyMeters(verticalAccuracyMeters);
        }
        if (hasBearingAccuracy) {
            location.setBearingAccuracyDegrees(bearingAccuracyDegrees);
        }
        if (extras != null) {
            location.setExtras(extras);
        }
    }

    @DoNotInline
    /* renamed from: c */
    public static void m7700c(Location location) {
        if (!location.hasVerticalAccuracy()) {
            return;
        }
        String provider = location.getProvider();
        long time = location.getTime();
        long elapsedRealtimeNanos = location.getElapsedRealtimeNanos();
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        boolean hasAltitude = location.hasAltitude();
        double altitude = location.getAltitude();
        boolean hasSpeed = location.hasSpeed();
        float speed = location.getSpeed();
        boolean hasBearing = location.hasBearing();
        float bearing = location.getBearing();
        boolean hasAccuracy = location.hasAccuracy();
        float accuracy = location.getAccuracy();
        boolean hasSpeedAccuracy = location.hasSpeedAccuracy();
        float speedAccuracyMetersPerSecond = location.getSpeedAccuracyMetersPerSecond();
        boolean hasBearingAccuracy = location.hasBearingAccuracy();
        float bearingAccuracyDegrees = location.getBearingAccuracyDegrees();
        Bundle extras = location.getExtras();
        location.reset();
        location.setProvider(provider);
        location.setTime(time);
        location.setElapsedRealtimeNanos(elapsedRealtimeNanos);
        location.setLatitude(latitude);
        location.setLongitude(longitude);
        if (hasAltitude) {
            location.setAltitude(altitude);
        }
        if (hasSpeed) {
            location.setSpeed(speed);
        }
        if (hasBearing) {
            location.setBearing(bearing);
        }
        if (hasAccuracy) {
            location.setAccuracy(accuracy);
        }
        if (hasSpeedAccuracy) {
            location.setSpeedAccuracyMetersPerSecond(speedAccuracyMetersPerSecond);
        }
        if (hasBearingAccuracy) {
            location.setBearingAccuracyDegrees(bearingAccuracyDegrees);
        }
        if (extras != null) {
            location.setExtras(extras);
        }
    }
}
