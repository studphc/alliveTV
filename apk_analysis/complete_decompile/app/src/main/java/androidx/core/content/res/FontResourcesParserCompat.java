package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.provider.FontRequest;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.http.HttpStatusCodesKt;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p000.at0;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class FontResourcesParserCompat {
    public static final int FETCH_STRATEGY_ASYNC = 1;
    public static final int FETCH_STRATEGY_BLOCKING = 0;
    public static final int INFINITE_TIMEOUT_VALUE = -1;

    /* loaded from: classes.dex */
    public interface FamilyResourceEntry {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface FetchStrategy {
    }

    /* loaded from: classes.dex */
    public static final class FontFamilyFilesResourceEntry implements FamilyResourceEntry {

        /* renamed from: a */
        public final FontFileResourceEntry[] f3616a;

        public FontFamilyFilesResourceEntry(@NonNull FontFileResourceEntry[] fontFileResourceEntryArr) {
            this.f3616a = fontFileResourceEntryArr;
        }

        @NonNull
        public FontFileResourceEntry[] getEntries() {
            return this.f3616a;
        }
    }

    /* loaded from: classes.dex */
    public static final class FontFileResourceEntry {

        /* renamed from: a */
        public final String f3617a;

        /* renamed from: b */
        public final int f3618b;

        /* renamed from: c */
        public final boolean f3619c;

        /* renamed from: d */
        public final String f3620d;

        /* renamed from: e */
        public final int f3621e;

        /* renamed from: f */
        public final int f3622f;

        public FontFileResourceEntry(@NonNull String str, int i, boolean z, @Nullable String str2, int i2, int i3) {
            this.f3617a = str;
            this.f3618b = i;
            this.f3619c = z;
            this.f3620d = str2;
            this.f3621e = i2;
            this.f3622f = i3;
        }

        @NonNull
        public String getFileName() {
            return this.f3617a;
        }

        public int getResourceId() {
            return this.f3622f;
        }

        public int getTtcIndex() {
            return this.f3621e;
        }

        @Nullable
        public String getVariationSettings() {
            return this.f3620d;
        }

        public int getWeight() {
            return this.f3618b;
        }

        public boolean isItalic() {
            return this.f3619c;
        }
    }

    /* renamed from: a */
    public static void m819a(XmlPullParser xmlPullParser) {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next != 2) {
                if (next == 3) {
                    i--;
                }
            } else {
                i++;
            }
        }
    }

    @Nullable
    public static FamilyResourceEntry parse(@NonNull XmlPullParser xmlPullParser, @NonNull Resources resources) {
        int next;
        boolean z;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            xmlPullParser.require(2, null, "font-family");
            if (xmlPullParser.getName().equals("font-family")) {
                TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamily);
                String string = obtainAttributes.getString(R.styleable.FontFamily_fontProviderAuthority);
                String string2 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderPackage);
                String string3 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderQuery);
                int resourceId = obtainAttributes.getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
                int integer = obtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
                int integer2 = obtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, HttpStatusCodesKt.HTTP_INTERNAL_SERVER_ERROR);
                String string4 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderSystemFontFamily);
                obtainAttributes.recycle();
                if (string != null && string2 != null && string3 != null) {
                    while (xmlPullParser.next() != 3) {
                        m819a(xmlPullParser);
                    }
                    return new ProviderResourceEntry(new FontRequest(string, string2, string3, readCerts(resources, resourceId)), integer, integer2, string4);
                }
                ArrayList arrayList = new ArrayList();
                while (xmlPullParser.next() != 3) {
                    if (xmlPullParser.getEventType() == 2) {
                        if (xmlPullParser.getName().equals("font")) {
                            TypedArray obtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamilyFont);
                            int i = R.styleable.FontFamilyFont_fontWeight;
                            if (!obtainAttributes2.hasValue(i)) {
                                i = R.styleable.FontFamilyFont_android_fontWeight;
                            }
                            int i2 = obtainAttributes2.getInt(i, HttpStatusCodesKt.HTTP_BAD_REQUEST);
                            int i3 = R.styleable.FontFamilyFont_fontStyle;
                            if (!obtainAttributes2.hasValue(i3)) {
                                i3 = R.styleable.FontFamilyFont_android_fontStyle;
                            }
                            if (1 == obtainAttributes2.getInt(i3, 0)) {
                                z = true;
                            } else {
                                z = false;
                            }
                            int i4 = R.styleable.FontFamilyFont_ttcIndex;
                            if (!obtainAttributes2.hasValue(i4)) {
                                i4 = R.styleable.FontFamilyFont_android_ttcIndex;
                            }
                            int i5 = R.styleable.FontFamilyFont_fontVariationSettings;
                            if (!obtainAttributes2.hasValue(i5)) {
                                i5 = R.styleable.FontFamilyFont_android_fontVariationSettings;
                            }
                            String string5 = obtainAttributes2.getString(i5);
                            int i6 = obtainAttributes2.getInt(i4, 0);
                            int i7 = R.styleable.FontFamilyFont_font;
                            if (!obtainAttributes2.hasValue(i7)) {
                                i7 = R.styleable.FontFamilyFont_android_font;
                            }
                            int resourceId2 = obtainAttributes2.getResourceId(i7, 0);
                            String string6 = obtainAttributes2.getString(i7);
                            obtainAttributes2.recycle();
                            while (xmlPullParser.next() != 3) {
                                m819a(xmlPullParser);
                            }
                            arrayList.add(new FontFileResourceEntry(string6, i2, z, string5, i6, resourceId2));
                        } else {
                            m819a(xmlPullParser);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                return new FontFamilyFilesResourceEntry((FontFileResourceEntry[]) arrayList.toArray(new FontFileResourceEntry[0]));
            }
            m819a(xmlPullParser);
            return null;
        }
        throw new XmlPullParserException("No start tag found");
    }

    @NonNull
    public static List<List<byte[]>> readCerts(@NonNull Resources resources, @ArrayRes int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (at0.m1962a(obtainTypedArray, 0) == 1) {
                for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                    int resourceId = obtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        String[] stringArray = resources.getStringArray(resourceId);
                        ArrayList arrayList2 = new ArrayList();
                        for (String str : stringArray) {
                            arrayList2.add(Base64.decode(str, 0));
                        }
                        arrayList.add(arrayList2);
                    }
                }
            } else {
                String[] stringArray2 = resources.getStringArray(i);
                ArrayList arrayList3 = new ArrayList();
                for (String str2 : stringArray2) {
                    arrayList3.add(Base64.decode(str2, 0));
                }
                arrayList.add(arrayList3);
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static final class ProviderResourceEntry implements FamilyResourceEntry {

        /* renamed from: a */
        public final FontRequest f3623a;

        /* renamed from: b */
        public final int f3624b;

        /* renamed from: c */
        public final int f3625c;

        /* renamed from: d */
        public final String f3626d;

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public ProviderResourceEntry(@NonNull FontRequest fontRequest, int i, int i2, @Nullable String str) {
            this.f3623a = fontRequest;
            this.f3625c = i;
            this.f3624b = i2;
            this.f3626d = str;
        }

        public int getFetchStrategy() {
            return this.f3625c;
        }

        @NonNull
        public FontRequest getRequest() {
            return this.f3623a;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public String getSystemFontFamilyName() {
            return this.f3626d;
        }

        public int getTimeout() {
            return this.f3624b;
        }

        public ProviderResourceEntry(@NonNull FontRequest fontRequest, int i, int i2) {
            this(fontRequest, i, i2, null);
        }
    }
}
