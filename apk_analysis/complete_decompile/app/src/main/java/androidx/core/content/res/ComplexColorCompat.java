package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;
import p000.C1540m9;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class ComplexColorCompat {

    /* renamed from: a */
    public final Shader f3613a;

    /* renamed from: b */
    public final ColorStateList f3614b;

    /* renamed from: c */
    public int f3615c;

    public ComplexColorCompat(Shader shader, ColorStateList colorStateList, int i) {
        this.f3613a = shader;
        this.f3614b = colorStateList;
        this.f3615c = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x016a, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r3.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ComplexColorCompat m818a(Resources resources, int i, Resources.Theme theme) {
        int next;
        float f;
        float f2;
        C1540m9 c1540m9;
        Shader radialGradient;
        Shader.TileMode tileMode;
        Shader.TileMode tileMode2;
        Resources resources2 = resources;
        XmlResourceParser xml = resources.getXml(i);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            String name = xml.getName();
            name.getClass();
            if (!name.equals("gradient")) {
                if (name.equals("selector")) {
                    ColorStateList createFromXmlInner = ColorStateListInflaterCompat.createFromXmlInner(resources2, xml, asAttributeSet, theme);
                    return new ComplexColorCompat(null, createFromXmlInner, createFromXmlInner.getDefaultColor());
                }
                throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
            }
            String name2 = xml.getName();
            if (name2.equals("gradient")) {
                TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources2, theme, asAttributeSet, R.styleable.GradientColor);
                float namedFloat = TypedArrayUtils.getNamedFloat(obtainAttributes, xml, "startX", R.styleable.GradientColor_android_startX, RecyclerView.f7068F0);
                float namedFloat2 = TypedArrayUtils.getNamedFloat(obtainAttributes, xml, "startY", R.styleable.GradientColor_android_startY, RecyclerView.f7068F0);
                float namedFloat3 = TypedArrayUtils.getNamedFloat(obtainAttributes, xml, "endX", R.styleable.GradientColor_android_endX, RecyclerView.f7068F0);
                float namedFloat4 = TypedArrayUtils.getNamedFloat(obtainAttributes, xml, "endY", R.styleable.GradientColor_android_endY, RecyclerView.f7068F0);
                float namedFloat5 = TypedArrayUtils.getNamedFloat(obtainAttributes, xml, "centerX", R.styleable.GradientColor_android_centerX, RecyclerView.f7068F0);
                float namedFloat6 = TypedArrayUtils.getNamedFloat(obtainAttributes, xml, "centerY", R.styleable.GradientColor_android_centerY, RecyclerView.f7068F0);
                int namedInt = TypedArrayUtils.getNamedInt(obtainAttributes, xml, "type", R.styleable.GradientColor_android_type, 0);
                int namedColor = TypedArrayUtils.getNamedColor(obtainAttributes, xml, "startColor", R.styleable.GradientColor_android_startColor, 0);
                boolean hasAttribute = TypedArrayUtils.hasAttribute(xml, "centerColor");
                int namedColor2 = TypedArrayUtils.getNamedColor(obtainAttributes, xml, "centerColor", R.styleable.GradientColor_android_centerColor, 0);
                int namedColor3 = TypedArrayUtils.getNamedColor(obtainAttributes, xml, "endColor", R.styleable.GradientColor_android_endColor, 0);
                int namedInt2 = TypedArrayUtils.getNamedInt(obtainAttributes, xml, "tileMode", R.styleable.GradientColor_android_tileMode, 0);
                float namedFloat7 = TypedArrayUtils.getNamedFloat(obtainAttributes, xml, "gradientRadius", R.styleable.GradientColor_android_gradientRadius, RecyclerView.f7068F0);
                obtainAttributes.recycle();
                int depth = xml.getDepth() + 1;
                ArrayList arrayList = new ArrayList(20);
                ArrayList arrayList2 = new ArrayList(20);
                while (true) {
                    int next2 = xml.next();
                    f = namedFloat3;
                    if (next2 != 1) {
                        int depth2 = xml.getDepth();
                        f2 = namedFloat2;
                        if (depth2 < depth && next2 == 3) {
                            break;
                        }
                        if (next2 == 2) {
                            if (depth2 <= depth) {
                                if (xml.getName().equals("item")) {
                                    TypedArray obtainAttributes2 = TypedArrayUtils.obtainAttributes(resources2, theme, asAttributeSet, R.styleable.GradientColorItem);
                                    int i2 = R.styleable.GradientColorItem_android_color;
                                    boolean hasValue = obtainAttributes2.hasValue(i2);
                                    int i3 = R.styleable.GradientColorItem_android_offset;
                                    boolean hasValue2 = obtainAttributes2.hasValue(i3);
                                    if (!hasValue || !hasValue2) {
                                        break;
                                    }
                                    int color = obtainAttributes2.getColor(i2, 0);
                                    float f3 = obtainAttributes2.getFloat(i3, RecyclerView.f7068F0);
                                    obtainAttributes2.recycle();
                                    arrayList2.add(Integer.valueOf(color));
                                    arrayList.add(Float.valueOf(f3));
                                } else {
                                    continue;
                                }
                            }
                            resources2 = resources;
                        }
                        namedFloat3 = f;
                        namedFloat2 = f2;
                    } else {
                        f2 = namedFloat2;
                        break;
                    }
                }
                if (arrayList2.size() > 0) {
                    c1540m9 = new C1540m9(arrayList2, arrayList);
                } else {
                    c1540m9 = null;
                }
                if (c1540m9 == null) {
                    if (hasAttribute) {
                        c1540m9 = new C1540m9(namedColor, namedColor2, namedColor3);
                    } else {
                        c1540m9 = new C1540m9(namedColor, namedColor3);
                    }
                }
                if (namedInt != 1) {
                    if (namedInt != 2) {
                        if (namedInt2 != 1) {
                            if (namedInt2 != 2) {
                                tileMode2 = Shader.TileMode.CLAMP;
                            } else {
                                tileMode2 = Shader.TileMode.MIRROR;
                            }
                        } else {
                            tileMode2 = Shader.TileMode.REPEAT;
                        }
                        radialGradient = new LinearGradient(namedFloat, f2, f, namedFloat4, (int[]) c1540m9.f22854b, (float[]) c1540m9.f22855c, tileMode2);
                    } else {
                        radialGradient = new SweepGradient(namedFloat5, namedFloat6, (int[]) c1540m9.f22854b, (float[]) c1540m9.f22855c);
                    }
                } else if (namedFloat7 > RecyclerView.f7068F0) {
                    if (namedInt2 != 1) {
                        if (namedInt2 != 2) {
                            tileMode = Shader.TileMode.CLAMP;
                        } else {
                            tileMode = Shader.TileMode.MIRROR;
                        }
                    } else {
                        tileMode = Shader.TileMode.REPEAT;
                    }
                    radialGradient = new RadialGradient(namedFloat5, namedFloat6, namedFloat7, (int[]) c1540m9.f22854b, (float[]) c1540m9.f22855c, tileMode);
                } else {
                    throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
                }
                return new ComplexColorCompat(radialGradient, null, 0);
            }
            throw new XmlPullParserException(xml.getPositionDescription() + ": invalid gradient color tag " + name2);
        }
        throw new XmlPullParserException("No start tag found");
    }

    @Nullable
    public static ComplexColorCompat inflate(@NonNull Resources resources, @ColorRes int i, @Nullable Resources.Theme theme) {
        try {
            return m818a(resources, i, theme);
        } catch (Exception e) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e);
            return null;
        }
    }

    @ColorInt
    public int getColor() {
        return this.f3615c;
    }

    @Nullable
    public Shader getShader() {
        return this.f3613a;
    }

    public boolean isGradient() {
        if (this.f3613a != null) {
            return true;
        }
        return false;
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        if (this.f3613a == null && (colorStateList = this.f3614b) != null && colorStateList.isStateful()) {
            return true;
        }
        return false;
    }

    public boolean onStateChanged(int[] iArr) {
        if (isStateful()) {
            ColorStateList colorStateList = this.f3614b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f3615c) {
                this.f3615c = colorForState;
                return true;
            }
        }
        return false;
    }

    public void setColor(@ColorInt int i) {
        this.f3615c = i;
    }

    public boolean willDraw() {
        if (!isGradient() && this.f3615c == 0) {
            return false;
        }
        return true;
    }
}
