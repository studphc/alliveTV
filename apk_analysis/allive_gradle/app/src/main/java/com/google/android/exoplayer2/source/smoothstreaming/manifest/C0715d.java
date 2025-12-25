package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: com.google.android.exoplayer2.source.smoothstreaming.manifest.d */
/* loaded from: classes.dex */
public final class C0715d extends AbstractC0712a {

    /* renamed from: e */
    public final String f11704e;

    /* renamed from: f */
    public final LinkedList f11705f;

    /* renamed from: g */
    public int f11706g;

    /* renamed from: h */
    public String f11707h;

    /* renamed from: i */
    public long f11708i;

    /* renamed from: j */
    public String f11709j;

    /* renamed from: k */
    public String f11710k;

    /* renamed from: l */
    public int f11711l;

    /* renamed from: m */
    public int f11712m;

    /* renamed from: n */
    public int f11713n;

    /* renamed from: o */
    public int f11714o;

    /* renamed from: p */
    public String f11715p;

    /* renamed from: q */
    public ArrayList f11716q;

    /* renamed from: r */
    public long f11717r;

    public C0715d(AbstractC0712a abstractC0712a, String str) {
        super(abstractC0712a, str, "StreamIndex");
        this.f11704e = str;
        this.f11705f = new LinkedList();
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.AbstractC0712a
    /* renamed from: a */
    public final void mo2833a(Object obj) {
        if (obj instanceof Format) {
            this.f11705f.add((Format) obj);
        }
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.AbstractC0712a
    /* renamed from: b */
    public final Object mo2834b() {
        LinkedList linkedList = this.f11705f;
        Format[] formatArr = new Format[linkedList.size()];
        linkedList.toArray(formatArr);
        return new SsManifest.StreamElement(this.f11704e, this.f11710k, this.f11706g, this.f11707h, this.f11708i, this.f11709j, this.f11711l, this.f11712m, this.f11713n, this.f11714o, this.f11715p, formatArr, this.f11716q, this.f11717r);
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.AbstractC0712a
    /* renamed from: d */
    public final boolean mo2836d(String str) {
        return "c".equals(str);
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.AbstractC0712a
    /* renamed from: j */
    public final void mo2839j(XmlPullParser xmlPullParser) {
        int i = 1;
        if ("c".equals(xmlPullParser.getName())) {
            int size = this.f11716q.size();
            long m2831h = AbstractC0712a.m2831h(xmlPullParser, "t", C0643C.TIME_UNSET);
            if (m2831h == C0643C.TIME_UNSET) {
                if (size == 0) {
                    m2831h = 0;
                } else if (this.f11717r != -1) {
                    m2831h = this.f11717r + ((Long) this.f11716q.get(size - 1)).longValue();
                } else {
                    throw ParserException.createForMalformedManifest("Unable to infer start time", null);
                }
            }
            this.f11716q.add(Long.valueOf(m2831h));
            this.f11717r = AbstractC0712a.m2831h(xmlPullParser, "d", C0643C.TIME_UNSET);
            long m2831h2 = AbstractC0712a.m2831h(xmlPullParser, "r", 1L);
            if (m2831h2 > 1 && this.f11717r == C0643C.TIME_UNSET) {
                throw ParserException.createForMalformedManifest("Repeated chunk with unspecified duration", null);
            }
            while (true) {
                long j = i;
                if (j < m2831h2) {
                    this.f11716q.add(Long.valueOf((this.f11717r * j) + m2831h));
                    i++;
                } else {
                    return;
                }
            }
        } else {
            String attributeValue = xmlPullParser.getAttributeValue(null, "Type");
            if (attributeValue != null) {
                if (!MimeTypes.BASE_TYPE_AUDIO.equalsIgnoreCase(attributeValue)) {
                    if (MimeTypes.BASE_TYPE_VIDEO.equalsIgnoreCase(attributeValue)) {
                        i = 2;
                    } else if (MimeTypes.BASE_TYPE_TEXT.equalsIgnoreCase(attributeValue)) {
                        i = 3;
                    } else {
                        throw ParserException.createForMalformedManifest("Invalid key value[" + attributeValue + "]", null);
                    }
                }
                this.f11706g = i;
                m2841l(Integer.valueOf(i), "Type");
                if (this.f11706g == 3) {
                    String attributeValue2 = xmlPullParser.getAttributeValue(null, "Subtype");
                    if (attributeValue2 != null) {
                        this.f11707h = attributeValue2;
                    } else {
                        throw new SsManifestParser.MissingFieldException("Subtype");
                    }
                } else {
                    this.f11707h = xmlPullParser.getAttributeValue(null, "Subtype");
                }
                m2841l(this.f11707h, "Subtype");
                String attributeValue3 = xmlPullParser.getAttributeValue(null, "Name");
                this.f11709j = attributeValue3;
                m2841l(attributeValue3, "Name");
                String attributeValue4 = xmlPullParser.getAttributeValue(null, "Url");
                if (attributeValue4 != null) {
                    this.f11710k = attributeValue4;
                    this.f11711l = AbstractC0712a.m2830g(xmlPullParser, "MaxWidth");
                    this.f11712m = AbstractC0712a.m2830g(xmlPullParser, "MaxHeight");
                    this.f11713n = AbstractC0712a.m2830g(xmlPullParser, "DisplayWidth");
                    this.f11714o = AbstractC0712a.m2830g(xmlPullParser, "DisplayHeight");
                    String attributeValue5 = xmlPullParser.getAttributeValue(null, "Language");
                    this.f11715p = attributeValue5;
                    m2841l(attributeValue5, "Language");
                    long m2830g = AbstractC0712a.m2830g(xmlPullParser, "TimeScale");
                    this.f11708i = m2830g;
                    if (m2830g == -1) {
                        this.f11708i = ((Long) m2835c("TimeScale")).longValue();
                    }
                    this.f11716q = new ArrayList();
                    return;
                }
                throw new SsManifestParser.MissingFieldException("Url");
            }
            throw new SsManifestParser.MissingFieldException("Type");
        }
    }
}
