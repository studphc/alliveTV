package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.MainThread;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.Iterator;
import p000.AbstractC1497l3;
import p000.ViewOnClickListenerC1109d4;
import p000.fd2;
import p000.iu2;
import p000.ju2;
import p000.ku2;
import p000.sn1;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup implements MenuHost {

    /* renamed from: A */
    public ColorStateList f1496A;

    /* renamed from: B */
    public boolean f1497B;

    /* renamed from: C */
    public boolean f1498C;

    /* renamed from: D */
    public final ArrayList f1499D;

    /* renamed from: E */
    public final ArrayList f1500E;

    /* renamed from: F */
    public final int[] f1501F;

    /* renamed from: G */
    public final MenuHostHelper f1502G;

    /* renamed from: H */
    public ArrayList f1503H;

    /* renamed from: I */
    public OnMenuItemClickListener f1504I;

    /* renamed from: J */
    public final C0107p f1505J;

    /* renamed from: K */
    public ToolbarWidgetWrapper f1506K;

    /* renamed from: L */
    public C0095d f1507L;

    /* renamed from: M */
    public C0108q f1508M;

    /* renamed from: N */
    public MenuPresenter.Callback f1509N;

    /* renamed from: O */
    public MenuBuilder.Callback f1510O;

    /* renamed from: P */
    public boolean f1511P;

    /* renamed from: Q */
    public OnBackInvokedCallback f1512Q;

    /* renamed from: R */
    public OnBackInvokedDispatcher f1513R;

    /* renamed from: S */
    public boolean f1514S;

    /* renamed from: T */
    public final sn1 f1515T;

    /* renamed from: a */
    public ActionMenuView f1516a;

    /* renamed from: b */
    public AppCompatTextView f1517b;

    /* renamed from: c */
    public AppCompatTextView f1518c;

    /* renamed from: d */
    public AppCompatImageButton f1519d;

    /* renamed from: e */
    public AppCompatImageView f1520e;

    /* renamed from: f */
    public final Drawable f1521f;

    /* renamed from: g */
    public final CharSequence f1522g;

    /* renamed from: h */
    public AppCompatImageButton f1523h;

    /* renamed from: i */
    public View f1524i;

    /* renamed from: j */
    public Context f1525j;

    /* renamed from: k */
    public int f1526k;

    /* renamed from: l */
    public int f1527l;

    /* renamed from: m */
    public int f1528m;

    /* renamed from: n */
    public final int f1529n;

    /* renamed from: o */
    public final int f1530o;

    /* renamed from: p */
    public int f1531p;

    /* renamed from: q */
    public int f1532q;

    /* renamed from: r */
    public int f1533r;

    /* renamed from: s */
    public int f1534s;

    /* renamed from: t */
    public fd2 f1535t;

    /* renamed from: u */
    public int f1536u;

    /* renamed from: v */
    public int f1537v;

    /* renamed from: w */
    public final int f1538w;

    /* renamed from: x */
    public CharSequence f1539x;

    /* renamed from: y */
    public CharSequence f1540y;

    /* renamed from: z */
    public ColorStateList f1541z;

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* renamed from: a */
        public boolean f1542a = false;

        /* renamed from: b */
        public int f1543b;

        /* renamed from: c */
        public int f1544c;

        /* renamed from: d */
        public int f1545d;

        /* renamed from: e */
        public int f1546e;

        /* renamed from: f */
        public int f1547f;

        /* renamed from: g */
        public int f1548g;

        /* renamed from: h */
        public int f1549h;

        /* renamed from: i */
        public int f1550i;

        /* renamed from: j */
        public int f1551j;

        /* renamed from: k */
        public int f1552k;

        /* renamed from: l */
        public int f1553l;

        /* renamed from: m */
        public int f1554m;

        /* renamed from: n */
        public int f1555n;

        /* renamed from: o */
        public int f1556o;

        /* renamed from: p */
        public int f1557p;

        /* renamed from: q */
        public int f1558q;

        /* renamed from: r */
        public int f1559r;

        /* renamed from: s */
        public int f1560s;

        /* renamed from: t */
        public int f1561t;

        /* renamed from: u */
        public int f1562u;

        public void mapProperties(@NonNull PropertyMapper propertyMapper) {
            int mapObject;
            int mapObject2;
            int mapInt;
            int mapInt2;
            int mapInt3;
            int mapInt4;
            int mapInt5;
            int mapInt6;
            int mapObject3;
            int mapObject4;
            int mapObject5;
            int mapObject6;
            int mapObject7;
            int mapResourceId;
            int mapObject8;
            int mapObject9;
            int mapInt7;
            int mapInt8;
            int mapInt9;
            int mapInt10;
            mapObject = propertyMapper.mapObject("collapseContentDescription", R.attr.collapseContentDescription);
            this.f1543b = mapObject;
            mapObject2 = propertyMapper.mapObject("collapseIcon", R.attr.collapseIcon);
            this.f1544c = mapObject2;
            mapInt = propertyMapper.mapInt("contentInsetEnd", R.attr.contentInsetEnd);
            this.f1545d = mapInt;
            mapInt2 = propertyMapper.mapInt("contentInsetEndWithActions", R.attr.contentInsetEndWithActions);
            this.f1546e = mapInt2;
            mapInt3 = propertyMapper.mapInt("contentInsetLeft", R.attr.contentInsetLeft);
            this.f1547f = mapInt3;
            mapInt4 = propertyMapper.mapInt("contentInsetRight", R.attr.contentInsetRight);
            this.f1548g = mapInt4;
            mapInt5 = propertyMapper.mapInt("contentInsetStart", R.attr.contentInsetStart);
            this.f1549h = mapInt5;
            mapInt6 = propertyMapper.mapInt("contentInsetStartWithNavigation", R.attr.contentInsetStartWithNavigation);
            this.f1550i = mapInt6;
            mapObject3 = propertyMapper.mapObject("logo", R.attr.logo);
            this.f1551j = mapObject3;
            mapObject4 = propertyMapper.mapObject("logoDescription", R.attr.logoDescription);
            this.f1552k = mapObject4;
            mapObject5 = propertyMapper.mapObject("menu", R.attr.menu);
            this.f1553l = mapObject5;
            mapObject6 = propertyMapper.mapObject("navigationContentDescription", R.attr.navigationContentDescription);
            this.f1554m = mapObject6;
            mapObject7 = propertyMapper.mapObject("navigationIcon", R.attr.navigationIcon);
            this.f1555n = mapObject7;
            mapResourceId = propertyMapper.mapResourceId("popupTheme", R.attr.popupTheme);
            this.f1556o = mapResourceId;
            mapObject8 = propertyMapper.mapObject("subtitle", R.attr.subtitle);
            this.f1557p = mapObject8;
            mapObject9 = propertyMapper.mapObject("title", R.attr.title);
            this.f1558q = mapObject9;
            mapInt7 = propertyMapper.mapInt("titleMarginBottom", R.attr.titleMarginBottom);
            this.f1559r = mapInt7;
            mapInt8 = propertyMapper.mapInt("titleMarginEnd", R.attr.titleMarginEnd);
            this.f1560s = mapInt8;
            mapInt9 = propertyMapper.mapInt("titleMarginStart", R.attr.titleMarginStart);
            this.f1561t = mapInt9;
            mapInt10 = propertyMapper.mapInt("titleMarginTop", R.attr.titleMarginTop);
            this.f1562u = mapInt10;
            this.f1542a = true;
        }

        public void readProperties(@NonNull Toolbar toolbar, @NonNull PropertyReader propertyReader) {
            if (this.f1542a) {
                propertyReader.readObject(this.f1543b, toolbar.getCollapseContentDescription());
                propertyReader.readObject(this.f1544c, toolbar.getCollapseIcon());
                propertyReader.readInt(this.f1545d, toolbar.getContentInsetEnd());
                propertyReader.readInt(this.f1546e, toolbar.getContentInsetEndWithActions());
                propertyReader.readInt(this.f1547f, toolbar.getContentInsetLeft());
                propertyReader.readInt(this.f1548g, toolbar.getContentInsetRight());
                propertyReader.readInt(this.f1549h, toolbar.getContentInsetStart());
                propertyReader.readInt(this.f1550i, toolbar.getContentInsetStartWithNavigation());
                propertyReader.readObject(this.f1551j, toolbar.getLogo());
                propertyReader.readObject(this.f1552k, toolbar.getLogoDescription());
                propertyReader.readObject(this.f1553l, toolbar.getMenu());
                propertyReader.readObject(this.f1554m, toolbar.getNavigationContentDescription());
                propertyReader.readObject(this.f1555n, toolbar.getNavigationIcon());
                propertyReader.readResourceId(this.f1556o, toolbar.getPopupTheme());
                propertyReader.readObject(this.f1557p, toolbar.getSubtitle());
                propertyReader.readObject(this.f1558q, toolbar.getTitle());
                propertyReader.readInt(this.f1559r, toolbar.getTitleMarginBottom());
                propertyReader.readInt(this.f1560s, toolbar.getTitleMarginEnd());
                propertyReader.readInt(this.f1561t, toolbar.getTitleMarginStart());
                propertyReader.readInt(this.f1562u, toolbar.getTitleMarginTop());
                return;
            }
            throw AbstractC1497l3.m5831i();
        }
    }

    /* loaded from: classes.dex */
    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: b */
        public int f1564b;

        /* renamed from: c */
        public boolean f1565c;

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1564b);
            parcel.writeInt(this.f1565c ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1564b = parcel.readInt();
            this.f1565c = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public Toolbar(@NonNull Context context) {
        this(context, null);
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i = 0; i < menu.size(); i++) {
            arrayList.add(menu.getItem(i));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    /* renamed from: i */
    public static int m282i(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart();
    }

    /* renamed from: j */
    public static int m283j(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    /* renamed from: a */
    public final void m284a(ArrayList arrayList, int i) {
        boolean z;
        if (getLayoutDirection() == 1) {
            z = true;
        } else {
            z = false;
        }
        int childCount = getChildCount();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, getLayoutDirection());
        arrayList.clear();
        if (z) {
            for (int i2 = childCount - 1; i2 >= 0; i2--) {
                View childAt = getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f1563a == 0 && m297p(childAt)) {
                    int i3 = layoutParams.gravity;
                    int layoutDirection = getLayoutDirection();
                    int absoluteGravity2 = GravityCompat.getAbsoluteGravity(i3, layoutDirection) & 7;
                    if (absoluteGravity2 != 1 && absoluteGravity2 != 3 && absoluteGravity2 != 5) {
                        absoluteGravity2 = layoutDirection == 1 ? 5 : 3;
                    }
                    if (absoluteGravity2 == absoluteGravity) {
                        arrayList.add(childAt);
                    }
                }
            }
            return;
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt2 = getChildAt(i4);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.f1563a == 0 && m297p(childAt2)) {
                int i5 = layoutParams2.gravity;
                int layoutDirection2 = getLayoutDirection();
                int absoluteGravity3 = GravityCompat.getAbsoluteGravity(i5, layoutDirection2) & 7;
                if (absoluteGravity3 != 1 && absoluteGravity3 != 3 && absoluteGravity3 != 5) {
                    absoluteGravity3 = layoutDirection2 == 1 ? 5 : 3;
                }
                if (absoluteGravity3 == absoluteGravity) {
                    arrayList.add(childAt2);
                }
            }
        }
    }

    @Override // androidx.core.view.MenuHost
    @MainThread
    public void addMenuProvider(@NonNull MenuProvider menuProvider) {
        this.f1502G.addMenuProvider(menuProvider);
    }

    /* renamed from: b */
    public final void m285b(View view, boolean z) {
        LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams2)) {
            layoutParams = generateLayoutParams(layoutParams2);
        } else {
            layoutParams = (LayoutParams) layoutParams2;
        }
        layoutParams.f1563a = 1;
        if (z && this.f1524i != null) {
            view.setLayoutParams(layoutParams);
            this.f1500E.add(view);
        } else {
            addView(view, layoutParams);
        }
    }

    /* renamed from: c */
    public final void m286c() {
        if (this.f1523h == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.f1523h = appCompatImageButton;
            appCompatImageButton.setImageDrawable(this.f1521f);
            this.f1523h.setContentDescription(this.f1522g);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = (this.f1529n & 112) | GravityCompat.START;
            generateDefaultLayoutParams.f1563a = 2;
            this.f1523h.setLayoutParams(generateDefaultLayoutParams);
            this.f1523h.setOnClickListener(new ViewOnClickListenerC1109d4(8, this));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean canShowOverflowMenu() {
        ActionMenuView actionMenuView;
        if (getVisibility() == 0 && (actionMenuView = this.f1516a) != null && actionMenuView.isOverflowReserved()) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams)) {
            return true;
        }
        return false;
    }

    public void collapseActionView() {
        MenuItemImpl menuItemImpl;
        C0108q c0108q = this.f1508M;
        if (c0108q == null) {
            menuItemImpl = null;
        } else {
            menuItemImpl = c0108q.f1628b;
        }
        if (menuItemImpl != null) {
            menuItemImpl.collapseActionView();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [fd2, java.lang.Object] */
    /* renamed from: d */
    public final void m287d() {
        if (this.f1535t == null) {
            ?? obj = new Object();
            obj.f17219a = 0;
            obj.f17220b = 0;
            obj.f17221c = Integer.MIN_VALUE;
            obj.f17222d = Integer.MIN_VALUE;
            obj.f17223e = 0;
            obj.f17224f = 0;
            obj.f17225g = false;
            obj.f17226h = false;
            this.f1535t = obj;
        }
    }

    public void dismissPopupMenus() {
        ActionMenuView actionMenuView = this.f1516a;
        if (actionMenuView != null) {
            actionMenuView.dismissPopupMenus();
        }
    }

    /* renamed from: e */
    public final void m288e() {
        m289f();
        if (this.f1516a.peekMenu() == null) {
            MenuBuilder menuBuilder = (MenuBuilder) this.f1516a.getMenu();
            if (this.f1508M == null) {
                this.f1508M = new C0108q(this);
            }
            this.f1516a.setExpandedActionViewsExclusive(true);
            menuBuilder.addMenuPresenter(this.f1508M, this.f1525j);
            m298q();
        }
    }

    /* renamed from: f */
    public final void m289f() {
        if (this.f1516a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f1516a = actionMenuView;
            actionMenuView.setPopupTheme(this.f1526k);
            this.f1516a.setOnMenuItemClickListener(this.f1505J);
            this.f1516a.setMenuCallbacks(this.f1509N, new ju2(this));
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = (this.f1529n & 112) | GravityCompat.END;
            this.f1516a.setLayoutParams(generateDefaultLayoutParams);
            m285b(this.f1516a, false);
        }
    }

    /* renamed from: g */
    public final void m290g() {
        if (this.f1519d == null) {
            this.f1519d = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = (this.f1529n & 112) | GravityCompat.START;
            this.f1519d.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    @Nullable
    public CharSequence getCollapseContentDescription() {
        AppCompatImageButton appCompatImageButton = this.f1523h;
        if (appCompatImageButton != null) {
            return appCompatImageButton.getContentDescription();
        }
        return null;
    }

    @Nullable
    public Drawable getCollapseIcon() {
        AppCompatImageButton appCompatImageButton = this.f1523h;
        if (appCompatImageButton != null) {
            return appCompatImageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        fd2 fd2Var = this.f1535t;
        if (fd2Var != null) {
            if (fd2Var.f17225g) {
                return fd2Var.f17219a;
            }
            return fd2Var.f17220b;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i = this.f1537v;
        if (i == Integer.MIN_VALUE) {
            return getContentInsetEnd();
        }
        return i;
    }

    public int getContentInsetLeft() {
        fd2 fd2Var = this.f1535t;
        if (fd2Var != null) {
            return fd2Var.f17219a;
        }
        return 0;
    }

    public int getContentInsetRight() {
        fd2 fd2Var = this.f1535t;
        if (fd2Var != null) {
            return fd2Var.f17220b;
        }
        return 0;
    }

    public int getContentInsetStart() {
        fd2 fd2Var = this.f1535t;
        if (fd2Var != null) {
            if (fd2Var.f17225g) {
                return fd2Var.f17220b;
            }
            return fd2Var.f17219a;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.f1536u;
        if (i == Integer.MIN_VALUE) {
            return getContentInsetStart();
        }
        return i;
    }

    public int getCurrentContentInsetEnd() {
        MenuBuilder peekMenu;
        ActionMenuView actionMenuView = this.f1516a;
        if (actionMenuView != null && (peekMenu = actionMenuView.peekMenu()) != null && peekMenu.hasVisibleItems()) {
            return Math.max(getContentInsetEnd(), Math.max(this.f1537v, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (getLayoutDirection() == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (getLayoutDirection() == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.f1536u, 0));
        }
        return getContentInsetStart();
    }

    public Drawable getLogo() {
        AppCompatImageView appCompatImageView = this.f1520e;
        if (appCompatImageView != null) {
            return appCompatImageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        AppCompatImageView appCompatImageView = this.f1520e;
        if (appCompatImageView != null) {
            return appCompatImageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        m288e();
        return this.f1516a.getMenu();
    }

    @Nullable
    @VisibleForTesting
    public View getNavButtonView() {
        return this.f1519d;
    }

    @Nullable
    public CharSequence getNavigationContentDescription() {
        AppCompatImageButton appCompatImageButton = this.f1519d;
        if (appCompatImageButton != null) {
            return appCompatImageButton.getContentDescription();
        }
        return null;
    }

    @Nullable
    public Drawable getNavigationIcon() {
        AppCompatImageButton appCompatImageButton = this.f1519d;
        if (appCompatImageButton != null) {
            return appCompatImageButton.getDrawable();
        }
        return null;
    }

    public C0095d getOuterActionMenuPresenter() {
        return this.f1507L;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        m288e();
        return this.f1516a.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f1525j;
    }

    @StyleRes
    public int getPopupTheme() {
        return this.f1526k;
    }

    public CharSequence getSubtitle() {
        return this.f1540y;
    }

    @Nullable
    @VisibleForTesting
    public final TextView getSubtitleTextView() {
        return this.f1518c;
    }

    public CharSequence getTitle() {
        return this.f1539x;
    }

    public int getTitleMarginBottom() {
        return this.f1534s;
    }

    public int getTitleMarginEnd() {
        return this.f1532q;
    }

    public int getTitleMarginStart() {
        return this.f1531p;
    }

    public int getTitleMarginTop() {
        return this.f1533r;
    }

    @Nullable
    @VisibleForTesting
    public final TextView getTitleTextView() {
        return this.f1517b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DecorToolbar getWrapper() {
        if (this.f1506K == null) {
            this.f1506K = new ToolbarWidgetWrapper(this, true);
        }
        return this.f1506K;
    }

    /* renamed from: h */
    public final int m291h(int i, View view) {
        int i2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        if (i > 0) {
            i2 = (measuredHeight - i) / 2;
        } else {
            i2 = 0;
        }
        int i3 = layoutParams.gravity & 112;
        if (i3 != 16 && i3 != 48 && i3 != 80) {
            i3 = this.f1538w & 112;
        }
        if (i3 != 48) {
            if (i3 != 80) {
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int i4 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                int i5 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                if (i4 < i5) {
                    i4 = i5;
                } else {
                    int i6 = (((height - paddingBottom) - measuredHeight) - i4) - paddingTop;
                    int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    if (i6 < i7) {
                        i4 = Math.max(0, i4 - (i7 - i6));
                    }
                }
                return paddingTop + i4;
            }
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - i2;
        }
        return getPaddingTop() - i2;
    }

    public boolean hasExpandedActionView() {
        C0108q c0108q = this.f1508M;
        if (c0108q != null && c0108q.f1628b != null) {
            return true;
        }
        return false;
    }

    public boolean hideOverflowMenu() {
        ActionMenuView actionMenuView = this.f1516a;
        if (actionMenuView != null && actionMenuView.hideOverflowMenu()) {
            return true;
        }
        return false;
    }

    public void inflateMenu(@MenuRes int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    @Override // androidx.core.view.MenuHost
    @MainThread
    public void invalidateMenu() {
        Iterator it = this.f1503H.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(((MenuItem) it.next()).getItemId());
        }
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        this.f1502G.onCreateMenu(menu, getMenuInflater());
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.f1503H = currentMenuItems2;
    }

    public boolean isBackInvokedCallbackEnabled() {
        return this.f1514S;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isOverflowMenuShowPending() {
        ActionMenuView actionMenuView = this.f1516a;
        if (actionMenuView != null && actionMenuView.isOverflowMenuShowPending()) {
            return true;
        }
        return false;
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuView actionMenuView = this.f1516a;
        if (actionMenuView != null && actionMenuView.isOverflowMenuShowing()) {
            return true;
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isTitleTruncated() {
        Layout layout;
        AppCompatTextView appCompatTextView = this.f1517b;
        if (appCompatTextView == null || (layout = appCompatTextView.getLayout()) == null) {
            return false;
        }
        int lineCount = layout.getLineCount();
        for (int i = 0; i < lineCount; i++) {
            if (layout.getEllipsisCount(i) > 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: k */
    public final boolean m292k(View view) {
        if (view.getParent() != this && !this.f1500E.contains(view)) {
            return false;
        }
        return true;
    }

    /* renamed from: l */
    public final int m293l(View view, int i, int i2, int[] iArr) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        int m291h = m291h(i2, view);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, m291h, max + measuredWidth, view.getMeasuredHeight() + m291h);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + max;
    }

    /* renamed from: m */
    public final int m294m(View view, int i, int i2, int[] iArr) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int m291h = m291h(i2, view);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, m291h, max, view.getMeasuredHeight() + m291h);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
    }

    /* renamed from: n */
    public final int m295n(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i6) + Math.max(0, i5);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + max + i2, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i3, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    /* renamed from: o */
    public final void m296o(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i4 >= 0) {
            if (mode != 0) {
                i4 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i4);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m298q();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f1515T);
        m298q();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1498C = false;
        }
        if (!this.f1498C) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f1498C = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1498C = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0291 A[LOOP:0: B:40:0x028f->B:41:0x0291, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x02ad A[LOOP:1: B:44:0x02ab->B:45:0x02ad, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x02cd A[LOOP:2: B:48:0x02cb->B:49:0x02cd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x031b A[LOOP:3: B:57:0x0319->B:58:0x031b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x021b  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        int i5;
        int i6;
        int i7;
        boolean m297p;
        boolean m297p2;
        int i8;
        int i9;
        int i10;
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        boolean z3;
        int i11;
        int i12;
        int i13;
        int paddingTop;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int size;
        int i20;
        int i21;
        int size2;
        int i22;
        int size3;
        int i23;
        int i24;
        int i25;
        int size4;
        if (getLayoutDirection() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i26 = width - paddingRight;
        int[] iArr = this.f1501F;
        iArr[1] = 0;
        iArr[0] = 0;
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight >= 0) {
            i5 = Math.min(minimumHeight, i4 - i2);
        } else {
            i5 = 0;
        }
        if (m297p(this.f1519d)) {
            if (z2) {
                i7 = m294m(this.f1519d, i26, i5, iArr);
                i6 = paddingLeft;
                if (m297p(this.f1523h)) {
                    if (z2) {
                        i7 = m294m(this.f1523h, i7, i5, iArr);
                    } else {
                        i6 = m293l(this.f1523h, i6, i5, iArr);
                    }
                }
                if (m297p(this.f1516a)) {
                    if (z2) {
                        i6 = m293l(this.f1516a, i6, i5, iArr);
                    } else {
                        i7 = m294m(this.f1516a, i7, i5, iArr);
                    }
                }
                int currentContentInsetLeft = getCurrentContentInsetLeft();
                int currentContentInsetRight = getCurrentContentInsetRight();
                iArr[0] = Math.max(0, currentContentInsetLeft - i6);
                iArr[1] = Math.max(0, currentContentInsetRight - (i26 - i7));
                int max = Math.max(i6, currentContentInsetLeft);
                int min = Math.min(i7, i26 - currentContentInsetRight);
                if (m297p(this.f1524i)) {
                    if (z2) {
                        min = m294m(this.f1524i, min, i5, iArr);
                    } else {
                        max = m293l(this.f1524i, max, i5, iArr);
                    }
                }
                if (m297p(this.f1520e)) {
                    if (z2) {
                        min = m294m(this.f1520e, min, i5, iArr);
                    } else {
                        max = m293l(this.f1520e, max, i5, iArr);
                    }
                }
                m297p = m297p(this.f1517b);
                m297p2 = m297p(this.f1518c);
                if (!m297p) {
                    LayoutParams layoutParams = (LayoutParams) this.f1517b.getLayoutParams();
                    i8 = paddingRight;
                    i9 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + this.f1517b.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                } else {
                    i8 = paddingRight;
                    i9 = 0;
                }
                if (!m297p2) {
                    LayoutParams layoutParams2 = (LayoutParams) this.f1518c.getLayoutParams();
                    i10 = width;
                    i9 += this.f1518c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                } else {
                    i10 = width;
                }
                if (m297p && !m297p2) {
                    i12 = paddingLeft;
                    i13 = i5;
                } else {
                    if (!m297p) {
                        appCompatTextView = this.f1517b;
                    } else {
                        appCompatTextView = this.f1518c;
                    }
                    if (!m297p2) {
                        appCompatTextView2 = this.f1518c;
                    } else {
                        appCompatTextView2 = this.f1517b;
                    }
                    LayoutParams layoutParams3 = (LayoutParams) appCompatTextView.getLayoutParams();
                    LayoutParams layoutParams4 = (LayoutParams) appCompatTextView2.getLayoutParams();
                    if ((!m297p && this.f1517b.getMeasuredWidth() > 0) || (m297p2 && this.f1518c.getMeasuredWidth() > 0)) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    i11 = this.f1538w & 112;
                    i12 = paddingLeft;
                    if (i11 == 48) {
                        if (i11 != 80) {
                            int i27 = (((height - paddingTop2) - paddingBottom) - i9) / 2;
                            i13 = i5;
                            int i28 = ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + this.f1533r;
                            if (i27 < i28) {
                                i27 = i28;
                            } else {
                                int i29 = (((height - paddingBottom) - i9) - i27) - paddingTop2;
                                int i30 = ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin;
                                int i31 = this.f1534s;
                                if (i29 < i30 + i31) {
                                    i27 = Math.max(0, i27 - ((((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin + i31) - i29));
                                }
                            }
                            paddingTop = paddingTop2 + i27;
                        } else {
                            i13 = i5;
                            paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin) - this.f1534s) - i9;
                        }
                    } else {
                        i13 = i5;
                        paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + this.f1533r;
                    }
                    if (!z2) {
                        if (z3) {
                            i17 = this.f1531p;
                        } else {
                            i17 = 0;
                        }
                        int i32 = i17 - iArr[1];
                        min -= Math.max(0, i32);
                        iArr[1] = Math.max(0, -i32);
                        if (m297p) {
                            LayoutParams layoutParams5 = (LayoutParams) this.f1517b.getLayoutParams();
                            int measuredWidth = min - this.f1517b.getMeasuredWidth();
                            int measuredHeight = this.f1517b.getMeasuredHeight() + paddingTop;
                            this.f1517b.layout(measuredWidth, paddingTop, min, measuredHeight);
                            i18 = measuredWidth - this.f1532q;
                            paddingTop = measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin;
                        } else {
                            i18 = min;
                        }
                        if (m297p2) {
                            int i33 = paddingTop + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.f1518c.getLayoutParams())).topMargin;
                            this.f1518c.layout(min - this.f1518c.getMeasuredWidth(), i33, min, this.f1518c.getMeasuredHeight() + i33);
                            i19 = min - this.f1532q;
                        } else {
                            i19 = min;
                        }
                        if (z3) {
                            min = Math.min(i18, i19);
                        }
                    } else {
                        if (z3) {
                            i14 = this.f1531p;
                        } else {
                            i14 = 0;
                        }
                        int i34 = i14 - iArr[0];
                        max += Math.max(0, i34);
                        iArr[0] = Math.max(0, -i34);
                        if (m297p) {
                            LayoutParams layoutParams6 = (LayoutParams) this.f1517b.getLayoutParams();
                            int measuredWidth2 = this.f1517b.getMeasuredWidth() + max;
                            int measuredHeight2 = this.f1517b.getMeasuredHeight() + paddingTop;
                            this.f1517b.layout(max, paddingTop, measuredWidth2, measuredHeight2);
                            i15 = measuredWidth2 + this.f1532q;
                            paddingTop = measuredHeight2 + ((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin;
                        } else {
                            i15 = max;
                        }
                        if (m297p2) {
                            int i35 = paddingTop + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.f1518c.getLayoutParams())).topMargin;
                            int measuredWidth3 = this.f1518c.getMeasuredWidth() + max;
                            this.f1518c.layout(max, i35, measuredWidth3, this.f1518c.getMeasuredHeight() + i35);
                            i16 = measuredWidth3 + this.f1532q;
                        } else {
                            i16 = max;
                        }
                        if (z3) {
                            max = Math.max(i15, i16);
                        }
                    }
                }
                ArrayList arrayList = this.f1499D;
                m284a(arrayList, 3);
                size = arrayList.size();
                i20 = max;
                for (i21 = 0; i21 < size; i21++) {
                    i20 = m293l((View) arrayList.get(i21), i20, i13, iArr);
                }
                int i36 = i13;
                m284a(arrayList, 5);
                size2 = arrayList.size();
                for (i22 = 0; i22 < size2; i22++) {
                    min = m294m((View) arrayList.get(i22), min, i36, iArr);
                }
                m284a(arrayList, 1);
                int i37 = iArr[0];
                int i38 = iArr[1];
                size3 = arrayList.size();
                int i39 = i38;
                int i40 = i37;
                i23 = 0;
                int i41 = 0;
                while (i23 < size3) {
                    View view = (View) arrayList.get(i23);
                    LayoutParams layoutParams7 = (LayoutParams) view.getLayoutParams();
                    int i42 = ((ViewGroup.MarginLayoutParams) layoutParams7).leftMargin - i40;
                    int i43 = ((ViewGroup.MarginLayoutParams) layoutParams7).rightMargin - i39;
                    int max2 = Math.max(0, i42);
                    int max3 = Math.max(0, i43);
                    int max4 = Math.max(0, -i42);
                    int max5 = Math.max(0, -i43);
                    i41 += view.getMeasuredWidth() + max2 + max3;
                    i23++;
                    i39 = max5;
                    i40 = max4;
                }
                i25 = ((((i10 - i12) - i8) / 2) + i12) - (i41 / 2);
                int i44 = i41 + i25;
                if (i25 >= i20) {
                    if (i44 > min) {
                        i20 = i25 - (i44 - min);
                    } else {
                        i20 = i25;
                    }
                }
                size4 = arrayList.size();
                for (i24 = 0; i24 < size4; i24++) {
                    i20 = m293l((View) arrayList.get(i24), i20, i36, iArr);
                }
                arrayList.clear();
            }
            i6 = m293l(this.f1519d, paddingLeft, i5, iArr);
        } else {
            i6 = paddingLeft;
        }
        i7 = i26;
        if (m297p(this.f1523h)) {
        }
        if (m297p(this.f1516a)) {
        }
        int currentContentInsetLeft2 = getCurrentContentInsetLeft();
        int currentContentInsetRight2 = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft2 - i6);
        iArr[1] = Math.max(0, currentContentInsetRight2 - (i26 - i7));
        int max6 = Math.max(i6, currentContentInsetLeft2);
        int min2 = Math.min(i7, i26 - currentContentInsetRight2);
        if (m297p(this.f1524i)) {
        }
        if (m297p(this.f1520e)) {
        }
        m297p = m297p(this.f1517b);
        m297p2 = m297p(this.f1518c);
        if (!m297p) {
        }
        if (!m297p2) {
        }
        if (m297p) {
        }
        if (!m297p) {
        }
        if (!m297p2) {
        }
        LayoutParams layoutParams32 = (LayoutParams) appCompatTextView.getLayoutParams();
        LayoutParams layoutParams42 = (LayoutParams) appCompatTextView2.getLayoutParams();
        if (!m297p) {
        }
        z3 = false;
        i11 = this.f1538w & 112;
        i12 = paddingLeft;
        if (i11 == 48) {
        }
        if (!z2) {
        }
        ArrayList arrayList2 = this.f1499D;
        m284a(arrayList2, 3);
        size = arrayList2.size();
        i20 = max6;
        while (i21 < size) {
        }
        int i362 = i13;
        m284a(arrayList2, 5);
        size2 = arrayList2.size();
        while (i22 < size2) {
        }
        m284a(arrayList2, 1);
        int i372 = iArr[0];
        int i382 = iArr[1];
        size3 = arrayList2.size();
        int i392 = i382;
        int i402 = i372;
        i23 = 0;
        int i412 = 0;
        while (i23 < size3) {
        }
        i25 = ((((i10 - i12) - i8) / 2) + i12) - (i412 / 2);
        int i442 = i412 + i25;
        if (i25 >= i20) {
        }
        size4 = arrayList2.size();
        while (i24 < size4) {
        }
        arrayList2.clear();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int i10 = !isLayoutRtl ? 1 : 0;
        int i11 = 0;
        if (m297p(this.f1519d)) {
            m296o(this.f1519d, i, 0, i2, this.f1530o);
            i3 = m282i(this.f1519d) + this.f1519d.getMeasuredWidth();
            i4 = Math.max(0, m283j(this.f1519d) + this.f1519d.getMeasuredHeight());
            i5 = View.combineMeasuredStates(0, this.f1519d.getMeasuredState());
        } else {
            i3 = 0;
            i4 = 0;
            i5 = 0;
        }
        if (m297p(this.f1523h)) {
            m296o(this.f1523h, i, 0, i2, this.f1530o);
            i3 = m282i(this.f1523h) + this.f1523h.getMeasuredWidth();
            i4 = Math.max(i4, m283j(this.f1523h) + this.f1523h.getMeasuredHeight());
            i5 = View.combineMeasuredStates(i5, this.f1523h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = Math.max(currentContentInsetStart, i3);
        int max2 = Math.max(0, currentContentInsetStart - i3);
        int[] iArr = this.f1501F;
        iArr[isLayoutRtl ? 1 : 0] = max2;
        if (m297p(this.f1516a)) {
            m296o(this.f1516a, i, max, i2, this.f1530o);
            i6 = m282i(this.f1516a) + this.f1516a.getMeasuredWidth();
            i4 = Math.max(i4, m283j(this.f1516a) + this.f1516a.getMeasuredHeight());
            i5 = View.combineMeasuredStates(i5, this.f1516a.getMeasuredState());
        } else {
            i6 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max3 = max + Math.max(currentContentInsetEnd, i6);
        iArr[i10] = Math.max(0, currentContentInsetEnd - i6);
        if (m297p(this.f1524i)) {
            max3 += m295n(this.f1524i, i, max3, i2, 0, iArr);
            i4 = Math.max(i4, m283j(this.f1524i) + this.f1524i.getMeasuredHeight());
            i5 = View.combineMeasuredStates(i5, this.f1524i.getMeasuredState());
        }
        if (m297p(this.f1520e)) {
            max3 += m295n(this.f1520e, i, max3, i2, 0, iArr);
            i4 = Math.max(i4, m283j(this.f1520e) + this.f1520e.getMeasuredHeight());
            i5 = View.combineMeasuredStates(i5, this.f1520e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (((LayoutParams) childAt.getLayoutParams()).f1563a == 0 && m297p(childAt)) {
                max3 += m295n(childAt, i, max3, i2, 0, iArr);
                i4 = Math.max(i4, m283j(childAt) + childAt.getMeasuredHeight());
                i5 = View.combineMeasuredStates(i5, childAt.getMeasuredState());
            }
        }
        int i13 = this.f1533r + this.f1534s;
        int i14 = this.f1531p + this.f1532q;
        if (m297p(this.f1517b)) {
            m295n(this.f1517b, i, max3 + i14, i2, i13, iArr);
            int m282i = m282i(this.f1517b) + this.f1517b.getMeasuredWidth();
            i7 = m283j(this.f1517b) + this.f1517b.getMeasuredHeight();
            i8 = View.combineMeasuredStates(i5, this.f1517b.getMeasuredState());
            i9 = m282i;
        } else {
            i7 = 0;
            i8 = i5;
            i9 = 0;
        }
        if (m297p(this.f1518c)) {
            i9 = Math.max(i9, m295n(this.f1518c, i, max3 + i14, i2, i7 + i13, iArr));
            i7 += m283j(this.f1518c) + this.f1518c.getMeasuredHeight();
            i8 = View.combineMeasuredStates(i8, this.f1518c.getMeasuredState());
        }
        int max4 = Math.max(i4, i7);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop() + max4;
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight + max3 + i9, getSuggestedMinimumWidth()), i, (-16777216) & i8);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i2, i8 << 16);
        if (this.f1511P) {
            int childCount2 = getChildCount();
            for (int i15 = 0; i15 < childCount2; i15++) {
                View childAt2 = getChildAt(i15);
                if (!m297p(childAt2) || childAt2.getMeasuredWidth() <= 0 || childAt2.getMeasuredHeight() <= 0) {
                }
            }
            setMeasuredDimension(resolveSizeAndState, i11);
        }
        i11 = resolveSizeAndState2;
        setMeasuredDimension(resolveSizeAndState, i11);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuBuilder menuBuilder;
        MenuItem findItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        ActionMenuView actionMenuView = this.f1516a;
        if (actionMenuView != null) {
            menuBuilder = actionMenuView.peekMenu();
        } else {
            menuBuilder = null;
        }
        int i = savedState.f1564b;
        if (i != 0 && this.f1508M != null && menuBuilder != null && (findItem = menuBuilder.findItem(i)) != null) {
            findItem.expandActionView();
        }
        if (savedState.f1565c) {
            sn1 sn1Var = this.f1515T;
            removeCallbacks(sn1Var);
            post(sn1Var);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        m287d();
        fd2 fd2Var = this.f1535t;
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        if (z != fd2Var.f17225g) {
            fd2Var.f17225g = z;
            if (fd2Var.f17226h) {
                if (z) {
                    int i2 = fd2Var.f17222d;
                    if (i2 == Integer.MIN_VALUE) {
                        i2 = fd2Var.f17223e;
                    }
                    fd2Var.f17219a = i2;
                    int i3 = fd2Var.f17221c;
                    if (i3 == Integer.MIN_VALUE) {
                        i3 = fd2Var.f17224f;
                    }
                    fd2Var.f17220b = i3;
                    return;
                }
                int i4 = fd2Var.f17221c;
                if (i4 == Integer.MIN_VALUE) {
                    i4 = fd2Var.f17223e;
                }
                fd2Var.f17219a = i4;
                int i5 = fd2Var.f17222d;
                if (i5 == Integer.MIN_VALUE) {
                    i5 = fd2Var.f17224f;
                }
                fd2Var.f17220b = i5;
                return;
            }
            fd2Var.f17219a = fd2Var.f17223e;
            fd2Var.f17220b = fd2Var.f17224f;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        MenuItemImpl menuItemImpl;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        C0108q c0108q = this.f1508M;
        if (c0108q != null && (menuItemImpl = c0108q.f1628b) != null) {
            savedState.f1564b = menuItemImpl.getItemId();
        }
        savedState.f1565c = isOverflowMenuShowing();
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1497B = false;
        }
        if (!this.f1497B) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f1497B = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1497B = false;
        }
        return true;
    }

    /* renamed from: p */
    public final boolean m297p(View view) {
        if (view != null && view.getParent() == this && view.getVisibility() != 8) {
            return true;
        }
        return false;
    }

    /* renamed from: q */
    public final void m298q() {
        boolean z;
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher m5790a = ku2.m5790a(this);
            if (hasExpandedActionView() && m5790a != null && isAttachedToWindow() && this.f1514S) {
                z = true;
            } else {
                z = false;
            }
            if (z && this.f1513R == null) {
                if (this.f1512Q == null) {
                    this.f1512Q = ku2.m5791b(new iu2(this, 0));
                }
                ku2.m5792c(m5790a, this.f1512Q);
                this.f1513R = m5790a;
                return;
            }
            if (!z && (onBackInvokedDispatcher = this.f1513R) != null) {
                ku2.m5793d(onBackInvokedDispatcher, this.f1512Q);
                this.f1513R = null;
            }
        }
    }

    @Override // androidx.core.view.MenuHost
    @MainThread
    public void removeMenuProvider(@NonNull MenuProvider menuProvider) {
        this.f1502G.removeMenuProvider(menuProvider);
    }

    public void setBackInvokedCallbackEnabled(boolean z) {
        if (this.f1514S != z) {
            this.f1514S = z;
            m298q();
        }
    }

    public void setCollapseContentDescription(@StringRes int i) {
        setCollapseContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setCollapseIcon(@DrawableRes int i) {
        setCollapseIcon(AppCompatResources.getDrawable(getContext(), i));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setCollapsible(boolean z) {
        this.f1511P = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f1537v) {
            this.f1537v = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f1536u) {
            this.f1536u = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetsAbsolute(int i, int i2) {
        m287d();
        fd2 fd2Var = this.f1535t;
        fd2Var.f17226h = false;
        if (i != Integer.MIN_VALUE) {
            fd2Var.f17223e = i;
            fd2Var.f17219a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            fd2Var.f17224f = i2;
            fd2Var.f17220b = i2;
        }
    }

    public void setContentInsetsRelative(int i, int i2) {
        m287d();
        this.f1535t.m4805a(i, i2);
    }

    public void setLogo(@DrawableRes int i) {
        setLogo(AppCompatResources.getDrawable(getContext(), i));
    }

    public void setLogoDescription(@StringRes int i) {
        setLogoDescription(getContext().getText(i));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setMenu(MenuBuilder menuBuilder, C0095d c0095d) {
        if (menuBuilder == null && this.f1516a == null) {
            return;
        }
        m289f();
        MenuBuilder peekMenu = this.f1516a.peekMenu();
        if (peekMenu == menuBuilder) {
            return;
        }
        if (peekMenu != null) {
            peekMenu.removeMenuPresenter(this.f1507L);
            peekMenu.removeMenuPresenter(this.f1508M);
        }
        if (this.f1508M == null) {
            this.f1508M = new C0108q(this);
        }
        c0095d.f1605m = true;
        if (menuBuilder != null) {
            menuBuilder.addMenuPresenter(c0095d, this.f1525j);
            menuBuilder.addMenuPresenter(this.f1508M, this.f1525j);
        } else {
            c0095d.initForMenu(this.f1525j, null);
            this.f1508M.initForMenu(this.f1525j, null);
            c0095d.updateMenuView(true);
            this.f1508M.updateMenuView(true);
        }
        this.f1516a.setPopupTheme(this.f1526k);
        this.f1516a.setPresenter(c0095d);
        this.f1507L = c0095d;
        m298q();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.f1509N = callback;
        this.f1510O = callback2;
        ActionMenuView actionMenuView = this.f1516a;
        if (actionMenuView != null) {
            actionMenuView.setMenuCallbacks(callback, callback2);
        }
    }

    public void setNavigationContentDescription(@StringRes int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationIcon(@DrawableRes int i) {
        setNavigationIcon(AppCompatResources.getDrawable(getContext(), i));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        m290g();
        this.f1519d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f1504I = onMenuItemClickListener;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        m288e();
        this.f1516a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(@StyleRes int i) {
        if (this.f1526k != i) {
            this.f1526k = i;
            if (i == 0) {
                this.f1525j = getContext();
            } else {
                this.f1525j = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(@StringRes int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitleTextAppearance(Context context, @StyleRes int i) {
        this.f1528m = i;
        AppCompatTextView appCompatTextView = this.f1518c;
        if (appCompatTextView != null) {
            appCompatTextView.setTextAppearance(context, i);
        }
    }

    public void setSubtitleTextColor(@ColorInt int i) {
        setSubtitleTextColor(ColorStateList.valueOf(i));
    }

    public void setTitle(@StringRes int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitleMargin(int i, int i2, int i3, int i4) {
        this.f1531p = i;
        this.f1533r = i2;
        this.f1532q = i3;
        this.f1534s = i4;
        requestLayout();
    }

    public void setTitleMarginBottom(int i) {
        this.f1534s = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.f1532q = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.f1531p = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.f1533r = i;
        requestLayout();
    }

    public void setTitleTextAppearance(Context context, @StyleRes int i) {
        this.f1527l = i;
        AppCompatTextView appCompatTextView = this.f1517b;
        if (appCompatTextView != null) {
            appCompatTextView.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(@ColorInt int i) {
        setTitleTextColor(ColorStateList.valueOf(i));
    }

    public boolean showOverflowMenu() {
        ActionMenuView actionMenuView = this.f1516a;
        if (actionMenuView != null && actionMenuView.showOverflowMenu()) {
            return true;
        }
        return false;
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ActionBar.LayoutParams {

        /* renamed from: a */
        public int f1563a;

        public LayoutParams(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1563a = 0;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f1563a = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.f1563a = 0;
            this.gravity = i3;
        }

        public LayoutParams(int i) {
            this(-2, -1, i);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ActionBar.LayoutParams) layoutParams);
            this.f1563a = 0;
            this.f1563a = layoutParams.f1563a;
        }

        public LayoutParams(ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1563a = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1563a = 0;
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1563a = 0;
        }
    }

    public Toolbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    @Override // androidx.core.view.MenuHost
    @MainThread
    public void addMenuProvider(@NonNull MenuProvider menuProvider, @NonNull LifecycleOwner lifecycleOwner) {
        this.f1502G.addMenuProvider(menuProvider, lifecycleOwner);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public void setCollapseContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m286c();
        }
        AppCompatImageButton appCompatImageButton = this.f1523h;
        if (appCompatImageButton != null) {
            appCompatImageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            m286c();
            this.f1523h.setImageDrawable(drawable);
        } else {
            AppCompatImageButton appCompatImageButton = this.f1523h;
            if (appCompatImageButton != null) {
                appCompatImageButton.setImageDrawable(this.f1521f);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.f1520e == null) {
                this.f1520e = new AppCompatImageView(getContext());
            }
            if (!m292k(this.f1520e)) {
                m285b(this.f1520e, true);
            }
        } else {
            AppCompatImageView appCompatImageView = this.f1520e;
            if (appCompatImageView != null && m292k(appCompatImageView)) {
                removeView(this.f1520e);
                this.f1500E.remove(this.f1520e);
            }
        }
        AppCompatImageView appCompatImageView2 = this.f1520e;
        if (appCompatImageView2 != null) {
            appCompatImageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.f1520e == null) {
            this.f1520e = new AppCompatImageView(getContext());
        }
        AppCompatImageView appCompatImageView = this.f1520e;
        if (appCompatImageView != null) {
            appCompatImageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m290g();
        }
        AppCompatImageButton appCompatImageButton = this.f1519d;
        if (appCompatImageButton != null) {
            appCompatImageButton.setContentDescription(charSequence);
            TooltipCompat.setTooltipText(this.f1519d, charSequence);
        }
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            m290g();
            if (!m292k(this.f1519d)) {
                m285b(this.f1519d, true);
            }
        } else {
            AppCompatImageButton appCompatImageButton = this.f1519d;
            if (appCompatImageButton != null && m292k(appCompatImageButton)) {
                removeView(this.f1519d);
                this.f1500E.remove(this.f1519d);
            }
        }
        AppCompatImageButton appCompatImageButton2 = this.f1519d;
        if (appCompatImageButton2 != null) {
            appCompatImageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1518c == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f1518c = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f1518c.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.f1528m;
                if (i != 0) {
                    this.f1518c.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.f1496A;
                if (colorStateList != null) {
                    this.f1518c.setTextColor(colorStateList);
                }
            }
            if (!m292k(this.f1518c)) {
                m285b(this.f1518c, true);
            }
        } else {
            AppCompatTextView appCompatTextView2 = this.f1518c;
            if (appCompatTextView2 != null && m292k(appCompatTextView2)) {
                removeView(this.f1518c);
                this.f1500E.remove(this.f1518c);
            }
        }
        AppCompatTextView appCompatTextView3 = this.f1518c;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(charSequence);
        }
        this.f1540y = charSequence;
    }

    public void setSubtitleTextColor(@NonNull ColorStateList colorStateList) {
        this.f1496A = colorStateList;
        AppCompatTextView appCompatTextView = this.f1518c;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1517b == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f1517b = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f1517b.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.f1527l;
                if (i != 0) {
                    this.f1517b.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.f1541z;
                if (colorStateList != null) {
                    this.f1517b.setTextColor(colorStateList);
                }
            }
            if (!m292k(this.f1517b)) {
                m285b(this.f1517b, true);
            }
        } else {
            AppCompatTextView appCompatTextView2 = this.f1517b;
            if (appCompatTextView2 != null && m292k(appCompatTextView2)) {
                removeView(this.f1517b);
                this.f1500E.remove(this.f1517b);
            }
        }
        AppCompatTextView appCompatTextView3 = this.f1517b;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(charSequence);
        }
        this.f1539x = charSequence;
    }

    public void setTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.f1541z = colorStateList;
        AppCompatTextView appCompatTextView = this.f1517b;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public Toolbar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1538w = 8388627;
        this.f1499D = new ArrayList();
        this.f1500E = new ArrayList();
        this.f1501F = new int[2];
        this.f1502G = new MenuHostHelper(new iu2(this, 1));
        this.f1503H = new ArrayList();
        this.f1505J = new C0107p(this);
        this.f1515T = new sn1(10, this);
        Context context2 = getContext();
        int[] iArr = R.styleable.Toolbar;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context2, attributeSet, iArr, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
        this.f1527l = obtainStyledAttributes.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
        this.f1528m = obtainStyledAttributes.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.f1538w = obtainStyledAttributes.getInteger(R.styleable.Toolbar_android_gravity, 8388627);
        this.f1529n = obtainStyledAttributes.getInteger(R.styleable.Toolbar_buttonGravity, 48);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMargin, 0);
        int i2 = R.styleable.Toolbar_titleMargins;
        dimensionPixelOffset = obtainStyledAttributes.hasValue(i2) ? obtainStyledAttributes.getDimensionPixelOffset(i2, dimensionPixelOffset) : dimensionPixelOffset;
        this.f1534s = dimensionPixelOffset;
        this.f1533r = dimensionPixelOffset;
        this.f1532q = dimensionPixelOffset;
        this.f1531p = dimensionPixelOffset;
        int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginStart, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.f1531p = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginEnd, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.f1532q = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginTop, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.f1533r = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginBottom, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.f1534s = dimensionPixelOffset5;
        }
        this.f1530o = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Toolbar_maxButtonHeight, -1);
        int dimensionPixelOffset6 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Toolbar_contentInsetLeft, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Toolbar_contentInsetRight, 0);
        m287d();
        fd2 fd2Var = this.f1535t;
        fd2Var.f17226h = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            fd2Var.f17223e = dimensionPixelSize;
            fd2Var.f17219a = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            fd2Var.f17224f = dimensionPixelSize2;
            fd2Var.f17220b = dimensionPixelSize2;
        }
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            fd2Var.m4805a(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.f1536u = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.f1537v = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f1521f = obtainStyledAttributes.getDrawable(R.styleable.Toolbar_collapseIcon);
        this.f1522g = obtainStyledAttributes.getText(R.styleable.Toolbar_collapseContentDescription);
        CharSequence text = obtainStyledAttributes.getText(R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = obtainStyledAttributes.getText(R.styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.f1525j = getContext();
        setPopupTheme(obtainStyledAttributes.getResourceId(R.styleable.Toolbar_popupTheme, 0));
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.Toolbar_navigationIcon);
        if (drawable != null) {
            setNavigationIcon(drawable);
        }
        CharSequence text3 = obtainStyledAttributes.getText(R.styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.Toolbar_logo);
        if (drawable2 != null) {
            setLogo(drawable2);
        }
        CharSequence text4 = obtainStyledAttributes.getText(R.styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        int i3 = R.styleable.Toolbar_titleTextColor;
        if (obtainStyledAttributes.hasValue(i3)) {
            setTitleTextColor(obtainStyledAttributes.getColorStateList(i3));
        }
        int i4 = R.styleable.Toolbar_subtitleTextColor;
        if (obtainStyledAttributes.hasValue(i4)) {
            setSubtitleTextColor(obtainStyledAttributes.getColorStateList(i4));
        }
        int i5 = R.styleable.Toolbar_menu;
        if (obtainStyledAttributes.hasValue(i5)) {
            inflateMenu(obtainStyledAttributes.getResourceId(i5, 0));
        }
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.core.view.MenuHost
    @SuppressLint({"LambdaLast"})
    @MainThread
    public void addMenuProvider(@NonNull MenuProvider menuProvider, @NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.State state) {
        this.f1502G.addMenuProvider(menuProvider, lifecycleOwner, state);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ActionBar.LayoutParams) {
            return new LayoutParams((ActionBar.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }
}
