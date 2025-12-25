package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.google.common.base.Optional;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzjv {

    /* renamed from: a */
    public static volatile Optional f13847a;

    /* JADX WARN: Can't wrap try/catch for region: R(18:8|(4:10|(1:12)|13|14)|15|(4:17|(1:19)|13|14)|20|(2:22|(1:24))|25|26|27|28|29|30|31|(1:33)(1:80)|34|(9:36|37|38|39|40|(2:41|(3:43|(3:58|59|60)(7:45|46|(2:48|(1:51))|52|(1:54)|55|56)|57)(1:61))|62|63|64)(1:79)|65|14) */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0074, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0075, code lost:
    
        android.util.Log.e("HermeticFileOverrides", "no data dir", r3);
        r3 = com.google.common.base.Optional.absent();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Optional zza(Context context) {
        StrictMode.ThreadPolicy allowThreadDiskReads;
        Optional absent;
        Optional absent2;
        boolean isDeviceProtectedStorage;
        Optional optional = f13847a;
        if (optional == null) {
            synchronized (zzjv.class) {
                try {
                    optional = f13847a;
                    if (optional == null) {
                        String str = Build.TYPE;
                        String str2 = Build.TAGS;
                        ArrayMap arrayMap = zzjx.f13850a;
                        if (!str.equals("eng")) {
                            if (str.equals("userdebug")) {
                            }
                            absent2 = Optional.absent();
                            f13847a = absent2;
                            optional = absent2;
                        }
                        if (!str2.contains("dev-keys")) {
                            if (str2.contains("test-keys")) {
                            }
                            absent2 = Optional.absent();
                            f13847a = absent2;
                            optional = absent2;
                        }
                        if (zzji.zzc()) {
                            isDeviceProtectedStorage = context.isDeviceProtectedStorage();
                            if (!isDeviceProtectedStorage) {
                                context = context.createDeviceProtectedStorageContext();
                            }
                        }
                        allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        StrictMode.allowThreadDiskWrites();
                        File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
                        if (file.exists()) {
                            absent = Optional.m3770of(file);
                        } else {
                            absent = Optional.absent();
                        }
                        if (absent.isPresent()) {
                            File file2 = (File) absent.get();
                            try {
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
                                try {
                                    SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
                                    HashMap hashMap = new HashMap();
                                    while (true) {
                                        String readLine = bufferedReader.readLine();
                                        if (readLine == null) {
                                            break;
                                        }
                                        String[] split = readLine.split(" ", 3);
                                        if (split.length != 3) {
                                            Log.e("HermeticFileOverrides", "Invalid: " + readLine);
                                        } else {
                                            String str3 = new String(split[0]);
                                            String decode = Uri.decode(new String(split[1]));
                                            String str4 = (String) hashMap.get(split[2]);
                                            if (str4 == null) {
                                                String str5 = new String(split[2]);
                                                str4 = Uri.decode(str5);
                                                if (str4.length() < 1024 || str4 == str5) {
                                                    hashMap.put(str5, str4);
                                                }
                                            }
                                            SimpleArrayMap simpleArrayMap2 = (SimpleArrayMap) simpleArrayMap.get(str3);
                                            if (simpleArrayMap2 == null) {
                                                simpleArrayMap2 = new SimpleArrayMap();
                                                simpleArrayMap.put(str3, simpleArrayMap2);
                                            }
                                            simpleArrayMap2.put(decode, str4);
                                        }
                                    }
                                    Log.w("HermeticFileOverrides", "Parsed " + file2.toString() + " for Android package " + context.getPackageName());
                                    zzjo zzjoVar = new zzjo(simpleArrayMap);
                                    bufferedReader.close();
                                    absent2 = Optional.m3770of(zzjoVar);
                                } finally {
                                    try {
                                        bufferedReader.close();
                                    } catch (Throwable th) {
                                        th.addSuppressed(th);
                                    }
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                            absent2 = Optional.absent();
                        }
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        f13847a = absent2;
                        optional = absent2;
                    }
                } catch (Throwable th2) {
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    throw th2;
                } finally {
                }
            }
        }
        return optional;
    }
}
