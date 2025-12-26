package com.google.firebase.components;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import p000.C1523lt;

/* loaded from: classes2.dex */
public final class Component<T> {

    /* renamed from: a */
    public final String f15511a;

    /* renamed from: b */
    public final Set f15512b;

    /* renamed from: c */
    public final Set f15513c;

    /* renamed from: d */
    public final int f15514d;

    /* renamed from: e */
    public final int f15515e;

    /* renamed from: f */
    public final ComponentFactory f15516f;

    /* renamed from: g */
    public final Set f15517g;

    public Component(String str, Set set, Set set2, int i, int i2, ComponentFactory componentFactory, Set set3) {
        this.f15511a = str;
        this.f15512b = Collections.unmodifiableSet(set);
        this.f15513c = Collections.unmodifiableSet(set2);
        this.f15514d = i;
        this.f15515e = i2;
        this.f15516f = componentFactory;
        this.f15517g = Collections.unmodifiableSet(set3);
    }

    public static <T> Builder<T> builder(Class<T> cls) {
        return new Builder<>(cls, new Class[0]);
    }

    public static <T> Component<T> intoSet(T t, Class<T> cls) {
        return intoSetBuilder(cls).factory(new C1523lt(0, t)).build();
    }

    public static <T> Builder<T> intoSetBuilder(Class<T> cls) {
        Builder<T> builder = builder(cls);
        builder.f15522e = 1;
        return builder;
    }

    @Deprecated
    /* renamed from: of */
    public static <T> Component<T> m4370of(Class<T> cls, T t) {
        return builder(cls).factory(new C1523lt(0, t)).build();
    }

    public Set<Dependency> getDependencies() {
        return this.f15513c;
    }

    public ComponentFactory<T> getFactory() {
        return this.f15516f;
    }

    @Nullable
    public String getName() {
        return this.f15511a;
    }

    public Set<Qualified<? super T>> getProvidedInterfaces() {
        return this.f15512b;
    }

    public Set<Class<?>> getPublishedEvents() {
        return this.f15517g;
    }

    public boolean isAlwaysEager() {
        if (this.f15514d == 1) {
            return true;
        }
        return false;
    }

    public boolean isEagerInDefaultApp() {
        if (this.f15514d == 2) {
            return true;
        }
        return false;
    }

    public boolean isLazy() {
        if (this.f15514d == 0) {
            return true;
        }
        return false;
    }

    public boolean isValue() {
        if (this.f15515e == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f15512b.toArray()) + ">{" + this.f15514d + ", type=" + this.f15515e + ", deps=" + Arrays.toString(this.f15513c.toArray()) + "}";
    }

    public Component<T> withFactory(ComponentFactory<T> componentFactory) {
        return new Component<>(this.f15511a, this.f15512b, this.f15513c, this.f15514d, this.f15515e, componentFactory, this.f15517g);
    }

    @SafeVarargs
    public static <T> Builder<T> builder(Class<T> cls, Class<? super T>... clsArr) {
        return new Builder<>(cls, clsArr);
    }

    public static <T> Component<T> intoSet(T t, Qualified<T> qualified) {
        return intoSetBuilder(qualified).factory(new C1523lt(0, t)).build();
    }

    @SafeVarargs
    /* renamed from: of */
    public static <T> Component<T> m4372of(T t, Class<T> cls, Class<? super T>... clsArr) {
        return builder(cls, clsArr).factory(new C1523lt(0, t)).build();
    }

    public static <T> Builder<T> builder(Qualified<T> qualified) {
        return new Builder<>(qualified, new Qualified[0]);
    }

    public static <T> Builder<T> intoSetBuilder(Qualified<T> qualified) {
        Builder<T> builder = builder(qualified);
        builder.f15522e = 1;
        return builder;
    }

    @SafeVarargs
    /* renamed from: of */
    public static <T> Component<T> m4371of(T t, Qualified<T> qualified, Qualified<? super T>... qualifiedArr) {
        return builder(qualified, qualifiedArr).factory(new C1523lt(0, t)).build();
    }

    @SafeVarargs
    public static <T> Builder<T> builder(Qualified<T> qualified, Qualified<? super T>... qualifiedArr) {
        return new Builder<>(qualified, qualifiedArr);
    }

    /* loaded from: classes2.dex */
    public static class Builder<T> {

        /* renamed from: a */
        public String f15518a = null;

        /* renamed from: b */
        public final HashSet f15519b;

        /* renamed from: c */
        public final HashSet f15520c;

        /* renamed from: d */
        public int f15521d;

        /* renamed from: e */
        public int f15522e;

        /* renamed from: f */
        public ComponentFactory f15523f;

        /* renamed from: g */
        public final HashSet f15524g;

        public Builder(Class cls, Class[] clsArr) {
            HashSet hashSet = new HashSet();
            this.f15519b = hashSet;
            this.f15520c = new HashSet();
            this.f15521d = 0;
            this.f15522e = 0;
            this.f15524g = new HashSet();
            Preconditions.checkNotNull(cls, "Null interface");
            hashSet.add(Qualified.unqualified(cls));
            for (Class cls2 : clsArr) {
                Preconditions.checkNotNull(cls2, "Null interface");
                this.f15519b.add(Qualified.unqualified(cls2));
            }
        }

        @CanIgnoreReturnValue
        public Builder<T> add(Dependency dependency) {
            Preconditions.checkNotNull(dependency, "Null dependency");
            Preconditions.checkArgument(!this.f15519b.contains(dependency.getInterface()), "Components are not allowed to depend on interfaces they themselves provide.");
            this.f15520c.add(dependency);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<T> alwaysEager() {
            boolean z;
            if (this.f15521d == 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "Instantiation type has already been set.");
            this.f15521d = 1;
            return this;
        }

        public Component<T> build() {
            boolean z;
            if (this.f15523f != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "Missing required property: factory.");
            return new Component<>(this.f15518a, new HashSet(this.f15519b), new HashSet(this.f15520c), this.f15521d, this.f15522e, this.f15523f, this.f15524g);
        }

        @CanIgnoreReturnValue
        public Builder<T> eagerInDefaultApp() {
            boolean z;
            if (this.f15521d == 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "Instantiation type has already been set.");
            this.f15521d = 2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<T> factory(ComponentFactory<T> componentFactory) {
            this.f15523f = (ComponentFactory) Preconditions.checkNotNull(componentFactory, "Null factory");
            return this;
        }

        public Builder<T> name(@NonNull String str) {
            this.f15518a = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<T> publishes(Class<?> cls) {
            this.f15524g.add(cls);
            return this;
        }

        public Builder(Qualified qualified, Qualified[] qualifiedArr) {
            HashSet hashSet = new HashSet();
            this.f15519b = hashSet;
            this.f15520c = new HashSet();
            this.f15521d = 0;
            this.f15522e = 0;
            this.f15524g = new HashSet();
            Preconditions.checkNotNull(qualified, "Null interface");
            hashSet.add(qualified);
            for (Qualified qualified2 : qualifiedArr) {
                Preconditions.checkNotNull(qualified2, "Null interface");
            }
            Collections.addAll(this.f15519b, qualifiedArr);
        }
    }
}
