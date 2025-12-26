package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;
import p000.bu2;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class TintTypedArray {

    /* renamed from: a */
    public final Context f1493a;

    /* renamed from: b */
    public final TypedArray f1494b;

    /* renamed from: c */
    public TypedValue f1495c;

    public TintTypedArray(Context context, TypedArray typedArray) {
        this.f1493a = context;
        this.f1494b = typedArray;
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public boolean getBoolean(int i, boolean z) {
        return this.f1494b.getBoolean(i, z);
    }

    @RequiresApi(21)
    public int getChangingConfigurations() {
        return bu2.m2165a(this.f1494b);
    }

    public int getColor(int i, int i2) {
        return this.f1494b.getColor(i, i2);
    }

    public ColorStateList getColorStateList(int i) {
        int resourceId;
        ColorStateList colorStateList;
        TypedArray typedArray = this.f1494b;
        if (typedArray.hasValue(i) && (resourceId = typedArray.getResourceId(i, 0)) != 0 && (colorStateList = AppCompatResources.getColorStateList(this.f1493a, resourceId)) != null) {
            return colorStateList;
        }
        return typedArray.getColorStateList(i);
    }

    public float getDimension(int i, float f) {
        return this.f1494b.getDimension(i, f);
    }

    public int getDimensionPixelOffset(int i, int i2) {
        return this.f1494b.getDimensionPixelOffset(i, i2);
    }

    public int getDimensionPixelSize(int i, int i2) {
        return this.f1494b.getDimensionPixelSize(i, i2);
    }

    public Drawable getDrawable(int i) {
        int resourceId;
        TypedArray typedArray = this.f1494b;
        if (typedArray.hasValue(i) && (resourceId = typedArray.getResourceId(i, 0)) != 0) {
            return AppCompatResources.getDrawable(this.f1493a, resourceId);
        }
        return typedArray.getDrawable(i);
    }

    public Drawable getDrawableIfKnown(int i) {
        int resourceId;
        Drawable m256d;
        if (this.f1494b.hasValue(i) && (resourceId = this.f1494b.getResourceId(i, 0)) != 0) {
            AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
            Context context = this.f1493a;
            synchronized (appCompatDrawableManager) {
                m256d = appCompatDrawableManager.f1149a.m256d(context, resourceId, true);
            }
            return m256d;
        }
        return null;
    }

    public float getFloat(int i, float f) {
        return this.f1494b.getFloat(i, f);
    }

    @Nullable
    public Typeface getFont(@StyleableRes int i, int i2, @Nullable ResourcesCompat.FontCallback fontCallback) {
        int resourceId = this.f1494b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1495c == null) {
            this.f1495c = new TypedValue();
        }
        return ResourcesCompat.getFont(this.f1493a, resourceId, this.f1495c, i2, fontCallback);
    }

    public float getFraction(int i, int i2, int i3, float f) {
        return this.f1494b.getFraction(i, i2, i3, f);
    }

    public int getIndex(int i) {
        return this.f1494b.getIndex(i);
    }

    public int getIndexCount() {
        return this.f1494b.getIndexCount();
    }

    public int getInt(int i, int i2) {
        return this.f1494b.getInt(i, i2);
    }

    public int getInteger(int i, int i2) {
        return this.f1494b.getInteger(i, i2);
    }

    public int getLayoutDimension(int i, String str) {
        return this.f1494b.getLayoutDimension(i, str);
    }

    public String getNonResourceString(int i) {
        return this.f1494b.getNonResourceString(i);
    }

    public String getPositionDescription() {
        return this.f1494b.getPositionDescription();
    }

    public int getResourceId(int i, int i2) {
        return this.f1494b.getResourceId(i, i2);
    }

    public Resources getResources() {
        return this.f1494b.getResources();
    }

    public String getString(int i) {
        return this.f1494b.getString(i);
    }

    public CharSequence getText(int i) {
        return this.f1494b.getText(i);
    }

    public CharSequence[] getTextArray(int i) {
        return this.f1494b.getTextArray(i);
    }

    public int getType(int i) {
        return bu2.m2166b(this.f1494b, i);
    }

    public boolean getValue(int i, TypedValue typedValue) {
        return this.f1494b.getValue(i, typedValue);
    }

    public TypedArray getWrappedTypeArray() {
        return this.f1494b;
    }

    public boolean hasValue(int i) {
        return this.f1494b.hasValue(i);
    }

    public int length() {
        return this.f1494b.length();
    }

    public TypedValue peekValue(int i) {
        return this.f1494b.peekValue(i);
    }

    public void recycle() {
        this.f1494b.recycle();
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public int getLayoutDimension(int i, int i2) {
        return this.f1494b.getLayoutDimension(i, i2);
    }

    public static TintTypedArray obtainStyledAttributes(Context context, int i, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(i, iArr));
    }
}
