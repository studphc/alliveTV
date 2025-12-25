package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.errorprone.annotations.Immutable;
import java.util.AbstractMap;
import java.util.Comparator;
import javax.annotation.CheckForNull;

@Immutable
@Beta
/* loaded from: classes2.dex */
public final class ElementOrder<T> {

    /* renamed from: a */
    public final Type f15031a;

    /* renamed from: b */
    public final Comparator f15032b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes2.dex */
    public static final class Type {
        public static final Type INSERTION;
        public static final Type SORTED;
        public static final Type STABLE;
        public static final Type UNORDERED;

        /* renamed from: a */
        public static final /* synthetic */ Type[] f15033a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Enum, com.google.common.graph.ElementOrder$Type] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, com.google.common.graph.ElementOrder$Type] */
        /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Enum, com.google.common.graph.ElementOrder$Type] */
        /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, com.google.common.graph.ElementOrder$Type] */
        static {
            ?? r4 = new Enum("UNORDERED", 0);
            UNORDERED = r4;
            ?? r5 = new Enum("STABLE", 1);
            STABLE = r5;
            ?? r6 = new Enum("INSERTION", 2);
            INSERTION = r6;
            ?? r7 = new Enum("SORTED", 3);
            SORTED = r7;
            f15033a = new Type[]{r4, r5, r6, r7};
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) f15033a.clone();
        }
    }

    public ElementOrder(Type type, Comparator comparator) {
        boolean z;
        boolean z2;
        this.f15031a = (Type) Preconditions.checkNotNull(type);
        this.f15032b = comparator;
        if (type == Type.SORTED) {
            z = true;
        } else {
            z = false;
        }
        if (comparator != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z == z2);
    }

    public static <S> ElementOrder<S> insertion() {
        return new ElementOrder<>(Type.INSERTION, null);
    }

    public static <S extends Comparable<? super S>> ElementOrder<S> natural() {
        return new ElementOrder<>(Type.SORTED, Ordering.natural());
    }

    public static <S> ElementOrder<S> sorted(Comparator<S> comparator) {
        return new ElementOrder<>(Type.SORTED, (Comparator) Preconditions.checkNotNull(comparator));
    }

    public static <S> ElementOrder<S> stable() {
        return new ElementOrder<>(Type.STABLE, null);
    }

    public static <S> ElementOrder<S> unordered() {
        return new ElementOrder<>(Type.UNORDERED, null);
    }

    /* renamed from: a */
    public final AbstractMap m4171a(int i) {
        int i2 = AbstractC0964c.f15050a[this.f15031a.ordinal()];
        if (i2 != 1) {
            if (i2 != 2 && i2 != 3) {
                if (i2 == 4) {
                    return Maps.newTreeMap(comparator());
                }
                throw new AssertionError();
            }
            return Maps.newLinkedHashMapWithExpectedSize(i);
        }
        return Maps.newHashMapWithExpectedSize(i);
    }

    public Comparator<T> comparator() {
        Comparator<T> comparator = this.f15032b;
        if (comparator != null) {
            return comparator;
        }
        throw new UnsupportedOperationException("This ordering does not define a comparator.");
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ElementOrder)) {
            return false;
        }
        ElementOrder elementOrder = (ElementOrder) obj;
        if (this.f15031a == elementOrder.f15031a && Objects.equal(this.f15032b, elementOrder.f15032b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.f15031a, this.f15032b);
    }

    public String toString() {
        MoreObjects.ToStringHelper add = MoreObjects.toStringHelper(this).add("type", this.f15031a);
        Comparator comparator = this.f15032b;
        if (comparator != null) {
            add.add("comparator", comparator);
        }
        return add.toString();
    }

    public Type type() {
        return this.f15031a;
    }
}
