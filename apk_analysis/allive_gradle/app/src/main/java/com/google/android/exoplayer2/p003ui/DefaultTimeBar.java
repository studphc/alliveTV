package com.google.android.exoplayer2.p003ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.p003ui.TimeBar;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
import p000.AbstractC1502l8;
import p000.RunnableC0006a5;
import p000.jf2;

/* loaded from: classes.dex */
public class DefaultTimeBar extends View implements TimeBar {
    public static final int BAR_GRAVITY_BOTTOM = 1;
    public static final int BAR_GRAVITY_CENTER = 0;
    public static final int DEFAULT_AD_MARKER_COLOR = -1291845888;
    public static final int DEFAULT_AD_MARKER_WIDTH_DP = 4;
    public static final int DEFAULT_BAR_HEIGHT_DP = 4;
    public static final int DEFAULT_BUFFERED_COLOR = -855638017;
    public static final int DEFAULT_PLAYED_AD_MARKER_COLOR = 872414976;
    public static final int DEFAULT_PLAYED_COLOR = -1;
    public static final int DEFAULT_SCRUBBER_COLOR = -1;
    public static final int DEFAULT_SCRUBBER_DISABLED_SIZE_DP = 0;
    public static final int DEFAULT_SCRUBBER_DRAGGED_SIZE_DP = 16;
    public static final int DEFAULT_SCRUBBER_ENABLED_SIZE_DP = 12;
    public static final int DEFAULT_TOUCH_TARGET_HEIGHT_DP = 26;
    public static final int DEFAULT_UNPLAYED_COLOR = 872415231;

    /* renamed from: A */
    public int f12012A;

    /* renamed from: B */
    public long f12013B;

    /* renamed from: C */
    public int f12014C;

    /* renamed from: D */
    public Rect f12015D;

    /* renamed from: E */
    public final ValueAnimator f12016E;

    /* renamed from: F */
    public float f12017F;

    /* renamed from: G */
    public boolean f12018G;

    /* renamed from: H */
    public boolean f12019H;

    /* renamed from: I */
    public long f12020I;

    /* renamed from: J */
    public long f12021J;

    /* renamed from: K */
    public long f12022K;

    /* renamed from: L */
    public long f12023L;

    /* renamed from: M */
    public int f12024M;

    /* renamed from: N */
    public long[] f12025N;

    /* renamed from: O */
    public boolean[] f12026O;

    /* renamed from: a */
    public final Rect f12027a;

    /* renamed from: b */
    public final Rect f12028b;

    /* renamed from: c */
    public final Rect f12029c;

    /* renamed from: d */
    public final Rect f12030d;

    /* renamed from: e */
    public final Paint f12031e;

    /* renamed from: f */
    public final Paint f12032f;

    /* renamed from: g */
    public final Paint f12033g;

    /* renamed from: h */
    public final Paint f12034h;

    /* renamed from: i */
    public final Paint f12035i;

    /* renamed from: j */
    public final Paint f12036j;

    /* renamed from: k */
    public final Drawable f12037k;

    /* renamed from: l */
    public final int f12038l;

    /* renamed from: m */
    public final int f12039m;

    /* renamed from: n */
    public final int f12040n;

    /* renamed from: o */
    public final int f12041o;

    /* renamed from: p */
    public final int f12042p;

    /* renamed from: q */
    public final int f12043q;

    /* renamed from: r */
    public final int f12044r;

    /* renamed from: s */
    public final int f12045s;

    /* renamed from: t */
    public final int f12046t;

    /* renamed from: u */
    public final StringBuilder f12047u;

    /* renamed from: v */
    public final Formatter f12048v;

    /* renamed from: w */
    public final RunnableC0006a5 f12049w;

    /* renamed from: x */
    public final CopyOnWriteArraySet f12050x;

    /* renamed from: y */
    public final Point f12051y;

    /* renamed from: z */
    public final float f12052z;

    public DefaultTimeBar(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public static int m2891a(float f, int i) {
        return (int) ((i * f) + 0.5f);
    }

    private long getPositionIncrement() {
        long j = this.f12013B;
        if (j == C0643C.TIME_UNSET) {
            long j2 = this.f12021J;
            if (j2 == C0643C.TIME_UNSET) {
                return 0L;
            }
            return j2 / this.f12012A;
        }
        return j;
    }

    private String getProgressText() {
        return Util.getStringForTime(this.f12047u, this.f12048v, this.f12022K);
    }

    private long getScrubberPosition() {
        if (this.f12028b.width() > 0 && this.f12021J != C0643C.TIME_UNSET) {
            return (this.f12030d.width() * this.f12021J) / r0.width();
        }
        return 0L;
    }

    @Override // com.google.android.exoplayer2.p003ui.TimeBar
    public void addListener(TimeBar.OnScrubListener onScrubListener) {
        Assertions.checkNotNull(onScrubListener);
        this.f12050x.add(onScrubListener);
    }

    /* renamed from: b */
    public final boolean m2892b(long j) {
        long j2;
        long j3 = this.f12021J;
        if (j3 <= 0) {
            return false;
        }
        if (this.f12019H) {
            j2 = this.f12020I;
        } else {
            j2 = this.f12022K;
        }
        long j4 = j2;
        long constrainValue = Util.constrainValue(j4 + j, 0L, j3);
        if (constrainValue == j4) {
            return false;
        }
        if (!this.f12019H) {
            m2893c(constrainValue);
        } else {
            m2896f(constrainValue);
        }
        m2895e();
        return true;
    }

    /* renamed from: c */
    public final void m2893c(long j) {
        this.f12020I = j;
        this.f12019H = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator it = this.f12050x.iterator();
        while (it.hasNext()) {
            ((TimeBar.OnScrubListener) it.next()).onScrubStart(this, j);
        }
    }

    /* renamed from: d */
    public final void m2894d(boolean z) {
        removeCallbacks(this.f12049w);
        this.f12019H = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator it = this.f12050x.iterator();
        while (it.hasNext()) {
            ((TimeBar.OnScrubListener) it.next()).onScrubStop(this, this.f12020I, z);
        }
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f12037k;
        if (drawable != null && drawable.isStateful() && drawable.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* renamed from: e */
    public final void m2895e() {
        long j;
        Rect rect = this.f12029c;
        Rect rect2 = this.f12028b;
        rect.set(rect2);
        Rect rect3 = this.f12030d;
        rect3.set(rect2);
        if (this.f12019H) {
            j = this.f12020I;
        } else {
            j = this.f12022K;
        }
        if (this.f12021J > 0) {
            rect.right = Math.min(rect2.left + ((int) ((rect2.width() * this.f12023L) / this.f12021J)), rect2.right);
            rect3.right = Math.min(rect2.left + ((int) ((rect2.width() * j) / this.f12021J)), rect2.right);
        } else {
            int i = rect2.left;
            rect.right = i;
            rect3.right = i;
        }
        invalidate(this.f12027a);
    }

    /* renamed from: f */
    public final void m2896f(long j) {
        if (this.f12020I == j) {
            return;
        }
        this.f12020I = j;
        Iterator it = this.f12050x.iterator();
        while (it.hasNext()) {
            ((TimeBar.OnScrubListener) it.next()).onScrubMove(this, j);
        }
    }

    @Override // com.google.android.exoplayer2.p003ui.TimeBar
    public long getPreferredUpdateDelay() {
        int width = (int) (this.f12028b.width() / this.f12052z);
        if (width != 0) {
            long j = this.f12021J;
            if (j != 0 && j != C0643C.TIME_UNSET) {
                return j / width;
            }
        }
        return Long.MAX_VALUE;
    }

    public void hideScrubber(boolean z) {
        ValueAnimator valueAnimator = this.f12016E;
        if (valueAnimator.isStarted()) {
            valueAnimator.cancel();
        }
        this.f12018G = z;
        this.f12017F = RecyclerView.f7068F0;
        invalidate(this.f12027a);
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f12037k;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Paint paint;
        int i;
        canvas.save();
        Rect rect = this.f12028b;
        int height = rect.height();
        int centerY = rect.centerY() - (height / 2);
        int i2 = centerY + height;
        long j = this.f12021J;
        Paint paint2 = this.f12033g;
        Rect rect2 = this.f12030d;
        if (j <= 0) {
            canvas.drawRect(rect.left, centerY, rect.right, i2, paint2);
        } else {
            Rect rect3 = this.f12029c;
            int i3 = rect3.left;
            int i4 = rect3.right;
            int max = Math.max(Math.max(rect.left, i4), rect2.right);
            int i5 = rect.right;
            if (max < i5) {
                canvas.drawRect(max, centerY, i5, i2, paint2);
            }
            int max2 = Math.max(i3, rect2.right);
            if (i4 > max2) {
                canvas.drawRect(max2, centerY, i4, i2, this.f12032f);
            }
            if (rect2.width() > 0) {
                canvas.drawRect(rect2.left, centerY, rect2.right, i2, this.f12031e);
            }
            if (this.f12024M != 0) {
                long[] jArr = (long[]) Assertions.checkNotNull(this.f12025N);
                boolean[] zArr = (boolean[]) Assertions.checkNotNull(this.f12026O);
                int i6 = this.f12041o;
                int i7 = i6 / 2;
                int i8 = 0;
                int i9 = 0;
                while (i9 < this.f12024M) {
                    int min = Math.min(rect.width() - i6, Math.max(i8, ((int) ((rect.width() * Util.constrainValue(jArr[i9], 0L, this.f12021J)) / this.f12021J)) - i7)) + rect.left;
                    if (zArr[i9]) {
                        paint = this.f12035i;
                    } else {
                        paint = this.f12034h;
                    }
                    canvas.drawRect(min, centerY, min + i6, i2, paint);
                    i9++;
                    i8 = i8;
                    i6 = i6;
                }
            }
        }
        if (this.f12021J > 0) {
            int constrainValue = Util.constrainValue(rect2.right, rect2.left, rect.right);
            int centerY2 = rect2.centerY();
            Drawable drawable = this.f12037k;
            if (drawable == null) {
                if (!this.f12019H && !isFocused()) {
                    if (isEnabled()) {
                        i = this.f12042p;
                    } else {
                        i = this.f12043q;
                    }
                } else {
                    i = this.f12044r;
                }
                canvas.drawCircle(constrainValue, centerY2, (int) ((i * this.f12017F) / 2.0f), this.f12036j);
            } else {
                int intrinsicWidth = ((int) (drawable.getIntrinsicWidth() * this.f12017F)) / 2;
                int intrinsicHeight = ((int) (drawable.getIntrinsicHeight() * this.f12017F)) / 2;
                drawable.setBounds(constrainValue - intrinsicWidth, centerY2 - intrinsicHeight, constrainValue + intrinsicWidth, centerY2 + intrinsicHeight);
                drawable.draw(canvas);
            }
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z, int i, @Nullable Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (this.f12019H && !z) {
            m2894d(false);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName("android.widget.SeekBar");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.f12021J <= 0) {
            return;
        }
        if (Util.SDK_INT >= 21) {
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
        } else {
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (isEnabled()) {
            long positionIncrement = getPositionIncrement();
            if (i != 66) {
                switch (i) {
                    case 21:
                        positionIncrement = -positionIncrement;
                        if (m2892b(positionIncrement)) {
                            RunnableC0006a5 runnableC0006a5 = this.f12049w;
                            removeCallbacks(runnableC0006a5);
                            postDelayed(runnableC0006a5, 1000L);
                            return true;
                        }
                        break;
                    case 22:
                        if (m2892b(positionIncrement)) {
                        }
                        break;
                }
            }
            if (this.f12019H) {
                m2894d(false);
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        Rect rect;
        int i8 = i3 - i;
        int i9 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i8 - getPaddingRight();
        if (this.f12018G) {
            i5 = 0;
        } else {
            i5 = this.f12045s;
        }
        int i10 = this.f12040n;
        int i11 = this.f12038l;
        int i12 = this.f12039m;
        if (i10 == 1) {
            i6 = (i9 - getPaddingBottom()) - i12;
            i7 = ((i9 - getPaddingBottom()) - i11) - Math.max(i5 - (i11 / 2), 0);
        } else {
            i6 = (i9 - i12) / 2;
            i7 = (i9 - i11) / 2;
        }
        Rect rect2 = this.f12027a;
        rect2.set(paddingLeft, i6, paddingRight, i12 + i6);
        this.f12028b.set(rect2.left + i5, i7, rect2.right - i5, i11 + i7);
        if (Util.SDK_INT >= 29 && ((rect = this.f12015D) == null || rect.width() != i8 || this.f12015D.height() != i9)) {
            Rect rect3 = new Rect(0, 0, i8, i9);
            this.f12015D = rect3;
            AbstractC1502l8.m5888s(this, Collections.singletonList(rect3));
        }
        m2895e();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int i3 = this.f12039m;
        if (mode == 0) {
            size = i3;
        } else if (mode != 1073741824) {
            size = Math.min(i3, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), size);
        Drawable drawable = this.f12037k;
        if (drawable != null && drawable.isStateful() && drawable.setState(getDrawableState())) {
            invalidate();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        Drawable drawable = this.f12037k;
        if (drawable != null && Util.SDK_INT >= 23 && drawable.setLayoutDirection(i)) {
            invalidate();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0035, code lost:
    
        if (r3 != 3) goto L34;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (isEnabled() && this.f12021J > 0) {
            Point point = this.f12051y;
            point.set((int) motionEvent.getX(), (int) motionEvent.getY());
            int i = point.x;
            int i2 = point.y;
            int action = motionEvent.getAction();
            Rect rect = this.f12030d;
            Rect rect2 = this.f12028b;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if (this.f12019H) {
                            if (i2 < this.f12046t) {
                                int i3 = this.f12014C;
                                rect.right = Util.constrainValue(((i - i3) / 3) + i3, rect2.left, rect2.right);
                            } else {
                                this.f12014C = i;
                                rect.right = Util.constrainValue(i, rect2.left, rect2.right);
                            }
                            m2896f(getScrubberPosition());
                            m2895e();
                            invalidate();
                            return true;
                        }
                    }
                }
                if (this.f12019H) {
                    if (motionEvent.getAction() == 3) {
                        z = true;
                    }
                    m2894d(z);
                    return true;
                }
            } else {
                int i4 = i;
                if (this.f12027a.contains(i4, i2)) {
                    rect.right = Util.constrainValue(i4, rect2.left, rect2.right);
                    m2893c(getScrubberPosition());
                    m2895e();
                    invalidate();
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, @Nullable Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        if (this.f12021J <= 0) {
            return false;
        }
        if (i == 8192) {
            if (m2892b(-getPositionIncrement())) {
                m2894d(false);
            }
        } else {
            if (i != 4096) {
                return false;
            }
            if (m2892b(getPositionIncrement())) {
                m2894d(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    @Override // com.google.android.exoplayer2.p003ui.TimeBar
    public void removeListener(TimeBar.OnScrubListener onScrubListener) {
        this.f12050x.remove(onScrubListener);
    }

    @Override // com.google.android.exoplayer2.p003ui.TimeBar
    public void setAdGroupTimesMs(@Nullable long[] jArr, @Nullable boolean[] zArr, int i) {
        boolean z;
        if (i != 0 && (jArr == null || zArr == null)) {
            z = false;
        } else {
            z = true;
        }
        Assertions.checkArgument(z);
        this.f12024M = i;
        this.f12025N = jArr;
        this.f12026O = zArr;
        m2895e();
    }

    public void setAdMarkerColor(@ColorInt int i) {
        this.f12034h.setColor(i);
        invalidate(this.f12027a);
    }

    public void setBufferedColor(@ColorInt int i) {
        this.f12032f.setColor(i);
        invalidate(this.f12027a);
    }

    @Override // com.google.android.exoplayer2.p003ui.TimeBar
    public void setBufferedPosition(long j) {
        if (this.f12023L == j) {
            return;
        }
        this.f12023L = j;
        m2895e();
    }

    @Override // com.google.android.exoplayer2.p003ui.TimeBar
    public void setDuration(long j) {
        if (this.f12021J == j) {
            return;
        }
        this.f12021J = j;
        if (this.f12019H && j == C0643C.TIME_UNSET) {
            m2894d(true);
        }
        m2895e();
    }

    @Override // android.view.View, com.google.android.exoplayer2.p003ui.TimeBar
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.f12019H && !z) {
            m2894d(true);
        }
    }

    @Override // com.google.android.exoplayer2.p003ui.TimeBar
    public void setKeyCountIncrement(int i) {
        boolean z;
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        this.f12012A = i;
        this.f12013B = C0643C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.p003ui.TimeBar
    public void setKeyTimeIncrement(long j) {
        boolean z;
        if (j > 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        this.f12012A = -1;
        this.f12013B = j;
    }

    public void setPlayedAdMarkerColor(@ColorInt int i) {
        this.f12035i.setColor(i);
        invalidate(this.f12027a);
    }

    public void setPlayedColor(@ColorInt int i) {
        this.f12031e.setColor(i);
        invalidate(this.f12027a);
    }

    @Override // com.google.android.exoplayer2.p003ui.TimeBar
    public void setPosition(long j) {
        if (this.f12022K == j) {
            return;
        }
        this.f12022K = j;
        setContentDescription(getProgressText());
        m2895e();
    }

    public void setScrubberColor(@ColorInt int i) {
        this.f12036j.setColor(i);
        invalidate(this.f12027a);
    }

    public void setUnplayedColor(@ColorInt int i) {
        this.f12033g.setColor(i);
        invalidate(this.f12027a);
    }

    public void showScrubber() {
        ValueAnimator valueAnimator = this.f12016E;
        if (valueAnimator.isStarted()) {
            valueAnimator.cancel();
        }
        this.f12018G = false;
        this.f12017F = 1.0f;
        invalidate(this.f12027a);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, attributeSet);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i, @Nullable AttributeSet attributeSet2) {
        this(context, attributeSet, i, attributeSet2, 0);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i, @Nullable AttributeSet attributeSet2, int i2) {
        super(context, attributeSet, i);
        this.f12027a = new Rect();
        this.f12028b = new Rect();
        this.f12029c = new Rect();
        this.f12030d = new Rect();
        Paint paint = new Paint();
        this.f12031e = paint;
        Paint paint2 = new Paint();
        this.f12032f = paint2;
        Paint paint3 = new Paint();
        this.f12033g = paint3;
        Paint paint4 = new Paint();
        this.f12034h = paint4;
        Paint paint5 = new Paint();
        this.f12035i = paint5;
        Paint paint6 = new Paint();
        this.f12036j = paint6;
        paint6.setAntiAlias(true);
        this.f12050x = new CopyOnWriteArraySet();
        this.f12051y = new Point();
        float f = context.getResources().getDisplayMetrics().density;
        this.f12052z = f;
        this.f12046t = m2891a(f, -50);
        int m2891a = m2891a(f, 4);
        int m2891a2 = m2891a(f, 26);
        int m2891a3 = m2891a(f, 4);
        int m2891a4 = m2891a(f, 12);
        int m2891a5 = m2891a(f, 0);
        int m2891a6 = m2891a(f, 16);
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R.styleable.DefaultTimeBar, i, i2);
            try {
                Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.DefaultTimeBar_scrubber_drawable);
                this.f12037k = drawable;
                if (drawable != null) {
                    int i3 = Util.SDK_INT;
                    if (i3 >= 23) {
                        int layoutDirection = getLayoutDirection();
                        if (i3 < 23 || !drawable.setLayoutDirection(layoutDirection)) {
                        }
                    }
                    m2891a2 = Math.max(drawable.getMinimumHeight(), m2891a2);
                }
                this.f12038l = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_bar_height, m2891a);
                this.f12039m = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_touch_target_height, m2891a2);
                this.f12040n = obtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_bar_gravity, 0);
                this.f12041o = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_ad_marker_width, m2891a3);
                this.f12042p = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_scrubber_enabled_size, m2891a4);
                this.f12043q = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_scrubber_disabled_size, m2891a5);
                this.f12044r = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_scrubber_dragged_size, m2891a6);
                int i4 = obtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_played_color, -1);
                int i5 = obtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_scrubber_color, -1);
                int i6 = obtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_buffered_color, DEFAULT_BUFFERED_COLOR);
                int i7 = obtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_unplayed_color, DEFAULT_UNPLAYED_COLOR);
                int i8 = obtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_ad_marker_color, DEFAULT_AD_MARKER_COLOR);
                int i9 = obtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_played_ad_marker_color, DEFAULT_PLAYED_AD_MARKER_COLOR);
                paint.setColor(i4);
                paint6.setColor(i5);
                paint2.setColor(i6);
                paint3.setColor(i7);
                paint4.setColor(i8);
                paint5.setColor(i9);
                obtainStyledAttributes.recycle();
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            this.f12038l = m2891a;
            this.f12039m = m2891a2;
            this.f12040n = 0;
            this.f12041o = m2891a3;
            this.f12042p = m2891a4;
            this.f12043q = m2891a5;
            this.f12044r = m2891a6;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(DEFAULT_BUFFERED_COLOR);
            paint3.setColor(DEFAULT_UNPLAYED_COLOR);
            paint4.setColor(DEFAULT_AD_MARKER_COLOR);
            paint5.setColor(DEFAULT_PLAYED_AD_MARKER_COLOR);
            this.f12037k = null;
        }
        StringBuilder sb = new StringBuilder();
        this.f12047u = sb;
        this.f12048v = new Formatter(sb, Locale.getDefault());
        this.f12049w = new RunnableC0006a5(13, this);
        Drawable drawable2 = this.f12037k;
        if (drawable2 != null) {
            this.f12045s = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.f12045s = (Math.max(this.f12043q, Math.max(this.f12042p, this.f12044r)) + 1) / 2;
        }
        this.f12017F = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f12016E = valueAnimator;
        valueAnimator.addUpdateListener(new jf2(this, 2));
        this.f12021J = C0643C.TIME_UNSET;
        this.f12013B = C0643C.TIME_UNSET;
        this.f12012A = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public void hideScrubber(long j) {
        ValueAnimator valueAnimator = this.f12016E;
        if (valueAnimator.isStarted()) {
            valueAnimator.cancel();
        }
        valueAnimator.setFloatValues(this.f12017F, RecyclerView.f7068F0);
        valueAnimator.setDuration(j);
        valueAnimator.start();
    }

    public void showScrubber(long j) {
        ValueAnimator valueAnimator = this.f12016E;
        if (valueAnimator.isStarted()) {
            valueAnimator.cancel();
        }
        this.f12018G = false;
        valueAnimator.setFloatValues(this.f12017F, 1.0f);
        valueAnimator.setDuration(j);
        valueAnimator.start();
    }
}
