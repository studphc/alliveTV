package com.google.common.base;

import java.io.Serializable;
import java.util.regex.Matcher;
import p000.AbstractC1205fr;
import p000.AbstractC1726qj;
import p000.h61;

/* renamed from: com.google.common.base.d */
/* loaded from: classes.dex */
public class C0835d implements Predicate, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final AbstractC1205fr f14508a;

    public C0835d(h61 h61Var) {
        this.f14508a = (AbstractC1205fr) Preconditions.checkNotNull(h61Var);
    }

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        return ((Matcher) Preconditions.checkNotNull(((h61) this.f14508a).f17953a.matcher((CharSequence) obj))).find();
    }

    @Override // com.google.common.base.Predicate
    public final boolean equals(Object obj) {
        if (!(obj instanceof C0835d)) {
            return false;
        }
        C0835d c0835d = (C0835d) obj;
        AbstractC1205fr abstractC1205fr = this.f14508a;
        if (!Objects.equal(((h61) abstractC1205fr).f17953a.pattern(), ((h61) c0835d.f14508a).f17953a.pattern()) || ((h61) abstractC1205fr).f17953a.flags() != ((h61) c0835d.f14508a).f17953a.flags()) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        AbstractC1205fr abstractC1205fr = this.f14508a;
        return Objects.hashCode(((h61) abstractC1205fr).f17953a.pattern(), Integer.valueOf(((h61) abstractC1205fr).f17953a.flags()));
    }

    public String toString() {
        AbstractC1205fr abstractC1205fr = this.f14508a;
        String toStringHelper = MoreObjects.toStringHelper(abstractC1205fr).add("pattern", ((h61) abstractC1205fr).f17953a.pattern()).add("pattern.flags", ((h61) abstractC1205fr).f17953a.flags()).toString();
        return AbstractC1726qj.m7059o("Predicates.contains(", toStringHelper, ")", AbstractC1726qj.m7052h(21, toStringHelper));
    }
}
