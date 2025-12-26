package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.primitives.Primitives;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.CheckForNull;

@Immutable(containerOf = {"B"})
@GwtIncompatible
/* loaded from: classes.dex */
public final class ImmutableClassToInstanceMap<B> extends ForwardingMap<Class<? extends B>, B> implements ClassToInstanceMap<B>, Serializable {

    /* renamed from: b */
    public static final ImmutableClassToInstanceMap f14659b = new ImmutableClassToInstanceMap(ImmutableMap.m3923of());

    /* renamed from: a */
    public final ImmutableMap f14660a;

    /* loaded from: classes.dex */
    public static final class Builder<B> {

        /* renamed from: a */
        public final ImmutableMap.Builder f14661a = ImmutableMap.builder();

        public ImmutableClassToInstanceMap<B> build() {
            ImmutableMap buildOrThrow = this.f14661a.buildOrThrow();
            if (buildOrThrow.isEmpty()) {
                return ImmutableClassToInstanceMap.m3894of();
            }
            return new ImmutableClassToInstanceMap<>(buildOrThrow);
        }

        @CanIgnoreReturnValue
        public <T extends B> Builder<B> put(Class<T> cls, T t) {
            this.f14661a.put(cls, t);
            return this;
        }

        @CanIgnoreReturnValue
        public <T extends B> Builder<B> putAll(Map<? extends Class<? extends T>, ? extends T> map) {
            for (Map.Entry<? extends Class<? extends T>, ? extends T> entry : map.entrySet()) {
                Class<? extends T> key = entry.getKey();
                this.f14661a.put(key, Primitives.wrap(key).cast(entry.getValue()));
            }
            return this;
        }
    }

    public ImmutableClassToInstanceMap(ImmutableMap immutableMap) {
        this.f14660a = immutableMap;
    }

    public static <B> Builder<B> builder() {
        return new Builder<>();
    }

    public static <B, S extends B> ImmutableClassToInstanceMap<B> copyOf(Map<? extends Class<? extends S>, ? extends S> map) {
        if (map instanceof ImmutableClassToInstanceMap) {
            return (ImmutableClassToInstanceMap) map;
        }
        return new Builder().putAll(map).build();
    }

    /* renamed from: of */
    public static <B> ImmutableClassToInstanceMap<B> m3894of() {
        return f14659b;
    }

    @Override // com.google.common.collect.ClassToInstanceMap
    @CheckForNull
    public <T extends B> T getInstance(Class<T> cls) {
        return (T) this.f14660a.get(Preconditions.checkNotNull(cls));
    }

    @Override // com.google.common.collect.ClassToInstanceMap
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public <T extends B> T putInstance(Class<T> cls, T t) {
        throw new UnsupportedOperationException();
    }

    public Object readResolve() {
        if (isEmpty()) {
            return m3894of();
        }
        return this;
    }

    /* renamed from: of */
    public static <B, T extends B> ImmutableClassToInstanceMap<B> m3895of(Class<T> cls, T t) {
        return new ImmutableClassToInstanceMap<>(ImmutableMap.m3924of(cls, t));
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public Map<Class<? extends B>, B> delegate() {
        return this.f14660a;
    }
}
