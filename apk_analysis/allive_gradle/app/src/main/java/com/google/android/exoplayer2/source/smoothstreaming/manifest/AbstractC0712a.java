package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: com.google.android.exoplayer2.source.smoothstreaming.manifest.a */
/* loaded from: classes.dex */
public abstract class AbstractC0712a {

    /* renamed from: a */
    public final String f11688a;

    /* renamed from: b */
    public final String f11689b;

    /* renamed from: c */
    public final AbstractC0712a f11690c;

    /* renamed from: d */
    public final LinkedList f11691d = new LinkedList();

    public AbstractC0712a(AbstractC0712a abstractC0712a, String str, String str2) {
        this.f11690c = abstractC0712a;
        this.f11688a = str;
        this.f11689b = str2;
    }

    /* renamed from: g */
    public static int m2830g(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue != null) {
            try {
                return Integer.parseInt(attributeValue);
            } catch (NumberFormatException e) {
                throw ParserException.createForMalformedManifest(null, e);
            }
        }
        return -1;
    }

    /* renamed from: h */
    public static long m2831h(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue != null) {
            try {
                return Long.parseLong(attributeValue);
            } catch (NumberFormatException e) {
                throw ParserException.createForMalformedManifest(null, e);
            }
        }
        return j;
    }

    /* renamed from: i */
    public static int m2832i(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue != null) {
            try {
                return Integer.parseInt(attributeValue);
            } catch (NumberFormatException e) {
                throw ParserException.createForMalformedManifest(null, e);
            }
        }
        throw new SsManifestParser.MissingFieldException(str);
    }

    /* renamed from: a */
    public void mo2833a(Object obj) {
    }

    /* renamed from: b */
    public abstract Object mo2834b();

    /* renamed from: c */
    public final Object m2835c(String str) {
        int i = 0;
        while (true) {
            LinkedList linkedList = this.f11691d;
            if (i < linkedList.size()) {
                Pair pair = (Pair) linkedList.get(i);
                if (((String) pair.first).equals(str)) {
                    return pair.second;
                }
                i++;
            } else {
                AbstractC0712a abstractC0712a = this.f11690c;
                if (abstractC0712a == null) {
                    return null;
                }
                return abstractC0712a.m2835c(str);
            }
        }
    }

    /* renamed from: d */
    public boolean mo2836d(String str) {
        return false;
    }

    /* renamed from: e */
    public final Object m2837e(XmlPullParser xmlPullParser) {
        boolean z = false;
        int i = 0;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            AbstractC0712a abstractC0712a = null;
            if (eventType == 1) {
                return null;
            }
            if (eventType != 2) {
                if (eventType != 3) {
                    if (eventType == 4 && z && i == 0) {
                        mo2840k(xmlPullParser);
                    }
                } else if (!z) {
                    continue;
                } else if (i > 0) {
                    i--;
                } else {
                    String name = xmlPullParser.getName();
                    mo2838f(xmlPullParser);
                    if (!mo2836d(name)) {
                        return mo2834b();
                    }
                }
            } else {
                String name2 = xmlPullParser.getName();
                if (this.f11689b.equals(name2)) {
                    mo2839j(xmlPullParser);
                    z = true;
                } else if (z) {
                    if (i > 0) {
                        i++;
                    } else if (mo2836d(name2)) {
                        mo2839j(xmlPullParser);
                    } else {
                        boolean equals = "QualityLevel".equals(name2);
                        String str = this.f11688a;
                        if (equals) {
                            abstractC0712a = new AbstractC0712a(this, str, "QualityLevel");
                        } else if ("Protection".equals(name2)) {
                            abstractC0712a = new AbstractC0712a(this, str, "Protection");
                        } else if ("StreamIndex".equals(name2)) {
                            abstractC0712a = new C0715d(this, str);
                        }
                        if (abstractC0712a == null) {
                            i = 1;
                        } else {
                            mo2833a(abstractC0712a.m2837e(xmlPullParser));
                        }
                    }
                }
            }
            xmlPullParser.next();
        }
    }

    /* renamed from: f */
    public void mo2838f(XmlPullParser xmlPullParser) {
    }

    /* renamed from: j */
    public abstract void mo2839j(XmlPullParser xmlPullParser);

    /* renamed from: k */
    public void mo2840k(XmlPullParser xmlPullParser) {
    }

    /* renamed from: l */
    public final void m2841l(Object obj, String str) {
        this.f11691d.add(Pair.create(str, obj));
    }
}
