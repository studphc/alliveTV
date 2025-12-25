package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.resources.Compatibility;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;
import p000.rn2;

/* loaded from: classes.dex */
public class StateListDrawableCompat extends DrawableContainerCompat {

    /* renamed from: n */
    public rn2 f778n;

    /* renamed from: o */
    public boolean f779o;

    public StateListDrawableCompat() {
        this(null, null);
    }

    /* renamed from: g */
    public static int[] m204g(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i = 0;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i2);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i3 = i + 1;
                if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i] = attributeNameResource;
                i = i3;
            }
        }
        return StateSet.trimStateSet(iArr, i);
    }

    public void addState(int[] iArr, Drawable drawable) {
        if (drawable != null) {
            rn2 rn2Var = this.f778n;
            rn2Var.f26050I[rn2Var.m7288a(drawable)] = iArr;
            onStateChange(getState());
        }
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    @RequiresApi(21)
    public void applyTheme(@NonNull Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat
    /* renamed from: e */
    public void mo198e(rn2 rn2Var) {
        super.mo198e(rn2Var);
        this.f778n = rn2Var;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public rn2 mo197b() {
        return new rn2(this.f778n, this, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b8, code lost:
    
        if (r4 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ba, code lost:
    
        r4 = r10.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00bf, code lost:
    
        if (r4 != 4) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c2, code lost:
    
        if (r4 != 2) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c4, code lost:
    
        r4 = androidx.appcompat.resources.Compatibility.Api21Impl.createFromXmlInner(r9, r10, r11, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e3, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e4, code lost:
    
        r0.f26050I[r0.m7288a(r4)] = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void inflate(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
        int depth;
        Drawable drawable;
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.StateListDrawable);
        setVisible(obtainAttributes.getBoolean(R.styleable.StateListDrawable_android_visible, true), true);
        rn2 rn2Var = this.f778n;
        rn2Var.f26054d |= Compatibility.Api21Impl.getChangingConfigurations(obtainAttributes);
        rn2Var.f26059i = obtainAttributes.getBoolean(R.styleable.StateListDrawable_android_variablePadding, rn2Var.f26059i);
        rn2Var.f26062l = obtainAttributes.getBoolean(R.styleable.StateListDrawable_android_constantSize, rn2Var.f26062l);
        rn2Var.f26076z = obtainAttributes.getInt(R.styleable.StateListDrawable_android_enterFadeDuration, rn2Var.f26076z);
        rn2Var.f26042A = obtainAttributes.getInt(R.styleable.StateListDrawable_android_exitFadeDuration, rn2Var.f26042A);
        rn2Var.f26074x = obtainAttributes.getBoolean(R.styleable.StateListDrawable_android_dither, rn2Var.f26074x);
        rn2 rn2Var2 = this.f752a;
        if (resources != null) {
            rn2Var2.f26052b = resources;
            int i = resources.getDisplayMetrics().densityDpi;
            if (i == 0) {
                i = 160;
            }
            int i2 = rn2Var2.f26053c;
            rn2Var2.f26053c = i;
            if (i2 != i) {
                rn2Var2.f26063m = false;
                rn2Var2.f26060j = false;
            }
        } else {
            rn2Var2.getClass();
        }
        obtainAttributes.recycle();
        rn2 rn2Var3 = this.f778n;
        int depth2 = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray obtainAttributes2 = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.StateListDrawableItem);
                int resourceId = obtainAttributes2.getResourceId(R.styleable.StateListDrawableItem_android_drawable, -1);
                if (resourceId > 0) {
                    drawable = ResourceManagerInternal.get().getDrawable(context, resourceId);
                } else {
                    drawable = null;
                }
                obtainAttributes2.recycle();
                int[] m204g = m204g(attributeSet);
            }
        }
        onStateChange(getState());
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        if (!this.f779o && super.mutate() == this) {
            this.f778n.mo7293f();
            this.f779o = true;
        }
        return this;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public boolean onStateChange(@NonNull int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int m7292e = this.f778n.m7292e(iArr);
        if (m7292e < 0) {
            m7292e = this.f778n.m7292e(StateSet.WILD_CARD);
        }
        if (!m202d(m7292e) && !onStateChange) {
            return false;
        }
        return true;
    }

    public StateListDrawableCompat(rn2 rn2Var, Resources resources) {
        mo198e(new rn2(rn2Var, this, resources));
        onStateChange(getState());
    }
}
