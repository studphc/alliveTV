package p000;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.ListViewAutoScrollHelper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class e70 extends ListView {
    public static final int INVALID_POSITION = -1;
    public static final int NO_POSITION = -1;

    /* renamed from: a */
    public final Rect f16685a;

    /* renamed from: b */
    public int f16686b;

    /* renamed from: c */
    public int f16687c;

    /* renamed from: d */
    public int f16688d;

    /* renamed from: e */
    public int f16689e;

    /* renamed from: f */
    public int f16690f;

    /* renamed from: g */
    public c70 f16691g;

    /* renamed from: h */
    public boolean f16692h;

    /* renamed from: i */
    public final boolean f16693i;

    /* renamed from: j */
    public boolean f16694j;

    /* renamed from: k */
    public ListViewAutoScrollHelper f16695k;

    /* renamed from: l */
    public RunnableC1104d f16696l;

    public e70(Context context, boolean z) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.f16685a = new Rect();
        this.f16686b = 0;
        this.f16687c = 0;
        this.f16688d = 0;
        this.f16689e = 0;
        this.f16693i = z;
        setCacheColorHint(0);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Drawable selector;
        Rect rect = this.f16685a;
        if (!rect.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(rect);
            selector.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.f16696l != null) {
            return;
        }
        super.drawableStateChanged();
        c70 c70Var = this.f16691g;
        if (c70Var != null) {
            c70Var.f8281b = true;
        }
        Drawable selector = getSelector();
        if (selector != null && this.f16694j && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        if (!this.f16693i && !super.hasFocus()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        if (!this.f16693i && !super.hasWindowFocus()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean isFocused() {
        if (!this.f16693i && !super.isFocused()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        if ((this.f16693i && this.f16692h) || super.isInTouchMode()) {
            return true;
        }
        return false;
    }

    public int lookForSelectablePosition(int i, boolean z) {
        int min;
        ListAdapter adapter = getAdapter();
        if (adapter != null && !isInTouchMode()) {
            int count = adapter.getCount();
            if (!getAdapter().areAllItemsEnabled()) {
                if (z) {
                    min = Math.max(0, i);
                    while (min < count && !adapter.isEnabled(min)) {
                        min++;
                    }
                } else {
                    min = Math.min(i, count - 1);
                    while (min >= 0 && !adapter.isEnabled(min)) {
                        min--;
                    }
                }
                if (min < 0 || min >= count) {
                    return -1;
                }
                return min;
            }
            if (i >= 0 && i < count) {
                return i;
            }
        }
        return -1;
    }

    public int measureHeightOfChildrenCompat(int i, int i2, int i3, int i4, int i5) {
        int makeMeasureSpec;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i6 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i7 = 0;
        int i8 = 0;
        View view = null;
        for (int i9 = 0; i9 < count; i9++) {
            int itemViewType = adapter.getItemViewType(i9);
            if (itemViewType != i7) {
                view = null;
                i7 = itemViewType;
            }
            view = adapter.getView(i9, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i10 = layoutParams.height;
            if (i10 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i10, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, makeMeasureSpec);
            view.forceLayout();
            if (i9 > 0) {
                i6 += dividerHeight;
            }
            i6 += view.getMeasuredHeight();
            if (i6 >= i4) {
                if (i5 >= 0 && i9 > i5 && i8 > 0 && i6 != i4) {
                    return i8;
                }
                return i4;
            }
            if (i5 >= 0 && i9 >= i5) {
                i8 = i6;
            }
        }
        return i6;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f16696l = null;
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0148 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onForwardedEvent(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        View childAt;
        View childAt2;
        int actionMasked = motionEvent.getActionMasked();
        boolean z5 = false;
        if (actionMasked != 1) {
            if (actionMasked != 2) {
                if (actionMasked != 3) {
                    z = true;
                    if (z || z5) {
                        this.f16694j = false;
                        setPressed(false);
                        drawableStateChanged();
                        childAt2 = getChildAt(this.f16690f - getFirstVisiblePosition());
                        if (childAt2 != null) {
                            childAt2.setPressed(false);
                        }
                    }
                    if (!z) {
                        if (this.f16695k == null) {
                            this.f16695k = new ListViewAutoScrollHelper(this);
                        }
                        this.f16695k.setEnabled(true);
                        this.f16695k.onTouch(this, motionEvent);
                    } else {
                        ListViewAutoScrollHelper listViewAutoScrollHelper = this.f16695k;
                        if (listViewAutoScrollHelper != null) {
                            listViewAutoScrollHelper.setEnabled(false);
                        }
                    }
                    return z;
                }
                z = false;
                if (z) {
                }
                this.f16694j = false;
                setPressed(false);
                drawableStateChanged();
                childAt2 = getChildAt(this.f16690f - getFirstVisiblePosition());
                if (childAt2 != null) {
                }
                if (!z) {
                }
                return z;
            }
            z = true;
        } else {
            z = false;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i);
        if (findPointerIndex >= 0) {
            int x = (int) motionEvent.getX(findPointerIndex);
            int y = (int) motionEvent.getY(findPointerIndex);
            int pointToPosition = pointToPosition(x, y);
            if (pointToPosition == -1) {
                z5 = true;
            } else {
                View childAt3 = getChildAt(pointToPosition - getFirstVisiblePosition());
                float f = x;
                float f2 = y;
                this.f16694j = true;
                int i2 = Build.VERSION.SDK_INT;
                z60.m8392a(this, f, f2);
                if (!isPressed()) {
                    setPressed(true);
                }
                layoutChildren();
                int i3 = this.f16690f;
                if (i3 != -1 && (childAt = getChildAt(i3 - getFirstVisiblePosition())) != null && childAt != childAt3 && childAt.isPressed()) {
                    childAt.setPressed(false);
                }
                this.f16690f = pointToPosition;
                z60.m8392a(childAt3, f - childAt3.getLeft(), f2 - childAt3.getTop());
                if (!childAt3.isPressed()) {
                    childAt3.setPressed(true);
                }
                Drawable selector = getSelector();
                if (selector != null && pointToPosition != -1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    selector.setVisible(false, false);
                }
                int left = childAt3.getLeft();
                int top = childAt3.getTop();
                int right = childAt3.getRight();
                int bottom = childAt3.getBottom();
                Rect rect = this.f16685a;
                rect.set(left, top, right, bottom);
                rect.left -= this.f16686b;
                rect.top -= this.f16687c;
                rect.right += this.f16688d;
                rect.bottom += this.f16689e;
                if (i2 >= 33) {
                    z3 = b70.m2062a(this);
                } else {
                    Field field = d70.f16278a;
                    if (field != null) {
                        try {
                            z3 = field.getBoolean(this);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                    z3 = false;
                }
                if (childAt3.isEnabled() != z3) {
                    boolean z6 = !z3;
                    if (Build.VERSION.SDK_INT >= 33) {
                        b70.m2063b(this, z6);
                    } else {
                        Field field2 = d70.f16278a;
                        if (field2 != null) {
                            try {
                                field2.set(this, Boolean.valueOf(z6));
                            } catch (IllegalAccessException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    if (pointToPosition != -1) {
                        refreshDrawableState();
                    }
                }
                if (z2) {
                    float exactCenterX = rect.exactCenterX();
                    float exactCenterY = rect.exactCenterY();
                    if (getVisibility() == 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    selector.setVisible(z4, false);
                    DrawableCompat.setHotspot(selector, exactCenterX, exactCenterY);
                }
                Drawable selector2 = getSelector();
                if (selector2 != null && pointToPosition != -1) {
                    DrawableCompat.setHotspot(selector2, f, f2);
                }
                c70 c70Var = this.f16691g;
                if (c70Var != null) {
                    c70Var.f8281b = false;
                }
                refreshDrawableState();
                if (actionMasked == 1) {
                    performItemClick(childAt3, pointToPosition, getItemIdAtPosition(pointToPosition));
                }
                z = true;
                z5 = false;
            }
            if (z) {
            }
            this.f16694j = false;
            setPressed(false);
            drawableStateChanged();
            childAt2 = getChildAt(this.f16690f - getFirstVisiblePosition());
            if (childAt2 != null) {
            }
            if (!z) {
            }
            return z;
        }
        z = false;
        if (z) {
        }
        this.f16694j = false;
        setPressed(false);
        drawableStateChanged();
        childAt2 = getChildAt(this.f16690f - getFirstVisiblePosition());
        if (childAt2 != null) {
        }
        if (!z) {
        }
        return z;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int i = Build.VERSION.SDK_INT;
        if (i < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f16696l == null) {
            RunnableC1104d runnableC1104d = new RunnableC1104d(15, this);
            this.f16696l = runnableC1104d;
            post(runnableC1104d);
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked != 9 && actionMasked != 7) {
            setSelection(-1);
        } else {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (pointToPosition != -1 && pointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i >= 30 && a70.f71d) {
                        try {
                            a70.f68a.invoke(this, Integer.valueOf(pointToPosition), childAt, Boolean.FALSE, -1, -1);
                            a70.f69b.invoke(this, Integer.valueOf(pointToPosition));
                            a70.f70c.invoke(this, Integer.valueOf(pointToPosition));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                    }
                }
                Drawable selector = getSelector();
                if (selector != null && this.f16694j && isPressed()) {
                    selector.setState(getDrawableState());
                }
            }
        }
        return onHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f16690f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        RunnableC1104d runnableC1104d = this.f16696l;
        if (runnableC1104d != null) {
            e70 e70Var = (e70) runnableC1104d.f16188b;
            e70Var.f16696l = null;
            e70Var.removeCallbacks(runnableC1104d);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z) {
        this.f16692h = z;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.appcompat.graphics.drawable.DrawableWrapperCompat, c70] */
    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        c70 c70Var;
        if (drawable != null) {
            ?? drawableWrapperCompat = new DrawableWrapperCompat(drawable);
            drawableWrapperCompat.f8281b = true;
            c70Var = drawableWrapperCompat;
        } else {
            c70Var = null;
        }
        this.f16691g = c70Var;
        super.setSelector(c70Var);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f16686b = rect.left;
        this.f16687c = rect.top;
        this.f16688d = rect.right;
        this.f16689e = rect.bottom;
    }
}
