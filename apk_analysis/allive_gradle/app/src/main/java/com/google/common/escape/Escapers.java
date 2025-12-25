package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import javax.annotation.CheckForNull;
import kotlin.jvm.internal.CharCompanionObject;
import p000.aa0;

@GwtCompatible
/* loaded from: classes.dex */
public final class Escapers {

    /* renamed from: a */
    public static final aa0 f15013a = new CharEscaper();

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public final HashMap f15014a = new HashMap();

        /* renamed from: b */
        public char f15015b = 0;

        /* renamed from: c */
        public char f15016c = CharCompanionObject.MAX_VALUE;

        /* renamed from: d */
        public String f15017d = null;

        @CanIgnoreReturnValue
        public Builder addEscape(char c, String str) {
            Preconditions.checkNotNull(str);
            this.f15014a.put(Character.valueOf(c), str);
            return this;
        }

        public Escaper build() {
            return new C0961a(this, this.f15014a, this.f15015b, this.f15016c);
        }

        @CanIgnoreReturnValue
        public Builder setSafeRange(char c, char c2) {
            this.f15015b = c;
            this.f15016c = c2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setUnsafeReplacement(String str) {
            this.f15017d = str;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @CheckForNull
    public static String computeReplacement(CharEscaper charEscaper, char c) {
        char[] escape = charEscaper.escape(c);
        if (escape == null) {
            return null;
        }
        return new String(escape);
    }

    public static Escaper nullEscaper() {
        return f15013a;
    }

    @CheckForNull
    public static String computeReplacement(UnicodeEscaper unicodeEscaper, int i) {
        char[] escape = unicodeEscaper.escape(i);
        if (escape == null) {
            return null;
        }
        return new String(escape);
    }
}
