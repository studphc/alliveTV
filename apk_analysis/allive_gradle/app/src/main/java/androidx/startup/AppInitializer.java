package androidx.startup;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.tracing.Trace;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class AppInitializer {

    /* renamed from: d */
    public static volatile AppInitializer f7538d;

    /* renamed from: e */
    public static final Object f7539e = new Object();

    /* renamed from: c */
    public final Context f7542c;

    /* renamed from: b */
    public final HashSet f7541b = new HashSet();

    /* renamed from: a */
    public final HashMap f7540a = new HashMap();

    public AppInitializer(Context context) {
        this.f7542c = context.getApplicationContext();
    }

    @NonNull
    public static AppInitializer getInstance(@NonNull Context context) {
        if (f7538d == null) {
            synchronized (f7539e) {
                try {
                    if (f7538d == null) {
                        f7538d = new AppInitializer(context);
                    }
                } finally {
                }
            }
        }
        return f7538d;
    }

    /* renamed from: a */
    public final void m1906a(Bundle bundle) {
        HashSet hashSet;
        String string = this.f7542c.getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    boolean hasNext = it.hasNext();
                    hashSet = this.f7541b;
                    if (!hasNext) {
                        break;
                    }
                    String next = it.next();
                    if (string.equals(bundle.getString(next, null))) {
                        Class<?> cls = Class.forName(next);
                        if (Initializer.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    m1907b((Class) it2.next(), hashSet2);
                }
            } catch (ClassNotFoundException e) {
                throw new StartupException(e);
            }
        }
    }

    /* renamed from: b */
    public final Object m1907b(Class cls, HashSet hashSet) {
        Object obj;
        if (Trace.isEnabled()) {
            try {
                Trace.beginSection(cls.getSimpleName());
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
        if (!hashSet.contains(cls)) {
            HashMap hashMap = this.f7540a;
            if (!hashMap.containsKey(cls)) {
                hashSet.add(cls);
                try {
                    Initializer initializer = (Initializer) cls.getDeclaredConstructor(null).newInstance(null);
                    List<Class<? extends Initializer<?>>> dependencies = initializer.dependencies();
                    if (!dependencies.isEmpty()) {
                        for (Class<? extends Initializer<?>> cls2 : dependencies) {
                            if (!hashMap.containsKey(cls2)) {
                                m1907b(cls2, hashSet);
                            }
                        }
                    }
                    obj = initializer.create(this.f7542c);
                    hashSet.remove(cls);
                    hashMap.put(cls, obj);
                } catch (Throwable th2) {
                    throw new StartupException(th2);
                }
            } else {
                obj = hashMap.get(cls);
            }
            Trace.endSection();
            return obj;
        }
        throw new IllegalStateException("Cannot initialize " + cls.getName() + ". Cycle detected.");
    }

    @NonNull
    public <T> T initializeComponent(@NonNull Class<? extends Initializer<T>> cls) {
        T t;
        synchronized (f7539e) {
            try {
                t = (T) this.f7540a.get(cls);
                if (t == null) {
                    t = (T) m1907b(cls, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t;
    }

    public boolean isEagerlyInitialized(@NonNull Class<? extends Initializer<?>> cls) {
        return this.f7541b.contains(cls);
    }
}
