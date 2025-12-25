package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.IBinder;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.CompoundButton;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.emoji2.text.EmojiCompat;
import androidx.recyclerview.widget.RecyclerView;
import p000.AbstractC1497l3;
import p000.C1151ea;
import p000.C1503l9;
import p000.ar2;
import p000.je0;

/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton implements EmojiCompatConfigurationView {

    /* renamed from: R */
    public static final je0 f1420R = new je0("thumbPos", 1, Float.class);

    /* renamed from: S */
    public static final int[] f1421S = {R.attr.state_checked};

    /* renamed from: A */
    public int f1422A;

    /* renamed from: B */
    public int f1423B;

    /* renamed from: C */
    public int f1424C;

    /* renamed from: D */
    public int f1425D;

    /* renamed from: E */
    public int f1426E;

    /* renamed from: F */
    public int f1427F;

    /* renamed from: G */
    public int f1428G;

    /* renamed from: H */
    public boolean f1429H;

    /* renamed from: I */
    public final TextPaint f1430I;

    /* renamed from: J */
    public ColorStateList f1431J;

    /* renamed from: K */
    public StaticLayout f1432K;

    /* renamed from: L */
    public StaticLayout f1433L;

    /* renamed from: M */
    public AllCapsTransformationMethod f1434M;

    /* renamed from: N */
    public ObjectAnimator f1435N;

    /* renamed from: O */
    public C1503l9 f1436O;

    /* renamed from: P */
    public ar2 f1437P;

    /* renamed from: Q */
    public final Rect f1438Q;

    /* renamed from: a */
    public Drawable f1439a;

    /* renamed from: b */
    public ColorStateList f1440b;

    /* renamed from: c */
    public PorterDuff.Mode f1441c;

    /* renamed from: d */
    public boolean f1442d;

    /* renamed from: e */
    public boolean f1443e;

    /* renamed from: f */
    public Drawable f1444f;

    /* renamed from: g */
    public ColorStateList f1445g;

    /* renamed from: h */
    public PorterDuff.Mode f1446h;

    /* renamed from: i */
    public boolean f1447i;

    /* renamed from: j */
    public boolean f1448j;

    /* renamed from: k */
    public int f1449k;

    /* renamed from: l */
    public int f1450l;

    /* renamed from: m */
    public int f1451m;

    /* renamed from: n */
    public boolean f1452n;

    /* renamed from: o */
    public CharSequence f1453o;

    /* renamed from: p */
    public CharSequence f1454p;

    /* renamed from: q */
    public CharSequence f1455q;

    /* renamed from: r */
    public CharSequence f1456r;

    /* renamed from: s */
    public boolean f1457s;

    /* renamed from: t */
    public int f1458t;

    /* renamed from: u */
    public final int f1459u;

    /* renamed from: v */
    public float f1460v;

    /* renamed from: w */
    public float f1461w;

    /* renamed from: x */
    public final VelocityTracker f1462x;

    /* renamed from: y */
    public final int f1463y;

    /* renamed from: z */
    public float f1464z;

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* renamed from: a */
        public boolean f1465a = false;

        /* renamed from: b */
        public int f1466b;

        /* renamed from: c */
        public int f1467c;

        /* renamed from: d */
        public int f1468d;

        /* renamed from: e */
        public int f1469e;

        /* renamed from: f */
        public int f1470f;

        /* renamed from: g */
        public int f1471g;

        /* renamed from: h */
        public int f1472h;

        /* renamed from: i */
        public int f1473i;

        /* renamed from: j */
        public int f1474j;

        /* renamed from: k */
        public int f1475k;

        /* renamed from: l */
        public int f1476l;

        /* renamed from: m */
        public int f1477m;

        /* renamed from: n */
        public int f1478n;

        public void mapProperties(@NonNull PropertyMapper propertyMapper) {
            int mapObject;
            int mapObject2;
            int mapObject3;
            int mapBoolean;
            int mapBoolean2;
            int mapInt;
            int mapInt2;
            int mapInt3;
            int mapObject4;
            int mapObject5;
            int mapObject6;
            int mapObject7;
            int mapObject8;
            mapObject = propertyMapper.mapObject("textOff", R.attr.textOff);
            this.f1466b = mapObject;
            mapObject2 = propertyMapper.mapObject("textOn", R.attr.textOn);
            this.f1467c = mapObject2;
            mapObject3 = propertyMapper.mapObject("thumb", R.attr.thumb);
            this.f1468d = mapObject3;
            mapBoolean = propertyMapper.mapBoolean("showText", androidx.appcompat.R.attr.showText);
            this.f1469e = mapBoolean;
            mapBoolean2 = propertyMapper.mapBoolean("splitTrack", androidx.appcompat.R.attr.splitTrack);
            this.f1470f = mapBoolean2;
            mapInt = propertyMapper.mapInt("switchMinWidth", androidx.appcompat.R.attr.switchMinWidth);
            this.f1471g = mapInt;
            mapInt2 = propertyMapper.mapInt("switchPadding", androidx.appcompat.R.attr.switchPadding);
            this.f1472h = mapInt2;
            mapInt3 = propertyMapper.mapInt("thumbTextPadding", androidx.appcompat.R.attr.thumbTextPadding);
            this.f1473i = mapInt3;
            mapObject4 = propertyMapper.mapObject("thumbTint", androidx.appcompat.R.attr.thumbTint);
            this.f1474j = mapObject4;
            mapObject5 = propertyMapper.mapObject("thumbTintMode", androidx.appcompat.R.attr.thumbTintMode);
            this.f1475k = mapObject5;
            mapObject6 = propertyMapper.mapObject("track", androidx.appcompat.R.attr.track);
            this.f1476l = mapObject6;
            mapObject7 = propertyMapper.mapObject("trackTint", androidx.appcompat.R.attr.trackTint);
            this.f1477m = mapObject7;
            mapObject8 = propertyMapper.mapObject("trackTintMode", androidx.appcompat.R.attr.trackTintMode);
            this.f1478n = mapObject8;
            this.f1465a = true;
        }

        public void readProperties(@NonNull SwitchCompat switchCompat, @NonNull PropertyReader propertyReader) {
            if (this.f1465a) {
                propertyReader.readObject(this.f1466b, switchCompat.getTextOff());
                propertyReader.readObject(this.f1467c, switchCompat.getTextOn());
                propertyReader.readObject(this.f1468d, switchCompat.getThumbDrawable());
                propertyReader.readBoolean(this.f1469e, switchCompat.getShowText());
                propertyReader.readBoolean(this.f1470f, switchCompat.getSplitTrack());
                propertyReader.readInt(this.f1471g, switchCompat.getSwitchMinWidth());
                propertyReader.readInt(this.f1472h, switchCompat.getSwitchPadding());
                propertyReader.readInt(this.f1473i, switchCompat.getThumbTextPadding());
                propertyReader.readObject(this.f1474j, switchCompat.getThumbTintList());
                propertyReader.readObject(this.f1475k, switchCompat.getThumbTintMode());
                propertyReader.readObject(this.f1476l, switchCompat.getTrackDrawable());
                propertyReader.readObject(this.f1477m, switchCompat.getTrackTintList());
                propertyReader.readObject(this.f1478n, switchCompat.getTrackTintMode());
                return;
            }
            throw AbstractC1497l3.m5831i();
        }
    }

    public SwitchCompat(@NonNull Context context) {
        this(context, null);
    }

    @NonNull
    private C1503l9 getEmojiTextViewHelper() {
        if (this.f1436O == null) {
            this.f1436O = new C1503l9(this);
        }
        return this.f1436O;
    }

    private boolean getTargetCheckedState() {
        if (this.f1464z > 0.5f) {
            return true;
        }
        return false;
    }

    private int getThumbOffset() {
        float f;
        if (ViewUtils.isLayoutRtl(this)) {
            f = 1.0f - this.f1464z;
        } else {
            f = this.f1464z;
        }
        return (int) ((f * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rect;
        Drawable drawable = this.f1444f;
        if (drawable != null) {
            Rect rect2 = this.f1438Q;
            drawable.getPadding(rect2);
            Drawable drawable2 = this.f1439a;
            if (drawable2 != null) {
                rect = DrawableUtils.getOpticalBounds(drawable2);
            } else {
                rect = DrawableUtils.INSETS_NONE;
            }
            return ((((this.f1422A - this.f1424C) - rect2.left) - rect2.right) - rect.left) - rect.right;
        }
        return 0;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f1455q = charSequence;
        C1503l9 emojiTextViewHelper = getEmojiTextViewHelper();
        TransformationMethod wrapTransformationMethod = emojiTextViewHelper.f22390b.wrapTransformationMethod(this.f1434M);
        if (wrapTransformationMethod != null) {
            charSequence = wrapTransformationMethod.getTransformation(charSequence, this);
        }
        this.f1456r = charSequence;
        this.f1433L = null;
        if (this.f1457s) {
            m281d();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f1453o = charSequence;
        C1503l9 emojiTextViewHelper = getEmojiTextViewHelper();
        TransformationMethod wrapTransformationMethod = emojiTextViewHelper.f22390b.wrapTransformationMethod(this.f1434M);
        if (wrapTransformationMethod != null) {
            charSequence = wrapTransformationMethod.getTransformation(charSequence, this);
        }
        this.f1454p = charSequence;
        this.f1432K = null;
        if (this.f1457s) {
            m281d();
        }
    }

    /* renamed from: a */
    public final void m278a() {
        Drawable drawable = this.f1439a;
        if (drawable != null) {
            if (this.f1442d || this.f1443e) {
                Drawable mutate = DrawableCompat.wrap(drawable).mutate();
                this.f1439a = mutate;
                if (this.f1442d) {
                    DrawableCompat.setTintList(mutate, this.f1440b);
                }
                if (this.f1443e) {
                    DrawableCompat.setTintMode(this.f1439a, this.f1441c);
                }
                if (this.f1439a.isStateful()) {
                    this.f1439a.setState(getDrawableState());
                }
            }
        }
    }

    /* renamed from: b */
    public final void m279b() {
        Drawable drawable = this.f1444f;
        if (drawable != null) {
            if (this.f1447i || this.f1448j) {
                Drawable mutate = DrawableCompat.wrap(drawable).mutate();
                this.f1444f = mutate;
                if (this.f1447i) {
                    DrawableCompat.setTintList(mutate, this.f1445g);
                }
                if (this.f1448j) {
                    DrawableCompat.setTintMode(this.f1444f, this.f1446h);
                }
                if (this.f1444f.isStateful()) {
                    this.f1444f.setState(getDrawableState());
                }
            }
        }
    }

    /* renamed from: c */
    public final void m280c() {
        setTextOnInternal(this.f1453o);
        setTextOffInternal(this.f1455q);
        requestLayout();
    }

    /* renamed from: d */
    public final void m281d() {
        if (this.f1437P == null && this.f1436O.f22390b.isEnabled() && EmojiCompat.isConfigured()) {
            EmojiCompat emojiCompat = EmojiCompat.get();
            int loadState = emojiCompat.getLoadState();
            if (loadState == 3 || loadState == 0) {
                ar2 ar2Var = new ar2(this);
                this.f1437P = ar2Var;
                emojiCompat.registerInitCallback(ar2Var);
            }
        }
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        Rect rect;
        int i;
        int i2;
        int i3 = this.f1425D;
        int i4 = this.f1426E;
        int i5 = this.f1427F;
        int i6 = this.f1428G;
        int thumbOffset = getThumbOffset() + i3;
        Drawable drawable = this.f1439a;
        if (drawable != null) {
            rect = DrawableUtils.getOpticalBounds(drawable);
        } else {
            rect = DrawableUtils.INSETS_NONE;
        }
        Drawable drawable2 = this.f1444f;
        Rect rect2 = this.f1438Q;
        if (drawable2 != null) {
            drawable2.getPadding(rect2);
            int i7 = rect2.left;
            thumbOffset += i7;
            if (rect != null) {
                int i8 = rect.left;
                if (i8 > i7) {
                    i3 += i8 - i7;
                }
                int i9 = rect.top;
                int i10 = rect2.top;
                if (i9 > i10) {
                    i = (i9 - i10) + i4;
                } else {
                    i = i4;
                }
                int i11 = rect.right;
                int i12 = rect2.right;
                if (i11 > i12) {
                    i5 -= i11 - i12;
                }
                int i13 = rect.bottom;
                int i14 = rect2.bottom;
                if (i13 > i14) {
                    i2 = i6 - (i13 - i14);
                    this.f1444f.setBounds(i3, i, i5, i2);
                }
            } else {
                i = i4;
            }
            i2 = i6;
            this.f1444f.setBounds(i3, i, i5, i2);
        }
        Drawable drawable3 = this.f1439a;
        if (drawable3 != null) {
            drawable3.getPadding(rect2);
            int i15 = thumbOffset - rect2.left;
            int i16 = thumbOffset + this.f1424C + rect2.right;
            this.f1439a.setBounds(i15, i4, i16, i6);
            Drawable background = getBackground();
            if (background != null) {
                DrawableCompat.setHotspotBounds(background, i15, i4, i16, i6);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        Drawable drawable = this.f1439a;
        if (drawable != null) {
            DrawableCompat.setHotspot(drawable, f, f2);
        }
        Drawable drawable2 = this.f1444f;
        if (drawable2 != null) {
            DrawableCompat.setHotspot(drawable2, f, f2);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        boolean z;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f1439a;
        if (drawable != null && drawable.isStateful()) {
            z = drawable.setState(drawableState);
        } else {
            z = false;
        }
        Drawable drawable2 = this.f1444f;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!ViewUtils.isLayoutRtl(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f1422A;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingLeft + this.f1451m;
        }
        return compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (ViewUtils.isLayoutRtl(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f1422A;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingRight + this.f1451m;
        }
        return compoundPaddingRight;
    }

    @Override // android.widget.TextView
    @Nullable
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.unwrapCustomSelectionActionModeCallback(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.f1457s;
    }

    public boolean getSplitTrack() {
        return this.f1452n;
    }

    public int getSwitchMinWidth() {
        return this.f1450l;
    }

    public int getSwitchPadding() {
        return this.f1451m;
    }

    public CharSequence getTextOff() {
        return this.f1455q;
    }

    public CharSequence getTextOn() {
        return this.f1453o;
    }

    public Drawable getThumbDrawable() {
        return this.f1439a;
    }

    @FloatRange(from = 0.0d, m152to = 1.0d)
    public final float getThumbPosition() {
        return this.f1464z;
    }

    public int getThumbTextPadding() {
        return this.f1449k;
    }

    @Nullable
    public ColorStateList getThumbTintList() {
        return this.f1440b;
    }

    @Nullable
    public PorterDuff.Mode getThumbTintMode() {
        return this.f1441c;
    }

    public Drawable getTrackDrawable() {
        return this.f1444f;
    }

    @Nullable
    public ColorStateList getTrackTintList() {
        return this.f1445g;
    }

    @Nullable
    public PorterDuff.Mode getTrackTintMode() {
        return this.f1446h;
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public boolean isEmojiCompatEnabled() {
        return getEmojiTextViewHelper().f22390b.isEnabled();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1439a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1444f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.f1435N;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.f1435N.end();
            this.f1435N = null;
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f1421S);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        StaticLayout staticLayout;
        int width;
        super.onDraw(canvas);
        Drawable drawable = this.f1444f;
        Rect rect = this.f1438Q;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.f1426E;
        int i2 = this.f1428G;
        int i3 = i + rect.top;
        int i4 = i2 - rect.bottom;
        Drawable drawable2 = this.f1439a;
        if (drawable != null) {
            if (this.f1452n && drawable2 != null) {
                Rect opticalBounds = DrawableUtils.getOpticalBounds(drawable2);
                drawable2.copyBounds(rect);
                rect.left += opticalBounds.left;
                rect.right -= opticalBounds.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            } else {
                drawable.draw(canvas);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        if (getTargetCheckedState()) {
            staticLayout = this.f1432K;
        } else {
            staticLayout = this.f1433L;
        }
        if (staticLayout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.f1431J;
            TextPaint textPaint = this.f1430I;
            if (colorStateList != null) {
                textPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            textPaint.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (staticLayout.getWidth() / 2), ((i3 + i4) / 2) - (staticLayout.getHeight() / 2));
            staticLayout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        CharSequence charSequence;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            if (isChecked()) {
                charSequence = this.f1453o;
            } else {
                charSequence = this.f1455q;
            }
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(text);
                sb.append(' ');
                sb.append(charSequence);
                accessibilityNodeInfo.setText(sb);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int width;
        int i6;
        int i7;
        int i8;
        super.onLayout(z, i, i2, i3, i4);
        int i9 = 0;
        if (this.f1439a != null) {
            Drawable drawable = this.f1444f;
            Rect rect = this.f1438Q;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect opticalBounds = DrawableUtils.getOpticalBounds(this.f1439a);
            i5 = Math.max(0, opticalBounds.left - rect.left);
            i9 = Math.max(0, opticalBounds.right - rect.right);
        } else {
            i5 = 0;
        }
        if (ViewUtils.isLayoutRtl(this)) {
            i6 = getPaddingLeft() + i5;
            width = ((this.f1422A + i6) - i5) - i9;
        } else {
            width = (getWidth() - getPaddingRight()) - i9;
            i6 = (width - this.f1422A) + i5 + i9;
        }
        int gravity = getGravity() & 112;
        if (gravity != 16) {
            if (gravity != 80) {
                i8 = getPaddingTop();
                i7 = this.f1423B + i8;
            } else {
                i7 = getHeight() - getPaddingBottom();
                i8 = i7 - this.f1423B;
            }
        } else {
            int height = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
            int i10 = this.f1423B;
            int i11 = height - (i10 / 2);
            i7 = i10 + i11;
            i8 = i11;
        }
        this.f1425D = i6;
        this.f1426E = i8;
        this.f1428G = i7;
        this.f1427F = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = 0;
        if (this.f1457s) {
            StaticLayout staticLayout = this.f1432K;
            TextPaint textPaint = this.f1430I;
            if (staticLayout == null) {
                CharSequence charSequence = this.f1454p;
                if (charSequence != null) {
                    i8 = (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint));
                } else {
                    i8 = 0;
                }
                this.f1432K = new StaticLayout(charSequence, textPaint, i8, Layout.Alignment.ALIGN_NORMAL, 1.0f, RecyclerView.f7068F0, true);
            }
            if (this.f1433L == null) {
                CharSequence charSequence2 = this.f1456r;
                if (charSequence2 != null) {
                    i7 = (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint));
                } else {
                    i7 = 0;
                }
                this.f1433L = new StaticLayout(charSequence2, textPaint, i7, Layout.Alignment.ALIGN_NORMAL, 1.0f, RecyclerView.f7068F0, true);
            }
        }
        Drawable drawable = this.f1439a;
        Rect rect = this.f1438Q;
        if (drawable != null) {
            drawable.getPadding(rect);
            i3 = (this.f1439a.getIntrinsicWidth() - rect.left) - rect.right;
            i4 = this.f1439a.getIntrinsicHeight();
        } else {
            i3 = 0;
            i4 = 0;
        }
        if (this.f1457s) {
            i5 = (this.f1449k * 2) + Math.max(this.f1432K.getWidth(), this.f1433L.getWidth());
        } else {
            i5 = 0;
        }
        this.f1424C = Math.max(i5, i3);
        Drawable drawable2 = this.f1444f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i9 = this.f1444f.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i10 = rect.left;
        int i11 = rect.right;
        Drawable drawable3 = this.f1439a;
        if (drawable3 != null) {
            Rect opticalBounds = DrawableUtils.getOpticalBounds(drawable3);
            i10 = Math.max(i10, opticalBounds.left);
            i11 = Math.max(i11, opticalBounds.right);
        }
        if (this.f1429H) {
            i6 = Math.max(this.f1450l, (this.f1424C * 2) + i10 + i11);
        } else {
            i6 = this.f1450l;
        }
        int max = Math.max(i9, i4);
        this.f1422A = i6;
        this.f1423B = max;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < max) {
            setMeasuredDimension(getMeasuredWidthAndState(), max);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        CharSequence charSequence;
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        if (isChecked()) {
            charSequence = this.f1453o;
        } else {
            charSequence = this.f1455q;
        }
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0015, code lost:
    
        if (r1 != 3) goto L82;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        float f;
        VelocityTracker velocityTracker = this.f1462x;
        velocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int i = this.f1459u;
        if (actionMasked != 0) {
            float f2 = RecyclerView.f7068F0;
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i2 = this.f1458t;
                    if (i2 != 1) {
                        if (i2 == 2) {
                            float x = motionEvent.getX();
                            int thumbScrollRange = getThumbScrollRange();
                            float f3 = x - this.f1460v;
                            if (thumbScrollRange != 0) {
                                f = f3 / thumbScrollRange;
                            } else if (f3 > RecyclerView.f7068F0) {
                                f = 1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (ViewUtils.isLayoutRtl(this)) {
                                f = -f;
                            }
                            float f4 = this.f1464z;
                            float f5 = f + f4;
                            if (f5 >= RecyclerView.f7068F0) {
                                if (f5 > 1.0f) {
                                    f2 = 1.0f;
                                } else {
                                    f2 = f5;
                                }
                            }
                            if (f2 != f4) {
                                this.f1460v = x;
                                setThumbPosition(f2);
                            }
                            return true;
                        }
                    } else {
                        float x2 = motionEvent.getX();
                        float y = motionEvent.getY();
                        float f6 = i;
                        if (Math.abs(x2 - this.f1460v) > f6 || Math.abs(y - this.f1461w) > f6) {
                            this.f1458t = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.f1460v = x2;
                            this.f1461w = y;
                            return true;
                        }
                    }
                }
            }
            if (this.f1458t == 2) {
                this.f1458t = 0;
                if (motionEvent.getAction() == 1 && isEnabled()) {
                    z = true;
                } else {
                    z = false;
                }
                boolean isChecked = isChecked();
                if (z) {
                    velocityTracker.computeCurrentVelocity(1000);
                    float xVelocity = velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.f1463y) {
                        if (!ViewUtils.isLayoutRtl(this) ? xVelocity > RecyclerView.f7068F0 : xVelocity < RecyclerView.f7068F0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } else {
                        z2 = getTargetCheckedState();
                    }
                } else {
                    z2 = isChecked;
                }
                if (z2 != isChecked) {
                    playSoundEffect(0);
                }
                setChecked(z2);
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(3);
                super.onTouchEvent(obtain);
                obtain.recycle();
                super.onTouchEvent(motionEvent);
                return true;
            }
            this.f1458t = 0;
            velocityTracker.clear();
        } else {
            float x3 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (isEnabled() && this.f1439a != null) {
                int thumbOffset = getThumbOffset();
                Drawable drawable = this.f1439a;
                Rect rect = this.f1438Q;
                drawable.getPadding(rect);
                int i3 = this.f1426E - i;
                int i4 = (this.f1425D + thumbOffset) - i;
                int i5 = this.f1424C + i4 + rect.left + rect.right + i;
                int i6 = this.f1428G + i;
                if (x3 > i4 && x3 < i5 && y2 > i3 && y2 < i6) {
                    this.f1458t = 1;
                    this.f1460v = x3;
                    this.f1461w = y2;
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().m5897b(z);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (isChecked) {
            if (Build.VERSION.SDK_INT >= 30) {
                CharSequence charSequence = this.f1453o;
                if (charSequence == null) {
                    charSequence = getResources().getString(androidx.appcompat.R.string.abc_capital_on);
                }
                ViewCompat.setStateDescription(this, charSequence);
            }
        } else if (Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence2 = this.f1455q;
            if (charSequence2 == null) {
                charSequence2 = getResources().getString(androidx.appcompat.R.string.abc_capital_off);
            }
            ViewCompat.setStateDescription(this, charSequence2);
        }
        IBinder windowToken = getWindowToken();
        float f = RecyclerView.f7068F0;
        if (windowToken != null && isLaidOut()) {
            if (isChecked) {
                f = 1.0f;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f1420R, f);
            this.f1435N = ofFloat;
            ofFloat.setDuration(250L);
            this.f1435N.setAutoCancel(true);
            this.f1435N.start();
            return;
        }
        ObjectAnimator objectAnimator = this.f1435N;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        if (isChecked) {
            f = 1.0f;
        }
        setThumbPosition(f);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(@Nullable ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().m5898c(z);
        setTextOnInternal(this.f1453o);
        setTextOffInternal(this.f1455q);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z) {
        this.f1429H = z;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(@NonNull InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().f22390b.getFilters(inputFilterArr));
    }

    public void setShowText(boolean z) {
        if (this.f1457s != z) {
            this.f1457s = z;
            requestLayout();
            if (z) {
                m281d();
            }
        }
    }

    public void setSplitTrack(boolean z) {
        this.f1452n = z;
        invalidate();
    }

    public void setSwitchMinWidth(int i) {
        this.f1450l = i;
        requestLayout();
    }

    public void setSwitchPadding(int i) {
        this.f1451m = i;
        requestLayout();
    }

    public void setSwitchTextAppearance(Context context, int i) {
        Typeface typeface;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, i, androidx.appcompat.R.styleable.TextAppearance);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(androidx.appcompat.R.styleable.TextAppearance_android_textColor);
        if (colorStateList != null) {
            this.f1431J = colorStateList;
        } else {
            this.f1431J = getTextColors();
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);
        if (dimensionPixelSize != 0) {
            float f = dimensionPixelSize;
            TextPaint textPaint = this.f1430I;
            if (f != textPaint.getTextSize()) {
                textPaint.setTextSize(f);
                requestLayout();
            }
        }
        int i2 = obtainStyledAttributes.getInt(androidx.appcompat.R.styleable.TextAppearance_android_typeface, -1);
        int i3 = obtainStyledAttributes.getInt(androidx.appcompat.R.styleable.TextAppearance_android_textStyle, -1);
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    typeface = null;
                } else {
                    typeface = Typeface.MONOSPACE;
                }
            } else {
                typeface = Typeface.SERIF;
            }
        } else {
            typeface = Typeface.SANS_SERIF;
        }
        setSwitchTypeface(typeface, i3);
        if (obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.TextAppearance_textAllCaps, false)) {
            this.f1434M = new AllCapsTransformationMethod(getContext());
        } else {
            this.f1434M = null;
        }
        setTextOnInternal(this.f1453o);
        setTextOffInternal(this.f1455q);
        obtainStyledAttributes.recycle();
    }

    public void setSwitchTypeface(Typeface typeface, int i) {
        Typeface create;
        float f = RecyclerView.f7068F0;
        TextPaint textPaint = this.f1430I;
        if (i > 0) {
            if (typeface == null) {
                create = Typeface.defaultFromStyle(i);
            } else {
                create = Typeface.create(typeface, i);
            }
            setSwitchTypeface(create);
            int i2 = (~(create != null ? create.getStyle() : 0)) & i;
            textPaint.setFakeBoldText((i2 & 1) != 0);
            if ((i2 & 2) != 0) {
                f = -0.25f;
            }
            textPaint.setTextSkewX(f);
            return;
        }
        textPaint.setFakeBoldText(false);
        textPaint.setTextSkewX(RecyclerView.f7068F0);
        setSwitchTypeface(typeface);
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (!isChecked() && Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence2 = this.f1455q;
            if (charSequence2 == null) {
                charSequence2 = getResources().getString(androidx.appcompat.R.string.abc_capital_off);
            }
            ViewCompat.setStateDescription(this, charSequence2);
        }
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (isChecked() && Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence2 = this.f1453o;
            if (charSequence2 == null) {
                charSequence2 = getResources().getString(androidx.appcompat.R.string.abc_capital_on);
            }
            ViewCompat.setStateDescription(this, charSequence2);
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f1439a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1439a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f) {
        this.f1464z = f;
        invalidate();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(AppCompatResources.getDrawable(getContext(), i));
    }

    public void setThumbTextPadding(int i) {
        this.f1449k = i;
        requestLayout();
    }

    public void setThumbTintList(@Nullable ColorStateList colorStateList) {
        this.f1440b = colorStateList;
        this.f1442d = true;
        m278a();
    }

    public void setThumbTintMode(@Nullable PorterDuff.Mode mode) {
        this.f1441c = mode;
        this.f1443e = true;
        m278a();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f1444f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1444f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(AppCompatResources.getDrawable(getContext(), i));
    }

    public void setTrackTintList(@Nullable ColorStateList colorStateList) {
        this.f1445g = colorStateList;
        this.f1447i = true;
        m279b();
    }

    public void setTrackTintMode(@Nullable PorterDuff.Mode mode) {
        this.f1446h = mode;
        this.f1448j = true;
        m279b();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.f1439a && drawable != this.f1444f) {
            return false;
        }
        return true;
    }

    public SwitchCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.switchStyle);
    }

    public SwitchCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1440b = null;
        this.f1441c = null;
        this.f1442d = false;
        this.f1443e = false;
        this.f1445g = null;
        this.f1446h = null;
        this.f1447i = false;
        this.f1448j = false;
        this.f1462x = VelocityTracker.obtain();
        this.f1429H = true;
        this.f1438Q = new Rect();
        ThemeUtils.checkAppCompatTheme(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.f1430I = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = androidx.appcompat.R.styleable.SwitchCompat;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.SwitchCompat_android_thumb);
        this.f1439a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.SwitchCompat_track);
        this.f1444f = drawable2;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
        setTextOnInternal(obtainStyledAttributes.getText(androidx.appcompat.R.styleable.SwitchCompat_android_textOn));
        setTextOffInternal(obtainStyledAttributes.getText(androidx.appcompat.R.styleable.SwitchCompat_android_textOff));
        this.f1457s = obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.SwitchCompat_showText, true);
        this.f1449k = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_thumbTextPadding, 0);
        this.f1450l = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_switchMinWidth, 0);
        this.f1451m = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_switchPadding, 0);
        this.f1452n = obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.SwitchCompat_splitTrack, false);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(androidx.appcompat.R.styleable.SwitchCompat_thumbTint);
        if (colorStateList != null) {
            this.f1440b = colorStateList;
            this.f1442d = true;
        }
        PorterDuff.Mode parseTintMode = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(androidx.appcompat.R.styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.f1441c != parseTintMode) {
            this.f1441c = parseTintMode;
            this.f1443e = true;
        }
        if (this.f1442d || this.f1443e) {
            m278a();
        }
        ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(androidx.appcompat.R.styleable.SwitchCompat_trackTint);
        if (colorStateList2 != null) {
            this.f1445g = colorStateList2;
            this.f1447i = true;
        }
        PorterDuff.Mode parseTintMode2 = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(androidx.appcompat.R.styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.f1446h != parseTintMode2) {
            this.f1446h = parseTintMode2;
            this.f1448j = true;
        }
        if (this.f1447i || this.f1448j) {
            m279b();
        }
        int resourceId = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.SwitchCompat_switchTextAppearance, 0);
        if (resourceId != 0) {
            setSwitchTextAppearance(context, resourceId);
        }
        new C1151ea(this).m4675f(attributeSet, i);
        obtainStyledAttributes.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1459u = viewConfiguration.getScaledTouchSlop();
        this.f1463y = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().m5896a(attributeSet, i);
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void setSwitchTypeface(Typeface typeface) {
        TextPaint textPaint = this.f1430I;
        if ((textPaint.getTypeface() == null || textPaint.getTypeface().equals(typeface)) && (textPaint.getTypeface() != null || typeface == null)) {
            return;
        }
        textPaint.setTypeface(typeface);
        requestLayout();
        invalidate();
    }
}
