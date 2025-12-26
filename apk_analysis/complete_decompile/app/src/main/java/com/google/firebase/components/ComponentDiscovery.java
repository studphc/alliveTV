package com.google.firebase.components;

import android.app.Service;
import android.content.Context;
import android.util.Log;
import com.google.firebase.inject.Provider;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p000.AbstractC1726qj;
import p000.C1958wt;
import p000.C1995xt;
import p000.ye0;

/* loaded from: classes2.dex */
public final class ComponentDiscovery<T> {

    /* renamed from: a */
    public final Context f15525a;

    /* renamed from: b */
    public final C1995xt f15526b;

    public ComponentDiscovery(Context context, C1995xt c1995xt) {
        this.f15525a = context;
        this.f15526b = c1995xt;
    }

    /* renamed from: a */
    public static ComponentRegistrar m4373a(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                return (ComponentRegistrar) cls.getDeclaredConstructor(null).newInstance(null);
            }
            throw new InvalidRegistrarException("Class " + str + " is not an instance of com.google.firebase.components.ComponentRegistrar");
        } catch (ClassNotFoundException unused) {
            Log.w("ComponentDiscovery", "Class " + str + " is not an found.");
            return null;
        } catch (IllegalAccessException e) {
            throw new InvalidRegistrarException(ye0.m8296p("Could not instantiate ", str, "."), e);
        } catch (InstantiationException e2) {
            throw new InvalidRegistrarException(ye0.m8296p("Could not instantiate ", str, "."), e2);
        } catch (NoSuchMethodException e3) {
            throw new InvalidRegistrarException(AbstractC1726qj.m7038C("Could not instantiate ", str), e3);
        } catch (InvocationTargetException e4) {
            throw new InvalidRegistrarException(AbstractC1726qj.m7038C("Could not instantiate ", str), e4);
        }
    }

    public static ComponentDiscovery<Context> forContext(Context context, Class<? extends Service> cls) {
        return new ComponentDiscovery<>(context, new C1995xt(cls));
    }

    @Deprecated
    public List<ComponentRegistrar> discover() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f15526b.m8192a(this.f15525a).iterator();
        while (it.hasNext()) {
            try {
                ComponentRegistrar m4373a = m4373a((String) it.next());
                if (m4373a != null) {
                    arrayList.add(m4373a);
                }
            } catch (InvalidRegistrarException e) {
                Log.w("ComponentDiscovery", "Invalid component registrar.", e);
            }
        }
        return arrayList;
    }

    public List<Provider<ComponentRegistrar>> discoverLazy() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f15526b.m8192a(this.f15525a).iterator();
        while (it.hasNext()) {
            arrayList.add(new C1958wt(0, (String) it.next()));
        }
        return arrayList;
    }
}
