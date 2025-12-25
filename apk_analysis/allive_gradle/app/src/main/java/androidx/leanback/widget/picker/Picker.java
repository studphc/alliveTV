package androidx.leanback.widget.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.leanback.R;
import androidx.leanback.widget.VerticalGridView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p000.AbstractC1726qj;
import p000.n42;
import p000.o42;

/* loaded from: classes.dex */
public class Picker extends FrameLayout {

    /* renamed from: a */
    public final ViewGroup f6359a;

    /* renamed from: b */
    public final ArrayList f6360b;

    /* renamed from: c */
    public ArrayList f6361c;

    /* renamed from: d */
    public final float f6362d;

    /* renamed from: e */
    public final float f6363e;

    /* renamed from: f */
    public final float f6364f;

    /* renamed from: g */
    public final int f6365g;

    /* renamed from: h */
    public final DecelerateInterpolator f6366h;

    /* renamed from: i */
    public ArrayList f6367i;

    /* renamed from: j */
    public float f6368j;

    /* renamed from: k */
    public float f6369k;

    /* renamed from: l */
    public int f6370l;

    /* renamed from: m */
    public final ArrayList f6371m;

    /* renamed from: n */
    public int f6372n;

    /* renamed from: o */
    public int f6373o;

    /* renamed from: p */
    public final n42 f6374p;

    /* loaded from: classes.dex */
    public interface PickerValueListener {
        void onValueChanged(@NonNull Picker picker, int i);
    }

    public Picker(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.pickerStyle);
    }

    /* renamed from: a */
    public final void m1512a(View view, boolean z, float f, DecelerateInterpolator decelerateInterpolator) {
        view.animate().cancel();
        if (!z) {
            view.setAlpha(f);
        } else {
            view.animate().alpha(f).setDuration(this.f6365g).setInterpolator(decelerateInterpolator).start();
        }
    }

    public void addOnValueChangedListener(@NonNull PickerValueListener pickerValueListener) {
        if (this.f6367i == null) {
            this.f6367i = new ArrayList();
        }
        this.f6367i.add(pickerValueListener);
    }

    /* renamed from: b */
    public final void m1513b(View view, boolean z, int i, boolean z2) {
        boolean z3;
        if (i != this.f6370l && hasFocus()) {
            z3 = false;
        } else {
            z3 = true;
        }
        DecelerateInterpolator decelerateInterpolator = this.f6366h;
        if (z) {
            if (z3) {
                m1512a(view, z2, this.f6363e, decelerateInterpolator);
                return;
            } else {
                m1512a(view, z2, this.f6362d, decelerateInterpolator);
                return;
            }
        }
        if (z3) {
            m1512a(view, z2, this.f6364f, decelerateInterpolator);
        } else {
            m1512a(view, z2, RecyclerView.f7068F0, decelerateInterpolator);
        }
    }

    /* renamed from: c */
    public final void m1514c(int i) {
        boolean z;
        VerticalGridView verticalGridView = (VerticalGridView) this.f6360b.get(i);
        int selectedPosition = verticalGridView.getSelectedPosition();
        for (int i2 = 0; i2 < verticalGridView.getAdapter().getItemCount(); i2++) {
            View findViewByPosition = verticalGridView.getLayoutManager().findViewByPosition(i2);
            if (findViewByPosition != null) {
                if (selectedPosition == i2) {
                    z = true;
                } else {
                    z = false;
                }
                m1513b(findViewByPosition, z, i, true);
            }
        }
    }

    /* renamed from: d */
    public final void m1515d() {
        for (int i = 0; i < getColumnsCount(); i++) {
            m1516e((VerticalGridView) this.f6360b.get(i));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (isActivated()) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 23 && keyCode != 66) {
                return super.dispatchKeyEvent(keyEvent);
            }
            if (keyEvent.getAction() == 1) {
                performClick();
            }
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* renamed from: e */
    public final void m1516e(VerticalGridView verticalGridView) {
        float visibleItemCount;
        ViewGroup.LayoutParams layoutParams = verticalGridView.getLayoutParams();
        if (isActivated()) {
            visibleItemCount = getActivatedVisibleItemCount();
        } else {
            visibleItemCount = getVisibleItemCount();
        }
        layoutParams.height = (int) AbstractC1726qj.m7051g(visibleItemCount, 1.0f, verticalGridView.getVerticalSpacing(), getPickerItemHeightPixels() * visibleItemCount);
        verticalGridView.setLayoutParams(layoutParams);
    }

    public float getActivatedVisibleItemCount() {
        return this.f6368j;
    }

    @Nullable
    public PickerColumn getColumnAt(int i) {
        ArrayList arrayList = this.f6361c;
        if (arrayList == null) {
            return null;
        }
        return (PickerColumn) arrayList.get(i);
    }

    public int getColumnsCount() {
        ArrayList arrayList = this.f6361c;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public int getPickerItemHeightPixels() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.picker_item_height);
    }

    @LayoutRes
    public final int getPickerItemLayoutId() {
        return this.f6372n;
    }

    @IdRes
    public final int getPickerItemTextViewId() {
        return this.f6373o;
    }

    public int getSelectedColumn() {
        return this.f6370l;
    }

    @Deprecated
    public final CharSequence getSeparator() {
        return (CharSequence) this.f6371m.get(0);
    }

    @NonNull
    public final List<CharSequence> getSeparators() {
        return this.f6371m;
    }

    public float getVisibleItemCount() {
        return 1.0f;
    }

    public void onColumnValueChanged(int i, int i2) {
        PickerColumn pickerColumn = (PickerColumn) this.f6361c.get(i);
        if (pickerColumn.getCurrentValue() != i2) {
            pickerColumn.setCurrentValue(i2);
            ArrayList arrayList = this.f6367i;
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((PickerValueListener) this.f6367i.get(size)).onValueChanged(this, i);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int selectedColumn = getSelectedColumn();
        if (selectedColumn >= 0) {
            ArrayList arrayList = this.f6360b;
            if (selectedColumn < arrayList.size()) {
                return ((VerticalGridView) arrayList.get(selectedColumn)).requestFocus(i, rect);
            }
            return false;
        }
        return false;
    }

    public void removeOnValueChangedListener(@NonNull PickerValueListener pickerValueListener) {
        ArrayList arrayList = this.f6367i;
        if (arrayList != null) {
            arrayList.remove(pickerValueListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f6360b;
            if (i < arrayList.size()) {
                if (((VerticalGridView) arrayList.get(i)).hasFocus()) {
                    setSelectedColumn(i);
                }
                i++;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    public void setActivated(boolean z) {
        ArrayList arrayList;
        if (z == isActivated()) {
            super.setActivated(z);
            return;
        }
        super.setActivated(z);
        boolean hasFocus = hasFocus();
        int selectedColumn = getSelectedColumn();
        setDescendantFocusability(131072);
        if (!z && hasFocus && isFocusable()) {
            requestFocus();
        }
        int i = 0;
        while (true) {
            int columnsCount = getColumnsCount();
            arrayList = this.f6360b;
            if (i >= columnsCount) {
                break;
            }
            ((VerticalGridView) arrayList.get(i)).setFocusable(z);
            i++;
        }
        m1515d();
        boolean isActivated = isActivated();
        for (int i2 = 0; i2 < getColumnsCount(); i2++) {
            VerticalGridView verticalGridView = (VerticalGridView) arrayList.get(i2);
            for (int i3 = 0; i3 < verticalGridView.getChildCount(); i3++) {
                verticalGridView.getChildAt(i3).setFocusable(isActivated);
            }
        }
        if (z && hasFocus && selectedColumn >= 0) {
            ((VerticalGridView) arrayList.get(selectedColumn)).requestFocus();
        }
        setDescendantFocusability(262144);
    }

    public void setActivatedVisibleItemCount(float f) {
        if (f > RecyclerView.f7068F0) {
            if (this.f6368j != f) {
                this.f6368j = f;
                if (isActivated()) {
                    m1515d();
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    public void setColumnAt(int i, @NonNull PickerColumn pickerColumn) {
        this.f6361c.set(i, pickerColumn);
        VerticalGridView verticalGridView = (VerticalGridView) this.f6360b.get(i);
        o42 o42Var = (o42) verticalGridView.getAdapter();
        if (o42Var != null) {
            o42Var.notifyDataSetChanged();
        }
        verticalGridView.setSelectedPosition(pickerColumn.getCurrentValue() - pickerColumn.getMinValue());
    }

    public void setColumnValue(int i, int i2, boolean z) {
        PickerColumn pickerColumn = (PickerColumn) this.f6361c.get(i);
        if (pickerColumn.getCurrentValue() != i2) {
            pickerColumn.setCurrentValue(i2);
            ArrayList arrayList = this.f6367i;
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((PickerValueListener) this.f6367i.get(size)).onValueChanged(this, i);
                }
            }
            VerticalGridView verticalGridView = (VerticalGridView) this.f6360b.get(i);
            if (verticalGridView != null) {
                int minValue = i2 - ((PickerColumn) this.f6361c.get(i)).getMinValue();
                if (z) {
                    verticalGridView.setSelectedPositionSmooth(minValue);
                } else {
                    verticalGridView.setSelectedPosition(minValue);
                }
            }
        }
    }

    public void setColumns(@NonNull List<PickerColumn> list) {
        ArrayList arrayList = this.f6371m;
        if (arrayList.size() != 0) {
            if (arrayList.size() == 1) {
                CharSequence charSequence = (CharSequence) arrayList.get(0);
                arrayList.clear();
                arrayList.add("");
                for (int i = 0; i < list.size() - 1; i++) {
                    arrayList.add(charSequence);
                }
                arrayList.add("");
            } else if (arrayList.size() != list.size() + 1) {
                throw new IllegalStateException("Separators size: " + arrayList.size() + " mustequal the size of columns: " + list.size() + " + 1");
            }
            ArrayList arrayList2 = this.f6360b;
            arrayList2.clear();
            ViewGroup viewGroup = this.f6359a;
            viewGroup.removeAllViews();
            ArrayList arrayList3 = new ArrayList(list);
            this.f6361c = arrayList3;
            if (this.f6370l > arrayList3.size() - 1) {
                this.f6370l = this.f6361c.size() - 1;
            }
            LayoutInflater from = LayoutInflater.from(getContext());
            int columnsCount = getColumnsCount();
            if (!TextUtils.isEmpty((CharSequence) arrayList.get(0))) {
                TextView textView = (TextView) from.inflate(R.layout.lb_picker_separator, viewGroup, false);
                textView.setText((CharSequence) arrayList.get(0));
                viewGroup.addView(textView);
            }
            int i2 = 0;
            while (i2 < columnsCount) {
                VerticalGridView verticalGridView = (VerticalGridView) from.inflate(R.layout.lb_picker_column, viewGroup, false);
                m1516e(verticalGridView);
                verticalGridView.setWindowAlignment(0);
                verticalGridView.setHasFixedSize(false);
                verticalGridView.setFocusable(isActivated());
                verticalGridView.setItemViewCacheSize(0);
                arrayList2.add(verticalGridView);
                viewGroup.addView(verticalGridView);
                int i3 = i2 + 1;
                if (!TextUtils.isEmpty((CharSequence) arrayList.get(i3))) {
                    TextView textView2 = (TextView) from.inflate(R.layout.lb_picker_separator, viewGroup, false);
                    textView2.setText((CharSequence) arrayList.get(i3));
                    viewGroup.addView(textView2);
                }
                verticalGridView.setAdapter(new o42(this, getPickerItemLayoutId(), getPickerItemTextViewId(), i2));
                verticalGridView.setOnChildViewHolderSelectedListener(this.f6374p);
                i2 = i3;
            }
            return;
        }
        throw new IllegalStateException("Separators size is: " + arrayList.size() + ". At least one separator must be provided");
    }

    public final void setPickerItemLayoutId(@LayoutRes int i) {
        this.f6372n = i;
    }

    public final void setPickerItemTextViewId(@IdRes int i) {
        this.f6373o = i;
    }

    public void setSelectedColumn(int i) {
        int i2 = this.f6370l;
        ArrayList arrayList = this.f6360b;
        if (i2 != i) {
            this.f6370l = i;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                m1514c(i3);
            }
        }
        VerticalGridView verticalGridView = (VerticalGridView) arrayList.get(i);
        if (hasFocus() && !verticalGridView.hasFocus()) {
            verticalGridView.requestFocus();
        }
    }

    public final void setSeparator(@NonNull CharSequence charSequence) {
        setSeparators(Arrays.asList(charSequence));
    }

    public final void setSeparators(@NonNull List<CharSequence> list) {
        ArrayList arrayList = this.f6371m;
        arrayList.clear();
        arrayList.addAll(list);
    }

    public void setVisibleItemCount(float f) {
        if (f > RecyclerView.f7068F0) {
            if (this.f6369k != f) {
                this.f6369k = f;
                if (!isActivated()) {
                    m1515d();
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    @SuppressLint({"CustomViewStyleable"})
    public Picker(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6360b = new ArrayList();
        this.f6368j = 3.0f;
        this.f6369k = 1.0f;
        this.f6370l = 0;
        this.f6371m = new ArrayList();
        this.f6374p = new n42(this);
        int[] iArr = R.styleable.lbPicker;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes, i, 0);
        this.f6372n = obtainStyledAttributes.getResourceId(R.styleable.lbPicker_pickerItemLayout, R.layout.lb_picker_item);
        this.f6373o = obtainStyledAttributes.getResourceId(R.styleable.lbPicker_pickerItemTextViewId, 0);
        obtainStyledAttributes.recycle();
        setEnabled(true);
        setDescendantFocusability(262144);
        this.f6363e = 1.0f;
        this.f6362d = 1.0f;
        this.f6364f = 0.5f;
        this.f6365g = 200;
        this.f6366h = new DecelerateInterpolator(2.5f);
        this.f6359a = (ViewGroup) ((ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.lb_picker, (ViewGroup) this, true)).findViewById(R.id.picker);
    }
}
