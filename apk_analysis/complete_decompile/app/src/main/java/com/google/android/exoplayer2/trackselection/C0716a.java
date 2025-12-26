package com.google.android.exoplayer2.trackselection;

import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import p000.m10;
import p000.q10;
import p000.qa2;

/* renamed from: com.google.android.exoplayer2.trackselection.a */
/* loaded from: classes.dex */
public final class C0716a extends q10 implements Comparable {

    /* renamed from: e */
    public final int f11957e;

    /* renamed from: f */
    public final boolean f11958f;

    /* renamed from: g */
    public final String f11959g;

    /* renamed from: h */
    public final DefaultTrackSelector.Parameters f11960h;

    /* renamed from: i */
    public final boolean f11961i;

    /* renamed from: j */
    public final int f11962j;

    /* renamed from: k */
    public final int f11963k;

    /* renamed from: l */
    public final int f11964l;

    /* renamed from: m */
    public final boolean f11965m;

    /* renamed from: n */
    public final int f11966n;

    /* renamed from: o */
    public final int f11967o;

    /* renamed from: p */
    public final boolean f11968p;

    /* renamed from: q */
    public final int f11969q;

    /* renamed from: r */
    public final int f11970r;

    /* renamed from: s */
    public final int f11971s;

    /* renamed from: t */
    public final int f11972t;

    /* renamed from: u */
    public final boolean f11973u;

    /* renamed from: v */
    public final boolean f11974v;

    public C0716a(int i, TrackGroup trackGroup, int i2, DefaultTrackSelector.Parameters parameters, int i3, boolean z, m10 m10Var) {
        super(trackGroup, i, i2);
        int i4;
        int i5;
        boolean z2;
        boolean z3;
        boolean z4;
        int i6;
        boolean z5;
        boolean z6;
        boolean z7;
        this.f11960h = parameters;
        this.f11959g = DefaultTrackSelector.normalizeUndeterminedLanguageToNull(this.f25408d.language);
        int i7 = 0;
        this.f11961i = DefaultTrackSelector.isSupported(i3, false);
        int i8 = 0;
        while (true) {
            i4 = Integer.MAX_VALUE;
            if (i8 < parameters.preferredAudioLanguages.size()) {
                i5 = DefaultTrackSelector.getFormatLanguageScore(this.f25408d, parameters.preferredAudioLanguages.get(i8), false);
                if (i5 > 0) {
                    break;
                } else {
                    i8++;
                }
            } else {
                i5 = 0;
                i8 = Integer.MAX_VALUE;
                break;
            }
        }
        this.f11963k = i8;
        this.f11962j = i5;
        this.f11964l = DefaultTrackSelector.m2878a(this.f25408d.roleFlags, parameters.preferredAudioRoleFlags);
        Format format = this.f25408d;
        int i9 = format.roleFlags;
        if (i9 != 0 && (i9 & 1) == 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.f11965m = z2;
        if ((format.selectionFlags & 1) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f11968p = z3;
        int i10 = format.channelCount;
        this.f11969q = i10;
        this.f11970r = format.sampleRate;
        int i11 = format.bitrate;
        this.f11971s = i11;
        if ((i11 == -1 || i11 <= parameters.maxAudioBitrate) && ((i10 == -1 || i10 <= parameters.maxAudioChannelCount) && m10Var.apply(format))) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f11958f = z4;
        String[] systemLanguageCodes = Util.getSystemLanguageCodes();
        int i12 = 0;
        while (true) {
            if (i12 < systemLanguageCodes.length) {
                i6 = DefaultTrackSelector.getFormatLanguageScore(this.f25408d, systemLanguageCodes[i12], false);
                if (i6 > 0) {
                    break;
                } else {
                    i12++;
                }
            } else {
                i6 = 0;
                i12 = Integer.MAX_VALUE;
                break;
            }
        }
        this.f11966n = i12;
        this.f11967o = i6;
        int i13 = 0;
        while (true) {
            if (i13 < parameters.preferredAudioMimeTypes.size()) {
                String str = this.f25408d.sampleMimeType;
                if (str != null && str.equals(parameters.preferredAudioMimeTypes.get(i13))) {
                    i4 = i13;
                    break;
                }
                i13++;
            } else {
                break;
            }
        }
        this.f11972t = i4;
        if (qa2.m7015e(i3) == 128) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.f11973u = z5;
        if (qa2.m7017g(i3) == 64) {
            z6 = true;
        } else {
            z6 = false;
        }
        this.f11974v = z6;
        DefaultTrackSelector.Parameters parameters2 = this.f11960h;
        if (DefaultTrackSelector.isSupported(i3, parameters2.exceedRendererCapabilitiesIfNecessary) && ((z7 = this.f11958f) || parameters2.exceedAudioConstraintsIfNecessary)) {
            i7 = (!DefaultTrackSelector.isSupported(i3, false) || !z7 || this.f25408d.bitrate == -1 || parameters2.forceHighestSupportedBitrate || parameters2.forceLowestBitrate || (!parameters2.allowMultipleAdaptiveSelections && z)) ? 1 : 2;
        }
        this.f11957e = i7;
    }

    @Override // p000.q10
    /* renamed from: a */
    public final int mo2886a() {
        return this.f11957e;
    }

    @Override // p000.q10
    /* renamed from: b */
    public final boolean mo2887b(q10 q10Var) {
        int i;
        String str;
        int i2;
        C0716a c0716a = (C0716a) q10Var;
        DefaultTrackSelector.Parameters parameters = this.f11960h;
        boolean z = parameters.allowAudioMixedChannelCountAdaptiveness;
        Format format = c0716a.f25408d;
        Format format2 = this.f25408d;
        if ((z || ((i2 = format2.channelCount) != -1 && i2 == format.channelCount)) && ((parameters.allowAudioMixedMimeTypeAdaptiveness || ((str = format2.sampleMimeType) != null && TextUtils.equals(str, format.sampleMimeType))) && (parameters.allowAudioMixedSampleRateAdaptiveness || ((i = format2.sampleRate) != -1 && i == format.sampleRate)))) {
            if (!parameters.allowAudioMixedDecoderSupportAdaptiveness) {
                if (this.f11973u != c0716a.f11973u || this.f11974v != c0716a.f11974v) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C0716a c0716a) {
        Ordering reverse;
        Ordering ordering;
        boolean z = this.f11961i;
        boolean z2 = this.f11958f;
        if (z2 && z) {
            reverse = DefaultTrackSelector.f11888j;
        } else {
            reverse = DefaultTrackSelector.f11888j.reverse();
        }
        ComparisonChain compare = ComparisonChain.start().compareFalseFirst(z, c0716a.f11961i).compare(Integer.valueOf(this.f11963k), Integer.valueOf(c0716a.f11963k), Ordering.natural().reverse()).compare(this.f11962j, c0716a.f11962j).compare(this.f11964l, c0716a.f11964l).compareFalseFirst(this.f11968p, c0716a.f11968p).compareFalseFirst(this.f11965m, c0716a.f11965m).compare(Integer.valueOf(this.f11966n), Integer.valueOf(c0716a.f11966n), Ordering.natural().reverse()).compare(this.f11967o, c0716a.f11967o).compareFalseFirst(z2, c0716a.f11958f).compare(Integer.valueOf(this.f11972t), Integer.valueOf(c0716a.f11972t), Ordering.natural().reverse());
        int i = this.f11971s;
        Integer valueOf = Integer.valueOf(i);
        int i2 = c0716a.f11971s;
        Integer valueOf2 = Integer.valueOf(i2);
        if (this.f11960h.forceLowestBitrate) {
            ordering = DefaultTrackSelector.f11888j.reverse();
        } else {
            ordering = DefaultTrackSelector.f11889k;
        }
        ComparisonChain compare2 = compare.compare(valueOf, valueOf2, ordering).compareFalseFirst(this.f11973u, c0716a.f11973u).compareFalseFirst(this.f11974v, c0716a.f11974v).compare(Integer.valueOf(this.f11969q), Integer.valueOf(c0716a.f11969q), reverse).compare(Integer.valueOf(this.f11970r), Integer.valueOf(c0716a.f11970r), reverse);
        Integer valueOf3 = Integer.valueOf(i);
        Integer valueOf4 = Integer.valueOf(i2);
        if (!Util.areEqual(this.f11959g, c0716a.f11959g)) {
            reverse = DefaultTrackSelector.f11889k;
        }
        return compare2.compare(valueOf3, valueOf4, reverse).result();
    }
}
