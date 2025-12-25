package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.view.TintableBackgroundView;
import p000.AbstractC1497l3;
import p000.AbstractC1716q9;
import p000.C1345j8;
import p000.C1679p9;
import p000.C1901v9;
import p000.DialogInterfaceOnClickListenerC1753r9;
import p000.InterfaceC1938w9;
import p000.ViewTreeObserverOnGlobalLayoutListenerC1933w4;

/* loaded from: classes.dex */
public class AppCompatSpinner extends Spinner implements TintableBackgroundView {

    /* renamed from: i */
    public static final int[] f1202i = {R.attr.spinnerMode};

    /* renamed from: a */
    public final C1345j8 f1203a;

    /* renamed from: b */
    public final Context f1204b;

    /* renamed from: c */
    public final C1679p9 f1205c;

    /* renamed from: d */
    public SpinnerAdapter f1206d;

    /* renamed from: e */
    public final boolean f1207e;

    /* renamed from: f */
    public final InterfaceC1938w9 f1208f;

    /* renamed from: g */
    public int f1209g;

    /* renamed from: h */
    public final Rect f1210h;

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* renamed from: a */
        public boolean f1211a = false;

        /* renamed from: b */
        public int f1212b;

        /* renamed from: c */
        public int f1213c;

        public void mapProperties(@NonNull PropertyMapper propertyMapper) {
            int mapObject;
            int mapObject2;
            mapObject = propertyMapper.mapObject("backgroundTint", androidx.appcompat.R.attr.backgroundTint);
            this.f1212b = mapObject;
            mapObject2 = propertyMapper.mapObject("backgroundTintMode", androidx.appcompat.R.attr.backgroundTintMode);
            this.f1213c = mapObject2;
            this.f1211a = true;
        }

        public void readProperties(@NonNull AppCompatSpinner appCompatSpinner, @NonNull PropertyReader propertyReader) {
            if (this.f1211a) {
                propertyReader.readObject(this.f1212b, appCompatSpinner.getBackgroundTintList());
                propertyReader.readObject(this.f1213c, appCompatSpinner.getBackgroundTintMode());
                return;
            }
            throw AbstractC1497l3.m5831i();
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: a */
        public boolean f1214a;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f1214a ? (byte) 1 : (byte) 0);
        }
    }

    public AppCompatSpinner(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* renamed from: a */
    public final int m242a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i2 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
        }
        if (drawable != null) {
            Rect rect = this.f1210h;
            drawable.getPadding(rect);
            return i2 + rect.left + rect.right;
        }
        return i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1345j8 c1345j8 = this.f1203a;
        if (c1345j8 != null) {
            c1345j8.m5407a();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        InterfaceC1938w9 interfaceC1938w9 = this.f1208f;
        if (interfaceC1938w9 != null) {
            return interfaceC1938w9.getHorizontalOffset();
        }
        return super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        InterfaceC1938w9 interfaceC1938w9 = this.f1208f;
        if (interfaceC1938w9 != null) {
            return interfaceC1938w9.getVerticalOffset();
        }
        return super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.f1208f != null) {
            return this.f1209g;
        }
        return super.getDropDownWidth();
    }

    @VisibleForTesting
    public final InterfaceC1938w9 getInternalPopup() {
        return this.f1208f;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        InterfaceC1938w9 interfaceC1938w9 = this.f1208f;
        if (interfaceC1938w9 != null) {
            return interfaceC1938w9.getBackground();
        }
        return super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f1204b;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        InterfaceC1938w9 interfaceC1938w9 = this.f1208f;
        if (interfaceC1938w9 != null) {
            return interfaceC1938w9.mo7230a();
        }
        return super.getPrompt();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        C1345j8 c1345j8 = this.f1203a;
        if (c1345j8 != null) {
            return c1345j8.m5408b();
        }
        return null;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1345j8 c1345j8 = this.f1203a;
        if (c1345j8 != null) {
            return c1345j8.m5409c();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        InterfaceC1938w9 interfaceC1938w9 = this.f1208f;
        if (interfaceC1938w9 != null && interfaceC1938w9.isShowing()) {
            interfaceC1938w9.dismiss();
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1208f != null && View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m242a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f1214a && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC1933w4(1, this));
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View$BaseSavedState, android.os.Parcelable, androidx.appcompat.widget.AppCompatSpinner$SavedState] */
    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z;
        ?? baseSavedState = new View.BaseSavedState(super.onSaveInstanceState());
        InterfaceC1938w9 interfaceC1938w9 = this.f1208f;
        if (interfaceC1938w9 != null && interfaceC1938w9.isShowing()) {
            z = true;
        } else {
            z = false;
        }
        baseSavedState.f1214a = z;
        return baseSavedState;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        C1679p9 c1679p9 = this.f1205c;
        if (c1679p9 != null && c1679p9.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        InterfaceC1938w9 interfaceC1938w9 = this.f1208f;
        if (interfaceC1938w9 != null) {
            if (!interfaceC1938w9.isShowing()) {
                this.f1208f.mo7233d(getTextDirection(), getTextAlignment());
                return true;
            }
            return true;
        }
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1345j8 c1345j8 = this.f1203a;
        if (c1345j8 != null) {
            c1345j8.m5411e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        C1345j8 c1345j8 = this.f1203a;
        if (c1345j8 != null) {
            c1345j8.m5412f(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        InterfaceC1938w9 interfaceC1938w9 = this.f1208f;
        if (interfaceC1938w9 != null) {
            interfaceC1938w9.mo7232c(i);
            interfaceC1938w9.setHorizontalOffset(i);
        } else {
            super.setDropDownHorizontalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        InterfaceC1938w9 interfaceC1938w9 = this.f1208f;
        if (interfaceC1938w9 != null) {
            interfaceC1938w9.setVerticalOffset(i);
        } else {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.f1208f != null) {
            this.f1209g = i;
        } else {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        InterfaceC1938w9 interfaceC1938w9 = this.f1208f;
        if (interfaceC1938w9 != null) {
            interfaceC1938w9.setBackgroundDrawable(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(@DrawableRes int i) {
        setPopupBackgroundDrawable(AppCompatResources.getDrawable(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        InterfaceC1938w9 interfaceC1938w9 = this.f1208f;
        if (interfaceC1938w9 != null) {
            interfaceC1938w9.mo7231b(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        C1345j8 c1345j8 = this.f1203a;
        if (c1345j8 != null) {
            c1345j8.m5414h(colorStateList);
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        C1345j8 c1345j8 = this.f1203a;
        if (c1345j8 != null) {
            c1345j8.m5415i(mode);
        }
    }

    public AppCompatSpinner(@NonNull Context context, int i) {
        this(context, null, androidx.appcompat.R.attr.spinnerStyle, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.widget.ListAdapter, s9, java.lang.Object] */
    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f1207e) {
            this.f1206d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        InterfaceC1938w9 interfaceC1938w9 = this.f1208f;
        if (interfaceC1938w9 != 0) {
            Context context = this.f1204b;
            if (context == null) {
                context = getContext();
            }
            Resources.Theme theme = context.getTheme();
            ?? obj = new Object();
            obj.f26317a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                obj.f26318b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (spinnerAdapter instanceof android.widget.ThemedSpinnerAdapter) {
                    AbstractC1716q9.m7006a((android.widget.ThemedSpinnerAdapter) spinnerAdapter, theme);
                } else if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() == null) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                    }
                }
            }
            interfaceC1938w9.setAdapter(obj);
        }
    }

    public AppCompatSpinner(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.spinnerStyle);
    }

    public AppCompatSpinner(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public AppCompatSpinner(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0064, code lost:
    
        if (r11 == null) goto L31;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v7, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r6v0, types: [androidx.appcompat.widget.AppCompatSpinner, android.view.View] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AppCompatSpinner(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2, Resources.Theme theme) {
        super(context, attributeSet, i);
        TypedArray typedArray;
        this.f1210h = new Rect();
        ThemeUtils.checkAppCompatTheme(this, getContext());
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, androidx.appcompat.R.styleable.Spinner, i, 0);
        this.f1203a = new C1345j8(this);
        if (theme != null) {
            this.f1204b = new ContextThemeWrapper(context, theme);
        } else {
            int resourceId = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.Spinner_popupTheme, 0);
            if (resourceId != 0) {
                this.f1204b = new ContextThemeWrapper(context, resourceId);
            } else {
                this.f1204b = context;
            }
        }
        ?? r11 = -1;
        TypedArray typedArray2 = null;
        try {
            if (i2 == -1) {
                try {
                    typedArray = context.obtainStyledAttributes(attributeSet, f1202i, i, 0);
                    try {
                        boolean hasValue = typedArray.hasValue(0);
                        r11 = typedArray;
                        if (hasValue) {
                            i2 = typedArray.getInt(0, 0);
                            r11 = typedArray;
                        }
                    } catch (Exception e) {
                        e = e;
                        Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                        r11 = typedArray;
                    }
                } catch (Exception e2) {
                    e = e2;
                    typedArray = null;
                } catch (Throwable th) {
                    th = th;
                    if (typedArray2 != null) {
                        typedArray2.recycle();
                    }
                    throw th;
                }
                r11.recycle();
            }
            if (i2 == 0) {
                DialogInterfaceOnClickListenerC1753r9 dialogInterfaceOnClickListenerC1753r9 = new DialogInterfaceOnClickListenerC1753r9(this);
                this.f1208f = dialogInterfaceOnClickListenerC1753r9;
                dialogInterfaceOnClickListenerC1753r9.f25906c = obtainStyledAttributes.getString(androidx.appcompat.R.styleable.Spinner_android_prompt);
            } else if (i2 == 1) {
                C1901v9 c1901v9 = new C1901v9(this, this.f1204b, attributeSet, i);
                TintTypedArray obtainStyledAttributes2 = TintTypedArray.obtainStyledAttributes(this.f1204b, attributeSet, androidx.appcompat.R.styleable.Spinner, i, 0);
                this.f1209g = obtainStyledAttributes2.getLayoutDimension(androidx.appcompat.R.styleable.Spinner_android_dropDownWidth, -2);
                c1901v9.setBackgroundDrawable(obtainStyledAttributes2.getDrawable(androidx.appcompat.R.styleable.Spinner_android_popupBackground));
                c1901v9.f27671J = obtainStyledAttributes.getString(androidx.appcompat.R.styleable.Spinner_android_prompt);
                obtainStyledAttributes2.recycle();
                this.f1208f = c1901v9;
                this.f1205c = new C1679p9(this, this, c1901v9);
            }
            CharSequence[] textArray = obtainStyledAttributes.getTextArray(androidx.appcompat.R.styleable.Spinner_android_entries);
            if (textArray != null) {
                ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.simple_spinner_item, textArray);
                arrayAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                setAdapter(arrayAdapter);
            }
            obtainStyledAttributes.recycle();
            this.f1207e = true;
            SpinnerAdapter spinnerAdapter = this.f1206d;
            if (spinnerAdapter != null) {
                setAdapter(spinnerAdapter);
                this.f1206d = null;
            }
            this.f1203a.m5410d(attributeSet, i);
        } catch (Throwable th2) {
            th = th2;
            typedArray2 = r11;
        }
    }
}
