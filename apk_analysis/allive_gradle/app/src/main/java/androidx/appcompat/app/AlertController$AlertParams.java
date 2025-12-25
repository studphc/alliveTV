package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import p000.C1538m7;
import p000.C1575n7;
import p000.C1612o7;
import p000.C1677p7;
import p000.C1788s7;

/* loaded from: classes.dex */
public class AlertController$AlertParams {
    public ListAdapter mAdapter;
    public boolean[] mCheckedItems;
    public final Context mContext;
    public Cursor mCursor;
    public View mCustomTitleView;
    public boolean mForceInverseBackground;
    public Drawable mIcon;
    public final LayoutInflater mInflater;
    public String mIsCheckedColumn;
    public boolean mIsMultiChoice;
    public boolean mIsSingleChoice;
    public CharSequence[] mItems;
    public String mLabelColumn;
    public CharSequence mMessage;
    public Drawable mNegativeButtonIcon;
    public DialogInterface.OnClickListener mNegativeButtonListener;
    public CharSequence mNegativeButtonText;
    public Drawable mNeutralButtonIcon;
    public DialogInterface.OnClickListener mNeutralButtonListener;
    public CharSequence mNeutralButtonText;
    public DialogInterface.OnCancelListener mOnCancelListener;
    public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
    public DialogInterface.OnClickListener mOnClickListener;
    public DialogInterface.OnDismissListener mOnDismissListener;
    public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
    public DialogInterface.OnKeyListener mOnKeyListener;
    public OnPrepareListViewListener mOnPrepareListViewListener;
    public Drawable mPositiveButtonIcon;
    public DialogInterface.OnClickListener mPositiveButtonListener;
    public CharSequence mPositiveButtonText;
    public CharSequence mTitle;
    public View mView;
    public int mViewLayoutResId;
    public int mViewSpacingBottom;
    public int mViewSpacingLeft;
    public int mViewSpacingRight;
    public int mViewSpacingTop;
    public int mIconId = 0;
    public int mIconAttrId = 0;
    public boolean mViewSpacingSpecified = false;
    public int mCheckedItem = -1;
    public boolean mRecycleOnMeasure = true;
    public boolean mCancelable = true;

    /* loaded from: classes.dex */
    public interface OnPrepareListViewListener {
        void onPrepareListView(ListView listView);
    }

    public AlertController$AlertParams(Context context) {
        this.mContext = context;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public void apply(C1788s7 c1788s7) {
        int i;
        ListAdapter listAdapter;
        View view = this.mCustomTitleView;
        if (view != null) {
            c1788s7.f26269G = view;
        } else {
            CharSequence charSequence = this.mTitle;
            if (charSequence != null) {
                c1788s7.f26284e = charSequence;
                TextView textView = c1788s7.f26267E;
                if (textView != null) {
                    textView.setText(charSequence);
                }
            }
            Drawable drawable = this.mIcon;
            if (drawable != null) {
                c1788s7.f26265C = drawable;
                c1788s7.f26264B = 0;
                ImageView imageView = c1788s7.f26266D;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    c1788s7.f26266D.setImageDrawable(drawable);
                }
            }
            int i2 = this.mIconId;
            if (i2 != 0) {
                c1788s7.m7342d(i2);
            }
            int i3 = this.mIconAttrId;
            if (i3 != 0) {
                c1788s7.getClass();
                TypedValue typedValue = new TypedValue();
                c1788s7.f26280a.getTheme().resolveAttribute(i3, typedValue, true);
                c1788s7.m7342d(typedValue.resourceId);
            }
        }
        CharSequence charSequence2 = this.mMessage;
        if (charSequence2 != null) {
            c1788s7.f26285f = charSequence2;
            TextView textView2 = c1788s7.f26268F;
            if (textView2 != null) {
                textView2.setText(charSequence2);
            }
        }
        CharSequence charSequence3 = this.mPositiveButtonText;
        if (charSequence3 != null || this.mPositiveButtonIcon != null) {
            c1788s7.m7341c(-1, charSequence3, this.mPositiveButtonListener, null, this.mPositiveButtonIcon);
        }
        CharSequence charSequence4 = this.mNegativeButtonText;
        if (charSequence4 != null || this.mNegativeButtonIcon != null) {
            c1788s7.m7341c(-2, charSequence4, this.mNegativeButtonListener, null, this.mNegativeButtonIcon);
        }
        CharSequence charSequence5 = this.mNeutralButtonText;
        if (charSequence5 != null || this.mNeutralButtonIcon != null) {
            c1788s7.m7341c(-3, charSequence5, this.mNeutralButtonListener, null, this.mNeutralButtonIcon);
        }
        if (this.mItems != null || this.mCursor != null || this.mAdapter != null) {
            AlertController$RecycleListView alertController$RecycleListView = (AlertController$RecycleListView) this.mInflater.inflate(c1788s7.f26273K, (ViewGroup) null);
            if (this.mIsMultiChoice) {
                if (this.mCursor == null) {
                    listAdapter = new C1538m7(this, this.mContext, c1788s7.f26274L, this.mItems, alertController$RecycleListView);
                } else {
                    listAdapter = new C1575n7(this, this.mContext, this.mCursor, alertController$RecycleListView, c1788s7);
                }
            } else {
                if (this.mIsSingleChoice) {
                    i = c1788s7.f26275M;
                } else {
                    i = c1788s7.f26276N;
                }
                int i4 = i;
                if (this.mCursor != null) {
                    listAdapter = new SimpleCursorAdapter(this.mContext, i4, this.mCursor, new String[]{this.mLabelColumn}, new int[]{R.id.text1});
                } else {
                    listAdapter = this.mAdapter;
                    if (listAdapter == null) {
                        listAdapter = new ArrayAdapter(this.mContext, i4, R.id.text1, this.mItems);
                    }
                }
            }
            OnPrepareListViewListener onPrepareListViewListener = this.mOnPrepareListViewListener;
            if (onPrepareListViewListener != null) {
                onPrepareListViewListener.onPrepareListView(alertController$RecycleListView);
            }
            c1788s7.f26270H = listAdapter;
            c1788s7.f26271I = this.mCheckedItem;
            if (this.mOnClickListener != null) {
                alertController$RecycleListView.setOnItemClickListener(new C1612o7(this, c1788s7));
            } else if (this.mOnCheckboxClickListener != null) {
                alertController$RecycleListView.setOnItemClickListener(new C1677p7(this, alertController$RecycleListView, c1788s7));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.mOnItemSelectedListener;
            if (onItemSelectedListener != null) {
                alertController$RecycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.mIsSingleChoice) {
                alertController$RecycleListView.setChoiceMode(1);
            } else if (this.mIsMultiChoice) {
                alertController$RecycleListView.setChoiceMode(2);
            }
            c1788s7.f26286g = alertController$RecycleListView;
        }
        View view2 = this.mView;
        if (view2 != null) {
            if (this.mViewSpacingSpecified) {
                int i5 = this.mViewSpacingLeft;
                int i6 = this.mViewSpacingTop;
                int i7 = this.mViewSpacingRight;
                int i8 = this.mViewSpacingBottom;
                c1788s7.f26287h = view2;
                c1788s7.f26288i = 0;
                c1788s7.f26293n = true;
                c1788s7.f26289j = i5;
                c1788s7.f26290k = i6;
                c1788s7.f26291l = i7;
                c1788s7.f26292m = i8;
                return;
            }
            c1788s7.f26287h = view2;
            c1788s7.f26288i = 0;
            c1788s7.f26293n = false;
            return;
        }
        int i9 = this.mViewLayoutResId;
        if (i9 != 0) {
            c1788s7.f26287h = null;
            c1788s7.f26288i = i9;
            c1788s7.f26293n = false;
        }
    }
}
