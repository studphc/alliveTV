package com.google.firebase.components;

import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.dynamicloading.ComponentLoader;
import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import p000.AbstractC1921vt;
import p000.C0533au;
import p000.C1958wt;
import p000.C2069zt;
import p000.RunnableC0583c7;
import p000.ca0;
import p000.j12;
import p000.p63;
import p000.v71;

/* loaded from: classes2.dex */
public class ComponentRuntime implements ComponentContainer, ComponentLoader {

    /* renamed from: i */
    public static final C2069zt f15527i = new C2069zt(0);

    /* renamed from: a */
    public final HashMap f15528a;

    /* renamed from: b */
    public final HashMap f15529b;

    /* renamed from: c */
    public final HashMap f15530c;

    /* renamed from: d */
    public final ArrayList f15531d;

    /* renamed from: e */
    public final HashSet f15532e;

    /* renamed from: f */
    public final ca0 f15533f;

    /* renamed from: g */
    public final AtomicReference f15534g;

    /* renamed from: h */
    public final ComponentRegistrarProcessor f15535h;

    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a */
        public final Executor f15536a;

        /* renamed from: b */
        public final ArrayList f15537b = new ArrayList();

        /* renamed from: c */
        public final ArrayList f15538c = new ArrayList();

        /* renamed from: d */
        public ComponentRegistrarProcessor f15539d = ComponentRegistrarProcessor.NOOP;

        public Builder(Executor executor) {
            this.f15536a = executor;
        }

        @CanIgnoreReturnValue
        public Builder addComponent(Component<?> component) {
            this.f15538c.add(component);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addComponentRegistrar(ComponentRegistrar componentRegistrar) {
            this.f15537b.add(new C1958wt(1, componentRegistrar));
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addLazyComponentRegistrars(Collection<Provider<ComponentRegistrar>> collection) {
            this.f15537b.addAll(collection);
            return this;
        }

        public ComponentRuntime build() {
            return new ComponentRuntime(this.f15536a, this.f15537b, this.f15538c, this.f15539d);
        }

        @CanIgnoreReturnValue
        public Builder setProcessor(ComponentRegistrarProcessor componentRegistrarProcessor) {
            this.f15539d = componentRegistrarProcessor;
            return this;
        }
    }

    public ComponentRuntime(Executor executor, ArrayList arrayList, List list, ComponentRegistrarProcessor componentRegistrarProcessor) {
        this.f15528a = new HashMap();
        this.f15529b = new HashMap();
        this.f15530c = new HashMap();
        this.f15532e = new HashSet();
        this.f15534g = new AtomicReference();
        ca0 ca0Var = new ca0(executor);
        this.f15533f = ca0Var;
        this.f15535h = componentRegistrarProcessor;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(Component.m4372of(ca0Var, (Class<ca0>) ca0.class, (Class<? super ca0>[]) new Class[]{Subscriber.class, Publisher.class}));
        arrayList2.add(Component.m4372of(this, (Class<ComponentRuntime>) ComponentLoader.class, (Class<? super ComponentRuntime>[]) new Class[0]));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Component component = (Component) it.next();
            if (component != null) {
                arrayList2.add(component);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList3.add(it2.next());
        }
        this.f15531d = arrayList3;
        m4374a(arrayList2);
    }

    public static Builder builder(Executor executor) {
        return new Builder(executor);
    }

    /* renamed from: a */
    public final void m4374a(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        synchronized (this) {
            Iterator it = this.f15531d.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = (ComponentRegistrar) ((Provider) it.next()).get();
                    if (componentRegistrar != null) {
                        arrayList.addAll(this.f15535h.processRegistrar(componentRegistrar));
                        it.remove();
                    }
                } catch (InvalidRegistrarException e) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Object[] array = ((Component) it2.next()).getProvidedInterfaces().toArray();
                int length = array.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        Object obj = array[i];
                        if (obj.toString().contains("kotlinx.coroutines.CoroutineDispatcher")) {
                            if (this.f15532e.contains(obj.toString())) {
                                it2.remove();
                                break;
                            }
                            this.f15532e.add(obj.toString());
                        }
                        i++;
                    }
                }
            }
            if (this.f15528a.isEmpty()) {
                p63.m6841A(arrayList);
            } else {
                ArrayList arrayList3 = new ArrayList(this.f15528a.keySet());
                arrayList3.addAll(arrayList);
                p63.m6841A(arrayList3);
            }
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                Component component = (Component) it3.next();
                this.f15528a.put(component, new Lazy(new C0533au(0, this, component)));
            }
            arrayList2.addAll(m4377d(arrayList));
            arrayList2.addAll(m4378e());
            m4376c();
        }
        Iterator it4 = arrayList2.iterator();
        while (it4.hasNext()) {
            ((Runnable) it4.next()).run();
        }
        Boolean bool = (Boolean) this.f15534g.get();
        if (bool != null) {
            m4375b(this.f15528a, bool.booleanValue());
        }
    }

    /* renamed from: b */
    public final void m4375b(HashMap hashMap, boolean z) {
        ArrayDeque arrayDeque;
        for (Map.Entry entry : hashMap.entrySet()) {
            Component component = (Component) entry.getKey();
            Provider provider = (Provider) entry.getValue();
            if (component.isAlwaysEager() || (component.isEagerInDefaultApp() && z)) {
                provider.get();
            }
        }
        ca0 ca0Var = this.f15533f;
        synchronized (ca0Var) {
            arrayDeque = ca0Var.f8303b;
            if (arrayDeque != null) {
                ca0Var.f8303b = null;
            } else {
                arrayDeque = null;
            }
        }
        if (arrayDeque != null) {
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                ca0Var.publish((Event) it.next());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [v71, java.lang.Object] */
    /* renamed from: c */
    public final void m4376c() {
        for (Component component : this.f15528a.keySet()) {
            for (Dependency dependency : component.getDependencies()) {
                if (dependency.isSet()) {
                    Qualified<?> qualified = dependency.getInterface();
                    HashMap hashMap = this.f15530c;
                    if (!hashMap.containsKey(qualified)) {
                        Qualified<?> qualified2 = dependency.getInterface();
                        Set emptySet = Collections.emptySet();
                        ?? obj = new Object();
                        obj.f27664b = null;
                        obj.f27663a = Collections.newSetFromMap(new ConcurrentHashMap());
                        obj.f27663a.addAll(emptySet);
                        hashMap.put(qualified2, obj);
                    }
                }
                Qualified<?> qualified3 = dependency.getInterface();
                HashMap hashMap2 = this.f15529b;
                if (hashMap2.containsKey(qualified3)) {
                    continue;
                } else if (!dependency.isRequired()) {
                    if (!dependency.isSet()) {
                        hashMap2.put(dependency.getInterface(), new j12(j12.f20343c, j12.f20344d));
                    }
                } else {
                    throw new MissingDependencyException("Unsatisfied dependency for component " + component + ": " + dependency.getInterface());
                }
            }
        }
    }

    /* renamed from: d */
    public final ArrayList m4377d(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Component component = (Component) it.next();
            if (component.isValue()) {
                Provider provider = (Provider) this.f15528a.get(component);
                for (Qualified qualified : component.getProvidedInterfaces()) {
                    HashMap hashMap = this.f15529b;
                    if (!hashMap.containsKey(qualified)) {
                        hashMap.put(qualified, provider);
                    } else {
                        arrayList2.add(new RunnableC0583c7(6, (j12) ((Provider) hashMap.get(qualified)), provider));
                    }
                }
            }
        }
        return arrayList2;
    }

    @Override // com.google.firebase.dynamicloading.ComponentLoader
    public void discoverComponents() {
        synchronized (this) {
            try {
                if (this.f15531d.isEmpty()) {
                    return;
                }
                m4374a(new ArrayList());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [v71, java.lang.Object] */
    /* renamed from: e */
    public final ArrayList m4378e() {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : this.f15528a.entrySet()) {
            Component component = (Component) entry.getKey();
            if (!component.isValue()) {
                Provider provider = (Provider) entry.getValue();
                for (Qualified qualified : component.getProvidedInterfaces()) {
                    if (!hashMap.containsKey(qualified)) {
                        hashMap.put(qualified, new HashSet());
                    }
                    ((Set) hashMap.get(qualified)).add(provider);
                }
            }
        }
        for (Map.Entry entry2 : hashMap.entrySet()) {
            Object key = entry2.getKey();
            HashMap hashMap2 = this.f15530c;
            if (!hashMap2.containsKey(key)) {
                Qualified qualified2 = (Qualified) entry2.getKey();
                Set set = (Set) ((Collection) entry2.getValue());
                ?? obj = new Object();
                obj.f27664b = null;
                obj.f27663a = Collections.newSetFromMap(new ConcurrentHashMap());
                obj.f27663a.addAll(set);
                hashMap2.put(qualified2, obj);
            } else {
                v71 v71Var = (v71) hashMap2.get(entry2.getKey());
                Iterator it = ((Set) entry2.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new RunnableC0583c7(7, v71Var, (Provider) it.next()));
                }
            }
        }
        return arrayList;
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final /* synthetic */ Object get(Qualified qualified) {
        return AbstractC1921vt.m7933a(this, qualified);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final /* synthetic */ Deferred getDeferred(Class cls) {
        return AbstractC1921vt.m7935c(this, cls);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final /* synthetic */ Provider getProvider(Class cls) {
        return AbstractC1921vt.m7936d(this, cls);
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    @VisibleForTesting
    public void initializeAllComponentsForTests() {
        Iterator it = this.f15528a.values().iterator();
        while (it.hasNext()) {
            ((Provider) it.next()).get();
        }
    }

    public void initializeEagerComponents(boolean z) {
        HashMap hashMap;
        AtomicReference atomicReference = this.f15534g;
        Boolean valueOf = Boolean.valueOf(z);
        while (!atomicReference.compareAndSet(null, valueOf)) {
            if (atomicReference.get() != null) {
                return;
            }
        }
        synchronized (this) {
            hashMap = new HashMap(this.f15528a);
        }
        m4375b(hashMap, z);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final /* synthetic */ Set setOf(Qualified qualified) {
        return AbstractC1921vt.m7937e(this, qualified);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final /* synthetic */ Provider setOfProvider(Class cls) {
        return AbstractC1921vt.m7939g(this, cls);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final /* synthetic */ Object get(Class cls) {
        return AbstractC1921vt.m7934b(this, cls);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Deferred<T> getDeferred(Qualified<T> qualified) {
        Provider<T> provider = getProvider(qualified);
        if (provider == null) {
            return new j12(j12.f20343c, j12.f20344d);
        }
        if (provider instanceof j12) {
            return (j12) provider;
        }
        return new j12(null, provider);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public synchronized <T> Provider<T> getProvider(Qualified<T> qualified) {
        Preconditions.checkNotNull(qualified, "Null interface requested.");
        return (Provider) this.f15529b.get(qualified);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final /* synthetic */ Set setOf(Class cls) {
        return AbstractC1921vt.m7938f(this, cls);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public synchronized <T> Provider<Set<T>> setOfProvider(Qualified<T> qualified) {
        v71 v71Var = (v71) this.f15530c.get(qualified);
        if (v71Var != null) {
            return v71Var;
        }
        return f15527i;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ComponentRuntime(Executor executor, Iterable<ComponentRegistrar> iterable, Component<?>... componentArr) {
        this(executor, r0, Arrays.asList(componentArr), ComponentRegistrarProcessor.NOOP);
        ArrayList arrayList = new ArrayList();
        Iterator<ComponentRegistrar> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(new C1958wt(1, it.next()));
        }
    }
}
