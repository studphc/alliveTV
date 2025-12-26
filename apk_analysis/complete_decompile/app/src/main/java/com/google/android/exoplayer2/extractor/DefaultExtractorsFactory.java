package com.google.android.exoplayer2.extractor;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.amr.AmrExtractor;
import com.google.android.exoplayer2.extractor.avi.AviExtractor;
import com.google.android.exoplayer2.extractor.flac.FlacExtractor;
import com.google.android.exoplayer2.extractor.flv.FlvExtractor;
import com.google.android.exoplayer2.extractor.jpeg.JpegExtractor;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor;
import com.google.android.exoplayer2.extractor.ogg.OggExtractor;
import com.google.android.exoplayer2.extractor.p002ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.p002ts.Ac4Extractor;
import com.google.android.exoplayer2.extractor.p002ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.p002ts.PsExtractor;
import com.google.android.exoplayer2.extractor.p002ts.TsExtractor;
import com.google.android.exoplayer2.extractor.wav.WavExtractor;
import com.google.android.exoplayer2.util.FileTypes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p000.C1255h3;
import p000.C1540m9;

/* loaded from: classes.dex */
public final class DefaultExtractorsFactory implements ExtractorsFactory {

    /* renamed from: m */
    public static final int[] f10071m = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14};

    /* renamed from: n */
    public static final C1540m9 f10072n = new C1540m9(new C1255h3(14));

    /* renamed from: o */
    public static final C1540m9 f10073o = new C1540m9(new C1255h3(15));

    /* renamed from: a */
    public boolean f10074a;

    /* renamed from: b */
    public boolean f10075b;

    /* renamed from: c */
    public int f10076c;

    /* renamed from: d */
    public int f10077d;

    /* renamed from: e */
    public int f10078e;

    /* renamed from: f */
    public int f10079f;

    /* renamed from: g */
    public int f10080g;

    /* renamed from: h */
    public int f10081h;

    /* renamed from: i */
    public int f10082i;

    /* renamed from: k */
    public int f10084k;

    /* renamed from: j */
    public int f10083j = 1;

    /* renamed from: l */
    public int f10085l = TsExtractor.DEFAULT_TIMESTAMP_SEARCH_BYTES;

    /* renamed from: a */
    public final void m2531a(ArrayList arrayList, int i) {
        int i2 = 2;
        switch (i) {
            case 0:
                arrayList.add(new Ac3Extractor());
                return;
            case 1:
                arrayList.add(new Ac4Extractor());
                return;
            case 2:
                int i3 = this.f10076c | (this.f10074a ? 1 : 0);
                if (!this.f10075b) {
                    i2 = 0;
                }
                arrayList.add(new AdtsExtractor(i2 | i3));
                return;
            case 3:
                int i4 = this.f10077d | (this.f10074a ? 1 : 0);
                if (!this.f10075b) {
                    i2 = 0;
                }
                arrayList.add(new AmrExtractor(i2 | i4));
                return;
            case 4:
                Extractor m6096f = f10072n.m6096f(Integer.valueOf(this.f10078e));
                if (m6096f != null) {
                    arrayList.add(m6096f);
                    return;
                } else {
                    arrayList.add(new FlacExtractor(this.f10078e));
                    return;
                }
            case 5:
                arrayList.add(new FlvExtractor());
                return;
            case 6:
                arrayList.add(new MatroskaExtractor(this.f10079f));
                return;
            case 7:
                int i5 = this.f10082i | (this.f10074a ? 1 : 0);
                if (!this.f10075b) {
                    i2 = 0;
                }
                arrayList.add(new Mp3Extractor(i2 | i5));
                return;
            case 8:
                arrayList.add(new FragmentedMp4Extractor(this.f10081h));
                arrayList.add(new Mp4Extractor(this.f10080g));
                return;
            case 9:
                arrayList.add(new OggExtractor());
                return;
            case 10:
                arrayList.add(new PsExtractor());
                return;
            case 11:
                arrayList.add(new TsExtractor(this.f10083j, this.f10084k, this.f10085l));
                return;
            case 12:
                arrayList.add(new WavExtractor());
                return;
            case 13:
            default:
                return;
            case 14:
                arrayList.add(new JpegExtractor());
                return;
            case 15:
                Extractor m6096f2 = f10073o.m6096f(new Object[0]);
                if (m6096f2 != null) {
                    arrayList.add(m6096f2);
                    return;
                }
                return;
            case 16:
                arrayList.add(new AviExtractor());
                return;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public synchronized Extractor[] createExtractors() {
        return createExtractors(Uri.EMPTY, new HashMap());
    }

    public synchronized DefaultExtractorsFactory setAdtsExtractorFlags(int i) {
        this.f10076c = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory setAmrExtractorFlags(int i) {
        this.f10077d = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory setConstantBitrateSeekingAlwaysEnabled(boolean z) {
        this.f10075b = z;
        return this;
    }

    public synchronized DefaultExtractorsFactory setConstantBitrateSeekingEnabled(boolean z) {
        this.f10074a = z;
        return this;
    }

    public synchronized DefaultExtractorsFactory setFlacExtractorFlags(int i) {
        this.f10078e = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory setFragmentedMp4ExtractorFlags(int i) {
        this.f10081h = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory setMatroskaExtractorFlags(int i) {
        this.f10079f = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory setMp3ExtractorFlags(int i) {
        this.f10082i = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory setMp4ExtractorFlags(int i) {
        this.f10080g = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory setTsExtractorFlags(int i) {
        this.f10084k = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory setTsExtractorMode(int i) {
        this.f10083j = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory setTsExtractorTimestampSearchBytes(int i) {
        this.f10085l = i;
        return this;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public synchronized Extractor[] createExtractors(Uri uri, Map<String, List<String>> map) {
        ArrayList arrayList;
        try {
            int[] iArr = f10071m;
            arrayList = new ArrayList(16);
            int inferFileTypeFromResponseHeaders = FileTypes.inferFileTypeFromResponseHeaders(map);
            if (inferFileTypeFromResponseHeaders != -1) {
                m2531a(arrayList, inferFileTypeFromResponseHeaders);
            }
            int inferFileTypeFromUri = FileTypes.inferFileTypeFromUri(uri);
            if (inferFileTypeFromUri != -1 && inferFileTypeFromUri != inferFileTypeFromResponseHeaders) {
                m2531a(arrayList, inferFileTypeFromUri);
            }
            for (int i = 0; i < 16; i++) {
                int i2 = iArr[i];
                if (i2 != inferFileTypeFromResponseHeaders && i2 != inferFileTypeFromUri) {
                    m2531a(arrayList, i2);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return (Extractor[]) arrayList.toArray(new Extractor[arrayList.size()]);
    }
}
