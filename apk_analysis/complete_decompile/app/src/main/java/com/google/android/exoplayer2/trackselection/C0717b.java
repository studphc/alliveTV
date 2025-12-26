package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import p000.q10;

/* renamed from: com.google.android.exoplayer2.trackselection.b */
/* loaded from: classes.dex */
public final class C0717b extends q10 implements Comparable {

    /* renamed from: e */
    public final int f11975e;

    /* renamed from: f */
    public final boolean f11976f;

    /* renamed from: g */
    public final boolean f11977g;

    /* renamed from: h */
    public final boolean f11978h;

    /* renamed from: i */
    public final int f11979i;

    /* renamed from: j */
    public final int f11980j;

    /* renamed from: k */
    public final int f11981k;

    /* renamed from: l */
    public final int f11982l;

    /* renamed from: m */
    public final boolean f11983m;

    public C0717b(int i, TrackGroup trackGroup, int i2, DefaultTrackSelector.Parameters parameters, int i3, String str) {
        super(trackGroup, i, i2);
        boolean z;
        boolean z2;
        ImmutableList<String> immutableList;
        int i4;
        boolean z3;
        boolean z4;
        boolean z5;
        int i5 = 0;
        this.f11976f = DefaultTrackSelector.isSupported(i3, false);
        int i6 = this.f25408d.selectionFlags & (~parameters.ignoredTextSelectionFlags);
        if ((i6 & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f11977g = z;
        if ((i6 & 2) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f11978h = z2;
        if (parameters.preferredTextLanguages.isEmpty()) {
            immutableList = ImmutableList.m3903of("");
        } else {
            immutableList = parameters.preferredTextLanguages;
        }
        int i7 = 0;
        while (true) {
            if (i7 < immutableList.size()) {
                i4 = DefaultTrackSelector.getFormatLanguageScore(this.f25408d, immutableList.get(i7), parameters.selectUndeterminedTextLanguage);
                if (i4 > 0) {
                    break;
                } else {
                    i7++;
                }
            } else {
                i7 = Integer.MAX_VALUE;
                i4 = 0;
                break;
            }
        }
        this.f11979i = i7;
        this.f11980j = i4;
        int m2878a = DefaultTrackSelector.m2878a(this.f25408d.roleFlags, parameters.preferredTextRoleFlags);
        this.f11981k = m2878a;
        if ((this.f25408d.roleFlags & 1088) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f11983m = z3;
        if (DefaultTrackSelector.normalizeUndeterminedLanguageToNull(str) == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        int formatLanguageScore = DefaultTrackSelector.getFormatLanguageScore(this.f25408d, str, z4);
        this.f11982l = formatLanguageScore;
        if (i4 <= 0 && ((!parameters.preferredTextLanguages.isEmpty() || m2878a <= 0) && !this.f11977g && (!this.f11978h || formatLanguageScore <= 0))) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (DefaultTrackSelector.isSupported(i3, parameters.exceedRendererCapabilitiesIfNecessary) && z5) {
            i5 = 1;
        }
        this.f11975e = i5;
    }

    @Override // p000.q10
    /* renamed from: a */
    public final int mo2886a() {
        return this.f11975e;
    }

    @Override // p000.q10
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ boolean mo2887b(q10 q10Var) {
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C0717b c0717b) {
        Ordering reverse;
        ComparisonChain compare = ComparisonChain.start().compareFalseFirst(this.f11976f, c0717b.f11976f).compare(Integer.valueOf(this.f11979i), Integer.valueOf(c0717b.f11979i), Ordering.natural().reverse());
        int i = this.f11980j;
        ComparisonChain compare2 = compare.compare(i, c0717b.f11980j);
        int i2 = this.f11981k;
        ComparisonChain compareFalseFirst = compare2.compare(i2, c0717b.f11981k).compareFalseFirst(this.f11977g, c0717b.f11977g);
        Boolean valueOf = Boolean.valueOf(this.f11978h);
        Boolean valueOf2 = Boolean.valueOf(c0717b.f11978h);
        if (i == 0) {
            reverse = Ordering.natural();
        } else {
            reverse = Ordering.natural().reverse();
        }
        ComparisonChain compare3 = compareFalseFirst.compare(valueOf, valueOf2, reverse).compare(this.f11982l, c0717b.f11982l);
        if (i2 == 0) {
            compare3 = compare3.compareTrueFirst(this.f11983m, c0717b.f11983m);
        }
        return compare3.result();
    }
}
