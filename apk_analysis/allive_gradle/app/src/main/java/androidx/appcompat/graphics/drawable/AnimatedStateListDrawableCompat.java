package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.resources.Compatibility;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p000.C0009a8;
import p000.C2010y7;
import p000.C2047z7;
import p000.rn2;
import p000.yy2;

/* loaded from: classes.dex */
public class AnimatedStateListDrawableCompat extends StateListDrawableCompat implements TintAwareDrawable {

    /* renamed from: p */
    public C2047z7 f746p;

    /* renamed from: q */
    public yy2 f747q;

    /* renamed from: r */
    public int f748r;

    /* renamed from: s */
    public int f749s;

    /* renamed from: t */
    public boolean f750t;

    public AnimatedStateListDrawableCompat() {
        this(null, null);
    }

    @Nullable
    public static AnimatedStateListDrawableCompat create(@NonNull Context context, @DrawableRes int i, @Nullable Resources.Theme theme) {
        int next;
        try {
            Resources resources = context.getResources();
            XmlResourceParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return createFromXmlInner(context, resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e) {
            Log.e("AnimatedStateListDrawableCompat", "parser error", e);
            return null;
        } catch (XmlPullParserException e2) {
            Log.e("AnimatedStateListDrawableCompat", "parser error", e2);
            return null;
        }
    }

    @NonNull
    public static AnimatedStateListDrawableCompat createFromXmlInner(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            AnimatedStateListDrawableCompat animatedStateListDrawableCompat = new AnimatedStateListDrawableCompat();
            animatedStateListDrawableCompat.inflate(context, resources, xmlPullParser, attributeSet, theme);
            return animatedStateListDrawableCompat;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    public void addState(@NonNull int[] iArr, @NonNull Drawable drawable, int i) {
        ObjectsCompat.requireNonNull(drawable);
        C2047z7 c2047z7 = this.f746p;
        int m7288a = c2047z7.m7288a(drawable);
        c2047z7.f26050I[m7288a] = iArr;
        c2047z7.f29263K.put(m7288a, Integer.valueOf(i));
        onStateChange(getState());
    }

    public <T extends Drawable & Animatable> void addTransition(int i, int i2, @NonNull T t, boolean z) {
        ObjectsCompat.requireNonNull(t);
        this.f746p.m8393g(i, i2, t, z);
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat
    /* renamed from: b */
    public final rn2 mo197b() {
        return new C2047z7(this.f746p, this, null);
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat
    /* renamed from: e */
    public final void mo198e(rn2 rn2Var) {
        super.mo198e(rn2Var);
        if (rn2Var instanceof C2047z7) {
            this.f746p = (C2047z7) rn2Var;
        }
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat
    /* renamed from: f */
    public final rn2 mo197b() {
        return new C2047z7(this.f746p, this, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x01e7, code lost:
    
        onStateChange(getState());
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x01ee, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x016c, code lost:
    
        if (r11 == null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x016e, code lost:
    
        r11 = r19.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0172, code lost:
    
        if (r11 != 4) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0175, code lost:
    
        if (r11 != 2) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0181, code lost:
    
        if (r19.getName().equals("animated-vector") == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0183, code lost:
    
        r11 = androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat.createFromXmlInner(r17, r18, r19, r20, r21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0188, code lost:
    
        r11 = androidx.appcompat.resources.Compatibility.Api21Impl.createFromXmlInner(r18, r19, r20, r21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01a5, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r19.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01a6, code lost:
    
        if (r11 == null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01a8, code lost:
    
        if (r13 == (-1)) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01aa, code lost:
    
        if (r14 == (-1)) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x01ac, code lost:
    
        r16.f746p.m8393g(r13, r14, r11, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01cd, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r19.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01e6, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r19.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00c9, code lost:
    
        if (r11 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00cb, code lost:
    
        r11 = r19.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00cf, code lost:
    
        if (r11 != 4) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00d2, code lost:
    
        if (r11 != 2) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00de, code lost:
    
        if (r19.getName().equals("vector") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00e0, code lost:
    
        r11 = androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.createFromXmlInner(r18, r19, r20, r21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00e5, code lost:
    
        r11 = androidx.appcompat.resources.Compatibility.Api21Impl.createFromXmlInner(r18, r19, r20, r21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0102, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r19.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0103, code lost:
    
        if (r11 == null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0105, code lost:
    
        r9 = r16.f746p;
        r10 = r9.m7288a(r11);
        r9.f26050I[r10] = r6;
        r9.f29263K.put(r10, java.lang.Integer.valueOf(r13));
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0132, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r19.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
     */
    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void inflate(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
        int depth;
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableCompat);
        setVisible(obtainAttributes.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        C2047z7 c2047z7 = this.f746p;
        c2047z7.f26054d |= Compatibility.Api21Impl.getChangingConfigurations(obtainAttributes);
        c2047z7.f26059i = obtainAttributes.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_variablePadding, c2047z7.f26059i);
        c2047z7.f26062l = obtainAttributes.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_constantSize, c2047z7.f26062l);
        c2047z7.f26076z = obtainAttributes.getInt(R.styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, c2047z7.f26076z);
        c2047z7.f26042A = obtainAttributes.getInt(R.styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, c2047z7.f26042A);
        setDither(obtainAttributes.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_dither, c2047z7.f26074x));
        rn2 rn2Var = this.f752a;
        if (resources != null) {
            rn2Var.f26052b = resources;
            int i = resources.getDisplayMetrics().densityDpi;
            if (i == 0) {
                i = 160;
            }
            int i2 = rn2Var.f26053c;
            rn2Var.f26053c = i;
            if (i2 != i) {
                rn2Var.f26063m = false;
                rn2Var.f26060j = false;
            }
        } else {
            rn2Var.getClass();
        }
        obtainAttributes.recycle();
        int depth2 = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2) {
                Drawable drawable = null;
                if (xmlPullParser.getName().equals("item")) {
                    TypedArray obtainAttributes2 = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableItem);
                    int resourceId = obtainAttributes2.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_id, 0);
                    int resourceId2 = obtainAttributes2.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_drawable, -1);
                    if (resourceId2 > 0) {
                        drawable = ResourceManagerInternal.get().getDrawable(context, resourceId2);
                    }
                    obtainAttributes2.recycle();
                    int[] m204g = StateListDrawableCompat.m204g(attributeSet);
                } else if (xmlPullParser.getName().equals("transition")) {
                    TypedArray obtainAttributes3 = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableTransition);
                    int resourceId3 = obtainAttributes3.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
                    int resourceId4 = obtainAttributes3.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_toId, -1);
                    int resourceId5 = obtainAttributes3.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
                    if (resourceId5 > 0) {
                        drawable = ResourceManagerInternal.get().getDrawable(context, resourceId5);
                    }
                    boolean z = obtainAttributes3.getBoolean(R.styleable.AnimatedStateListDrawableTransition_android_reversible, false);
                    obtainAttributes3.recycle();
                } else {
                    continue;
                }
            }
        }
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        yy2 yy2Var = this.f747q;
        if (yy2Var != null) {
            yy2Var.mo36O();
            this.f747q = null;
            m202d(this.f748r);
            this.f748r = -1;
            this.f749s = -1;
        }
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        if (!this.f750t && super.mutate() == this) {
            this.f746p.mo7293f();
            this.f750t = true;
        }
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0105, code lost:
    
        if (m202d(r1) != false) goto L51;
     */
    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onStateChange(@NonNull int[] iArr) {
        int intValue;
        int intValue2;
        boolean z;
        yy2 c2010y7;
        C2047z7 c2047z7 = this.f746p;
        int m7292e = c2047z7.m7292e(iArr);
        if (m7292e < 0) {
            m7292e = c2047z7.m7292e(StateSet.WILD_CARD);
        }
        int i = this.f758g;
        boolean z2 = false;
        if (m7292e != i) {
            yy2 yy2Var = this.f747q;
            if (yy2Var != null) {
                if (m7292e != this.f748r) {
                    if (m7292e == this.f749s && yy2Var.mo37g()) {
                        yy2Var.mo34M();
                        this.f748r = this.f749s;
                        this.f749s = m7292e;
                    } else {
                        i = this.f748r;
                        yy2Var.mo36O();
                    }
                }
                z2 = true;
            }
            this.f747q = null;
            this.f749s = -1;
            this.f748r = -1;
            C2047z7 c2047z72 = this.f746p;
            if (i < 0) {
                c2047z72.getClass();
                intValue = 0;
            } else {
                intValue = ((Integer) c2047z72.f29263K.get(i, 0)).intValue();
            }
            if (m7292e < 0) {
                intValue2 = 0;
            } else {
                intValue2 = ((Integer) c2047z72.f29263K.get(m7292e, 0)).intValue();
            }
            if (intValue2 != 0 && intValue != 0) {
                long j = intValue2 | (intValue << 32);
                int longValue = (int) ((Long) c2047z72.f29262J.get(j, -1L)).longValue();
                if (longValue >= 0) {
                    if ((((Long) c2047z72.f29262J.get(j, -1L)).longValue() & 8589934592L) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    m202d(longValue);
                    Object current = getCurrent();
                    if (current instanceof AnimationDrawable) {
                        if ((((Long) c2047z72.f29262J.get(j, -1L)).longValue() & 4294967296L) != 0) {
                            z2 = true;
                        }
                        c2010y7 = new C0009a8((AnimationDrawable) current, z2, z);
                    } else if (current instanceof AnimatedVectorDrawableCompat) {
                        c2010y7 = new C2010y7((AnimatedVectorDrawableCompat) current, 1);
                    } else if (current instanceof Animatable) {
                        c2010y7 = new C2010y7((Animatable) current, 0);
                    }
                    c2010y7.mo35N();
                    this.f747q = c2010y7;
                    this.f749s = i;
                    this.f748r = m7292e;
                    z2 = true;
                }
            }
        }
        Drawable current2 = getCurrent();
        if (current2 != null) {
            return z2 | current2.setState(iArr);
        }
        return z2;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        yy2 yy2Var = this.f747q;
        if (yy2Var != null && (visible || z2)) {
            if (z) {
                yy2Var.mo35N();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    public AnimatedStateListDrawableCompat(C2047z7 c2047z7, Resources resources) {
        this.f748r = -1;
        this.f749s = -1;
        mo198e(new C2047z7(c2047z7, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }
}
