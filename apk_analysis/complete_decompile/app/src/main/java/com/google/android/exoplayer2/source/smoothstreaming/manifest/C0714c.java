package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: com.google.android.exoplayer2.source.smoothstreaming.manifest.c */
/* loaded from: classes.dex */
public final class C0714c extends AbstractC0712a {

    /* renamed from: e */
    public final LinkedList f11695e;

    /* renamed from: f */
    public int f11696f;

    /* renamed from: g */
    public int f11697g;

    /* renamed from: h */
    public long f11698h;

    /* renamed from: i */
    public long f11699i;

    /* renamed from: j */
    public long f11700j;

    /* renamed from: k */
    public int f11701k;

    /* renamed from: l */
    public boolean f11702l;

    /* renamed from: m */
    public SsManifest.ProtectionElement f11703m;

    public C0714c(String str) {
        super(null, str, "SmoothStreamingMedia");
        this.f11701k = -1;
        this.f11703m = null;
        this.f11695e = new LinkedList();
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.AbstractC0712a
    /* renamed from: a */
    public final void mo2833a(Object obj) {
        boolean z;
        if (obj instanceof SsManifest.StreamElement) {
            this.f11695e.add((SsManifest.StreamElement) obj);
            return;
        }
        if (obj instanceof SsManifest.ProtectionElement) {
            if (this.f11703m == null) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkState(z);
            this.f11703m = (SsManifest.ProtectionElement) obj;
        }
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.AbstractC0712a
    /* renamed from: b */
    public final Object mo2834b() {
        LinkedList linkedList = this.f11695e;
        int size = linkedList.size();
        SsManifest.StreamElement[] streamElementArr = new SsManifest.StreamElement[size];
        linkedList.toArray(streamElementArr);
        SsManifest.ProtectionElement protectionElement = this.f11703m;
        if (protectionElement != null) {
            DrmInitData drmInitData = new DrmInitData(new DrmInitData.SchemeData(protectionElement.uuid, MimeTypes.VIDEO_MP4, protectionElement.data));
            for (int i = 0; i < size; i++) {
                SsManifest.StreamElement streamElement = streamElementArr[i];
                int i2 = streamElement.type;
                if (i2 == 2 || i2 == 1) {
                    Format[] formatArr = streamElement.formats;
                    for (int i3 = 0; i3 < formatArr.length; i3++) {
                        formatArr[i3] = formatArr[i3].buildUpon().setDrmInitData(drmInitData).build();
                    }
                }
            }
        }
        return new SsManifest(this.f11696f, this.f11697g, this.f11698h, this.f11699i, this.f11700j, this.f11701k, this.f11702l, this.f11703m, streamElementArr);
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.AbstractC0712a
    /* renamed from: j */
    public final void mo2839j(XmlPullParser xmlPullParser) {
        boolean z;
        this.f11696f = AbstractC0712a.m2832i(xmlPullParser, "MajorVersion");
        this.f11697g = AbstractC0712a.m2832i(xmlPullParser, "MinorVersion");
        this.f11698h = AbstractC0712a.m2831h(xmlPullParser, "TimeScale", 10000000L);
        String attributeValue = xmlPullParser.getAttributeValue(null, "Duration");
        if (attributeValue != null) {
            try {
                this.f11699i = Long.parseLong(attributeValue);
                this.f11700j = AbstractC0712a.m2831h(xmlPullParser, "DVRWindowLength", 0L);
                this.f11701k = AbstractC0712a.m2830g(xmlPullParser, "LookaheadCount");
                String attributeValue2 = xmlPullParser.getAttributeValue(null, "IsLive");
                if (attributeValue2 != null) {
                    z = Boolean.parseBoolean(attributeValue2);
                } else {
                    z = false;
                }
                this.f11702l = z;
                m2841l(Long.valueOf(this.f11698h), "TimeScale");
                return;
            } catch (NumberFormatException e) {
                throw ParserException.createForMalformedManifest(null, e);
            }
        }
        throw new SsManifestParser.MissingFieldException("Duration");
    }
}
