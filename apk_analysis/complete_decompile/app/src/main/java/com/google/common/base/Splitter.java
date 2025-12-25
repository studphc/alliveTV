package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p000.AbstractC0541b1;
import p000.C1368jv;
import p000.C1369jw;
import p000.ai2;
import p000.dx0;
import p000.em2;
import p000.h61;
import p000.t42;
import p000.tx0;

@GwtCompatible(emulated = true)
/* loaded from: classes.dex */
public final class Splitter {

    /* renamed from: a */
    public final CharMatcher f14488a;

    /* renamed from: b */
    public final boolean f14489b;

    /* renamed from: c */
    public final em2 f14490c;

    /* renamed from: d */
    public final int f14491d;

    @Beta
    /* loaded from: classes.dex */
    public static final class MapSplitter {

        /* renamed from: a */
        public final Splitter f14492a;

        /* renamed from: b */
        public final Splitter f14493b;

        public MapSplitter(Splitter splitter, Splitter splitter2) {
            this.f14492a = splitter;
            this.f14493b = (Splitter) Preconditions.checkNotNull(splitter2);
        }

        public Map<String, String> split(CharSequence charSequence) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : this.f14492a.split(charSequence)) {
                Splitter splitter = this.f14493b;
                AbstractC0541b1 abstractC0541b1 = (AbstractC0541b1) splitter.f14490c.mo92a(splitter, str);
                Preconditions.checkArgument(abstractC0541b1.hasNext(), "Chunk [%s] is not a valid entry", str);
                String str2 = (String) abstractC0541b1.next();
                Preconditions.checkArgument(!linkedHashMap.containsKey(str2), "Duplicate key [%s] found.", str2);
                Preconditions.checkArgument(abstractC0541b1.hasNext(), "Chunk [%s] is not a valid entry", str);
                linkedHashMap.put(str2, (String) abstractC0541b1.next());
                Preconditions.checkArgument(!abstractC0541b1.hasNext(), "Chunk [%s] is not a valid entry", str);
            }
            return Collections.unmodifiableMap(linkedHashMap);
        }
    }

    public Splitter(em2 em2Var) {
        this(em2Var, false, CharMatcher.none(), Integer.MAX_VALUE);
    }

    /* renamed from: a */
    public static Splitter m3781a(h61 h61Var) {
        Preconditions.checkArgument(!((Matcher) Preconditions.checkNotNull(h61Var.f17953a.matcher(""))).matches(), "The pattern may not match the empty string: %s", h61Var);
        return new Splitter(new ai2(4, h61Var));
    }

    public static Splitter fixedLength(int i) {
        boolean z;
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "The length may not be less than 1");
        return new Splitter(new tx0(i));
    }

    /* renamed from: on */
    public static Splitter m3782on(char c) {
        return m3783on(CharMatcher.m3759is(c));
    }

    @GwtIncompatible
    public static Splitter onPattern(String str) {
        dx0 dx0Var = t42.f26692a;
        Preconditions.checkNotNull(str);
        t42.f26692a.getClass();
        return m3781a(new h61(Pattern.compile(str)));
    }

    public Splitter limit(int i) {
        boolean z;
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "must be greater than zero: %s", i);
        return new Splitter(this.f14490c, this.f14489b, this.f14488a, i);
    }

    public Splitter omitEmptyStrings() {
        return new Splitter(this.f14490c, true, this.f14488a, this.f14491d);
    }

    public Iterable<String> split(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return new C1369jw(1, this, charSequence);
    }

    public List<String> splitToList(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        Iterator mo92a = this.f14490c.mo92a(this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (true) {
            AbstractC0541b1 abstractC0541b1 = (AbstractC0541b1) mo92a;
            if (abstractC0541b1.hasNext()) {
                arrayList.add((String) abstractC0541b1.next());
            } else {
                return Collections.unmodifiableList(arrayList);
            }
        }
    }

    public Splitter trimResults() {
        return trimResults(CharMatcher.whitespace());
    }

    @Beta
    public MapSplitter withKeyValueSeparator(String str) {
        return withKeyValueSeparator(m3784on(str));
    }

    public Splitter(em2 em2Var, boolean z, CharMatcher charMatcher, int i) {
        this.f14490c = em2Var;
        this.f14489b = z;
        this.f14488a = charMatcher;
        this.f14491d = i;
    }

    /* renamed from: on */
    public static Splitter m3783on(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(new ai2(3, charMatcher));
    }

    public Splitter trimResults(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(this.f14490c, this.f14489b, charMatcher, this.f14491d);
    }

    @Beta
    public MapSplitter withKeyValueSeparator(char c) {
        return withKeyValueSeparator(m3782on(c));
    }

    @Beta
    public MapSplitter withKeyValueSeparator(Splitter splitter) {
        return new MapSplitter(this, splitter);
    }

    /* renamed from: on */
    public static Splitter m3784on(String str) {
        Preconditions.checkArgument(str.length() != 0, "The separator may not be the empty string.");
        if (str.length() == 1) {
            return m3782on(str.charAt(0));
        }
        return new Splitter(new C1368jv(str, 4));
    }

    @GwtIncompatible
    /* renamed from: on */
    public static Splitter m3785on(Pattern pattern) {
        return m3781a(new h61(pattern));
    }
}
