package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;
import p000.y61;
import p000.z61;

@GwtCompatible
/* loaded from: classes.dex */
public class Joiner {

    /* renamed from: a */
    public final String f14481a;

    /* loaded from: classes.dex */
    public static final class MapJoiner {

        /* renamed from: a */
        public final Joiner f14482a;

        /* renamed from: b */
        public final String f14483b;

        public MapJoiner(Joiner joiner, String str) {
            this.f14482a = joiner;
            this.f14483b = (String) Preconditions.checkNotNull(str);
        }

        @CanIgnoreReturnValue
        public <A extends Appendable> A appendTo(A a, Map<?, ?> map) {
            return (A) appendTo((MapJoiner) a, (Iterable<? extends Map.Entry<?, ?>>) map.entrySet());
        }

        public String join(Map<?, ?> map) {
            return join(map.entrySet());
        }

        public MapJoiner useForNull(String str) {
            return new MapJoiner(this.f14482a.useForNull(str), this.f14483b);
        }

        @CanIgnoreReturnValue
        public StringBuilder appendTo(StringBuilder sb, Map<?, ?> map) {
            return appendTo(sb, (Iterable<? extends Map.Entry<?, ?>>) map.entrySet());
        }

        @Beta
        public String join(Iterable<? extends Map.Entry<?, ?>> iterable) {
            return join(iterable.iterator());
        }

        @CanIgnoreReturnValue
        @Beta
        public <A extends Appendable> A appendTo(A a, Iterable<? extends Map.Entry<?, ?>> iterable) {
            return (A) appendTo((MapJoiner) a, iterable.iterator());
        }

        @Beta
        public String join(Iterator<? extends Map.Entry<?, ?>> it) {
            return appendTo(new StringBuilder(), it).toString();
        }

        @CanIgnoreReturnValue
        @Beta
        public <A extends Appendable> A appendTo(A a, Iterator<? extends Map.Entry<?, ?>> it) {
            Preconditions.checkNotNull(a);
            if (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                Object key = next.getKey();
                Joiner joiner = this.f14482a;
                a.append(joiner.mo3767a(key));
                String str = this.f14483b;
                a.append(str);
                a.append(joiner.mo3767a(next.getValue()));
                while (it.hasNext()) {
                    a.append(joiner.f14481a);
                    Map.Entry<?, ?> next2 = it.next();
                    a.append(joiner.mo3767a(next2.getKey()));
                    a.append(str);
                    a.append(joiner.mo3767a(next2.getValue()));
                }
            }
            return a;
        }

        @CanIgnoreReturnValue
        @Beta
        public StringBuilder appendTo(StringBuilder sb, Iterable<? extends Map.Entry<?, ?>> iterable) {
            return appendTo(sb, iterable.iterator());
        }

        @CanIgnoreReturnValue
        @Beta
        public StringBuilder appendTo(StringBuilder sb, Iterator<? extends Map.Entry<?, ?>> it) {
            try {
                appendTo((MapJoiner) sb, it);
                return sb;
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    public Joiner(String str) {
        this.f14481a = (String) Preconditions.checkNotNull(str);
    }

    /* renamed from: on */
    public static Joiner m3766on(String str) {
        return new Joiner(str);
    }

    /* renamed from: a */
    public CharSequence mo3767a(Object obj) {
        java.util.Objects.requireNonNull(obj);
        if (obj instanceof CharSequence) {
            return (CharSequence) obj;
        }
        return obj.toString();
    }

    @CanIgnoreReturnValue
    public <A extends Appendable> A appendTo(A a, Iterable<? extends Object> iterable) {
        return (A) appendTo((Joiner) a, iterable.iterator());
    }

    public final String join(Iterable<? extends Object> iterable) {
        return join(iterable.iterator());
    }

    public Joiner skipNulls() {
        return new C0832a(this, this);
    }

    public Joiner useForNull(String str) {
        Preconditions.checkNotNull(str);
        return new y61(this, this, str);
    }

    public MapJoiner withKeyValueSeparator(char c) {
        return withKeyValueSeparator(String.valueOf(c));
    }

    /* renamed from: on */
    public static Joiner m3765on(char c) {
        return new Joiner(String.valueOf(c));
    }

    @CanIgnoreReturnValue
    public <A extends Appendable> A appendTo(A a, Iterator<? extends Object> it) {
        Preconditions.checkNotNull(a);
        if (it.hasNext()) {
            a.append(mo3767a(it.next()));
            while (it.hasNext()) {
                a.append(this.f14481a);
                a.append(mo3767a(it.next()));
            }
        }
        return a;
    }

    public final String join(Iterator<? extends Object> it) {
        return appendTo(new StringBuilder(), it).toString();
    }

    public MapJoiner withKeyValueSeparator(String str) {
        return new MapJoiner(this, str);
    }

    public Joiner(Joiner joiner) {
        this.f14481a = joiner.f14481a;
    }

    public final String join(Object[] objArr) {
        return join(Arrays.asList(objArr));
    }

    public final String join(@CheckForNull Object obj, @CheckForNull Object obj2, Object... objArr) {
        Preconditions.checkNotNull(objArr);
        return join(new z61(obj, obj2, objArr));
    }

    @CanIgnoreReturnValue
    public final <A extends Appendable> A appendTo(A a, Object[] objArr) {
        return (A) appendTo((Joiner) a, (Iterable<? extends Object>) Arrays.asList(objArr));
    }

    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder sb, Iterable<? extends Object> iterable) {
        return appendTo(sb, iterable.iterator());
    }

    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder sb, Iterator<? extends Object> it) {
        try {
            appendTo((Joiner) sb, it);
            return sb;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder sb, Object[] objArr) {
        return appendTo(sb, (Iterable<? extends Object>) Arrays.asList(objArr));
    }

    @CanIgnoreReturnValue
    public final <A extends Appendable> A appendTo(A a, @CheckForNull Object obj, @CheckForNull Object obj2, Object... objArr) {
        Preconditions.checkNotNull(objArr);
        return (A) appendTo((Joiner) a, (Iterable<? extends Object>) new z61(obj, obj2, objArr));
    }

    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder sb, @CheckForNull Object obj, @CheckForNull Object obj2, Object... objArr) {
        Preconditions.checkNotNull(objArr);
        return appendTo(sb, (Iterable<? extends Object>) new z61(obj, obj2, objArr));
    }
}
