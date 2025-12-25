package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

@KeepForSdk
@Deprecated
/* loaded from: classes.dex */
public class LibraryVersion {

    /* renamed from: b */
    public static final GmsLogger f13448b = new GmsLogger("LibraryVersion", "");

    /* renamed from: c */
    public static final LibraryVersion f13449c = new LibraryVersion();

    /* renamed from: a */
    public final ConcurrentHashMap f13450a = new ConcurrentHashMap();

    @VisibleForTesting
    public LibraryVersion() {
    }

    @NonNull
    @KeepForSdk
    public static LibraryVersion getInstance() {
        return f13449c;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0094  */
    @NonNull
    @KeepForSdk
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getVersion(@NonNull String str) {
        IOException e;
        String str2;
        InputStream inputStream;
        GmsLogger gmsLogger = f13448b;
        Preconditions.checkNotEmpty(str, "Please provide a valid libraryName");
        ConcurrentHashMap concurrentHashMap = this.f13450a;
        if (concurrentHashMap.containsKey(str)) {
            return (String) concurrentHashMap.get(str);
        }
        Properties properties = new Properties();
        InputStream inputStream2 = null;
        r6 = null;
        String str3 = null;
        inputStream2 = null;
        try {
            try {
                inputStream = LibraryVersion.class.getResourceAsStream("/" + str + ".properties");
            } catch (IOException e2) {
                e = e2;
                str2 = null;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (inputStream != null) {
                properties.load(inputStream);
                str3 = properties.getProperty("version", null);
                gmsLogger.m3148v("LibraryVersion", str + " version is " + str3);
            } else {
                gmsLogger.m3150w("LibraryVersion", "Failed to get app version for libraryName: " + str);
            }
        } catch (IOException e3) {
            e = e3;
            String str4 = str3;
            inputStream2 = inputStream;
            str2 = str4;
            gmsLogger.m3145e("LibraryVersion", "Failed to get app version for libraryName: " + str, e);
            InputStream inputStream3 = inputStream2;
            str3 = str2;
            inputStream = inputStream3;
            if (inputStream != null) {
            }
            if (str3 == null) {
            }
            concurrentHashMap.put(str, str3);
            return str3;
        } catch (Throwable th2) {
            th = th2;
            inputStream2 = inputStream;
            if (inputStream2 != null) {
                IOUtils.closeQuietly(inputStream2);
            }
            throw th;
        }
        if (inputStream != null) {
            IOUtils.closeQuietly(inputStream);
        }
        if (str3 == null) {
            gmsLogger.m3142d("LibraryVersion", ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used");
            str3 = "UNKNOWN";
        }
        concurrentHashMap.put(str, str3);
        return str3;
    }
}
