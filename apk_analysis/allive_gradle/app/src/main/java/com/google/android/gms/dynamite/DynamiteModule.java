package com.google.android.gms.dynamite;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.exoplayer2.extractor.p002ts.TsExtractor;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.common.zza;
import com.google.firebase.analytics.FirebaseAnalytics;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import p000.C1851tx;
import p000.cd3;
import p000.p70;

@KeepForSdk
/* loaded from: classes.dex */
public final class DynamiteModule {

    @KeepForSdk
    public static final int LOCAL = -1;

    @KeepForSdk
    public static final int NONE = 0;

    @KeepForSdk
    public static final int NO_SELECTION = 0;

    @KeepForSdk
    public static final int REMOTE = 1;

    /* renamed from: b */
    public static Boolean f13701b = null;

    /* renamed from: c */
    public static String f13702c = null;

    /* renamed from: d */
    public static boolean f13703d = false;

    /* renamed from: e */
    public static int f13704e = -1;

    /* renamed from: f */
    public static Boolean f13705f;

    /* renamed from: j */
    public static zzp f13709j;

    /* renamed from: k */
    public static zzq f13710k;

    /* renamed from: a */
    public final Context f13711a;

    /* renamed from: g */
    public static final ThreadLocal f13706g = new ThreadLocal();

    /* renamed from: h */
    public static final C1851tx f13707h = new C1851tx(6);

    /* renamed from: i */
    public static final C0771a f13708i = new Object();

    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE = new Object();

    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_LOCAL = new Object();

    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new Object();

    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new Object();

    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new Object();

    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new Object();

    @NonNull
    public static final VersionPolicy zza = new Object();

    @DynamiteApi
    /* loaded from: classes.dex */
    public static class DynamiteLoaderClassLoader {

        @NonNull
        public static ClassLoader sClassLoader;
    }

    @KeepForSdk
    /* loaded from: classes.dex */
    public static class LoadingException extends Exception {
    }

    /* loaded from: classes.dex */
    public interface VersionPolicy {

        @KeepForSdk
        /* loaded from: classes.dex */
        public interface IVersions {
            int zza(@NonNull Context context, @NonNull String str);

            int zzb(@NonNull Context context, @NonNull String str, boolean z);
        }

        @KeepForSdk
        /* loaded from: classes.dex */
        public static class SelectionResult {

            @KeepForSdk
            public int localVersion = 0;

            @KeepForSdk
            public int remoteVersion = 0;

            @KeepForSdk
            public int selection = 0;
        }

        @NonNull
        @KeepForSdk
        SelectionResult selectModule(@NonNull Context context, @NonNull String str, @NonNull IVersions iVersions);
    }

    public DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        this.f13711a = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0131, code lost:
    
        if (r5 != false) goto L92;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int m3205a(Context context, String str, boolean z, boolean z2) {
        Cursor query;
        MatrixCursor matrixCursor;
        boolean z3;
        MatrixCursor matrixCursor2 = null;
        try {
            try {
                long longValue = ((Long) f13707h.get()).longValue();
                String str2 = "api_force_staging";
                boolean z4 = true;
                if (true != z) {
                    str2 = "api";
                }
                Uri build = new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority("com.google.android.gms.chimera").path(str2).appendPath(str).appendQueryParameter("requestStartUptime", String.valueOf(longValue)).build();
                ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(build);
                boolean z5 = false;
                if (acquireUnstableContentProviderClient != null) {
                    try {
                        query = acquireUnstableContentProviderClient.query(build, null, null, null, null);
                    } catch (RemoteException unused) {
                    } catch (Throwable th) {
                        acquireUnstableContentProviderClient.release();
                        throw th;
                    }
                    if (query != null) {
                        try {
                            int count = query.getCount();
                            int columnCount = query.getColumnCount();
                            matrixCursor = new MatrixCursor(query.getColumnNames(), count);
                            for (int i = 0; i < count; i++) {
                                if (query.moveToPosition(i)) {
                                    Object[] objArr = new Object[columnCount];
                                    for (int i2 = 0; i2 < columnCount; i2++) {
                                        int type = query.getType(i2);
                                        if (type != 0) {
                                            if (type != 1) {
                                                if (type != 2) {
                                                    if (type != 3) {
                                                        if (type == 4) {
                                                            objArr[i2] = query.getBlob(i2);
                                                        } else {
                                                            throw new RemoteException("Unknown column type");
                                                        }
                                                    } else {
                                                        objArr[i2] = query.getString(i2);
                                                    }
                                                } else {
                                                    objArr[i2] = Double.valueOf(query.getDouble(i2));
                                                }
                                            } else {
                                                objArr[i2] = Long.valueOf(query.getLong(i2));
                                            }
                                        } else {
                                            objArr[i2] = null;
                                        }
                                    }
                                    matrixCursor.addRow(objArr);
                                } else {
                                    throw new RemoteException("Cursor read incomplete (ContentProvider dead?)");
                                }
                            }
                            query.close();
                            acquireUnstableContentProviderClient.release();
                            if (matrixCursor != null) {
                                try {
                                    if (matrixCursor.moveToFirst()) {
                                        int i3 = matrixCursor.getInt(0);
                                        if (i3 > 0) {
                                            synchronized (DynamiteModule.class) {
                                                try {
                                                    f13702c = matrixCursor.getString(2);
                                                    int columnIndex = matrixCursor.getColumnIndex("loaderVersion");
                                                    if (columnIndex >= 0) {
                                                        f13704e = matrixCursor.getInt(columnIndex);
                                                    }
                                                    int columnIndex2 = matrixCursor.getColumnIndex("disableStandaloneDynamiteLoader2");
                                                    if (columnIndex2 >= 0) {
                                                        if (matrixCursor.getInt(columnIndex2) != 0) {
                                                            z3 = true;
                                                        } else {
                                                            z3 = false;
                                                        }
                                                        f13703d = z3;
                                                    } else {
                                                        z3 = false;
                                                    }
                                                } finally {
                                                }
                                            }
                                            cd3 cd3Var = (cd3) f13706g.get();
                                            if (cd3Var != null && cd3Var.f8340a == null) {
                                                cd3Var.f8340a = matrixCursor;
                                            } else {
                                                z4 = false;
                                            }
                                            z5 = z3;
                                        }
                                        matrixCursor2 = matrixCursor;
                                        if (z2 && z5) {
                                            throw new Exception("forcing fallback to container DynamiteLoader impl");
                                        }
                                        if (matrixCursor2 != null) {
                                            matrixCursor2.close();
                                        }
                                        return i3;
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    if (e instanceof LoadingException) {
                                        throw e;
                                    }
                                    throw new Exception("V2 version check failed: " + e.getMessage(), e);
                                } catch (Throwable th2) {
                                    th = th2;
                                    matrixCursor2 = matrixCursor;
                                    if (matrixCursor2 != null) {
                                        matrixCursor2.close();
                                    }
                                    throw th;
                                }
                            }
                            Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                            throw new Exception("Failed to connect to dynamite module ContentResolver.");
                        } finally {
                            try {
                                query.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                    }
                    acquireUnstableContentProviderClient.release();
                }
                matrixCursor = null;
                if (matrixCursor != null) {
                }
                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                throw new Exception("Failed to connect to dynamite module ContentResolver.");
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.google.android.gms.internal.common.zza] */
    /* renamed from: b */
    public static void m3206b(ClassLoader classLoader) {
        try {
            zzq zzqVar = null;
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(null).newInstance(null);
            if (iBinder != null) {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzq) {
                    zzqVar = (zzq) queryLocalInterface;
                } else {
                    zzqVar = new zza(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
                }
            }
            f13710k = zzqVar;
        } catch (ClassNotFoundException e) {
            e = e;
            throw new Exception("Failed to instantiate dynamite loader", e);
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new Exception("Failed to instantiate dynamite loader", e);
        } catch (InstantiationException e3) {
            e = e3;
            throw new Exception("Failed to instantiate dynamite loader", e);
        } catch (NoSuchMethodException e4) {
            e = e4;
            throw new Exception("Failed to instantiate dynamite loader", e);
        } catch (InvocationTargetException e5) {
            e = e5;
            throw new Exception("Failed to instantiate dynamite loader", e);
        }
    }

    /* renamed from: c */
    public static boolean m3207c(Context context) {
        int i;
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(f13705f)) {
            return true;
        }
        boolean z = false;
        if (f13705f == null) {
            PackageManager packageManager = context.getPackageManager();
            if (true != PlatformVersion.isAtLeastQ()) {
                i = 0;
            } else {
                i = 268435456;
            }
            ProviderInfo resolveContentProvider = packageManager.resolveContentProvider("com.google.android.gms.chimera", i);
            if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 10000000) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z = true;
            }
            f13705f = Boolean.valueOf(z);
            if (z && (applicationInfo = resolveContentProvider.applicationInfo) != null && (applicationInfo.flags & TsExtractor.TS_STREAM_TYPE_AC3) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                f13703d = true;
            }
        }
        if (!z) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public static zzp m3208d(Context context) {
        zzp zzpVar;
        synchronized (DynamiteModule.class) {
            zzp zzpVar2 = f13709j;
            if (zzpVar2 != null) {
                return zzpVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzpVar = 0;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    if (queryLocalInterface instanceof zzp) {
                        zzpVar = (zzp) queryLocalInterface;
                    } else {
                        zzpVar = new zza(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
                    }
                }
                if (zzpVar != 0) {
                    f13709j = zzpVar;
                    return zzpVar;
                }
            } catch (Exception e) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e.getMessage());
            }
            return null;
        }
    }

    @KeepForSdk
    public static int getLocalVersion(@NonNull Context context, @NonNull String str) {
        try {
            Class<?> loadClass = context.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (!Objects.equal(declaredField.get(null), str)) {
                Log.e("DynamiteModule", "Module descriptor id '" + String.valueOf(declaredField.get(null)) + "' didn't match expected id '" + str + "'");
                return 0;
            }
            return declaredField2.getInt(null);
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e.getMessage())));
            return 0;
        }
    }

    @KeepForSdk
    public static int getRemoteVersion(@NonNull Context context, @NonNull String str) {
        return zza(context, str, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0099, code lost:
    
        if (r10 != 0) goto L23;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r11v0, types: [cd3, java.lang.Object] */
    @NonNull
    @KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DynamiteModule load(@NonNull Context context, @NonNull VersionPolicy versionPolicy, @NonNull String str) {
        cd3 cd3Var;
        cd3 cd3Var2;
        DynamiteModule dynamiteModule;
        Boolean bool;
        IObjectWrapper zzh;
        DynamiteModule dynamiteModule2;
        zzq zzqVar;
        boolean z;
        IObjectWrapper zze;
        Context context2 = context;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            ThreadLocal threadLocal = f13706g;
            cd3 cd3Var3 = (cd3) threadLocal.get();
            ?? obj = new Object();
            threadLocal.set(obj);
            C1851tx c1851tx = f13707h;
            Long l = (Long) c1851tx.get();
            long longValue = l.longValue();
            try {
                c1851tx.set(Long.valueOf(SystemClock.uptimeMillis()));
                VersionPolicy.SelectionResult selectModule = versionPolicy.selectModule(context2, str, f13708i);
                int i = selectModule.localVersion;
                try {
                    int i2 = selectModule.remoteVersion;
                    try {
                        Log.i("DynamiteModule", "Considering local module " + str + ":" + i + " and remote module " + str + ":" + i2);
                        int i3 = selectModule.selection;
                        try {
                            if (i3 != 0) {
                                if (i3 == -1) {
                                    if (selectModule.localVersion != 0) {
                                        i3 = -1;
                                    }
                                }
                                i2 = i2;
                                if (i3 == 1) {
                                    int i4 = selectModule.remoteVersion;
                                    i2 = i4;
                                }
                                if (i3 == -1) {
                                    Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
                                    dynamiteModule = new DynamiteModule(applicationContext);
                                } else if (i3 == 1) {
                                    try {
                                        int i5 = selectModule.remoteVersion;
                                        try {
                                            synchronized (DynamiteModule.class) {
                                                if (m3207c(context)) {
                                                    bool = f13701b;
                                                } else {
                                                    throw new Exception("Remote loading disabled");
                                                }
                                            }
                                            if (bool != null) {
                                                if (bool.booleanValue()) {
                                                    Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i5);
                                                    synchronized (DynamiteModule.class) {
                                                        zzqVar = f13710k;
                                                    }
                                                    if (zzqVar != null) {
                                                        cd3 cd3Var4 = (cd3) threadLocal.get();
                                                        if (cd3Var4 != null && cd3Var4.f8340a != null) {
                                                            Context applicationContext2 = context.getApplicationContext();
                                                            Cursor cursor = cd3Var4.f8340a;
                                                            ObjectWrapper.wrap(null);
                                                            synchronized (DynamiteModule.class) {
                                                                if (f13704e >= 2) {
                                                                    z = true;
                                                                } else {
                                                                    z = false;
                                                                }
                                                            }
                                                            if (z) {
                                                                Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                                                zze = zzqVar.zzf(ObjectWrapper.wrap(applicationContext2), str, i5, ObjectWrapper.wrap(cursor));
                                                            } else {
                                                                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                                                zze = zzqVar.zze(ObjectWrapper.wrap(applicationContext2), str, i5, ObjectWrapper.wrap(cursor));
                                                            }
                                                            Context context3 = (Context) ObjectWrapper.unwrap(zze);
                                                            if (context3 != null) {
                                                                dynamiteModule2 = new DynamiteModule(context3);
                                                            } else {
                                                                throw new Exception("Failed to get module context");
                                                            }
                                                        } else {
                                                            throw new Exception("No result cursor");
                                                        }
                                                    } else {
                                                        throw new Exception("DynamiteLoaderV2 was not cached.");
                                                    }
                                                } else {
                                                    Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i5);
                                                    zzp m3208d = m3208d(context);
                                                    if (m3208d != null) {
                                                        int zze2 = m3208d.zze();
                                                        if (zze2 >= 3) {
                                                            cd3 cd3Var5 = (cd3) threadLocal.get();
                                                            if (cd3Var5 != null) {
                                                                zzh = m3208d.zzi(ObjectWrapper.wrap(context), str, i5, ObjectWrapper.wrap(cd3Var5.f8340a));
                                                            } else {
                                                                throw new Exception("No cached result cursor holder");
                                                            }
                                                        } else if (zze2 == 2) {
                                                            Log.w("DynamiteModule", "IDynamite loader version = 2");
                                                            zzh = m3208d.zzj(ObjectWrapper.wrap(context), str, i5);
                                                        } else {
                                                            Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                                            zzh = m3208d.zzh(ObjectWrapper.wrap(context), str, i5);
                                                        }
                                                        Object unwrap = ObjectWrapper.unwrap(zzh);
                                                        if (unwrap != null) {
                                                            dynamiteModule2 = new DynamiteModule((Context) unwrap);
                                                        } else {
                                                            throw new Exception("Failed to load remote module.");
                                                        }
                                                    } else {
                                                        throw new Exception("Failed to create IDynamiteLoader.");
                                                    }
                                                }
                                                dynamiteModule = dynamiteModule2;
                                            } else {
                                                throw new Exception("Failed to determine which loading route to use.");
                                            }
                                        } catch (RemoteException e) {
                                            throw new Exception("Failed to load remote module.", e);
                                        } catch (LoadingException e2) {
                                            throw e2;
                                        } catch (Throwable th) {
                                            CrashUtils.addDynamiteErrorToDropBox(context2, th);
                                            throw new Exception("Failed to load remote module.", th);
                                        }
                                    } catch (LoadingException e3) {
                                        Log.w("DynamiteModule", "Failed to load remote module: " + e3.getMessage());
                                        int i6 = selectModule.localVersion;
                                        if (i6 != 0 && versionPolicy.selectModule(context2, str, new C0779i(i6)).selection == -1) {
                                            Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
                                            dynamiteModule = new DynamiteModule(applicationContext);
                                        } else {
                                            throw new Exception("Remote load failed. No local fallback found.", e3);
                                        }
                                    }
                                } else {
                                    throw new Exception("VersionPolicy returned invalid code:" + i3);
                                }
                                if (longValue == 0) {
                                    f13707h.remove();
                                } else {
                                    f13707h.set(l);
                                }
                                Cursor cursor2 = obj.f8340a;
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                f13706g.set(cd3Var3);
                                return dynamiteModule;
                            }
                            throw new Exception("No acceptable module " + str + " found. Local version is " + selectModule.localVersion + " and remote version is " + selectModule.remoteVersion + ".");
                        } catch (Throwable th2) {
                            th = th2;
                            cd3Var = context2;
                            cd3Var2 = i2;
                            if (longValue == 0) {
                                f13707h.remove();
                            } else {
                                f13707h.set(l);
                            }
                            Cursor cursor3 = cd3Var.f8340a;
                            if (cursor3 != null) {
                                cursor3.close();
                            }
                            f13706g.set(cd3Var2);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        cd3Var2 = cd3Var3;
                        cd3Var = obj;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    cd3Var = obj;
                    cd3Var2 = cd3Var3;
                }
            } catch (Throwable th5) {
                th = th5;
                cd3Var = obj;
                cd3Var2 = cd3Var3;
            }
        } else {
            throw new Exception("null application Context");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x016b, code lost:
    
        if (r2 != false) goto L101;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x01cb -> B:24:0x01d0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x01cd -> B:24:0x01d0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int zza(@NonNull Context context, @NonNull String str, boolean z) {
        Field declaredField;
        Throwable th;
        RemoteException e;
        Cursor cursor;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool = f13701b;
                boolean z2 = true;
                int i = 0;
                Cursor cursor2 = null;
                if (bool == null) {
                    try {
                        declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e2) {
                        Log.w("DynamiteModule", "Failed to load module via V2: " + e2.toString());
                        bool = Boolean.FALSE;
                    }
                    synchronized (declaredField.getDeclaringClass()) {
                        ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                        if (classLoader == ClassLoader.getSystemClassLoader()) {
                            bool = Boolean.FALSE;
                        } else if (classLoader != null) {
                            try {
                                m3206b(classLoader);
                            } catch (LoadingException unused) {
                            }
                            bool = Boolean.TRUE;
                        } else {
                            if (!m3207c(context)) {
                                return 0;
                            }
                            if (!f13703d) {
                                Boolean bool2 = Boolean.TRUE;
                                if (!bool2.equals(null)) {
                                    try {
                                        int m3205a = m3205a(context, str, z, true);
                                        String str2 = f13702c;
                                        if (str2 != null && !str2.isEmpty()) {
                                            ClassLoader zza2 = zzb.zza();
                                            if (zza2 == null) {
                                                if (Build.VERSION.SDK_INT >= 29) {
                                                    p70.m6884c();
                                                    String str3 = f13702c;
                                                    Preconditions.checkNotNull(str3);
                                                    zza2 = p70.m6883b(ClassLoader.getSystemClassLoader(), str3);
                                                } else {
                                                    String str4 = f13702c;
                                                    Preconditions.checkNotNull(str4);
                                                    zza2 = new PathClassLoader(str4, ClassLoader.getSystemClassLoader());
                                                }
                                            }
                                            m3206b(zza2);
                                            declaredField.set(null, zza2);
                                            f13701b = bool2;
                                            return m3205a;
                                        }
                                        return m3205a;
                                    } catch (LoadingException unused2) {
                                        declaredField.set(null, ClassLoader.getSystemClassLoader());
                                        bool = Boolean.FALSE;
                                    }
                                }
                            }
                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                            bool = Boolean.FALSE;
                        }
                        f13701b = bool;
                    }
                }
                if (bool.booleanValue()) {
                    try {
                        return m3205a(context, str, z, false);
                    } catch (LoadingException e3) {
                        Log.w("DynamiteModule", "Failed to retrieve remote module version: " + e3.getMessage());
                        return 0;
                    }
                }
                zzp m3208d = m3208d(context);
                try {
                    if (m3208d != null) {
                        try {
                            int zze = m3208d.zze();
                            if (zze >= 3) {
                                ThreadLocal threadLocal = f13706g;
                                cd3 cd3Var = (cd3) threadLocal.get();
                                if (cd3Var != null && (cursor = cd3Var.f8340a) != null) {
                                    i = cursor.getInt(0);
                                } else {
                                    Cursor cursor3 = (Cursor) ObjectWrapper.unwrap(m3208d.zzk(ObjectWrapper.wrap(context), str, z, ((Long) f13707h.get()).longValue()));
                                    if (cursor3 != null) {
                                        try {
                                            if (cursor3.moveToFirst()) {
                                                int i2 = cursor3.getInt(0);
                                                if (i2 > 0) {
                                                    cd3 cd3Var2 = (cd3) threadLocal.get();
                                                    if (cd3Var2 != null && cd3Var2.f8340a == null) {
                                                        cd3Var2.f8340a = cursor3;
                                                    } else {
                                                        z2 = false;
                                                    }
                                                }
                                                cursor2 = cursor3;
                                                if (cursor2 != null) {
                                                    cursor2.close();
                                                }
                                                i = i2;
                                            }
                                        } catch (RemoteException e4) {
                                            e = e4;
                                            cursor2 = cursor3;
                                            Log.w("DynamiteModule", "Failed to retrieve remote module version: " + e.getMessage());
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                            return i;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            cursor2 = cursor3;
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                            throw th;
                                        }
                                    }
                                    Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                                    if (cursor3 != null) {
                                        cursor3.close();
                                    }
                                }
                            } else if (zze == 2) {
                                Log.w("DynamiteModule", "IDynamite loader version = 2, no high precision latency measurement.");
                                i = m3208d.zzg(ObjectWrapper.wrap(context), str, z);
                            } else {
                                Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
                                i = m3208d.zzf(ObjectWrapper.wrap(context), str, z);
                            }
                        } catch (RemoteException e5) {
                            e = e5;
                        }
                    }
                    return i;
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        } catch (Throwable th4) {
            CrashUtils.addDynamiteErrorToDropBox(context, th4);
            throw th4;
        }
    }

    @NonNull
    @KeepForSdk
    public Context getModuleContext() {
        return this.f13711a;
    }

    @NonNull
    @KeepForSdk
    public IBinder instantiate(@NonNull String str) {
        try {
            return (IBinder) this.f13711a.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new Exception("Failed to instantiate module class: ".concat(String.valueOf(str)), e);
        }
    }
}
