package com.google.common.reflect;

import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.util.Map;
import javax.annotation.CheckForNull;

/* loaded from: classes2.dex */
public final class ImmutableTypeToInstanceMap<B> extends ForwardingMap<TypeToken<? extends B>, B> implements TypeToInstanceMap<B> {

    /* renamed from: a */
    public final ImmutableMap f15226a;

    /* loaded from: classes2.dex */
    public static final class Builder<B> {

        /* renamed from: a */
        public final ImmutableMap.Builder f15227a = ImmutableMap.builder();

        public ImmutableTypeToInstanceMap<B> build() {
            return new ImmutableTypeToInstanceMap<>(this.f15227a.buildOrThrow());
        }

        @CanIgnoreReturnValue
        public <T extends B> Builder<B> put(Class<T> cls, T t) {
            this.f15227a.put(TypeToken.m4293of((Class) cls), t);
            return this;
        }

        @CanIgnoreReturnValue
        public <T extends B> Builder<B> put(TypeToken<T> typeToken, T t) {
            typeToken.m4299i();
            this.f15227a.put(typeToken, t);
            return this;
        }
    }

    public ImmutableTypeToInstanceMap(ImmutableMap immutableMap) {
        this.f15226a = immutableMap;
    }

    public static <B> Builder<B> builder() {
        return new Builder<>();
    }

    /* renamed from: of */
    public static <B> ImmutableTypeToInstanceMap<B> m4279of() {
        return new ImmutableTypeToInstanceMap<>(ImmutableMap.m3923of());
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @CheckForNull
    public <T extends B> T getInstance(TypeToken<T> typeToken) {
        typeToken.m4299i();
        return (T) this.f15226a.get(typeToken);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((TypeToken<? extends TypeToken<? extends B>>) obj, (TypeToken<? extends B>) obj2);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void putAll(Map<? extends TypeToken<? extends B>, ? extends B> map) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public <T extends B> T putInstance(TypeToken<T> typeToken, T t) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public Map<TypeToken<? extends B>, B> delegate() {
        return this.f15226a;
    }

    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public B put(TypeToken<? extends B> typeToken, B b) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public <T extends B> T putInstance(Class<T> cls, T t) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @CheckForNull
    public <T extends B> T getInstance(Class<T> cls) {
        return (T) this.f15226a.get(TypeToken.m4293of((Class) cls));
    }
}
