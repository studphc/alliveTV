package p000;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintInfo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.ViewUtils;
import androidx.core.util.TypedValueCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* renamed from: ea */
/* loaded from: classes.dex */
public final class C1151ea {

    /* renamed from: a */
    public final TextView f16727a;

    /* renamed from: b */
    public TintInfo f16728b;

    /* renamed from: c */
    public TintInfo f16729c;

    /* renamed from: d */
    public TintInfo f16730d;

    /* renamed from: e */
    public TintInfo f16731e;

    /* renamed from: f */
    public TintInfo f16732f;

    /* renamed from: g */
    public TintInfo f16733g;

    /* renamed from: h */
    public TintInfo f16734h;

    /* renamed from: i */
    public final C1541ma f16735i;

    /* renamed from: j */
    public int f16736j = 0;

    /* renamed from: k */
    public int f16737k = -1;

    /* renamed from: l */
    public Typeface f16738l;

    /* renamed from: m */
    public boolean f16739m;

    public C1151ea(TextView textView) {
        this.f16727a = textView;
        this.f16735i = new C1541ma(textView);
    }

    /* renamed from: c */
    public static TintInfo m4670c(Context context, AppCompatDrawableManager appCompatDrawableManager, int i) {
        ColorStateList m257e;
        synchronized (appCompatDrawableManager) {
            m257e = appCompatDrawableManager.f1149a.m257e(i, context);
        }
        if (m257e != null) {
            TintInfo tintInfo = new TintInfo();
            tintInfo.mHasTintList = true;
            tintInfo.mTintList = m257e;
            return tintInfo;
        }
        return null;
    }

    /* renamed from: a */
    public final void m4671a(Drawable drawable, TintInfo tintInfo) {
        if (drawable != null && tintInfo != null) {
            AppCompatDrawableManager.m240a(drawable, tintInfo, this.f16727a.getDrawableState());
        }
    }

    /* renamed from: b */
    public final void m4672b() {
        TintInfo tintInfo = this.f16728b;
        TextView textView = this.f16727a;
        if (tintInfo != null || this.f16729c != null || this.f16730d != null || this.f16731e != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            m4671a(compoundDrawables[0], this.f16728b);
            m4671a(compoundDrawables[1], this.f16729c);
            m4671a(compoundDrawables[2], this.f16730d);
            m4671a(compoundDrawables[3], this.f16731e);
        }
        if (this.f16732f != null || this.f16733g != null) {
            Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
            m4671a(compoundDrawablesRelative[0], this.f16732f);
            m4671a(compoundDrawablesRelative[2], this.f16733g);
        }
    }

    /* renamed from: d */
    public final ColorStateList m4673d() {
        TintInfo tintInfo = this.f16734h;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    /* renamed from: e */
    public final PorterDuff.Mode m4674e() {
        TintInfo tintInfo = this.f16734h;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:172:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x020e  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m4675f(AttributeSet attributeSet, int i) {
        boolean z;
        boolean z2;
        String str;
        String str2;
        int i2;
        C1541ma c1541ma;
        TypedArray obtainStyledAttributes;
        int i3;
        int i4;
        float f;
        int i5;
        float f2;
        int i6;
        float f3;
        int i7;
        TintTypedArray obtainStyledAttributes2;
        int resourceId;
        Drawable drawable;
        int resourceId2;
        Drawable drawable2;
        int resourceId3;
        Drawable drawable3;
        int resourceId4;
        Drawable drawable4;
        int resourceId5;
        Drawable drawable5;
        int resourceId6;
        Drawable drawable6;
        int i8;
        int i9;
        int dimensionPixelSize;
        int dimensionPixelSize2;
        int i10;
        int i11;
        float f4;
        int[] iArr;
        int resourceId7;
        int length;
        int i12;
        int i13;
        TextView textView = this.f16727a;
        Context context = textView.getContext();
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        int[] iArr2 = R.styleable.AppCompatTextHelper;
        TintTypedArray obtainStyledAttributes3 = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr2, i, 0);
        ViewCompat.saveAttributeDataForStyleable(textView, textView.getContext(), iArr2, attributeSet, obtainStyledAttributes3.getWrappedTypeArray(), i, 0);
        int resourceId8 = obtainStyledAttributes3.getResourceId(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
        int i14 = R.styleable.AppCompatTextHelper_android_drawableLeft;
        if (obtainStyledAttributes3.hasValue(i14)) {
            this.f16728b = m4670c(context, appCompatDrawableManager, obtainStyledAttributes3.getResourceId(i14, 0));
        }
        int i15 = R.styleable.AppCompatTextHelper_android_drawableTop;
        if (obtainStyledAttributes3.hasValue(i15)) {
            this.f16729c = m4670c(context, appCompatDrawableManager, obtainStyledAttributes3.getResourceId(i15, 0));
        }
        int i16 = R.styleable.AppCompatTextHelper_android_drawableRight;
        if (obtainStyledAttributes3.hasValue(i16)) {
            this.f16730d = m4670c(context, appCompatDrawableManager, obtainStyledAttributes3.getResourceId(i16, 0));
        }
        int i17 = R.styleable.AppCompatTextHelper_android_drawableBottom;
        if (obtainStyledAttributes3.hasValue(i17)) {
            this.f16731e = m4670c(context, appCompatDrawableManager, obtainStyledAttributes3.getResourceId(i17, 0));
        }
        int i18 = R.styleable.AppCompatTextHelper_android_drawableStart;
        if (obtainStyledAttributes3.hasValue(i18)) {
            this.f16732f = m4670c(context, appCompatDrawableManager, obtainStyledAttributes3.getResourceId(i18, 0));
        }
        int i19 = R.styleable.AppCompatTextHelper_android_drawableEnd;
        if (obtainStyledAttributes3.hasValue(i19)) {
            this.f16733g = m4670c(context, appCompatDrawableManager, obtainStyledAttributes3.getResourceId(i19, 0));
        }
        obtainStyledAttributes3.recycle();
        boolean z3 = textView.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (resourceId8 != -1) {
            TintTypedArray obtainStyledAttributes4 = TintTypedArray.obtainStyledAttributes(context, resourceId8, R.styleable.TextAppearance);
            if (!z3) {
                int i20 = R.styleable.TextAppearance_textAllCaps;
                if (obtainStyledAttributes4.hasValue(i20)) {
                    z = obtainStyledAttributes4.getBoolean(i20, false);
                    z2 = true;
                    m4682m(context, obtainStyledAttributes4);
                    i12 = Build.VERSION.SDK_INT;
                    i13 = R.styleable.TextAppearance_textLocale;
                    if (!obtainStyledAttributes4.hasValue(i13)) {
                        str2 = obtainStyledAttributes4.getString(i13);
                    } else {
                        str2 = null;
                    }
                    if (i12 >= 26) {
                        int i21 = R.styleable.TextAppearance_fontVariationSettings;
                        if (obtainStyledAttributes4.hasValue(i21)) {
                            str = obtainStyledAttributes4.getString(i21);
                            obtainStyledAttributes4.recycle();
                        }
                    }
                    str = null;
                    obtainStyledAttributes4.recycle();
                }
            }
            z = false;
            z2 = false;
            m4682m(context, obtainStyledAttributes4);
            i12 = Build.VERSION.SDK_INT;
            i13 = R.styleable.TextAppearance_textLocale;
            if (!obtainStyledAttributes4.hasValue(i13)) {
            }
            if (i12 >= 26) {
            }
            str = null;
            obtainStyledAttributes4.recycle();
        } else {
            z = false;
            z2 = false;
            str = null;
            str2 = null;
        }
        TintTypedArray obtainStyledAttributes5 = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.TextAppearance, i, 0);
        if (!z3) {
            int i22 = R.styleable.TextAppearance_textAllCaps;
            if (obtainStyledAttributes5.hasValue(i22)) {
                z = obtainStyledAttributes5.getBoolean(i22, false);
                z2 = true;
            }
        }
        int i23 = Build.VERSION.SDK_INT;
        int i24 = R.styleable.TextAppearance_textLocale;
        if (obtainStyledAttributes5.hasValue(i24)) {
            str2 = obtainStyledAttributes5.getString(i24);
        }
        if (i23 >= 26) {
            int i25 = R.styleable.TextAppearance_fontVariationSettings;
            if (obtainStyledAttributes5.hasValue(i25)) {
                str = obtainStyledAttributes5.getString(i25);
            }
        }
        if (i23 >= 28) {
            int i26 = R.styleable.TextAppearance_android_textSize;
            if (obtainStyledAttributes5.hasValue(i26) && obtainStyledAttributes5.getDimensionPixelSize(i26, -1) == 0) {
                textView.setTextSize(0, RecyclerView.f7068F0);
            }
        }
        m4682m(context, obtainStyledAttributes5);
        obtainStyledAttributes5.recycle();
        if (!z3 && z2) {
            textView.setAllCaps(z);
        }
        Typeface typeface = this.f16738l;
        if (typeface != null) {
            if (this.f16737k == -1) {
                textView.setTypeface(typeface, this.f16736j);
            } else {
                textView.setTypeface(typeface);
            }
        }
        if (str != null) {
            AbstractC0586ca.m2215d(textView, str);
        }
        if (str2 != null) {
            if (i23 >= 24) {
                AbstractC0550ba.m2068b(textView, AbstractC0550ba.m2067a(str2));
            } else {
                i2 = 0;
                textView.setTextLocale(AbstractC0011aa.m43a(str2.split(",")[0]));
                int[] iArr3 = R.styleable.AppCompatTextView;
                c1541ma = this.f16735i;
                Context context2 = c1541ma.f22871j;
                obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr3, i, i2);
                TextView textView2 = c1541ma.f22870i;
                ViewCompat.saveAttributeDataForStyleable(textView2, textView2.getContext(), iArr3, attributeSet, obtainStyledAttributes, i, 0);
                i3 = R.styleable.AppCompatTextView_autoSizeTextType;
                if (obtainStyledAttributes.hasValue(i3)) {
                    c1541ma.f22862a = obtainStyledAttributes.getInt(i3, 0);
                }
                i4 = R.styleable.AppCompatTextView_autoSizeStepGranularity;
                if (!obtainStyledAttributes.hasValue(i4)) {
                    f = obtainStyledAttributes.getDimension(i4, -1.0f);
                } else {
                    f = -1.0f;
                }
                i5 = R.styleable.AppCompatTextView_autoSizeMinTextSize;
                if (!obtainStyledAttributes.hasValue(i5)) {
                    f2 = obtainStyledAttributes.getDimension(i5, -1.0f);
                } else {
                    f2 = -1.0f;
                }
                i6 = R.styleable.AppCompatTextView_autoSizeMaxTextSize;
                if (!obtainStyledAttributes.hasValue(i6)) {
                    f3 = obtainStyledAttributes.getDimension(i6, -1.0f);
                } else {
                    f3 = -1.0f;
                }
                i7 = R.styleable.AppCompatTextView_autoSizePresetSizes;
                if (obtainStyledAttributes.hasValue(i7) && (resourceId7 = obtainStyledAttributes.getResourceId(i7, 0)) > 0) {
                    TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId7);
                    length = obtainTypedArray.length();
                    int[] iArr4 = new int[length];
                    if (length > 0) {
                        for (int i27 = 0; i27 < length; i27++) {
                            iArr4[i27] = obtainTypedArray.getDimensionPixelSize(i27, -1);
                        }
                        c1541ma.f22867f = C1541ma.m6113b(iArr4);
                        c1541ma.m6121i();
                    }
                    obtainTypedArray.recycle();
                }
                obtainStyledAttributes.recycle();
                if (!c1541ma.m6122j()) {
                    if (c1541ma.f22862a == 1) {
                        if (!c1541ma.f22868g) {
                            DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
                            if (f2 == -1.0f) {
                                f2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                            }
                            if (f3 == -1.0f) {
                                f3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                            }
                            if (f == -1.0f) {
                                f = 1.0f;
                            }
                            c1541ma.m6123k(f2, f3, f);
                        }
                        c1541ma.m6120h();
                    }
                } else {
                    c1541ma.f22862a = 0;
                }
                if (ViewUtils.f1593c && c1541ma.f22862a != 0) {
                    iArr = c1541ma.f22867f;
                    if (iArr.length > 0) {
                        if (AbstractC0586ca.m2212a(textView) != -1.0f) {
                            AbstractC0586ca.m2213b(textView, Math.round(c1541ma.f22865d), Math.round(c1541ma.f22866e), Math.round(c1541ma.f22864c), 0);
                        } else {
                            AbstractC0586ca.m2214c(textView, iArr, 0);
                        }
                    }
                }
                obtainStyledAttributes2 = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.AppCompatTextView);
                resourceId = obtainStyledAttributes2.getResourceId(R.styleable.AppCompatTextView_drawableLeftCompat, -1);
                if (resourceId == -1) {
                    drawable = appCompatDrawableManager.getDrawable(context, resourceId);
                } else {
                    drawable = null;
                }
                resourceId2 = obtainStyledAttributes2.getResourceId(R.styleable.AppCompatTextView_drawableTopCompat, -1);
                if (resourceId2 == -1) {
                    drawable2 = appCompatDrawableManager.getDrawable(context, resourceId2);
                } else {
                    drawable2 = null;
                }
                resourceId3 = obtainStyledAttributes2.getResourceId(R.styleable.AppCompatTextView_drawableRightCompat, -1);
                if (resourceId3 == -1) {
                    drawable3 = appCompatDrawableManager.getDrawable(context, resourceId3);
                } else {
                    drawable3 = null;
                }
                resourceId4 = obtainStyledAttributes2.getResourceId(R.styleable.AppCompatTextView_drawableBottomCompat, -1);
                if (resourceId4 == -1) {
                    drawable4 = appCompatDrawableManager.getDrawable(context, resourceId4);
                } else {
                    drawable4 = null;
                }
                resourceId5 = obtainStyledAttributes2.getResourceId(R.styleable.AppCompatTextView_drawableStartCompat, -1);
                if (resourceId5 == -1) {
                    drawable5 = appCompatDrawableManager.getDrawable(context, resourceId5);
                } else {
                    drawable5 = null;
                }
                resourceId6 = obtainStyledAttributes2.getResourceId(R.styleable.AppCompatTextView_drawableEndCompat, -1);
                if (resourceId6 == -1) {
                    drawable6 = appCompatDrawableManager.getDrawable(context, resourceId6);
                } else {
                    drawable6 = null;
                }
                if (drawable5 != null && drawable6 == null) {
                    if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
                        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
                        Drawable drawable7 = compoundDrawablesRelative[0];
                        if (drawable7 == null && compoundDrawablesRelative[2] == null) {
                            Drawable[] compoundDrawables = textView.getCompoundDrawables();
                            if (drawable == null) {
                                drawable = compoundDrawables[0];
                            }
                            if (drawable2 == null) {
                                drawable2 = compoundDrawables[1];
                            }
                            if (drawable3 == null) {
                                drawable3 = compoundDrawables[2];
                            }
                            if (drawable4 == null) {
                                drawable4 = compoundDrawables[3];
                            }
                            textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
                        } else {
                            if (drawable2 == null) {
                                drawable2 = compoundDrawablesRelative[1];
                            }
                            if (drawable4 == null) {
                                drawable4 = compoundDrawablesRelative[3];
                            }
                            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, compoundDrawablesRelative[2], drawable4);
                        }
                    }
                } else {
                    Drawable[] compoundDrawablesRelative2 = textView.getCompoundDrawablesRelative();
                    if (drawable5 == null) {
                        drawable5 = compoundDrawablesRelative2[0];
                    }
                    if (drawable2 == null) {
                        drawable2 = compoundDrawablesRelative2[1];
                    }
                    if (drawable6 == null) {
                        drawable6 = compoundDrawablesRelative2[2];
                    }
                    if (drawable4 == null) {
                        drawable4 = compoundDrawablesRelative2[3];
                    }
                    textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
                }
                i8 = R.styleable.AppCompatTextView_drawableTint;
                if (obtainStyledAttributes2.hasValue(i8)) {
                    TextViewCompat.setCompoundDrawableTintList(textView, obtainStyledAttributes2.getColorStateList(i8));
                }
                i9 = R.styleable.AppCompatTextView_drawableTintMode;
                if (obtainStyledAttributes2.hasValue(i9)) {
                    TextViewCompat.setCompoundDrawableTintMode(textView, DrawableUtils.parseTintMode(obtainStyledAttributes2.getInt(i9, -1), null));
                }
                dimensionPixelSize = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
                dimensionPixelSize2 = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
                i10 = R.styleable.AppCompatTextView_lineHeight;
                if (!obtainStyledAttributes2.hasValue(i10)) {
                    TypedValue peekValue = obtainStyledAttributes2.peekValue(i10);
                    if (peekValue != null && peekValue.type == 5) {
                        i11 = TypedValueCompat.getUnitFromComplexDimension(peekValue.data);
                        f4 = TypedValue.complexToFloat(peekValue.data);
                    } else {
                        f4 = obtainStyledAttributes2.getDimensionPixelSize(i10, -1);
                        i11 = -1;
                    }
                } else {
                    i11 = -1;
                    f4 = -1.0f;
                }
                obtainStyledAttributes2.recycle();
                if (dimensionPixelSize != -1) {
                    TextViewCompat.setFirstBaselineToTopHeight(textView, dimensionPixelSize);
                }
                if (dimensionPixelSize2 != -1) {
                    TextViewCompat.setLastBaselineToBottomHeight(textView, dimensionPixelSize2);
                }
                if (f4 == -1.0f) {
                    if (i11 == -1) {
                        TextViewCompat.setLineHeight(textView, (int) f4);
                        return;
                    } else {
                        TextViewCompat.setLineHeight(textView, i11, f4);
                        return;
                    }
                }
                return;
            }
        }
        i2 = 0;
        int[] iArr32 = R.styleable.AppCompatTextView;
        c1541ma = this.f16735i;
        Context context22 = c1541ma.f22871j;
        obtainStyledAttributes = context22.obtainStyledAttributes(attributeSet, iArr32, i, i2);
        TextView textView22 = c1541ma.f22870i;
        ViewCompat.saveAttributeDataForStyleable(textView22, textView22.getContext(), iArr32, attributeSet, obtainStyledAttributes, i, 0);
        i3 = R.styleable.AppCompatTextView_autoSizeTextType;
        if (obtainStyledAttributes.hasValue(i3)) {
        }
        i4 = R.styleable.AppCompatTextView_autoSizeStepGranularity;
        if (!obtainStyledAttributes.hasValue(i4)) {
        }
        i5 = R.styleable.AppCompatTextView_autoSizeMinTextSize;
        if (!obtainStyledAttributes.hasValue(i5)) {
        }
        i6 = R.styleable.AppCompatTextView_autoSizeMaxTextSize;
        if (!obtainStyledAttributes.hasValue(i6)) {
        }
        i7 = R.styleable.AppCompatTextView_autoSizePresetSizes;
        if (obtainStyledAttributes.hasValue(i7)) {
            TypedArray obtainTypedArray2 = obtainStyledAttributes.getResources().obtainTypedArray(resourceId7);
            length = obtainTypedArray2.length();
            int[] iArr42 = new int[length];
            if (length > 0) {
            }
            obtainTypedArray2.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!c1541ma.m6122j()) {
        }
        if (ViewUtils.f1593c) {
            iArr = c1541ma.f22867f;
            if (iArr.length > 0) {
            }
        }
        obtainStyledAttributes2 = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.AppCompatTextView);
        resourceId = obtainStyledAttributes2.getResourceId(R.styleable.AppCompatTextView_drawableLeftCompat, -1);
        if (resourceId == -1) {
        }
        resourceId2 = obtainStyledAttributes2.getResourceId(R.styleable.AppCompatTextView_drawableTopCompat, -1);
        if (resourceId2 == -1) {
        }
        resourceId3 = obtainStyledAttributes2.getResourceId(R.styleable.AppCompatTextView_drawableRightCompat, -1);
        if (resourceId3 == -1) {
        }
        resourceId4 = obtainStyledAttributes2.getResourceId(R.styleable.AppCompatTextView_drawableBottomCompat, -1);
        if (resourceId4 == -1) {
        }
        resourceId5 = obtainStyledAttributes2.getResourceId(R.styleable.AppCompatTextView_drawableStartCompat, -1);
        if (resourceId5 == -1) {
        }
        resourceId6 = obtainStyledAttributes2.getResourceId(R.styleable.AppCompatTextView_drawableEndCompat, -1);
        if (resourceId6 == -1) {
        }
        if (drawable5 != null) {
        }
        Drawable[] compoundDrawablesRelative22 = textView.getCompoundDrawablesRelative();
        if (drawable5 == null) {
        }
        if (drawable2 == null) {
        }
        if (drawable6 == null) {
        }
        if (drawable4 == null) {
        }
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
        i8 = R.styleable.AppCompatTextView_drawableTint;
        if (obtainStyledAttributes2.hasValue(i8)) {
        }
        i9 = R.styleable.AppCompatTextView_drawableTintMode;
        if (obtainStyledAttributes2.hasValue(i9)) {
        }
        dimensionPixelSize = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
        dimensionPixelSize2 = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
        i10 = R.styleable.AppCompatTextView_lineHeight;
        if (!obtainStyledAttributes2.hasValue(i10)) {
        }
        obtainStyledAttributes2.recycle();
        if (dimensionPixelSize != -1) {
        }
        if (dimensionPixelSize2 != -1) {
        }
        if (f4 == -1.0f) {
        }
    }

    /* renamed from: g */
    public final void m4676g(int i, Context context) {
        String string;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, i, R.styleable.TextAppearance);
        int i2 = R.styleable.TextAppearance_textAllCaps;
        boolean hasValue = obtainStyledAttributes.hasValue(i2);
        TextView textView = this.f16727a;
        if (hasValue) {
            textView.setAllCaps(obtainStyledAttributes.getBoolean(i2, false));
        }
        int i3 = Build.VERSION.SDK_INT;
        int i4 = R.styleable.TextAppearance_android_textSize;
        if (obtainStyledAttributes.hasValue(i4) && obtainStyledAttributes.getDimensionPixelSize(i4, -1) == 0) {
            textView.setTextSize(0, RecyclerView.f7068F0);
        }
        m4682m(context, obtainStyledAttributes);
        if (i3 >= 26) {
            int i5 = R.styleable.TextAppearance_fontVariationSettings;
            if (obtainStyledAttributes.hasValue(i5) && (string = obtainStyledAttributes.getString(i5)) != null) {
                AbstractC0586ca.m2215d(textView, string);
            }
        }
        obtainStyledAttributes.recycle();
        Typeface typeface = this.f16738l;
        if (typeface != null) {
            textView.setTypeface(typeface, this.f16736j);
        }
    }

    /* renamed from: h */
    public final void m4677h(int i, int i2, int i3, int i4) {
        C1541ma c1541ma = this.f16735i;
        if (c1541ma.m6122j()) {
            DisplayMetrics displayMetrics = c1541ma.f22871j.getResources().getDisplayMetrics();
            c1541ma.m6123k(TypedValue.applyDimension(i4, i, displayMetrics), TypedValue.applyDimension(i4, i2, displayMetrics), TypedValue.applyDimension(i4, i3, displayMetrics));
            if (c1541ma.m6120h()) {
                c1541ma.m6116a();
            }
        }
    }

    /* renamed from: i */
    public final void m4678i(int[] iArr, int i) {
        C1541ma c1541ma = this.f16735i;
        if (c1541ma.m6122j()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = c1541ma.f22871j.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr2[i2] = Math.round(TypedValue.applyDimension(i, iArr[i2], displayMetrics));
                    }
                }
                c1541ma.f22867f = C1541ma.m6113b(iArr2);
                if (!c1541ma.m6121i()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                c1541ma.f22868g = false;
            }
            if (c1541ma.m6120h()) {
                c1541ma.m6116a();
            }
        }
    }

    /* renamed from: j */
    public final void m4679j(int i) {
        C1541ma c1541ma = this.f16735i;
        if (c1541ma.m6122j()) {
            if (i != 0) {
                if (i == 1) {
                    DisplayMetrics displayMetrics = c1541ma.f22871j.getResources().getDisplayMetrics();
                    c1541ma.m6123k(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                    if (c1541ma.m6120h()) {
                        c1541ma.m6116a();
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException(ye0.m8291k(i, "Unknown auto-size text type: "));
            }
            c1541ma.f22862a = 0;
            c1541ma.f22865d = -1.0f;
            c1541ma.f22866e = -1.0f;
            c1541ma.f22864c = -1.0f;
            c1541ma.f22867f = new int[0];
            c1541ma.f22863b = false;
        }
    }

    /* renamed from: k */
    public final void m4680k(ColorStateList colorStateList) {
        boolean z;
        if (this.f16734h == null) {
            this.f16734h = new TintInfo();
        }
        TintInfo tintInfo = this.f16734h;
        tintInfo.mTintList = colorStateList;
        if (colorStateList != null) {
            z = true;
        } else {
            z = false;
        }
        tintInfo.mHasTintList = z;
        this.f16728b = tintInfo;
        this.f16729c = tintInfo;
        this.f16730d = tintInfo;
        this.f16731e = tintInfo;
        this.f16732f = tintInfo;
        this.f16733g = tintInfo;
    }

    /* renamed from: l */
    public final void m4681l(PorterDuff.Mode mode) {
        boolean z;
        if (this.f16734h == null) {
            this.f16734h = new TintInfo();
        }
        TintInfo tintInfo = this.f16734h;
        tintInfo.mTintMode = mode;
        if (mode != null) {
            z = true;
        } else {
            z = false;
        }
        tintInfo.mHasTintMode = z;
        this.f16728b = tintInfo;
        this.f16729c = tintInfo;
        this.f16730d = tintInfo;
        this.f16731e = tintInfo;
        this.f16732f = tintInfo;
        this.f16733g = tintInfo;
    }

    /* renamed from: m */
    public final void m4682m(Context context, TintTypedArray tintTypedArray) {
        String string;
        boolean z;
        boolean z2;
        this.f16736j = tintTypedArray.getInt(R.styleable.TextAppearance_android_textStyle, this.f16736j);
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            int i2 = tintTypedArray.getInt(R.styleable.TextAppearance_android_textFontWeight, -1);
            this.f16737k = i2;
            if (i2 != -1) {
                this.f16736j &= 2;
            }
        }
        int i3 = R.styleable.TextAppearance_android_fontFamily;
        boolean z3 = true;
        if (!tintTypedArray.hasValue(i3) && !tintTypedArray.hasValue(R.styleable.TextAppearance_fontFamily)) {
            int i4 = R.styleable.TextAppearance_android_typeface;
            if (tintTypedArray.hasValue(i4)) {
                this.f16739m = false;
                int i5 = tintTypedArray.getInt(i4, 1);
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 == 3) {
                            this.f16738l = Typeface.MONOSPACE;
                            return;
                        }
                        return;
                    }
                    this.f16738l = Typeface.SERIF;
                    return;
                }
                this.f16738l = Typeface.SANS_SERIF;
                return;
            }
            return;
        }
        this.f16738l = null;
        int i6 = R.styleable.TextAppearance_fontFamily;
        if (tintTypedArray.hasValue(i6)) {
            i3 = i6;
        }
        int i7 = this.f16737k;
        int i8 = this.f16736j;
        if (!context.isRestricted()) {
            try {
                Typeface font = tintTypedArray.getFont(i3, this.f16736j, new C2012y9(this, i7, i8, new WeakReference(this.f16727a)));
                if (font != null) {
                    if (i >= 28 && this.f16737k != -1) {
                        Typeface create = Typeface.create(font, 0);
                        int i9 = this.f16737k;
                        if ((this.f16736j & 2) != 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        this.f16738l = AbstractC1115da.m4557a(create, i9, z2);
                    } else {
                        this.f16738l = font;
                    }
                }
                if (this.f16738l == null) {
                    z = true;
                } else {
                    z = false;
                }
                this.f16739m = z;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f16738l == null && (string = tintTypedArray.getString(i3)) != null) {
            if (Build.VERSION.SDK_INT >= 28 && this.f16737k != -1) {
                Typeface create2 = Typeface.create(string, 0);
                int i10 = this.f16737k;
                if ((this.f16736j & 2) == 0) {
                    z3 = false;
                }
                this.f16738l = AbstractC1115da.m4557a(create2, i10, z3);
                return;
            }
            this.f16738l = Typeface.create(string, this.f16736j);
        }
    }
}
