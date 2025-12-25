package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import javax.annotation.CheckForNull;

@Beta
/* loaded from: classes2.dex */
public final class Parameter implements AnnotatedElement {

    /* renamed from: a */
    public final Invokable f15231a;

    /* renamed from: b */
    public final int f15232b;

    /* renamed from: c */
    public final TypeToken f15233c;

    /* renamed from: d */
    public final ImmutableList f15234d;

    public Parameter(Invokable invokable, int i, TypeToken typeToken, Annotation[] annotationArr) {
        this.f15231a = invokable;
        this.f15232b = i;
        this.f15233c = typeToken;
        this.f15234d = ImmutableList.copyOf(annotationArr);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof Parameter)) {
            return false;
        }
        Parameter parameter = (Parameter) obj;
        if (this.f15232b != parameter.f15232b || !this.f15231a.equals(parameter.f15231a)) {
            return false;
        }
        return true;
    }

    @Override // java.lang.reflect.AnnotatedElement
    @CheckForNull
    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        Preconditions.checkNotNull(cls);
        UnmodifiableIterator it = this.f15234d.iterator();
        while (it.hasNext()) {
            Annotation annotation = (Annotation) it.next();
            if (cls.isInstance(annotation)) {
                return cls.cast(annotation);
            }
        }
        return null;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getAnnotations() {
        return getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A[] getAnnotationsByType(Class<A> cls) {
        return (A[]) getDeclaredAnnotationsByType(cls);
    }

    @Override // java.lang.reflect.AnnotatedElement
    @CheckForNull
    public <A extends Annotation> A getDeclaredAnnotation(Class<A> cls) {
        Preconditions.checkNotNull(cls);
        return (A) FluentIterable.from(this.f15234d).filter(cls).first().orNull();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getDeclaredAnnotations() {
        return (Annotation[]) this.f15234d.toArray(new Annotation[0]);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A[] getDeclaredAnnotationsByType(Class<A> cls) {
        return (A[]) ((Annotation[]) FluentIterable.from(this.f15234d).filter(cls).toArray(cls));
    }

    public Invokable<?, ?> getDeclaringInvokable() {
        return this.f15231a;
    }

    public TypeToken<?> getType() {
        return this.f15233c;
    }

    public int hashCode() {
        return this.f15232b;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        if (getAnnotation(cls) != null) {
            return true;
        }
        return false;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f15233c);
        StringBuilder sb = new StringBuilder(valueOf.length() + 15);
        sb.append(valueOf);
        sb.append(" arg");
        sb.append(this.f15232b);
        return sb.toString();
    }
}
