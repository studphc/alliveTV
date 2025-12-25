package com.google.firebase;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.core.os.UserManagerCompat;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.components.Lazy;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.concurrent.UiExecutor;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.DataCollectionConfigStorage;
import com.google.firebase.provider.FirebaseInitProvider;
import com.google.firebase.tracing.ComponentMonitor;
import com.google.firebase.tracing.FirebaseTrace;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p000.AbstractC1921vt;
import p000.C0533au;
import p000.ce0;
import p000.de0;

/* loaded from: classes2.dex */
public class FirebaseApp {

    @NonNull
    public static final String DEFAULT_APP_NAME = "[DEFAULT]";

    /* renamed from: k */
    public static final Object f15451k = new Object();

    /* renamed from: l */
    public static final ArrayMap f15452l = new ArrayMap();

    /* renamed from: a */
    public final Context f15453a;

    /* renamed from: b */
    public final String f15454b;

    /* renamed from: c */
    public final FirebaseOptions f15455c;

    /* renamed from: d */
    public final ComponentRuntime f15456d;

    /* renamed from: g */
    public final Lazy f15459g;

    /* renamed from: h */
    public final Provider f15460h;

    /* renamed from: e */
    public final AtomicBoolean f15457e = new AtomicBoolean(false);

    /* renamed from: f */
    public final AtomicBoolean f15458f = new AtomicBoolean();

    /* renamed from: i */
    public final CopyOnWriteArrayList f15461i = new CopyOnWriteArrayList();

    /* renamed from: j */
    public final CopyOnWriteArrayList f15462j = new CopyOnWriteArrayList();

    @KeepForSdk
    /* loaded from: classes2.dex */
    public interface BackgroundStateChangeListener {
        @KeepForSdk
        void onBackgroundStateChanged(boolean z);
    }

    public FirebaseApp(Context context, String str, FirebaseOptions firebaseOptions) {
        this.f15453a = (Context) Preconditions.checkNotNull(context);
        this.f15454b = Preconditions.checkNotEmpty(str);
        this.f15455c = (FirebaseOptions) Preconditions.checkNotNull(firebaseOptions);
        StartupTime startupTime = FirebaseInitProvider.getStartupTime();
        FirebaseTrace.pushTrace("Firebase");
        FirebaseTrace.pushTrace("ComponentDiscovery");
        List<Provider<ComponentRegistrar>> discoverLazy = ComponentDiscovery.forContext(context, ComponentDiscoveryService.class).discoverLazy();
        FirebaseTrace.popTrace();
        FirebaseTrace.pushTrace("Runtime");
        ComponentRuntime.Builder processor = ComponentRuntime.builder(UiExecutor.INSTANCE).addLazyComponentRegistrars(discoverLazy).addComponentRegistrar(new FirebaseCommonRegistrar()).addComponentRegistrar(new ExecutorsRegistrar()).addComponent(Component.m4372of(context, (Class<Context>) Context.class, (Class<? super Context>[]) new Class[0])).addComponent(Component.m4372of(this, (Class<FirebaseApp>) FirebaseApp.class, (Class<? super FirebaseApp>[]) new Class[0])).addComponent(Component.m4372of(firebaseOptions, (Class<FirebaseOptions>) FirebaseOptions.class, (Class<? super FirebaseOptions>[]) new Class[0])).setProcessor(new ComponentMonitor());
        if (UserManagerCompat.isUserUnlocked(context) && FirebaseInitProvider.isCurrentlyInitializing()) {
            processor.addComponent(Component.m4372of(startupTime, (Class<StartupTime>) StartupTime.class, (Class<? super StartupTime>[]) new Class[0]));
        }
        ComponentRuntime build = processor.build();
        this.f15456d = build;
        FirebaseTrace.popTrace();
        this.f15459g = new Lazy(new C0533au(2, this, context));
        build.getClass();
        this.f15460h = AbstractC1921vt.m7936d(build, DefaultHeartBeatController.class);
        addBackgroundStateChangeListener(new BackgroundStateChangeListener() { // from class: be0
            @Override // com.google.firebase.FirebaseApp.BackgroundStateChangeListener
            public final void onBackgroundStateChanged(boolean z) {
                FirebaseApp firebaseApp = FirebaseApp.this;
                if (!z) {
                    ((DefaultHeartBeatController) firebaseApp.f15460h.get()).registerHeartBeat();
                } else {
                    String str2 = FirebaseApp.DEFAULT_APP_NAME;
                    firebaseApp.getClass();
                }
            }
        });
        FirebaseTrace.popTrace();
    }

    /* renamed from: b */
    public static ArrayList m4363b() {
        ArrayList arrayList = new ArrayList();
        synchronized (f15451k) {
            try {
                Iterator it = f15452l.values().iterator();
                while (it.hasNext()) {
                    arrayList.add(((FirebaseApp) it.next()).getName());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    @VisibleForTesting
    public static void clearInstancesForTest() {
        synchronized (f15451k) {
            f15452l.clear();
        }
    }

    @NonNull
    public static List<FirebaseApp> getApps(@NonNull Context context) {
        ArrayList arrayList;
        synchronized (f15451k) {
            arrayList = new ArrayList(f15452l.values());
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public static FirebaseApp getInstance() {
        FirebaseApp firebaseApp;
        synchronized (f15451k) {
            try {
                firebaseApp = (FirebaseApp) f15452l.get(DEFAULT_APP_NAME);
                if (firebaseApp == null) {
                    throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + ProcessUtils.getMyProcessName() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
                }
                ((DefaultHeartBeatController) firebaseApp.f15460h.get()).registerHeartBeat();
            } catch (Throwable th) {
                throw th;
            }
        }
        return firebaseApp;
    }

    @Nullable
    public static FirebaseApp initializeApp(@NonNull Context context) {
        synchronized (f15451k) {
            try {
                if (f15452l.containsKey(DEFAULT_APP_NAME)) {
                    return getInstance();
                }
                FirebaseOptions fromResource = FirebaseOptions.fromResource(context);
                if (fromResource == null) {
                    Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                    return null;
                }
                return initializeApp(context, fromResource);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: a */
    public final void m4364a() {
        Preconditions.checkState(!this.f15458f.get(), "FirebaseApp was deleted");
    }

    @KeepForSdk
    public void addBackgroundStateChangeListener(BackgroundStateChangeListener backgroundStateChangeListener) {
        m4364a();
        if (this.f15457e.get() && BackgroundDetector.getInstance().isInBackground()) {
            backgroundStateChangeListener.onBackgroundStateChanged(true);
        }
        this.f15461i.add(backgroundStateChangeListener);
    }

    @KeepForSdk
    public void addLifecycleEventListener(@NonNull FirebaseAppLifecycleListener firebaseAppLifecycleListener) {
        m4364a();
        Preconditions.checkNotNull(firebaseAppLifecycleListener);
        this.f15462j.add(firebaseAppLifecycleListener);
    }

    /* renamed from: c */
    public final void m4365c() {
        Context context = this.f15453a;
        if (!UserManagerCompat.isUserUnlocked(context)) {
            Log.i("FirebaseApp", "Device in Direct Boot Mode: postponing initialization of Firebase APIs for app " + getName());
            AtomicReference atomicReference = de0.f16350b;
            if (atomicReference.get() == null) {
                de0 de0Var = new de0(context);
                while (!atomicReference.compareAndSet(null, de0Var)) {
                    if (atomicReference.get() != null) {
                        return;
                    }
                }
                context.registerReceiver(de0Var, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                return;
            }
            return;
        }
        Log.i("FirebaseApp", "Device unlocked: initializing all Firebase APIs for app " + getName());
        this.f15456d.initializeEagerComponents(isDefaultApp());
        ((DefaultHeartBeatController) this.f15460h.get()).registerHeartBeat();
    }

    /* renamed from: d */
    public final void m4366d(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        Iterator it = this.f15461i.iterator();
        while (it.hasNext()) {
            ((BackgroundStateChangeListener) it.next()).onBackgroundStateChanged(z);
        }
    }

    public void delete() {
        if (!this.f15458f.compareAndSet(false, true)) {
            return;
        }
        synchronized (f15451k) {
            f15452l.remove(this.f15454b);
        }
        Iterator it = this.f15462j.iterator();
        while (it.hasNext()) {
            ((FirebaseAppLifecycleListener) it.next()).onDeleted(this.f15454b, this.f15455c);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseApp)) {
            return false;
        }
        return this.f15454b.equals(((FirebaseApp) obj).getName());
    }

    @KeepForSdk
    public <T> T get(Class<T> cls) {
        m4364a();
        ComponentRuntime componentRuntime = this.f15456d;
        componentRuntime.getClass();
        return (T) AbstractC1921vt.m7934b(componentRuntime, cls);
    }

    @NonNull
    public Context getApplicationContext() {
        m4364a();
        return this.f15453a;
    }

    @NonNull
    public String getName() {
        m4364a();
        return this.f15454b;
    }

    @NonNull
    public FirebaseOptions getOptions() {
        m4364a();
        return this.f15455c;
    }

    @KeepForSdk
    public String getPersistenceKey() {
        return Base64Utils.encodeUrlSafeNoPadding(getName().getBytes(Charset.defaultCharset())) + "+" + Base64Utils.encodeUrlSafeNoPadding(getOptions().getApplicationId().getBytes(Charset.defaultCharset()));
    }

    public int hashCode() {
        return this.f15454b.hashCode();
    }

    @KeepForSdk
    public boolean isDataCollectionDefaultEnabled() {
        m4364a();
        return ((DataCollectionConfigStorage) this.f15459g.get()).isEnabled();
    }

    @KeepForSdk
    @VisibleForTesting
    public boolean isDefaultApp() {
        return DEFAULT_APP_NAME.equals(getName());
    }

    @KeepForSdk
    public void removeBackgroundStateChangeListener(BackgroundStateChangeListener backgroundStateChangeListener) {
        m4364a();
        this.f15461i.remove(backgroundStateChangeListener);
    }

    @KeepForSdk
    public void removeLifecycleEventListener(@NonNull FirebaseAppLifecycleListener firebaseAppLifecycleListener) {
        m4364a();
        Preconditions.checkNotNull(firebaseAppLifecycleListener);
        this.f15462j.remove(firebaseAppLifecycleListener);
    }

    public void setAutomaticResourceManagementEnabled(boolean z) {
        m4364a();
        if (this.f15457e.compareAndSet(!z, z)) {
            boolean isInBackground = BackgroundDetector.getInstance().isInBackground();
            if (z && isInBackground) {
                m4366d(true);
            } else if (!z && isInBackground) {
                m4366d(false);
            }
        }
    }

    @KeepForSdk
    public void setDataCollectionDefaultEnabled(Boolean bool) {
        m4364a();
        ((DataCollectionConfigStorage) this.f15459g.get()).setEnabled(bool);
    }

    public String toString() {
        return Objects.toStringHelper(this).add(AppMeasurementSdk.ConditionalUserProperty.NAME, this.f15454b).add("options", this.f15455c).toString();
    }

    @KeepForSdk
    @Deprecated
    public void setDataCollectionDefaultEnabled(boolean z) {
        setDataCollectionDefaultEnabled(Boolean.valueOf(z));
    }

    @KeepForSdk
    public static String getPersistenceKey(String str, FirebaseOptions firebaseOptions) {
        return Base64Utils.encodeUrlSafeNoPadding(str.getBytes(Charset.defaultCharset())) + "+" + Base64Utils.encodeUrlSafeNoPadding(firebaseOptions.getApplicationId().getBytes(Charset.defaultCharset()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public static FirebaseApp getInstance(@NonNull String str) {
        FirebaseApp firebaseApp;
        String str2;
        synchronized (f15451k) {
            try {
                firebaseApp = (FirebaseApp) f15452l.get(str.trim());
                if (firebaseApp != null) {
                    ((DefaultHeartBeatController) firebaseApp.f15460h.get()).registerHeartBeat();
                } else {
                    ArrayList m4363b = m4363b();
                    if (m4363b.isEmpty()) {
                        str2 = "";
                    } else {
                        str2 = "Available app names: " + TextUtils.join(", ", m4363b);
                    }
                    throw new IllegalStateException("FirebaseApp with name " + str + " doesn't exist. " + str2);
                }
            } finally {
            }
        }
        return firebaseApp;
    }

    @NonNull
    public static FirebaseApp initializeApp(@NonNull Context context, @NonNull FirebaseOptions firebaseOptions) {
        return initializeApp(context, firebaseOptions, DEFAULT_APP_NAME);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.google.android.gms.common.api.internal.BackgroundDetector$BackgroundStateChangeListener, java.lang.Object] */
    @NonNull
    public static FirebaseApp initializeApp(@NonNull Context context, @NonNull FirebaseOptions firebaseOptions, @NonNull String str) {
        FirebaseApp firebaseApp;
        AtomicReference atomicReference = ce0.f8345a;
        if (PlatformVersion.isAtLeastIceCreamSandwich() && (context.getApplicationContext() instanceof Application)) {
            Application application = (Application) context.getApplicationContext();
            AtomicReference atomicReference2 = ce0.f8345a;
            if (atomicReference2.get() == null) {
                ?? obj = new Object();
                while (true) {
                    if (atomicReference2.compareAndSet(null, obj)) {
                        BackgroundDetector.initialize(application);
                        BackgroundDetector.getInstance().addListener(obj);
                        break;
                    }
                    if (atomicReference2.get() != null) {
                        break;
                    }
                }
            }
        }
        String trim = str.trim();
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f15451k) {
            ArrayMap arrayMap = f15452l;
            Preconditions.checkState(!arrayMap.containsKey(trim), "FirebaseApp name " + trim + " already exists!");
            Preconditions.checkNotNull(context, "Application context cannot be null.");
            firebaseApp = new FirebaseApp(context, trim, firebaseOptions);
            arrayMap.put(trim, firebaseApp);
        }
        firebaseApp.m4365c();
        return firebaseApp;
    }
}
