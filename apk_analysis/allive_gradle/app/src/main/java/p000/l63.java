package p000;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.jpeg.MotionPhotoDescription$ContainerItem;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import com.google.common.collect.ImmutableList;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes.dex */
public abstract class l63 {

    /* renamed from: a */
    public static final String[] f22364a = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};

    /* renamed from: b */
    public static final String[] f22365b = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};

    /* renamed from: c */
    public static final String[] f22366c = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    /* JADX WARN: Code restructure failed: missing block: B:22:0x005e, code lost:
    
        if (r7 == (-1)) goto L22;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C1972x6 m5863a(String str) {
        long j;
        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
        newPullParser.setInput(new StringReader(str));
        newPullParser.next();
        if (XmlPullParserUtil.isStartTag(newPullParser, "x:xmpmeta")) {
            ImmutableList m3902of = ImmutableList.m3902of();
            long j2 = -9223372036854775807L;
            loop0: do {
                newPullParser.next();
                if (XmlPullParserUtil.isStartTag(newPullParser, "rdf:Description")) {
                    String[] strArr = f22364a;
                    int i = 0;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= 4) {
                            break loop0;
                        }
                        String attributeValue = XmlPullParserUtil.getAttributeValue(newPullParser, strArr[i2]);
                        if (attributeValue != null) {
                            if (Integer.parseInt(attributeValue) == 1) {
                                String[] strArr2 = f22365b;
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= 4) {
                                        break;
                                    }
                                    String attributeValue2 = XmlPullParserUtil.getAttributeValue(newPullParser, strArr2[i3]);
                                    if (attributeValue2 != null) {
                                        j = Long.parseLong(attributeValue2);
                                    } else {
                                        i3++;
                                    }
                                }
                                j = -9223372036854775807L;
                                String[] strArr3 = f22366c;
                                while (true) {
                                    if (i < 2) {
                                        String attributeValue3 = XmlPullParserUtil.getAttributeValue(newPullParser, strArr3[i]);
                                        if (attributeValue3 != null) {
                                            m3902of = ImmutableList.m3904of(new MotionPhotoDescription$ContainerItem(MimeTypes.IMAGE_JPEG, "Primary", 0L, 0L), new MotionPhotoDescription$ContainerItem(MimeTypes.VIDEO_MP4, "MotionPhoto", Long.parseLong(attributeValue3), 0L));
                                            break;
                                        }
                                        i++;
                                    } else {
                                        m3902of = ImmutableList.m3902of();
                                        break;
                                    }
                                }
                                j2 = j;
                            }
                        } else {
                            i2++;
                        }
                    }
                    return null;
                }
                if (XmlPullParserUtil.isStartTag(newPullParser, "Container:Directory")) {
                    m3902of = m5864b(newPullParser, "Container", "Item");
                } else if (XmlPullParserUtil.isStartTag(newPullParser, "GContainer:Directory")) {
                    m3902of = m5864b(newPullParser, "GContainer", "GContainerItem");
                }
            } while (!XmlPullParserUtil.isEndTag(newPullParser, "x:xmpmeta"));
            if (m3902of.isEmpty()) {
                return null;
            }
            return new C1972x6(j2, m3902of);
        }
        throw ParserException.createForMalformedContainer("Couldn't find xmp metadata", null);
    }

    /* renamed from: b */
    public static ImmutableList m5864b(XmlPullParser xmlPullParser, String str, String str2) {
        long j;
        long j2;
        ImmutableList.Builder builder = ImmutableList.builder();
        String concat = str.concat(":Item");
        String concat2 = str.concat(":Directory");
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, concat)) {
                String concat3 = str2.concat(":Mime");
                String concat4 = str2.concat(":Semantic");
                String concat5 = str2.concat(":Length");
                String concat6 = str2.concat(":Padding");
                String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, concat3);
                String attributeValue2 = XmlPullParserUtil.getAttributeValue(xmlPullParser, concat4);
                String attributeValue3 = XmlPullParserUtil.getAttributeValue(xmlPullParser, concat5);
                String attributeValue4 = XmlPullParserUtil.getAttributeValue(xmlPullParser, concat6);
                if (attributeValue != null && attributeValue2 != null) {
                    if (attributeValue3 != null) {
                        j = Long.parseLong(attributeValue3);
                    } else {
                        j = 0;
                    }
                    if (attributeValue4 != null) {
                        j2 = Long.parseLong(attributeValue4);
                    } else {
                        j2 = 0;
                    }
                    builder.add((ImmutableList.Builder) new MotionPhotoDescription$ContainerItem(attributeValue, attributeValue2, j, j2));
                } else {
                    return ImmutableList.m3902of();
                }
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, concat2));
        return builder.build();
    }
}
