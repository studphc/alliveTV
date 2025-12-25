package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import javax.annotation.CheckForNull;

@GwtCompatible
/* loaded from: classes.dex */
public final class MoreObjects {

    /* loaded from: classes.dex */
    public static final class ToStringHelper {

        /* renamed from: a */
        public final String f14484a;

        /* renamed from: b */
        public final C0834c f14485b;

        /* renamed from: c */
        public C0834c f14486c;

        /* renamed from: d */
        public boolean f14487d;

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.google.common.base.c] */
        public ToStringHelper(String str) {
            ?? obj = new Object();
            this.f14485b = obj;
            this.f14486c = obj;
            this.f14487d = false;
            this.f14484a = (String) Preconditions.checkNotNull(str);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.google.common.base.c, com.google.common.base.b] */
        /* renamed from: a */
        public final C0833b m3768a() {
            ?? obj = new Object();
            this.f14486c.f14507c = obj;
            this.f14486c = obj;
            return obj;
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, boolean z) {
            m3769b(str, String.valueOf(z));
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(boolean z) {
            m3768a().f14506b = String.valueOf(z);
            return this;
        }

        /* renamed from: b */
        public final void m3769b(String str, String str2) {
            C0833b m3768a = m3768a();
            m3768a.f14506b = str2;
            m3768a.f14505a = (String) Preconditions.checkNotNull(str);
        }

        @CanIgnoreReturnValue
        public ToStringHelper omitNullValues() {
            this.f14487d = true;
            return this;
        }

        public String toString() {
            boolean z = this.f14487d;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f14484a);
            sb.append('{');
            String str = "";
            for (C0834c c0834c = this.f14485b.f14507c; c0834c != null; c0834c = c0834c.f14507c) {
                Object obj = c0834c.f14506b;
                if ((c0834c instanceof C0833b) || obj != null || !z) {
                    sb.append(str);
                    String str2 = c0834c.f14505a;
                    if (str2 != null) {
                        sb.append(str2);
                        sb.append('=');
                    }
                    if (obj != null && obj.getClass().isArray()) {
                        String deepToString = Arrays.deepToString(new Object[]{obj});
                        sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                    } else {
                        sb.append(obj);
                    }
                    str = ", ";
                }
            }
            sb.append('}');
            return sb.toString();
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, char c) {
            m3769b(str, String.valueOf(c));
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, double d) {
            m3769b(str, String.valueOf(d));
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, float f) {
            m3769b(str, String.valueOf(f));
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(char c) {
            m3768a().f14506b = String.valueOf(c);
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, int i) {
            m3769b(str, String.valueOf(i));
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, long j) {
            m3769b(str, String.valueOf(j));
            return this;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.google.common.base.c] */
        @CanIgnoreReturnValue
        public ToStringHelper add(String str, @CheckForNull Object obj) {
            ?? obj2 = new Object();
            this.f14486c.f14507c = obj2;
            this.f14486c = obj2;
            obj2.f14506b = obj;
            obj2.f14505a = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(double d) {
            m3768a().f14506b = String.valueOf(d);
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(float f) {
            m3768a().f14506b = String.valueOf(f);
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(int i) {
            m3768a().f14506b = String.valueOf(i);
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(long j) {
            m3768a().f14506b = String.valueOf(j);
            return this;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.google.common.base.c] */
        @CanIgnoreReturnValue
        public ToStringHelper addValue(@CheckForNull Object obj) {
            ?? obj2 = new Object();
            this.f14486c.f14507c = obj2;
            this.f14486c = obj2;
            obj2.f14506b = obj;
            return this;
        }
    }

    public static <T> T firstNonNull(@CheckForNull T t, T t2) {
        if (t != null) {
            return t;
        }
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj.getClass().getSimpleName());
    }

    public static ToStringHelper toStringHelper(Class<?> cls) {
        return new ToStringHelper(cls.getSimpleName());
    }

    public static ToStringHelper toStringHelper(String str) {
        return new ToStringHelper(str);
    }
}
