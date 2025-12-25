package com.google.common.collect;

import com.google.common.base.Objects;
import java.util.AbstractMap;
import java.util.Map;

/* renamed from: com.google.common.collect.s0 */
/* loaded from: classes.dex */
public class C0930s0 implements MapDifference {

    /* renamed from: a */
    public final Map f14953a;

    /* renamed from: b */
    public final Map f14954b;

    /* renamed from: c */
    public final Map f14955c;

    /* renamed from: d */
    public final Map f14956d;

    public C0930s0(AbstractMap abstractMap, AbstractMap abstractMap2, AbstractMap abstractMap3, AbstractMap abstractMap4) {
        this.f14953a = Maps.m4045a(abstractMap);
        this.f14954b = Maps.m4045a(abstractMap2);
        this.f14955c = Maps.m4045a(abstractMap3);
        this.f14956d = Maps.m4045a(abstractMap4);
    }

    @Override // com.google.common.collect.MapDifference
    public final boolean areEqual() {
        if (this.f14953a.isEmpty() && this.f14954b.isEmpty() && this.f14956d.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.MapDifference
    public Map entriesDiffering() {
        return this.f14956d;
    }

    @Override // com.google.common.collect.MapDifference
    public Map entriesInCommon() {
        return this.f14955c;
    }

    @Override // com.google.common.collect.MapDifference
    public Map entriesOnlyOnLeft() {
        return this.f14953a;
    }

    @Override // com.google.common.collect.MapDifference
    public Map entriesOnlyOnRight() {
        return this.f14954b;
    }

    @Override // com.google.common.collect.MapDifference
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapDifference)) {
            return false;
        }
        MapDifference mapDifference = (MapDifference) obj;
        if (entriesOnlyOnLeft().equals(mapDifference.entriesOnlyOnLeft()) && entriesOnlyOnRight().equals(mapDifference.entriesOnlyOnRight()) && entriesInCommon().equals(mapDifference.entriesInCommon()) && entriesDiffering().equals(mapDifference.entriesDiffering())) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.MapDifference
    public final int hashCode() {
        return Objects.hashCode(entriesOnlyOnLeft(), entriesOnlyOnRight(), entriesInCommon(), entriesDiffering());
    }

    public final String toString() {
        if (areEqual()) {
            return "equal";
        }
        StringBuilder sb = new StringBuilder("not equal");
        Map map = this.f14953a;
        if (!map.isEmpty()) {
            sb.append(": only on left=");
            sb.append(map);
        }
        Map map2 = this.f14954b;
        if (!map2.isEmpty()) {
            sb.append(": only on right=");
            sb.append(map2);
        }
        Map map3 = this.f14956d;
        if (!map3.isEmpty()) {
            sb.append(": value differences=");
            sb.append(map3);
        }
        return sb.toString();
    }
}
