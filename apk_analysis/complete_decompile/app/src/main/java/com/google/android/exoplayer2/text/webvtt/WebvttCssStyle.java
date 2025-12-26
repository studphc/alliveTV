package com.google.android.exoplayer2.text.webvtt;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.common.base.Ascii;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class WebvttCssStyle {
    public static final int FONT_SIZE_UNIT_EM = 2;
    public static final int FONT_SIZE_UNIT_PERCENT = 3;
    public static final int FONT_SIZE_UNIT_PIXEL = 1;
    public static final int STYLE_BOLD = 1;
    public static final int STYLE_BOLD_ITALIC = 3;
    public static final int STYLE_ITALIC = 2;
    public static final int STYLE_NORMAL = 0;
    public static final int UNSPECIFIED = -1;

    /* renamed from: f */
    public int f11843f;

    /* renamed from: h */
    public int f11845h;

    /* renamed from: o */
    public float f11852o;

    /* renamed from: a */
    public String f11838a = "";

    /* renamed from: b */
    public String f11839b = "";

    /* renamed from: c */
    public Set f11840c = Collections.emptySet();

    /* renamed from: d */
    public String f11841d = "";

    /* renamed from: e */
    public String f11842e = null;

    /* renamed from: g */
    public boolean f11844g = false;

    /* renamed from: i */
    public boolean f11846i = false;

    /* renamed from: j */
    public int f11847j = -1;

    /* renamed from: k */
    public int f11848k = -1;

    /* renamed from: l */
    public int f11849l = -1;

    /* renamed from: m */
    public int f11850m = -1;

    /* renamed from: n */
    public int f11851n = -1;

    /* renamed from: p */
    public int f11853p = -1;

    /* renamed from: q */
    public boolean f11854q = false;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface FontSizeUnit {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface StyleFlags {
    }

    /* renamed from: a */
    public static int m2867a(int i, String str, String str2, int i2) {
        if (!str.isEmpty() && i != -1) {
            if (!str.equals(str2)) {
                return -1;
            }
            return i + i2;
        }
        return i;
    }

    public int getBackgroundColor() {
        if (this.f11846i) {
            return this.f11845h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public boolean getCombineUpright() {
        return this.f11854q;
    }

    public int getFontColor() {
        if (this.f11844g) {
            return this.f11843f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    @Nullable
    public String getFontFamily() {
        return this.f11842e;
    }

    public float getFontSize() {
        return this.f11852o;
    }

    public int getFontSizeUnit() {
        return this.f11851n;
    }

    public int getRubyPosition() {
        return this.f11853p;
    }

    public int getSpecificityScore(@Nullable String str, @Nullable String str2, Set<String> set, @Nullable String str3) {
        if (this.f11838a.isEmpty() && this.f11839b.isEmpty() && this.f11840c.isEmpty() && this.f11841d.isEmpty()) {
            return TextUtils.isEmpty(str2) ? 1 : 0;
        }
        int m2867a = m2867a(m2867a(m2867a(0, this.f11838a, str, 1073741824), this.f11839b, str2, 2), this.f11841d, str3, 4);
        if (m2867a == -1 || !set.containsAll(this.f11840c)) {
            return 0;
        }
        return (this.f11840c.size() * 4) + m2867a;
    }

    public int getStyle() {
        int i;
        int i2 = this.f11849l;
        if (i2 == -1 && this.f11850m == -1) {
            return -1;
        }
        int i3 = 0;
        if (i2 == 1) {
            i = 1;
        } else {
            i = 0;
        }
        if (this.f11850m == 1) {
            i3 = 2;
        }
        return i | i3;
    }

    public boolean hasBackgroundColor() {
        return this.f11846i;
    }

    public boolean hasFontColor() {
        return this.f11844g;
    }

    public boolean isLinethrough() {
        if (this.f11847j == 1) {
            return true;
        }
        return false;
    }

    public boolean isUnderline() {
        if (this.f11848k == 1) {
            return true;
        }
        return false;
    }

    public WebvttCssStyle setBackgroundColor(int i) {
        this.f11845h = i;
        this.f11846i = true;
        return this;
    }

    public WebvttCssStyle setBold(boolean z) {
        this.f11849l = z ? 1 : 0;
        return this;
    }

    public WebvttCssStyle setCombineUpright(boolean z) {
        this.f11854q = z;
        return this;
    }

    public WebvttCssStyle setFontColor(int i) {
        this.f11843f = i;
        this.f11844g = true;
        return this;
    }

    public WebvttCssStyle setFontFamily(@Nullable String str) {
        String lowerCase;
        if (str == null) {
            lowerCase = null;
        } else {
            lowerCase = Ascii.toLowerCase(str);
        }
        this.f11842e = lowerCase;
        return this;
    }

    public WebvttCssStyle setFontSize(float f) {
        this.f11852o = f;
        return this;
    }

    public WebvttCssStyle setFontSizeUnit(int i) {
        this.f11851n = i;
        return this;
    }

    public WebvttCssStyle setItalic(boolean z) {
        this.f11850m = z ? 1 : 0;
        return this;
    }

    public WebvttCssStyle setLinethrough(boolean z) {
        this.f11847j = z ? 1 : 0;
        return this;
    }

    public WebvttCssStyle setRubyPosition(int i) {
        this.f11853p = i;
        return this;
    }

    public void setTargetClasses(String[] strArr) {
        this.f11840c = new HashSet(Arrays.asList(strArr));
    }

    public void setTargetId(String str) {
        this.f11838a = str;
    }

    public void setTargetTagName(String str) {
        this.f11839b = str;
    }

    public void setTargetVoice(String str) {
        this.f11841d = str;
    }

    public WebvttCssStyle setUnderline(boolean z) {
        this.f11848k = z ? 1 : 0;
        return this;
    }
}
