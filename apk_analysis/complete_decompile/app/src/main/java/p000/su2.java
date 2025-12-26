package p000;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import com.google.android.exoplayer2.C0643C;

/* loaded from: classes.dex */
public final class su2 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: k */
    public static su2 f26569k;

    /* renamed from: l */
    public static su2 f26570l;

    /* renamed from: a */
    public final View f26571a;

    /* renamed from: b */
    public final CharSequence f26572b;

    /* renamed from: c */
    public final int f26573c;

    /* renamed from: d */
    public final ru2 f26574d;

    /* renamed from: e */
    public final ru2 f26575e;

    /* renamed from: f */
    public int f26576f;

    /* renamed from: g */
    public int f26577g;

    /* renamed from: h */
    public tu2 f26578h;

    /* renamed from: i */
    public boolean f26579i;

    /* renamed from: j */
    public boolean f26580j = true;

    /* JADX WARN: Type inference failed for: r0v0, types: [ru2] */
    /* JADX WARN: Type inference failed for: r0v1, types: [ru2] */
    public su2(View view, CharSequence charSequence) {
        final int i = 0;
        this.f26574d = new Runnable(this) { // from class: ru2

            /* renamed from: b */
            public final /* synthetic */ su2 f26156b;

            {
                this.f26156b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i) {
                    case 0:
                        this.f26156b.m7417c(false);
                        return;
                    default:
                        this.f26156b.m7416a();
                        return;
                }
            }
        };
        final int i2 = 1;
        this.f26575e = new Runnable(this) { // from class: ru2

            /* renamed from: b */
            public final /* synthetic */ su2 f26156b;

            {
                this.f26156b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i2) {
                    case 0:
                        this.f26156b.m7417c(false);
                        return;
                    default:
                        this.f26156b.m7416a();
                        return;
                }
            }
        };
        this.f26571a = view;
        this.f26572b = charSequence;
        this.f26573c = ViewConfigurationCompat.getScaledHoverSlop(ViewConfiguration.get(view.getContext()));
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    /* renamed from: b */
    public static void m7415b(su2 su2Var) {
        su2 su2Var2 = f26569k;
        if (su2Var2 != null) {
            su2Var2.f26571a.removeCallbacks(su2Var2.f26574d);
        }
        f26569k = su2Var;
        if (su2Var != null) {
            su2Var.f26571a.postDelayed(su2Var.f26574d, ViewConfiguration.getLongPressTimeout());
        }
    }

    /* renamed from: a */
    public final void m7416a() {
        su2 su2Var = f26570l;
        View view = this.f26571a;
        if (su2Var == this) {
            f26570l = null;
            tu2 tu2Var = this.f26578h;
            if (tu2Var != null) {
                View view2 = tu2Var.f26967b;
                if (view2.getParent() != null) {
                    ((WindowManager) tu2Var.f26966a.getSystemService("window")).removeView(view2);
                }
                this.f26578h = null;
                this.f26580j = true;
                view.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f26569k == this) {
            m7415b(null);
        }
        view.removeCallbacks(this.f26575e);
    }

    /* renamed from: c */
    public final void m7417c(boolean z) {
        int height;
        int i;
        int i2;
        String str;
        int i3;
        String str2;
        int i4;
        long longPressTimeout;
        long j;
        long j2;
        View view = this.f26571a;
        if (!view.isAttachedToWindow()) {
            return;
        }
        m7415b(null);
        su2 su2Var = f26570l;
        if (su2Var != null) {
            su2Var.m7416a();
        }
        f26570l = this;
        this.f26579i = z;
        tu2 tu2Var = new tu2(view.getContext());
        this.f26578h = tu2Var;
        int i5 = this.f26576f;
        int i6 = this.f26577g;
        boolean z2 = this.f26579i;
        View view2 = tu2Var.f26967b;
        ViewParent parent = view2.getParent();
        Context context = tu2Var.f26966a;
        if (parent != null && view2.getParent() != null) {
            ((WindowManager) context.getSystemService("window")).removeView(view2);
        }
        tu2Var.f26968c.setText(this.f26572b);
        WindowManager.LayoutParams layoutParams = tu2Var.f26969d;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i5 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
            height = i6 + dimensionPixelOffset2;
            i = i6 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i = 0;
        }
        layoutParams.gravity = 49;
        Resources resources = context.getResources();
        if (z2) {
            i2 = R.dimen.tooltip_y_offset_touch;
        } else {
            i2 = R.dimen.tooltip_y_offset_non_touch;
        }
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(i2);
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams2 = rootView.getLayoutParams();
        if (!(layoutParams2 instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams2).type != 2) {
            Context context2 = view.getContext();
            while (true) {
                if (!(context2 instanceof ContextWrapper)) {
                    break;
                }
                if (context2 instanceof Activity) {
                    rootView = ((Activity) context2).getWindow().getDecorView();
                    break;
                }
                context2 = ((ContextWrapper) context2).getBaseContext();
            }
        }
        if (rootView == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            str2 = "window";
        } else {
            Rect rect = tu2Var.f26970e;
            rootView.getWindowVisibleDisplayFrame(rect);
            if (rect.left >= 0 || rect.top >= 0) {
                str = "window";
                i3 = 0;
            } else {
                Resources resources2 = context.getResources();
                str = "window";
                int identifier = resources2.getIdentifier("status_bar_height", "dimen", "android");
                if (identifier != 0) {
                    i4 = resources2.getDimensionPixelSize(identifier);
                } else {
                    i4 = 0;
                }
                DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
                i3 = 0;
                rect.set(0, i4, displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
            int[] iArr = tu2Var.f26972g;
            rootView.getLocationOnScreen(iArr);
            int[] iArr2 = tu2Var.f26971f;
            view.getLocationOnScreen(iArr2);
            int i7 = iArr2[i3] - iArr[i3];
            iArr2[i3] = i7;
            iArr2[1] = iArr2[1] - iArr[1];
            layoutParams.x = (i7 + i5) - (rootView.getWidth() / 2);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, i3);
            view2.measure(makeMeasureSpec, makeMeasureSpec);
            int measuredHeight = view2.getMeasuredHeight();
            int i8 = iArr2[1];
            int i9 = ((i + i8) - dimensionPixelOffset3) - measuredHeight;
            int i10 = i8 + height + dimensionPixelOffset3;
            if (z2) {
                if (i9 >= 0) {
                    layoutParams.y = i9;
                } else {
                    layoutParams.y = i10;
                }
            } else if (measuredHeight + i10 <= rect.height()) {
                layoutParams.y = i10;
            } else {
                layoutParams.y = i9;
            }
            str2 = str;
        }
        ((WindowManager) context.getSystemService(str2)).addView(view2, layoutParams);
        view.addOnAttachStateChangeListener(this);
        if (this.f26579i) {
            j2 = 2500;
        } else {
            if ((ViewCompat.getWindowSystemUiVisibility(view) & 1) == 1) {
                longPressTimeout = ViewConfiguration.getLongPressTimeout();
                j = C0643C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
            } else {
                longPressTimeout = ViewConfiguration.getLongPressTimeout();
                j = C0643C.DEFAULT_SEEK_FORWARD_INCREMENT_MS;
            }
            j2 = j - longPressTimeout;
        }
        ru2 ru2Var = this.f26575e;
        view.removeCallbacks(ru2Var);
        view.postDelayed(ru2Var, j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0064, code lost:
    
        if (java.lang.Math.abs(r5 - r3.f26577g) <= r2) goto L29;
     */
    @Override // android.view.View.OnHoverListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f26578h != null && this.f26579i) {
            return false;
        }
        View view2 = this.f26571a;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view2.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                this.f26580j = true;
                m7416a();
            }
        } else if (view2.isEnabled() && this.f26578h == null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (!this.f26580j) {
                int abs = Math.abs(x - this.f26576f);
                int i = this.f26573c;
                if (abs <= i) {
                }
            }
            this.f26576f = x;
            this.f26577g = y;
            this.f26580j = false;
            m7415b(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.f26576f = view.getWidth() / 2;
        this.f26577g = view.getHeight() / 2;
        m7417c(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        m7416a();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
