package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import javax.annotation.CheckForNull;
import p000.AbstractC1726qj;
import p000.f51;

@Beta
/* loaded from: classes2.dex */
public abstract class Invokable<T, R> implements AnnotatedElement, Member {

    /* renamed from: a */
    public final AccessibleObject f15228a;

    /* renamed from: b */
    public final Member f15229b;

    /* JADX WARN: Multi-variable type inference failed */
    public Invokable(AccessibleObject accessibleObject) {
        Preconditions.checkNotNull(accessibleObject);
        this.f15228a = accessibleObject;
        this.f15229b = (Member) accessibleObject;
    }

    public static Invokable<?, Object> from(Method method) {
        return new f51(method);
    }

    /* renamed from: a */
    public abstract Type[] mo4280a();

    /* renamed from: b */
    public abstract Type[] mo4281b();

    /* renamed from: c */
    public abstract Type mo4282c();

    /* renamed from: d */
    public abstract Annotation[][] mo4283d();

    /* renamed from: e */
    public abstract Object mo4284e(Object obj, Object[] objArr);

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof Invokable)) {
            return false;
        }
        Invokable invokable = (Invokable) obj;
        if (!getOwnerType().equals(invokable.getOwnerType()) || !this.f15229b.equals(invokable.f15229b)) {
            return false;
        }
        return true;
    }

    @Override // java.lang.reflect.AnnotatedElement
    @CheckForNull
    public final <A extends Annotation> A getAnnotation(Class<A> cls) {
        return (A) this.f15228a.getAnnotation(cls);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getAnnotations() {
        return this.f15228a.getAnnotations();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getDeclaredAnnotations() {
        return this.f15228a.getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.Member
    public final Class<? super T> getDeclaringClass() {
        return (Class<? super T>) this.f15229b.getDeclaringClass();
    }

    public final ImmutableList<TypeToken<? extends Throwable>> getExceptionTypes() {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Type type : mo4280a()) {
            builder.add((ImmutableList.Builder) TypeToken.m4294of(type));
        }
        return builder.build();
    }

    @Override // java.lang.reflect.Member
    public final int getModifiers() {
        return this.f15229b.getModifiers();
    }

    @Override // java.lang.reflect.Member
    public final String getName() {
        return this.f15229b.getName();
    }

    public TypeToken<T> getOwnerType() {
        return TypeToken.m4293of((Class) getDeclaringClass());
    }

    public final ImmutableList<Parameter> getParameters() {
        Type[] mo4281b = mo4281b();
        Annotation[][] mo4283d = mo4283d();
        ImmutableList.Builder builder = ImmutableList.builder();
        for (int i = 0; i < mo4281b.length; i++) {
            builder.add((ImmutableList.Builder) new Parameter(this, i, TypeToken.m4294of(mo4281b[i]), mo4283d[i]));
        }
        return builder.build();
    }

    public final TypeToken<? extends R> getReturnType() {
        return (TypeToken<? extends R>) TypeToken.m4294of(mo4282c());
    }

    public abstract TypeVariable<?>[] getTypeParameters();

    public int hashCode() {
        return this.f15229b.hashCode();
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public final R invoke(@CheckForNull T t, Object... objArr) {
        return (R) mo4284e(t, (Object[]) Preconditions.checkNotNull(objArr));
    }

    public final boolean isAbstract() {
        return Modifier.isAbstract(getModifiers());
    }

    public final boolean isAccessible() {
        return this.f15228a.isAccessible();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return this.f15228a.isAnnotationPresent(cls);
    }

    public final boolean isFinal() {
        return Modifier.isFinal(getModifiers());
    }

    public final boolean isNative() {
        return Modifier.isNative(getModifiers());
    }

    public abstract boolean isOverridable();

    public final boolean isPackagePrivate() {
        if (!isPrivate() && !isPublic() && !isProtected()) {
            return true;
        }
        return false;
    }

    public final boolean isPrivate() {
        return Modifier.isPrivate(getModifiers());
    }

    public final boolean isProtected() {
        return Modifier.isProtected(getModifiers());
    }

    public final boolean isPublic() {
        return Modifier.isPublic(getModifiers());
    }

    public final boolean isStatic() {
        return Modifier.isStatic(getModifiers());
    }

    public final boolean isSynchronized() {
        return Modifier.isSynchronized(getModifiers());
    }

    @Override // java.lang.reflect.Member
    public final boolean isSynthetic() {
        return this.f15229b.isSynthetic();
    }

    public abstract boolean isVarArgs();

    public final <R1 extends R> Invokable<T, R1> returning(Class<R1> cls) {
        return returning(TypeToken.m4293of((Class) cls));
    }

    public final void setAccessible(boolean z) {
        this.f15228a.setAccessible(z);
    }

    public String toString() {
        return this.f15229b.toString();
    }

    public final boolean trySetAccessible() {
        try {
            this.f15228a.setAccessible(true);
            return true;
        } catch (RuntimeException unused) {
            return false;
        }
    }

    public static <T> Invokable<T, T> from(Constructor<T> constructor) {
        return new f51(constructor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R1 extends R> Invokable<T, R1> returning(TypeToken<R1> typeToken) {
        if (typeToken.isSupertypeOf(getReturnType())) {
            return this;
        }
        String valueOf = String.valueOf(getReturnType());
        String valueOf2 = String.valueOf(typeToken);
        throw new IllegalArgumentException(AbstractC1726qj.m7055k(valueOf2.length() + valueOf.length() + 35, "Invokable is known to return ", valueOf, ", not ", valueOf2));
    }
}
