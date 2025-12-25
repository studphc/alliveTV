package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewCompat;
import p000.C1341j4;
import p000.C1859u4;
import p000.C1896v4;
import p000.C2007y4;
import p000.ViewOnClickListenerC2044z4;
import p000.ViewTreeObserverOnGlobalLayoutListenerC1933w4;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ActivityChooserView extends ViewGroup implements ActivityChooserModel$ActivityChooserModelClient {

    /* renamed from: a */
    public final C2007y4 f1085a;

    /* renamed from: b */
    public final ViewOnClickListenerC2044z4 f1086b;

    /* renamed from: c */
    public final View f1087c;

    /* renamed from: d */
    public final Drawable f1088d;

    /* renamed from: e */
    public final FrameLayout f1089e;

    /* renamed from: f */
    public final ImageView f1090f;

    /* renamed from: g */
    public final FrameLayout f1091g;

    /* renamed from: h */
    public final ImageView f1092h;

    /* renamed from: i */
    public final int f1093i;

    /* renamed from: j */
    public ActionProvider f1094j;

    /* renamed from: k */
    public final C1896v4 f1095k;

    /* renamed from: l */
    public final ViewTreeObserverOnGlobalLayoutListenerC1933w4 f1096l;

    /* renamed from: m */
    public ListPopupWindow f1097m;

    /* renamed from: n */
    public PopupWindow.OnDismissListener f1098n;

    /* renamed from: o */
    public boolean f1099o;

    /* renamed from: p */
    public int f1100p;

    /* renamed from: q */
    public boolean f1101q;

    /* renamed from: r */
    public int f1102r;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public static class InnerLayout extends LinearLayout {

        /* renamed from: a */
        public static final int[] f1103a = {R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, f1103a);
            setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
            obtainStyledAttributes.recycle();
        }
    }

    public ActivityChooserView(@NonNull Context context) {
        this(context, null);
    }

    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [boolean, int] */
    /* renamed from: a */
    public final void m238a(int i) {
        ?? r1;
        C2007y4 c2007y4 = this.f1085a;
        if (c2007y4.f28829a != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.f1096l);
            if (this.f1091g.getVisibility() == 0) {
                r1 = 1;
            } else {
                r1 = 0;
            }
            int m7537f = c2007y4.f28829a.m7537f();
            if (i != Integer.MAX_VALUE && m7537f > i + r1) {
                if (!c2007y4.f28833e) {
                    c2007y4.f28833e = true;
                    c2007y4.notifyDataSetChanged();
                }
                int i2 = i - 1;
                if (c2007y4.f28830b != i2) {
                    c2007y4.f28830b = i2;
                    c2007y4.notifyDataSetChanged();
                }
            } else {
                if (c2007y4.f28833e) {
                    c2007y4.f28833e = false;
                    c2007y4.notifyDataSetChanged();
                }
                if (c2007y4.f28830b != i) {
                    c2007y4.f28830b = i;
                    c2007y4.notifyDataSetChanged();
                }
            }
            ListPopupWindow listPopupWindow = getListPopupWindow();
            if (!listPopupWindow.isShowing()) {
                if (!this.f1099o && r1 != 0) {
                    if (c2007y4.f28831c || c2007y4.f28832d) {
                        c2007y4.f28831c = false;
                        c2007y4.f28832d = false;
                        c2007y4.notifyDataSetChanged();
                    }
                } else if (!c2007y4.f28831c || c2007y4.f28832d != r1) {
                    c2007y4.f28831c = true;
                    c2007y4.f28832d = r1;
                    c2007y4.notifyDataSetChanged();
                }
                int i3 = c2007y4.f28830b;
                c2007y4.f28830b = Integer.MAX_VALUE;
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                int count = c2007y4.getCount();
                int i4 = 0;
                View view = null;
                for (int i5 = 0; i5 < count; i5++) {
                    view = c2007y4.getView(i5, view, null);
                    view.measure(makeMeasureSpec, makeMeasureSpec2);
                    i4 = Math.max(i4, view.getMeasuredWidth());
                }
                c2007y4.f28830b = i3;
                listPopupWindow.setContentWidth(Math.min(i4, this.f1093i));
                listPopupWindow.show();
                ActionProvider actionProvider = this.f1094j;
                if (actionProvider != null) {
                    actionProvider.subUiVisibilityChanged(true);
                }
                listPopupWindow.getListView().setContentDescription(getContext().getString(androidx.appcompat.R.string.abc_activitychooserview_choose_application));
                listPopupWindow.getListView().setSelector(new ColorDrawable(0));
                return;
            }
            return;
        }
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    public boolean dismissPopup() {
        if (isShowingPopup()) {
            getListPopupWindow().dismiss();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.f1096l);
                return true;
            }
            return true;
        }
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public C1859u4 getDataModel() {
        return this.f1085a.f28829a;
    }

    public ListPopupWindow getListPopupWindow() {
        if (this.f1097m == null) {
            ListPopupWindow listPopupWindow = new ListPopupWindow(getContext());
            this.f1097m = listPopupWindow;
            listPopupWindow.setAdapter(this.f1085a);
            this.f1097m.setAnchorView(this);
            this.f1097m.setModal(true);
            ListPopupWindow listPopupWindow2 = this.f1097m;
            ViewOnClickListenerC2044z4 viewOnClickListenerC2044z4 = this.f1086b;
            listPopupWindow2.setOnItemClickListener(viewOnClickListenerC2044z4);
            this.f1097m.setOnDismissListener(viewOnClickListenerC2044z4);
        }
        return this.f1097m;
    }

    public boolean isShowingPopup() {
        return getListPopupWindow().isShowing();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C1859u4 c1859u4 = this.f1085a.f28829a;
        if (c1859u4 != null) {
            c1859u4.registerObserver(this.f1095k);
        }
        this.f1101q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C1859u4 c1859u4 = this.f1085a.f28829a;
        if (c1859u4 != null) {
            c1859u4.unregisterObserver(this.f1095k);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1096l);
        }
        if (isShowingPopup()) {
            dismissPopup();
        }
        this.f1101q = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f1087c.layout(0, 0, i3 - i, i4 - i2);
        if (!isShowingPopup()) {
            dismissPopup();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f1091g.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
        }
        View view = this.f1087c;
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // androidx.appcompat.widget.ActivityChooserModel$ActivityChooserModelClient
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setActivityChooserModel(C1859u4 c1859u4) {
        C2007y4 c2007y4 = this.f1085a;
        ActivityChooserView activityChooserView = c2007y4.f28834f;
        C1859u4 c1859u42 = activityChooserView.f1085a.f28829a;
        C1896v4 c1896v4 = activityChooserView.f1095k;
        if (c1859u42 != null && activityChooserView.isShown()) {
            c1859u42.unregisterObserver(c1896v4);
        }
        c2007y4.f28829a = c1859u4;
        if (c1859u4 != null && activityChooserView.isShown()) {
            c1859u4.registerObserver(c1896v4);
        }
        c2007y4.notifyDataSetChanged();
        if (isShowingPopup()) {
            dismissPopup();
            showPopup();
        }
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.f1102r = i;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f1090f.setContentDescription(getContext().getString(i));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f1090f.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i) {
        this.f1100p = i;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f1098n = onDismissListener;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setProvider(ActionProvider actionProvider) {
        this.f1094j = actionProvider;
    }

    public boolean showPopup() {
        if (isShowingPopup() || !this.f1101q) {
            return false;
        }
        this.f1099o = false;
        m238a(this.f1100p);
        return true;
    }

    public ActivityChooserView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2 = 0;
        this.f1095k = new C1896v4(this, i2);
        this.f1096l = new ViewTreeObserverOnGlobalLayoutListenerC1933w4(i2, this);
        this.f1100p = 4;
        int[] iArr = androidx.appcompat.R.styleable.ActivityChooserView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes, i, 0);
        this.f1100p = obtainStyledAttributes.getInt(androidx.appcompat.R.styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(androidx.appcompat.R.layout.abc_activity_chooser_view, (ViewGroup) this, true);
        ViewOnClickListenerC2044z4 viewOnClickListenerC2044z4 = new ViewOnClickListenerC2044z4(this);
        this.f1086b = viewOnClickListenerC2044z4;
        View findViewById = findViewById(androidx.appcompat.R.id.activity_chooser_view_content);
        this.f1087c = findViewById;
        this.f1088d = findViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(androidx.appcompat.R.id.default_activity_button);
        this.f1091g = frameLayout;
        frameLayout.setOnClickListener(viewOnClickListenerC2044z4);
        frameLayout.setOnLongClickListener(viewOnClickListenerC2044z4);
        int i3 = androidx.appcompat.R.id.image;
        this.f1092h = (ImageView) frameLayout.findViewById(i3);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(androidx.appcompat.R.id.expand_activities_button);
        frameLayout2.setOnClickListener(viewOnClickListenerC2044z4);
        frameLayout2.setAccessibilityDelegate(new View.AccessibilityDelegate());
        frameLayout2.setOnTouchListener(new C1341j4(this, frameLayout2, 1));
        this.f1089e = frameLayout2;
        ImageView imageView = (ImageView) frameLayout2.findViewById(i3);
        this.f1090f = imageView;
        imageView.setImageDrawable(drawable);
        C2007y4 c2007y4 = new C2007y4(this);
        this.f1085a = c2007y4;
        c2007y4.registerDataSetObserver(new C1896v4(this, 1));
        Resources resources = context.getResources();
        this.f1093i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(androidx.appcompat.R.dimen.abc_config_prefDialogWidth));
    }
}
