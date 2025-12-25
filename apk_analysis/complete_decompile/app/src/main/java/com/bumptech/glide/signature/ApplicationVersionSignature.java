package com.bumptech.glide.signature;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class ApplicationVersionSignature {

    /* renamed from: a */
    public static final ConcurrentHashMap f9152a = new ConcurrentHashMap();

    @NonNull
    public static Key obtain(@NonNull Context context) {
        PackageInfo packageInfo;
        String uuid;
        String packageName = context.getPackageName();
        ConcurrentHashMap concurrentHashMap = f9152a;
        Key key = (Key) concurrentHashMap.get(packageName);
        if (key == null) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("AppVersionSignature", "Cannot resolve info for" + context.getPackageName(), e);
                packageInfo = null;
            }
            if (packageInfo != null) {
                uuid = String.valueOf(packageInfo.versionCode);
            } else {
                uuid = UUID.randomUUID().toString();
            }
            ObjectKey objectKey = new ObjectKey(uuid);
            Key key2 = (Key) concurrentHashMap.putIfAbsent(packageName, objectKey);
            if (key2 != null) {
                return key2;
            }
            return objectKey;
        }
        return key;
    }
}
