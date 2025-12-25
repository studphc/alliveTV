package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.ArrayRes;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import p000.C1788s7;
import p000.ViewOnClickListenerC1109d4;

/* loaded from: classes.dex */
public class AlertDialog extends AppCompatDialog implements DialogInterface {

    /* renamed from: f */
    public final C1788s7 f589f;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a */
        public final AlertController$AlertParams f590a;

        /* renamed from: b */
        public final int f591b;

        public Builder(@NonNull Context context) {
            this(context, AlertDialog.m157e(0, context));
        }

        @NonNull
        public AlertDialog create() {
            AlertController$AlertParams alertController$AlertParams = this.f590a;
            AlertDialog alertDialog = new AlertDialog(alertController$AlertParams.mContext, this.f591b);
            alertController$AlertParams.apply(alertDialog.f589f);
            alertDialog.setCancelable(alertController$AlertParams.mCancelable);
            if (alertController$AlertParams.mCancelable) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(alertController$AlertParams.mOnCancelListener);
            alertDialog.setOnDismissListener(alertController$AlertParams.mOnDismissListener);
            DialogInterface.OnKeyListener onKeyListener = alertController$AlertParams.mOnKeyListener;
            if (onKeyListener != null) {
                alertDialog.setOnKeyListener(onKeyListener);
            }
            return alertDialog;
        }

        @NonNull
        public Context getContext() {
            return this.f590a.mContext;
        }

        public Builder setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController$AlertParams alertController$AlertParams = this.f590a;
            alertController$AlertParams.mAdapter = listAdapter;
            alertController$AlertParams.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.f590a.mCancelable = z;
            return this;
        }

        public Builder setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            AlertController$AlertParams alertController$AlertParams = this.f590a;
            alertController$AlertParams.mCursor = cursor;
            alertController$AlertParams.mLabelColumn = str;
            alertController$AlertParams.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setCustomTitle(@Nullable View view) {
            this.f590a.mCustomTitleView = view;
            return this;
        }

        public Builder setIcon(@DrawableRes int i) {
            this.f590a.mIconId = i;
            return this;
        }

        public Builder setIconAttribute(@AttrRes int i) {
            TypedValue typedValue = new TypedValue();
            AlertController$AlertParams alertController$AlertParams = this.f590a;
            alertController$AlertParams.mContext.getTheme().resolveAttribute(i, typedValue, true);
            alertController$AlertParams.mIconId = typedValue.resourceId;
            return this;
        }

        @Deprecated
        public Builder setInverseBackgroundForced(boolean z) {
            this.f590a.mForceInverseBackground = z;
            return this;
        }

        public Builder setItems(@ArrayRes int i, DialogInterface.OnClickListener onClickListener) {
            AlertController$AlertParams alertController$AlertParams = this.f590a;
            alertController$AlertParams.mItems = alertController$AlertParams.mContext.getResources().getTextArray(i);
            alertController$AlertParams.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setMessage(@StringRes int i) {
            AlertController$AlertParams alertController$AlertParams = this.f590a;
            alertController$AlertParams.mMessage = alertController$AlertParams.mContext.getText(i);
            return this;
        }

        public Builder setMultiChoiceItems(@ArrayRes int i, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController$AlertParams alertController$AlertParams = this.f590a;
            alertController$AlertParams.mItems = alertController$AlertParams.mContext.getResources().getTextArray(i);
            alertController$AlertParams.mOnCheckboxClickListener = onMultiChoiceClickListener;
            alertController$AlertParams.mCheckedItems = zArr;
            alertController$AlertParams.mIsMultiChoice = true;
            return this;
        }

        public Builder setNegativeButton(@StringRes int i, DialogInterface.OnClickListener onClickListener) {
            AlertController$AlertParams alertController$AlertParams = this.f590a;
            alertController$AlertParams.mNegativeButtonText = alertController$AlertParams.mContext.getText(i);
            alertController$AlertParams.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNegativeButtonIcon(Drawable drawable) {
            this.f590a.mNegativeButtonIcon = drawable;
            return this;
        }

        public Builder setNeutralButton(@StringRes int i, DialogInterface.OnClickListener onClickListener) {
            AlertController$AlertParams alertController$AlertParams = this.f590a;
            alertController$AlertParams.mNeutralButtonText = alertController$AlertParams.mContext.getText(i);
            alertController$AlertParams.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButtonIcon(Drawable drawable) {
            this.f590a.mNeutralButtonIcon = drawable;
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.f590a.mOnCancelListener = onCancelListener;
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.f590a.mOnDismissListener = onDismissListener;
            return this;
        }

        public Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.f590a.mOnItemSelectedListener = onItemSelectedListener;
            return this;
        }

        public Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.f590a.mOnKeyListener = onKeyListener;
            return this;
        }

        public Builder setPositiveButton(@StringRes int i, DialogInterface.OnClickListener onClickListener) {
            AlertController$AlertParams alertController$AlertParams = this.f590a;
            alertController$AlertParams.mPositiveButtonText = alertController$AlertParams.mContext.getText(i);
            alertController$AlertParams.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setPositiveButtonIcon(Drawable drawable) {
            this.f590a.mPositiveButtonIcon = drawable;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder setRecycleOnMeasureEnabled(boolean z) {
            this.f590a.mRecycleOnMeasure = z;
            return this;
        }

        public Builder setSingleChoiceItems(@ArrayRes int i, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController$AlertParams alertController$AlertParams = this.f590a;
            alertController$AlertParams.mItems = alertController$AlertParams.mContext.getResources().getTextArray(i);
            alertController$AlertParams.mOnClickListener = onClickListener;
            alertController$AlertParams.mCheckedItem = i2;
            alertController$AlertParams.mIsSingleChoice = true;
            return this;
        }

        public Builder setTitle(@StringRes int i) {
            AlertController$AlertParams alertController$AlertParams = this.f590a;
            alertController$AlertParams.mTitle = alertController$AlertParams.mContext.getText(i);
            return this;
        }

        public Builder setView(int i) {
            AlertController$AlertParams alertController$AlertParams = this.f590a;
            alertController$AlertParams.mView = null;
            alertController$AlertParams.mViewLayoutResId = i;
            alertController$AlertParams.mViewSpacingSpecified = false;
            return this;
        }

        public AlertDialog show() {
            AlertDialog create = create();
            create.show();
            return create;
        }

        public Builder(@NonNull Context context, @StyleRes int i) {
            this.f590a = new AlertController$AlertParams(new ContextThemeWrapper(context, AlertDialog.m157e(i, context)));
            this.f591b = i;
        }

        public Builder setIcon(@Nullable Drawable drawable) {
            this.f590a.mIcon = drawable;
            return this;
        }

        public Builder setMessage(@Nullable CharSequence charSequence) {
            this.f590a.mMessage = charSequence;
            return this;
        }

        public Builder setTitle(@Nullable CharSequence charSequence) {
            this.f590a.mTitle = charSequence;
            return this;
        }

        public Builder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            AlertController$AlertParams alertController$AlertParams = this.f590a;
            alertController$AlertParams.mItems = charSequenceArr;
            alertController$AlertParams.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController$AlertParams alertController$AlertParams = this.f590a;
            alertController$AlertParams.mNegativeButtonText = charSequence;
            alertController$AlertParams.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController$AlertParams alertController$AlertParams = this.f590a;
            alertController$AlertParams.mNeutralButtonText = charSequence;
            alertController$AlertParams.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController$AlertParams alertController$AlertParams = this.f590a;
            alertController$AlertParams.mPositiveButtonText = charSequence;
            alertController$AlertParams.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setView(View view) {
            AlertController$AlertParams alertController$AlertParams = this.f590a;
            alertController$AlertParams.mView = view;
            alertController$AlertParams.mViewLayoutResId = 0;
            alertController$AlertParams.mViewSpacingSpecified = false;
            return this;
        }

        public Builder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController$AlertParams alertController$AlertParams = this.f590a;
            alertController$AlertParams.mItems = charSequenceArr;
            alertController$AlertParams.mOnCheckboxClickListener = onMultiChoiceClickListener;
            alertController$AlertParams.mCheckedItems = zArr;
            alertController$AlertParams.mIsMultiChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(Cursor cursor, int i, String str, DialogInterface.OnClickListener onClickListener) {
            AlertController$AlertParams alertController$AlertParams = this.f590a;
            alertController$AlertParams.mCursor = cursor;
            alertController$AlertParams.mOnClickListener = onClickListener;
            alertController$AlertParams.mCheckedItem = i;
            alertController$AlertParams.mLabelColumn = str;
            alertController$AlertParams.mIsSingleChoice = true;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public Builder setView(View view, int i, int i2, int i3, int i4) {
            AlertController$AlertParams alertController$AlertParams = this.f590a;
            alertController$AlertParams.mView = view;
            alertController$AlertParams.mViewLayoutResId = 0;
            alertController$AlertParams.mViewSpacingSpecified = true;
            alertController$AlertParams.mViewSpacingLeft = i;
            alertController$AlertParams.mViewSpacingTop = i2;
            alertController$AlertParams.mViewSpacingRight = i3;
            alertController$AlertParams.mViewSpacingBottom = i4;
            return this;
        }

        public Builder setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController$AlertParams alertController$AlertParams = this.f590a;
            alertController$AlertParams.mCursor = cursor;
            alertController$AlertParams.mOnCheckboxClickListener = onMultiChoiceClickListener;
            alertController$AlertParams.mIsCheckedColumn = str;
            alertController$AlertParams.mLabelColumn = str2;
            alertController$AlertParams.mIsMultiChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            AlertController$AlertParams alertController$AlertParams = this.f590a;
            alertController$AlertParams.mItems = charSequenceArr;
            alertController$AlertParams.mOnClickListener = onClickListener;
            alertController$AlertParams.mCheckedItem = i;
            alertController$AlertParams.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            AlertController$AlertParams alertController$AlertParams = this.f590a;
            alertController$AlertParams.mAdapter = listAdapter;
            alertController$AlertParams.mOnClickListener = onClickListener;
            alertController$AlertParams.mCheckedItem = i;
            alertController$AlertParams.mIsSingleChoice = true;
            return this;
        }
    }

    public AlertDialog(@NonNull Context context) {
        this(context, 0);
    }

    /* renamed from: e */
    public static int m157e(int i, Context context) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button getButton(int i) {
        C1788s7 c1788s7 = this.f589f;
        if (i != -3) {
            if (i != -2) {
                if (i != -1) {
                    c1788s7.getClass();
                    return null;
                }
                return c1788s7.f26294o;
            }
            return c1788s7.f26298s;
        }
        return c1788s7.f26302w;
    }

    public ListView getListView() {
        return this.f589f.f26286g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        boolean z;
        int i;
        View view;
        int i2;
        int i3;
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        ListAdapter listAdapter;
        int i5;
        View findViewById;
        super.onCreate(bundle);
        C1788s7 c1788s7 = this.f589f;
        c1788s7.f26281b.setContentView(c1788s7.f26272J);
        int i6 = R.id.parentPanel;
        Window window = c1788s7.f26282c;
        View findViewById2 = window.findViewById(i6);
        int i7 = R.id.topPanel;
        View findViewById3 = findViewById2.findViewById(i7);
        int i8 = R.id.contentPanel;
        View findViewById4 = findViewById2.findViewById(i8);
        int i9 = R.id.buttonPanel;
        View findViewById5 = findViewById2.findViewById(i9);
        ViewGroup viewGroup = (ViewGroup) findViewById2.findViewById(R.id.customPanel);
        View view2 = c1788s7.f26287h;
        Context context = c1788s7.f26280a;
        if (view2 == null) {
            if (c1788s7.f26288i != 0) {
                view2 = LayoutInflater.from(context).inflate(c1788s7.f26288i, viewGroup, false);
            } else {
                view2 = null;
            }
        }
        if (view2 != null) {
            z = true;
        } else {
            z = false;
        }
        if (!z || !C1788s7.m7339a(view2)) {
            window.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) window.findViewById(R.id.custom);
            frameLayout.addView(view2, new ViewGroup.LayoutParams(-1, -1));
            if (c1788s7.f26293n) {
                frameLayout.setPadding(c1788s7.f26289j, c1788s7.f26290k, c1788s7.f26291l, c1788s7.f26292m);
            }
            if (c1788s7.f26286g != null) {
                ((LinearLayout.LayoutParams) ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams())).weight = RecyclerView.f7068F0;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View findViewById6 = viewGroup.findViewById(i7);
        View findViewById7 = viewGroup.findViewById(i8);
        View findViewById8 = viewGroup.findViewById(i9);
        ViewGroup m7340b = C1788s7.m7340b(findViewById6, findViewById3);
        ViewGroup m7340b2 = C1788s7.m7340b(findViewById7, findViewById4);
        ViewGroup m7340b3 = C1788s7.m7340b(findViewById8, findViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) window.findViewById(R.id.scrollView);
        c1788s7.f26263A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        c1788s7.f26263A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) m7340b2.findViewById(android.R.id.message);
        c1788s7.f26268F = textView;
        if (textView != null) {
            CharSequence charSequence = c1788s7.f26285f;
            if (charSequence != null) {
                textView.setText(charSequence);
            } else {
                textView.setVisibility(8);
                c1788s7.f26263A.removeView(c1788s7.f26268F);
                if (c1788s7.f26286g != null) {
                    ViewGroup viewGroup2 = (ViewGroup) c1788s7.f26263A.getParent();
                    int indexOfChild = viewGroup2.indexOfChild(c1788s7.f26263A);
                    viewGroup2.removeViewAt(indexOfChild);
                    viewGroup2.addView(c1788s7.f26286g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    m7340b2.setVisibility(8);
                }
            }
        }
        Button button = (Button) m7340b3.findViewById(android.R.id.button1);
        c1788s7.f26294o = button;
        ViewOnClickListenerC1109d4 viewOnClickListenerC1109d4 = c1788s7.f26279Q;
        button.setOnClickListener(viewOnClickListenerC1109d4);
        boolean isEmpty = TextUtils.isEmpty(c1788s7.f26295p);
        int i10 = c1788s7.f26283d;
        if (isEmpty && c1788s7.f26297r == null) {
            c1788s7.f26294o.setVisibility(8);
            i = 0;
        } else {
            c1788s7.f26294o.setText(c1788s7.f26295p);
            Drawable drawable = c1788s7.f26297r;
            if (drawable != null) {
                drawable.setBounds(0, 0, i10, i10);
                c1788s7.f26294o.setCompoundDrawables(c1788s7.f26297r, null, null, null);
            }
            c1788s7.f26294o.setVisibility(0);
            i = 1;
        }
        Button button2 = (Button) m7340b3.findViewById(android.R.id.button2);
        c1788s7.f26298s = button2;
        button2.setOnClickListener(viewOnClickListenerC1109d4);
        if (TextUtils.isEmpty(c1788s7.f26299t) && c1788s7.f26301v == null) {
            c1788s7.f26298s.setVisibility(8);
        } else {
            c1788s7.f26298s.setText(c1788s7.f26299t);
            Drawable drawable2 = c1788s7.f26301v;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, i10, i10);
                c1788s7.f26298s.setCompoundDrawables(c1788s7.f26301v, null, null, null);
            }
            c1788s7.f26298s.setVisibility(0);
            i |= 2;
        }
        Button button3 = (Button) m7340b3.findViewById(android.R.id.button3);
        c1788s7.f26302w = button3;
        button3.setOnClickListener(viewOnClickListenerC1109d4);
        if (TextUtils.isEmpty(c1788s7.f26303x) && c1788s7.f26305z == null) {
            c1788s7.f26302w.setVisibility(8);
            view = null;
        } else {
            c1788s7.f26302w.setText(c1788s7.f26303x);
            Drawable drawable3 = c1788s7.f26305z;
            if (drawable3 != null) {
                drawable3.setBounds(0, 0, i10, i10);
                view = null;
                c1788s7.f26302w.setCompoundDrawables(c1788s7.f26305z, null, null, null);
            } else {
                view = null;
            }
            c1788s7.f26302w.setVisibility(0);
            i |= 4;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (i == 1) {
                Button button4 = c1788s7.f26294o;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button4.getLayoutParams();
                layoutParams.gravity = 1;
                layoutParams.weight = 0.5f;
                button4.setLayoutParams(layoutParams);
            } else if (i == 2) {
                Button button5 = c1788s7.f26298s;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button5.getLayoutParams();
                layoutParams2.gravity = 1;
                layoutParams2.weight = 0.5f;
                button5.setLayoutParams(layoutParams2);
            } else if (i == 4) {
                Button button6 = c1788s7.f26302w;
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) button6.getLayoutParams();
                layoutParams3.gravity = 1;
                layoutParams3.weight = 0.5f;
                button6.setLayoutParams(layoutParams3);
            }
        }
        if (i != 0) {
            i2 = 8;
        } else {
            i2 = 8;
            m7340b3.setVisibility(8);
        }
        if (c1788s7.f26269G != null) {
            m7340b.addView(c1788s7.f26269G, 0, new ViewGroup.LayoutParams(-1, -2));
            window.findViewById(R.id.title_template).setVisibility(i2);
            i3 = i2;
        } else {
            c1788s7.f26266D = (ImageView) window.findViewById(android.R.id.icon);
            if (!TextUtils.isEmpty(c1788s7.f26284e) && c1788s7.f26277O) {
                TextView textView2 = (TextView) window.findViewById(R.id.alertTitle);
                c1788s7.f26267E = textView2;
                textView2.setText(c1788s7.f26284e);
                int i11 = c1788s7.f26264B;
                if (i11 != 0) {
                    c1788s7.f26266D.setImageResource(i11);
                } else {
                    Drawable drawable4 = c1788s7.f26265C;
                    if (drawable4 != null) {
                        c1788s7.f26266D.setImageDrawable(drawable4);
                    } else {
                        c1788s7.f26267E.setPadding(c1788s7.f26266D.getPaddingLeft(), c1788s7.f26266D.getPaddingTop(), c1788s7.f26266D.getPaddingRight(), c1788s7.f26266D.getPaddingBottom());
                        i3 = 8;
                        c1788s7.f26266D.setVisibility(8);
                    }
                }
                i3 = 8;
            } else {
                i3 = 8;
                window.findViewById(R.id.title_template).setVisibility(8);
                c1788s7.f26266D.setVisibility(8);
                m7340b.setVisibility(8);
            }
        }
        if (viewGroup.getVisibility() != i3) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (m7340b != null && m7340b.getVisibility() != i3) {
            z3 = 1;
        } else {
            z3 = 0;
        }
        if (m7340b3.getVisibility() != i3) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4 && (findViewById = m7340b2.findViewById(R.id.textSpacerNoButtons)) != null) {
            findViewById.setVisibility(0);
        }
        if (z3 != 0) {
            NestedScrollView nestedScrollView2 = c1788s7.f26263A;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            if (c1788s7.f26285f != null || c1788s7.f26286g != null) {
                view = m7340b.findViewById(R.id.titleDividerNoCustom);
            }
            i4 = 0;
            if (view != null) {
                view.setVisibility(0);
            }
        } else {
            i4 = 0;
            View findViewById9 = m7340b2.findViewById(R.id.textSpacerNoTitle);
            if (findViewById9 != null) {
                findViewById9.setVisibility(0);
            }
        }
        AlertController$RecycleListView alertController$RecycleListView = c1788s7.f26286g;
        if (alertController$RecycleListView instanceof AlertController$RecycleListView) {
            alertController$RecycleListView.setHasDecor(z3, z4);
        }
        if (!z2) {
            View view3 = c1788s7.f26286g;
            if (view3 == null) {
                view3 = c1788s7.f26263A;
            }
            if (view3 != null) {
                if (z4) {
                    i5 = 2;
                } else {
                    i5 = i4;
                }
                View findViewById10 = window.findViewById(R.id.scrollIndicatorUp);
                View findViewById11 = window.findViewById(R.id.scrollIndicatorDown);
                ViewCompat.setScrollIndicators(view3, z3 | i5, 3);
                if (findViewById10 != null) {
                    m7340b2.removeView(findViewById10);
                }
                if (findViewById11 != null) {
                    m7340b2.removeView(findViewById11);
                }
            }
        }
        AlertController$RecycleListView alertController$RecycleListView2 = c1788s7.f26286g;
        if (alertController$RecycleListView2 != null && (listAdapter = c1788s7.f26270H) != null) {
            alertController$RecycleListView2.setAdapter(listAdapter);
            int i12 = c1788s7.f26271I;
            if (i12 > -1) {
                alertController$RecycleListView2.setItemChecked(i12, true);
                alertController$RecycleListView2.setSelection(i12);
            }
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f589f.f26263A;
        if (nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f589f.f26263A;
        if (nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void setButton(int i, CharSequence charSequence, Message message) {
        this.f589f.m7341c(i, charSequence, null, message, null);
    }

    public void setCustomTitle(View view) {
        this.f589f.f26269G = view;
    }

    public void setIcon(int i) {
        this.f589f.m7342d(i);
    }

    public void setIconAttribute(int i) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i, typedValue, true);
        this.f589f.m7342d(typedValue.resourceId);
    }

    public void setMessage(CharSequence charSequence) {
        C1788s7 c1788s7 = this.f589f;
        c1788s7.f26285f = charSequence;
        TextView textView = c1788s7.f26268F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        C1788s7 c1788s7 = this.f589f;
        c1788s7.f26284e = charSequence;
        TextView textView = c1788s7.f26267E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setView(View view) {
        C1788s7 c1788s7 = this.f589f;
        c1788s7.f26287h = view;
        c1788s7.f26288i = 0;
        c1788s7.f26293n = false;
    }

    public AlertDialog(@NonNull Context context, @StyleRes int i) {
        super(context, m157e(i, context));
        this.f589f = new C1788s7(getContext(), this, getWindow());
    }

    public void setButton(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f589f.m7341c(i, charSequence, onClickListener, null, null);
    }

    public void setIcon(Drawable drawable) {
        C1788s7 c1788s7 = this.f589f;
        c1788s7.f26265C = drawable;
        c1788s7.f26264B = 0;
        ImageView imageView = c1788s7.f26266D;
        if (imageView != null) {
            if (drawable != null) {
                imageView.setVisibility(0);
                c1788s7.f26266D.setImageDrawable(drawable);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public void setButton(int i, CharSequence charSequence, Drawable drawable, DialogInterface.OnClickListener onClickListener) {
        this.f589f.m7341c(i, charSequence, onClickListener, null, drawable);
    }

    public AlertDialog(@NonNull Context context, boolean z, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        this(context, 0);
        setCancelable(z);
        setOnCancelListener(onCancelListener);
    }

    public void setView(View view, int i, int i2, int i3, int i4) {
        C1788s7 c1788s7 = this.f589f;
        c1788s7.f26287h = view;
        c1788s7.f26288i = 0;
        c1788s7.f26293n = true;
        c1788s7.f26289j = i;
        c1788s7.f26290k = i2;
        c1788s7.f26291l = i3;
        c1788s7.f26292m = i4;
    }
}
