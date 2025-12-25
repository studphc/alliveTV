package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.widget.PopupWindowCompat;
import java.lang.reflect.Method;
import p000.C1341j4;
import p000.e70;
import p000.k91;
import p000.l91;
import p000.m91;
import p000.n91;
import p000.o91;
import p000.p91;
import p000.q91;

/* loaded from: classes.dex */
public class ListPopupWindow implements ShowableListMenu {

    /* renamed from: G */
    public static final Method f1288G;

    /* renamed from: H */
    public static final Method f1289H;

    /* renamed from: I */
    public static final Method f1290I;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int MATCH_PARENT = -1;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    public static final int WRAP_CONTENT = -2;

    /* renamed from: A */
    public k91 f1291A;

    /* renamed from: B */
    public final Handler f1292B;

    /* renamed from: C */
    public final Rect f1293C;

    /* renamed from: D */
    public Rect f1294D;

    /* renamed from: E */
    public boolean f1295E;

    /* renamed from: F */
    public final PopupWindow f1296F;

    /* renamed from: a */
    public final Context f1297a;

    /* renamed from: b */
    public ListAdapter f1298b;

    /* renamed from: c */
    public e70 f1299c;

    /* renamed from: d */
    public int f1300d;

    /* renamed from: e */
    public int f1301e;

    /* renamed from: f */
    public int f1302f;

    /* renamed from: g */
    public int f1303g;

    /* renamed from: h */
    public int f1304h;

    /* renamed from: i */
    public boolean f1305i;

    /* renamed from: j */
    public boolean f1306j;

    /* renamed from: k */
    public boolean f1307k;

    /* renamed from: l */
    public int f1308l;

    /* renamed from: m */
    public boolean f1309m;

    /* renamed from: n */
    public boolean f1310n;

    /* renamed from: o */
    public final int f1311o;

    /* renamed from: p */
    public View f1312p;

    /* renamed from: q */
    public int f1313q;

    /* renamed from: r */
    public o91 f1314r;

    /* renamed from: s */
    public View f1315s;

    /* renamed from: t */
    public Drawable f1316t;

    /* renamed from: u */
    public AdapterView.OnItemClickListener f1317u;

    /* renamed from: v */
    public AdapterView.OnItemSelectedListener f1318v;

    /* renamed from: w */
    public final k91 f1319w;

    /* renamed from: x */
    public final q91 f1320x;

    /* renamed from: y */
    public final p91 f1321y;

    /* renamed from: z */
    public final k91 f1322z;

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                f1288G = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                f1290I = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                f1289H = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public ListPopupWindow(@NonNull Context context) {
        this(context, null, R.attr.listPopupWindowStyle);
    }

    public void clearListSelection() {
        e70 e70Var = this.f1299c;
        if (e70Var != null) {
            e70Var.setListSelectionHidden(true);
            e70Var.requestLayout();
        }
    }

    public View.OnTouchListener createDragToOpenListener(View view) {
        return new C1341j4(this, view, 2);
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        PopupWindow popupWindow = this.f1296F;
        popupWindow.dismiss();
        View view = this.f1312p;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1312p);
            }
        }
        popupWindow.setContentView(null);
        this.f1299c = null;
        this.f1292B.removeCallbacks(this.f1319w);
    }

    /* renamed from: e */
    public e70 mo251e(Context context, boolean z) {
        return new e70(context, z);
    }

    @Nullable
    public View getAnchorView() {
        return this.f1315s;
    }

    @StyleRes
    public int getAnimationStyle() {
        return this.f1296F.getAnimationStyle();
    }

    @Nullable
    public Drawable getBackground() {
        return this.f1296F.getBackground();
    }

    @Nullable
    public Rect getEpicenterBounds() {
        if (this.f1294D != null) {
            return new Rect(this.f1294D);
        }
        return null;
    }

    public int getHeight() {
        return this.f1300d;
    }

    public int getHorizontalOffset() {
        return this.f1302f;
    }

    public int getInputMethodMode() {
        return this.f1296F.getInputMethodMode();
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    @Nullable
    public ListView getListView() {
        return this.f1299c;
    }

    public int getPromptPosition() {
        return this.f1313q;
    }

    @Nullable
    public Object getSelectedItem() {
        if (!isShowing()) {
            return null;
        }
        return this.f1299c.getSelectedItem();
    }

    public long getSelectedItemId() {
        if (!isShowing()) {
            return Long.MIN_VALUE;
        }
        return this.f1299c.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        if (!isShowing()) {
            return -1;
        }
        return this.f1299c.getSelectedItemPosition();
    }

    @Nullable
    public View getSelectedView() {
        if (!isShowing()) {
            return null;
        }
        return this.f1299c.getSelectedView();
    }

    public int getSoftInputMode() {
        return this.f1296F.getSoftInputMode();
    }

    public int getVerticalOffset() {
        if (!this.f1305i) {
            return 0;
        }
        return this.f1303g;
    }

    public int getWidth() {
        return this.f1301e;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isDropDownAlwaysVisible() {
        return this.f1309m;
    }

    public boolean isInputMethodNotNeeded() {
        if (this.f1296F.getInputMethodMode() == 2) {
            return true;
        }
        return false;
    }

    public boolean isModal() {
        return this.f1295E;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        return this.f1296F.isShowing();
    }

    public boolean onKeyDown(int i, @NonNull KeyEvent keyEvent) {
        int i2;
        int i3;
        if (isShowing() && i != 62 && (this.f1299c.getSelectedItemPosition() >= 0 || (i != 66 && i != 23))) {
            int selectedItemPosition = this.f1299c.getSelectedItemPosition();
            PopupWindow popupWindow = this.f1296F;
            boolean isAboveAnchor = popupWindow.isAboveAnchor();
            ListAdapter listAdapter = this.f1298b;
            if (listAdapter != null) {
                boolean areAllItemsEnabled = listAdapter.areAllItemsEnabled();
                if (areAllItemsEnabled) {
                    i2 = 0;
                } else {
                    i2 = this.f1299c.lookForSelectablePosition(0, true);
                }
                if (areAllItemsEnabled) {
                    i3 = listAdapter.getCount() - 1;
                } else {
                    i3 = this.f1299c.lookForSelectablePosition(listAdapter.getCount() - 1, false);
                }
            } else {
                i2 = Integer.MAX_VALUE;
                i3 = Integer.MIN_VALUE;
            }
            if ((!isAboveAnchor && i == 19 && selectedItemPosition <= i2) || (isAboveAnchor && i == 20 && selectedItemPosition >= i3)) {
                clearListSelection();
                popupWindow.setInputMethodMode(1);
                show();
                return true;
            }
            this.f1299c.setListSelectionHidden(false);
            if (this.f1299c.onKeyDown(i, keyEvent)) {
                popupWindow.setInputMethodMode(2);
                this.f1299c.requestFocusFromTouch();
                show();
                if (i == 19 || i == 20 || i == 23 || i == 66) {
                    return true;
                }
            } else if (!isAboveAnchor && i == 20) {
                if (selectedItemPosition == i3) {
                    return true;
                }
            } else if (isAboveAnchor && i == 19 && selectedItemPosition == i2) {
                return true;
            }
        }
        return false;
    }

    public boolean onKeyPreIme(int i, @NonNull KeyEvent keyEvent) {
        if (i == 4 && isShowing()) {
            View view = this.f1315s;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                KeyEvent.DispatcherState keyDispatcherState = view.getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.startTracking(keyEvent, this);
                }
                return true;
            }
            if (keyEvent.getAction() == 1) {
                KeyEvent.DispatcherState keyDispatcherState2 = view.getKeyDispatcherState();
                if (keyDispatcherState2 != null) {
                    keyDispatcherState2.handleUpEvent(keyEvent);
                }
                if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                    dismiss();
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public boolean onKeyUp(int i, @NonNull KeyEvent keyEvent) {
        if (isShowing() && this.f1299c.getSelectedItemPosition() >= 0) {
            boolean onKeyUp = this.f1299c.onKeyUp(i, keyEvent);
            if (onKeyUp && (i == 66 || i == 23)) {
                dismiss();
            }
            return onKeyUp;
        }
        return false;
    }

    public boolean performItemClick(int i) {
        if (isShowing()) {
            if (this.f1317u != null) {
                e70 e70Var = this.f1299c;
                this.f1317u.onItemClick(e70Var, e70Var.getChildAt(i - e70Var.getFirstVisiblePosition()), i, e70Var.getAdapter().getItemId(i));
                return true;
            }
            return true;
        }
        return false;
    }

    public void postShow() {
        this.f1292B.post(this.f1291A);
    }

    public void setAdapter(@Nullable ListAdapter listAdapter) {
        o91 o91Var = this.f1314r;
        if (o91Var == null) {
            this.f1314r = new o91(0, this);
        } else {
            ListAdapter listAdapter2 = this.f1298b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(o91Var);
            }
        }
        this.f1298b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f1314r);
        }
        e70 e70Var = this.f1299c;
        if (e70Var != null) {
            e70Var.setAdapter(this.f1298b);
        }
    }

    public void setAnchorView(@Nullable View view) {
        this.f1315s = view;
    }

    public void setAnimationStyle(@StyleRes int i) {
        this.f1296F.setAnimationStyle(i);
    }

    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        this.f1296F.setBackgroundDrawable(drawable);
    }

    public void setContentWidth(int i) {
        Drawable background = this.f1296F.getBackground();
        if (background != null) {
            Rect rect = this.f1293C;
            background.getPadding(rect);
            this.f1301e = rect.left + rect.right + i;
            return;
        }
        setWidth(i);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setDropDownAlwaysVisible(boolean z) {
        this.f1309m = z;
    }

    public void setDropDownGravity(int i) {
        this.f1308l = i;
    }

    public void setEpicenterBounds(@Nullable Rect rect) {
        Rect rect2;
        if (rect != null) {
            rect2 = new Rect(rect);
        } else {
            rect2 = null;
        }
        this.f1294D = rect2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setForceIgnoreOutsideTouch(boolean z) {
        this.f1310n = z;
    }

    public void setHeight(int i) {
        if (i < 0 && -2 != i && -1 != i) {
            throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
        }
        this.f1300d = i;
    }

    public void setHorizontalOffset(int i) {
        this.f1302f = i;
    }

    public void setInputMethodMode(int i) {
        this.f1296F.setInputMethodMode(i);
    }

    public void setListSelector(Drawable drawable) {
        this.f1316t = drawable;
    }

    public void setModal(boolean z) {
        this.f1295E = z;
        this.f1296F.setFocusable(z);
    }

    public void setOnDismissListener(@Nullable PopupWindow.OnDismissListener onDismissListener) {
        this.f1296F.setOnDismissListener(onDismissListener);
    }

    public void setOnItemClickListener(@Nullable AdapterView.OnItemClickListener onItemClickListener) {
        this.f1317u = onItemClickListener;
    }

    public void setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f1318v = onItemSelectedListener;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setOverlapAnchor(boolean z) {
        this.f1307k = true;
        this.f1306j = z;
    }

    public void setPromptPosition(int i) {
        this.f1313q = i;
    }

    public void setPromptView(@Nullable View view) {
        View view2;
        boolean isShowing = isShowing();
        if (isShowing && (view2 = this.f1312p) != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1312p);
            }
        }
        this.f1312p = view;
        if (isShowing) {
            show();
        }
    }

    public void setSelection(int i) {
        e70 e70Var = this.f1299c;
        if (isShowing() && e70Var != null) {
            e70Var.setListSelectionHidden(false);
            e70Var.setSelection(i);
            if (e70Var.getChoiceMode() != 0) {
                e70Var.setItemChecked(i, true);
            }
        }
    }

    public void setSoftInputMode(int i) {
        this.f1296F.setSoftInputMode(i);
    }

    public void setVerticalOffset(int i) {
        this.f1303g = i;
        this.f1305i = true;
    }

    public void setWidth(int i) {
        this.f1301e = i;
    }

    public void setWindowLayoutType(int i) {
        this.f1304h = i;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        int i;
        int i2;
        boolean z;
        int m6112a;
        int i3;
        boolean z2;
        int i4;
        int i5;
        int i6;
        int makeMeasureSpec;
        int i7;
        boolean z3 = true;
        e70 e70Var = this.f1299c;
        PopupWindow popupWindow = this.f1296F;
        Context context = this.f1297a;
        if (e70Var == null) {
            this.f1291A = new k91(this, 0);
            e70 mo251e = mo251e(context, !this.f1295E);
            this.f1299c = mo251e;
            Drawable drawable = this.f1316t;
            if (drawable != null) {
                mo251e.setSelector(drawable);
            }
            this.f1299c.setAdapter(this.f1298b);
            this.f1299c.setOnItemClickListener(this.f1317u);
            this.f1299c.setFocusable(true);
            this.f1299c.setFocusableInTouchMode(true);
            this.f1299c.setOnItemSelectedListener(new l91(0, this));
            this.f1299c.setOnScrollListener(this.f1321y);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f1318v;
            if (onItemSelectedListener != null) {
                this.f1299c.setOnItemSelectedListener(onItemSelectedListener);
            }
            View view = this.f1299c;
            View view2 = this.f1312p;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i8 = this.f1313q;
                if (i8 != 0) {
                    if (i8 != 1) {
                        Log.e("ListPopupWindow", "Invalid hint position " + this.f1313q);
                    } else {
                        linearLayout.addView(view, layoutParams);
                        linearLayout.addView(view2);
                    }
                } else {
                    linearLayout.addView(view2);
                    linearLayout.addView(view, layoutParams);
                }
                int i9 = this.f1301e;
                if (i9 >= 0) {
                    i7 = Integer.MIN_VALUE;
                } else {
                    i9 = 0;
                    i7 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i9, i7), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                i = 0;
            }
            popupWindow.setContentView(view);
        } else {
            View view3 = this.f1312p;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                i = layoutParams3.bottomMargin + view3.getMeasuredHeight() + layoutParams3.topMargin;
            } else {
                i = 0;
            }
        }
        Drawable background = popupWindow.getBackground();
        Rect rect = this.f1293C;
        if (background != null) {
            background.getPadding(rect);
            int i10 = rect.top;
            i2 = rect.bottom + i10;
            if (!this.f1305i) {
                this.f1303g = -i10;
            }
        } else {
            rect.setEmpty();
            i2 = 0;
        }
        if (popupWindow.getInputMethodMode() == 2) {
            z = true;
        } else {
            z = false;
        }
        View anchorView = getAnchorView();
        int i11 = this.f1303g;
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = f1289H;
            if (method != null) {
                try {
                    m6112a = ((Integer) method.invoke(popupWindow, anchorView, Integer.valueOf(i11), Boolean.valueOf(z))).intValue();
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                }
            }
            m6112a = popupWindow.getMaxAvailableHeight(anchorView, i11);
        } else {
            m6112a = m91.m6112a(popupWindow, anchorView, i11, z);
        }
        if (!this.f1309m && this.f1300d != -1) {
            int i12 = this.f1301e;
            if (i12 != -2) {
                if (i12 != -1) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
                } else {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824);
                }
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE);
            }
            int measureHeightOfChildrenCompat = this.f1299c.measureHeightOfChildrenCompat(makeMeasureSpec, 0, -1, m6112a - i, -1);
            if (measureHeightOfChildrenCompat > 0) {
                i += this.f1299c.getPaddingBottom() + this.f1299c.getPaddingTop() + i2;
            }
            i3 = measureHeightOfChildrenCompat + i;
        } else {
            i3 = m6112a + i2;
        }
        int i13 = i3;
        boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
        PopupWindowCompat.setWindowLayoutType(popupWindow, this.f1304h);
        if (popupWindow.isShowing()) {
            if (!getAnchorView().isAttachedToWindow()) {
                return;
            }
            int i14 = this.f1301e;
            if (i14 == -1) {
                i14 = -1;
            } else if (i14 == -2) {
                i14 = getAnchorView().getWidth();
            }
            int i15 = this.f1300d;
            if (i15 == -1) {
                if (!isInputMethodNotNeeded) {
                    i13 = -1;
                }
                if (isInputMethodNotNeeded) {
                    if (this.f1301e == -1) {
                        i6 = -1;
                    } else {
                        i6 = 0;
                    }
                    popupWindow.setWidth(i6);
                    popupWindow.setHeight(0);
                } else {
                    if (this.f1301e == -1) {
                        i5 = -1;
                    } else {
                        i5 = 0;
                    }
                    popupWindow.setWidth(i5);
                    popupWindow.setHeight(-1);
                }
            } else if (i15 != -2) {
                i13 = i15;
            }
            if (this.f1310n || this.f1309m) {
                z3 = false;
            }
            popupWindow.setOutsideTouchable(z3);
            View anchorView2 = getAnchorView();
            int i16 = this.f1302f;
            int i17 = this.f1303g;
            if (i14 < 0) {
                i14 = -1;
            }
            if (i13 < 0) {
                i4 = -1;
            } else {
                i4 = i13;
            }
            popupWindow.update(anchorView2, i16, i17, i14, i4);
            return;
        }
        int i18 = this.f1301e;
        if (i18 == -1) {
            i18 = -1;
        } else if (i18 == -2) {
            i18 = getAnchorView().getWidth();
        }
        int i19 = this.f1300d;
        if (i19 == -1) {
            i13 = -1;
        } else if (i19 != -2) {
            i13 = i19;
        }
        popupWindow.setWidth(i18);
        popupWindow.setHeight(i13);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = f1288G;
            if (method2 != null) {
                try {
                    method2.invoke(popupWindow, Boolean.TRUE);
                } catch (Exception unused2) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            n91.m6323b(popupWindow, true);
        }
        if (!this.f1310n && !this.f1309m) {
            z2 = true;
        } else {
            z2 = false;
        }
        popupWindow.setOutsideTouchable(z2);
        popupWindow.setTouchInterceptor(this.f1320x);
        if (this.f1307k) {
            PopupWindowCompat.setOverlapAnchor(popupWindow, this.f1306j);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method3 = f1290I;
            if (method3 != null) {
                try {
                    method3.invoke(popupWindow, this.f1294D);
                } catch (Exception e) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
                }
            }
        } else {
            n91.m6322a(popupWindow, this.f1294D);
        }
        PopupWindowCompat.showAsDropDown(popupWindow, getAnchorView(), this.f1302f, this.f1303g, this.f1308l);
        this.f1299c.setSelection(-1);
        if (!this.f1295E || this.f1299c.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.f1295E) {
            this.f1292B.post(this.f1322z);
        }
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        this.f1300d = -2;
        this.f1301e = -2;
        this.f1304h = 1002;
        this.f1308l = 0;
        this.f1309m = false;
        this.f1310n = false;
        this.f1311o = Integer.MAX_VALUE;
        this.f1313q = 0;
        this.f1319w = new k91(this, 2);
        this.f1320x = new q91(0, this);
        this.f1321y = new p91(this);
        this.f1322z = new k91(this, 1);
        this.f1293C = new Rect();
        this.f1297a = context;
        this.f1292B = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPopupWindow, i, i2);
        this.f1302f = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.f1303g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f1305i = true;
        }
        obtainStyledAttributes.recycle();
        PopupWindow popupWindow = new PopupWindow(context, attributeSet, i, i2);
        TintTypedArray obtainStyledAttributes2 = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.PopupWindow, i, i2);
        int i3 = R.styleable.PopupWindow_overlapAnchor;
        if (obtainStyledAttributes2.hasValue(i3)) {
            PopupWindowCompat.setOverlapAnchor(popupWindow, obtainStyledAttributes2.getBoolean(i3, false));
        }
        popupWindow.setBackgroundDrawable(obtainStyledAttributes2.getDrawable(R.styleable.PopupWindow_android_popupBackground));
        obtainStyledAttributes2.recycle();
        this.f1296F = popupWindow;
        popupWindow.setInputMethodMode(1);
    }
}
