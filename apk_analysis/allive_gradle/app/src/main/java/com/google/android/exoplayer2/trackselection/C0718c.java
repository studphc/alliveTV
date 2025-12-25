package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import p000.q10;
import p000.qa2;

/* renamed from: com.google.android.exoplayer2.trackselection.c */
/* loaded from: classes.dex */
public final class C0718c extends q10 {

    /* renamed from: e */
    public final boolean f11984e;

    /* renamed from: f */
    public final DefaultTrackSelector.Parameters f11985f;

    /* renamed from: g */
    public final boolean f11986g;

    /* renamed from: h */
    public final boolean f11987h;

    /* renamed from: i */
    public final int f11988i;

    /* renamed from: j */
    public final int f11989j;

    /* renamed from: k */
    public final int f11990k;

    /* renamed from: l */
    public final int f11991l;

    /* renamed from: m */
    public final boolean f11992m;

    /* renamed from: n */
    public final boolean f11993n;

    /* renamed from: o */
    public final int f11994o;

    /* renamed from: p */
    public final boolean f11995p;

    /* renamed from: q */
    public final boolean f11996q;

    /* renamed from: r */
    public final int f11997r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00c9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0718c(int i, TrackGroup trackGroup, int i2, DefaultTrackSelector.Parameters parameters, int i3, int i4, boolean z) {
        super(trackGroup, i, i2);
        int i5;
        boolean z2;
        boolean z3;
        boolean z4;
        int i6;
        boolean z5;
        int i7;
        boolean z6;
        boolean z7;
        String str;
        boolean z8;
        Format format;
        boolean z9;
        Format format2;
        int i8;
        int i9;
        float f;
        int i10;
        Format format3;
        int i11;
        int i12;
        int i13;
        int i14 = 3;
        int i15 = 0;
        this.f11985f = parameters;
        if (parameters.allowVideoNonSeamlessAdaptiveness) {
            i5 = 24;
        } else {
            i5 = 16;
        }
        if (parameters.allowVideoMixedMimeTypeAdaptiveness && (i4 & i5) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f11993n = z2;
        if (z && (((i11 = (format3 = this.f25408d).width) == -1 || i11 <= parameters.maxVideoWidth) && ((i12 = format3.height) == -1 || i12 <= parameters.maxVideoHeight))) {
            float f2 = format3.frameRate;
            if ((f2 == -1.0f || f2 <= parameters.maxVideoFrameRate) && ((i13 = format3.bitrate) == -1 || i13 <= parameters.maxVideoBitrate)) {
                z3 = true;
                this.f11984e = z3;
                if (z && (((i8 = (format2 = this.f25408d).width) == -1 || i8 >= parameters.minVideoWidth) && ((i9 = format2.height) == -1 || i9 >= parameters.minVideoHeight))) {
                    f = format2.frameRate;
                    if ((f != -1.0f || f >= parameters.minVideoFrameRate) && ((i10 = format2.bitrate) == -1 || i10 >= parameters.minVideoBitrate)) {
                        z4 = true;
                        this.f11986g = z4;
                        this.f11987h = DefaultTrackSelector.isSupported(i3, false);
                        Format format4 = this.f25408d;
                        this.f11988i = format4.bitrate;
                        this.f11989j = format4.getPixelCount();
                        this.f11991l = DefaultTrackSelector.m2878a(this.f25408d.roleFlags, parameters.preferredVideoRoleFlags);
                        i6 = this.f25408d.roleFlags;
                        if (i6 == 0 && (i6 & 1) == 0) {
                            z5 = false;
                        } else {
                            z5 = true;
                        }
                        this.f11992m = z5;
                        i7 = 0;
                        while (true) {
                            if (i7 >= parameters.preferredVideoMimeTypes.size()) {
                                String str2 = this.f25408d.sampleMimeType;
                                if (str2 != null && str2.equals(parameters.preferredVideoMimeTypes.get(i7))) {
                                    break;
                                } else {
                                    i7++;
                                }
                            } else {
                                i7 = Integer.MAX_VALUE;
                                break;
                            }
                        }
                        this.f11990k = i7;
                        if (qa2.m7015e(i3) != 128) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        this.f11995p = z6;
                        if (qa2.m7017g(i3) != 64) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        this.f11996q = z7;
                        str = this.f25408d.sampleMimeType;
                        if (str != null) {
                            switch (str.hashCode()) {
                                case -1662735862:
                                    if (str.equals(MimeTypes.VIDEO_AV1)) {
                                        z8 = false;
                                        break;
                                    }
                                    z8 = -1;
                                    break;
                                case -1662541442:
                                    if (str.equals(MimeTypes.VIDEO_H265)) {
                                        z8 = true;
                                        break;
                                    }
                                    z8 = -1;
                                    break;
                                case 1331836730:
                                    if (str.equals(MimeTypes.VIDEO_H264)) {
                                        z8 = 2;
                                        break;
                                    }
                                    z8 = -1;
                                    break;
                                case 1599127257:
                                    if (str.equals(MimeTypes.VIDEO_VP9)) {
                                        z8 = 3;
                                        break;
                                    }
                                    z8 = -1;
                                    break;
                                default:
                                    z8 = -1;
                                    break;
                            }
                            switch (z8) {
                                case false:
                                    i14 = 4;
                                    break;
                                case true:
                                    i14 = 1;
                                    break;
                                case true:
                                    i14 = 2;
                                    break;
                            }
                            this.f11997r = i14;
                            format = this.f25408d;
                            if ((format.roleFlags & 16384) == 0) {
                                DefaultTrackSelector.Parameters parameters2 = this.f11985f;
                                if (DefaultTrackSelector.isSupported(i3, parameters2.exceedRendererCapabilitiesIfNecessary) && ((z9 = this.f11984e) || parameters2.exceedVideoConstraintsIfNecessary)) {
                                    i15 = (!DefaultTrackSelector.isSupported(i3, false) || !this.f11986g || !z9 || format.bitrate == -1 || parameters2.forceHighestSupportedBitrate || parameters2.forceLowestBitrate || (i5 & i3) == 0) ? 1 : 2;
                                }
                            }
                            this.f11994o = i15;
                        }
                        i14 = 0;
                        this.f11997r = i14;
                        format = this.f25408d;
                        if ((format.roleFlags & 16384) == 0) {
                        }
                        this.f11994o = i15;
                    }
                }
                z4 = false;
                this.f11986g = z4;
                this.f11987h = DefaultTrackSelector.isSupported(i3, false);
                Format format42 = this.f25408d;
                this.f11988i = format42.bitrate;
                this.f11989j = format42.getPixelCount();
                this.f11991l = DefaultTrackSelector.m2878a(this.f25408d.roleFlags, parameters.preferredVideoRoleFlags);
                i6 = this.f25408d.roleFlags;
                if (i6 == 0) {
                }
                z5 = true;
                this.f11992m = z5;
                i7 = 0;
                while (true) {
                    if (i7 >= parameters.preferredVideoMimeTypes.size()) {
                    }
                    i7++;
                }
                this.f11990k = i7;
                if (qa2.m7015e(i3) != 128) {
                }
                this.f11995p = z6;
                if (qa2.m7017g(i3) != 64) {
                }
                this.f11996q = z7;
                str = this.f25408d.sampleMimeType;
                if (str != null) {
                }
                i14 = 0;
                this.f11997r = i14;
                format = this.f25408d;
                if ((format.roleFlags & 16384) == 0) {
                }
                this.f11994o = i15;
            }
        }
        z3 = false;
        this.f11984e = z3;
        if (z) {
            f = format2.frameRate;
            if (f != -1.0f) {
            }
            z4 = true;
            this.f11986g = z4;
            this.f11987h = DefaultTrackSelector.isSupported(i3, false);
            Format format422 = this.f25408d;
            this.f11988i = format422.bitrate;
            this.f11989j = format422.getPixelCount();
            this.f11991l = DefaultTrackSelector.m2878a(this.f25408d.roleFlags, parameters.preferredVideoRoleFlags);
            i6 = this.f25408d.roleFlags;
            if (i6 == 0) {
            }
            z5 = true;
            this.f11992m = z5;
            i7 = 0;
            while (true) {
                if (i7 >= parameters.preferredVideoMimeTypes.size()) {
                }
                i7++;
            }
            this.f11990k = i7;
            if (qa2.m7015e(i3) != 128) {
            }
            this.f11995p = z6;
            if (qa2.m7017g(i3) != 64) {
            }
            this.f11996q = z7;
            str = this.f25408d.sampleMimeType;
            if (str != null) {
            }
            i14 = 0;
            this.f11997r = i14;
            format = this.f25408d;
            if ((format.roleFlags & 16384) == 0) {
            }
            this.f11994o = i15;
        }
        z4 = false;
        this.f11986g = z4;
        this.f11987h = DefaultTrackSelector.isSupported(i3, false);
        Format format4222 = this.f25408d;
        this.f11988i = format4222.bitrate;
        this.f11989j = format4222.getPixelCount();
        this.f11991l = DefaultTrackSelector.m2878a(this.f25408d.roleFlags, parameters.preferredVideoRoleFlags);
        i6 = this.f25408d.roleFlags;
        if (i6 == 0) {
        }
        z5 = true;
        this.f11992m = z5;
        i7 = 0;
        while (true) {
            if (i7 >= parameters.preferredVideoMimeTypes.size()) {
            }
            i7++;
        }
        this.f11990k = i7;
        if (qa2.m7015e(i3) != 128) {
        }
        this.f11995p = z6;
        if (qa2.m7017g(i3) != 64) {
        }
        this.f11996q = z7;
        str = this.f25408d.sampleMimeType;
        if (str != null) {
        }
        i14 = 0;
        this.f11997r = i14;
        format = this.f25408d;
        if ((format.roleFlags & 16384) == 0) {
        }
        this.f11994o = i15;
    }

    @Override // p000.q10
    /* renamed from: a */
    public final int mo2886a() {
        return this.f11994o;
    }

    @Override // p000.q10
    /* renamed from: b */
    public final boolean mo2887b(q10 q10Var) {
        C0718c c0718c = (C0718c) q10Var;
        if (this.f11993n || Util.areEqual(this.f25408d.sampleMimeType, c0718c.f25408d.sampleMimeType)) {
            if (!this.f11985f.allowVideoMixedDecoderSupportAdaptiveness) {
                if (this.f11995p != c0718c.f11995p || this.f11996q != c0718c.f11996q) {
                }
            }
            return true;
        }
        return false;
    }
}
