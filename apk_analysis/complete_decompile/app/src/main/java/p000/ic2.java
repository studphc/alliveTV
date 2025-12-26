package p000;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.DependencyException;
import com.google.firebase.components.Qualified;
import com.google.firebase.events.Publisher;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public final class ic2 implements ComponentContainer {

    /* renamed from: a */
    public final Set f18363a;

    /* renamed from: b */
    public final Set f18364b;

    /* renamed from: c */
    public final Set f18365c;

    /* renamed from: d */
    public final Set f18366d;

    /* renamed from: e */
    public final Set f18367e;

    /* renamed from: f */
    public final Set f18368f;

    /* renamed from: g */
    public final ComponentContainer f18369g;

    public ic2(Component component, ComponentContainer componentContainer) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (Dependency dependency : component.getDependencies()) {
            if (dependency.isDirectInjection()) {
                if (dependency.isSet()) {
                    hashSet4.add(dependency.getInterface());
                } else {
                    hashSet.add(dependency.getInterface());
                }
            } else if (dependency.isDeferred()) {
                hashSet3.add(dependency.getInterface());
            } else if (dependency.isSet()) {
                hashSet5.add(dependency.getInterface());
            } else {
                hashSet2.add(dependency.getInterface());
            }
        }
        if (!component.getPublishedEvents().isEmpty()) {
            hashSet.add(Qualified.unqualified(Publisher.class));
        }
        this.f18363a = Collections.unmodifiableSet(hashSet);
        this.f18364b = Collections.unmodifiableSet(hashSet2);
        this.f18365c = Collections.unmodifiableSet(hashSet3);
        this.f18366d = Collections.unmodifiableSet(hashSet4);
        this.f18367e = Collections.unmodifiableSet(hashSet5);
        this.f18368f = component.getPublishedEvents();
        this.f18369g = componentContainer;
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final Object get(Class cls) {
        if (this.f18363a.contains(Qualified.unqualified(cls))) {
            Object obj = this.f18369g.get((Class<Object>) cls);
            return !cls.equals(Publisher.class) ? obj : new hc2(this.f18368f, (Publisher) obj);
        }
        throw new DependencyException("Attempting to request an undeclared dependency " + cls + ".");
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final Deferred getDeferred(Class cls) {
        return getDeferred(Qualified.unqualified(cls));
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final Provider getProvider(Class cls) {
        return getProvider(Qualified.unqualified(cls));
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final /* synthetic */ Set setOf(Class cls) {
        return AbstractC1921vt.m7938f(this, cls);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final Provider setOfProvider(Class cls) {
        return setOfProvider(Qualified.unqualified(cls));
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final Deferred getDeferred(Qualified qualified) {
        if (this.f18365c.contains(qualified)) {
            return this.f18369g.getDeferred(qualified);
        }
        throw new DependencyException("Attempting to request an undeclared dependency Deferred<" + qualified + ">.");
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final Provider getProvider(Qualified qualified) {
        if (this.f18364b.contains(qualified)) {
            return this.f18369g.getProvider(qualified);
        }
        throw new DependencyException("Attempting to request an undeclared dependency Provider<" + qualified + ">.");
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final Set setOf(Qualified qualified) {
        if (this.f18366d.contains(qualified)) {
            return this.f18369g.setOf(qualified);
        }
        throw new DependencyException("Attempting to request an undeclared dependency Set<" + qualified + ">.");
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final Provider setOfProvider(Qualified qualified) {
        if (this.f18367e.contains(qualified)) {
            return this.f18369g.setOfProvider(qualified);
        }
        throw new DependencyException("Attempting to request an undeclared dependency Provider<Set<" + qualified + ">>.");
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final Object get(Qualified qualified) {
        if (this.f18363a.contains(qualified)) {
            return this.f18369g.get(qualified);
        }
        throw new DependencyException("Attempting to request an undeclared dependency " + qualified + ".");
    }
}
