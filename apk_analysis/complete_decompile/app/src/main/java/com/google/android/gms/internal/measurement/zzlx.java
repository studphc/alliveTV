package com.google.android.gms.internal.measurement;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public abstract class zzlx {
    /* renamed from: a */
    public static zzlp m3468a() {
        String m7057m;
        ClassLoader classLoader = zzlx.class.getClassLoader();
        if (zzlp.class.equals(zzlp.class)) {
            m7057m = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";
        } else if (zzlp.class.getPackage().equals(zzlx.class.getPackage())) {
            m7057m = AbstractC1726qj.m7057m(zzlp.class.getPackage().getName(), ".BlazeGeneratedzzlpLoader");
        } else {
            throw new IllegalArgumentException(zzlp.class.getName());
        }
        try {
            try {
                try {
                    try {
                        return (zzlp) zzlp.class.cast(((zzlx) Class.forName(m7057m, true, classLoader).getConstructor(null).newInstance(null)).zza());
                    } catch (IllegalAccessException e) {
                        throw new IllegalStateException(e);
                    }
                } catch (InvocationTargetException e2) {
                    throw new IllegalStateException(e2);
                }
            } catch (InstantiationException e3) {
                throw new IllegalStateException(e3);
            } catch (NoSuchMethodException e4) {
                throw new IllegalStateException(e4);
            }
        } catch (ClassNotFoundException unused) {
            Iterator it = ServiceLoader.load(zzlx.class, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    arrayList.add((zzlp) zzlp.class.cast(((zzlx) it.next()).zza()));
                } catch (ServiceConfigurationError e5) {
                    Logger.getLogger(zzlk.class.getName()).logp(Level.SEVERE, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load ".concat("zzlp"), (Throwable) e5);
                }
            }
            if (arrayList.size() == 1) {
                return (zzlp) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (zzlp) zzlp.class.getMethod("combine", Collection.class).invoke(null, arrayList);
            } catch (IllegalAccessException e6) {
                throw new IllegalStateException(e6);
            } catch (NoSuchMethodException e7) {
                throw new IllegalStateException(e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(e8);
            }
        }
    }

    public abstract zzlp zza();
}
