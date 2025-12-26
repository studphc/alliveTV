package androidx.core.location;

import android.location.GnssMeasurementsEvent$Callback;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.collection.SimpleArrayMap;
import androidx.core.location.GnssStatusCompat;
import androidx.core.os.CancellationSignal;
import androidx.core.os.ExecutorCompat;
import androidx.core.util.Consumer;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p000.CallableC1764rk;
import p000.ExecutorC2014yb;
import p000.RunnableC0006a5;
import p000.bd1;
import p000.cd1;
import p000.ed1;
import p000.fd1;
import p000.fx0;
import p000.gd1;
import p000.hd1;
import p000.jd1;
import p000.md1;
import p000.zc1;

/* loaded from: classes.dex */
public final class LocationManagerCompat {

    /* renamed from: a */
    public static Class f3677a;

    /* renamed from: b */
    public static Method f3678b;

    /* renamed from: c */
    public static Method f3679c;

    /* renamed from: d */
    public static final WeakHashMap f3680d = new WeakHashMap();

    /* renamed from: a */
    public static boolean m865a(LocationManager locationManager, Executor executor, GnssMeasurementsEvent$Callback gnssMeasurementsEvent$Callback) {
        if (Build.VERSION.SDK_INT == 30) {
            try {
                if (f3677a == null) {
                    f3677a = Class.forName("android.location.GnssRequest$Builder");
                }
                if (f3678b == null) {
                    Method declaredMethod = f3677a.getDeclaredMethod("build", null);
                    f3678b = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                if (f3679c == null) {
                    Method declaredMethod2 = LocationManager.class.getDeclaredMethod("registerGnssMeasurementsCallback", Class.forName("android.location.GnssRequest"), Executor.class, fx0.m4857j());
                    f3679c = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                }
                Object invoke = f3679c.invoke(locationManager, f3678b.invoke(f3677a.getDeclaredConstructor(null).newInstance(null), null), executor, gnssMeasurementsEvent$Callback);
                if (invoke != null) {
                    if (((Boolean) invoke).booleanValue()) {
                        return true;
                    }
                }
                return false;
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
                return false;
            }
        }
        throw new IllegalStateException();
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00d7 A[Catch: all -> 0x00b2, TryCatch #0 {all -> 0x00b2, blocks: (B:26:0x0060, B:60:0x00b8, B:61:0x00ce, B:48:0x00cf, B:50:0x00d7, B:52:0x00df, B:53:0x00e5, B:54:0x00e6, B:55:0x00eb, B:56:0x00ec, B:57:0x00f2), top: B:25:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ec A[Catch: all -> 0x00b2, TryCatch #0 {all -> 0x00b2, blocks: (B:26:0x0060, B:60:0x00b8, B:61:0x00ce, B:48:0x00cf, B:50:0x00d7, B:52:0x00df, B:53:0x00e5, B:54:0x00e6, B:55:0x00eb, B:56:0x00ec, B:57:0x00f2), top: B:25:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f5 A[Catch: all -> 0x002f, TRY_ENTER, TryCatch #10 {all -> 0x002f, blocks: (B:16:0x0021, B:18:0x0029, B:19:0x0035, B:22:0x003c, B:24:0x0056, B:35:0x0083, B:36:0x008a, B:40:0x0098, B:41:0x009f, B:65:0x00f5, B:66:0x00fc, B:77:0x005a, B:79:0x00fd, B:80:0x0113, B:82:0x0032), top: B:15:0x0021 }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m866b(LocationManager locationManager, Handler handler, Executor executor, GnssStatusCompat.Callback callback) {
        boolean z;
        boolean z2;
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            return AbstractC0182b.m874b(locationManager, handler, executor, callback);
        }
        if (i >= 24) {
            return AbstractC0181a.m870c(locationManager, handler, executor, callback);
        }
        boolean z3 = false;
        if (handler != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        SimpleArrayMap simpleArrayMap = gd1.f17651a;
        synchronized (simpleArrayMap) {
            try {
                C0184d c0184d = (C0184d) simpleArrayMap.get(callback);
                if (c0184d == null) {
                    c0184d = new C0184d(locationManager, callback);
                } else {
                    c0184d.f3700c = null;
                }
                if (c0184d.f3700c == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Preconditions.checkState(z2);
                c0184d.f3700c = executor;
                FutureTask futureTask = new FutureTask(new CallableC1764rk(1, locationManager, c0184d));
                if (Looper.myLooper() == handler.getLooper()) {
                    futureTask.run();
                } else if (!handler.post(futureTask)) {
                    throw new IllegalStateException(handler + " is shutting down");
                }
                try {
                    try {
                        long nanos = TimeUnit.SECONDS.toNanos(5L);
                        long nanoTime = System.nanoTime() + nanos;
                        boolean z4 = false;
                        while (((Boolean) futureTask.get(nanos, TimeUnit.NANOSECONDS)).booleanValue()) {
                            try {
                                try {
                                    gd1.f17651a.put(callback, c0184d);
                                    if (z4) {
                                        Thread.currentThread().interrupt();
                                    }
                                    return true;
                                } catch (ExecutionException e) {
                                    e = e;
                                    if (e.getCause() instanceof RuntimeException) {
                                        if (e.getCause() instanceof Error) {
                                            throw ((Error) e.getCause());
                                        }
                                        throw new IllegalStateException(e);
                                    }
                                    throw ((RuntimeException) e.getCause());
                                } catch (TimeoutException e2) {
                                    e = e2;
                                    throw new IllegalStateException(handler + " appears to be blocked, please run registerGnssStatusCallback() directly on a Looper thread or ensure the main Looper is not blocked by this thread", e);
                                } catch (Throwable th) {
                                    th = th;
                                    z3 = true;
                                    if (z3) {
                                        Thread.currentThread().interrupt();
                                    }
                                    throw th;
                                }
                            } catch (InterruptedException unused) {
                                nanos = nanoTime - System.nanoTime();
                                z4 = true;
                            } catch (ExecutionException e3) {
                                e = e3;
                                if (e.getCause() instanceof RuntimeException) {
                                }
                            } catch (TimeoutException e4) {
                                e = e4;
                                throw new IllegalStateException(handler + " appears to be blocked, please run registerGnssStatusCallback() directly on a Looper thread or ensure the main Looper is not blocked by this thread", e);
                            } catch (Throwable th2) {
                                th = th2;
                                z3 = z4;
                                if (z3) {
                                }
                                throw th;
                            }
                        }
                        if (z4) {
                            Thread.currentThread().interrupt();
                        }
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (ExecutionException e5) {
                    e = e5;
                } catch (TimeoutException e6) {
                    e = e6;
                }
            } finally {
            }
        }
    }

    /* renamed from: c */
    public static void m867c(LocationManager locationManager, md1 md1Var) {
        md1 md1Var2;
        WeakReference weakReference = (WeakReference) f3680d.put((jd1) ObjectsCompat.requireNonNull(md1Var.f22897a), new WeakReference(md1Var));
        if (weakReference != null) {
            md1Var2 = (md1) weakReference.get();
        } else {
            md1Var2 = null;
        }
        if (md1Var2 != null) {
            md1Var2.f22897a = null;
            locationManager.removeUpdates(md1Var2);
        }
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @Deprecated
    public static void getCurrentLocation(@NonNull LocationManager locationManager, @NonNull String str, @Nullable CancellationSignal cancellationSignal, @NonNull Executor executor, @NonNull Consumer<Location> consumer) {
        getCurrentLocation(locationManager, str, cancellationSignal != null ? (android.os.CancellationSignal) cancellationSignal.getCancellationSignalObject() : null, executor, consumer);
    }

    @Nullable
    public static String getGnssHardwareModelName(@NonNull LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return cd1.m2226a(locationManager);
        }
        return null;
    }

    public static int getGnssYearOfHardware(@NonNull LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return cd1.m2227b(locationManager);
        }
        return 0;
    }

    public static boolean hasProvider(@NonNull LocationManager locationManager, @NonNull String str) {
        if (Build.VERSION.SDK_INT >= 31) {
            return ed1.m4688a(locationManager, str);
        }
        if (locationManager.getAllProviders().contains(str)) {
            return true;
        }
        try {
            if (locationManager.getProvider(str) != null) {
                return true;
            }
            return false;
        } catch (SecurityException unused) {
            return false;
        }
    }

    public static boolean isLocationEnabled(@NonNull LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return cd1.m2228c(locationManager);
        }
        if (!locationManager.isProviderEnabled("network") && !locationManager.isProviderEnabled("gps")) {
            return false;
        }
        return true;
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    @RequiresApi(24)
    public static boolean registerGnssMeasurementsCallback(@NonNull LocationManager locationManager, @NonNull GnssMeasurementsEvent$Callback gnssMeasurementsEvent$Callback, @NonNull Handler handler) {
        int i = Build.VERSION.SDK_INT;
        if (i > 30) {
            return AbstractC0181a.m869b(locationManager, gnssMeasurementsEvent$Callback, handler);
        }
        if (i == 30) {
            return m865a(locationManager, ExecutorCompat.create(handler), gnssMeasurementsEvent$Callback);
        }
        SimpleArrayMap simpleArrayMap = gd1.f17652b;
        synchronized (simpleArrayMap) {
            try {
                unregisterGnssMeasurementsCallback(locationManager, gnssMeasurementsEvent$Callback);
                if (!AbstractC0181a.m869b(locationManager, gnssMeasurementsEvent$Callback, handler)) {
                    return false;
                }
                simpleArrayMap.put(gnssMeasurementsEvent$Callback, gnssMeasurementsEvent$Callback);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull GnssStatusCompat.Callback callback, @NonNull Handler handler) {
        if (Build.VERSION.SDK_INT >= 30) {
            return registerGnssStatusCallback(locationManager, ExecutorCompat.create(handler), callback);
        }
        return registerGnssStatusCallback(locationManager, new ExecutorC2014yb(2, handler), callback);
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void removeUpdates(@NonNull LocationManager locationManager, @NonNull LocationListenerCompat locationListenerCompat) {
        WeakHashMap weakHashMap = f3680d;
        synchronized (weakHashMap) {
            try {
                Iterator it = weakHashMap.values().iterator();
                ArrayList arrayList = null;
                while (it.hasNext()) {
                    md1 md1Var = (md1) ((WeakReference) it.next()).get();
                    if (md1Var != null) {
                        jd1 jd1Var = (jd1) ObjectsCompat.requireNonNull(md1Var.f22897a);
                        if (jd1Var.f20469b == locationListenerCompat) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(jd1Var);
                            md1Var.f22897a = null;
                            locationManager.removeUpdates(md1Var);
                        }
                    }
                }
                if (arrayList != null) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        f3680d.remove((jd1) it2.next());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        locationManager.removeUpdates(locationListenerCompat);
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void requestLocationUpdates(@NonNull LocationManager locationManager, @NonNull String str, @NonNull LocationRequestCompat locationRequestCompat, @NonNull Executor executor, @NonNull LocationListenerCompat locationListenerCompat) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            ed1.m4690c(locationManager, str, locationRequestCompat.toLocationRequest(), executor, locationListenerCompat);
            return;
        }
        if (i < 30 || !AbstractC0182b.m875c(locationManager, str, locationRequestCompat, executor, locationListenerCompat)) {
            md1 md1Var = new md1(new jd1(locationListenerCompat, str), executor);
            if (bd1.m2085a(locationManager, str, locationRequestCompat, md1Var)) {
                return;
            }
            synchronized (f3680d) {
                locationManager.requestLocationUpdates(str, locationRequestCompat.getIntervalMillis(), locationRequestCompat.getMinUpdateDistanceMeters(), md1Var, Looper.getMainLooper());
                m867c(locationManager, md1Var);
            }
        }
    }

    @RequiresApi(24)
    public static void unregisterGnssMeasurementsCallback(@NonNull LocationManager locationManager, @NonNull GnssMeasurementsEvent$Callback gnssMeasurementsEvent$Callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            AbstractC0181a.m871d(locationManager, gnssMeasurementsEvent$Callback);
            return;
        }
        SimpleArrayMap simpleArrayMap = gd1.f17652b;
        synchronized (simpleArrayMap) {
            try {
                GnssMeasurementsEvent$Callback m4853f = fx0.m4853f(simpleArrayMap.remove(gnssMeasurementsEvent$Callback));
                if (m4853f != null) {
                    if (m4853f instanceof hd1) {
                        ((hd1) m4853f).f18030b = null;
                    }
                    AbstractC0181a.m871d(locationManager, m4853f);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void unregisterGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull GnssStatusCompat.Callback callback) {
        if (Build.VERSION.SDK_INT >= 24) {
            SimpleArrayMap simpleArrayMap = gd1.f17651a;
            synchronized (simpleArrayMap) {
                try {
                    Object remove = simpleArrayMap.remove(callback);
                    if (remove != null) {
                        AbstractC0181a.m872e(locationManager, remove);
                    }
                } finally {
                }
            }
            return;
        }
        SimpleArrayMap simpleArrayMap2 = gd1.f17651a;
        synchronized (simpleArrayMap2) {
            try {
                C0184d c0184d = (C0184d) simpleArrayMap2.remove(callback);
                if (c0184d != null) {
                    c0184d.f3700c = null;
                    locationManager.removeGpsStatusListener(c0184d);
                }
            } finally {
            }
        }
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void getCurrentLocation(@NonNull LocationManager locationManager, @NonNull String str, @Nullable android.os.CancellationSignal cancellationSignal, @NonNull Executor executor, @NonNull Consumer<Location> consumer) {
        if (Build.VERSION.SDK_INT >= 30) {
            AbstractC0182b.m873a(locationManager, str, cancellationSignal, executor, consumer);
            return;
        }
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        Location lastKnownLocation = locationManager.getLastKnownLocation(str);
        if (lastKnownLocation != null && SystemClock.elapsedRealtime() - LocationCompat.getElapsedRealtimeMillis(lastKnownLocation) < 10000) {
            executor.execute(new zc1(consumer, lastKnownLocation, 0));
            return;
        }
        final fd1 fd1Var = new fd1(locationManager, executor, consumer);
        locationManager.requestLocationUpdates(str, 0L, RecyclerView.f7068F0, fd1Var, Looper.getMainLooper());
        if (cancellationSignal != null) {
            cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: ad1
                @Override // android.os.CancellationSignal.OnCancelListener
                public final void onCancel() {
                    fd1 fd1Var2 = fd1.this;
                    synchronized (fd1Var2) {
                        try {
                            if (!fd1Var2.f17217e) {
                                fd1Var2.f17217e = true;
                                fd1Var2.f17216d = null;
                                fd1Var2.f17213a.removeUpdates(fd1Var2);
                                RunnableC0006a5 runnableC0006a5 = fd1Var2.f17218f;
                                if (runnableC0006a5 != null) {
                                    fd1Var2.f17215c.removeCallbacks(runnableC0006a5);
                                    fd1Var2.f17218f = null;
                                }
                            }
                        } finally {
                        }
                    }
                }
            });
        }
        synchronized (fd1Var) {
            try {
                if (fd1Var.f17217e) {
                    return;
                }
                RunnableC0006a5 runnableC0006a5 = new RunnableC0006a5(23, fd1Var);
                fd1Var.f17218f = runnableC0006a5;
                fd1Var.f17215c.postDelayed(runnableC0006a5, 30000L);
            } finally {
            }
        }
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull Executor executor, @NonNull GnssStatusCompat.Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            return m866b(locationManager, null, executor, callback);
        }
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            myLooper = Looper.getMainLooper();
        }
        return m866b(locationManager, new Handler(myLooper), executor, callback);
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    @RequiresApi(24)
    public static boolean registerGnssMeasurementsCallback(@NonNull LocationManager locationManager, @NonNull Executor executor, @NonNull GnssMeasurementsEvent$Callback gnssMeasurementsEvent$Callback) {
        int i = Build.VERSION.SDK_INT;
        if (i > 30) {
            return ed1.m4689b(locationManager, executor, gnssMeasurementsEvent$Callback);
        }
        if (i == 30) {
            return m865a(locationManager, executor, gnssMeasurementsEvent$Callback);
        }
        SimpleArrayMap simpleArrayMap = gd1.f17652b;
        synchronized (simpleArrayMap) {
            try {
                hd1 hd1Var = new hd1(gnssMeasurementsEvent$Callback, executor);
                unregisterGnssMeasurementsCallback(locationManager, gnssMeasurementsEvent$Callback);
                if (!AbstractC0181a.m868a(locationManager, hd1Var)) {
                    return false;
                }
                simpleArrayMap.put(gnssMeasurementsEvent$Callback, hd1Var);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void requestLocationUpdates(@NonNull LocationManager locationManager, @NonNull String str, @NonNull LocationRequestCompat locationRequestCompat, @NonNull LocationListenerCompat locationListenerCompat, @NonNull Looper looper) {
        if (Build.VERSION.SDK_INT >= 31) {
            ed1.m4690c(locationManager, str, locationRequestCompat.toLocationRequest(), ExecutorCompat.create(new Handler(looper)), locationListenerCompat);
        } else {
            if (bd1.m2086b(locationManager, str, locationRequestCompat, locationListenerCompat, looper)) {
                return;
            }
            locationManager.requestLocationUpdates(str, locationRequestCompat.getIntervalMillis(), locationRequestCompat.getMinUpdateDistanceMeters(), locationListenerCompat, looper);
        }
    }
}
