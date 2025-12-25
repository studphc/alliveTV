package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.XmlRes;
import androidx.core.R;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Array;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class ColorStateListInflaterCompat {

    /* renamed from: a */
    public static final ThreadLocal f3612a = new ThreadLocal();

    @NonNull
    public static ColorStateList createFromXml(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme) {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return createFromXmlInner(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x011b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00a2  */
    /* JADX WARN: Type inference failed for: r7v17, types: [java.lang.Object[], java.lang.Object] */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ColorStateList createFromXmlInner(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
        int depth;
        TypedArray obtainStyledAttributes;
        int color;
        int i;
        float f;
        float f2;
        int attributeCount;
        int i2;
        boolean z;
        int i3;
        int i4;
        Resources resources2 = resources;
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            boolean z2 = true;
            int depth2 = xmlPullParser.getDepth() + 1;
            int[][] iArr = new int[20];
            int[] iArr2 = new int[20];
            int i5 = 0;
            int i6 = 0;
            while (true) {
                int next = xmlPullParser.next();
                if (next == z2 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                    break;
                }
                if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                    int[] iArr3 = R.styleable.ColorStateListItem;
                    if (theme == null) {
                        obtainStyledAttributes = resources2.obtainAttributes(attributeSet, iArr3);
                    } else {
                        obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr3, i5, i5);
                    }
                    int i7 = R.styleable.ColorStateListItem_android_color;
                    int resourceId = obtainStyledAttributes.getResourceId(i7, -1);
                    if (resourceId != -1) {
                        ThreadLocal threadLocal = f3612a;
                        TypedValue typedValue = (TypedValue) threadLocal.get();
                        if (typedValue == null) {
                            typedValue = new TypedValue();
                            threadLocal.set(typedValue);
                        }
                        resources2.getValue(resourceId, typedValue, z2);
                        int i8 = typedValue.type;
                        if (i8 < 28 || i8 > 31) {
                            try {
                                color = createFromXml(resources2, resources2.getXml(resourceId), theme).getDefaultColor();
                            } catch (Exception unused) {
                                color = obtainStyledAttributes.getColor(R.styleable.ColorStateListItem_android_color, -65281);
                            }
                            i = R.styleable.ColorStateListItem_android_alpha;
                            if (!obtainStyledAttributes.hasValue(i)) {
                                f = obtainStyledAttributes.getFloat(i, 1.0f);
                            } else {
                                int i9 = R.styleable.ColorStateListItem_alpha;
                                if (obtainStyledAttributes.hasValue(i9)) {
                                    f = obtainStyledAttributes.getFloat(i9, 1.0f);
                                } else {
                                    f = 1.0f;
                                }
                            }
                            if (Build.VERSION.SDK_INT >= 31) {
                                int i10 = R.styleable.ColorStateListItem_android_lStar;
                                if (obtainStyledAttributes.hasValue(i10)) {
                                    f2 = obtainStyledAttributes.getFloat(i10, -1.0f);
                                    obtainStyledAttributes.recycle();
                                    attributeCount = attributeSet.getAttributeCount();
                                    int[] iArr4 = new int[attributeCount];
                                    int i11 = i5;
                                    for (i2 = i11; i2 < attributeCount; i2++) {
                                        int attributeNameResource = attributeSet.getAttributeNameResource(i2);
                                        if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != R.attr.alpha && attributeNameResource != R.attr.lStar) {
                                            int i12 = i11 + 1;
                                            if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                                                attributeNameResource = -attributeNameResource;
                                            }
                                            iArr4[i11] = attributeNameResource;
                                            i11 = i12;
                                        }
                                    }
                                    int[] trimStateSet = StateSet.trimStateSet(iArr4, i11);
                                    if (f2 < RecyclerView.f7068F0 && f2 <= 100.0f) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (f == 1.0f || z) {
                                        int clamp = MathUtils.clamp((int) ((Color.alpha(color) * f) + 0.5f), 0, 255);
                                        if (z) {
                                            CamColor m814a = CamColor.m814a(color);
                                            color = CamColor.toColor(m814a.f3606a, m814a.f3607b, f2);
                                        }
                                        color = (16777215 & color) | (clamp << 24);
                                    }
                                    i3 = i6 + 1;
                                    int i13 = 8;
                                    if (i3 > iArr2.length) {
                                        if (i6 <= 4) {
                                            i4 = 8;
                                        } else {
                                            i4 = i6 * 2;
                                        }
                                        int[] iArr5 = new int[i4];
                                        System.arraycopy(iArr2, 0, iArr5, 0, i6);
                                        iArr2 = iArr5;
                                    }
                                    iArr2[i6] = color;
                                    if (i3 > iArr.length) {
                                        Class<?> componentType = iArr.getClass().getComponentType();
                                        if (i6 > 4) {
                                            i13 = i6 * 2;
                                        }
                                        ?? r7 = (Object[]) Array.newInstance(componentType, i13);
                                        System.arraycopy(iArr, 0, r7, 0, i6);
                                        iArr = r7;
                                    }
                                    iArr[i6] = trimStateSet;
                                    iArr = iArr;
                                    resources2 = resources;
                                    i6 = i3;
                                }
                            }
                            f2 = obtainStyledAttributes.getFloat(R.styleable.ColorStateListItem_lStar, -1.0f);
                            obtainStyledAttributes.recycle();
                            attributeCount = attributeSet.getAttributeCount();
                            int[] iArr42 = new int[attributeCount];
                            int i112 = i5;
                            while (i2 < attributeCount) {
                            }
                            int[] trimStateSet2 = StateSet.trimStateSet(iArr42, i112);
                            if (f2 < RecyclerView.f7068F0) {
                            }
                            z = false;
                            if (f == 1.0f) {
                            }
                            int clamp2 = MathUtils.clamp((int) ((Color.alpha(color) * f) + 0.5f), 0, 255);
                            if (z) {
                            }
                            color = (16777215 & color) | (clamp2 << 24);
                            i3 = i6 + 1;
                            int i132 = 8;
                            if (i3 > iArr2.length) {
                            }
                            iArr2[i6] = color;
                            if (i3 > iArr.length) {
                            }
                            iArr[i6] = trimStateSet2;
                            iArr = iArr;
                            resources2 = resources;
                            i6 = i3;
                        }
                    }
                    color = obtainStyledAttributes.getColor(i7, -65281);
                    i = R.styleable.ColorStateListItem_android_alpha;
                    if (!obtainStyledAttributes.hasValue(i)) {
                    }
                    if (Build.VERSION.SDK_INT >= 31) {
                    }
                    f2 = obtainStyledAttributes.getFloat(R.styleable.ColorStateListItem_lStar, -1.0f);
                    obtainStyledAttributes.recycle();
                    attributeCount = attributeSet.getAttributeCount();
                    int[] iArr422 = new int[attributeCount];
                    int i1122 = i5;
                    while (i2 < attributeCount) {
                    }
                    int[] trimStateSet22 = StateSet.trimStateSet(iArr422, i1122);
                    if (f2 < RecyclerView.f7068F0) {
                    }
                    z = false;
                    if (f == 1.0f) {
                    }
                    int clamp22 = MathUtils.clamp((int) ((Color.alpha(color) * f) + 0.5f), 0, 255);
                    if (z) {
                    }
                    color = (16777215 & color) | (clamp22 << 24);
                    i3 = i6 + 1;
                    int i1322 = 8;
                    if (i3 > iArr2.length) {
                    }
                    iArr2[i6] = color;
                    if (i3 > iArr.length) {
                    }
                    iArr[i6] = trimStateSet22;
                    iArr = iArr;
                    resources2 = resources;
                    i6 = i3;
                } else {
                    resources2 = resources;
                }
                z2 = true;
                i5 = 0;
            }
            int[] iArr6 = new int[i6];
            int[][] iArr7 = new int[i6];
            System.arraycopy(iArr2, 0, iArr6, 0, i6);
            System.arraycopy(iArr, 0, iArr7, 0, i6);
            return new ColorStateList(iArr7, iArr6);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    @Nullable
    public static ColorStateList inflate(@NonNull Resources resources, @XmlRes int i, @Nullable Resources.Theme theme) {
        try {
            return createFromXml(resources, resources.getXml(i), theme);
        } catch (Exception e) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e);
            return null;
        }
    }
}
