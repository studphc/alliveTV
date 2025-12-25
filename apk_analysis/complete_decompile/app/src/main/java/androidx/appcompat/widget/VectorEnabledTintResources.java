package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.ResourcesCompat;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import p000.gc2;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class VectorEnabledTintResources extends gc2 {
    public static final int MAX_SDK_WHERE_REQUIRED = 20;

    /* renamed from: c */
    public static boolean f1584c = false;

    /* renamed from: b */
    public final WeakReference f1585b;

    public VectorEnabledTintResources(@NonNull Context context, @NonNull Resources resources) {
        super(resources);
        this.f1585b = new WeakReference(context);
    }

    public static boolean isCompatVectorFromResourcesEnabled() {
        return f1584c;
    }

    public static void setCompatVectorFromResourcesEnabled(boolean z) {
        f1584c = z;
    }

    public static boolean shouldBeUsed() {
        isCompatVectorFromResourcesEnabled();
        return false;
    }

    @Override // p000.gc2, android.content.res.Resources
    public XmlResourceParser getAnimation(int i) {
        return this.f17645a.getAnimation(i);
    }

    @Override // p000.gc2, android.content.res.Resources
    public boolean getBoolean(int i) {
        return this.f17645a.getBoolean(i);
    }

    @Override // p000.gc2, android.content.res.Resources
    public int getColor(int i) {
        return this.f17645a.getColor(i);
    }

    @Override // p000.gc2, android.content.res.Resources
    public ColorStateList getColorStateList(int i) {
        return this.f17645a.getColorStateList(i);
    }

    @Override // p000.gc2, android.content.res.Resources
    public Configuration getConfiguration() {
        return this.f17645a.getConfiguration();
    }

    @Override // p000.gc2, android.content.res.Resources
    public float getDimension(int i) {
        return this.f17645a.getDimension(i);
    }

    @Override // p000.gc2, android.content.res.Resources
    public int getDimensionPixelOffset(int i) {
        return this.f17645a.getDimensionPixelOffset(i);
    }

    @Override // p000.gc2, android.content.res.Resources
    public int getDimensionPixelSize(int i) {
        return this.f17645a.getDimensionPixelSize(i);
    }

    @Override // p000.gc2, android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        return this.f17645a.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) {
        Context context = (Context) this.f1585b.get();
        if (context != null) {
            ResourceManagerInternal resourceManagerInternal = ResourceManagerInternal.get();
            synchronized (resourceManagerInternal) {
                try {
                    Drawable m258g = resourceManagerInternal.m258g(i, context);
                    if (m258g == null) {
                        m258g = m4936a(i);
                    }
                    if (m258g == null) {
                        return null;
                    }
                    return resourceManagerInternal.m259h(context, i, false, m258g);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return m4936a(i);
    }

    @Override // p000.gc2, android.content.res.Resources
    public /* bridge */ /* synthetic */ Drawable getDrawableForDensity(int i, int i2) {
        return super.getDrawableForDensity(i, i2);
    }

    @Override // p000.gc2, android.content.res.Resources
    public float getFraction(int i, int i2, int i3) {
        return this.f17645a.getFraction(i, i2, i3);
    }

    @Override // p000.gc2, android.content.res.Resources
    public int getIdentifier(String str, String str2, String str3) {
        return this.f17645a.getIdentifier(str, str2, str3);
    }

    @Override // p000.gc2, android.content.res.Resources
    public int[] getIntArray(int i) {
        return this.f17645a.getIntArray(i);
    }

    @Override // p000.gc2, android.content.res.Resources
    public int getInteger(int i) {
        return this.f17645a.getInteger(i);
    }

    @Override // p000.gc2, android.content.res.Resources
    public XmlResourceParser getLayout(int i) {
        return this.f17645a.getLayout(i);
    }

    @Override // p000.gc2, android.content.res.Resources
    public Movie getMovie(int i) {
        return this.f17645a.getMovie(i);
    }

    @Override // p000.gc2, android.content.res.Resources
    public String getQuantityString(int i, int i2, Object[] objArr) {
        return this.f17645a.getQuantityString(i, i2, objArr);
    }

    @Override // p000.gc2, android.content.res.Resources
    public CharSequence getQuantityText(int i, int i2) {
        return this.f17645a.getQuantityText(i, i2);
    }

    @Override // p000.gc2, android.content.res.Resources
    public String getResourceEntryName(int i) {
        return this.f17645a.getResourceEntryName(i);
    }

    @Override // p000.gc2, android.content.res.Resources
    public String getResourceName(int i) {
        return this.f17645a.getResourceName(i);
    }

    @Override // p000.gc2, android.content.res.Resources
    public String getResourcePackageName(int i) {
        return this.f17645a.getResourcePackageName(i);
    }

    @Override // p000.gc2, android.content.res.Resources
    public String getResourceTypeName(int i) {
        return this.f17645a.getResourceTypeName(i);
    }

    @Override // p000.gc2, android.content.res.Resources
    public String getString(int i) {
        return this.f17645a.getString(i);
    }

    @Override // p000.gc2, android.content.res.Resources
    public String[] getStringArray(int i) {
        return this.f17645a.getStringArray(i);
    }

    @Override // p000.gc2, android.content.res.Resources
    public CharSequence getText(int i) {
        return this.f17645a.getText(i);
    }

    @Override // p000.gc2, android.content.res.Resources
    public CharSequence[] getTextArray(int i) {
        return this.f17645a.getTextArray(i);
    }

    @Override // p000.gc2, android.content.res.Resources
    public /* bridge */ /* synthetic */ void getValue(int i, TypedValue typedValue, boolean z) {
        super.getValue(i, typedValue, z);
    }

    @Override // p000.gc2, android.content.res.Resources
    public /* bridge */ /* synthetic */ void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) {
        super.getValueForDensity(i, i2, typedValue, z);
    }

    @Override // p000.gc2, android.content.res.Resources
    public XmlResourceParser getXml(int i) {
        return this.f17645a.getXml(i);
    }

    @Override // p000.gc2, android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f17645a.obtainAttributes(attributeSet, iArr);
    }

    @Override // p000.gc2, android.content.res.Resources
    public TypedArray obtainTypedArray(int i) {
        return this.f17645a.obtainTypedArray(i);
    }

    @Override // p000.gc2, android.content.res.Resources
    public InputStream openRawResource(int i) {
        return this.f17645a.openRawResource(i);
    }

    @Override // p000.gc2, android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i) {
        return this.f17645a.openRawResourceFd(i);
    }

    @Override // p000.gc2, android.content.res.Resources
    public /* bridge */ /* synthetic */ void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) {
        super.parseBundleExtra(str, attributeSet, bundle);
    }

    @Override // p000.gc2, android.content.res.Resources
    public /* bridge */ /* synthetic */ void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) {
        super.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // p000.gc2, android.content.res.Resources
    public /* bridge */ /* synthetic */ void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
    }

    @Override // p000.gc2, android.content.res.Resources
    @RequiresApi(21)
    public Drawable getDrawableForDensity(int i, int i2, Resources.Theme theme) {
        return ResourcesCompat.getDrawableForDensity(this.f17645a, i, i2, theme);
    }

    @Override // p000.gc2, android.content.res.Resources
    public String getQuantityString(int i, int i2) {
        return this.f17645a.getQuantityString(i, i2);
    }

    @Override // p000.gc2, android.content.res.Resources
    public String getString(int i, Object[] objArr) {
        return this.f17645a.getString(i, objArr);
    }

    @Override // p000.gc2, android.content.res.Resources
    public CharSequence getText(int i, CharSequence charSequence) {
        return this.f17645a.getText(i, charSequence);
    }

    @Override // p000.gc2, android.content.res.Resources
    public /* bridge */ /* synthetic */ void getValue(String str, TypedValue typedValue, boolean z) {
        super.getValue(str, typedValue, z);
    }

    @Override // p000.gc2, android.content.res.Resources
    public InputStream openRawResource(int i, TypedValue typedValue) {
        return this.f17645a.openRawResource(i, typedValue);
    }

    @Override // p000.gc2, android.content.res.Resources
    @RequiresApi(21)
    public Drawable getDrawable(int i, Resources.Theme theme) {
        return ResourcesCompat.getDrawable(this.f17645a, i, theme);
    }
}
